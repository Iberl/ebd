package ebd.speedAndDistanceSupervisionModule;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.enums.CurveType;
import ebd.globalUtils.enums.ETCSMode;
import ebd.globalUtils.enums.SpeedInterventionLevel;
import ebd.globalUtils.enums.SpeedSupervisionState;
import ebd.globalUtils.events.speedDistanceSupervision.SsmReportEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.trainStatusMananger.ModeReportEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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


    private final EventBus localEventBus;
    private final String tdTarget = "td";
    private final TrainDataVolatile trainDataVolatile;
    private final RouteDataVolatile routeDataVolatile;

    private ETCSMode curMode = ETCSMode.NO_MODE;

    private BreakingCurve emergencyBreakingCurve = null;
    private BreakingCurve serviceBreakingCurve = null;
    private SpeedInterventionLevel curSpeedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
    private SpeedSupervisionState curSupervisionState = SpeedSupervisionState.NOT_SET;
    private final SpeedSupervisionState tssState = SpeedSupervisionState.TARGET_SPEED_SUPERVISION;

    private double targetSpeed = 0d; //in [m/s]
    private double targetDistance = 0d; //in [m]
    private double tssTargetDistance = 0d;
    private double serviceTargetDistance;
    /**
     * If release speed == 0, handel it as no release speed applicable!
     */
    private double releaseSpeed = 0d; //in [m/s]
    /**
     * Distance relative to the reference location at which train can switch into RSM mode
     */
    private double releaseDistance;

    /**
     * Constructor
     * @param localEventBus The local {@link EventBus} of the train
     */
    public SpeedSupervisor(EventBus localEventBus){
        this.localEventBus = localEventBus;
        localEventBus.register(this);
        this.routeDataVolatile = this.localEventBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
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

        if (this.emergencyBreakingCurve == null) return;

        double curSpeed = trainDataVolatile.getCurrentSpeed();
        Position curPosition = trainDataVolatile.getCurrentPosition();
        if (curPosition == null || curPosition.getLocation().getId() == (new InitalLocation()).getId()) return;

        switch (curMode) {
            case NO_MODE, STAND_BY, SHUNTING, POST_TRIP -> forceHalt(curSpeed);
            case FULL_SUPERVISION -> fullSupervision(curSpeed, curPosition);
            case SYSTEM_FAILURE, TRIP -> forceEmergencyStop();
        }

        String allTarget = "all";
        this.localEventBus.postSticky(new SsmReportEvent("ssm",
                allTarget,
                this.curSpeedInterventionLevel,
                this.curSupervisionState,
                this.releaseDistance,
                this.releaseSpeed));
    }


    /**
     * This method updates the breaking curve and related values
     * @param nbce A {@link NewBreakingCurveEvent}
     */
    @Subscribe
    public void setBreakingCurves(NewBreakingCurveEvent nbce){
        this.emergencyBreakingCurve = nbce.emergencyBreakingCurve;
        this.serviceBreakingCurve = nbce.serviceBreakingCurve;

        this.releaseSpeed = calculateReleaseSpeed();
        this.releaseDistance = calculateReleaseSpeedDistance(this.releaseSpeed);
        if(curSupervisionState == SpeedSupervisionState.RELEASE_SPEED_SUPERVISION) {
            this.curSupervisionState = SpeedSupervisionState.CEILING_SPEED_SUPERVISION; //Pulls train out of RSM
        }
    }

    @Subscribe
    public void curMode(ModeReportEvent mre){
        this.curMode = mre.curMode;
    }

    /**
     * Sets curSpeedInterventionLevel and curSupervisionState to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS}
     * and {@link SpeedSupervisionState#CEILING_SPEED_SUPERVISION}. If current Speed is > 0,
     * {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS} is set instead.
     * @param curSpeed current speed in [m/s]
     */
    private void forceHalt(double curSpeed){
        this.curSupervisionState = SpeedSupervisionState.CEILING_SPEED_SUPERVISION;
        if(curSpeed == 0){
            this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
        }
        else {
            this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        }
    }

    /**
     * Sets curSpeedInterventionLevel and curSupervisionState to {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * and {@link SpeedSupervisionState#CEILING_SPEED_SUPERVISION}
     */
    private void forceEmergencyStop(){
        this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        this.curSupervisionState = SpeedSupervisionState.CEILING_SPEED_SUPERVISION;
    }

    /**
     * Sets the curSpeedInterventionLevel and curSupervisionState when in mode {@link ETCSMode#FULL_SUPERVISION}.
     * @param curSpeed in [m/s]
     * @param curPosition s. {@link Position}
     */
    private void fullSupervision(double curSpeed, Position curPosition) {
        double estimatedFrontEnd = curPosition.estimatedDistanceToPastLocation(this.emergencyBreakingCurve.getRefLocation().getId());
        double maxSafeFrontEnd = curPosition.maxSafeFrontDistanceToPastLocation(this.emergencyBreakingCurve.getRefLocation().getId());

        findTargetSpeedAndDistance(estimatedFrontEnd);

        SpeedSupervisionState eState = this.emergencyBreakingCurve.getSpeedSupervisionState(estimatedFrontEnd,curSpeed);
        SpeedSupervisionState sState = this.serviceBreakingCurve.getSpeedSupervisionState(estimatedFrontEnd,curSpeed);
        boolean eoaTarget = serviceTargetDistance == this.serviceBreakingCurve.endOfDefinedDistance() &&
                this.serviceBreakingCurve.getSpeedAtDistance(serviceTargetDistance, CurveType.PERMITTED_SPEED) == 0;

        boolean newInTSM = eState == tssState || (sState == tssState && eoaTarget);
        boolean oldInTSM = this.curSupervisionState == tssState && this.targetDistance == this.tssTargetDistance;

        if(this.curSupervisionState == SpeedSupervisionState.RELEASE_SPEED_SUPERVISION ||
            (this.releaseSpeed > 0 && curSpeed < this.releaseSpeed && maxSafeFrontEnd > this.releaseDistance)){//Release speed monitoring

            this.curSupervisionState = SpeedSupervisionState.RELEASE_SPEED_SUPERVISION;

            if(curSpeed > this.releaseSpeed){
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            else if(this.curSpeedInterventionLevel == SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS && curSpeed > 0){
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            else {
                this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
            }
        }
        else if(newInTSM || oldInTSM){ //Target speed monitoring regime
            this.tssTargetDistance = this.targetDistance;
            this.curSupervisionState = SpeedSupervisionState.TARGET_SPEED_SUPERVISION;
            //Based on SRS 026-3 Table 12
            switch (this.curSpeedInterventionLevel){

                case NOT_SET, NO_INTERVENTION -> this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
                case INDICATION -> tmsIndication(curSpeed, estimatedFrontEnd, maxSafeFrontEnd);
                case OVERSPEED -> tmsOverspeed(curSpeed,estimatedFrontEnd, maxSafeFrontEnd);
                case WARNING -> tmsWarning(curSpeed,estimatedFrontEnd,maxSafeFrontEnd);
                case APPLY_SERVICE_BREAKS -> tmsServiceBreakIntervention(curSpeed, estimatedFrontEnd, maxSafeFrontEnd);
                case APPLY_EMERGENCY_BREAKS -> tsmEmergencyBreakIntervention(curSpeed);
            }
        }
        else { //Ceiling speed monitoring regime
            //Based on SRS 026-3 Table 17
            this.curSupervisionState = SpeedSupervisionState.CEILING_SPEED_SUPERVISION;

            switch (this.curSpeedInterventionLevel){

                case NOT_SET, NO_INTERVENTION, INDICATION -> csmIndicationAndNoIntervention(curSpeed, estimatedFrontEnd);
                case OVERSPEED -> csmOverspeed(curSpeed, estimatedFrontEnd);
                case WARNING -> csmWarning(curSpeed, estimatedFrontEnd);
                case APPLY_SERVICE_BREAKS -> csmServiceBreakIntervention(curSpeed, estimatedFrontEnd);
                case APPLY_EMERGENCY_BREAKS -> csmEmergencyBreakIntervention(curSpeed);
            }
        }
    }

    /**
     * Sets the current target speed and distance of that target from the reference location
     * @param curTripDistance in [m]
     */
    private void findTargetSpeedAndDistance(double curTripDistance) {
        this.targetDistance = this.emergencyBreakingCurve.nextTargetDistance(curTripDistance);
        this.serviceTargetDistance = this.serviceBreakingCurve.nextTargetDistance(curTripDistance);

        this.targetSpeed = this.emergencyBreakingCurve.getSpeedAtDistance(this.targetDistance,CurveType.PERMITTED_SPEED);
    }

    /**
     * Calculates the release speed based on the danger point distance in {@link ConfigHandler}. <br>
     *     A simplified calculation based on SRS 3.13.9.4.8.2 for only one target: EOA
     * @return The calculated release speed
     */
    private double calculateReleaseSpeed() {
        Packet_15 p15 = this.routeDataVolatile.getPacket_15();
        if(p15 == null) return 0;
        else if(p15.Q_OVERLAP == ETCSVariables.Q_OVERLAP_INFO) return p15.V_RELEASEOL * 5 / 3.6;
        return p15.V_RELEASEDP * 5 / 3.6;
    }

    /**
     * Calculates based on the release speed the distance to EOA at which the train should switch in to release speed. <br>
     *     A simplified calculation based on SRS 3.13.9.4.8.2 for only one target: EOA
     * @return The calculated release speed
     */
    private double calculateReleaseSpeedDistance(double releaseSpeed) {
        double distance = this.serviceBreakingCurve.getDistanceSpeedAlwaysLower(releaseSpeed, CurveType.PERMITTED_SPEED);
        if(distance < Double.POSITIVE_INFINITY){
            return distance;
        }
        return this.serviceBreakingCurve.endOfDefinedDistance();
    }


    /*
    Target Speed Supervision Conditions
     */

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 11
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#INDICATION} if revocation condition [0]
     * is fulfilled
     * @param curSpeed current Speed in [m/s]
     */
    private void tsmEmergencyBreakIntervention(double curSpeed){
        if(curSpeed == 0) this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 10 and 11
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#INDICATION} if revocation condition [1] or [3]
     * are fulfilled
     * @param curSpeed current Speed in [m/s]
     * @param estimatedFrontEnd in [m]
     * @param maxSafeFrontEnd in [m]
     */
    private void tmsServiceBreakIntervention(double curSpeed, double estimatedFrontEnd, double maxSafeFrontEnd){

        //TODO Test this
        boolean eoaTarget = this.serviceTargetDistance == this.serviceBreakingCurve.endOfDefinedDistance() &&
                                this.serviceBreakingCurve.getSpeedAtDistance(serviceTargetDistance, CurveType.PERMITTED_SPEED) == 0;
        boolean svlTarget = this.targetDistance == this.emergencyBreakingCurve.endOfDefinedDistance();

        tsmRevocationCondition1_3(curSpeed, estimatedFrontEnd, maxSafeFrontEnd, eoaTarget || svlTarget);


    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 8 to 11
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#INDICATION} if revocation condition [1] or [3]
     * are fulfilled.<br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS} or {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * if triggering condition [10]/[12] or [13]/[15] are fulfilled, respectively. <br>
     * Distance considerations are mostly ignored.
     * @param curSpeed current Speed in [m/s]
     * @param estimatedFrontEnd in [m]
     * @param maxSafeFrontEnd in [m]
     */
    private void tmsWarning(double curSpeed, double estimatedFrontEnd, double maxSafeFrontEnd){

        boolean eoaTarget = this.serviceTargetDistance == this.serviceBreakingCurve.endOfDefinedDistance() &&
                this.serviceBreakingCurve.getSpeedAtDistance(serviceTargetDistance, CurveType.PERMITTED_SPEED) == 0;
        boolean svlTarget = this.targetDistance == this.emergencyBreakingCurve.endOfDefinedDistance();

        tsmRevocationCondition1_3(curSpeed, estimatedFrontEnd, maxSafeFrontEnd, eoaTarget || svlTarget);

        tsmTriggerConditions10_12_13_15(curSpeed, estimatedFrontEnd, maxSafeFrontEnd, this.serviceTargetDistance, eoaTarget, svlTarget);
    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 11 and 8
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#INDICATION} if revocation condition [1] or [3]
     * are fulfilled.<br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#WARNING} if triggering condition [7] or [9] is
     * fulfilled. <br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS} or {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * if triggering condition [10]/[12] or [13]/[15] are fulfilled, respectively. <br>
     * Distance considerations are mostly ignored.
     * @param curSpeed current Speed in [m/s]
     * @param estimatedFrontEnd in [m]
     * @param maxSafeFrontEnd in [m]
     */
    private void tmsOverspeed(double curSpeed, double estimatedFrontEnd, double maxSafeFrontEnd){

        boolean eoaTarget = this.serviceTargetDistance == this.serviceBreakingCurve.endOfDefinedDistance() &&
                this.serviceBreakingCurve.getSpeedAtDistance(serviceTargetDistance, CurveType.PERMITTED_SPEED) == 0;
        boolean svlTarget = this.targetDistance == this.emergencyBreakingCurve.endOfDefinedDistance();

        tsmRevocationCondition1_3(curSpeed, estimatedFrontEnd, maxSafeFrontEnd, eoaTarget || svlTarget);

        tsmTriggerConditions10_12_13_15(curSpeed, estimatedFrontEnd, maxSafeFrontEnd, this.serviceTargetDistance, eoaTarget, svlTarget);

        tmsTriggerCondition7_9(curSpeed, estimatedFrontEnd, maxSafeFrontEnd, this.serviceTargetDistance, eoaTarget, svlTarget);

    }

    /**
     * See SRS 026 3.13.10.4 Table 12 and Table 11 and 8
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#OVERSPEED} if triggering condition [4] or [6] is
     * fulfilled. <br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#WARNING} if triggering condition [9] is
     * fulfilled. <br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS} or {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * if triggering condition [12] or [15] are fulfilled, respectively. <br>
     * Distance considerations are mostly ignored.
     * //TODO Add distance considerations
     * @param curSpeed current Speed in [m/s]
     * @param estimatedFrontEnd in [m]
     * @param maxSafeFrontEnd in [m]
     */
    private void tmsIndication(double curSpeed, double estimatedFrontEnd, double maxSafeFrontEnd){

        boolean eoaTarget = this.serviceTargetDistance == this.serviceBreakingCurve.endOfDefinedDistance() &&
                this.serviceBreakingCurve.getSpeedAtDistance(serviceTargetDistance, CurveType.PERMITTED_SPEED) == 0;
        boolean svlTarget = this.targetDistance == this.emergencyBreakingCurve.endOfDefinedDistance();

        tsmTriggerConditions10_12_13_15(curSpeed, estimatedFrontEnd, maxSafeFrontEnd, this.serviceTargetDistance, eoaTarget, svlTarget);

        tmsTriggerCondition7_9(curSpeed, estimatedFrontEnd, maxSafeFrontEnd, this.serviceTargetDistance, eoaTarget, svlTarget);

        tsmTriggerCondition4_6(curSpeed, estimatedFrontEnd, maxSafeFrontEnd, this.serviceTargetDistance, eoaTarget, svlTarget);
    }

    /**
     * See SRS 026 3.13.10.4 Table 10 and 11
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#INDICATION} if revocation condition [1] or [3]
     * are fulfilled
     * @param curSpeed current Speed in [m/s]
     * @param estimatedFrontEnd in [m]
     * @param maxSafeFrontEnd in [m]
     * @param eoaOrSVLTarget if target is either EOA (but not LOA) or SVL.
     */
    private void tsmRevocationCondition1_3(double curSpeed, double estimatedFrontEnd, double maxSafeFrontEnd, boolean eoaOrSVLTarget) {
        if (!eoaOrSVLTarget || this.releaseSpeed == 0) { //Table 10 is in effect
            double dP = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.PERMITTED_SPEED);
            if (curSpeed < this.targetSpeed) {//r1
                this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
            }
            if (curSpeed < this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.PERMITTED_SPEED)
                    && maxSafeFrontEnd < dP) {//r3
                this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
            }
        } else { //Table 11 is in effect
            double dPsvl = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, CurveType.PERMITTED_SPEED);
            double dPeoa = this.serviceBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, CurveType.PERMITTED_SPEED);

            if (curSpeed < this.releaseSpeed) { //r1
                this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
            }
            if (curSpeed < this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.PERMITTED_SPEED)
                    && maxSafeFrontEnd < dPsvl && estimatedFrontEnd < dPeoa) { //r3
                this.curSpeedInterventionLevel = SpeedInterventionLevel.INDICATION;
            }
        }
    }

    /**
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS} or {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * if triggering condition [10]/[12] or [13]/[15] are fulfilled, respectively. <br>
     * @param curSpeed in [m/s]
     * @param estimatedFrontEnd in [m]
     * @param maxSafeFrontEnd in [m]
     * @param serviceTargetDistance in [m]
     * @param eoaTarget if next target is EOA (but not LOA)
     * @param svlTarget if next target is SVL
     */
    private void tsmTriggerConditions10_12_13_15(double curSpeed,
                                                 double estimatedFrontEnd,
                                                 double maxSafeFrontEnd,
                                                 double serviceTargetDistance,
                                                 boolean eoaTarget,
                                                 boolean svlTarget) {
        if(!(eoaTarget || svlTarget) || this.releaseSpeed == 0){//Table 8 in effect
            double dEBI = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.EMERGENCY_INTERVENTION_CURVE);
            double dSBI2 = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.SERVICE_INTERVENTION_CURVE_2);
            double dI = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.INDICATION_CURVE);

            double vMRSP_dSBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.SERVICE_INTERVENTION_CURVE_2);
            double vTarget_dSBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.SERVICE_INTERVENTION_CURVE_2);
            double vMRSP_dEBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.EMERGENCY_INTERVENTION_CURVE);
            double vTarget_dEBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.EMERGENCY_INTERVENTION_CURVE);

            if(curSpeed > vTarget_dSBI && curSpeed <= vMRSP_dSBI && maxSafeFrontEnd > dSBI2){//t10
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            if(curSpeed > vMRSP_dSBI && curSpeed <= vMRSP_dEBI && maxSafeFrontEnd > dI && maxSafeFrontEnd <= dEBI){//t12
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            if(curSpeed > vTarget_dEBI && curSpeed <= vMRSP_dEBI && maxSafeFrontEnd > dEBI){//t13
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            if(curSpeed > vMRSP_dEBI && maxSafeFrontEnd > dI){//t15
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
        }
        else if(eoaTarget){//Table 9 EOA in effect
            double dEBI = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.EMERGENCY_INTERVENTION_CURVE);
            double dSBI1 = this.serviceBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, serviceTargetDistance, CurveType.SERVICE_INTERVENTION_CURVE_1);
            double dI = this.serviceBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, serviceTargetDistance, CurveType.INDICATION_CURVE);

            double vMRSP_dSBI = this.serviceBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.SERVICE_INTERVENTION_CURVE_1);
            double vMRSP_dEBI = this.serviceBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.EMERGENCY_INTERVENTION_CURVE);

            if(curSpeed > this.releaseSpeed && curSpeed <= vMRSP_dSBI && estimatedFrontEnd > dSBI1){//t10
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            if(curSpeed > vMRSP_dSBI && curSpeed <= vMRSP_dEBI && estimatedFrontEnd > dI && maxSafeFrontEnd <= dEBI){//t12
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            if(curSpeed > this.releaseSpeed && curSpeed <= vMRSP_dEBI && maxSafeFrontEnd > dEBI){//t13
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            if(curSpeed > vMRSP_dEBI && estimatedFrontEnd > dI){//t15
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
        }
        else {//Table 9 SVL in effect
            double dEBI = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.EMERGENCY_INTERVENTION_CURVE);
            double dSBI2 = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.SERVICE_INTERVENTION_CURVE_2);
            double dI = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.INDICATION_CURVE);

            double vMRSP_dSBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.SERVICE_INTERVENTION_CURVE_2);
            double vMRSP_dEBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.EMERGENCY_INTERVENTION_CURVE);

            if(curSpeed > this.releaseSpeed && curSpeed <= vMRSP_dSBI && estimatedFrontEnd > dSBI2){//t10
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            if(curSpeed > vMRSP_dSBI && curSpeed <= vMRSP_dEBI && maxSafeFrontEnd > dI && maxSafeFrontEnd <= dEBI){//t12
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
            }
            if(curSpeed > this.releaseSpeed && curSpeed <= vMRSP_dEBI && maxSafeFrontEnd > dEBI){//t13
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }
            if(curSpeed > vMRSP_dEBI && maxSafeFrontEnd > dI){//t15
                this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
            }

        }
    }

    /**
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#WARNING} if triggering condition [7] or [9] is
     * fulfilled. <br>
     * @param curSpeed in [m/s]
     * @param estimatedFrontEnd in [m]
     * @param maxSafeFrontEnd in [m]
     * @param serviceTargetDistance in [m]
     * @param eoaTarget if next target is EOA (but not LOA)
     * @param svlTarget if next target is SVL
     */
    private void tmsTriggerCondition7_9(double curSpeed,
                                        double estimatedFrontEnd,
                                        double maxSafeFrontEnd,
                                        double serviceTargetDistance,
                                        boolean eoaTarget,
                                        boolean svlTarget) {
        if(!(eoaTarget || svlTarget) || this.releaseSpeed == 0){//Table 8 in effect
            double vTarget_dW = this.emergencyBreakingCurve.getVmrspAtDistance(this.targetDistance, CurveType.WARNING_CURVE);
            double vMRSP_dW = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.WARNING_CURVE);
            double vMRSP_dSBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.SERVICE_INTERVENTION_CURVE_2);

            double dW = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.WARNING_CURVE);
            double dI = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.INDICATION_CURVE);
            double dSBI2 = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.SERVICE_INTERVENTION_CURVE_2);

            if(curSpeed > vTarget_dW && curSpeed <= vMRSP_dW && maxSafeFrontEnd > dW){//t7
                this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
            }
            if(curSpeed > vMRSP_dW && curSpeed <= vMRSP_dSBI && maxSafeFrontEnd > dI && maxSafeFrontEnd <= dSBI2){//t9
                this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
            }
        }
        else if(eoaTarget){//Table 8 in effect
            double vMRSP_dW = this.serviceBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.WARNING_CURVE);
            double vMRSP_dSBI = this.serviceBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.SERVICE_INTERVENTION_CURVE_1);

            double dW = this.serviceBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, serviceTargetDistance, CurveType.WARNING_CURVE);
            double dI = this.serviceBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, serviceTargetDistance, CurveType.INDICATION_CURVE);
            double dSBI1 = this.serviceBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, serviceTargetDistance, CurveType.SERVICE_INTERVENTION_CURVE_1);

            if(curSpeed > this.releaseSpeed && curSpeed <= vMRSP_dW && estimatedFrontEnd > dW){//t7
                this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
            }
            if(curSpeed > vMRSP_dW && curSpeed <= vMRSP_dSBI && estimatedFrontEnd > dI && estimatedFrontEnd <= dSBI1){//t9
                this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
            }
        }
        else {
            double vMRSP_dW = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.WARNING_CURVE);
            double vMRSP_dSBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.SERVICE_INTERVENTION_CURVE_2);

            double dW = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.WARNING_CURVE);
            double dI = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.INDICATION_CURVE);
            double dSBI2 = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, this.targetDistance, CurveType.SERVICE_INTERVENTION_CURVE_2);

            if(curSpeed > this.releaseSpeed && curSpeed <= vMRSP_dW && maxSafeFrontEnd > dW){//t7
                this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
            }
            if(curSpeed > vMRSP_dW && curSpeed <= vMRSP_dSBI && maxSafeFrontEnd > dI && maxSafeFrontEnd <= dSBI2){//t9
                this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
            }
        }
    }

    /**
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#OVERSPEED} if triggering condition [4] or [6] is
     * fulfilled. <br>
     * @param curSpeed in [m/s]
     * @param estimatedFrontEnd in [m]
     * @param maxSafeFrontEnd in [m]
     * @param serviceTargetDistance in [m]
     * @param eoaTarget if next target is EOA (but not LOA)
     * @param svlTarget if next target is SVL
     */
    private void tsmTriggerCondition4_6(double curSpeed,
                                        double estimatedFrontEnd,
                                        double maxSafeFrontEnd,
                                        double serviceTargetDistance,
                                        boolean eoaTarget,
                                        boolean svlTarget) {
        if(!(eoaTarget || svlTarget) || this.releaseSpeed == 0){//Table 8 in effect
            double vTarget = this.emergencyBreakingCurve.getVmrspAtDistance(this.targetDistance, CurveType.PERMITTED_SPEED);
            double vMRSP = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.PERMITTED_SPEED);
            double vMRSP_dw = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.WARNING_CURVE);

            double dP = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed,this.targetDistance,CurveType.PERMITTED_SPEED);
            double dI = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed,this.targetDistance,CurveType.INDICATION_CURVE);
            double dW = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed,this.targetDistance,CurveType.WARNING_CURVE);

            if(curSpeed > vTarget && curSpeed <= vMRSP && maxSafeFrontEnd > dP){//t4
                this.curSpeedInterventionLevel = SpeedInterventionLevel.OVERSPEED;
            }
            if(curSpeed > vMRSP && curSpeed <= vMRSP_dw && maxSafeFrontEnd > dI && maxSafeFrontEnd <= dW){//t6
                this.curSpeedInterventionLevel = SpeedInterventionLevel.OVERSPEED;
            }
        }
        else if(eoaTarget){
            double vMRSP = this.serviceBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.PERMITTED_SPEED);
            double vMRSP_dw = this.serviceBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.WARNING_CURVE);

            double dP = this.serviceBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, serviceTargetDistance,CurveType.PERMITTED_SPEED);
            double dI = this.serviceBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, serviceTargetDistance,CurveType.INDICATION_CURVE);
            double dW = this.serviceBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed, serviceTargetDistance,CurveType.WARNING_CURVE);

            if(curSpeed > releaseSpeed && curSpeed <= vMRSP && estimatedFrontEnd > dI && estimatedFrontEnd <= dP){//t4
                this.curSpeedInterventionLevel = SpeedInterventionLevel.OVERSPEED;
            }
            if(curSpeed > vMRSP && curSpeed <= vMRSP_dw && estimatedFrontEnd > dI && estimatedFrontEnd <= dW){//t6
                this.curSpeedInterventionLevel = SpeedInterventionLevel.OVERSPEED;
            }
        }
        else {
            double vMRSP = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.PERMITTED_SPEED);
            double vMRSP_dw = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.WARNING_CURVE);

            double dP = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed,this.targetDistance,CurveType.PERMITTED_SPEED);
            double dI = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed,this.targetDistance,CurveType.INDICATION_CURVE);
            double dW = this.emergencyBreakingCurve.getDistanceSpeedAlwaysLower(curSpeed,this.targetDistance,CurveType.WARNING_CURVE);

            if(curSpeed > releaseSpeed && curSpeed <= vMRSP && maxSafeFrontEnd > dI && maxSafeFrontEnd <= dP){//t4
                this.curSpeedInterventionLevel = SpeedInterventionLevel.OVERSPEED;
            }
            if(curSpeed > vMRSP && curSpeed <= vMRSP_dw && maxSafeFrontEnd > dI && maxSafeFrontEnd <= dW){//t6
                this.curSpeedInterventionLevel = SpeedInterventionLevel.OVERSPEED;
            }

        }
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
     * @param estimatedFrontEnd in [m]
     */
    private void csmServiceBreakIntervention(double curSpeed, double estimatedFrontEnd){
        double vMRSP = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.PERMITTED_SPEED);
        if(curSpeed <= vMRSP) this.curSpeedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
    }

    /**
     * See SRS 026 3.13.10.4 Table 7 and Table 6
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#NO_INTERVENTION} if revocation condition [1]
     * is fulfilled<br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS} or {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * if triggering condition [4] or [5] are fulfilled, respectively. <br>
     * @param curSpeed current Speed in [m/s]
     * @param estimatedFrontEnd in [m]
     */
    private void csmWarning(double curSpeed, double estimatedFrontEnd){
        double vMRSP_dEBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.EMERGENCY_INTERVENTION_CURVE);
        double vMRSP_dSBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.SERVICE_INTERVENTION_CURVE_2);
        double vMRSP = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.PERMITTED_SPEED);

        if(curSpeed > vMRSP_dEBI) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        else if(curSpeed > vMRSP_dSBI) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
        else if(curSpeed <= vMRSP) this.curSpeedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
    }

    /**
     * See SRS 026 3.13.10.4 Table 7 and Table 6
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#NO_INTERVENTION} if revocation condition [1]
     * is fulfilled<br>
     * Sets curSpeedInterventionLevel to {@link SpeedInterventionLevel#APPLY_SERVICE_BREAKS} or {@link SpeedInterventionLevel#APPLY_EMERGENCY_BREAKS}
     * if triggering condition [4] or [5] are fulfilled, respectively. <br>
     * Sets urSpeedInterventionLevel to {@link SpeedInterventionLevel#WARNING} if triggering condition [3] is fulfilled. <br>
     * @param curSpeed current Speed in [m/s]
     * @param estimatedFrontEnd in [m]
     */
    private void csmOverspeed(double curSpeed, double estimatedFrontEnd){
        double vMRSP_dEBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.EMERGENCY_INTERVENTION_CURVE);
        double vMRSP_dSBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.SERVICE_INTERVENTION_CURVE_2);
        double vMRSP_dW = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.WARNING_CURVE);
        double vMRSP = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.PERMITTED_SPEED);

        if(curSpeed > vMRSP_dEBI) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        else if(curSpeed > vMRSP_dSBI) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
        else if(curSpeed > vMRSP_dW) this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
        else if(curSpeed <= vMRSP) this.curSpeedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
    }

    private void csmIndicationAndNoIntervention(double curSpeed, double estimatedFrontEnd){
        double vMRSP_dEBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.EMERGENCY_INTERVENTION_CURVE);
        double vMRSP_dSBI = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.SERVICE_INTERVENTION_CURVE_2);
        double vMRSP_dW = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.WARNING_CURVE);
        double vMRSP = this.emergencyBreakingCurve.getVmrspAtDistance(estimatedFrontEnd, CurveType.PERMITTED_SPEED);

        if(curSpeed > vMRSP_dEBI) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS;
        else if(curSpeed > vMRSP_dSBI) this.curSpeedInterventionLevel = SpeedInterventionLevel.APPLY_SERVICE_BREAKS;
        else if(curSpeed > vMRSP_dW) this.curSpeedInterventionLevel = SpeedInterventionLevel.WARNING;
        else if(curSpeed > vMRSP) this.curSpeedInterventionLevel = SpeedInterventionLevel.OVERSPEED;
        else if(curSpeed <= vMRSP) this.curSpeedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
    }

}
