package de.ibw.main;

import com.google.gson.Gson;
import de.ibw.handler.ClientHandler;
import de.ibw.schedule.TmsScheduler;
import de.ibw.tms.entities.TimeTaskRepository;
import de.ibw.tms.entities.TmsJpaApp;
import de.ibw.tms.intf.SmartClient;
import de.motis.producer.MotisProducer;
import ebd.SlConfigHandler;
import ebd.rbc_tms.util.exception.MissingInformationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Client(TMS) zur smartLogic
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-11
 */
public class SmartLogicClient extends SmartClient {


    private static final Logger log = LoggerFactory.getLogger(SmartLogicClient.class);

    /**
     * Motis Anbindung
     */
    public static MotisProducer MotisProducer;


    private TmsScheduler RequestScheduler;

    /**
     * Verwaltet Kommunikation vom TMS mit der smartLogic
     */
    public ClientHandler CH = null;

    private TimeTaskRepository timeTaskRepository;

    private String sTmsId = "1";
    private String sRbcId = "1";

    /**
     * startet Scheduler zum senden der Tms-Befehle in der Datenbank
     * @throws MissingInformationException - kann Fehler werfen
     */
    public void startScheduler() throws MissingInformationException {

        this.RequestScheduler.start();
    }


    /**
     * Dieser Konstruktor erstellt den Client. unused
     *
     * @param sHost - Host-ip der SmartLogic.
     * @param iPort - Port des SmartLogic-Host
     */
    public SmartLogicClient(String sHost, int iPort) {
        super(sHost, iPort);
    }

    /**
     * Dieser Konstruktor erstellt den Client.
     *
     * @param timeTaskRepository
     * @param sHost - Host-ip der SmartLogic.
     * @param iPort - Port des SmartLogic-Host
     */
    public SmartLogicClient(TimeTaskRepository timeTaskRepository, String sHost, int iPort) {
        super(sHost, iPort);
        this.timeTaskRepository = timeTaskRepository;
        this.RequestScheduler = new TmsScheduler(this, this.timeTaskRepository);
        this.CH = new ClientHandler(this);
    }

    public String getsTmsId() {
        return sTmsId;
    }

    public void setsTmsId(String sTmsId) {
        this.sTmsId = sTmsId;
    }

    public String getsRbcId() {
        return sRbcId;
    }

    public void setsRbcId(String sRbcId) {
        this.sRbcId = sRbcId;
    }

    /**
     * @deprecated
     */
    private void evalRepo(){

        //for (CheckMovementPermissionDAO MovePerm : permissionRepository.findAll()) {
            //System.out.println(MovePerm.getId());
            //try {


                //TmsMovementPermissionRequest TPR = new TmsMovementPermissionRequest("1", "1",
               //         CheckPermissionConverter.convert(MovePerm)
               // );
               // String sJson = TPR.parseToJson();
               // sendJsonWhenValid(sJson);
           // } catch (MissingInformationException e) {
           //     e.printStackTrace();
           // }
        //}
    }

    @Override
    public void run() {
        try {
            startSmartLogicClient(CH);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final Gson gson = new Gson();

    /**
     * Pruefmethode ob ein Json-String Valide ist
     * @param jsonInString - String der zu pruefen ist
     * @return boolean - true wenn der String valide ist.
     */
    public static boolean isJSONValid(String jsonInString) {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    private static SmartLogicClient SlClient = null;


    /**
     * uebernimmt buisness logic und Steuereingaben in der Konsole.
     * Sobald start eingegeben wurde, wird die TMS-Datenbank eingelesen und die Verbindung zur smartLogic aufgebaut.
     * @param repository - verwaltet TMS Datenbank-Anbindung
     */
    public static void proceedTmsLogic(TimeTaskRepository repository) {


        BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
        String jsonStringOrFileName = "";
        while (true) {
            System.out.println("Enter Cmd: ");
            try {
                jsonStringOrFileName = R.readLine();
                System.out.println("Entered: " + jsonStringOrFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (jsonStringOrFileName.equals("start")) {
                String slHostIp = TmsJpaApp.Config.getIpToSmartLogic4TMS();
                int iPort = Integer.parseInt(TmsJpaApp.Config.getPortOfSmartLogic4TMS());
                SlClient = new SmartLogicClient(repository, slHostIp, iPort);
                SlClient.start();
                break;
            }
            String jsonString = null;
            /*try {
                FileReader jsonReaded = FileHandler.readConfigurationFile("slClientCmd/" + jsonStringOrFileName);
                try {
                    jsonString = convertInputStreamToString(jsonReaded);
                    if (jsonString.isEmpty()) {
                        System.out.println("Input is no json or json-Resource-File");
                        continue;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("Json-File not found");
                continue;
            }*/



        }
        //SlClient.evalRepo();

    }

    /**
     * @deprecated
     * @param jsonString
     */
    private static void sendJsonWhenValid(String jsonString) {

        if (isJSONValid(jsonString)) {

            String finalJsonString = jsonString;
            if (SlClient == null) {
                System.out.println("Client not startet");
                String slHostIp = TmsJpaApp.Config.getIpToSmartLogic4TMS();
                Integer iPort = Integer.valueOf(TmsJpaApp.Config.getPortOfSmartLogic4TMS());
                SlClient = new SmartLogicClient(SlClient.timeTaskRepository, slHostIp, iPort);
                SlClient.start();
                System.out.println("Client startet now.");
            }
            /*
            new Thread() {
                @Override
                public void run() {
                    try {

                        SlClient.CH.sendCommand(finalJsonString);
                    } catch (MissingInformationException e) {
                        e.printStackTrace();
                    }
                }
            }.start();



             */
        } else {
            System.out.println("Json inalid");
        }
    }


    private static String convertInputStreamToString(FileReader input)
            throws IOException {

        BufferedReader in = new BufferedReader(input);
        StringBuilder sb = new StringBuilder();
        return in.lines().collect(Collectors.joining());



    }


}
