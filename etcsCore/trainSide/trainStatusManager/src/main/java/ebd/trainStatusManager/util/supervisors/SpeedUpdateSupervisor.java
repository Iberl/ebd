package ebd.trainStatusManager.util.supervisors;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.breakingCurveType.CurveType;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.logger.ToLogDebugEvent;
import ebd.globalUtils.events.speedDistanceSupervision.SsmReportEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;

public class SpeedUpdateSupervisor {

    private final EventBus localEventBus;
    private final TrainDataVolatile trainDataVolatile;


    private BreakingCurve emergencyBC = null;
    private BreakingCurve serviceBC = null;
    private BreakingCurve normalBC = null;

    private double maxEmergencyDistance = 0;
    private double maxServiceDistance = 0;
    private double maxNormalDistance = 0;

    private double releaseSpeed;
    private double releaseDistance;
    private double targetSpeed;
    private double maxEmergencyInterventionSpeed;
    private double maxServiceIntervention2Speed;
    private double maxServiceIntervention1Speed;
    private double maxNormalSpeed;
    private double maxPermittedSpeed;
    private double maxWarningSpeed;
    private double maxIndicationSpeed;
    private double maxC30Speed;

    public SpeedUpdateSupervisor(EventBus localEventBus){
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);

        NewTrainDataVolatileEvent ntdve = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class);
        this.trainDataVolatile = ntdve.trainDataVolatile;
    }

    @Subscribe
    public void clockTick(ClockTickEvent cte){
        if(emergencyBC == null) return;

        double curDistance = trainDataVolatile.getCurTripDistance();

        findTargetSpeedAndDistance(curDistance);
        updateSpeeds(curDistance);
        sendCurrentMaxSpeed();

        if(ConfigHandler.getInstance().debug) logDebug();
    }

    @Subscribe
    public void newBreakingCurve(NewBreakingCurveEvent nbce){
        this.emergencyBC = nbce.emergencyBreakingCurve;
        this.serviceBC = nbce.serviceBreakingCurve;
        this.normalBC = nbce.normalBreakingCurve;

        this.maxEmergencyDistance = this.emergencyBC.endOfDefinedDistance();
        this.maxServiceDistance = this.serviceBC.endOfDefinedDistance();
        this.maxNormalDistance = this.normalBC.endOfDefinedDistance();
    }

    @Subscribe
    public void releaseSpeedEvent(SsmReportEvent sre){
        this.releaseSpeed = sre.releaseSpeed;
        this.releaseDistance = sre.releaseDistance;
    }

    /**
     * Send current max speeds of all curves to {@link TrainDataVolatile}
     */
    private void sendCurrentMaxSpeed() {

        HashMap<String, Object> updateMap = new HashMap<>();
        updateMap.put("currentMaximumSpeed", this.maxPermittedSpeed);
        updateMap.put("currentEmergencyInterventionSpeed", this.maxEmergencyInterventionSpeed);
        updateMap.put("currentServiceIntervention2Speed", this.maxServiceIntervention2Speed);
        updateMap.put("currentServiceIntervention1Speed", this.maxServiceIntervention1Speed);
        updateMap.put("currentNormalInterventionSpeed", this.maxNormalSpeed);
        updateMap.put("currentWarningSpeed", this.maxWarningSpeed);
        updateMap.put("currentIndicationSpeed", this.maxIndicationSpeed);
        updateMap.put("currentCoastingPhaseSpeed", this.maxC30Speed);
        updateMap.put("targetSpeed", this.targetSpeed);
        updateMap.put("currentApplicableReleaseSpeed",this.releaseSpeed);

        this.localEventBus.post(new TrainDataMultiChangeEvent("ssm", "td", updateMap));
    }

    private void updateSpeeds(double curDistance) {
        this.maxEmergencyInterventionSpeed = 0;
        this.maxServiceIntervention2Speed = 0;
        this.maxServiceIntervention1Speed = 0;
        this.maxNormalSpeed = 0;
        this.maxPermittedSpeed = 0;
        this.maxWarningSpeed = 0;
        this.maxIndicationSpeed = 0;
        this.maxC30Speed = 0;

        if(curDistance < this.maxEmergencyDistance) {
            this.maxEmergencyInterventionSpeed = this.emergencyBC.getSpeedAtDistance(curDistance, CurveType.EMERGENCY_INTERVENTION_CURVE);
            this.maxServiceIntervention2Speed = this.emergencyBC.getSpeedAtDistance(curDistance, CurveType.SERVICE_INTERVENTION_CURVE_2);
            this.maxPermittedSpeed = this.emergencyBC.getSpeedAtDistance(curDistance, CurveType.PERMITTED_SPEED);
            this.maxWarningSpeed = this.emergencyBC.getSpeedAtDistance(curDistance, CurveType.WARNING_CURVE);
            this.maxIndicationSpeed = this.emergencyBC.getSpeedAtDistance(curDistance, CurveType.INDICATION_CURVE);
        }
        if(curDistance < this.maxServiceDistance){
            this.maxServiceIntervention1Speed = this.serviceBC.getSpeedAtDistance(curDistance, CurveType.SERVICE_INTERVENTION_CURVE_1);
            this.maxC30Speed = this.serviceBC.getSpeedAtDistance(curDistance, CurveType.C30_CURVE);
        }
        if(curDistance < this.maxNormalDistance){
            this.maxNormalSpeed = this.normalBC.getSpeedAtDistance(curDistance, CurveType.NORMAL_INTERVENTION_CURVE);
        }
    }

    private void logDebug(){
        String msg = "Max V in m/s. ";
        String msg2 = String.format("ebi: %3.2f,sbi2: %3.2f,sbi1: %3.2f, nbi: %3.2f," +
                        "w: %3.2f, p: %3.2f, i: %3.2f, c30: %3.2f, t: %3.2f,r: %3.2f,",
                this.maxEmergencyInterventionSpeed,
                this.maxServiceIntervention2Speed,
                this.maxServiceIntervention1Speed,
                this.maxNormalSpeed,
                this.maxWarningSpeed,
                this.maxPermittedSpeed,
                this.maxIndicationSpeed,
                this.maxC30Speed,
                this.targetSpeed,
                this.releaseSpeed);
        this.localEventBus.post(new ToLogDebugEvent("dd", "log", msg + msg2));
    }

    private void findTargetSpeedAndDistance(double curTripDistance) {
        double targetSpeedDistance = this.emergencyBC.nextTargetDistance(curTripDistance);
        //Check for supervised target "release speed"
        if(curTripDistance < this.releaseDistance && targetSpeedDistance > this.releaseDistance){
            targetSpeedDistance = this.releaseDistance;
            this.targetSpeed = this.releaseSpeed;
        }
        else this.targetSpeed = this.emergencyBC.getSpeedAtDistance(targetSpeedDistance, CurveType.PERMITTED_SPEED);
    }

}
