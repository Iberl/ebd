package ebd.trainData.util.dataConstructs;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ForceFactorTable {

    private List<ForceFactorTableRow> forceFactorTableRowList;

    /**
     *
     * @param jsonObject The JSONObject containing the "Kraftfaktortabelle"
     */
    public ForceFactorTable(JSONObject jsonObject) throws TDBadDataException {
        forceFactorTableRowList = new ArrayList<>();
        fillFromJSON(jsonObject);
    }

    public List<ForceFactorTableRow> getForceFactorTableRowList() {
        return forceFactorTableRowList;
    }

    private void fillFromJSON(JSONObject jsonObject) throws TDBadDataException {
        JSONArray jsonArray;

        //TODO Better solution for empty ForceFactorTables
        if(jsonObject.keySet().isEmpty()){
            System.out.println("-ForceFactorTable was empty-");
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
