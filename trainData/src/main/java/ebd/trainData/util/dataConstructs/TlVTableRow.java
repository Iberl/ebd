package ebd.trainData.util.dataConstructs;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONObject;

import java.util.Set;

public class TlVTableRow {

    /**
     * Speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    private double speed;

    /**
     * minimum power //TODO units
     */
    private double minPower;

    /**
     * maxmum power //TODO units
     */
    private double maxPower;

    /**
     * K1 factor
     */
    private double k1Factor;

    /**
     * K2 factor
     */
    private double k2Factor;

    /**
     * K3 factor
     */
    private double k3Factor;

    /**
     *
     * @param speed Speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     * @param minPower
     * @param maxPower
     * @param k1Factor
     * @param k2Factor
     * @param k3Factor
     */
    public TlVTableRow(double speed, double minPower, double maxPower, double k1Factor, double k2Factor, double k3Factor) {
        this.speed = speed;
        this.minPower = minPower;
        this.maxPower = maxPower;
        this.k1Factor = k1Factor;
        this.k2Factor = k2Factor;
        this.k3Factor = k3Factor;
    }

    public TlVTableRow(JSONObject jsonObject) throws TDBadDataException {

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
     *
     * @return Speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    public double getSpeed() {
        return speed;
    }

    public double getMinPower() {
        return minPower;
    }

    public double getMaxPower() {
        return maxPower;
    }

    public double getK1Factor() {
        return k1Factor;
    }

    public double getK2Factor() {
        return k2Factor;
    }

    public double getK3Factor() {
        return k3Factor;
    }
}
