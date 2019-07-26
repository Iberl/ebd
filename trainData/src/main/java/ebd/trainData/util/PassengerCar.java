package ebd.trainData.util;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PassengerCar extends TrainCar {

    /**
     * The UIC Car Number descriping the type of car
     */
    private int uicCarNumber;

    /**
     * The kind of the car
     */
    private String carKind;

    /**
     * Able to steer train
     */
    private boolean ableToSteer;

    /**
     * Plain bearings present
     */
    private boolean plainBearings;

    /**
     * Empty mass of the car in [kg]
     */
    private int emptyMass;

    /**
     * Maximum weight of the car in [kg]
     */
    private int maxWeight;

    /**
     * Emergency break bypass present?
     */
    private boolean emergencyBreakBypass;

    /**
     * Pressure support (Druckertuechtigung) present?
     */
    private boolean pressureSupport;

    /**
     * Train control systems
     */
    private List<String > trainControlSystems;

    /**
     * Single axle base (Einzelachsstand) in [m]
     */
    private double singleAxleBase;

    /**
     * Distance between pivots  (Drehzapfenabstand) in [m]
     */
    private double pivotDistance;

    /**
     * Bogie base in [m]
     */
    private double bogieBase;

    /**
     * f-Value from wind tunnel experiments in [m^2]
     */
    private double fValue;

    /**
     * b-Value
     */
    private double bValue;

    /**
     * Sets the PassengerCar from an JSONobject.
     *
     * @param jsonObject containing one train car of the car type "Reisezugwagen"
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    public PassengerCar(JSONObject jsonObject) throws TDBadDataException {
        super(jsonObject);
        if (jsonObject.containsKey("Typ")){
            fillFromJSON((JSONObject)jsonObject.get("Typ"));
        }
        else throw new TDBadDataException("The key 'Typ' was missing in the trainCar data send by the tool TrainConfigurator");
    }

    /**
     * Parses the jsonObject.
     *
     * @param jsonObject containing one JSONObject of the type "Typ"
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    private void fillFromJSON(JSONObject jsonObject) throws TDBadDataException {

        Set<String> jsonObjectKeySet = jsonObject.keySet();

        if (jsonObjectKeySet.contains("UicWagennummer")){
            this.uicCarNumber = ((Long)jsonObject.get("UicWagennummer")).intValue();
        }
        else throw new TDBadDataException("The key 'UicWagennummer' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Gattung")){
            this.carKind = (String)jsonObject.get("Gattung");
        }
        else throw new TDBadDataException("The key 'Gattung' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Steuerwagen")){
            this.ableToSteer = (boolean)jsonObject.get("Steuerwagen");
        }
        else throw new TDBadDataException("The key 'Steuerwagen' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Gleitlager")){
            this.plainBearings = (boolean)jsonObject.get("Gleitlager");
        }
        else throw new TDBadDataException("The key 'Gleitlager' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Leermasse")){
            Long tempLong = (Long)jsonObject.get("Leermasse");
            this.emptyMass = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Leermasse' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Maximalgewicht")){
            Long tempLong = (Long)jsonObject.get("Maximalgewicht");
            this.maxWeight = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Maximalgewicht' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Notbremsueberbrueckung")){
            this.emergencyBreakBypass = (boolean) jsonObject.get("Notbremsueberbrueckung");
        }
        else throw new TDBadDataException("The key 'Notbremsueberbrueckung' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Zugbeeinflussungssysteme")){
            JSONArray jsonArray = (JSONArray)jsonObject.get("Zugbeeinflussungssysteme");
            this.trainControlSystems = new ArrayList<>();
            for(Object item : jsonArray){
                trainControlSystems.add((String)item);
            }
        }
        else throw new TDBadDataException("The key 'Zugbeeinflussungssysteme' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Einzelachsenachsstand")){
            Long tempLong = (Long) jsonObject.get("Einzelachsenachsstand");
            this.singleAxleBase = tempLong / 1000d;
        }
        else throw new TDBadDataException("The key 'Einzelachsenachsstand' was missing in the trainType data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Drehzapfenabstand")){
            Long tempLong = (Long)jsonObject.get("Drehzapfenabstand");
            this.pivotDistance = tempLong / 1000d;
        }
        else throw new TDBadDataException("The key 'Drehzapfenabstand' was missing in the trainType data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Drehgestellachsstand")){
            Long tempLong = (Long)jsonObject.get("Drehgestellachsstand");
            this.bogieBase = tempLong / 1000d;
        }
        else throw new TDBadDataException("The key 'Drehgestellachsstand' was missing in the trainType data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("fWert")){
            this.fValue = (Double)jsonObject.get("fWert");
        }
        else throw new TDBadDataException("The key 'fWert' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("bWert")){
            this.bValue = (Double)jsonObject.get("bWert");
        }
        else throw new TDBadDataException("The key 'bWert' was missing in the trainCar data send by the tool TrainConfigurator");
    }

    /*
    Getter
     */

    public int getUicCarNumber() {
        return uicCarNumber;
    }

    public String getCarKind() {
        return carKind;
    }

    public boolean isAbleToSteer() {
        return ableToSteer;
    }

    public boolean isPlainBearings() {
        return plainBearings;
    }

    /**
     * @return Empty mass of the car in [kg]
     */
    public int getEmptyMass() { return emptyMass; }

    /**
     * @return max weight of the car in [kg]
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    public boolean isEmergencyBreakBypass() {
        return emergencyBreakBypass;
    }

    public boolean isPressureSupport() { return pressureSupport; }

    public List<String> getTrainControlSystems() {
        return trainControlSystems;
    }

    /**
     * @return Single axle base in [m]
     */
    public double getSingleAxleBase() {
        return singleAxleBase;
    }

    /**
     * @return Distance between pivots  (Drehzapfenabstand) in [m]
     */
    public double getPivotDistance() {
        return pivotDistance;
    }

    /**
     * @return Bogie base in [m]
     */
    public double getBogieBase() {
        return bogieBase;
    }

    public Double getfValue() {
        return fValue;
    }

    public Double getbValue() {
        return bValue;
    }
}
