package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * Base class for all conditions and condition blocks. Access to the local {@link EventBus} is necessary, so conditions
 * can check the state of the train and evaluate them self.
 */
abstract public class Condition {

    protected EventBus localEventBus;

    /**
     *
     * @param localEventBus The local {@link EventBus} of the train.
     */
    public Condition(EventBus localEventBus){
        this.localEventBus = localEventBus;
    }

    /**
     * Evaluates the condition
     * @return true if the condition is fulfilled, false if not.
     */
    abstract public boolean eval();

    /**
     * Builds the condition out of a {@link JSONObject}
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    abstract protected void fromJSON (JSONObject jsonObject) throws DDBadDataException;
}
