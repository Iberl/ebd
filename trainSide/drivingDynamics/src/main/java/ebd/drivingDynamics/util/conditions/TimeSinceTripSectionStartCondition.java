package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.conditions.abstracts.Condition;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

public class TimeSinceTripSectionStartCondition extends Condition {

    /**
     * @param localEventBus The local {@link EventBus} of the train.
     */
    public TimeSinceTripSectionStartCondition(EventBus localEventBus) {
        super(localEventBus);
    }

    @Override
    public boolean eval() {
        return false;
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {

    }
}
