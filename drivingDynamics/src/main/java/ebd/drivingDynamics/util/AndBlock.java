package ebd.drivingDynamics.util;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

public class AndBlock extends ConditionBlock {


    public AndBlock(JSONObject jsonObject, EventBus eventBus) throws DDBadDataException {
        super(jsonObject,eventBus);
    }

    @Override
    public boolean eval() {
        for(Condition condition : conditions)
            if(!condition.eval()){
                return false;
            }
        return true;
    }

}
