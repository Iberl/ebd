package ebd.trainData.util.dataConstructs;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TlVTable {

    /**
     * double value representing limits //TODO: units
     * Can be NaN!
     */
    private double limits;

    /**
     * K2 factor in [s/m]
     * Can be NaN!
     */
    private double k2Factor;

    /**
     * Can be empty!
     */
    private List<TlVTableRow> tlVTableRowList;


    /**
     * Constructor setting the TlVTable from a {@link JSONObject} containg one TlVTable.
     *
     * @param jsonObject containing one tlv table
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    public TlVTable(JSONObject jsonObject) throws TDBadDataException {
        fillFromJSON(jsonObject);
    }

    /**
     * Parses the jsonObject. The list of tlvTableRows stays empty should the tlv table be empty
     *
     * @param jsonObject containing one tlv table
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    private void fillFromJSON(JSONObject jsonObject) throws TDBadDataException {

        this.tlVTableRowList = new ArrayList<>();

        Set<String> jsonObjectKeySet = jsonObject.keySet();

        if (jsonObjectKeySet.isEmpty()){
            this.limits = Double.NaN;
            this.k2Factor = Double.NaN;
            return;
        }

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

    /**
     * @return double value representing limits //TODO: units
     */
    public double getLimits() {
        return limits;
    }

    /**
     * @return K2 factor in [s/m]
     */
    public double getK2Factor() {
        return k2Factor;
    }

    public List<TlVTableRow> getTlVTableRowList() {
        return tlVTableRowList;
    }
}
