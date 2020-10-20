package ebd.drivingDynamics.util.conditions.abstracts;

import ebd.drivingDynamics.util.conditions.conditionBlocks.AndBlock;
import ebd.drivingDynamics.util.conditions.conditionBlocks.OrBlock;
import ebd.drivingDynamics.util.conditions.helper.SingleConditionParser;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A condition block contains a group of conditions that are depended in some way.
 * The way they are connected is determined by the implementation.<br>
 * There are AndBlocks and OrBlocks. In AndBlocks conditions are connected by "and", in
 * OrBlocks by "or".<br>
 * Blocks can be nested.
 */
public abstract class ConditionBlock extends Condition {

    protected List<Condition> conditions;

    /**
     * A condition block contains a group of conditions that are depended in some way.
     * @param jsonObject a valid {@link JSONObject}. See documentation for expected format.
     * @param localEventBus the local {@link EventBus}
     * @throws DDBadDataException If the {@link JSONObject} was not formatted correctly.
     */
    public ConditionBlock(JSONObject jsonObject, EventBus localEventBus) throws DDBadDataException {
        super(localEventBus);
        fromJSON(jsonObject);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {
        this.conditions = new ArrayList<>();
        Set<String> keySet = jsonObject.keySet();
        if(keySet.size() != 1 && !(keySet.contains("andBlock") || keySet.contains("orBlock"))){
            throw new DDBadDataException("A ConditionBlock was not formatted correctly: " + jsonObject.toString());
        }

        try {
            JSONArray jsonArray;
            if(keySet.contains("andBlock")){
                jsonArray = (JSONArray)jsonObject.get("andBlock");
            }
            else {
                jsonArray = (JSONArray)jsonObject.get("orBlock");
            }
            for (Object object : jsonArray){
                JSONObject tempJSON = (JSONObject)object;
                if(tempJSON.containsKey("andBlock")){
                    conditions.add(new AndBlock(tempJSON,this.localEventBus));
                }
                else if(tempJSON.containsKey("orBlock")){
                    conditions.add(new OrBlock(tempJSON,this.localEventBus));
                }
                else {
                    conditions.add(SingleConditionParser.parse(tempJSON,this.localEventBus));
                }
            }


        } catch (ClassCastException e) {
            DDBadDataException newE = new DDBadDataException("A ConditionBlock was not formatted correctly: " + jsonObject.toString());
            newE.setStackTrace(e.getStackTrace());
            throw newE;
        }

    }
}
