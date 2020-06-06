package ebd.trainData;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.trainData.util.dataConstructs.*;
import ebd.trainData.util.exceptions.TDBadDataException;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * This class contains the permanent information of a train. These values can only be set once per train.
 * The data for this class is loaded from the "Zugkonfigurator" tool, a web app. It can be reached by a REST interface.
 * @author Lars Schulze-Falck
 *
 */
public class TrainDataPerma {

    /**
     * The ID of the Train in the Train Config tool
     */
    private int trainConfigID = 0;

    /**
     * The name the Train
     */
    @NotNull
    private String name = "";

    /**
     * Given in [m]
     */
    private double l_train;

    /**
     * Given in [km/h]
     */
    private int v_maxtrain;

    /**
     * Weight of Train in [kg]
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


    /**
     * Sets the class from the data found in the tool "Zugkonfigurator", a web app.
     *
     * @throws IOException Thrown if there is a problem with the connection to the trainconfigurator
     *
     * @throws ParseException Thrown if there the response from the trainconfigurator can non be parsed
     *
     * @throws TDBadDataException Thrown if the ETCS-ID can not be found in the trainconfigurator of if there is missing
     *                              data in the response.
     */
    public TrainDataPerma(int trainConfigID) throws IOException, ParseException, TDBadDataException {
        this.trainConfigID = trainConfigID;
        if(!ConfigHandler.getInstance().useTrainConfiguratorTool) setInstanceFromFile();
        else setInstanceFromURL();
    }


    /**
     * Sets the instance by parsing the JSONObject that is returned from the app.
     *
     * @throws IOException Thrown if there is a problem with the connection to the trainconfigurator
     *
     * @throws ParseException Thrown if there the response from the trainconfigurator can non be parsed
     *
     * @throws TDBadDataException Thrown if the ETCS-ID can not be found in the trainconfigurator of if there is missing
     *                              data in the response.
     */
    private void setInstanceFromURL() throws IOException, ParseException, TDBadDataException {
        /*
        Getting the Json Object from the tool "Zug Konfigurator", a web based train configuration tool.
         */

        JSONParser parser = new JSONParser();

        String trainConfiguratorIP = ConfigHandler.getInstance().ipToTrainConfigurator;
        String trainConfiguratorPort = ConfigHandler.getInstance().portOfTrainConfigurator;
        String urlName = "http://" + trainConfiguratorIP + ":" + trainConfiguratorPort + "/trainConfig/rest/zug/extended/" + this.trainConfigID;
        URL url = new URL(urlName);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode == 400){
            throw new TDBadDataException("The train " + this.trainConfigID + " could not be found in the tool TrainConfigurator. Response code was " + responseCode);
        }
        else if(responseCode != 200){
            throw new IOException("The train " + this.trainConfigID + " could not be read from the tool TrainConfigurator. Response code was " + responseCode);
        }

        /*
        Reading the input data into the variables
         */
        try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            Object object = parser.parse(input);
            JSONObject jsonObject = (JSONObject) object;

            fillFromJSON(jsonObject);
        }
    }

    /**
     * Sets the instance by parsing the JSONObject that is extracted out of a file. For test cases
     *
     * @throws IOException Thrown if the file could not be read
     *
     * @throws ParseException Thrown if the file could non be parsed
     *
     * @throws TDBadDataException Thrown if there is missing data in the file.
     */
    private void setInstanceFromFile() throws IOException, TDBadDataException, ParseException {
        String pathToTrainJSON = ConfigHandler.getInstance().pathToTestTrainJson;
        try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathToTrainJSON)){
            try(BufferedReader input = new BufferedReader(new InputStreamReader(inputStream))){

            /*
            Reading the input data into the variables
            */
                JSONParser parser = new JSONParser();
                Object object = parser.parse(input);
                JSONObject jsonObject = (JSONObject) object;

                fillFromJSON(jsonObject);
            }
        }
        catch (NullPointerException npe){
            npe.printStackTrace();
            throw npe;
        }


    }

    /**
     * Parses the jsonObject.
     *
     * @param jsonObject containing one JSONObject of the type "Typ"
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    private void fillFromJSON(JSONObject jsonObject) throws TDBadDataException {
        Set<Object> jsonObjectKeySet = jsonObject.keySet();
        if (jsonObjectKeySet.contains("Name")){
            this.name = (String)jsonObject.get("Name");
        }
        else throw new TDBadDataException("The key 'Name' was missing in the train data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("EtcsEngineID")){
            this.trainConfigID = ((Long)jsonObject.get("EtcsEngineID")).intValue();
        }
        else throw new TDBadDataException("The key 'EtcsEngineID' was missing in the train data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("GesamtlaengeUeberPuffer")){
            this.l_train = ((Long)jsonObject.get("GesamtlaengeUeberPuffer") / 1000d); //Resolution is given in [mm], we need [m]
        }
        else throw new TDBadDataException("The key 'GesamtlaengeUeberPuffer' was missing in the train data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Hoechstgeschwindigkeit")){

            this.v_maxtrain = ((Long)jsonObject.get("Hoechstgeschwindigkeit")).intValue();
        }
        else throw new TDBadDataException("The key 'Hoechstgeschwindigkeit' was missing in the train data send by the tool TrainConfigurator");

        if (jsonObjectKeySet.contains("Gesamtgewicht")){
            this.trainWeight = ((Long)jsonObject.get("Gesamtgewicht")).intValue();
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


    private List<TrainCar> getTrainCars(JSONArray jsonArray) throws TDBadDataException {
        List<TrainCar> tCL = new ArrayList<>();

        for (Object entry : jsonArray){
            JSONObject jsonObject = (JSONObject) entry;
            String carType;

            if(jsonObject.containsKey("Fahrzeugart")){
                carType = (String)jsonObject.get("Fahrzeugart");
            }
            else throw new TDBadDataException("The key 'Fahrzeugart' was missing in the train data send by the tool TrainConfigurator");

            switch (carType) {
                case "Triebzug":
                    tCL.add(new LocomotiveTrain(jsonObject));
                    break;
                case "Triebfahrzeug":
                    tCL.add(new Locomotive(jsonObject));
                    break;
                case "Reisezugwagen":
                    tCL.add(new PassengerCar(jsonObject));
                    break;
                case "Gueterwagen":
                    tCL.add(new FreightCar(jsonObject));
                    break;
                default:
                    throw new TDBadDataException("Unknown type of train car in the data send by the tool TrainConfigurator");
            }
        }

        return tCL;
    }

    /*
    Getter
     */

    public int getTrainConfigID() {
        return trainConfigID;
    }

    public String getName() {
        return name;
    }

    public double getL_train() {
        return l_train;
    }

    /**
     * @return maximum speed of train in [km/h]
     */
    public int getV_maxtrain() {
        return v_maxtrain;
    }

    public double getTrainWeight() {
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
