package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONObject;

import java.util.List;

public abstract class Action {

    protected OrBlock orBlock;

    public boolean eval(){
        return this.orBlock.eval();
    };

    abstract protected void fromJSON(JSONObject jsonObject) throws DDBadDataException;



}
