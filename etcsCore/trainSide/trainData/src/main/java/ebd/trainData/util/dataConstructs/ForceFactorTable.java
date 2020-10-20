package ebd.trainData.util.dataConstructs;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a force factor table, which shows the force of the engine while driving and breaking
 */
public class ForceFactorTable {

    /**
     * Can be empty!
     */
    private List<ForceFactorTableRow> forceFactorTableRowList;

    /**
     * Constructor setting the List of {@link ForceFactorTableRow} from an JSONobject.
     * Should the table be empty, the list is empty.
     *
     * @param jsonObject The JSONObject containing one force factor table
     *
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    public ForceFactorTable(JSONObject jsonObject) throws TDBadDataException {
        forceFactorTableRowList = new ArrayList<>();
        fillFromJSON(jsonObject);
    }

    public List<ForceFactorTableRow> getForceFactorTableRowList() {
        return forceFactorTableRowList;
    }

    /**
     * Parses the jsonObject.
     *
     * @param jsonObject containing one force factor table
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    private void fillFromJSON(JSONObject jsonObject) throws TDBadDataException {
        JSONArray jsonArray;

        //TODO Better solution for empty ForceFactorTables
        if(jsonObject.keySet().isEmpty()){
            //System.out.println("-ForceFactorTable was empty-");
            return;
        }

        if(jsonObject.containsKey("Zeilen")){
            jsonArray = (JSONArray)jsonObject.get("Zeilen");
        }
        else throw new TDBadDataException("The key 'Zeilen' was missing in the trainCar data send by the tool TrainConfigurator");

        for (Object item : jsonArray){
            forceFactorTableRowList.add(new ForceFactorTableRow((JSONObject) item));
        }

    }

}
