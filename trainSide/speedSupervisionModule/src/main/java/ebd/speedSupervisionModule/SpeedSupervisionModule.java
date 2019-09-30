package ebd.speedSupervisionModule;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.speedSupervisionModule.util.events.SsmReportEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Arrays;
import java.util.Collections;

public class SpeedSupervisionModule {

    private EventBus eventBus;

    private BreakingCurve breakingCurve = null;

    //TODO Correct maxDistance!
    private Double maxDistance = 0d;


    public SpeedSupervisionModule(EventBus eventBus){
        this.eventBus = eventBus;
        eventBus.register(this);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
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

        if (curPosition.getLocation().getId().equals((new InitalLocation()).getId())) return;

        double tripDistance = trainDataVolatile.getCurTripDistance();
        double tripDistanceWarning = tripDistance + curSpeed * 5;
        double tripDistanceIndication = tripDistance + curSpeed * 10;
        SpeedInterventionLevel speedInterventionLevel;

        //TODO Make this less horrible!
        if(tripDistance < this.maxDistance){
            double maxSpeed = this.breakingCurve.getMaxSpeedAtRelativePosition(curPosition);

            if(curSpeed > maxSpeed + 27){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            else if (curSpeed > maxSpeed + 19.8){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            else if(curSpeed > maxSpeed + 14.4){
                speedInterventionLevel = SpeedInterventionLevel.WARNING;
            }
            else {
                if(tripDistanceWarning < this.maxDistance){
                    double maxSpeedWarning = this.breakingCurve.getMaxSpeedAtRelativePositionAndOffset(curPosition,curSpeed * 5);
                    if(curSpeed > maxSpeedWarning){
                        speedInterventionLevel = SpeedInterventionLevel.WARNING;
                    }
                    else {
                        if(tripDistanceIndication < this.maxDistance){
                            double maxSpeedIndication = this.breakingCurve.getMaxSpeedAtRelativePositionAndOffset(curPosition, curSpeed * 10);
                            if(curSpeed > maxSpeedIndication){
                                speedInterventionLevel = SpeedInterventionLevel.INDICATION;
                            }
                            else {
                                speedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
                            }
                        }
                        else {
                            speedInterventionLevel = SpeedInterventionLevel.INDICATION;
                        }
                    }
                }
                else {
                    speedInterventionLevel = SpeedInterventionLevel.WARNING;
                }
            }
        }
        else {
            speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        }

        this.eventBus.postSticky(new SsmReportEvent("ssm", Collections.singletonList("tsm"), speedInterventionLevel));

    }

    @Subscribe
    public void setBreakingCurve(NewBreakingCurveEvent nbce){

        this.breakingCurve = nbce.breakingCurve;
        this.maxDistance = this.breakingCurve.getHighestXValue();
    }

}
