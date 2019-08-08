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

            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                speedTotal = ((Long)tempObject).doubleValue();
            }
            else if(tempObjectName.equals("Double")){
                speedTotal = (Double)tempObject / 100;
            }
            else throw new DDBadDataException("TotalSpeedCondition value was not a number");

            if(speedTotal < 0 || speedTotal > 600){
                throw new DDBadDataException("TotalSpeedCondition Value was not in the range [0, 600]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a TotalSpeedCondition");

        if(jsonObject.keySet().contains("op")){
            String opCode = (String)jsonObject.get("op");
            this.comparator = ComparisonSelector.comparisonSelector(opCode);
        }
        else throw new DDBadDataException("The key 'op' was missing for a TotalSpeedCondition");
    }
}
