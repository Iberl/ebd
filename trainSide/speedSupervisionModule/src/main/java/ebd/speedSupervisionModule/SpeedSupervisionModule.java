package ebd.speedSupervisionModule;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
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

import java.util.Collections;
import java.util.List;

/**
 * This class supervises the speed of the train and to some extend the distance traveled.
 * It checks if the speed or the distance becomes to great and signals such occurrences.
 * It is the responsibility of the Train Status Manager and the Driving Dynamic Modules to react to these signals
 * correctly.
 *
 * //TODO: Respect SRS 3.13 in total!
 *
 * @author Lars Schulze-Falck
 */
public class SpeedSupervisionModule {



    private EventBus localEventBus;
    private List<String> tdTargets = Collections.singletonList("td");
    private List<String> allTargets = Collections.singletonList("all");

    private BreakingCurve breakingCurve = null;

    //TODO Correct maxDistance!
    private Double maxDistance = 0d;

    /**
     * Constructor
     * @param localEventBus The local {@link EventBus} of the train
     */
    public SpeedSupervisionModule(EventBus localEventBus){
        this.localEventBus = localEventBus;
        localEventBus.register(this);
    }

    /**
     * This method listens to clock tick events and checks if the speed becomes to great.
     * There are multiple {@link SpeedInterventionLevel}, that are reached at different times.<br>
     * Currently, the different points of intervention are aproximated, this will be overhauled in the next
     * revision of this module.
     *
     * @param cte A {@link ClockTickEvent}
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cte){

        if (this.breakingCurve == null){
            return;
        }

        TrainDataVolatile trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
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

        if (curPosition.getLocation().getId() == (new InitalLocation()).getId()) return;

        //System.out.println(this.breakingCurve.getRefLocation().getId());

        double tripDistance = curPosition.totalDistanceToPastLocation(this.breakingCurve.getRefLocation().getId());
        double tripDistanceWarning = tripDistance + curSpeed * 5;
        double tripDistanceIndication = tripDistance + curSpeed * 10;
        SpeedInterventionLevel speedInterventionLevel;

        double maxSpeed = this.breakingCurve.getMaxSpeedAtRelativePosition(curPosition);
        sendCurrentMaxSpeed(maxSpeed);
        //TODO Make this less horrible!
        if(tripDistance < this.maxDistance){

            //System.out.println("V_MAX: " + maxSpeed + " TripD: " + tripDistance);
            if(curSpeed > maxSpeed + 2){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            else if (curSpeed > maxSpeed){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            else {
                if(tripDistanceWarning < this.maxDistance){
                    double maxSpeedWarning = this.breakingCurve.getMaxSpeedAtRelativePositionAndOffset(curPosition,curSpeed * 5);
                    if(curSpeed > maxSpeedWarning + 2){
                        speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
                    }
                    else if (curSpeed > maxSpeedWarning + 1.5){
                        speedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
                    }
                    else if(curSpeed > maxSpeedWarning + 1.1){
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

        this.localEventBus.postSticky(new SsmReportEvent("ssm", this.allTargets , speedInterventionLevel));

    }
    /**
     * This method updates the breaking curve.
     * @param nbce A {@link NewBreakingCurveEvent}
     */
    @Subscribe
    public void setBreakingCurve(NewBreakingCurveEvent nbce){

        this.breakingCurve = nbce.breakingCurve;
        this.maxDistance = this.breakingCurve.getHighestXValue();
    }

    private void sendCurrentMaxSpeed(double curMaxSpeed) {
        this.localEventBus.post(new TrainDataChangeEvent("ssm", this.tdTargets, "currentMaximumSpeed", curMaxSpeed));
    }

}
