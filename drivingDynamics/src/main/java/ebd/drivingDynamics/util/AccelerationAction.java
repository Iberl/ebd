package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

public class AccelerationAction extends Action {


    private double accelerationPercentage;

    public AccelerationAction(JSONObject jsonObject) throws DDBadDataException {
        fromJSON(jsonObject);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){
            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                accelerationPercentage = (Long)tempObject;
            }
            else if(tempObjectName.equals("Double")){
                accelerationPercentage = (Double)tempObject;
            }
            else throw new DDBadDataException("AccelerationAction value was not a number");


            if(accelerationPercentage < 0 || accelerationPercentage > 100){
                throw new DDBadDataException("AccelerationAction Value was not in the range [0, 100]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a AccelerationAction");

        if(jsonObject.keySet().contains("conditions")){
            conditionsFromJSON((JSONObject)jsonObject.get("conditions"));

        }
        else throw new DDBadDataException("The key 'conditions' was missing for a AccelerationAction");

    }

    public double getAccelerationPercentage() {
        return accelerationPercentage;
    }
}
