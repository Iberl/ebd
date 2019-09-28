package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

abstract public class Condition {

    protected EventBus localEventBus;

    public Condition(EventBus eventBus){
        this.localEventBus = eventBus;
    }

    abstract public boolean eval();

    abstract protected void fromJSON (JSONObject jsonObject) throws DDBadDataException;
}
