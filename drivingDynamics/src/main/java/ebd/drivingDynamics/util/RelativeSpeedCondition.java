package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

public class RelativeSpeedCondition extends Condition {

    private Double speedPercentage;
    private BiFunction<Double,Double, Boolean> comparator;

    public RelativeSpeedCondition(JSONObject jsonObject) throws DDBadDataException {
        fromJSON(jsonObject);
    }

    @Override
    public boolean eval() {
        double tempMax = 100 * speedPercentage; //TODO add connection to TRD
        double tempCur = 20;

        return comparator.apply(tempCur,tempMax);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){
            speedPercentage = (Double)jsonObject.get("value") / 100;

            if(speedPercentage < 0 || speedPercentage > 1){
                throw new DDBadDataException("RelativeSpeedCondition Value was not in the range [0, 100]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a RelativeSpeedCondition");

        if(jsonObject.keySet().contains("op")){
            String temp = (String)jsonObject.get("op");
            switch (temp){
                case "<":
                    comparator = (Double speedRel,Double speedMax) -> (speedRel < speedMax);
                    break;
                case "<=":
                    comparator = (Double speedRel,Double speedMax) -> (speedRel <= speedMax);
                    break;
                case "==":
                    comparator = (Double speedRel,Double speedMax) -> (speedRel == speedMax);
                    break;
                case ">=":
                    comparator = (Double speedRel,Double speedMax) -> (speedRel >= speedMax);
                    break;
                case ">":
                    comparator = (Double speedRel,Double speedMax) -> (speedRel > speedMax);
                    break;
                default:
                    throw new DDBadDataException("Unexpected op parameter for RelativeSpeedCondition: " + temp);
            }
        }
        else throw new DDBadDataException("The key 'op' was missing for a RelativeSpeedCondition");
    }
}
