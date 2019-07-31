package ebd.drivingDynamics.util;

import org.json.simple.JSONObject;

public class RelativSpeedCondition extends Condition {
    @Override
    void fromJSON(JSONObject jsonObject) {
        
    }

    @Override
    public boolean eval() {
        return false;
    }
}
