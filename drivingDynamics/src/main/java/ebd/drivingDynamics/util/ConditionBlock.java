package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class ConditionBlock extends Condition {

    protected List<Condition> conditions;

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        this.conditions = new ArrayList<>();
        Set<String> keySet = jsonObject.keySet();
        if(keySet.size() != 1 && !(keySet.contains("andBlock") || keySet.contains("orBlock"))){
            throw new DDBadDataException("A ConditionBlock was not formatted correctly: " + jsonObject.toString());
        }

        try {
            JSONArray jsonArray;
            if(keySet.contains("andBlock")){
                jsonArray = (JSONArray)jsonObject.get("andBlock");
            }
            else {
                jsonArray = (JSONArray)jsonObject.get("orBlock");
            }
            for (Object object : jsonArray){
                JSONObject tempJSON = (JSONObject)object;
                if(tempJSON.containsKey("andBlock")){
                    conditions.add(new AndBlock(tempJSON));
                }
                else if(tempJSON.containsKey("orBlock")){
                    conditions.add(new OrBlock(tempJSON));
                }
                else {
                    conditions.add(ConditionSelector.select(tempJSON));
                }
            }


        } catch (ClassCastException e) {
            DDBadDataException newE = new DDBadDataException("A ConditionBlock was not formatted correctly: " + jsonObject.toString());
            newE.setStackTrace(e.getStackTrace());
            throw newE;
        }

    }
}
