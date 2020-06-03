package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.conditions.conditionBlocks.AndBlock;
import ebd.drivingDynamics.util.conditions.abstracts.Condition;
import ebd.drivingDynamics.util.conditions.helper.SingleConditionParser;
import ebd.drivingDynamics.util.conditions.conditionBlocks.OrBlock;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;

/**
 * This class represents an abstract action. An action represents one of the possible movement states
 * (s. {@link ebd.globalUtils.movementState.MovementState}). Every actions contains one or more {@link Condition}.
 * By checking if these conditions evaluate to true, one can decided if the specific action should be taken.<br>
 * <b>When implementing a new action, this action has to be included in {@link ActionParser} so it can be read
 * out of a json file. It also has to be included in the {@link ebd.drivingDynamics.DrivingDynamics} actionParser method</b>
 */
public abstract class Action {
    @NotNull
    protected EventBus localEventBus;

    @NotNull
    protected Condition condition;

    /**
     * the priority of the action. The action or actions with the lowest
     * priority value will be evaluated first.
     */
    protected int priority;

    /**
     *
     * @param localEventBus The local {@link EventBus} of the train
     */
    public Action(@NotNull EventBus localEventBus, int priority){
        this.localEventBus = localEventBus;
        this.priority = priority;
    }

    /**
     * Determines if this action should be taken.
     * @return true if all conditions (respecting 'and' and 'or' blocks) evaluate to true, else false.
     */
    public boolean eval(){
        return this.condition.eval();
    }

    /**
     * Build an action from an {@link JSONObject}
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    abstract protected void fromJSON(JSONObject jsonObject) throws DDBadDataException;

    /**
     * Parsed conditions out of a {@link JSONObject}
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    protected void conditionsFromJSON(JSONObject jsonObject) throws DDBadDataException{

        try {
            if(jsonObject.containsKey("andBlock")){
                this.condition = new AndBlock(jsonObject, this.localEventBus);
            }
            else if (jsonObject.containsKey("orBlock")){
                this.condition = new OrBlock(jsonObject, this.localEventBus);
            }
            else {
                this.condition = SingleConditionParser.parse(jsonObject, this.localEventBus);
            }


        } catch (ClassCastException e) {
            DDBadDataException newE = new DDBadDataException("A ConditionBlock was not formatted correctly: " + jsonObject.toString());
            newE.setStackTrace(e.getStackTrace());
            throw newE;
        }
    }

    /*
    Getter
     */

    /**
     * Returns the priority of the action. The action or actions with the lowest
     * priority value will be tested first
     * @return the priority value
     */
    public int getPriority(){
        return this.priority;
    }
}
