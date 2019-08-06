package ebd.drivingDynamics.util;

import org.json.simple.JSONObject;

abstract public class ConditionBlock {

    abstract public boolean eval();

    abstract protected void fromJSON(JSONObject jsonObject);
}
