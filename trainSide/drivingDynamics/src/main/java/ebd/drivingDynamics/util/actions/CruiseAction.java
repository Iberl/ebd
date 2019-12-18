package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * This action sets the train into cruise state. In this state, the train does apply just enough power to either
 * acceleration or deceleration to keep the speed constant.
 */
public class CruiseAction extends Action {

    /**
     * This action sets the train into cruise state. In this state, the train does apply just enough power to either
     * acceleration or deceleration to keep the speed constant.
     *
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus the local {@link EventBus}
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public CruiseAction(JSONObject jsonObject, EventBus localEventBus, int priority) throws DDBadDataException {
        super(localEventBus, priority);
        fromJSON(jsonObject);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.containsKey("conditions")){
            conditionsFromJSON((JSONObject)jsonObject.get("conditions"));

        }
        else throw new DDBadDataException("The key 'conditions' was missing for a CruiseAction");
    }
}
