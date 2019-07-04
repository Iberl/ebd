package ebd.trainData.util;

import ebd.trainData.util.dataConstructs.Breakmethod;
import ebd.trainData.util.dataConstructs.Breaksystem;
import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Lars Schulze-Falck
 */
public class TrainCar {

    /**
     * Type of train car (for example: "Triebfahrzeug")
     */
    private String typeName;

    /**
     * Position in train. 0 is the front position, 1 the second position etc.
     */
    private int positionInTrain;

    /**
     * The breaking weight resulting from the chosen break method. In [kg]
     */
    private Long chosenBreakingWeight;

    /**
     * The chosen break method. (P, G, P+G, etc.)
     */
    private String chosenBreakingMethod;

    /*
    Data from the "Type" field
    */

    /**
     * Type id
     */
    private long typeID;

    /**
     * Axle equation
     */
    private String axleEquation;

    /**
     * Total number of axles
     */
    private int totalNumberOfAxles;

    /**
     * Number of bogies
     */
    private int numberOfBogies;

    /**
     * Number of bogie axles
     */
    private int numberOfBogiesAxles;

    /**
     * Number of single axles;
     */
    private int numberOfSingleAxles;

    /**
     * Length of the car in [m]
     */
    private double length;

    /**
     * Height of the car in [m]
     */
    private double height;

    /**
     * Width of the car in [m]
     */
    private double width;

    /**
     * Axle load (Radsatzfahrmasse) in [kg]
     */
    private int axleLoad;

    /**
     * Axle category
     */
    private String axleCategory;

    /**
     * List of possible {@link Breaksystem} ("Scheibenbremse", "Wirbelstrombremse", etc.)
     */
    private List<Breaksystem> breakingSystems;

    /**
     * List of possible {@link Breakmethod} (P, G, P+G, etc.)
     */
    private List<Breakmethod> breakingMethods;

        /**
     * EP break present
     */
    private boolean epBreak;

    /**
     * Highest allowed speed. In [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    private int maxSpeed;

    /**
     * Track gauge of the train
     */
    private int trackGauge;

    /**
     * Dimensionless massfactor
     */
    private int massfactor;

    /**
     * Dimensionless tunnelfactor
     */
    private int tunnelfactor;


    public TrainCar(JSONObject jsonObject) throws TDBadDataException {
        setInstance(jsonObject);
    }


    private void setInstance(JSONObject jsonObject) throws TDBadDataException {

        Set<String> jsonObjectKeySet = jsonObject.keySet();

        if (jsonObjectKeySet.contains("Fahrzeugart")){
            this.typeName = (String)jsonObject.get("Fahrzeugart");
        }
        else throw new TDBadDataException("The key 'Fahrzeugart' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Position")){
            Long tempLong = (Long)jsonObject.get("Position");
            this.positionInTrain = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Position' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("gewaehlteBremsstellungName")){
            this.chosenBreakingMethod = (String)jsonObject.get("gewaehlteBremsstellungName");
        }
        else throw new TDBadDataException("The key 'gewaehlteBremsstellungName' was missing in the trainCar data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("gewaehlteBremsstellungGewicht")){
            this.chosenBreakingWeight = (Long)jsonObject.get("gewaehlteBremsstellungGewicht");
        }
        else throw new TDBadDataException("The key 'gewaehlteBremsstellungGewicht' was missing in the trainCar data send by the tool TrainConfigurator");

        /*
        Getting the Data from the Typ field
         */
        JSONObject typeJSONObject;

        if (jsonObjectKeySet.contains("Typ")) {
            typeJSONObject = (JSONObject)jsonObject.get("Typ");
        }
        else throw new TDBadDataException("The key 'Typ' was missing in the trainCar data send by the tool TrainConfigurator");

        Set<String> typeJSONObjectKeySet = typeJSONObject.keySet();

        if (typeJSONObjectKeySet.contains("Id")){
            this.typeID = (Long)typeJSONObject.get("Id");
        }
        else throw new TDBadDataException("The key 'Id' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("Achsformel")){
            this.axleEquation = (String)typeJSONObject.get("Achsformel");
        }
        else throw new TDBadDataException("The key 'Achsformel' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("AnzahlAchsenGesamt")){
            Long tempLong = (Long)typeJSONObject.get("AnzahlAchsenGesamt");
            this.totalNumberOfAxles = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'AnzahlAchsenGesamt' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("AnzahlDrehgestelle")){
            Long tempLong = (Long)typeJSONObject.get("AnzahlDrehgestelle");
            this.numberOfBogies = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'AnzahlDrehgestelle' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("AnzahlDrehgestellachsen")){
            Long tempLong = (Long)typeJSONObject.get("AnzahlDrehgestellachsen");
            this.numberOfBogiesAxles = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'AnzahlDrehgestellachsen' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("AnzahlEinzelachsen")){
            Long tempLong = (Long)typeJSONObject.get("AnzahlEinzelachsen");
            this.numberOfSingleAxles = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'AnzahlEinzelachsen' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("LaengeUeberPuffer")){
            this.length = (Long)typeJSONObject.get("LaengeUeberPuffer") / 1000d; //We need [m], given is [mm]
        }
        else throw new TDBadDataException("The key 'LaengeUeberPuffer' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("Hoehe")){
            this.height = (Long)typeJSONObject.get("Hoehe") / 1000d;
        }
        else throw new TDBadDataException("The key 'Hoehe' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("Breite")){
            this.width = (Long)typeJSONObject.get("Breite") / 1000d;
        }
        else throw new TDBadDataException("The key 'Breite' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("Radsatzfahrmasse")){
            Long tempLong = (Long)typeJSONObject.get("Radsatzfahrmasse");
            this.axleLoad = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Radsatzfahrmasse' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("Achslastkategorie")){
            this.axleCategory = (String)typeJSONObject.get("Achslastkategorie");
        }
        else throw new TDBadDataException("The key 'Achslastkategorie' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("Achslastkategorie")){
            this.axleCategory = (String)typeJSONObject.get("Achslastkategorie");
        }
        else throw new TDBadDataException("The key 'Achslastkategorie' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("verfuegbareBremssysteme")){
            JSONArray tempArray = (JSONArray) typeJSONObject.get("verfuegbareBremssysteme");
            this.breakingSystems = getBreakingSystems(tempArray);
        }
        else throw new TDBadDataException("The key 'verfuegbareBremssysteme' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("verfuegbareBremsstellungen")){
            JSONArray tempArray = (JSONArray) typeJSONObject.get("verfuegbareBremsstellungen");
            this.breakingMethods = getBreakingMethods(tempArray);
        }
        else throw new TDBadDataException("The key 'verfuegbareBremsstellungen' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("Hoechstgeschwindigkeit")){
            Long tempLong = (Long) typeJSONObject.get("Hoechstgeschwindigkeit");
            this.maxSpeed = tempLong.intValue() / 5;
        }
        else throw new TDBadDataException("The key 'Hoechstgeschwindigkeit' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("Spurweite")){
            Long tempLong = (Long)typeJSONObject.get("Spurweite");
            this.trackGauge = tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Spurweite' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("EpBremse")){
            this.epBreak = (boolean)typeJSONObject.get("EpBremse");
        }
        else throw new TDBadDataException("The key 'EpBremse' was missing in the trainType data send by the tool TrainConfigurator");

        if (typeJSONObjectKeySet.contains("Massenfaktor")){
            Long tempLong = (Long)typeJSONObject.get("Massenfaktor");
            this.massfactor =tempLong.intValue();
        }
        else throw new TDBadDataException("The key 'Massenfaktor' was missing in the trainType data send by the tool TrainConfigurator");


    }

    /**
     * Extracts a list of breaksystems
     * @param jsonArray A json Array representing a breaksystem list
     * @return A list of [@link {@link Breaksystem}
     * @throws TDBadDataException If data is not found
     */
    private List<Breaksystem> getBreakingSystems(JSONArray jsonArray) throws TDBadDataException {
        List<Breaksystem> breaksystemList = new ArrayList<>();
        for (Object entry : jsonArray){
            JSONObject jsonObject = (JSONObject)entry;
            Set<String>jsonObjectKeySet = jsonObject.keySet();

            String name;
            int minSpeed;
            int maxSpeed;

            if (jsonObjectKeySet.contains("Bremssystem")){
                name = (String)jsonObject.get("Bremssystem");
            }
            else throw new TDBadDataException("The key 'Bremssystem' was missing in the trainType data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("minGeschwindigkeitsbereich")){
                Long tempLong = (Long)jsonObject.get("minGeschwindigkeitsbereich");
                minSpeed = tempLong.intValue();
            }
            else throw new TDBadDataException("The key 'minGeschwindigkeitsbereich' was missing in the trainType data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("maxGeschwindigkeitsbereich")){
                Long tempLong = (Long)jsonObject.get("maxGeschwindigkeitsbereich");
                maxSpeed = tempLong.intValue();
            }
            else throw new TDBadDataException("The key 'maxGeschwindigkeitsbereich' was missing in the trainType data send by the tool TrainConfigurator");

            breaksystemList.add(new Breaksystem(name,minSpeed / 5,maxSpeed / 5)); //For consistent speed storage in [km/h] / 5
        }

        return breaksystemList;
    }

    /**
     * Extacts a list of breakingmehtods
     * @param jsonArray a {@link JSONArray} that represents a list of breaking methods
     * @return A list of breaking methods
     * @throws TDBadDataException if the data is not found
     */
    private List<Breakmethod> getBreakingMethods(JSONArray jsonArray) throws TDBadDataException {
        List<Breakmethod> breakmethodList = new ArrayList<>();
        for (Object entry : jsonArray){
            JSONObject jsonObject = (JSONObject) entry;
            Set<String> jsonObjectKeySet = jsonObject.keySet();

            String name;
            int breakweight;

            if (jsonObjectKeySet.contains("Bremsstellung")){
                name = (String)jsonObject.get("Bremsstellung");
            }
            else throw new TDBadDataException("The key 'Bremsstellung' was missing in the trainType data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("Bremsgewicht")){
                Long tempLong = (Long) jsonObject.get("Bremsgewicht");
                breakweight = tempLong.intValue();
            }
            else throw new TDBadDataException("The key 'Bremsgewicht' was missing in the trainType data send by the tool TrainConfigurator");

            breakmethodList.add(new Breakmethod(name,breakweight));
        }

        return breakmethodList;
    }

    public String getTypeName() {
        return typeName;
    }

    /**
     *
     * @return The cars position inside the train (starting with 0)
     */
    public int getPositionInTrain() {
        return positionInTrain;
    }

    /**
     *
     * @return chosen breaking weight in [kg]
     */
    public Long getChosenBreakingWeight() {
        return chosenBreakingWeight;
    }

    public String getChosenBreakingMethod() {
        return chosenBreakingMethod;
    }

    public long getTypeID() {
        return typeID;
    }

    public String getAxleEquation() {
        return axleEquation;
    }

    public int getTotalNumberOfAxles() {
        return totalNumberOfAxles;
    }

    public int getNumberOfBogies() {
        return numberOfBogies;
    }

    public int getNumberOfBogiesAxles() {
        return numberOfBogiesAxles;
    }

    public int getNumberOfSingleAxles() {
        return numberOfSingleAxles;
    }

    /**
     *
     * @return Length of the car in [m]
     */
    public double getLength() {
        return length;
    }

    /**
     *
     * @return Height of the car in [m]
     */
    public double getHeight() {
        return height;
    }

    /**
     *
     * @return Width of the car in [m]
     */
    public double getWidth() {
        return width;
    }

    /**
     *
     * @return Axle load (Radsatzfahrmasse) in [kg]
     */
    public int getAxleLoad() {
        return axleLoad;
    }

    public String getAxleCategory() {
        return axleCategory;
    }

    public List<Breakmethod> getBreakingMethods() {
        return breakingMethods;
    }

    public List<Breaksystem> getBreakingSystems() {
        return breakingSystems;
    }

    public boolean isEpBreak() {
        return epBreak;
    }

    /**
     *
     * @return Highest allowed speed. In [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getTrackGauge() {
        return trackGauge;
    }

    public int getMassfactor() {
        return massfactor;
    }

    public int getTunnelfactor() {
        return tunnelfactor;
    }
}
