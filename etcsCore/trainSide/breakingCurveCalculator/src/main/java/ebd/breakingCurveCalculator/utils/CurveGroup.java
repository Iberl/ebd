package ebd.breakingCurveCalculator.utils;


import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.globalUtils.enums.CurveType;
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
     * @param curveType A {@link CurveType}
     * @return BackwardSpline or {@code null}
     */
    abstract public @Nullable BackwardSpline getCurveFromType(CurveType curveType);


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
    protected BackwardSpline getCurveFromListAndOffset(String id, List<Knot> knotList, double offset){
        List<Knot> knotListCopy = new ArrayList<>(knotList);
        List<Knot> tempKnotList = new ArrayList<>();

        Knot formerKnot = knotListCopy.remove(0);
        tempKnotList.add(formerKnot);

        for(Knot knot : knotListCopy){
            double speed = knot.coefficients.get(0);
            double newX = knot.xValue - (speed * offset);
            double newSlope;
            if(speed == 0) newSlope = knot.coefficients.get(1);
            else newSlope = (formerKnot.coefficients.get(0) - knot.coefficients.get(0)) / (formerKnot.xValue - newX);

            Knot newKnot = new Knot(newX, new double[]{speed, newSlope});
            tempKnotList.add(newKnot);

            formerKnot = knot;
        }

        //Fixing first knot
        Knot firstKnot = tempKnotList.remove(0);
        double deltaX = firstKnot.xValue - tempKnotList.get(0).xValue;
        double deltaV = firstKnot.coefficients.get(0) - tempKnotList.get(0).coefficients.get(0);
        double newSlope = deltaV/deltaX;
        tempKnotList.add(0, new Knot(firstKnot.xValue, new double[]{firstKnot.coefficients.get(0), newSlope}));

        BackwardSpline curve = new BackwardSpline(1, id);
        for(Knot knot : tempKnotList){
            curve.addKnotToCurve(knot);
        }
        return curve;
    }

}
