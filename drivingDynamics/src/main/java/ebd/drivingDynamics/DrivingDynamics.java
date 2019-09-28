package ebd.drivingDynamics;

import ebd.drivingDynamics.util.actions.AccelerationAction;
import ebd.drivingDynamics.util.actions.Action;
import ebd.drivingDynamics.util.actions.BreakAction;
import ebd.drivingDynamics.util.events.DrivingDynamicsExceptionEvent;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.events.drivingDynamics.DDLockEvent;
import ebd.globalUtils.events.drivingDynamics.DDUnlockEvent;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.movementState.MovementState;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Spline;
import ebd.speedSupervisionModule.util.events.SsmReportEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DrivingDynamics {

    private EventBus eventBus;
    private TrainDataVolatile trainDataVolatile;

    private Spline tripProfile;
    private Position tripStartPosition;

    private DynamicState dynamicState;
    private DrivingProfile drivingProfile;

    private double time;
    private boolean locked = true;

    private List<String> tdTargets = new ArrayList<String>(Arrays.asList(new String[]{"td"}));
    private List<String> exceptionTargets = new ArrayList<String>(Arrays.asList(new String[]{"tsm"}));
    private double maxTripDistance;


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
        Update TrainDataVolatile with the newly calculated values
         */
        updateTrainDataVolatile();
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
    public void updateTripProfil(DDUpdateTripProfileEvent utpe){
        if(!(utpe.targets.contains("dd") || utpe.targets.contains("all"))){
            return;
        }
        this.tripProfile = utpe.tripProfile;
        try {
            BackwardSpline backwardSpline = (BackwardSpline)this.tripProfile;
            this.maxTripDistance = backwardSpline.getHighestXValue();
        }
        catch (ClassCastException cce){
            try {
                ForwardSpline forwardSpline =(ForwardSpline)this.tripProfile;
                this.maxTripDistance = Double.MAX_VALUE;
            }
            catch (ClassCastException ce){
                IllegalArgumentException iAE = new IllegalArgumentException("The trip profile used an unsupported implementation of Spline");
                this.eventBus.post(new DrivingDynamicsExceptionEvent("dd", this.exceptionTargets, utpe, iAE));
            }
        }


        Position curPos = this.trainDataVolatile.getCurrentPosition();
        this.tripStartPosition = new Position(curPos.getIncrement(),curPos.isDirectedForward(),curPos.getLocation(),curPos.getPreviousLocations());
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
