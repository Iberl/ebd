package ebd.breakingCurveCalculator.utils;

import ebd.globalUtils.breakingCurveType.BreakingCurveType;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.Knot;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * This class includes all curves that are calculated from a Service Deceleration Curve.
 */
public class SBDCurveGroup extends CurveGroup{

    private BackwardSpline emergencyBreakingInterventionCurve;
    private BackwardSpline serviceBreakingIntervention2Curve;
    private BackwardSpline warningCurve;
    private BackwardSpline permittedSpeedCurve;
    private BackwardSpline indicationCurve;
    private BackwardSpline c30Curve;

    public SBDCurveGroup(List<Knot> sbdKnotList) {
        super("SBD");
        getCurves(sbdKnotList);
    }

    @Override
    public @Nullable BackwardSpline getCurveFromType(BreakingCurveType curveType) {
        return switch (curveType){
            case EMERGENCY_INTERVENTION_CURVE -> emergencyBreakingInterventionCurve;
            case SERVICE_INTERVENTION_CURVE_2 -> serviceBreakingIntervention2Curve;
            case WARNING_CURVE -> warningCurve;
            case PERMITTED_SPEED -> permittedSpeedCurve;
            case INDICATION_CURVE -> indicationCurve;
            case C30_CURVE -> c30Curve;
            default -> null;
        };
    }

    private void getCurves(List<Knot> sbdKnotList) {
        this.emergencyBreakingInterventionCurve = getCurveFromListAndOffset(sbdKnotList, ch.emergencyInterventionOffset);
        this.serviceBreakingIntervention2Curve = getCurveFromListAndOffset(sbdKnotList, ch.serviceInterventionOffset);
        this.warningCurve = getCurveFromListAndOffset(sbdKnotList, ch.warningOffset);
        this.permittedSpeedCurve = getCurveFromListAndOffset(sbdKnotList, ch.permittedOffset);
        this.indicationCurve = getCurveFromListAndOffset(sbdKnotList, ch.indicationOffset);
        this.c30Curve = getCurveFromListAndOffset(sbdKnotList, ch.coastingPhaseOffset);
    }
}
