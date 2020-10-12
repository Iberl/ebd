package ebd.trainStatusManager.util.supervisors;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.breakingCurveType.CurveType;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.trainStatusMananger.ReleaseSpeedModeStateEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;

public class SpeedUpdateSupervisor {

    private final EventBus localEventBus;
    private final TrainDataVolatile trainDataVolatile;
    private String tdTarget = "td";

    private BreakingCurve emergencyBC = null;
    private BreakingCurve serviceBC = null;
    private BreakingCurve normalBC = null;

    private double maxEmergencyDistance = 0;
    private double maxServiceDistance = 0;
    private double maxNormalDistance = 0;

    private double releaseSpeed;
    private double releaseDistance;
    private double targetSpeedDistance;
    private double targetSpeed;

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
        sendCurrentMaxSpeed(curDistance);
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
    public void releaseSpeedEvent(ReleaseSpeedModeStateEvent rsmse){
        this.releaseSpeed = rsmse.curReleaseSpeed;
        this.releaseDistance = rsmse.releaseDistance;
    }

    /**
     * Send current max speeds of all curves to {@link TrainDataVolatile}
     */
    private void sendCurrentMaxSpeed(double curDistance) {

        double maxEmergencyInterventionSpeed = this.emergencyBC.getSpeedAtDistance(curDistance, CurveType.EMERGENCY_INTERVENTION_CURVE);
        double maxServiceIntervention2Speed = this.emergencyBC.getSpeedAtDistance(curDistance, CurveType.SERVICE_INTERVENTION_CURVE_2);
        double maxServiceIntervention1Speed = this.serviceBC.getSpeedAtDistance(curDistance, CurveType.SERVICE_INTERVENTION_CURVE_1);
        double maxNormalSpeed = this.normalBC.getSpeedAtDistance(curDistance, CurveType.NORMAL_INTERVENTION_CURVE);
        double maxPermittedSpeed = this.emergencyBC.getSpeedAtDistance(curDistance, CurveType.PERMITTED_SPEED);
        double maxWarningSpeed = this.emergencyBC.getSpeedAtDistance(curDistance, CurveType.WARNING_CURVE);
        double maxIndicationSpeed = this.emergencyBC.getSpeedAtDistance(curDistance, CurveType.INDICATION_CURVE);
        double maxC30Speed = this.serviceBC.getSpeedAtDistance(curDistance, CurveType.C30_CURVE);

        HashMap<String, Object> updateMap = new HashMap<>();
        updateMap.put("currentMaximumSpeed", maxPermittedSpeed);
        updateMap.put("currentEmergencyInterventionSpeed", maxEmergencyInterventionSpeed);
        updateMap.put("currentServiceIntervention2Speed", maxServiceIntervention2Speed);
        updateMap.put("currentServiceIntervention1Speed", maxServiceIntervention1Speed);
        updateMap.put("currentNormalSpeed", maxNormalSpeed);
        updateMap.put("currentWarningSpeed", maxWarningSpeed);
        updateMap.put("currentIndicationSpeed", maxIndicationSpeed);
        updateMap.put("currentCoastingPhaseSpeed", maxC30Speed);
        updateMap.put("targetSpeed", targetSpeed);
        updateMap.put("currentApplicableReleaseSpeed",this.releaseSpeed);

        this.localEventBus.post(new TrainDataMultiChangeEvent("ssm", this.tdTarget, updateMap));
    }

    private void findTargetSpeedAndDistance(double curTripDistance) {
        this.targetSpeedDistance = this.emergencyBC.nextTargetDistance(curTripDistance);
        //Check for supervised target "release speed"
        if(curTripDistance < this.releaseDistance && this.targetSpeedDistance > this.releaseDistance){
            this.targetSpeedDistance = this.releaseDistance;
            this.targetSpeed = this.releaseSpeed;
        }
        else this.targetSpeed = this.emergencyBC.getSpeedAtDistance(this.targetSpeedDistance, CurveType.PERMITTED_SPEED);
    }

}
