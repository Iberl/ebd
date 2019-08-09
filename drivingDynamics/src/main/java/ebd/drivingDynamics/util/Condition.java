package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

abstract public class Condition {

    abstract public boolean eval();

    abstract protected void fromJSON (JSONObject jsonObject) throws DDBadDataException;
}
