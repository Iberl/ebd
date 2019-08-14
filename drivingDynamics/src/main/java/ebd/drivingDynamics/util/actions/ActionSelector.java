package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

public class ActionSelector {

    public static Action select(JSONObject jsonObject, EventBus eventBus) throws DDBadDataException {

        if(jsonObject.containsKey("v_acc")){
            return new AccelerationAction((JSONObject) jsonObject.get("v_acc"), eventBus);
        }
        else if(jsonObject.containsKey("v_break")){
            return new BreakAction((JSONObject) jsonObject.get("v_break"), eventBus);
        }
        else if(jsonObject.containsKey("v_cruise")){
            return new CruiseAction((JSONObject) jsonObject.get("v_cruise"), eventBus);
        }
        else if(jsonObject.containsKey("v_halt")){
            return new HaltAction((JSONObject) jsonObject.get("v_halt"), eventBus);
        }
        else {
            throw new DDBadDataException("A action was not formatted correctly: " + jsonObject.toString());
        }

    }
}
