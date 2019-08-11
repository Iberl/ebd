package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;

public class BreakAction extends Action {

    public BreakAction(JSONObject jsonObject, EventBus eventBus) throws DDBadDataException {
        super(eventBus);
        fromJSON(jsonObject);
    }

    private double breakPercentage;

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){
            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                this.breakPercentage = (Long)tempObject;
            }
            else if(tempObjectName.equals("Double")){
                this.breakPercentage = (Double)tempObject;
            }
            else throw new DDBadDataException("BreakAction value was not a number");


            if(breakPercentage < 0 || breakPercentage > 100){
                throw new DDBadDataException("BreakAction Value was not in the range [0, 100]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a BreakAction");


        if(jsonObject.keySet().contains("conditions")){
            conditionsFromJSON((JSONObject)jsonObject.get("conditions"));

        }
        else throw new DDBadDataException("The key 'conditions' was missing for a AccelerationAction");

    }

    public double getBreakPercentage() {
        return this.breakPercentage;
    }
}
