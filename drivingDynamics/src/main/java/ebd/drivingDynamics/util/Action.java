package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

import java.util.List;

public abstract class Action {

    protected OrBlock orBlock;

    abstract protected void fromJSON(JSONObject jsonObject) throws DDBadDataException;

    abstract public boolean eval();

}
