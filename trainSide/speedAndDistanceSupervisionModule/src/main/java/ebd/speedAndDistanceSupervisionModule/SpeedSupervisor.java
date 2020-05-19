package ebd.speedAndDistanceSupervisionModule;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.BreakingCurveGroup;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.trainStatusMananger.ReleaseSpeedModeStateEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;
import ebd.speedAndDistanceSupervisionModule.util.events.SsmReportEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

/**
 * This class supervises the speed of the train and to some extend the distance traveled.
 * It checks if the speed or the distance becomes to great and signals such occurrences.
 * It is the responsibility of the Train Status Manager and the Driving Dynamic Modules to react to these signals
 * correctly.
 *
 * //TODO: Full fill applicable requirements of SRS 3.13!
 *
 * @author Lars Schulze-Falck
 */
public class SpeedSupervisor {


    private EventBus localEventBus;
    private String tdTarget = "td";
    private String allTarget = "all";
    private TrainDataVolatile trainDataVolatile;
    private ConfigHandler ch;

    private BreakingCurveGroup breakingCurveGroup = null;
    private boolean inRSM;
    private SpeedInterventionLevel curSpeedInterventionLevel;
    private SpeedSupervisionState curSupervisionState;

    private Double maxServiceDistance = 0d; //in [m]
    private Double maxEmergencyDistance = 0d; //in [m]

    private double maxEmergencyInterventionSpeed; //in [m/s]
    private double maxServiceInterventionSpeed; //in [m/s]
    private double maxWarningSpeed; //in [m/s]
    private double maxPermittedSpeed; //in [m/s]
    private double maxIndicationSpeed; //in [m/s]
    private double maxCoastingPhaseSpeed; //in [m/s]

    private double targetSpeed = 0d; //in [m/s]
    private double targetSpeedDistance = 0d; //in [m]
    /**
     * If release speed == 0, handel it as no release speed applicable!
     */
    private double releaseSpeed = 0d; //in [m/s]

    /**
     * Constructor
     * @param localEventBus The local {@link EventBus} of the train
     */
    public SpeedSupervisor(EventBus localEventBus){
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

        if (curPosition.getLocation().getId() == (new InitalLocation()).getId()) {
            return;
        }

        double tripDistance = curPosition.totalDistanceToPastLocation(this.breakingCurveGroup.getServiceDecelerationCurve().getRefLocation().getId());

        if(this.inRSM) updateMaxSpeedsToRSM(tripDistance);
        else updateMaxSpeeds(tripDistance, curSpeed);

        SpeedInterventionLevel speedInterventionLevel;
        SpeedSupervisionState supervisionState;

        if(this.inRSM && this.releaseSpeed > 0){//Release speed monitoring
            supervisionState = SpeedSupervisionState.RELEASE_SPEED_SUPERVISION;
            if(curSpeed > this.releaseSpeed + ch.dV_ebi_min){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            else if(this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS && curSpeed > 0){
                speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            else {
                speedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
            }
        }
        else if(this.maxIndicationSpeed >= curSpeed
                && this.maxIndicationSpeed == this.maxEmergencyInterventionSpeed) { //Ceiling speed monitoring regime
            //Based on SRS 026-3 Table 17
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
            else if(curSpeed > this.maxPermittedSpeed){
                speedInterventionLevel = SpeedInterventionLevel.PERMITTED_SPEED;
            }
            else {
                speedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
            }

            if (csmP1Emergency(curSpeed)) speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            else if (csmP1Service(curSpeed)) speedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            else if (csmP1NoIntervention(curSpeed)) speedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
            else if (csmP2(curSpeed)) speedInterventionLevel = SpeedInterventionLevel.WARNING;
            else if (csmP3(curSpeed)) speedInterventionLevel = SpeedInterventionLevel.PERMITTED_SPEED;
            else speedInterventionLevel = this.curSpeedInterventionLevel;



        }
        else{ //Target speed monitoring regime
            supervisionState = SpeedSupervisionState.TARGET_SPEED_SUPERVISION;
            //Based on SRS 026-3 Table 12
            if (tsmP1Emergency(curSpeed)) speedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            else if (tsmP1Service(curSpeed)) speedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            else if (tsmP1Indication(curSpeed)) speedInterventionLevel = SpeedInterventionLevel.INDICATION;
            else if (tsmP2(curSpeed)) speedInterventionLevel = SpeedInterventionLevel.WARNING;
            else if (tsmP3(curSpeed)) speedInterventionLevel = SpeedInterventionLevel.PERMITTED_SPEED;
            else if (tsmP4(curSpeed)) speedInterventionLevel = SpeedInterventionLevel.INDICATION;
            else speedInterventionLevel = this.curSpeedInterventionLevel;
        }
        this.curSpeedInterventionLevel = speedInterventionLevel;
        this.curSupervisionState = supervisionState;
        this.localEventBus.postSticky(new SsmReportEvent("ssm", this.allTarget, speedInterventionLevel, supervisionState));
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
        this.targetSpeed = this.breakingCurveGroup.getPermittedSpeedCurve().getPointOnCurve(0d);
        this.targetSpeedDistance = 0d;
    }

    @Subscribe
    public void setInRSM(ReleaseSpeedModeStateEvent rsmse){
        this.inRSM = rsmse.inRSM;
        this.releaseSpeed = rsmse.curReleaseSpeed;
    }

    /**
     * Sets the current max speeds of all breaking curves at the current position
     * @param tripDistance Current trip distance starting at the reference point of the breaking curves
     */
    private void updateMaxSpeeds(double tripDistance, double curSpeed) {
        this.maxEmergencyInterventionSpeed = 0d;
        this.maxServiceInterventionSpeed = 0d;
        this.maxWarningSpeed = 0d;
        this.maxPermittedSpeed = 0d;
        this.maxIndicationSpeed = 0d;
        this.maxCoastingPhaseSpeed = 0d;

        if(tripDistance < this.maxServiceDistance){
            this.maxEmergencyInterventionSpeed = this.breakingCurveGroup.getEmergencyInterventionCurve().getPointOnCurve(tripDistance);

            this.maxServiceInterventionSpeed = this.breakingCurveGroup.getServiceInterventionCurve().getPointOnCurve(tripDistance);
            this.maxWarningSpeed = this.breakingCurveGroup.getServiceWarningCurve().getPointOnCurve(tripDistance);
            this.maxPermittedSpeed = this.breakingCurveGroup.getPermittedSpeedCurve().getPointOnCurve(tripDistance);
            this.maxIndicationSpeed = this.breakingCurveGroup.getServiceIndicationCurve().getPointOnCurve(tripDistance);
            this.maxCoastingPhaseSpeed = this.breakingCurveGroup.getServiceCoastingPhaseCurve().getPointOnCurve(tripDistance);

            if(tripDistance >= this.targetSpeedDistance){
                BreakingCurve bc = this.breakingCurveGroup.getPermittedSpeedCurve(); //TODO Get Trip Profile somehow
                findNewTargetSpeedAndDistance(bc,tripDistance);
            }
        }
        else if (tripDistance < this.maxEmergencyDistance){
            this.maxEmergencyInterventionSpeed = this.breakingCurveGroup.getEmergencyInterventionCurve().getPointOnCurve(tripDistance);
            this.targetSpeed = 0d;
        }
    }

    /**
     *
     * @param tripDistance
     */
    private void updateMaxSpeedsToRSM(double tripDistance) {
        this.maxEmergencyInterventionSpeed = 0d;
        this.maxServiceInterventionSpeed = this.releaseSpeed;
        this.maxWarningSpeed = this.releaseSpeed;
        this.maxPermittedSpeed = this.releaseSpeed;
        this.maxIndicationSpeed = this.releaseSpeed;
        this.maxCoastingPhaseSpeed = this.releaseSpeed;
        this.targetSpeed = 0d;

        if (tripDistance < this.maxEmergencyDistance) {
            this.maxEmergencyInterventionSpeed = this.breakingCurveGroup.getEmergencyInterventionCurve().getPointOnCurve(tripDistance);
        }
    }

    /**
     * Calculates the target speed that has to be reached at the end of the next breaking phase and the distance
     * to that end. Updates {@code this.targetSpeed} and {@code this.targetSpeedDistance}.
     * @param bc The main {@link BreakingCurve}
     * @param tripDistance The distance driven in reference to the start of the breaking curve
     */
    private void findNewTargetSpeedAndDistance(BreakingCurve bc, double tripDistance) {


        double startSpeedOfBreaking = this.targetSpeed;
        double oldTD = tripDistance;
        double newTD;
        double oldTV = this.targetSpeed;
        double newTV;
        while(true){
            newTD = bc.getHigherOrLastKnotXValue(oldTD);
            if(newTD == bc.getHighestXValue()){
                this.targetSpeedDistance = newTD;
                this.targetSpeed = bc.getPointOnCurve(newTD);
                break;
            }
            newTV = bc.getPointOnCurve(newTD);
            if(startSpeedOfBreaking < newTV){
                startSpeedOfBreaking = newTV;
            }
            else if(startSpeedOfBreaking > newTV && oldTV == newTV){
                this.targetSpeedDistance = newTD;
                this.targetSpeed = newTV;
                break;
            }

            oldTD = newTD;
            oldTV = newTV;
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
        updateMap.put("targetSpeed", this.targetSpeed);
        updateMap.put("currentApplicableReleaseSpeed",this.releaseSpeed);

        this.localEventBus.post(new TrainDataMultiChangeEvent("ssm", this.tdTarget, updateMap));
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 8
     * @param curSpeed current Speed
     * @return true if triggering condition [13] or [15] is fulfilled
     */
    private boolean tsmP1Emergency(double curSpeed) {
        //Checking if d_maxsafefront > d_ebi ([13]) happens in updateMaxSpeeds
        //Checking if d_maxsafefront > d_I ([15]) happens in clockTick
        if(curSpeed > this.maxEmergencyInterventionSpeed) return true;
        return false;
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 8
     * //TODO add ability to check for condition [10]
     * @param curSpeed current Speed
     * @return true if triggering condition [12] is fulfilled
     */
    private boolean tsmP1Service(double curSpeed) {
        //Checks concerning distances are ignored
        if(curSpeed > this.maxServiceInterventionSpeed) return true;
        return false;
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 10
     * //TODO Add ability for [3]
     * @param curSpeed current Speed
     * @return true if revocation condition [0] or [1] is fulfilled
     */
    private boolean tsmP1Indication(double curSpeed) {
        //Checks concerning distances are ignored
        if(this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS && curSpeed == 0){ //[0]
            return true;
        }
        if (this.curSpeedInterventionLevel != SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS && curSpeed <= this.targetSpeed){ //[1]
            return true;
        }

        return false;
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 8
     * //TODO add ability to check for condition [7]
     * @param curSpeed current Speed
     * @return true if triggering condition [9] is fulfilled
     */
    private boolean tsmP2(double curSpeed) {
        //Checks concerning distances are ignored
        if (this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS
                || this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_SERVICE_BREAKS){
            return false;
        }
        if(curSpeed > this.maxWarningSpeed){
            return true;
        }
        return false;
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 8
     * //TODO add ability to check for condition [4]
     * @param curSpeed current Speed
     * @return true if triggering condition [6] is fulfilled
     */
    private boolean tsmP3(double curSpeed) {
        //Checks concerning distances are ignored
        if (this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS
                || this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_SERVICE_BREAKS){
            return false;
        }
        if(curSpeed > this.maxPermittedSpeed){
            return true;
        }
        return false;
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 8
     * @param curSpeed current Speed
     * @return true if triggering condition [3] is fulfilled
     */
    private boolean tsmP4(double curSpeed) {
        if (this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS
                || this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_SERVICE_BREAKS
                || this.curSpeedInterventionLevel == SpeedInterventionLevel.WARNING){
            return false;
        }
        return true; //We already know that we are in TSM, so this is the default condition
    }

    /**
     * See SRS 026 3.13.10.4 Table 7 and Table 5
     * @param curSpeed current Speed
     * @return true if triggering condition [5] is fulfilled
     */
    private boolean csmP1Emergency(double curSpeed) {
        if(curSpeed > this.maxEmergencyInterventionSpeed) return true;
        return false;
    }

    /**
     * See SRS 026 3.13.10.4 Table 7 and Table 5
     * @param curSpeed current Speed
     * @return true if triggering condition [4] is fulfilled
     */
    private boolean csmP1Service(double curSpeed) {
        if(curSpeed > this.maxServiceInterventionSpeed) return true;
        return false;
    }

    /**
     * See SRS 026 3.13.10.4 Table 7 and Table 6
     * @param curSpeed current Speed
     * @return true if revocation condition [0] or [1] is fulfilled
     */
    private boolean csmP1NoIntervention(double curSpeed) {
        if(this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS && curSpeed == 0){
            return true;
        }
        if(this.curSpeedInterventionLevel != SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS && curSpeed < this.maxPermittedSpeed){
            return true;
        }
        return false;
    }

    /**
     * See SRS 026 3.13.10.4 Table 7 and Table 5
     * @param curSpeed current Speed
     * @return true if triggering condition [3] is fulfilled
     */
    private boolean csmP2(double curSpeed) {
        if (this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS
                || this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_SERVICE_BREAKS){
            return false;
        }
        if (curSpeed > this.maxWarningSpeed){
            return true;
        }
        return false;
    }

    /**
     * See SRS 026 3.13.10.4 Table 7 and Table 5
     * @param curSpeed current Speed
     * @return true if triggering condition [2] is fulfilled
     */
    private boolean csmP3(double curSpeed) {
        if (this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS
                || this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_SERVICE_BREAKS
                || this.curSpeedInterventionLevel == SpeedInterventionLevel.WARNING){
            return false;
        }
        if (curSpeed > this.maxWarningSpeed){
            return true;
        }
        return false;
    }

}
