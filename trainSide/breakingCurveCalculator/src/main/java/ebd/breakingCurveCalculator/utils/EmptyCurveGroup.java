package ebd.breakingCurveCalculator.utils;

import ebd.globalUtils.breakingCurveType.CurveType;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.Knot;
import org.jetbrains.annotations.Nullable;

public class EmptyCurveGroup extends CurveGroup{

    BackwardSpline zeroCurve;

    public EmptyCurveGroup() {
        super("emptyCurveGroup");
        this.zeroCurve = new BackwardSpline(1);
        zeroCurve.addKnotToCurve(new Knot(0d, new double[]{0d,0d}));
    }

    @Override
    public @Nullable BackwardSpline getCurveFromType(CurveType curveType) {

        return zeroCurve;
    }
}
