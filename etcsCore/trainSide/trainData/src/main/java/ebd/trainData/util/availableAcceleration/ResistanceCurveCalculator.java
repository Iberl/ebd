package ebd.trainData.util.availableAcceleration;

import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Knot;
import ebd.trainData.TrainDataPerma;
import org.greenrobot.eventbus.EventBus;

public class ResistanceCurveCalculator {

    public static ForwardSpline calculate(EventBus eventBus){
        ForwardSpline resistanceCurve = new ForwardSpline(2);
        TrainDataPerma trainDataPerma = eventBus.getStickyEvent(TrainDataPerma.class);

        //TODO fill with math
        resistanceCurve.addKnotToCurve(new Knot(0d, new double[]{0.0,0,0}));
        resistanceCurve.addKnotToCurve(new Knot(5d, new double[]{0.005,0,0}));
        resistanceCurve.addKnotToCurve(new Knot(10d, new double[]{0.02,0,0}));
        resistanceCurve.addKnotToCurve(new Knot(20d, new double[]{0.04,0,0}));
        resistanceCurve.addKnotToCurve(new Knot(30d, new double[]{0.08,0,0}));
        resistanceCurve.addKnotToCurve(new Knot(40d, new double[]{0.16,0,0}));
        return resistanceCurve;
    }
}
