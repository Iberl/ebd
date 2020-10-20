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

        if(jsonObject.containsKey("type") && jsonObject.containsKey("action") && jsonObject.containsKey("priority")) {
            String actionType = (String)jsonObject.get("type");
            JSONObject actionObject = (JSONObject)jsonObject.get("action");

            double priorityValue;
            Object tempObject = jsonObject.get("priority");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                priorityValue = ((Long)tempObject).doubleValue(); //To [m/s]
            }
            else if(tempObjectName.equals("Double")){
                priorityValue = (Double)tempObject; //To [m/s]
            }
            else throw new DDBadDataException("Action priority was not a number");

            int priority = (int)priorityValue;

            switch (actionType) {
                case "v_acc":
                    return new AccelerationAction(actionObject, localEventBus, priority);
                case "v_break":
                    return new BreakAction(actionObject, localEventBus, priority);
                case "v_cruise":
                    return new CruiseAction(actionObject, localEventBus, priority);
                case "v_coast":
                    return new CoastAction(actionObject, localEventBus, priority);
                case "v_halt":
                    return new HaltAction(actionObject, localEventBus, priority);
                default:
                    throw new DDBadDataException("A action was not formatted correctly: " + jsonObject.toString());
            }
        }
        else {
            throw new DDBadDataException("A action was not formatted correctly: " + jsonObject.toString());
        }
    }
}
