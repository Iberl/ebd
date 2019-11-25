package ebd.drivingDynamics;

import ebd.drivingDynamics.util.actions.AccelerationAction;
import ebd.drivingDynamics.util.actions.Action;
import ebd.drivingDynamics.util.actions.BreakAction;
import ebd.drivingDynamics.util.events.DrivingDynamicsExceptionEvent;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.events.drivingDynamics.DDLockEvent;
import ebd.globalUtils.events.drivingDynamics.DDUnlockEvent;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.trainStatusMananger.NewLocationEvent;
import ebd.globalUtils.events.trainStatusMananger.PositionEvent;
import ebd.globalUtils.events.trainStatusMananger.TsmTripEndEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.movementState.MovementState;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Spline;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.speedSupervisionModule.util.events.SsmReportEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

public class DrivingDynamics {

    private EventBus localBus;
    private TrainDataVolatile trainDataVolatile;
    private int etcsTrainID;

    private Spline tripProfile;
    private Position tripStartPosition;

    private DynamicState dynamicState;
    private DrivingProfile drivingProfile;

    private double time;
    private boolean locked = true;

    private List<String> tdTargets = new ArrayList<String>(Arrays.asList(new String[]{"td"}));
    private List<String> exceptionTargets = new ArrayList<String>(Arrays.asList(new String[]{"tsm"}));
    private double maxTripSectionDistance;

    private double targetSpeed = 0d;

    private int cycleCount = 20;
    private int cylceCountMax = 20; //TODO Connect to Config
    private MovementState prevMovementState = null;
    private SpeedInterventionLevel prevSil = null;


    public DrivingDynamics(EventBus localBus){
        this.localBus = localBus;
        this.localBus.register(this);

        try {
            this.drivingProfile = new DrivingProfile(this.localBus);
        } catch (IOException | ParseException e) {
            localBus.post(new DrivingDynamicsExceptionEvent("td", this.exceptionTargets, new NotCausedByAEvent(), e, ExceptionEventTyp.FATAL));
        } catch (DDBadDataException e) {
            localBus.post(new DrivingDynamicsExceptionEvent("td", this.exceptionTargets, new NotCausedByAEvent(), e));
        }

        this.trainDataVolatile = localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        this.etcsTrainID = localBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma.getId();

    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cte){
        /*
        Setting time to calculate the precise time between calculations
         */
        double currentTime = System.nanoTime();
        double deltaT = (currentTime - this.time) / 1E9; //To get seconds
        this.time = currentTime;

        /*
        If driving dynamics is locked, nothing will be done.
         */
        if(locked){
            return;
        }

        /*
        Update TrainDataVolatile to set the current maximum allowed speed of the train
        based on the tripProfile
         */
        sendCurrentTargetSpeed();

        /*
        Checks the current SsmReportEvent for the status of the train //TODO Enum, more cases
        Getting next action that should be taken and parsing that action
         */
        SsmReportEvent speedSupervisionReport = this.localBus.getStickyEvent(SsmReportEvent.class);
        if(speedSupervisionReport == null ){
            actionParser(this.drivingProfile.actionToTake());
        }
        else {

            switch (speedSupervisionReport.interventionLevel){
                case NO_INTERVENTION:
                case INDICATION:
                    actionParser(this.drivingProfile.actionToTake());
                    break;
                case WARNING:
                    sendToLogEventSpeedSupervision(speedSupervisionReport.interventionLevel, MovementState.UNCHANGED);
                    actionParser(this.drivingProfile.actionToTake());
                    break;
                case APPLY_SERVICE_BREAKS:
                    sendToLogEventSpeedSupervision(speedSupervisionReport.interventionLevel, MovementState.BREAKING);
                    this.dynamicState.setMovementState(MovementState.BREAKING);
                    this.dynamicState.setBreakingModification(1d);
                    break;
                case APPLY_EMERGENCY_BREAKS:
                default:
                    sendToLogEventSpeedSupervision(speedSupervisionReport.interventionLevel, MovementState.EMERGENCY_BREAKING);
                    this.dynamicState.setMovementState(MovementState.EMERGENCY_BREAKING);
                    this.dynamicState.setBreakingModification(1d);
            }
        }

        /*
         * Log movement state changes
         */
        /*if(this.prevMovementState == null || !this.prevMovementState.equals(this.dynamicState.getMovementState())){
            sendToLogEventSpeedSupervisionMovementState(this.dynamicState.getMovementState());
            this.prevMovementState = this.dynamicState.getMovementState();
        }*/

        /*
        Calculate the next dynamic state.
         */
        this.dynamicState.nextState(deltaT);

        /*
        Update Positions after a new location
         */
        updateDSPosition();

        /*
        Sends global PositionEvent
         */

        EventBus.getDefault().post(new PositionEvent("dd;T=" + this.etcsTrainID, Collections.singletonList("all"), dynamicState.getPosition()));

        /*
        Update TrainDataVolatile with the newly calculated values
         */
        updateTrainDataVolatile();

        cycleCount++;
        if(this.cycleCount >= this.cylceCountMax || this.dynamicState.getSpeed() < 1){
            cycleCount = 0;
            sendToLogEventDynamicState();
        }
    }

    @Subscribe
    public void newTrainData(NewTrainDataVolatileEvent ntdve){
        if(!(ntdve.targets.contains("all") || ntdve.targets.contains("dd"))){
            return;
        }
        this.trainDataVolatile = ntdve.trainDataVolatile;
        if(!this.dynamicState.getPosition().equals(this.trainDataVolatile.getCurrentPosition())){
            this.dynamicState.setPosition(trainDataVolatile.getCurrentPosition());
        }
    }

    @Subscribe
    public void unlock(DDUnlockEvent ue){
        if(!(ue.targets.contains("dd") || ue.targets.contains("all") || !this.locked)){
            return;
        }
        if(this.dynamicState == null){
            this.dynamicState = new DynamicState(trainDataVolatile.getCurrentPosition(), trainDataVolatile.getAvailableAcceleration());
        }
        this.time = System.nanoTime();
        this.locked = false;
        this.localBus.post(new ToLogEvent("tsm", Collections.singletonList("log"),
                "Starting mission"));
    }

    @Subscribe
    public void setLocked(DDLockEvent le){
        if(!(le.targets.contains("dd") || le.targets.contains("all")) || this.locked){
            return;
        }
        this.locked = true;
    }

    @Subscribe
    public void updateTripProfile(DDUpdateTripProfileEvent utpe){
        if(!(utpe.targets.contains("dd") || utpe.targets.contains("all"))){
            return;
        }
        this.tripProfile = utpe.tripProfile;

        if(this.tripProfile instanceof BackwardSpline){
            BackwardSpline backwardSpline = (BackwardSpline)this.tripProfile;
            this.maxTripSectionDistance = backwardSpline.getHighestXValue();
        }
        else if(this.tripProfile instanceof ForwardSpline){
            this.maxTripSectionDistance = Double.MAX_VALUE;
        }
        else{
            IllegalArgumentException iAE = new IllegalArgumentException("The trip profile used an unsupported implementation of Spline");
            this.localBus.post(new DrivingDynamicsExceptionEvent("dd", this.exceptionTargets, utpe, iAE));
        }


        Position curPos = this.trainDataVolatile.getCurrentPosition();
        this.tripStartPosition = new Position(curPos.getIncrement(),curPos.isDirectedForward(),curPos.getLocation(),curPos.getPreviousLocations());
        if(this.dynamicState != null){
            this.dynamicState.setDistanceToStartOfProfile(curPos.totalDistanceToPastLocation(utpe.refLocID));
        }
    }

    @Subscribe
    public void atTripEnd(TsmTripEndEvent ttee){
        dynamicState.setMovementState(MovementState.HALTING);
        dynamicState.setAcceleration(0d);
        sendToLogEventSpeedSupervisionMovementState(MovementState.HALTING);
    }


    private void updateDSPosition() {
        NewRouteDataVolatileEvent nrdve = this.localBus.getStickyEvent(NewRouteDataVolatileEvent.class);
        NewLocationEvent nle = this.localBus.getStickyEvent(NewLocationEvent.class);

        if(nrdve == null || nle == null) return;

        Location newLoc = nle.newLocation;

        if(dynamicState.getPosition().getLocation().getId() == newLoc.getId()) {
            this.localBus.removeStickyEvent(nle);
            return;
        }

        RouteDataVolatile routeDataVolatile = nrdve.routeDataVolatile;

        if(routeDataVolatile.getLinkingInformation() == null) return;

        Map<Integer, Location> linkingInfo = routeDataVolatile.getLinkingInformation();

        Position oldPos = dynamicState.getPosition();
        Map<Integer,Location> prefLocs = oldPos.getPreviousLocations();
        double overshoot;

        if(prefLocs.size() > 0) {
            overshoot = oldPos.getIncrement() - linkingInfo.get(newLoc.getId()).getDistanceToPrevious();
            prefLocs.put(newLoc.getId(),newLoc);}
        else {
            InitalLocation initLoc = new InitalLocation();
            prefLocs.put(initLoc.getId(),initLoc);
            prefLocs.put(newLoc.getId(),new Location(newLoc.getId(), initLoc.getId(), oldPos.getIncrement()));
            overshoot = oldPos.getIncrement(); //Assumption: We always start at a location!
        }

        Position newPos = new Position(overshoot, oldPos.isDirectedForward(), newLoc, prefLocs);

        this.dynamicState.setPosition(newPos);
        this.localBus.removeStickyEvent(nle);

        String msg = "New location with ID " + newLoc.getId() + " was reached";
        this.localBus.post(new ToLogEvent("dd", Collections.singletonList("log"), msg));
    }

    private void updateTrainDataVolatile(){
        HashMap<String,Object> nameToValue = new HashMap<>();
        nameToValue.put("currentSpeed", this.dynamicState.getSpeed());
        nameToValue.put("currentPosition", this.dynamicState.getPosition());
        nameToValue.put("curTripDistance", this.dynamicState.getTripDistance());
        nameToValue.put("curTripSectionDistance", this.dynamicState.getDistanceToStartOfProfile());
        nameToValue.put("curTripTime", this.dynamicState.getTime());
        this.localBus.post(new TrainDataMultiChangeEvent("dd", this.tdTargets, nameToValue));
    }

    private void sendCurrentTargetSpeed() {
        double tripSectionDistance = this.dynamicState.getDistanceToStartOfProfile();

        if(tripSectionDistance < this.maxTripSectionDistance) this.targetSpeed = tripProfile.getPointOnCurve(tripSectionDistance);
        else this.targetSpeed = 0d;

        this.localBus.post(new TrainDataChangeEvent("dd", this.tdTargets, "currentTargetSpeed", this.targetSpeed));
    }

    private void sendToLogEventDynamicState() {
        double a = dynamicState.getAcceleration();
        double v = dynamicState.getSpeed();
        double vm = this.targetSpeed;
        int l = dynamicState.getPosition().getLocation().getId();
        double i = dynamicState.getPosition().getIncrement();
        double td = dynamicState.getTripDistance();
        double tt = dynamicState.getTime();
        String msg = String.format("Acc: %5.2f m/s^2 V: %5.2f m/s, V_max: %5.2f m/s, ",a,v,vm);
        String msg2 = String.format("Pos: LRBG %3d + %7.2f m, TripDist: %8.2f m, TripTime: %6.1f s",l,i,td,tt);
        this.localBus.post(new ToLogEvent("dd", Collections.singletonList("log"), msg + msg2));

    }

    private void sendToLogEventSpeedSupervision(SpeedInterventionLevel sil, MovementState movementState) {
        if(this.prevSil == sil) return;
        this.prevSil = sil;
        String msg = String.format("Current speed supervision intervention level: %s ", sil);
        this.localBus.post(new ToLogEvent("ssm", Collections.singletonList("log"), msg));
        if(movementState != MovementState.UNCHANGED) sendToLogEventSpeedSupervisionMovementState(movementState);

    }

    private void sendToLogEventSpeedSupervisionMovementState(MovementState ms) {
        String msg = String.format("Set movement state to: %s ", ms);
        this.localBus.post(new ToLogEvent("dd", Collections.singletonList("log"), msg));

    }

    private void sendMovementState(MovementState ms){
        if(this.prevMovementState == null || !this.prevMovementState.equals(this.dynamicState.getMovementState())){
            sendToLogEventSpeedSupervisionMovementState(this.dynamicState.getMovementState());
            this.prevMovementState = this.dynamicState.getMovementState();
        }
    }

    private void actionParser(Action action) {
        switch(action.getClass().getSimpleName()){
            case "NoAction":
                break;
            case "AccelerationAction":
                this.dynamicState.setMovementState(MovementState.ACCELERATING);
                this.dynamicState.setAccelerationModification(((AccelerationAction)action).getAccelerationPercentage());
                sendMovementState(MovementState.ACCELERATING);
                break;
            case "BreakAction":
                this.dynamicState.setMovementState(MovementState.BREAKING);
                this.dynamicState.setBreakingModification(((BreakAction)action).getBreakPercentage());
                sendMovementState(MovementState.BREAKING);
                break;
            case "CruiseAction":
                this.dynamicState.setMovementState(MovementState.CRUISE);
                sendMovementState(MovementState.CRUISE);
                break;
            case "HaltAction":
                this.dynamicState.setMovementState(MovementState.HALTING);
                sendMovementState(MovementState.HALTING);
                break;
            default:
                IllegalArgumentException iAE = new IllegalArgumentException("DrivingDynamics could not parse this action: " + action.getClass().getSimpleName());
                localBus.post(new DrivingDynamicsExceptionEvent("dd", this.exceptionTargets, new NotCausedByAEvent(), iAE, ExceptionEventTyp.FATAL));
        }
    }


}
