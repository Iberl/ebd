package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * Placeholder action to prevent the usage of null.
 */
public class NoAction extends Action {

    /**
     * Placeholder action to prevent the usage of null.
     */
    public NoAction(EventBus eventBus) {
        super(eventBus, Integer.MAX_VALUE);
    }

    @Override
    public boolean eval(){
        return true;
    }

    /**
     * Should never be called
     * @param jsonObject Any {@link JSONObject}
     * @throws DDBadDataException Thrown if method is called
     */
    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        throw new DDBadDataException("NoAction is not parsed out of a JSON Object and only a placeholder action");
    }
}
