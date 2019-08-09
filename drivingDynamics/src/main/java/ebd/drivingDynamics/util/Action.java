package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

public abstract class Action {

    protected Condition condition;

    public boolean eval(){
        return this.condition.eval();
    };

    abstract protected void fromJSON(JSONObject jsonObject) throws DDBadDataException;

    protected void conditionsFromJSON(JSONObject jsonObject) throws DDBadDataException{

        try {
            if(jsonObject.containsKey("andBlock")){
                condition = new AndBlock(jsonObject);
            }
            else if (jsonObject.containsKey("orBlock")){
                condition = new OrBlock(jsonObject);
            }
            else {
                condition = ConditionSelector.select(jsonObject);
            }


        } catch (ClassCastException e) {
            DDBadDataException newE = new DDBadDataException("A ConditionBlock was not formatted correctly: " + jsonObject.toString());
            newE.setStackTrace(e.getStackTrace());
            throw newE;
        }

    }



}
