package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

public class ActionParser {

    /**
     * Builds an action out of a {@link JSONObject}. The action built is chosen by the type value.<br>
     * <b>All implemented conditions have to be registered in this function by including them into the switch statement</b>
     *
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus the local {@link EventBus}
     * @return The correct {@link Action}
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public static Action parse(JSONObject jsonObject, EventBus localEventBus) throws DDBadDataException {

        if(jsonObject.containsKey("type") && jsonObject.containsKey("action")) {
            String actionType = (String)jsonObject.get("type");
            JSONObject actionObject = (JSONObject)jsonObject.get("action");

            switch (actionType) {
                case "v_acc":
                    return new AccelerationAction(actionObject, localEventBus);
                case "v_break":
                    return new BreakAction(actionObject, localEventBus);
                case "v_cruise":
                    return new CruiseAction(actionObject, localEventBus);
                case "v_coast":
                    return new CoastAction(actionObject, localEventBus);
                case "v_halt":
                    return new HaltAction(actionObject, localEventBus);
                default:
                    throw new DDBadDataException("A action was not formatted correctly: " + jsonObject.toString());
            }
        }
        else {
            throw new DDBadDataException("A action was not formatted correctly: " + jsonObject.toString());
        }
    }
}
