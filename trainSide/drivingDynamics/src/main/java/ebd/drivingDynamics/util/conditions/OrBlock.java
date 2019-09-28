package ebd.drivingDynamics.util.conditions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

public class OrBlock extends ConditionBlock {


    public OrBlock(JSONObject jsonObject, EventBus eventBus) throws DDBadDataException {
        super(jsonObject, eventBus);
    }
    
    @Override
    public boolean eval() {
        for (Condition condition : conditions){
            if(condition.eval()){
                return true;
            }
        }
        return false;
    }

}
