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
            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                speedPercentage = (Long)tempObject / 100d;
            }
            else if(tempObjectName.equals("Double")){
                speedPercentage = (Double)tempObject / 100;
            }
            else throw new DDBadDataException("RelativeSpeedCondition value was not a number");

            if(speedPercentage < 0 || speedPercentage > 1){
                throw new DDBadDataException("RelativeSpeedCondition Value was not in the range [0, 100]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a RelativeSpeedCondition");

        if(jsonObject.keySet().contains("op")){
            String opCode = (String)jsonObject.get("op");
            this.comparator = ComparisonSelector.comparisonSelector(opCode);
        }
        else throw new DDBadDataException("The key 'op' was missing for a RelativeSpeedCondition");
    }
}
