package ebd.breakingCurveCalculator.utils;

import ebd.globalUtils.breakingCurveType.CurveType;
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
    public @Nullable BackwardSpline getCurveFromType(CurveType curveType) {
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
        this.emergencyBreakingInterventionCurve = getCurveFromListAndOffset("ebi", ebdKnotList, ch.emergencyInterventionOffset);
        this.serviceBreakingIntervention2Curve = getCurveFromListAndOffset("sbi2", ebdKnotList, ch.serviceInterventionOffset);
        this.warningCurve = getCurveFromListAndOffset("ebd_w", ebdKnotList, ch.warningOffset);
        this.permittedSpeedCurve = getCurveFromListAndOffset("ebd_p", ebdKnotList, ch.permittedOffset);
        this.indicationCurve = getCurveFromListAndOffset("ebd_i", ebdKnotList, ch.indicationOffset);
    }
}
