package ebd.drivingDynamics.util;

import ebd.drivingDynamics.exceptions.DDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OrBlock extends ConditionBlock {

    private List<AndBlock> andBlocks;

    public OrBlock(JSONObject jsonObject) throws DDBadDataException {
        fromJSON(jsonObject);
    }
    
    @Override
    public boolean eval() {
        for (AndBlock andBlocks : andBlocks){
            if(andBlocks.eval()){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        if(jsonObject.keySet().contains("andBlocks")){
            JSONArray jsonArray = (JSONArray) jsonObject.get("andBlocks");
            andBlocks = new ArrayList<>();

            for(Object object : jsonArray){
                andBlocks.add(new AndBlock((JSONObject)object));
            }
        }
        else throw new DDBadDataException("The key 'andBlocks' was missing for a OrBlock");
    }

}
