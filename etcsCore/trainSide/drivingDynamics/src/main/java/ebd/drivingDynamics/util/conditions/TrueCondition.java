package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.conditions.abstracts.Condition;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * This condition always returns {@code true}.<br>
 * <p>The <b>type</b> of this condition is "true"</p>

 * <p>Example:
 * The full JSON string would look like this:<br>
 *     {"type" : "true", "condition" : {}}<br>
 *      The value of "condition" is passed to the constructor<br></p>
 * @author Lars Schulze-Falck
 */
public class TrueCondition extends Condition {
    /**
     * @param localEventBus The local {@link EventBus} of the train.
     */
    public TrueCondition(EventBus localEventBus) {
        super(localEventBus);
    }


    public TrueCondition(EventBus localEventBus, JSONObject jsonObject){
        super(localEventBus);
    }

    @Override
    public boolean eval() {
        return true;
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        return;
    }
}
