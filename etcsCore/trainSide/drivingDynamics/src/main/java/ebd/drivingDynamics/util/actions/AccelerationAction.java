package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * This action accelerates the train. The power by which the train should be accelerated can be modified by the
 * acceleration percentage.
 */
public class AccelerationAction extends Action {


    private double accelerationPercentage;

    /**
     * This action breaks the train.
     *
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus the local {@link EventBus}
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public AccelerationAction(JSONObject jsonObject, EventBus localEventBus, int priority) throws DDBadDataException {
        super(localEventBus, priority);
        fromJSON(jsonObject);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.containsKey("value")){
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

        if(jsonObject.containsKey("conditions")){
            conditionsFromJSON((JSONObject)jsonObject.get("conditions"));

        }
        else throw new DDBadDataException("The key 'conditions' was missing for a AccelerationAction");

    }

    /**
     * @return The acceleration percentage in the range of [0,1] to be used as modifier for the applied
     * acceleration power
     */
    public double getAccelerationPercentage() {
        return accelerationPercentage;
    }
}
