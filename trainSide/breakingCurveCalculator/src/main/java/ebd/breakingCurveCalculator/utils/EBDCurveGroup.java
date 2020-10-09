package ebd.breakingCurveCalculator.utils;

import ebd.globalUtils.breakingCurveType.BreakingCurveType;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.Knot;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * This class includes all curves that are calculated from a Emergency Deceleration Curve.
 */
public class EBDCurveGroup extends CurveGroup{

    private BackwardSpline emergencyBreakingInterventionCurve;
    private BackwardSpline serviceBreakingIntervention2Curve;
    private BackwardSpline warningCurve;
    private BackwardSpline permittedSpeedCurve;
    private BackwardSpline indicationCurve;

    public EBDCurveGroup(List<Knot> ebdKnotList) {
        super("EBD");
        getCurves(ebdKnotList);
    }

    @Override
    public @Nullable BackwardSpline getCurveFromType(BreakingCurveType curveType) {
        return switch (curveType){
            case EMERGENCY_INTERVENTION_CURVE -> emergencyBreakingInterventionCurve;
            case SERVICE_INTERVENTION_CURVE_2 -> serviceBreakingIntervention2Curve;
            case WARNING_CURVE -> warningCurve;
            case PERMITTED_SPEED -> permittedSpeedCurve;
            case INDICATION_CURVE -> indicationCurve;
            default -> null;
        };
    }

    private void getCurves(List<Knot> ebdKnotList) {
        this.emergencyBreakingInterventionCurve = getCurveFromListAndOffset(ebdKnotList, ch.emergencyInterventionOffset);
        this.serviceBreakingIntervention2Curve = getCurveFromListAndOffset(ebdKnotList, ch.serviceInterventionOffset);
        this.warningCurve = getCurveFromListAndOffset(ebdKnotList, ch.warningOffset);
        this.permittedSpeedCurve = getCurveFromListAndOffset(ebdKnotList, ch.permittedOffset);
        this.indicationCurve = getCurveFromListAndOffset(ebdKnotList, ch.indicationOffset);
    }
}
