package ebd.breakingCurveCalculator.utils;

import ebd.globalUtils.enums.CurveType;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.Knot;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * This class includes all curves that are calculated from a Service Deceleration Curve.
 */
public class SBDCurveGroup extends CurveGroup{

    private BackwardSpline serviceBreakingIntervention1Curve;
    private BackwardSpline warningCurve;
    private BackwardSpline permittedSpeedCurve;
    private BackwardSpline indicationCurve;
    private BackwardSpline c30Curve;

    public SBDCurveGroup(List<Knot> sbdSBI1, List<Knot> sbdW, List<Knot> sbdPS) {
        super("SBD");
        getCurves(sbdSBI1, sbdW, sbdPS);
    }

    @Override
    public @Nullable BackwardSpline getCurveFromType(CurveType curveType) {
        return switch (curveType){
            case SERVICE_INTERVENTION_CURVE_1 -> this.serviceBreakingIntervention1Curve;
            case WARNING_CURVE -> this.warningCurve;
            case PERMITTED_SPEED -> this.permittedSpeedCurve;
            case INDICATION_CURVE -> this.indicationCurve;
            case C30_CURVE -> this.c30Curve;
            default -> null;
        };
    }

    private void getCurves(List<Knot> sbdSBI1, List<Knot> sbdW, List<Knot> sbdPS) {
        this.serviceBreakingIntervention1Curve = getCurveFromListAndOffset("sbi1", sbdSBI1, ch.serviceInterventionOffset);
        this.warningCurve = getCurveFromListAndOffset("sbd_w", sbdW, ch.warningOffset);
        this.permittedSpeedCurve = getCurveFromListAndOffset("sbd_p", sbdPS, ch.permittedOffset);
        this.indicationCurve = getCurveFromListAndOffset("sbd_i", sbdPS, ch.indicationOffset);
        this.c30Curve = getCurveFromListAndOffset("sbd_c30", sbdPS, ch.coastingPhaseOffset);
    }
}
