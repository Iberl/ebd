package ebd.breakingCurveCalculator.utils;


import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.globalUtils.breakingCurveType.BreakingCurveType;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.Knot;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

abstract public class CurveGroup {

    protected final ConfigHandler ch;
    protected final String id;
    public CurveGroup(String id){
        this.ch = ConfigHandler.getInstance();
        this.id = id;
    }

    /**
     * Returns the @{@link BackwardSpline} that is appropriate to the curve type or {@code null} if no such type exists.
     * @param curveType A {@link BreakingCurveType}
     * @return BackwardSpline or {@code null}
     */
    abstract public @Nullable BackwardSpline getCurveFromType(BreakingCurveType curveType);


    public String getId() {
        return id;
    }

    /**
     *	Calculates a BackwardSpline from a list of Knots and a time offset.
     * @param knotList
     * 		A {@code List<Knot>} to be transformed into a @{@link BreakingCurve}
     * @param offset
     * 		An offset in [s]
     * @return
     * 		A breaking curve made from the shifted knots
     */
    protected BackwardSpline getCurveFromListAndOffset(List<Knot> knotList, double offset){
        List<Knot> knotListCopy = new ArrayList<>(knotList);
        List<Knot> tempKnotList = new ArrayList<>();

        Knot formerKnot = knotListCopy.remove(0);
        tempKnotList.add(formerKnot);

        for(Knot knot : knotListCopy){
            double newX = knot.xValue - (knot.coefficients.get(0) * offset);
            double newSlope = (formerKnot.coefficients.get(0) - knot.coefficients.get(0)) / (formerKnot.xValue - newX);;
            double speed = knot.coefficients.get(0);
            Knot newKnot = new Knot(newX, new double[]{speed, newSlope});
            tempKnotList.add(newKnot);

            formerKnot = knot;
        }

        BackwardSpline curve = new BackwardSpline(1);
        for(Knot knot : tempKnotList){
            curve.addKnotToCurve(knot);
        }
        return curve;
    }

}
