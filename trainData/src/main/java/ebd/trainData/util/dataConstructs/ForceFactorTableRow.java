package ebd.trainData.util.dataConstructs;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONObject;

import java.util.Set;

public class ForceFactorTableRow {

    /**
     * Electrical equipment //TODO units
     */
    private double electricalEquipment;

    /**
     * a0
     */
    private double a0;

    /**
     * a1
     */
    private double a1;

    /**
     * a2
     */
    private double a2;

    /**
     * minimum speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    private double minSpeed;

    /**
     * maximum speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    private double maxSpeed;

    /**
     *
     * @param electricalEquipment
     * @param a0
     * @param a1
     * @param a2
     * @param minSpeed minimum speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     * @param maxSpeed maximum speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    public ForceFactorTableRow(double electricalEquipment, double a0, double a1, double a2, double minSpeed, double maxSpeed) {
        this.electricalEquipment = electricalEquipment;
        this.a0 = a0;
        this.a1 = a1;
        this.a2 = a2;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    /**
     *
     * @param jsonObject Containing one "Kraftfaktorzeile"
     */
    public  ForceFactorTableRow(JSONObject jsonObject) throws TDBadDataException {

        Set<String> jsonObjectKeySet = jsonObject.keySet();

        if (jsonObjectKeySet.contains("Stromausruestung")){
            this.electricalEquipment = (Double)jsonObject.get("Stromausruestung");
        }
        else throw new TDBadDataException("The key 'Stromausruestung' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("a0")){
            this.a0 = (Double)jsonObject.get("a0");
        }
        else throw new TDBadDataException("The key 'a0' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("a1")){
            this.a1 = (Double)jsonObject.get("a1");
        }
        else throw new TDBadDataException("The key 'a1' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("a2")){
            this.a2 = (Double)jsonObject.get("a2");
        }
        else throw new TDBadDataException("The key 'a2' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("abGeschwindigkeit")){
            this.minSpeed = (Double)jsonObject.get("abGeschwindigkeit") / 5;
        }
        else throw new TDBadDataException("The key 'abGeschwindigkeit' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("bisGeschwindigkeit")){
            this.maxSpeed = (Double)jsonObject.get("bisGeschwindigkeit") / 5;
        }
        else throw new TDBadDataException("The key 'bisGeschwindigkeit' was missing in the trainCar data send by the tool TrainConfigurator");
    }

    public double getElectricalEquipment() {
        return electricalEquipment;
    }

    public double getA0() {
        return a0;
    }

    public double getA1() {
        return a1;
    }

    public double getA2() {
        return a2;
    }

    /**
     *
     * @return minimum speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    public double getMinSpeed() {
        return minSpeed;
    }

    /**
     *
     * @return maximum speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }
}
