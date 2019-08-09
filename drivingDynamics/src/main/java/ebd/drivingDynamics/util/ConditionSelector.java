package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

public class ConditionSelector {

    public static Condition select(JSONObject jsonObject) throws DDBadDataException {

        if(jsonObject.containsKey("v_rel")){
            return new RelativeSpeedCondition((JSONObject) jsonObject.get("v_rel"));
        }
        else if(jsonObject.containsKey("v")){
            return new TotalSpeedCondition((JSONObject) jsonObject.get("v"));
        }
        else {
            throw new DDBadDataException("A condition was not formatted correctly: " + jsonObject.toString());
        }

    }
}
