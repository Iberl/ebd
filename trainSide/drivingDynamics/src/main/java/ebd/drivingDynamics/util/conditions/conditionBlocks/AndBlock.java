package ebd.drivingDynamics.util.conditions.conditionBlocks;

import ebd.drivingDynamics.util.conditions.abstracts.Condition;
import ebd.drivingDynamics.util.conditions.abstracts.ConditionBlock;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * An and block contains a group of conditions that are connected by "and". All conditions in the block have to
 * evaluate to true so this block evaluates to true
 * <p>The JSON string:<br> {"andblock" : [*]} with * being a list of {@link Condition} including {@link ConditionBlock}</p>
 */
public class AndBlock extends ConditionBlock {

    /**
     * An and block contains a group of conditions that are connected by "and".
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus the local {@link EventBus}
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public AndBlock(JSONObject jsonObject, EventBus localEventBus) throws DDBadDataException {
        super(jsonObject,localEventBus);
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
