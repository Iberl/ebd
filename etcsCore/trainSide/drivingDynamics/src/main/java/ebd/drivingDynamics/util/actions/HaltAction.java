package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * This action sets the train into halt state. In this state, the train is standing still and not allowed to move.
 *<p>The <b>type</b> of this action is "v_halt"</p>
 *<p>The <b>priority</b> of this action is 0 to Integer.MAX, lower values mean higher priorities and are evaluated first</p>
 *<p>The <b>action</b> of this action contains the inner values</p>
 *<p>The <b>conditions</b> of this action contains the conditions under which this action is taken</p>
 *
 * <p>Example: The train should stand still when the conditions evaluate to true:
 * The full JSON string would look like this:<br>
 *     {"type" : "v_cruise", "priority": 0, action : {"condition" : {--conditions--}}}<br>
 *      The value of "action" is passed to the constructor<br></p>
 */

public class HaltAction extends Action {

    /**
     * This action sets the train into halt state. In this state, the train is standing still and not allowed to move.
     *
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus the local {@link EventBus}
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public HaltAction(JSONObject jsonObject, EventBus localEventBus, int priority) throws DDBadDataException {
        super(localEventBus, priority);
        fromJSON(jsonObject);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.containsKey("conditions")){
            conditionsFromJSON((JSONObject)jsonObject.get("conditions"));

        }
        else throw new DDBadDataException("The key 'conditions' was missing for a HaltAction");
    }
}
