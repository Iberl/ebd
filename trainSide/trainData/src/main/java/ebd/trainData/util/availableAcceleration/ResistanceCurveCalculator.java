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
        resistanceCurve.addKnotToCurve(new Knot(0d, new double[]{-0.05,0,0}));
        return resistanceCurve;
    }
}
