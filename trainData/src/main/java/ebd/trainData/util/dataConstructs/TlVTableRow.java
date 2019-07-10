package ebd.trainData.util.dataConstructs;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONObject;

import java.util.Set;

/**
 * This class represents one row in a {@link TlVTable}
 */
public class TlVTableRow {

    /**
     * Speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    private double speed;

    /**
     * minimum power in [kW]
     */
    private double minPower;

    /**
     * maxmum power in [kW]
     */
    private double maxPower;

    /**
     * K1 factor in [kN]
     */
    private double k1Factor;

    /**
     * K2 factor in [s/m]
     */
    private double k2Factor;

    /**
     * K3 factor in [s/m]
     */
    private double k3Factor;

    /**
     * Constructor setting the TlVTableRow from an JSONObject
     *
     * @param jsonObject containing one tlv table row
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    public TlVTableRow(JSONObject jsonObject) throws TDBadDataException {
        fillFromJSON(jsonObject);
    }

    /**
     * Parses the jsonObject.
     *
     * @param jsonObject containing one tlv table row
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    private void fillFromJSON(JSONObject jsonObject) throws TDBadDataException {
        Set<String> jsonObjectKeySet = jsonObject.keySet();

        if (jsonObjectKeySet.contains("Geschwindigkeit")){
            this.speed = (Double)jsonObject.get("Geschwindigkeit") / 5;
        }
        else throw new TDBadDataException("The key 'Geschwindigkeit' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("LeistungsbereichVon")){
            this.minPower = (Double)jsonObject.get("LeistungsbereichVon");
        }
        else throw new TDBadDataException("The key 'LeistungsbereichVon' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("LeistungsbereichBis")){
            this.maxPower = (Double)jsonObject.get("LeistungsbereichBis");
        }
        else throw new TDBadDataException("The key 'LeistungsbereichBis' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("K1-Faktor")){
            this.k1Factor = (Double)jsonObject.get("K1-Faktor");
        }
        else throw new TDBadDataException("The key 'K1-Faktor' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("K2-Faktor")){
            this.k2Factor = (Double)jsonObject.get("K2-Faktor");
        }
        else throw new TDBadDataException("The key 'K2-Faktor' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("K3-Faktor")){
            this.k3Factor = (Double)jsonObject.get("K3-Faktor");
        }
        else throw new TDBadDataException("The key 'K3-Faktor' was missing in the trainCar data send by the tool TrainConfigurator");
    }

    /*
    Getter
     */

    /**
     * @return Speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @return minimum power in [kW]
     */
    public double getMinPower() {
        return minPower;
    }

    /**
     * @return maxmum power in [kW]
     */
    public double getMaxPower() {
        return maxPower;
    }

    /**
     * @return K1 factor in [kN]
     */
    public double getK1Factor() {
        return k1Factor;
    }

    /**
     * @return K2 factor in [s/m]
     */
    public double getK2Factor() {
        return k2Factor;
    }

    /**
     * @return K3 factor in [s/m]
     */
    public double getK3Factor() {
        return k3Factor;
    }
}
