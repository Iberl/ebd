package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;

import java.util.function.BiFunction;

public class ComparisonParser {

    /**
     * This method takes a string containing one of the following strings: "<", "<=", ">=", ">".<br>
     * It returns a BiFunction that is able to compare to values. First parameter of that function is the left side,
     * second parameter the right side of the comparison.
     *
     * @param opString An string describing a comparison:
     * @return A {@link BiFunction} that compares two doubles values using the op string.
     * @throws DDBadDataException Thrown when opString is not formatted correctly
     */
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
