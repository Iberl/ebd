package ebd.trainStatusManager.util.supervisors;


import ebd.globalUtils.events.trainStatusMananger.ChangeInfrastructureDirectionEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.trainStatusMananger.SwitchInfrastructureDirectionEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DirectionSupervisor {

    private final EventBus localEventBus;
    private final TrainDataVolatile trainDataVolatile;

    private boolean shouldSwitch = true;

    public DirectionSupervisor(EventBus localEventBus){
        this.localEventBus = localEventBus;
        NewTrainDataVolatileEvent ntdve = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class);
        this.trainDataVolatile = ntdve.trainDataVolatile;
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cte){
        if(shouldSwitch && this.trainDataVolatile.getCurrentSpeed() == 0) {
            this.localEventBus.post(new ChangeInfrastructureDirectionEvent("tsm", "tsm", trainDataVolatile.getInfrastructureID()));
            shouldSwitch = false;
        }
    }

    @Subscribe
    public void changeInfrastructureDirection(SwitchInfrastructureDirectionEvent nide){
        this.shouldSwitch = true;
    }
}
