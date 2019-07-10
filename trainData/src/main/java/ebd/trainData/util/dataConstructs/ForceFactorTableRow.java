package ebd.trainData.util.dataConstructs;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONObject;

import java.util.Set;

public class ForceFactorTableRow {

    /**
     * Double value representing a electrical equipment type
     */
    private double electricalEquipment;

    /**
     * Rolling resistance a0 in [kN]
     */
    private double a0;

    /**
     * Rolling resistance a1 in [kN*h/km]
     */
    private double a1;

    /**
     * Rolling resistance a2 in [kN*(h/km)^2]
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
     * Constructor setting the {@link ForceFactorTableRow} out of a JSONObject
     *
     * @param jsonObject JSONObject containing one ForceFactorRow
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

    /**
     * @return Double value representing a electrical equipment type
     */
    public double getElectricalEquipment() {
        return electricalEquipment;
    }

    /**
     * @return Rolling resistance a0 in [kN]
     */
    public double getA0() {
        return a0;
    }

    /**
     * @return Rolling resistance a1 in [kN*h/km]
     */
    public double getA1() {
        return a1;
    }

    /**
     * @return Rolling resistance a2 in [kN*(h/km)^2]
     */
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
