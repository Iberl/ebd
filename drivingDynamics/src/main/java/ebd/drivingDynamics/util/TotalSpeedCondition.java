package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

import java.util.function.BiFunction;

public class TotalSpeedCondition extends Condition {

    private Double speedTotal;
    private BiFunction<Double,Double, Boolean> comparator;

    public TotalSpeedCondition(JSONObject jsonObject) throws DDBadDataException {
        fromJSON(jsonObject);
    }

    @Override
    public boolean eval() {
        //TODO add connection to TRD
        double tempCur = 20;

        return comparator.apply(tempCur,speedTotal);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){
            speedTotal = (Double)jsonObject.get("value") / 100;

            if(speedTotal < 0 || speedTotal > 1){
                throw new DDBadDataException("TotalSpeedCondition Value was not in the range [0, 100]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a TotalSpeedCondition");

        if(jsonObject.keySet().contains("op")){
            String temp = (String)jsonObject.get("op");
            switch (temp){
                case "<":
                    comparator = (Double speedTotal,Double speedMax) -> (speedTotal < speedMax);
                    break;
                case "<=":
                    comparator = (Double speedTotal,Double speedMax) -> (speedTotal <= speedMax);
                    break;
                case ">=":
                    comparator = (Double speedTotal,Double speedMax) -> (speedTotal >= speedMax);
                    break;
                case ">":
                    comparator = (Double speedTotal,Double speedMax) -> (speedTotal > speedMax);
                    break;
                default:
                    throw new DDBadDataException("Unexpected op parameter for TotalSpeedCondition: " + temp);
            }
        }
        else throw new DDBadDataException("The key 'op' was missing for a TotalSpeedCondition");
    }
}
