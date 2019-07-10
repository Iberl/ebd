package ebd.trainData.util.dataConstructs;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONObject;

import java.util.Set;

/**
 * This class represents one row in a {@link Diagram}. It contains data describing the efficiency of a engine.
 * Every row is valid between the minimum and maximum speed.
 */
public class DiagramRow {

    /**
     * p0 factor
     */
    private double p0;

    /**
     * p1 factor
     */
    private double p1;

    /**
     * p2 factor
     */
    private double p2;

    /**
     * minimum speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    private double minSpeed;

    /**
     * maximum speed in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    private double maxSpeed;

    /**
     * efficency in percent [%]
     */
    private double efficency;

    /**
     * Constructor setting the diagram row
     *
     * @param jsonObject containing one diagram row
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    public DiagramRow(JSONObject jsonObject) throws TDBadDataException {
        fillFromJSON(jsonObject);
    }

    /**
     * Parses the jsonObject.
     *
     * @param jsonObject containing one diagram row
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    private void fillFromJSON(JSONObject jsonObject) throws TDBadDataException {

        Set<String> jsonObjectKeySet = jsonObject.keySet();

        if (jsonObjectKeySet.contains("p0")){
            this.p0 = (Double)jsonObject.get("p0");
        }
        else throw new TDBadDataException("The key 'p0' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("p1")){
            this.p1 = (Double)jsonObject.get("p1");
        }
        else throw new TDBadDataException("The key 'p1' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("p2")){
            this.p2 = (Double)jsonObject.get("p2");
        }
        else throw new TDBadDataException("The key 'p2' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("abGeschwindigkeit")){
            this.minSpeed = (Double)jsonObject.get("abGeschwindigkeit") / 5;
        }
        else throw new TDBadDataException("The key 'abGeschwindigkeit' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("bisGeschwindigkeit")){
            this.maxSpeed = (Double)jsonObject.get("bisGeschwindigkeit") / 5;
        }
        else throw new TDBadDataException("The key 'bisGeschwindigkeit' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Wirkungsgrad")){
            this.efficency = (Double)jsonObject.get("Wirkungsgrad");
        }
        else throw new TDBadDataException("The key 'Wirkungsgrad' was missing in the trainCar data send by the tool TrainConfigurator");
    }

    /*
    Getter
     */

    public double getP0() {
        return p0;
    }

    public double getP1() {
        return p1;
    }

    public double getP2() {
        return p2;
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

    public double getEfficency() {
        return efficency;
    }
}
