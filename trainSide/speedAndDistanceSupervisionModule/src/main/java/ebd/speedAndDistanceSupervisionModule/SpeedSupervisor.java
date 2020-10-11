package ebd.speedAndDistanceSupervisionModule;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.CurveGroup;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.breakingCurveType.CurveType;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.trainStatusMananger.ReleaseSpeedModeStateEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;
import ebd.globalUtils.events.speedDistanceSupervision.SsmReportEvent;
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

    private BreakingCurve emergencyBreakingCurve = null;
    private boolean inRSM = false;
    private SpeedInterventionLevel curSpeedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
    private SpeedSupervisionState curSupervisionState = SpeedSupervisionState.NOT_SET;
    private Double maxEmergencyDistance = 0d; //in [m]

    private double maxEmergencyInterventionSpeed; //in [m/s]
    private double maxServiceInterventionSpeed; //in [m/s]
    private double maxWarningSpeed; //in [m/s]
    private double maxPermittedSpeed; //in [m/s]
    private double maxIndicationSpeed; //in [m/s]

    private double targetSpeed = 0d; //in [m/s]
    private double targetSpeedDistance = 0d; //in [m]
    /**
     * If release speed == 0, handel it as no release speed applicable!
     */
    private double releaseSpeed = 0d; //in [m/s]
    private double releaseDistance;

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

        if (this.emergencyBreakingCurve == null){
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

        double tripDistance = curPosition.totalDistanceToPastLocation(this.emergencyBreakingCurve.getRefLocation().getId());

        findTargetSpeedAndDistance(tripDistance);

        if(this.inRSM) updateMaxSpeedsToRSM(tripDistance);
        else updateMaxSpeeds(tripDistance, curSpeed);

        if(this.inRSM && this.releaseSpeed > 0){//Release speed monitoring
            this.curSupervisionState = SpeedSupervisionState.RELEASE_SPEED_SUPERVISION;
            if(curSpeed > this.releaseSpeed + ch.dV_ebi_min){
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            else if(this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS && curSpeed > 0){
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            else {
                this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
            }
        }
        else if(this.maxIndicationSpeed >= curSpeed
                && this.maxIndicationSpeed == this.maxEmergencyInterventionSpeed) { //Ceiling speed monitoring regime
            //Based on SRS 026-3 Table 17
            this.curSupervisionState = SpeedSupervisionState.CEILING_SPEED_SUPERVISION;

            switch (this.curSpeedInterventionLevel){

                case NOT_SET, NO_INTERVENTION, INDICATION -> csmIndicationAndNoIntervention(curSpeed);
                case OVERSPEED -> csmOverspeed(curSpeed);
                case WARNING -> csmWarning(curSpeed);
                case APPLY_SERVICE_BREAKS -> csmServiceBreakIntervention(curSpeed);
                case APPLY_EMERGENCY_BREAKS -> csmEmergencyBreakIntervention(curSpeed);
            }



        }
        else{ //Target speed monitoring regime
            this.curSupervisionState = SpeedSupervisionState.TARGET_SPEED_SUPERVISION;
            //Based on SRS 026-3 Table 12
            switch (this.curSpeedInterventionLevel){

                case NOT_SET, NO_INTERVENTION -> this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
                case INDICATION -> tmsIndication(curSpeed);
                case OVERSPEED -> tmsOverspeed(curSpeed,tripDistance);
                case WARNING -> tmsWarning(curSpeed,tripDistance);
                case APPLY_SERVICE_BREAKS -> tmsServiceBreakIntervention(curSpeed, tripDistance);
                case APPLY_EMERGENCY_BREAKS -> tsmEmergencyBreakIntervention(curSpeed);
            }
        }
        this.localEventBus.postSticky(new SsmReportEvent("ssm", this.allTarget, this.curSpeedInterventionLevel, this.curSupervisionState));
        sendCurrentMaxSpeed();
    }

    private void findTargetSpeedAndDistance(double curTripDistance) {
        this.targetSpeedDistance = this.emergencyBreakingCurve.nextTargetDistance(curTripDistance);
        //Check for supervised target "release speed"
        if(curTripDistance < this.releaseDistance && this.targetSpeedDistance > this.releaseDistance){
            this.targetSpeedDistance = this.releaseDistance;
            this.targetSpeed = this.releaseSpeed;
        }
        else this.targetSpeed = this.emergencyBreakingCurve.getSpeedAtDistance(this.targetSpeedDistance,CurveType.PERMITTED_SPEED);
    }


    /**
     * This method updates the breaking curve.
     * @param nbce A {@link NewBreakingCurveEvent}
     */
    @Subscribe
    public void setBreakingCurves(NewBreakingCurveEvent nbce){
        this.emergencyBreakingCurve = nbce.emergencyBreakingCurve;
        this.maxEmergencyDistance = this.emergencyBreakingCurve.endOfDefinedDistance();
    }

    @Subscribe
    public void setInRSM(ReleaseSpeedModeStateEvent rsmse){
        this.inRSM = rsmse.inRSM;
        this.releaseSpeed = rsmse.curReleaseSpeed;
        this.releaseDistance = rsmse.releaseDistance;
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

        if(tripDistance < this.maxEmergencyDistance){
            this.maxEmergencyInterventionSpeed = this.emergencyBreakingCurve.getSpeedAtDistance(tripDistance, CurveType.EMERGENCY_INTERVENTION_CURVE);

            this.maxServiceInterventionSpeed = this.emergencyBreakingCurve.getSpeedAtDistance(tripDistance, CurveType.SERVICE_INTERVENTION_CURVE_2);

            this.maxWarningSpeed = this.emergencyBreakingCurve.getSpeedAtDistance(tripDistance, CurveType.WARNING_CURVE);

            this.maxPermittedSpeed = this.emergencyBreakingCurve.getSpeedAtDistance(tripDistance, CurveType.PERMITTED_SPEED);

            this.maxIndicationSpeed = this.emergencyBreakingCurve.getSpeedAtDistance(tripDistance, CurveType.INDICATION_CURVE);
        }

    }

    /**
     * Set
     * @param tripDistance current trip distance
     */
    private void updateMaxSpeedsToRSM(double tripDistance) {
        this.maxEmergencyInterventionSpeed = 0d;
        this.maxServiceInterventionSpeed = 0d;
        this.maxWarningSpeed = this.releaseSpeed;
        this.maxPermittedSpeed = this.releaseSpeed;
        this.maxIndicationSpeed = this.releaseSpeed;

        if (tripDistance < this.maxEmergencyDistance) {
            this.maxEmergencyInterventionSpeed = this.emergencyBreakingCurve.getSpeedAtDistance(tripDistance,CurveType.EMERGENCY_INTERVENTION_CURVE);
            this.maxEmergencyInterventionSpeed = Math.min(this.maxEmergencyInterventionSpeed, this.releaseSpeed + ch.dV_ebi_min);
            this.maxServiceInterventionSpeed = this.emergencyBreakingCurve.getSpeedAtDistance(tripDistance,CurveType.SERVICE_INTERVENTION_CURVE_2);
            this.maxServiceInterventionSpeed = Math.min(this.maxServiceInterventionSpeed, this.releaseSpeed + ch.dV_sbi_min);
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
        updateMap.put("targetSpeed", this.targetSpeed);
        updateMap.put("currentApplicableReleaseSpeed",this.releaseSpeed);

        this.localEventBus.post(new TrainDataMultiChangeEvent("ssm", this.tdTarget, updateMap));
    }

    /*
    Target Speed Supervision Conditions
     */

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 10
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#INDICATION} if revocation condition [0]
     * is fulfilled
     * @param curSpeed current Speed in [m/s]
     */
    private void tsmEmergencyBreakIntervention(double curSpeed){
        if(curSpeed == 0) this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 10
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#INDICATION} if revocation condition [1] or [3]
     * are fulfilled
     * @param curSpeed current Speed in [m/s]
     */
    private void tmsServiceBreakIntervention(double curSpeed, double tripDistance){
        if(tripDistance > this.targetSpeedDistance && curSpeed < this.targetSpeed ||
            tripDistance < this.targetSpeedDistance && curSpeed < this.maxPermittedSpeed) {
            this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
        }
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 10 and 8
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#INDICATION} if revocation condition [1] or [3]
     * are fulfilled.<br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS} or {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * if triggering condition [12] or [15] are fulfilled, respectively. <br>
     * Distance considerations are mostly ignored.
     * //TODO Add distance considerations
     * @param curSpeed current Speed in [m/s]
     */
    private void tmsWarning(double curSpeed, double tripDistance){
        if(tripDistance > this.targetSpeedDistance && curSpeed < this.targetSpeed ||
                tripDistance < this.targetSpeedDistance && curSpeed < this.maxPermittedSpeed) {
            this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
        }
        else if(curSpeed > this.maxEmergencyInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        else if(curSpeed > this.maxServiceInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 10 and 8
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#INDICATION} if revocation condition [1] or [3]
     * are fulfilled.<br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#WARNING} if triggering condition [9] is
     * fulfilled. <br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS} or {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * if triggering condition [12] or [15] are fulfilled, respectively. <br>
     * Distance considerations are mostly ignored.
     * //TODO Add distance considerations
     * @param curSpeed current Speed in [m/s]
     */
    private void tmsOverspeed(double curSpeed, double tripDistance){
        if(tripDistance > this.targetSpeedDistance && curSpeed < this.targetSpeed ||
                tripDistance < this.targetSpeedDistance && curSpeed < this.maxPermittedSpeed) {
            this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
        }
        else if(curSpeed > this.maxEmergencyInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        else if(curSpeed > this.maxServiceInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
        else if(curSpeed > this.maxWarningSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 10 and 8
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#OVERSPEED} if triggering condition [6] is
     * fulfilled. <br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#WARNING} if triggering condition [9] is
     * fulfilled. <br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS} or {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * if triggering condition [12] or [15] are fulfilled, respectively. <br>
     * Distance considerations are mostly ignored.
     * //TODO Add distance considerations
     * @param curSpeed current Speed in [m/s]
     */
    private void tmsIndication(double curSpeed){
        if(curSpeed > this.maxEmergencyInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        else if(curSpeed > this.maxServiceInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
        else if(curSpeed > this.maxWarningSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
        else if(curSpeed > this.maxPermittedSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.OVERSPEED;
    }

    /*
    Ceiling Speed Supervision
     */

    /**
     * See SRS 026 3.13.10.4 Table 7 and Table 6
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#NO_INTERVENTION} if revocation condition [0]
     * is fulfilled
     * @param curSpeed current Speed in [m/s]
     */
    private void csmEmergencyBreakIntervention(double curSpeed){
        if(curSpeed == 0) this.curSpeedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
    }

    /**
     * See SRS 026 3.13.10.4 Table 7 and Table 6
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#NO_INTERVENTION} if revocation condition [1]
     * is fulfilled
     * @param curSpeed current Speed in [m/s]
     */
    private void csmServiceBreakIntervention(double curSpeed){
        if(curSpeed <= this.maxPermittedSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
    }

    /**
     * See SRS 026 3.13.10.4 Table 7 and Table 6
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#NO_INTERVENTION} if revocation condition [1]
     * is fulfilled<br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS} or {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * if triggering condition [4] or [5] are fulfilled, respectively. <br>
     * @param curSpeed current Speed in [m/s]
     */
    private void csmWarning(double curSpeed){
        if(curSpeed > this.maxEmergencyInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        else if(curSpeed > this.maxServiceInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
        else if(curSpeed <= this.maxPermittedSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
    }

    /**
     * See SRS 026 3.13.10.4 Table 7 and Table 6
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#NO_INTERVENTION} if revocation condition [1]
     * is fulfilled<br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS} or {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * if triggering condition [4] or [5] are fulfilled, respectively. <br>
     * Sets urSpeedInterventionLevel to {@link SpeedInterventionLevel#WARNING} if triggering condition [3] is fulfilled. <br>
     * @param curSpeed current Speed in [m/s]
     */
    private void csmOverspeed(double curSpeed){
        if(curSpeed > this.maxEmergencyInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        else if(curSpeed > this.maxServiceInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
        else if(curSpeed > this.maxWarningSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
        else if(curSpeed <= this.maxPermittedSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
    }

    private void csmIndicationAndNoIntervention(double curSpeed){
        if(curSpeed > this.maxEmergencyInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        else if(curSpeed > this.maxServiceInterventionSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
        else if(curSpeed > this.maxWarningSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
        else if(curSpeed > this.maxPermittedSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.OVERSPEED;
        else if(curSpeed <= this.maxPermittedSpeed) this.curSpeedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
    }

}
