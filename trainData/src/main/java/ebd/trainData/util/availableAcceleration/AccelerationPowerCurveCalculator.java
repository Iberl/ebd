package ebd.trainData.util.availableAcceleration;

import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Knot;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.dataConstructs.TrainCar;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;

public class AccelerationPowerCurveCalculator {

    public static ForwardSpline calculate(EventBus eventBus){
        ForwardSpline accelerationCurve = new ForwardSpline(2);
        TrainDataPerma trainDataPerma = eventBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;

        boolean locomotiveTrain = false;
        TrainCar poweredCar = null;

        //TODO fill with math
        //TODO Respect multiple locomotives
        if(trainDataPerma.getTrainCarList().isEmpty()){
            System.out.println(trainDataPerma.getName());
        }
        for(TrainCar tc : trainDataPerma.getTrainCarList()){
            if(tc.getTypeName().equals("Triebzug")){
                locomotiveTrain = true;
                poweredCar = tc;
            }
            else if(tc.getTypeName().equals("Triebfahrzeug")){
                poweredCar = tc;
            }
        }
        if (poweredCar == null){
            throw new IllegalArgumentException("There was no powered train car in this train");
        }

        accelerationCurve.addKnotToCurve(new Knot(0d, new double[]{0.5,0,0})); //huge oversimplification!

        return accelerationCurve;
    }
}
