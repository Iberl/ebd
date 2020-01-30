package ebd.speedSupervisionModule;

import ebd.breakingCurveCalculator.BreakingCurveGroup;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
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
import java.util.HashMap;
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


    private TrainDataVolatile trainDataVolatile;
    private EventBus localEventBus;
    private List<String> tdTargets = Collections.singletonList("td");
    private List<String> allTargets = Collections.singletonList("all");

    private BreakingCurveGroup breakingCurveGroup = null;

    //TODO Correct maxDistance!
    private Double maxServiceDistance = 0d;
    private Double maxEmergencyDistance = 0d;

    /**
     * Constructor
     * @param localEventBus The local {@link EventBus} of the train
     */
    public SpeedSupervisionModule(EventBus localEventBus){
        this.localEventBus = localEventBus;
        localEventBus.register(this);
        this.trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
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

        if (this.breakingCurveGroup == null){
            return;
        }
        double curSpeed;
        Position curPosition;

        curSpeed = trainDataVolatile.getCurrentSpeed();

        if(trainDataVolatile.getCurrentPosition() != null){
            curPosition = trainDataVolatile.getCurrentPosition();
        }
        else return;

        if (curPosition.getLocation().getId() == (new InitalLocation()).getId()) return;

        //System.out.println(this.breakingCurve.getRefLocation().getId());

        double tripDistance = curPosition.totalDistanceToPastLocation(this.breakingCurveGroup.getServiceDecelerationCurve().getRefLocation().getId());
        SpeedInterventionLevel speedInterventionLevel;

        if(tripDistance < this.maxServiceDistance){
            //System.out.println("V_MAX: " + maxSpeed + " TripD: " + tripDistance);
            if(curSpeed > this.breakingCurveGroup.getEmergencyInterventionCurve().getPointOnCurve(tripDistance)){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            else if (curSpeed > this.breakingCurveGroup.getServiceInterventionCurve().getPointOnCurve(tripDistance)){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            else if (curSpeed > this.breakingCurveGroup.getServiceWarningCurve().getPointOnCurve(tripDistance)){
                speedInterventionLevel = SpeedInterventionLevel.WARNING;
            }
            else if (curSpeed > this.breakingCurveGroup.getServicePermittedSpeedCurve().getPointOnCurve(tripDistance)){
                speedInterventionLevel = SpeedInterventionLevel.PERMITTED_SPEED;
            }
            else if (curSpeed > this.breakingCurveGroup.getServiceIndicationCurve().getPointOnCurve(tripDistance)){
                speedInterventionLevel = SpeedInterventionLevel.INDICATION;
            }
            else speedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;

        }
        else {
            if (tripDistance < maxEmergencyDistance && curSpeed < this.breakingCurveGroup.getEmergencyInterventionCurve().getPointOnCurve(tripDistance)){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            else {
                speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
        }

        this.localEventBus.postSticky(new SsmReportEvent("ssm", this.allTargets , speedInterventionLevel));
        sendCurrentMaxSpeed(tripDistance);
    }
    /**
     * This method updates the breaking curve.
     * @param nbce A {@link NewBreakingCurveEvent}
     */
    @Subscribe
    public void setBreakingCurveGroup(NewBreakingCurveEvent nbce){

        this.breakingCurveGroup = nbce.breakingCurveGroup;
        this.maxServiceDistance = this.breakingCurveGroup.getServiceDecelerationCurve().getHighestXValue();
        this.maxEmergencyDistance = this.breakingCurveGroup.getEmergencyDecelerationCurve().getHighestXValue();
    }

    private void sendCurrentMaxSpeed(double curTripDistance) {
        double maxEmergencySpeed = 0;
        double maxEmergencyInterventionSpeed = 0;
        double maxServiceSpeed = 0;
        double maxServiceInterventionSpeed = 0;
        double maxServiceWarningSpeed = 0;
        double maxServicePermittedSpeed = 0;
        double maxServiceIndicationSpeed = 0;

        if(curTripDistance < this.maxServiceDistance){
            maxEmergencySpeed = this.breakingCurveGroup.getEmergencyDecelerationCurve().getPointOnCurve(curTripDistance);
            maxEmergencyInterventionSpeed = this.breakingCurveGroup.getEmergencyInterventionCurve().getPointOnCurve(curTripDistance);

            maxServiceSpeed = this.breakingCurveGroup.getServiceDecelerationCurve().getPointOnCurve(curTripDistance);
            maxServiceInterventionSpeed = this.breakingCurveGroup.getServiceInterventionCurve().getPointOnCurve(curTripDistance);
            maxServiceWarningSpeed = this.breakingCurveGroup.getServiceWarningCurve().getPointOnCurve(curTripDistance);
            maxServicePermittedSpeed = this.breakingCurveGroup.getServicePermittedSpeedCurve().getPointOnCurve(curTripDistance);
            maxServiceIndicationSpeed = this.breakingCurveGroup.getServiceIndicationCurve().getPointOnCurve(curTripDistance);

        }
        else if (curTripDistance < maxEmergencyDistance){
            maxEmergencySpeed = this.breakingCurveGroup.getEmergencyDecelerationCurve().getPointOnCurve(curTripDistance);
            maxEmergencyInterventionSpeed = this.breakingCurveGroup.getEmergencyInterventionCurve().getPointOnCurve(curTripDistance);
        }
        HashMap<String, Object> updateMap = new HashMap<>();
        updateMap.put("currentMaximumSpeed", maxServiceSpeed);
        updateMap.put("currentEmergencySpeed", maxEmergencySpeed);
        updateMap.put("currentEmergencyInterventionSpeed", maxEmergencyInterventionSpeed);
        updateMap.put("currentServiceInterventionSpeed", maxServiceInterventionSpeed);
        updateMap.put("currentServiceWarningSpeed", maxServiceWarningSpeed);
        updateMap.put("currentServicePermittedSpeed", maxServicePermittedSpeed);
        updateMap.put("currentServiceIndicationSpeed", maxServiceIndicationSpeed);

        this.localEventBus.post(new TrainDataMultiChangeEvent("ssm", this.tdTargets, updateMap));
    }

}
