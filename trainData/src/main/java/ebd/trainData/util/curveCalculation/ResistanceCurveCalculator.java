package ebd.trainData.util.curveCalculation;

import ebd.globalUtils.spline.ForwardSpline;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;

public class ResistanceCurveCalculator {

    public static ForwardSpline calculate(EventBus eventBus){
        ForwardSpline resistanceCurve = new ForwardSpline(2);
        TrainDataPerma trainDataPerma = eventBus.getStickyEvent(TrainDataPerma.class);
        TrainDataVolatile trainDataVolatile = eventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;

        //TODO fill with math

        return resistanceCurve;
    }
}
