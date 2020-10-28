package ebd.trainData.util.availableAcceleration;


import ebd.globalUtils.enums.BreaksType;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Knot;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import org.greenrobot.eventbus.EventBus;

public class BreakingPowerCurveCalculator {

    public static ForwardSpline calculateNormalBreakingPower(EventBus eventBus){
        ForwardSpline breakingPowerCurve = new ForwardSpline(3, "NormalBreakingPower");
        TrainDataPerma trainDataPerma = eventBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;

        //TODO fill with math
        //TODO Respect multiple cars
        //TODO Respect train type
        BreaksType chosenBreakingMethod = trainDataPerma.getTrainCarList().get(0).getChosenBreakingMethod();
        double deceleration = 0;
        switch (chosenBreakingMethod){
            case G -> deceleration = 0.15;
            case P -> deceleration = 0.6;
            case P_E -> deceleration = 0.7;
            case P_MG -> deceleration = 0.7;
            case R -> deceleration = 0.8;
            case R_E -> deceleration = 1.05;
            case R_MG -> deceleration = 1;
            case R_WB -> deceleration = 1;
            case BREAK_CALCULATOR -> deceleration = 1.1;
        }
        if(deceleration == 0) System.err.println("Missed a case in BreakingPowerCurveCalculator");
        breakingPowerCurve.addKnotToCurve(new Knot(0d, new double[]{deceleration,0,0,0}));

        return breakingPowerCurve;
    }

    public static ForwardSpline calculateServiceBreakingPower(EventBus eventBus){
        ForwardSpline breakingPowerCurve = new ForwardSpline(3, "ServiceBreakingPower");
        TrainDataPerma trainDataPerma = eventBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;

        //TODO fill with math
        //TODO Respect multiple cars
        //TODO Respect train type
        BreaksType chosenBreakingMethod = trainDataPerma.getTrainCarList().get(0).getChosenBreakingMethod();
        double deceleration = 0;
        switch (chosenBreakingMethod){
            case G -> deceleration = 0.4;
            case P -> deceleration = 0.85;
            case P_E -> deceleration = 0.9;
            case P_MG -> deceleration = 0.85;
            case R -> deceleration = 1;
            case R_E -> deceleration = 1.1;
            case R_MG -> deceleration = 1;
            case R_WB -> deceleration = 1.1;
            case BREAK_CALCULATOR -> deceleration = 1.3;
        }
        if(deceleration == 0) System.err.println("Missed a case in BreakingPowerCurveCalculator");
        breakingPowerCurve.addKnotToCurve(new Knot(0d, new double[]{deceleration,0,0,0}));

        return breakingPowerCurve;
    }

    public static ForwardSpline calculateEmergencyBreakingPower(EventBus eventBus){
        ForwardSpline breakingPowerCurve = new ForwardSpline(3, "EmergencyBreakingPower");
        TrainDataPerma trainDataPerma = eventBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;

        //TODO fill with math
        //TODO Respect multiple cars
        //TODO Respect train type
        BreaksType chosenBreakingMethod = trainDataPerma.getTrainCarList().get(0).getChosenBreakingMethod();
        double deceleration = 0;
        switch (chosenBreakingMethod){
            case G -> deceleration = 0.35;
            case P -> deceleration = 0.8;
            case P_E -> deceleration = 0.8;
            case P_MG -> deceleration = 0.9;
            case R -> deceleration = 1;
            case R_E -> deceleration = 1.1;
            case R_MG -> deceleration = 1.2;
            case R_WB -> deceleration = 1.1;
            case BREAK_CALCULATOR -> deceleration = 1.3;
        }
        if(deceleration == 0) System.err.println("Missed a case in BreakingPowerCurveCalculator");
        breakingPowerCurve.addKnotToCurve(new Knot(0d, new double[]{deceleration,0,0,0}));


        return breakingPowerCurve;
    }
}
