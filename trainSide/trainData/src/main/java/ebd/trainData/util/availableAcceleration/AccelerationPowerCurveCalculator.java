package ebd.trainData.util.availableAcceleration;

import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Knot;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.util.dataConstructs.Locomotive;
import ebd.trainData.util.dataConstructs.LocomotiveTrain;
import ebd.trainData.util.dataConstructs.TrainCar;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import org.greenrobot.eventbus.EventBus;

public class AccelerationPowerCurveCalculator {

    public static ForwardSpline calculate(EventBus eventBus){
        ForwardSpline accelerationCurve = new ForwardSpline(2);
        TrainDataPerma trainDataPerma = eventBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;

        boolean locomotiveTrain = false;
        TrainCar poweredCar = null;
        double trainForce = 0; //in [N]
        double trainWeight = 0; //in [kg]
        //TODO fill with math
        //TODO Respect multiple locomotives
        if(trainDataPerma.getTrainCarList().isEmpty()){
            System.out.println(trainDataPerma.getName());
        }
        for(TrainCar tc : trainDataPerma.getTrainCarList()){
            if(tc.getTypeName().equals("Triebzug")){
                locomotiveTrain = true;
                poweredCar = tc;
                LocomotiveTrain lt = (LocomotiveTrain)tc;
                trainForce += lt.getTractiveForceAtStart();
            }
            else if(tc.getTypeName().equals("Triebfahrzeug")){
                poweredCar = tc;
                Locomotive l = (Locomotive)tc;
                trainForce += l.getTractiveForceAtStart();
            }
        }
        if (poweredCar == null){
            throw new IllegalArgumentException("There was no powered train car in this train");
        }
        trainWeight = trainDataPerma.getTrainWeight();
        double trainAcceleration = trainForce / trainWeight;
        accelerationCurve.addKnotToCurve(new Knot(0d, new double[]{trainAcceleration,0,0})); //huge oversimplification!

        return accelerationCurve;
    }
}
