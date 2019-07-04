package ebd.globalUtils.spline;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BackwardSplineTest {
    static BackwardSpline bs0;
    static BackwardSpline bs1;

    static Knot a = new Knot (0,0);
    static Knot b = new Knot (1,1);
    static Knot c = new Knot (2,2);


    static Knot aa;
    static Knot bb;
    static Knot cc;


    @BeforeAll
    static void newSpline(){
        bs0 = new BackwardSpline(0);
        bs1 = new BackwardSpline(1);
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

    @Test
    void addKnotToCurve() {
        BackwardSpline bs01 = new BackwardSpline(0);
        bs01.addKnotToCurve(a);
        bs01.addKnotToCurve(new Knot(3d,2d));

        assertEquals(2d,bs0.getHighestXValue());
        assertEquals(3d,bs01.getHighestXValue());
    }

    @Test
    void getPointOnCurve() {

        assertEquals(1d,bs0.getPointOnCurve(0d));
        assertEquals(1d,bs0.getPointOnCurve(0.5));
        assertEquals(2d,bs0.getPointOnCurve(1d));
        assertEquals(2d,bs0.getPointOnCurve(2d));


        assertEquals(0.5d,bs1.getPointOnCurve(0.5));
        assertEquals(1.5,bs1.getPointOnCurve(1.75));

    }



    @Test
    void getIntervallBoundariesOfPoint() {

        ArrayList result = bs0.getIntervallBoundariesOfPoint(0.5);
        assertEquals(0d, result.get(0));
        assertEquals(1d, result.get(1));

        result = bs0.getIntervallBoundariesOfPoint(1d);
        assertEquals(0d, result.get(0));
        assertEquals(1d, result.get(1));
    }

    @Test
    void getHighestXValue() {

        assertEquals(2d,bs0.getHighestXValue());
        assertEquals(2d,bs1.getHighestXValue());
    }

    @Test
    void getHigherOrLastKnotXValue() {

        assertEquals(2d,bs1.getHigherOrLastKnotXValue(1d));
        assertEquals(2d,bs1.getHigherOrLastKnotXValue(2d));

    }
}