package ebd.trainData.util.availableAcceleration;

import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Knot;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.TrainDataExceptionEvent;
import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;
import java.util.List;

public class BreakingPowerCurveCalculator {

    public static ForwardSpline calculateBreakingPower(EventBus eventBus){
        ForwardSpline breakingPowerCurve = new ForwardSpline(3);
        TrainDataPerma trainDataPerma = eventBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;

        //TODO fill with math
        //TODO Respect multiple cars
        //TODO Respect train type
        String chosenBreakingMethod = trainDataPerma.getTrainCarList().get(0).getChosenBreakingMethod();
        chosenBreakingMethod = chosenBreakingMethod.toLowerCase();
        double deceleration = 0.35;
        if(chosenBreakingMethod.contains("g")){
            deceleration = 0.35;
        }
        else if(chosenBreakingMethod.contains("p")){
            deceleration = 0.8;
        }
        else if(chosenBreakingMethod.contains("r")){
            deceleration = 1;
        }
        else if(chosenBreakingMethod.contains("r+mg")){
            deceleration = 1.2;
        }
        else if(chosenBreakingMethod.contains("bremsrechner")){
            deceleration = 1.3;
        }
        else {
            List<String> targets = Arrays.asList(new String[]{"all"});
            IllegalArgumentException iAE = new IllegalArgumentException("Breaking method: " + chosenBreakingMethod + " could not be found, default value will be used");
            TrainDataExceptionEvent exceptionEvent = new TrainDataExceptionEvent("td",targets, new NotCausedByAEvent(), iAE, ExceptionEventTyp.WARNING);
            eventBus.post(exceptionEvent);
        }

        breakingPowerCurve.addKnotToCurve(new Knot(0d, new double[]{deceleration,0,0,0}));

        return breakingPowerCurve;
    }
    public static ForwardSpline calculateEmergencyBreakingPower(EventBus eventBus){
        ForwardSpline breakingPowerCurve = new ForwardSpline(3);
        TrainDataPerma trainDataPerma = eventBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;

        //TODO fill with math
        //TODO Respect multiple cars
        //TODO Respect train type
        String chosenBreakingMethod = trainDataPerma.getTrainCarList().get(0).getChosenBreakingMethod(); //Assumes all cars having same breaking method!
        chosenBreakingMethod = chosenBreakingMethod.toLowerCase();
        double deceleration = 0.35;
        if(chosenBreakingMethod.contains("g")){
            deceleration = 0.45;
        }
        else if(chosenBreakingMethod.contains("p")){
            deceleration = 0.9;
        }
        else if(chosenBreakingMethod.contains("r") && !chosenBreakingMethod.contains("+")){
            deceleration = 1.1;
        }
        else if(chosenBreakingMethod.contains("r+mg")){
            deceleration = 1.3;
        }
        else if(chosenBreakingMethod.contains("bremsrechner")){
            deceleration = 1.4;
        }
        else {
            List<String> targets = Arrays.asList(new String[]{"all"});
            IllegalArgumentException iAE = new IllegalArgumentException("Breaking method: " + chosenBreakingMethod + " could not be found, default value will be used");
            TrainDataExceptionEvent exceptionEvent = new TrainDataExceptionEvent("td",targets, new NotCausedByAEvent(), iAE, ExceptionEventTyp.WARNING);
            eventBus.post(exceptionEvent);
        }

        breakingPowerCurve.addKnotToCurve(new Knot(0d, new double[]{deceleration,0,0,0}));


        return breakingPowerCurve;
    }
}
