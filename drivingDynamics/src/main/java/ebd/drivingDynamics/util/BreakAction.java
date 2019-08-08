package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

public class BreakAction extends Action {

    private double breakPercentage;

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("value")){
            Object tempObject = jsonObject.get("value");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                breakPercentage = (Long)tempObject;
            }
            else if(tempObjectName.equals("Double")){
                breakPercentage = (Double)tempObject;
            }
            else throw new DDBadDataException("BreakAction value was not a number");


            if(breakPercentage < 0 || breakPercentage > 100){
                throw new DDBadDataException("BreakAction Value was not in the range [0, 100]");
            }
        }
        else throw new DDBadDataException("The key 'value' was missing for a BreakAction");


        if(jsonObject.keySet().contains("orBlock")){
            JSONObject tempJSON = (JSONObject)jsonObject.get("orBlock");
            orBlock = new OrBlock(tempJSON);
        }
        else throw new DDBadDataException("The key 'orBlock' was missing for a BreakAction");

    }

    public double getBreakPercentage() {
        return breakPercentage;
    }
}
