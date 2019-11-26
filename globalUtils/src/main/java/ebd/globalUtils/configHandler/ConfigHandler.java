package ebd.globalUtils.configHandler;

import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import org.greenrobot.eventbus.EventBus;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Collections;

/**
 * This class holds the configuration parameters, which it reads out of the config.txt file.
 *<br>
 * It acts as a singelton.
 *<br>
 * To expand the configuration parameters, include a class variable with the same name as the parameter in the txt file.
 * Test for this parameters type in the loadConfig method. If the value of the variable is not represented by its toString
 * method (for example lists), it also has to be included in the saveCurrent method, for special handling.
 * @author Lars Schulze-Falck
 */
public class ConfigHandler {


    /*
        Strings
         */
    public String pathToDriverProfileJson = "";
    public String pathToTestTrainJson = "";

    public String ipToTrainConfigurator = "";
    public String portOfTrainConfigurator = "";

    public String ipToInfrastructureServer = "";
    public String portOfInfrastructureServer = "";


    /*
    ints
     */
    public int trainClockTickInMS = 100;

    /*
    doubles
     */

    /*
    boolean
     */
    public boolean testing = false;

    /*
    other
     */


    private static ConfigHandler single_instance = null;

    /**
     * Set private to stop instantiation
     *
     * @throws IOException If config.txt file was not found
     */
    private ConfigHandler() throws IOException {

        /*
        Setting up config.txt file if it does not already exists
         */
        File fileConfig = new File("configuration/config.txt");

        if (!fileConfig.exists()) {
            boolean createdDir = fileConfig.getParentFile().mkdir();
            boolean createdFile = fileConfig.createNewFile();
            if(!(createdFile)){
                throw new IOException("Config.txt could not be created");
            }

            try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config-default")) {

                if(inputStream == null) {
                    throw new IOException("The stream config-default could not be found");
                }

                try (FileOutputStream outputStream = new FileOutputStream(fileConfig)) {
                    int length;
                    byte[] buffer = new byte[1024];
                    while ((length = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, length);
                    }
                }catch (IOException ioe){
                    throw new IOException("Configuration file could not be created. " + ioe.getMessage());
                }
            }catch (IOException ioe){
                try(FileInputStream inputStream = new FileInputStream("config-default")) {

                    try (FileOutputStream outputStream = new FileOutputStream("configuration/config.txt")) {
                        int length;
                        byte[] buffer = new byte[1024];
                        while ((length = inputStream.read(buffer)) != -1){
                            outputStream.write(buffer,0,length);
                        }
                    }catch (IOException ioe3){
                        throw new IOException("Configuration file could not be created: " + ioe3.getMessage());
                    }
                }catch (IOException ioe2){
                    throw new IOException(ioe2.getMessage());
                }
            }
        }

        /*
        Loads the config
         */
        loadConfig(false);
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
            File file = new File("configuration/config.txt");
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
                BufferedReader reader = new BufferedReader(new FileReader("configuration/config.txt"));
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
     * Returns the singleton instance of the config store. Should this not be possible, a {@link ExceptionEvent} with
     * {@link ExceptionEventTyp#FATAL} is posted on the global {@link EventBus} and null is returned.
     *
     * @return The instance of @{@link ConfigHandler} or null if this was not possible
     */
    public static ConfigHandler getInstance() {
        try {
            if (single_instance == null) single_instance = new ConfigHandler();
            return single_instance;
        }catch (IOException ioe){
            ExceptionEvent ev = new ExceptionEvent("cfg", Collections.singletonList("all"), new NotCausedByAEvent(),
                    ioe, ExceptionEventTyp.FATAL);
            EventBus.getDefault().post(ev);
        }
        return null;
    }

}
