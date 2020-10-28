package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.enums.BreakMode;
import ebd.globalUtils.enums.CurveType;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * This action breaks the train. The power by which the train should be decelerated can be modified by the breaking
 * percentage.<br>
 *
 *<p>The <b>type</b> of this action is "v_break"</p>
 *<p>The <b>priority</b> of this action is 0 to Integer.MAX, lower values mean higher priorities and are evaluated first</p>
 *<p>The <b>action</b> of this action contains the inner values</p>
 *<p>The <b>value</b> of this action is in the range 0 % to 100 % and modifies the breaking power</p>
 *<p>The <b>mode</b> of this action contains either "e", "s" or "n" of emergency, service or normal breaking</p>
 *<p>The <b>conditions</b> of this action contains the conditions under which this action is taken</p>
 *
 * <p>Example: The train should service break with 80 % when the conditions evaluate to true:
 * The full JSON string would look like this:<br>
 *     {"type": "v_break", "priority": 0, action: {"value": 80, "mode": "s", "condition": {--conditions--}}}<br>
 *      The value of "action" is passed to the constructor<br></p>
 * @author Lars Schulze-Falck
 */
public class BreakAction extends Action {

    private BreakMode breakMode;

    private double breakPercentage;

    /**
     * This action breaks the train.
     *
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus the local {@link EventBus}
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public BreakAction(JSONObject jsonObject, EventBus localEventBus, int priority) throws DDBadDataException {
        super(localEventBus, priority);
        fromJSON(jsonObject);
    }

    /**
     * Constructs a signal Action that always evaluates to true and has the priority 0
     * @param localEventBus localEventBus the local {@link EventBus}
     * @param breakPercentage in range [0,1]
     * @param breakMode s. {@link BreakMode}
     */
    public BreakAction(EventBus localEventBus, double breakPercentage, BreakMode breakMode){
        super(localEventBus);
        this.breakPercentage = breakPercentage;
        this.breakMode = breakMode;
    }


    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.containsKey("value")){
            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                this.breakPercentage = (Long)tempObject / 100d;
            }
            else if(tempObjectName.equals("Double")){
                this.breakPercentage = (Double)tempObject / 100d;
            }
            else throw new DDBadDataException("BreakAction value was not a number");


            if(breakPercentage < 0 || breakPercentage > 1){
                throw new DDBadDataException("BreakAction Value was not in the range [0, 100]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a BreakAction");

        if(jsonObject.containsKey("mode")){
            String tempObject = (String) jsonObject.get("mode");
            switch (tempObject){
                case "e" -> this.breakMode = BreakMode.EMERGENCY_BREAKING;
                case "s" -> this.breakMode = BreakMode.SERVICE_BREAKING;
                case "n" -> this.breakMode = BreakMode.NORMAL_BREAKING;
                default -> throw new DDBadDataException("The key 'mode' had a value that was not 'e', 's' or 'n'");
            }
        }
        else throw new DDBadDataException("The key 'mode' was missing for a BreakAction");


        if(jsonObject.keySet().contains("conditions")){
            conditionsFromJSON((JSONObject)jsonObject.get("conditions"));

        }
        else throw new DDBadDataException("The key 'conditions' was missing for a BreakAction");

    }

    /**
     * @return The breaking percentage in the range of [0,1] to be used as modifier for the applied breaking power
     */
    public double getBreakPercentage() {
        return this.breakPercentage;
    }

    /**
     * @return the {@link BreakMode} of this action
     */
    public BreakMode getBreakMode() {
        return breakMode;
    }
}
