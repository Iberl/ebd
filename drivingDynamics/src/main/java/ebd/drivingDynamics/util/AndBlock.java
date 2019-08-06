package ebd.drivingDynamics.util;

import org.json.simple.JSONObject;

import java.util.List;

public class AndBlock extends ConditionBlock {

    private List<Condition> conditions;

    public AndBlock(JSONObject jsonObject){
        fromJSON(jsonObject);
    }

    @Override
    public boolean eval() {
        for(Condition condition : conditions)
            if(!condition.eval()){
                return false;
            }
        return true;
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) {

    }
}
