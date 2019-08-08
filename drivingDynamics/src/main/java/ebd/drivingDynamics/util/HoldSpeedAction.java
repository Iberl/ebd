package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

public class HoldSpeedAction extends Action {
    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("orBlock")){
            JSONObject tempJSON = (JSONObject)jsonObject.get("orBlock");
            orBlock = new OrBlock(tempJSON);
        }
        else throw new DDBadDataException("The key 'orBlock' was missing for a HoldAction");
    }
}
