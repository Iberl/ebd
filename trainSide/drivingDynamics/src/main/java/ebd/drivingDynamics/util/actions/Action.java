package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.conditions.AndBlock;
import ebd.drivingDynamics.util.conditions.Condition;
import ebd.drivingDynamics.util.conditions.ConditionSelector;
import ebd.drivingDynamics.util.conditions.OrBlock;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;

public abstract class Action {
    @NotNull
    protected EventBus localEventBus;

    @NotNull
    protected Condition condition;

    public Action(EventBus eventBus){
        this.localEventBus = eventBus;
    }

    public boolean eval(){
        return this.condition.eval();
    }

    abstract protected void fromJSON(JSONObject jsonObject) throws DDBadDataException;

    protected void conditionsFromJSON(JSONObject jsonObject) throws DDBadDataException{

        try {
            if(jsonObject.containsKey("andBlock")){
                this.condition = new AndBlock(jsonObject, this.localEventBus);
            }
            else if (jsonObject.containsKey("orBlock")){
                this.condition = new OrBlock(jsonObject, this.localEventBus);
            }
            else {
                this.condition = ConditionSelector.select(jsonObject, this.localEventBus);
            }


        } catch (ClassCastException e) {
            DDBadDataException newE = new DDBadDataException("A ConditionBlock was not formatted correctly: " + jsonObject.toString());
            newE.setStackTrace(e.getStackTrace());
            throw newE;
        }
    }
}
