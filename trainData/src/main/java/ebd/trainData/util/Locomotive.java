package ebd.trainData.util;

import ebd.trainData.util.dataConstructs.Diagram;
import ebd.trainData.util.dataConstructs.ForceFactorTable;
import ebd.trainData.util.dataConstructs.TlVTable;
import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Locomotive extends TrainCar {

    /**
     * UIC ID
     */
    private int uicID;

    /**
     * Pressure support (Druckertuechtigung) present?
     */
    private boolean pressureSupport;

    /**
     * The kind of drive
     */
    private String drive;

    /**
     * Available electrical systems
     */
    private List<String> electricalSystems;

    /**
     * Available train control systems
     */
    private List<String> trainControlSystems;

    /**
     * hourly output in [kW]
     */
    private int maxHourlyOutput;

    /**
     * maximum sustained power in [kW]
     */
    private int maxSustainedPower;

    /**
     * performance indicator in [kW/t]
     */
    private double performanceIndicator;

    /**
     * peak power in [kW]
     */
    private int peakPower;

    /**
     *  tractive force at starting in [kN]
     */
    private int tractiveForceAtStart;

    /**
     * Drive weel diameter in [m]
     */
    private int driveWeelDiameter;

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
     * Service weight in [kg]
     */
    private int serviceWeight;

    /**
     * Cross-section in [m^2]
     */
    private double crossSection;

    /**
     * Resistance coefficient
     */
    private double resistanceCoefficient;

    /**
     * Roll resistance coefficient
     */
    private double rollResistanceCoef;

    /**
     * Damping resistance coefficient
     */
    private double dampingResistanceCoef;

    /**
     * Drag resistance coefficient
     */
    private double dragResistanceCoef;

    /**
     * Efficiency of the drive
     */
    private int efficiency;

    /**
     * Break force factor table
     */
    private ForceFactorTable breakForceFactorTable;

    /**
     * Drive force factor table
     */
    private ForceFactorTable driveForceFactorTable;

    /**
     * List of TlVTable drive
     */
    private List<TlVTable> driveTlV;

    /**
     * List of TlVTable breaks
     */
    private List <TlVTable> breakTlV;

    /**
     * Consumption diagram
     */
    private Diagram consumptionDiagram;

    /**
     * Recuperation diagarm
     */
    private Diagram recuperationDiagram;


    /**
     * Sets the Locomotiv from an JSONobject.
     *
     * @param jsonObject containing one train car of the car type "Triebfahrzeug"
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    public Locomotive(JSONObject jsonObject) throws TDBadDataException {
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

        if (jsonObjectKeySet.contains("UicBaureihenbezeichnung")){
            this.uicID = ((Long)jsonObject.get("UicBaureihenbezeichnung")).intValue();
        }
        else throw new TDBadDataException("The key 'UicBaureihenbezeichnung' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Druckertuechtigung")){
            this.pressureSupport = (Boolean)jsonObject.get("Druckertuechtigung");
        }
        else throw new TDBadDataException("The key 'Druckertuechtigung' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Antrieb")){
            this.drive = (String) jsonObject.get("Antrieb");
        }
        else throw new TDBadDataException("The key 'Antrieb' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Stromsysteme")){
            JSONArray temparray = (JSONArray) jsonObject.get("Stromsysteme");
            this.electricalSystems = new ArrayList<>();
            for (Object item : temparray){
                this.electricalSystems.add((String) item);
            }
        }
        else throw new TDBadDataException("The key 'Stromsysteme' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Zugbeeinflussungssysteme")){
            JSONArray temparray = (JSONArray) jsonObject.get("Zugbeeinflussungssysteme");
            this.trainControlSystems = new ArrayList<>();
            for (Object item : temparray){
                this.trainControlSystems.add((String) item);
            }
        }
        else throw new TDBadDataException("The key 'Zugbeeinflussungssysteme' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Stundenleistung")){
            Long tempLong = (Long)jsonObject.get("Stundenleistung");
            this.maxHourlyOutput = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Stundenleistung' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Dauerleistung")){
            Long tempLong = (Long)jsonObject.get("Dauerleistung");
            this.maxSustainedPower = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Dauerleistung' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Leistungskennziffer")){
            this.performanceIndicator = (Double) jsonObject.get("Leistungskennziffer");
        }
        else throw new TDBadDataException("The key 'Leistungskennziffer' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Spitzenleistung")){
            Long tempLong = (Long)jsonObject.get("Spitzenleistung");
            this.peakPower = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Spitzenleistung' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Anfahrzugkraft")){
            Long tempLong = (Long)jsonObject.get("Anfahrzugkraft");
            this.tractiveForceAtStart = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Anfahrzugkraft' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Treibraddurchmesser")){
            Long tempLong = (Long)jsonObject.get("Treibraddurchmesser");
            this.driveWeelDiameter = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Treibraddurchmesser' was missing in the trainCar data send by the tool TrainConfigurator");

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

        if (jsonObjectKeySet.contains("Dienstmasse")){
            Long tempLong = (Long)jsonObject.get("Dienstmasse");
            this.serviceWeight = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Dienstmasse' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Querschnittsflaeche")){
            this.crossSection = (Double) jsonObject.get("Querschnittsflaeche");
        }
        else throw new TDBadDataException("The key 'Querschnittsflaeche' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Widerstandsbeiwert")){
            this.resistanceCoefficient = (Double) jsonObject.get("Widerstandsbeiwert");
        }
        else throw new TDBadDataException("The key 'Widerstandsbeiwert' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Rollwiderstandsbeiwert")){
            this.rollResistanceCoef = (Double) jsonObject.get("Rollwiderstandsbeiwert");
        }
        else throw new TDBadDataException("The key 'Rollwiderstandsbeiwert' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Daempfungswiderstandsbeiwert")){
            this.dampingResistanceCoef = (Double) jsonObject.get("Daempfungswiderstandsbeiwert");
        }
        else throw new TDBadDataException("The key 'Daempfungswiderstandsbeiwert' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Luftwiderstandsbeiwert")){
            this.dragResistanceCoef = (Double) jsonObject.get("Luftwiderstandsbeiwert");
        }
        else throw new TDBadDataException("The key 'Luftwiderstandsbeiwert' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Wirkungsgrad")){
            this.efficiency = ((Long)jsonObject.get("Wirkungsgrad")).intValue();
        }
        else throw new TDBadDataException("The key 'Wirkungsgrad' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Bremskraftfaktortabelle")){
            this.breakForceFactorTable = new ForceFactorTable((JSONObject)jsonObject.get("Bremskraftfaktortabelle"));
        }
        else throw new TDBadDataException("The key 'Bremskraftfaktortabelle' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Zugkraftfaktortabelle")){
            this.driveForceFactorTable = new ForceFactorTable((JSONObject) jsonObject.get("Zugkraftfaktortabelle"));
        }
        else throw new TDBadDataException("The key 'Zugkraftfaktortabelle' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("TlvTafelAntrieb")){
            JSONArray tempJsonArray = (JSONArray) jsonObject.get("TlvTafelAntrieb");
            this.driveTlV = new ArrayList<>();

            for (Object item : tempJsonArray){
                this.driveTlV.add(new TlVTable((JSONObject)item));
            }
        }
        else throw new TDBadDataException("The key 'TlvTafelAntrieb' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("TlvTafelBremsen")){
            JSONArray tempJsonArray = (JSONArray) jsonObject.get("TlvTafelBremsen");
            this.breakTlV= new ArrayList<>();

            for (Object item : tempJsonArray){
                this.breakTlV.add(new TlVTable((JSONObject)item));
            }
        }
        else throw new TDBadDataException("The key 'TlvTafelBremsen' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Verbrauchsdiagramm")){
            this.consumptionDiagram = new Diagram((JSONObject)jsonObject.get("Verbrauchsdiagramm"));
        }
        else throw new TDBadDataException("The key 'Verbrauchsdiagramm' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Rekuperationsdiagramm")){
            this.recuperationDiagram = new Diagram((JSONObject) jsonObject.get("Rekuperationsdiagramm"));
        }
        else throw new TDBadDataException("The key 'Rekuperationsdiagramm' was missing in the trainCar data send by the tool TrainConfigurator");
    }

    /*
    Getters
     */

    public int getUicID() {
        return uicID;
    }

    public boolean isPressureSupport() {
        return pressureSupport;
    }

    public String getDrive() {
        return drive;
    }

    public List<String> getElectricalSystems() {
        return electricalSystems;
    }

    public List<String> getTrainControlSystems() {
        return trainControlSystems;
    }

    public int getMaxHourlyOutput() {
        return maxHourlyOutput;
    }

    public int getMaxSustainedPower() {
        return maxSustainedPower;
    }

    public double getPerformanceIndicator() {
        return performanceIndicator;
    }

    public int getPeakPower() {
        return peakPower;
    }

    public int getTractiveForceAtStart() {
        return tractiveForceAtStart;
    }

    public int getDriveWeelDiameter() {
        return driveWeelDiameter;
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

    public int getServiceWeight() {
        return serviceWeight;
    }

    public double getCrossSection() {
        return crossSection;
    }

    public double getResistanceCoefficient() {
        return resistanceCoefficient;
    }

    public double getRollResistanceCoef() {
        return rollResistanceCoef;
    }

    public double getDampingResistanceCoef() {
        return dampingResistanceCoef;
    }

    public double getDragResistanceCoef() {
        return dragResistanceCoef;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public ForceFactorTable getBreakForceFactorTable() {
        return breakForceFactorTable;
    }

    public ForceFactorTable getDriveForceFactorTable() {
        return driveForceFactorTable;
    }

    public List<TlVTable> getDriveTlV() {
        return driveTlV;
    }

    public List<TlVTable> getBreakTlV() {
        return breakTlV;
    }

    public Diagram getConsumptionDiagram() {
        return consumptionDiagram;
    }

    public Diagram getRecuperationDiagram() {
        return recuperationDiagram;
    }
}
