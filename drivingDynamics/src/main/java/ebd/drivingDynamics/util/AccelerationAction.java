package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

public class AccelerationAction extends Action {

    private double accelerationPercentage;



    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){
            accelerationPercentage = (Double)jsonObject.get("value") / 100;

            if(accelerationPercentage < 0 || accelerationPercentage > 1){
                throw new DDBadDataException("AccelerationAction Value was not in the range [0, 100]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a AccelerationAction");

        if(jsonObject.keySet().contains("orBlock")){
            JSONObject tempJSON = (JSONObject)jsonObject.get("orBlock");
            orBlock = new OrBlock(tempJSON);
        }
        else throw new DDBadDataException("The key 'orBlock' was missing for a AccelerationAction");

    }

    @Override
    public boolean eval() {
        return orBlock.eval();
    }
}
