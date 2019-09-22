package ebd.speedSupervisionModule;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.position.Position;
import ebd.speedSupervisionModule.util.events.SsmReportEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Arrays;

public class SpeedSupervisionModule {

    private EventBus eventBus;

    private BreakingCurve breakingCurve = null;
    

    public SpeedSupervisionModule(EventBus eventBus){
        this.eventBus = eventBus;
        eventBus.register(this);
    }

    @Subscribe
    public void clockTick(ClockTickEvent cte){

        if (this.breakingCurve == null){
            return;
        }

        TrainDataVolatile trainDataVolatile = this.eventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        double curSpeed;
        Position curPosition;

        if(trainDataVolatile.getCurrentSpeed() != null){
            curSpeed = trainDataVolatile.getCurrentSpeed();
        }
        else return;

        if(trainDataVolatile.getCurrentPosition() != null){
            curPosition = trainDataVolatile.getCurrentPosition();
        }
        else return;

        double maxSpeed = this.breakingCurve.getMaxSpeedAtRelativePosition(curPosition);

        boolean toFast = curSpeed > maxSpeed;

        this.eventBus.postSticky(new SsmReportEvent("ssm", Arrays.asList("tsm"), toFast));

    }

    @Subscribe
    public void setBreakingCurve(NewBreakingCurveEvent nbce){
        this.breakingCurve = nbce.breakingCurve;
    }

}
