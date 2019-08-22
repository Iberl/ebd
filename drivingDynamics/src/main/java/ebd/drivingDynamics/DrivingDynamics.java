package ebd.drivingDynamics;

import ebd.drivingDynamics.util.events.DrivingDynamicsExceptionEvent;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.movementState.MovementState;
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
    private DynamicState dynamicState;
    private double time;


    private List<String> tdTargets = new ArrayList<String>(Arrays.asList(new String[]{"td"}));
    private List<String> exceptionTargets = new ArrayList<String>(Arrays.asList(new String[]{"tsm"}));

    public DrivingDynamics(EventBus eventBus, String pathToProfile){
        this.eventBus = eventBus;
        try {
            this.drivingProfile = new DrivingProfile(pathToProfile, this.eventBus);
        } catch (IOException | ParseException e) {
            eventBus.post(new DrivingDynamicsExceptionEvent("td", this.exceptionTargets, new NotCausedByAEvent(), e, ExceptionEventTyp.FETAL));
        } catch (DDBadDataException e) {
            eventBus.post(new DrivingDynamicsExceptionEvent("td", this.exceptionTargets, new NotCausedByAEvent(), e));
        }
        this.eventBus.register(this);
        this.trainDataVolatile = eventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        this.dynamicState = new DynamicState(0d, trainDataVolatile.getCurrentPosition(), trainDataVolatile.getCurrentSpeed(),0d, MovementState.HALTING, trainDataVolatile.getAvailableAcceleration());
        this.time = System.nanoTime();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cte){
        double currentTime = System.nanoTime();
        double deltaT = this.time - currentTime;
        this.time = currentTime;
        this.dynamicState.nextState(this.time);
        sendPosition();
        sendCurrentSpeed();

    }

    private void sendCurrentSpeed() {
        eventBus.post(new TrainDataChangeEvent("dd", this.tdTargets, "currentSpeed", this.dynamicState.getSpeed()));
    }

    private void sendPosition() {
        eventBus.post(new TrainDataChangeEvent("dd", this.tdTargets, "currentSpeedPosition", this.dynamicState.getPosition()));
    }


}
