package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * This action accelerates the train. The power by which the train should be accelerated can be modified by the
 * acceleration percentage.
 *
 *<p>The <b>type</b> of this action is "v_acc"</p>
 *<p>The <b>priority</b> of this action is 0 to Integer.MAX, lower values mean higher priorities and are evaluated first</p>
 *<p>The <b>action</b> of this action contains the inner values</p>
 *<p>The <b>value</b> of this action is in the range 0 % to 100 % and modifies the acceleration power</p>
 *<p>The <b>conditions</b> of this action contains the conditions under which this action is taken</p>
 *
 * <p>Example: The train should accelerate with 80 % when the conditions evaluate to true:
 * The full JSON string would look like this:<br>
 *     {"type": "v_break", "priority": 0, action: {"value": 80, "condition": {--conditions--}}}<br>
 *      The value of "action" is passed to the constructor<br></p>
 * @author Lars Schulze-Falck
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
