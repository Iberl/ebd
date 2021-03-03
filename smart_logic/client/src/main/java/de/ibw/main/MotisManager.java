package de.ibw.main;


import org.springframework.amqp.AmqpConnectException;
import org.springframework.amqp.AmqpException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidParameterException;
import java.util.Properties;
import java.util.stream.Collectors;


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
        String url = classLoader.getResource("motis/" + scenarioID).toExternalForm();

        return new File(url);
    }




    public static void sendMotisFiles() throws IOException, URISyntaxException {


        String scenarioID = getScenarioName();
        // abort it is in timetable
        if(scenarioID.equals("Scenario_1")) return;


        sendSzenarioToMotis(scenarioID);
    }

    public static void sendSzenarioToMotis(String scenarioID) throws IOException {
        ClassLoader classLoader = MethodHandles.lookup().getClass().getClassLoader();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);


        Resource[] motisResources = resolver.getResources("classpath:motis/" + scenarioID + "/*/*.json");
        if (motisResources != null && motisResources.length > 0) {
            for (Resource MotisResource : motisResources) {



                    new Thread() {
                        @Override
                        public void run() {



                            String msg = null;
                                try {
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(MotisResource.getInputStream()));
                                    msg = reader.lines().collect(Collectors.joining("\n"));

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                try {
                                    SmartLogicClient.MotisProducer.produceMsg(msg);
                                } catch (Exception Aex) {
                                    Aex.printStackTrace();
                                }
                            }

                    }.start();



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
