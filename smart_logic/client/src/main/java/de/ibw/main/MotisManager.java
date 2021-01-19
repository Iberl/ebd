package de.ibw.main;


import org.springframework.amqp.AmqpException;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidParameterException;
import java.util.Properties;


public class MotisManager {




    private static FilenameFilter jsonFilter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".json");
        }
    };

    private static String getScenarioName() throws IOException {
        Properties prop = new Properties();
        String fileName = "app.config";
        InputStream is = null;
        try {
            is = MotisManager.class.getClassLoader().getResourceAsStream("motis/motis.config");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        try {
            prop.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return prop.getProperty("ScenarioId");
    }

    private static File getScenarioDirectory() throws IOException, URISyntaxException {
        String scenarioID = getScenarioName();
        ClassLoader classLoader = MotisManager.class.getClassLoader();
        URL url = classLoader.getResource("motis/" + scenarioID);

        return new File(new URI(url.toString()));
    }




    public static void sendMotisFiles() throws IOException, URISyntaxException {
        File ScenarioDirectory = getScenarioDirectory();
        File[] subDirectories = ScenarioDirectory.listFiles();
        if (subDirectories != null) {
            for (File child : subDirectories) {
                if(child.isDirectory()) {
                    File[] jsonFiles = child.listFiles(jsonFilter);
                    for(File MotisJsonFile : jsonFiles) {
                       Path path = Path.of(MotisJsonFile.getAbsolutePath());
                       String msg = Files.readString(path);

                       try {
                           SmartLogicClient.MotisProducer.produceMsg(msg);
                       } catch(AmqpException Aex) {
                           Aex.printStackTrace();
                       }
                    }
                }
            }
        } else {
            throw new InvalidParameterException("Scenario-Directory is not valid");
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        MotisManager M = new MotisManager();
        M.sendMotisFiles();
    }




}
