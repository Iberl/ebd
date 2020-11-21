package de.ibw.main;

import com.google.gson.Gson;
import de.ibw.handler.ClientHandler;
import de.ibw.tms.intf.SmartClient;
import ebd.globalUtils.fileHandler.FileHandler;
import ebd.rbc_tms.util.exception.MissingInformationException;

import java.io.*;
import java.util.stream.Collectors;

/**
 * Client(TMS) zur SmartLogic
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-11
 */
public class SmartLogicClient extends SmartClient {

    public ClientHandler CH = new ClientHandler();

    /**
     * Dieser Konstruktor erstellt den Client.
     *
     * @param sHost - Host-ip der SmartLogic.
     * @param iPort - Port des SmartLogic-Host
     */
    public SmartLogicClient(String sHost, int iPort) {
        super(sHost, iPort);
    }

    /**
     * Default Konstruktor
     *
     */
    public SmartLogicClient() {
        super(null, 33330);
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


    public static boolean isJSONValid(String jsonInString) {
            try {
                gson.fromJson(jsonInString, Object.class);
                return true;
            } catch(com.google.gson.JsonSyntaxException ex) {
                return false;
            }
        }

    private static SmartLogicClient SlClient = null;

    public static void main(String[] args) {
        BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
        String jsonStringOrFileName = "";
        while(true) {
            System.out.println("Enter Cmd or json: ");
            try {
                jsonStringOrFileName = R.readLine();
                System.out.println("Entered: " + jsonStringOrFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (jsonStringOrFileName.equals("start")) {
                    SlClient = new SmartLogicClient();
                    SlClient.start();
                    continue;
            }
            String jsonString = null;
            try {
                FileReader jsonReaded = FileHandler.readConfigurationFile("slClientCmd/" +  jsonStringOrFileName);
                try {
                    jsonString = convertInputStreamToString(jsonReaded);
                    if(jsonString.isEmpty()) {
                        System.out.println("Input is no json or json-Resource-File");
                        continue;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("Json-File not found");
                continue;
            }





                    if (isJSONValid(jsonString)) {

                            String finalJsonString = jsonString;
                            if(SlClient == null) {
                                SlClient = new SmartLogicClient();
                                SlClient.start();
                            }
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


                    } else {
                        System.out.println("File: " + jsonStringOrFileName + " contains no json.");
                    }
                }
            }





    private static String convertInputStreamToString(FileReader input)
            throws IOException {

        BufferedReader in = new BufferedReader(input);
        StringBuilder sb = new StringBuilder();
        return in.lines().collect(Collectors.joining());



    }


}
