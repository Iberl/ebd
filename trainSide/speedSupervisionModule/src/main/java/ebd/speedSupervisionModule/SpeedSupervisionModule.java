package ebd.speedSupervisionModule;

import ebd.breakingCurveCalculator.BreakingCurveGroup;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;
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


    private EventBus localEventBus;
    private List<String> tdTargets = Collections.singletonList("td");
    private List<String> allTargets = Collections.singletonList("all");
    private TrainDataVolatile trainDataVolatile;
    private ConfigHandler ch;

    private BreakingCurveGroup breakingCurveGroup = null;

    private Double maxServiceDistance = 0d; //in [m]
    private Double maxEmergencyDistance = 0d; //in [m]

    private double maxEmergencyInterventionSpeed; //in {m/s]
    private double maxServiceInterventionSpeed; //in {m/s]
    private double maxWarningSpeed; //in {m/s]
    private double maxPermittedSpeed; //in {m/s]
    private double maxIndicationSpeed; //in {m/s]
    private double maxCoastingPhaseSpeed; //in {m/s]

    /**
     * Constructor
     * @param localEventBus The local {@link EventBus} of the train
     */
    public SpeedSupervisionModule(EventBus localEventBus){
        this.localEventBus = localEventBus;
        localEventBus.register(this);
        this.trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        this.ch = ConfigHandler.getInstance();
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

        updateMaxSpeeds(tripDistance);

        SpeedInterventionLevel speedInterventionLevel;
        SpeedSupervisionState supervisionState;

        if(this.maxIndicationSpeed >= curSpeed && this.maxIndicationSpeed >= this.maxPermittedSpeed) { //Ceiling supervision regime //TODO make more robust
            supervisionState = SpeedSupervisionState.CEILING_SPEED_SUPERVISION;
            if(curSpeed > this.maxEmergencyInterventionSpeed){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            else if(curSpeed > this.maxServiceInterventionSpeed){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            else if(curSpeed > this.maxWarningSpeed){
                speedInterventionLevel = SpeedInterventionLevel.WARNING;
            }
            else {
                speedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
            }
        }
        else{ //Target supervision regime
            supervisionState = SpeedSupervisionState.TARGET_SPEED_SUPERVISION;
            if(curSpeed > this.maxEmergencyInterventionSpeed){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            else if(curSpeed > this.maxServiceInterventionSpeed){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            else if(curSpeed > this.maxWarningSpeed){
                speedInterventionLevel = SpeedInterventionLevel.WARNING;
            }
            else if(curSpeed > this.maxPermittedSpeed){
                speedInterventionLevel = SpeedInterventionLevel.PERMITTED_SPEED;
            }
            else if(curSpeed > this.maxIndicationSpeed){
                speedInterventionLevel = SpeedInterventionLevel.INDICATION;
            }
            else {
                speedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
            }
        }


        this.localEventBus.postSticky(new SsmReportEvent("ssm", this.allTargets , speedInterventionLevel, supervisionState));
        sendCurrentMaxSpeed();
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


    /**
     * Sets the current max speeds of all breaking curves at the current position
     * @param tripDistance Current trip distance starting at the reference point of the breaking curves
     */
    private void updateMaxSpeeds(double tripDistance) {
        this.maxEmergencyInterventionSpeed = 0;
        this.maxServiceInterventionSpeed = 0;
        this.maxWarningSpeed = 0;
        this.maxPermittedSpeed = 0;
        this.maxIndicationSpeed = 0;
        this.maxCoastingPhaseSpeed = 0;

        if(tripDistance < this.maxServiceDistance){
            this.maxEmergencyInterventionSpeed = this.breakingCurveGroup.getEmergencyInterventionCurve().getPointOnCurve(tripDistance);

            this.maxServiceInterventionSpeed = this.breakingCurveGroup.getServiceInterventionCurve().getPointOnCurve(tripDistance);
            this.maxWarningSpeed = this.breakingCurveGroup.getServiceWarningCurve().getPointOnCurve(tripDistance);
            this.maxPermittedSpeed = this.breakingCurveGroup.getPermittedSpeedCurve().getPointOnCurve(tripDistance);
            this.maxIndicationSpeed = this.breakingCurveGroup.getServiceIndicationCurve().getPointOnCurve(tripDistance);
            this.maxCoastingPhaseSpeed = this.breakingCurveGroup.getServiceCoastingPhaseCurve().getPointOnCurve(tripDistance);

        }
        else if (tripDistance < this.maxEmergencyDistance){
            this.maxEmergencyInterventionSpeed = this.breakingCurveGroup.getEmergencyInterventionCurve().getPointOnCurve(tripDistance);
        }
    }

    /**
     * Send current max speeds of all curves to {@link TrainDataVolatile}
     */
    private void sendCurrentMaxSpeed() {

        HashMap<String, Object> updateMap = new HashMap<>();
        updateMap.put("currentMaximumSpeed", this.maxPermittedSpeed);
        updateMap.put("currentEmergencyInterventionSpeed", this.maxEmergencyInterventionSpeed);
        updateMap.put("currentServiceInterventionSpeed", this.maxServiceInterventionSpeed);
        updateMap.put("currentWarningSpeed", this.maxWarningSpeed);
        updateMap.put("currentIndicationSpeed", this.maxIndicationSpeed);
        updateMap.put("currentCoastingPhaseSpeed", this.maxCoastingPhaseSpeed);

        this.localEventBus.post(new TrainDataMultiChangeEvent("ssm", this.tdTargets, updateMap));
    }

}
