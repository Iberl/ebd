package ebd.trainData.util;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONObject;

import java.util.Set;

public class FreightCar extends TrainCar {

    /**
     * The UIC Car Number descriping the type of car
     */
    private long uicCarNumber;

    /**
     * The kind of the car
     */
    private String carKind;

    /**
     * freight car type
     */
    private String freightCarType;

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
     * Break block
     */
    private String breakBlock;

    /**
     * automatic load breaking present?
     */
    private boolean automaticLoadBreaking;

    /**
     * Maximum load mass in [kg]
     */
    private int maxLoadMass;

    /**
     * Maximum load volume in [m^3]
     */
    private int maxLoadVolume;

    /**
     * Roll resistance coefficient
     */
    private Double rollResistanceCoef;


    /**
     *
     * @param jsonObject
     * @throws TDBadDataException
     */
    public FreightCar(JSONObject jsonObject) throws TDBadDataException {
        super(jsonObject);
        if (jsonObject.containsKey("Typ")){
            fillFromJSON((JSONObject)jsonObject.get("Typ"));
        }
        else throw new TDBadDataException("The key 'Typ' was missing in the trainCar data send by the tool TrainConfigurator");
    }

    private void fillFromJSON(JSONObject jsonObject) throws TDBadDataException {

        Set<String> jsonObjectKeySet = jsonObject.keySet();

        if (jsonObjectKeySet.contains("UicWagennummer")){
            this.uicCarNumber = (Long)jsonObject.get("UicWagennummer");
        }
        else throw new TDBadDataException("The key 'UicWagennummer' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Gattung")){
            this.carKind = (String)jsonObject.get("Gattung");
        }
        else throw new TDBadDataException("The key 'Gattung' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Typ")){
            this.freightCarType = (String)jsonObject.get("Typ");
        }
        else throw new TDBadDataException("The key 'Typ' was missing in the trainCar data send by the tool TrainConfigurator");

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

        if (jsonObjectKeySet.contains("Einzelachsenachsstand")){
            Long tempLong = (Long)jsonObject.get("Einzelachsenachsstand");
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

        if (jsonObjectKeySet.contains("Bremssohle")){
            this.breakBlock = (String)jsonObject.get("Bremssohle");
        }
        else throw new TDBadDataException("The key 'Bremssohle' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("automatischeLastabbremsung")){
            this.automaticLoadBreaking = (boolean)jsonObject.get("automatischeLastabbremsung");
        }
        else throw new TDBadDataException("The key 'automatischeLastabbremsung' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("MaximaleZuladungsmasse")){
            Long tempLong = (Long)jsonObject.get("MaximaleZuladungsmasse");
            this.maxLoadMass = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'MaximaleZuladungsmasse' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("MaximalesZuladungsvolumen")){
            Long tempLong = (Long)jsonObject.get("MaximalesZuladungsvolumen");
            this.maxLoadVolume = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'MaximalesZuladungsvolumen' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Rollwiderstandsbeiwert")){
            this.rollResistanceCoef = (Double)jsonObject.get("Rollwiderstandsbeiwert");
        }
        else throw new TDBadDataException("The key 'Rollwiderstandsbeiwert' was missing in the trainCar data send by the tool TrainConfigurator");
    }

    /*
    Getter
     */

    public long getUicCarNumber() {
        return uicCarNumber;
    }

    public String getCarKind() {
        return carKind;
    }

    public String isFreightCarType() {
        return freightCarType;
    }

    public boolean isPlainBearings() {
        return plainBearings;
    }

    /**
     * @return Empty mass of the car in [kg]
     */
    public int getEmptyMass() {
        return emptyMass;
    }

    /**
     * @return max weight of the car in [kg]
     */
    public int getMaxWeight() {
        return maxWeight;
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

    public String getBreakBlock() { return breakBlock; }

    public boolean isAutomaticLoadBreaking() { return automaticLoadBreaking; }

    /**
     * @return max mass of load in [kg]
     */
    public int getMaxLoadMass() { return maxLoadMass; }

    /**
     * @return max load volume in [m^3]
     */
    public int getMaxLoadVolume() { return maxLoadVolume; }

    public Double getRollResistanceCoef() { return rollResistanceCoef; }
}
