package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.movementState.MovementState;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

public class AccelerationAction extends Action {


    private double accelerationPercentage;

    public AccelerationAction(JSONObject jsonObject, EventBus eventBus) throws DDBadDataException {
        super(eventBus);
        fromJSON(jsonObject);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){
            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                this.accelerationPercentage = (Long)tempObject / 100d;
            }
            else if(tempObjectName.equals("Double")){
                this.accelerationPercentage = (Double)tempObject / 100d;
            }
            else throw new DDBadDataException("AccelerationAction value was not a number");


            if(accelerationPercentage < 0 || accelerationPercentage > 1){
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
