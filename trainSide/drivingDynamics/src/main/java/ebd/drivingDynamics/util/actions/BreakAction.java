package ebd.drivingDynamics.util.actions;

import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

/**
 * This action breaks the train. The power by which the train should be decelerated can be modified by the breaking
 * percentage.
 */
public class BreakAction extends Action {

    private double breakPercentage;

    /**
     * This action breaks the train.
     *
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus the local {@link EventBus}
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public BreakAction(JSONObject jsonObject, EventBus localEventBus) throws DDBadDataException {
        super(localEventBus);
        fromJSON(jsonObject);
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
}
