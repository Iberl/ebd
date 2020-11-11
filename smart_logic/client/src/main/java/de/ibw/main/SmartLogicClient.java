package de.ibw.main;

import com.google.gson.Gson;
import de.ibw.hanlder.ClientHandler;
import de.ibw.tms.intf.SmartClient;
import de.ibw.tms.intf.SmartClientHandler;
import ebd.rbc_tms.util.exception.MissingInformationException;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Client(TMS) zur SmartLogic
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
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
            InputStream InStream = SmartLogicClient.class.getClassLoader().getResourceAsStream(jsonStringOrFileName);
                    if (InStream == null) {

                    }

                    String jsonString = null;

                    try {
                        jsonString = convertInputStreamToString(InStream);
                        if(jsonString.isEmpty()) {
                            System.out.println("Input is no json or json-Resource-File");
                            continue;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
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





    private static String convertInputStreamToString(InputStream inputStream)
            throws IOException {

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }

        return result.toString(StandardCharsets.UTF_8.name());

    }


}
