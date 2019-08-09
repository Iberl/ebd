package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OrBlock extends ConditionBlock {


    public OrBlock(JSONObject jsonObject) throws DDBadDataException {
        fromJSON(jsonObject);
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
