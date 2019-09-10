package ebd.drivingDynamics;

import ebd.drivingDynamics.util.actions.AccelerationAction;
import ebd.drivingDynamics.util.actions.Action;
import ebd.drivingDynamics.util.actions.BreakAction;
import ebd.drivingDynamics.util.events.DrivingDynamicsExceptionEvent;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.events.drivingDynamics.DDLockEvent;
import ebd.globalUtils.events.drivingDynamics.DDUnlockEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.movementState.MovementState;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrivingDynamics {

    private EventBus eventBus;
    private DrivingProfile drivingProfile;
    private TrainDataVolatile trainDataVolatile;

    //TODO Add event to update tripStartPosition
    //TODO Add event to update tripProfile
    private ForwardSpline tripProfile;
    private Position tripStartPosition;

    private DynamicState dynamicState;
    private double time;

    private boolean locked = true;

    private List<String> tdTargets = new ArrayList<String>(Arrays.asList(new String[]{"td"}));
    private List<String> exceptionTargets = new ArrayList<String>(Arrays.asList(new String[]{"tsm"}));


    public DrivingDynamics(EventBus eventBus, String pathToProfile, ForwardSpline tripProfile){
        this.eventBus = eventBus;
        this.eventBus.register(this);

        try {
            this.drivingProfile = new DrivingProfile(pathToProfile, this.eventBus);
        } catch (IOException | ParseException e) {
            eventBus.post(new DrivingDynamicsExceptionEvent("td", this.exceptionTargets, new NotCausedByAEvent(), e, ExceptionEventTyp.FATAL));
        } catch (DDBadDataException e) {
            eventBus.post(new DrivingDynamicsExceptionEvent("td", this.exceptionTargets, new NotCausedByAEvent(), e));
        }

        this.trainDataVolatile = eventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;

        this.tripProfile = tripProfile;
        this.tripStartPosition = this.trainDataVolatile.getCurrentPosition();

        this.time = System.nanoTime();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cte){
        /*
        Setting time to calculate the precise time between calculations
         */
        double currentTime = System.nanoTime();
        double deltaT = this.time - currentTime;
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
        Getting next action that should be taken and parsing that action
         */
        actionParser(this.drivingProfile.actionToTake());

        /*
        Calculate the next dynamic state.
         */
        this.dynamicState.nextState(deltaT);

        /*
        Update TrainDataVolatile with the newly calculated values
         */
        sendPosition();
        sendCurrentSpeed();
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
        if(!(ue.targets.contains("dd") || ue.targets.contains("all"))){
            return;
        }
        this.dynamicState = new DynamicState(trainDataVolatile.getCurrentPosition(), trainDataVolatile.getAvailableAcceleration());
        this.locked = false;
    }

    @Subscribe
    public void setLocked(DDLockEvent le){
        if(!(le.targets.contains("dd") || le.targets.contains("all"))){
            return;
        }
        this.locked = true;
    }

    private void sendCurrentSpeed() {
        this.eventBus.post(new TrainDataChangeEvent("dd", this.tdTargets, "currentSpeed", this.dynamicState.getSpeed()));
    }

    private void sendPosition() {
        this.eventBus.post(new TrainDataChangeEvent("dd", this.tdTargets, "currentPosition", this.dynamicState.getPosition()));
    }

    private void sendCurrentMaxSpeed() {
        double tripDistance = dynamicState.getPosition().totalDistanceToPreviousPosition(this.tripStartPosition);
        double curMaxSpeed = tripProfile.getPointOnCurve(tripDistance);
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
