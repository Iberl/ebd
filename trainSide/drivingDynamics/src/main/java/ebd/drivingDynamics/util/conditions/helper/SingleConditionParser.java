package ebd.drivingDynamics.util.conditions.helper;

import ebd.drivingDynamics.util.conditions.*;
import ebd.drivingDynamics.util.conditions.abstracts.Condition;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

public class SingleConditionParser {

    /**
     * This builds a condition out of a {@link JSONObject}. The action built is chosen by the type value.<br>
     * <b>All implemented conditions with the exception of condition blocks have to be registered in this function
     * by including them into the switch statement.</b>
     *
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus The local {@link EventBus} of the train.
     * @return The appropriate condition
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public static Condition parse(JSONObject jsonObject, EventBus localEventBus) throws DDBadDataException {
        if(jsonObject.containsKey("type") || jsonObject.containsKey("condition")){
            String conType = (String) jsonObject.get("type");
            JSONObject conObj = (JSONObject) jsonObject.get("condition");

            switch (conType) {
                case "v_rel":
                    return new RelativeSpeedCondition(conObj, localEventBus);
                case "v_t_rel":
                    return new RelativeFutureSpeedCondition(conObj,localEventBus);
                case "v":
                    return new TotalSpeedCondition(conObj, localEventBus);
                case "v_m":
                    return new MaxSpeedCondition(conObj,localEventBus);
                case "v_t_m":
                    return new MaxFutureSpeedCondition(conObj,localEventBus);
                case "t_secStart":
                    return new TimeSinceTripSectionStartCondition(conObj, localEventBus);
                case "t_sinceHalt":
                    return new TimeSinceHaltCondition(conObj, localEventBus);
                case "t_atHalt":
                    return new TimeAtHaltCondition(conObj, localEventBus);
                default:
                    throw new DDBadDataException("A condition was not formatted correctly: " + jsonObject.toString());
            }
        }else {
            throw new DDBadDataException("A condition was not formatted correctly: " + jsonObject.toString());
        }
    }
}
