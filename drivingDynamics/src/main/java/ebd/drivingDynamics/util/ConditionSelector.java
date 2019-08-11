package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

public class ConditionSelector {

    public static Condition select(JSONObject jsonObject, EventBus eventBus) throws DDBadDataException {

        if(jsonObject.containsKey("v_rel")){
            return new RelativeSpeedCondition((JSONObject) jsonObject.get("v_rel"), eventBus);
        }
        else if(jsonObject.containsKey("v")){
            return new TotalSpeedCondition((JSONObject) jsonObject.get("v"), eventBus);
        }
        else {
            throw new DDBadDataException("A condition was not formatted correctly: " + jsonObject.toString());
        }

    }
}
