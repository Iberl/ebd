package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;

import java.util.function.BiFunction;

public class ComparisonParser {

    public static BiFunction<Double,Double,Boolean> parse(String opString) throws DDBadDataException {
        switch (opString){
            case "<":
                return (Double x, Double y) -> (x < y);
            case "<=":
                return (Double x, Double y) -> (x <= y);
            case ">=":
                return (Double x, Double y) -> (x >= y);
            case ">":
                return (Double x, Double y) -> (x > y);
            default:
                throw new DDBadDataException("Unexpected op parameter for RelativeSpeedCondition: " + opString);
        }

    }
}
