package ebd;
import java.io.*;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.Properties;

/**
 * This class holds the configuration parameters, which it reads out of the config.txt file.
 *<br>
 * It acts as a singelton.
 *<br>
 * To expand the configuration parameters, include a class variable with the same name as the parameter in the txt file.
 * Test for this parameters type in the loadConfig method. If the value of the variable is not represented by its toString
 * method (for example lists), it also has to be included in the saveCurrent method, for special handling.
 * @author Lars Schulze-Falck
 * Weiterentwickelt von
 * @author iberl@verkehr.tu-darmstadt.de
 * @since 22.03.2021
 * @version 1.0
 *
 */
public class SlConfigHandler {


    private static String sPropFileName = "application.properties";


    /**
     * do not change
     * @return properties file name
     */
    public static String getAppPropFile() {
        return sPropFileName;
    }
    public static void setAppPropFileName(String sName) {
        sPropFileName = sName;
    }


    private static SlConfigHandler single_instance = null;

    /*
    Strings
    */
    public String app_name = "Dummy_Name";
    public String app_version = "Beta";
    public String app_date = "01.01.2021";

    public String ipToInfrastructureServer = "server1.ebd.signallabor.de";
    public int portOfInfrastructureServer = 1436;


    public String ipToSmartLogic4TMS = "127.0.0.1";
    public String portOfSmartLogic4TMS = "33330";

    public String portOfGUIServer4SL = "11112";

    public String portOfGUIServer4TMS = "11114";

    public String ipOfRBCServer = "127.0.0.1";

    //External Port for RBC
    public String portOfTMSServer = "22223";

    // debug prints
    boolean isEventDebugPrint = false;


    // External Port To RBC
    public String portOfRBCServer = "22224";



    /*
    ints
     */


    // Das Base Interface aller topologischer Modelle hat eine G&uuml;ltigkeit bis zu X-Monaten
    public int defaultAmountOfMonthBaseObjectIsValidTo = 3;


    // Standard Dauer fuer Weichenstellvorgaenge in ms
    public int defaultOperationTime = 500;



    /*
    longs
     */
    /*
    Message Priorities in Transmission Queues
    lowest value is send first
     */
     /*
     Priority for Check a CrossingSwitchCommand from TMS to SL
      */
    public long lCheckDbdCommand = 3L;

    /*
    Priory für SL Antworten an das TMS, als Antwort zum Prüfen eines Stellbefehlt
     */
    public long lCheckDbdReturn = 3L;

    /*
    doubles
     */

    /**
     * Die L&auml;nge des Zuges in Meter, falls das RBC keine Angabe gemacht hat.
     */
    public double D_DEFAULT_MIN_LENGTH = 10d;

    /*
    boolean
     */

    public boolean useInfrastructureServer = true;

    public boolean isInTestMode = true;

    public boolean checkPlanPro = false;

    public boolean sendMotisFiles = true;

    public boolean byPassSmartLogicControl = false;

    public boolean initCrossoversInRealdDbdClient = false;
    public boolean shallUserPrompt4SimulationFile = false;
    /*
    Scenario 2
     */
    public boolean train1StartingInTrackDirection = false;
    public boolean train2StartingInTrackDirection = false;





    /*
    streckenkilometrierung Strecke 2000 Balise 4731 ist Absteigend vom Rand gesehen
     */

    public boolean isTrackPosition_2000_4731_Upward = false;

    /*
    other
     */




    /**
     * Set private to stop instantiation
     *
     * @throws IOException If config.txt file was not found
     */
    private SlConfigHandler() throws IOException {


            Properties prop = new Properties();

            InputStream is = null;
            try {
                is = SlConfigHandler.class.getClassLoader().getResourceAsStream(getAppPropFile());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
            if(is == null) throw new InvalidParameterException("application.properties not in resources");
            try {
                prop.load(is);

                initGlobalVar(prop);


            } catch (IOException ex) {
                ex.printStackTrace();
                throw ex;
            }


    }

    private void initGlobalVar(Properties prop) {
        this.app_name = prop.getProperty("application.name");
        this.app_version = prop.getProperty("application.version");
        this.app_date = prop.getProperty("application.date");
        this.ipToSmartLogic4TMS = prop.getProperty("ipToSmartLogic4TMS");
        this.portOfSmartLogic4TMS = prop.getProperty("portOfSmartLogic4TMS");

        this.isEventDebugPrint = Boolean.parseBoolean(prop.getProperty("event_print_debug"));
        this.portOfGUIServer4TMS = prop.getProperty("portOfGUIServer4TMS");
        this.portOfGUIServer4SL = prop.getProperty("portOfGUIServer4SL");
        this.ipOfRBCServer = prop.getProperty("ipOfRBCServer");
        this.portOfRBCServer = prop.getProperty("portOfRBCServer");


        this.portOfTMSServer = prop.getProperty("portOfTMSServer");



        this.lCheckDbdReturn = Long.parseLong(prop.getProperty("lCheckDbdReturn"));
        this.lCheckDbdCommand = Long.parseLong(prop.getProperty("lCheckDbdCommand"));
        this.defaultAmountOfMonthBaseObjectIsValidTo = Integer.parseInt(prop.getProperty("defaultAmountOfMonthBaseObjectIsValidTo"));
        this.useInfrastructureServer = Boolean.parseBoolean(prop.getProperty("useInfrastructureServer"));

        this.ipToInfrastructureServer = prop.getProperty("ipToInfrastructureServer");
        this.portOfInfrastructureServer = Integer.parseInt(prop.getProperty("portOfInfrastructureServer"));
        this.initCrossoversInRealdDbdClient = Boolean.parseBoolean(prop.getProperty("initCrossoversInRealdDbdClient"));
        this.shallUserPrompt4SimulationFile = Boolean.parseBoolean(prop.getProperty("shallUserPrompt4SimulationFile"));


        this.defaultOperationTime = Integer.parseInt(prop.getProperty("defaultOperationTime"));

        this.isInTestMode = Boolean.parseBoolean(prop.getProperty("isInTestMode"));
        this.checkPlanPro = Boolean.parseBoolean((prop.getProperty("checkPlanPro")));
        this.sendMotisFiles = Boolean.parseBoolean((prop.getProperty("sendMotisFiles")));
        this.byPassSmartLogicControl = Boolean.parseBoolean((prop.getProperty("byPassSmartLogicControl")));
    }

    /**
     * Loads the default values for the config
     * @throws IOException if config-default file is not found
     */
    public void loadDefault() throws IOException {
        loadConfig(true);
    }

    /**
     * This Method takes the current state of the ConfigStore and writes it to the config.txt file.
     *
     * @throws IOException If config.txt file was not found
     * @throws IllegalAccessException If a field in ConfigStore was not accessible
     */
    public void saveCurrent() throws IOException, IllegalAccessException {
    /*
    Saving data to the config.txt file
     */

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("resources/config.txt"));
        } catch (IOException e) {
            throw new IOException("The config.txt file could not be opened. " + e.getMessage());
        }

        String[] lines = reader.lines().toArray(String[]::new);

        for (Field field : this.getClass().getFields()) {

            String fieldName = field.getName();

            for (int i = 0; i < lines.length; i++) {
                if (!lines[i].startsWith(fieldName)) continue;

                StringBuilder newline = new StringBuilder(fieldName + " = ");
                Object fieldValue = field.get(this);

                //noinspection SwitchStatementWithTooFewBranches This switch statement increases code readability, only get called once
                switch (fieldName) {
                    /*
                    Inserted configuration variable here for saving if they are to complex to be handled by the default case.
                    This is the case if the value of the variable is not represented by the variable *.toString method.
                     */
                    default:
                        newline.append(fieldValue);
                        break;
                }
                lines[i] = newline.toString();
                break;
            }
        }

        try {
            File file = new File("configuration/sl_config.txt");
            try (PrintStream out = new PrintStream(new FileOutputStream(file))) {
                for (String line : lines) {
                    out.println(line);
                }

            }
        } catch (IOException e) {
            throw new IOException("The config.txt file could not be opened. " + e.getMessage());
        }
    }

    /**
     * Loads the config.txt values from the config.txt or config.txt-default file
     * @param fromDefault If true, the values are loaded from config.txt-default, else config.txt is used
     * @throws IOException If config.txt or config.txt-default are not found
     */
    private void loadConfig(boolean fromDefault) throws IOException {
    /*
    Loading in values from the config.txt or config.txt default file
     */


        String[] stringArray;

        /*
        Try opening the files that store the values to be loaded in
         */
        if(!fromDefault) {

            try{
                BufferedReader reader = new BufferedReader(new FileReader("configuration/sl_config.txt"));
                stringArray = reader.lines().toArray(String[]::new);
            } catch (IOException e) {
                IOException ioe = new IOException("The config file could not be opened. " + e.getMessage());
                ioe.setStackTrace(e.getStackTrace());
                throw ioe;
            }
        }
        else {
            try(InputStream inputStream = getClass().getResourceAsStream("resources/config-default")){
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                stringArray = reader.lines().toArray(String[]::new);
            }catch (IOException e){
                try(BufferedReader reader = new BufferedReader(new FileReader("configuration/config-default"))) {
                    stringArray = reader.lines().toArray(String[]::new);
                } catch (IOException ex) {
                    IOException ioe = new IOException("Neither config-default stream nor " +
                            "config-default file could be opened. " + ex.getMessage());
                    ioe.setStackTrace(ex.getStackTrace());
                    throw ioe;
                }
            }
        }

        /*
        Load in the values
         */
        for (String line : stringArray) {
            String[] split;
            if (line.startsWith("#") || line.length() == 0) continue;

            line = line.replace(" ", "");
            split = line.split("=");

            if (split.length <= 1) continue;

            for (Field field : this.getClass().getFields()) {
                if (!field.getName().equals(split[0])) continue;

                switch (field.getType().getSimpleName()) {
                    //Strings
                    case "String":
                        try {
                            field.set(this, split[1]);
                        } catch (IllegalAccessException ignored) {
                        }
                        break;
                    //Integers
                    case "int":
                    case "Integer":
                        try {
                            field.set(this, Integer.valueOf(split[1]));
                        } catch (IllegalAccessException ignored) {
                        }
                        break;
                    //Doubles
                    case "double":
                    case "Double":
                        try {
                            field.set(this, Double.valueOf(split[1]));
                        } catch (IllegalAccessException ignored) {
                        }
                        break;
                    //Booleans
                    case "boolean":
                    case "Boolean":
                        try {
                            field.set(this, Boolean.valueOf(split[1]));
                        } catch (IllegalAccessException ignored) {
                        }
                        break;
                    default:
                        //TODO Warning ExceptionEvent
                        break;
                }
                break;
            }
        }
    }


    /*
    Getter
     */
    /**
     * Returns the singleton instance of the config store. Should this not be possible, System.exit(-1) is called
     *
     * @return The instance of @{@link SlConfigHandler} or null if this was not possible
     */
    public static SlConfigHandler getInstance() {
        try {
            if (single_instance == null) single_instance = new SlConfigHandler();
            return single_instance;
        }catch (IOException ioe){
            ioe.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

}
