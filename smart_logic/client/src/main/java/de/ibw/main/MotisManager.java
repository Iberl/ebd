package de.ibw.main;


import ebd.SlConfigHandler;
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

/**
 *  Verwaltet die Nachrichtengenerierung an den Motis-Web-Service
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-19
 */
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


    /**
     * sendet die Dateien, die in den Ressourcen bereitgestellt wurden
     * @throws IOException - kann Fehler werfen
     * @throws URISyntaxException -kann Fehler werfen
     */
    public static void sendMotisFiles() throws IOException, URISyntaxException {


        String scenarioID = getScenarioName();
        // abort it is in timetable
        if(scenarioID.equals("Scenario_1")) return;


        sendSzenarioToMotis(scenarioID);
    }

    /**
     * sendet Dateien zu Motis fuer das angegebenen Szenario
     * @param scenarioID - Name des zu verwendeten Szenarios - "Scenario_1" e.g.
     * @throws IOException - wirft Fehler wenn zur scenarioId kein Dateipfad in den Ressourcen passt
     */
    public static void sendSzenarioToMotis(String scenarioID) throws IOException {

        if(!SlConfigHandler.getInstance().sendMotisFiles) return;

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

    /**
     * Test Methode unused
     * @param args
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        MotisManager M = new MotisManager();
        M.sendMotisFiles();
    }




}
