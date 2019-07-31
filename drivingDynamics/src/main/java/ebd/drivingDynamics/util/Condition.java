package ebd.drivingDynamics.util;

import org.json.simple.JSONObject;

abstract public class Condition {

    abstract void fromJSON (JSONObject jsonObject);

    abstract public boolean eval();
}
