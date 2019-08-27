package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.movementState.MovementState;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

public class NoAction extends Action {
    public NoAction(EventBus eventBus) {
        super(eventBus);
    }

    @Override
    public boolean eval(){
        return true;
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {};
}
