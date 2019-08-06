package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

abstract public class Condition {

    abstract protected void fromJSON (JSONObject jsonObject) throws DDBadDataException;

    abstract public boolean eval();
}
