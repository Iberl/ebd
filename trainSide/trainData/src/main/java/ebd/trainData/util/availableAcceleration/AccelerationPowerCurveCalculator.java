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
        
        TrainCar poweredCar = null;
        double trainForce = 0; //in [N]
        double trainWeight = 0; //in [kg]
        //TODO fill with math
        //TODO Respect multiple locomotives
        for(TrainCar tc : trainDataPerma.getTrainCarList()){
            if(tc.getTypeName().equals("Triebzug")){
                poweredCar = tc;
                LocomotiveTrain lt = (LocomotiveTrain)tc;
                if(lt.getTractiveForceAtStart() <= 0){
                    trainForce += lt.getMaxWeight() * 0.30 * 9.81; //Start up force
                }else {
                    trainForce += lt.getTractiveForceAtStart();
                }
            }
            else if(tc.getTypeName().equals("Triebfahrzeug")){
                poweredCar = tc;
                Locomotive l = (Locomotive)tc;
                if(l.getTractiveForceAtStart() <= 0){
                    trainForce += l.getServiceWeight() * 0.30 * 9.81; //Start up force
                }else {
                    trainForce += l.getTractiveForceAtStart();
                }
            }
        }
        if (poweredCar == null){
            throw new IllegalArgumentException("There was no powered train car in this train");
        }

        trainWeight = trainDataPerma.getTrainWeight();
        double trainAcceleration = trainForce / trainWeight;
        accelerationCurve.addKnotToCurve(new Knot(0d, new double[]{trainAcceleration,0,0}));
        accelerationCurve.addKnotToCurve(new Knot(22.22d, new double[]{trainAcceleration,-0.036,0}));//100% power at 40km/h
        accelerationCurve.addKnotToCurve(new Knot(27.78, new double[]{trainAcceleration * 0.8,-0.072,0})); //80% power at 60km/h
        accelerationCurve.addKnotToCurve(new Knot(30.56d, new double[]{trainAcceleration * 0.6,-0.108,0})); //50% power at 90km/h
        accelerationCurve.addKnotToCurve(new Knot(33.33, new double[]{trainAcceleration * 0.3,0,0})); //30% power at 120km/h

        return accelerationCurve;
    }
}
