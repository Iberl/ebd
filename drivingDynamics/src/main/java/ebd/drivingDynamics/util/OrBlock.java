package ebd.drivingDynamics.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class OrBlock extends ConditionBlock {

    private List<AndBlock> andBlocks;

    public OrBlock(JSONObject jsonObject){
        fromJSON(jsonObject);
    }
    
    @Override
    public boolean eval() {
        for (AndBlock aBlock : andBlocks){
            if(aBlock.eval()){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void fromJSON(JSONObject jsonObject){


    }
}
