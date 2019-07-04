package ebd.trainData;

import ebd.trainData.util.*;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ebd.trainData.util.exceptions.TDBadDataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * @author Lars Schulze-Falck
 */
public class TrainDataPerma {

    /**
     * The internal id of the Train
     */
    @NotNull
    private String id = "";

    /**
     * The name the Train
     */
    @NotNull
    private String name = "";

    /**
     * {@link ebd.messageLibrary.util.ETCSVariables#L_TRAIN}
     * Given in [m]
     */
    private int L_TRAIN;

    /**
     * {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     * Given in [km/h]/5 with a resolution of 5 km/h
     */
    private int V_MAXTRAIN;

    /**
     * Weight of Train in tonnes (1000 Kg)
     */
    private int trainWeight;

    /**
     * UIC letters h z or ee present
     */
    private boolean uicLettersHZEE;

    /**
     * UIC letters n or y present
     */
    private boolean uicLettersNY;

    /**
     * UIC letter a present
     */
    private boolean uicLetterA;

    /**
     * Dimensionless massfactor
     */
    private double massfactor;




   /*
   Data for breaking ability calculations
   */


    /**
     * Number of axis on the train
     */
    private int numberOfAxis;

    /**
     * Number of axis with breaks
     */
    private int numberOfBreakAxis;

    /**
     * Available breaking percentage
     */
    private double breakPercent;

    /**
     * ep break present
     */
    private boolean epBreak;

    /**
     * rigid coupling present
     */
    private boolean rigidCoupling;


    /**
     * List of train cars with more details about the train, including chosen breaking method and breaking weight
     */
    List<TrainCar> trainCarList = new ArrayList<>();




    public TrainDataPerma(String trainConfiguraterIP, String trainID) throws IOException, ParseException, TDBadDataException {
        setInstance(trainConfiguraterIP,trainID);
    }

    private void setInstance(String trainConfiguratorIP, String trainID) throws IOException, ParseException, TDBadDataException {
        /*
        Getting the Json Object from the tool "Zug Konfigurator", a web based train configuration tool.
         */
        //TODO Give URL by config file
        JSONParser parser = new JSONParser();
        Object Object;

        String urlName = trainConfiguratorIP + "/rest/zug/extended/" + trainID;
        URL url = new URL(urlName);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode != 200){
            throw new TDBadDataException("The train " + trainID + " could not be read from the tool TrainConfigurator. Response code was " + responseCode);
        }

        /*
        Reading the input data into the variables
         */

        try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            //System.out.println(input.readLine());
            Object = parser.parse(input);
            JSONObject jsonObject = (JSONObject) Object;
            Set<Object> jsonObjectKeySet = jsonObject.keySet();



            if (jsonObjectKeySet.contains("Name")){
                this.name = (String)jsonObject.get("Name");
            }
            else throw new TDBadDataException("The key 'Name' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("EtcsEngineID")){
                this.id = String.valueOf(jsonObject.get("EtcsEngineID"));
            }
            else throw new TDBadDataException("The key 'EtcsEngineID' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("GesamtlaengeUeberPuffer")){
                Long tempLong = (Long)jsonObject.get("GesamtlaengeUeberPuffer") / 1000; //Resolution is given in [mm], we need [m]
                tempLong += 1; //To always round up
                this.L_TRAIN = tempLong.intValue();
            }
            else throw new TDBadDataException("The key 'GesamtlaengeUeberPuffer' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("Hoechstgeschwindigkeit")){
                Long tempLong = (Long)jsonObject.get("Hoechstgeschwindigkeit");
                this.V_MAXTRAIN = tempLong.intValue() / 5; //To get to [km/h]/5
            }
            else throw new TDBadDataException("The key 'Hoechstgeschwindigkeit' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("Gesamtgewicht")){
                Long tempLong = (Long)jsonObject.get("Gesamtgewicht");
                this.trainWeight = tempLong.intValue() / 1000; //We get [kg] need [t]
            }
            else throw new TDBadDataException("The key 'Gesamtgewicht' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("KennbuchstabeHZEE")){
                this.uicLettersHZEE = (boolean)jsonObject.get("KennbuchstabeHZEE");
            }
            else throw new TDBadDataException("The key 'KennbuchstabeHZEE' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("KennbuchstabeNY")){
                this.uicLettersNY = (boolean)jsonObject.get("KennbuchstabeNY");
            }
            else throw new TDBadDataException("The key 'KennbuchstabeNY' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("KennbuchstabeA")){
                this.uicLetterA = (boolean)jsonObject.get("KennbuchstabeA");
            }
            else throw new TDBadDataException("The key 'KennbuchstabeA' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("Massenfaktor")){
                this.massfactor = (Double)jsonObject.get("Massenfaktor");
            }
            else throw new TDBadDataException("The key 'Massenfaktor' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("GesamtanzahlAchsen")){
                Long tempLong = (Long)jsonObject.get("GesamtanzahlAchsen");
                this.numberOfAxis = tempLong.intValue();
            }
            else throw new TDBadDataException("The key 'GesamtanzahlAchsen' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("AnzahlGebremsteAchsen")){
                Long tempLong = (Long)jsonObject.get("AnzahlGebremsteAchsen");
                this.numberOfBreakAxis = tempLong.intValue();
            }
            else throw new TDBadDataException("The key 'AnzahlGebremsteAchsen' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("vorhandeneBremshundertstel")){
                this.breakPercent = (Double)jsonObject.get("vorhandeneBremshundertstel");
                //TODO Check values from train configurator
            }
            else throw new TDBadDataException("The key 'vorhandeneBremshundertstel' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("epBremse")){
                this.epBreak = (boolean)jsonObject.get("epBremse");
            }
            else throw new TDBadDataException("The key 'epBremse' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("straffGekoppelt")){
                this.rigidCoupling = (boolean)jsonObject.get("straffGekoppelt");
            }
            else throw new TDBadDataException("The key 'straffGekoppelt' was missing in the train data send by the tool TrainConfigurator");

            if (jsonObjectKeySet.contains("Fahrzeuge")){
                this.trainCarList = getTrainCars((JSONArray)jsonObject.get("Fahrzeuge"));
            }
            else throw new TDBadDataException("The key 'Fahrzeuge' was missing in the train data send by the tool TrainConfigurator");
        }


    }


    private List<TrainCar> getTrainCars(JSONArray jsonArray) throws TDBadDataException {
        List<TrainCar> trainCarList = new ArrayList<>();

        for (Object entry : jsonArray){
            JSONObject jsonObject = (JSONObject) entry;
            String carType;

            if(jsonObject.containsKey("Fahrzeugart")){
                carType = (String)jsonObject.get("Fahrzeugart");
            }
            else throw new TDBadDataException("The key 'Fahrzeugart' was missing in the train data send by the tool TrainConfigurator");

            TrainCar trainCar;

            if(carType.equals("Triebzug")){
                this.trainCarList.add(new LocomotiveTrain(jsonObject));
            }
            else if(carType.equals("Triebfahrzeug")){
                this.trainCarList.add(new Locomotive(jsonObject));
            }
            else if(carType.equals("Reisezugwagen")){
                this.trainCarList.add(new PassengerCar(jsonObject));
            }
            else if(carType.equals("Gueterwagen")){
                this.trainCarList.add(new FreightCar(jsonObject));
            }
            else throw new TDBadDataException("Unknown type of train car in the data send by the tool TrainConfigurator");
        }

        return trainCarList;
    }

    /*
    Getter
     */

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getL_TRAIN() {
        return L_TRAIN;
    }

    public int getV_MAXTRAIN() {
        return V_MAXTRAIN;
    }

    public int getTrainWeight() {
        return trainWeight;
    }

    public boolean isUicLettersHZEE() {
        return uicLettersHZEE;
    }

    public boolean isUicLettersNY() {
        return uicLettersNY;
    }

    public boolean isUicLetterA() {
        return uicLetterA;
    }

    public double getMassfactor() {
        return massfactor;
    }

    public int getNumberOfAxis() {
        return numberOfAxis;
    }

    public int getNumberOfBreakAxis() {
        return numberOfBreakAxis;
    }

    public double getBreakPercent() {
        return breakPercent;
    }

    public boolean isEpBreak() {
        return epBreak;
    }

    public boolean isRigidCoupling() {
        return rigidCoupling;
    }

    public List<TrainCar> getTrainCarList() {
        return trainCarList;
    }
}
