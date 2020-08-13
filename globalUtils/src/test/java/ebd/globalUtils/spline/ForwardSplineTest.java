package ebd.globalUtils.spline;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ForwardSplineTest {

    static ForwardSpline bs0;
    static ForwardSpline bs1;

    static Knot a = new Knot (0,0);
    static Knot b = new Knot (1,1);
    static Knot c = new Knot (2,2);


    static Knot aa;
    static Knot bb;
    static Knot cc;


    @BeforeAll
    static void newSpline(){
        bs0 = new ForwardSpline(0);
        bs1 = new ForwardSpline(1);
        ArrayList<Double> coefflist = new ArrayList<>(2);
        coefflist.add(0d);
        coefflist.add(0d);

        aa = new Knot(0d,coefflist);

        coefflist = new ArrayList<>(2);
        coefflist.add(1d);
        coefflist.add(1d);

        bb = new Knot(1d, coefflist);

        coefflist = new ArrayList<>(2);
        coefflist.add(2d);
        coefflist.add(2d);

        cc = new Knot(2d, coefflist);

        bs0.addKnotToCurve(a);
        bs0.addKnotToCurve(b);
        bs0.addKnotToCurve(c);

        bs1.addKnotToCurve(aa);
        bs1.addKnotToCurve(bb);
        bs1.addKnotToCurve(cc);
    }


    void addKnotToCurve() {
        ForwardSpline bs01 = new ForwardSpline(0);
        bs01.addKnotToCurve(a);
        bs01.addKnotToCurve(new Knot(3d,2d));

        assertEquals(0d,bs0.getLowestXValue());
        assertEquals(0d,bs01.getLowestXValue());
    }


    void getPointOnCurve() {

        assertEquals(0d,bs0.getPointOnCurve(0d));
        assertEquals(0d,bs0.getPointOnCurve(0.5));
        assertEquals(0d,bs0.getPointOnCurve(1d));
        assertEquals(1d,bs0.getPointOnCurve(2d));
        assertEquals(2d,bs0.getPointOnCurve(3d));

        assertEquals(0d,bs1.getPointOnCurve(0.5));
        assertEquals(1.5,bs1.getPointOnCurve(1.5));

    }




    void getIntervallBoundariesOfPoint() {

        ArrayList result = bs0.getIntervallBoundariesOfPoint(0.5);
        assertEquals(0d, result.get(0));
        assertEquals(1d, result.get(1));

        result = bs0.getIntervallBoundariesOfPoint(1d);
        assertEquals(1d, result.get(0));
        assertEquals(2d, result.get(1));
    }


    void getHighestXValue() {

        assertEquals(0d,bs0.getLowestXValue());
        assertEquals(0d,bs1.getLowestXValue());
    }


    void getHigherOrLastKnotXValue() {

        assertEquals(0d,bs1.getLowerOrFirstKnotXValue(1d));
        assertEquals(0d,bs1.getLowerOrFirstKnotXValue(0d));

    }
}