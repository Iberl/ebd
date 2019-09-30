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
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.movementState.MovementState;
import ebd.globalUtils.position.Position;
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

    private EventBus eventBus;
    private TrainDataVolatile trainDataVolatile;
    private String etcsTrainID;

    private Spline tripProfile;
    private Position tripStartPosition;

    private DynamicState dynamicState;
    private DrivingProfile drivingProfile;

    private double time;
    private boolean locked = true;

    private List<String> tdTargets = new ArrayList<String>(Arrays.asList(new String[]{"td"}));
    private List<String> exceptionTargets = new ArrayList<String>(Arrays.asList(new String[]{"tsm"}));
    private double maxTripDistance;

    private int cycleCount = 0;
    //TODO Connect to Config
    private int cylceCountMax = 20;


    public DrivingDynamics(EventBus eventBus, String pathToDrivingProfile){
        this.eventBus = eventBus;
        this.eventBus.register(this);

        try {
            this.drivingProfile = new DrivingProfile(pathToDrivingProfile, this.eventBus);
        } catch (IOException | ParseException e) {
            eventBus.post(new DrivingDynamicsExceptionEvent("td", this.exceptionTargets, new NotCausedByAEvent(), e, ExceptionEventTyp.FATAL));
        } catch (DDBadDataException e) {
            eventBus.post(new DrivingDynamicsExceptionEvent("td", this.exceptionTargets, new NotCausedByAEvent(), e));
        }

        this.trainDataVolatile = eventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        this.etcsTrainID = eventBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma.getId();

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
        sendCurrentMaxSpeed();

        /*
        Checks the current SsmReportEvent for the status of the train //TODO Enum, more cases
        Getting next action that should be taken and parsing that action
         */
        SsmReportEvent speedSupervisionReport = this.eventBus.getStickyEvent(SsmReportEvent.class);
        if(speedSupervisionReport == null ){
            actionParser(this.drivingProfile.actionToTake());
        }
        else {
            switch (speedSupervisionReport.interventionLevel){
                case NO_INTERVENTION:
                case INDICATION:
                case WARNING:
                    actionParser(this.drivingProfile.actionToTake());
                    break;
                case APPLY_SERVICE_BREAKS:
                    this.dynamicState.setMovementState(MovementState.BREAKING);
                    this.dynamicState.setBreakingModification(1d);
                case APPLY_EMERGENCY_BREAKS:
                default:
                    this.dynamicState.setMovementState(MovementState.EMERGENCY_BREAKING);
                    this.dynamicState.setBreakingModification(1d);
            }
        }

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
        if(this.cycleCount >= this.cylceCountMax){
            cycleCount = 0;
            sendToLogEvent();
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
        this.dynamicState = new DynamicState(trainDataVolatile.getCurrentPosition(), trainDataVolatile.getAvailableAcceleration());
        this.time = System.nanoTime();
        this.locked = false;
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
            this.maxTripDistance = backwardSpline.getHighestXValue();
        }
        else if(this.tripProfile instanceof ForwardSpline){
            this.maxTripDistance = Double.MAX_VALUE;
        }
        else{
            IllegalArgumentException iAE = new IllegalArgumentException("The trip profile used an unsupported implementation of Spline");
            this.eventBus.post(new DrivingDynamicsExceptionEvent("dd", this.exceptionTargets, utpe, iAE));
        }


        Position curPos = this.trainDataVolatile.getCurrentPosition();
        this.tripStartPosition = new Position(curPos.getIncrement(),curPos.isDirectedForward(),curPos.getLocation(),curPos.getPreviousLocations());
    }


    private void updateDSPosition() {
        NewRouteDataVolatileEvent nrdve = this.eventBus.getStickyEvent(NewRouteDataVolatileEvent.class);
        NewLocationEvent nle = this.eventBus.getStickyEvent(NewLocationEvent.class);

        if(nrdve == null || nle == null) return;

        Location newLoc = nle.newLocation;

        if(dynamicState.getPosition().getLocation().getId().equals(newLoc.getId())) {
            this.eventBus.removeStickyEvent(nle);
            return;
        }

        RouteDataVolatile routeDataVolatile = nrdve.routeDataVolatile;

        if(routeDataVolatile.getLinkingInformation() == null) return;

        Map<String, Location> linkingInfo = routeDataVolatile.getLinkingInformation();

        Position oldPos = dynamicState.getPosition();
        Map<String,Location> prefLocs = oldPos.getPreviousLocations();
        double overshoot;

        if(prefLocs.size() > 0) {
            overshoot = oldPos.getIncrement() - linkingInfo.get(newLoc.getId()).getDistanceToPrevious();
            prefLocs.put(newLoc.getId(),newLoc);}
        else {
            InitalLocation initLoc = new InitalLocation();
            prefLocs.put(initLoc.getId(),initLoc);
            prefLocs.put(newLoc.getId(),new Location(newLoc.getId(), initLoc.getId(), oldPos.getIncrement()));
            overshoot = 0d; //First Location can not be overshoot?
        }

        Position newPos = new Position(overshoot, oldPos.isDirectedForward(), newLoc, prefLocs);

        this.dynamicState.setPosition(newPos);
        this.eventBus.removeStickyEvent(nle);

        String msg = "New location with ID: " + newLoc.getId() + " was reached";
        this.eventBus.post(new ToLogEvent("dd", Collections.singletonList("log"), msg));
    }

    private void updateTrainDataVolatile(){
        HashMap<String,Object> nameToValue = new HashMap<>();
        nameToValue.put("currentSpeed", this.dynamicState.getSpeed());
        nameToValue.put("currentPosition", this.dynamicState.getPosition());
        nameToValue.put("curTripDistance", this.dynamicState.getTripDistance());
        nameToValue.put("curTripTime", this.dynamicState.getTime());
        this.eventBus.post(new TrainDataMultiChangeEvent("dd", this.tdTargets, nameToValue));
    }

    private void sendCurrentMaxSpeed() {
        double tripDistance = dynamicState.getPosition().totalDistanceToPreviousPosition(this.tripStartPosition);
        double curMaxSpeed;

        if(tripDistance < this.maxTripDistance) curMaxSpeed = tripProfile.getPointOnCurve(tripDistance);
        else curMaxSpeed = 0d;

        this.eventBus.post(new TrainDataChangeEvent("dd", this.tdTargets, "currentMaxSpeed", curMaxSpeed));
    }

    private void sendToLogEvent() {
        double a = dynamicState.getAcceleration();
        double v = dynamicState.getSpeed();
        String l = dynamicState.getPosition().getLocation().getId();
        double i = dynamicState.getPosition().getIncrement();
        double td = dynamicState.getTripDistance();
        double tt = dynamicState.getTime();
        String msg = String.format("DD -> Log: Acceleration: %.2f m/s^-2 Speed: %.2f m/s, Position: LRBG %s + %.2f m, ",a,v,l,i);
        String msg2 = String.format("Trip Distance: %.2f m, Trip Time: %.2f s", td, tt);
        this.eventBus.post(new ToLogEvent("dd", Collections.singletonList("log"), msg + msg2));

    }

    private void actionParser(Action action) {
        switch(action.getClass().getSimpleName()){
            case "NoAction":
                break;
            case "AccelerationAction":
                this.dynamicState.setMovementState(MovementState.ACCELERATING);
                this.dynamicState.setAccelerationModification(((AccelerationAction)action).getAccelerationPercentage());
                break;
            case "BreakAction":
                this.dynamicState.setMovementState(MovementState.BREAKING);
                this.dynamicState.setBreakingModification(((BreakAction)action).getBreakPercentage());
                break;
            case "CruiseAction":
                this.dynamicState.setMovementState(MovementState.CRUISE);
                break;
            case "HaltAction":
                this.dynamicState.setMovementState(MovementState.HALTING);
                break;
            default:
                IllegalArgumentException iAE = new IllegalArgumentException("DrivingDynamics could not parse this action: " + action.getClass().getSimpleName());
                eventBus.post(new DrivingDynamicsExceptionEvent("dd", this.exceptionTargets, new NotCausedByAEvent(), iAE, ExceptionEventTyp.FATAL));
        }
    }


}
