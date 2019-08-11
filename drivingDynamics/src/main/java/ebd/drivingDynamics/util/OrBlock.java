package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
