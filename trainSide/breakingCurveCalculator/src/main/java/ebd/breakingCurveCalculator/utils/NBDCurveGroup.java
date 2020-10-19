package ebd.breakingCurveCalculator.utils;

import ebd.globalUtils.breakingCurveType.CurveType;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.Knot;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * This class includes all curves that are calculated from a Service Deceleration Curve.
 */
public class NBDCurveGroup extends CurveGroup {

    private BackwardSpline normalInterventionBreakingCurve;
    private BackwardSpline permittedSpeedCurve;

    public NBDCurveGroup(List<Knot> nbdKnotList) {
        super("SBD");
        getCurves(nbdKnotList);
    }

    @Override
    public @Nullable BackwardSpline getCurveFromType(CurveType curveType) {
        return switch (curveType){
            case NORMAL_INTERVENTION_CURVE -> normalInterventionBreakingCurve;
            case PERMITTED_SPEED -> permittedSpeedCurve;
            default -> null;
        };
    }

    private void getCurves(List<Knot> nbdKnotList) {
        this.normalInterventionBreakingCurve = getCurveFromListAndOffset("nc", nbdKnotList, 0d);
        this.permittedSpeedCurve = getCurveFromListAndOffset("nbd_p", nbdKnotList, ch.permittedOffset);
    }
}
