package ebd.drivingDynamics.util.conditions.conditionBlocks;

import ebd.drivingDynamics.util.conditions.abstracts.Condition;
import ebd.drivingDynamics.util.conditions.abstracts.ConditionBlock;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * An or block contains a group of conditions that are connected by "or". One condition in the block has to
 * evaluate to true so this block evaluates to true<br>
 * <p>The JSON string:<br> {"orblock" : [*]} with * being a list of {@link Condition} including {@link ConditionBlock}</p>
 */
public class OrBlock extends ConditionBlock {

    /**
     * An or block contains a group of conditions that are connected by "or".
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus the local {@link EventBus}
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public OrBlock(JSONObject jsonObject, EventBus localEventBus) throws DDBadDataException {
        super(jsonObject, localEventBus);
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
