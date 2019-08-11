package ebd.drivingDynamics.util;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;

import java.util.function.BiFunction;

public class ComparisonSelector {

    public static BiFunction<Double,Double,Boolean> comparisonSelector(String opString) throws DDBadDataException {
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
