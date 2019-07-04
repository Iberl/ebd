package ebd.trainData.util.dataConstructs;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TlVTable {

    /**
     * limits TODO: units
     */
    private double limits;

    /**
     * K2 factor
     */
    private double k2Factor;

    private List<TlVTableRow> tlVTableRowList;



    public TlVTable(JSONObject jsonObject) throws TDBadDataException {
        this.tlVTableRowList = new ArrayList<>();
        fillFromJSON(jsonObject);
    }

    private void fillFromJSON(JSONObject jsonObject) throws TDBadDataException {

        Set<String> jsonObjectKeySet = jsonObject.keySet();

        if (jsonObjectKeySet.contains("Einschraenkung")){
            this.limits = (Double)jsonObject.get("Einschraenkung");
        }
        else throw new TDBadDataException("The key 'Einschraenkung' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("K2Faktor")){
            this.k2Factor = (Double)jsonObject.get("K2Faktor");
        }
        else throw new TDBadDataException("The key 'K2Faktor' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Zeilen")){
            JSONArray jsonArray = (JSONArray)jsonObject.get("Zeilen");

            for (Object item : jsonArray){
                getTlVTableRowList().add(new TlVTableRow((JSONObject)item));
            }
        }
        else throw new TDBadDataException("The key 'Zeilen' was missing in the trainCar data send by the tool TrainConfigurator");
    }


    public double getLimits() {
        return limits;
    }

    public double getK2Factor() {
        return k2Factor;
    }

    public List<TlVTableRow> getTlVTableRowList() {
        return tlVTableRowList;
    }
}
