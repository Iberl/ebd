package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AndBlock extends ConditionBlock {

    private List<Condition> conditions;

    public AndBlock(JSONObject jsonObject) throws DDBadDataException {
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
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("conditions")){
            JSONArray jsonArray = (JSONArray) jsonObject.get("conditions");
            conditions = new ArrayList<>();

            for(Object object : jsonArray){
                /*
                New Conditions have to be added here!
                 */
                JSONObject tempJSON = (JSONObject)object;

                //TODO Add new conditions
                if(tempJSON.containsKey("v_rel")) {
                    JSONObject condJSON = (JSONObject)tempJSON.get("v_rel");
                    conditions.add(new RelativeSpeedCondition(condJSON));
                }
                else if(tempJSON.containsKey("v")) {
                    JSONObject condJSON = (JSONObject)tempJSON.get("v");
                    conditions.add(new TotalSpeedCondition(condJSON));
                }
                else {
                    throw new DDBadDataException("There was a condition without valid key");
                }
            }
        }
        else throw new DDBadDataException("The key 'conditions' was missing for an AndBlock");
    }

}
