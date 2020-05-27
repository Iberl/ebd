package ebd.radioBlockCenter;


import ebd.baliseTelegramGenerator.Balise;
import ebd.baliseTelegramGenerator.BaliseGroup;
import ebd.baliseTelegramGenerator.BaliseTelegramGenerator;
import ebd.baliseTelegramGenerator.ListOfBalises;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.logging.Logging;
import ebd.messageLibrary.packet.trackpackets.Packet_0;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import ebd.radioBlockCenter.util.Route;
import ebd.radioBlockCenter.util.SocketClient;
import ebd.radioBlockCenter.util.handlers.TMSMessageHandler;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static ebd.messageLibrary.util.ETCSVariables.M_DUP_NO_DUPLICATE;
import static ebd.messageLibrary.util.ETCSVariables.M_VERSION_2_0;

public class RadioBlockCenter {

    private EventBus localBus;
    private String rbcID;
    private Map<Integer, List<Route>> trainIdsToRouts;

    private MessageSender messageSender;
    private MessageReceiver messageReceiver;

    /*
    Handler
     */
    private Logging logger;
    private TMSMessageHandler messageHandler;

    /*
    trackSide
     */
    private BaliseTelegramGenerator bTG;

    public static void main(String[] args) {
        RadioBlockCenter rbc = new RadioBlockCenter("12", new HashMap<>(), 1);
    }

    public RadioBlockCenter(String rbcID, Map<Integer, List<Route>> trainIdsToRouts, int scenario) {
        this.trainIdsToRouts = trainIdsToRouts;
        this.localBus = new EventBus();
        //this.localBus.register(this);
        this.rbcID = rbcID;
        JSONParser jsonParser = new JSONParser();
        List<int[]> speedSegments = new ArrayList<>();

        ConfigHandler configHandler = ConfigHandler.getInstance();

        if(configHandler.useTSMServer) {

            SocketClient socketClient = new SocketClient("RBC");

            while(true) {
                try {
                    socketClient.request("test");
                    JSONObject resp = (JSONObject) jsonParser.parse((String) socketClient.outputQueue.take());
                    //System.out.println(resp.toJSONString());
                    JSONObject eoa = (JSONObject) resp.get("endOfAuthority");
                    if((boolean) eoa.get("shunting") == true) {
                        break;
                    }

                    JSONObject sp = (JSONObject) resp.get("speedProfile");
                    JSONArray speedSegmentsJSON = (JSONArray) sp.get("speedSegments");

                    for(int i = 0; i < speedSegmentsJSON.size(); i++) {
                        JSONObject curr = (JSONObject) speedSegmentsJSON.get(i);
                        int[] newSegment = new int[3];
                        newSegment[0] = ((Long) ((JSONObject) ((JSONObject) curr.get("begin")).get("chainage")).get("iMeters")).intValue();
                        newSegment[1] = ((Long) ((JSONObject) curr.get("v_STATIC")).get("bSpeed")).intValue() * 5;
                        newSegment[2] = ((Long) ((JSONObject) ((JSONObject) ((JSONObject) speedSegmentsJSON.get(i)).get("end")).get("chainage")).get("iMeters")).intValue();
                        speedSegments.add(newSegment);
                    }

                } catch(Exception e) {
                    System.err.println("Received an Error from TMS");
                    ;
                    e.printStackTrace();
                }

            }
        } else {
            try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(configHandler.pathToSzenarioJSON)){
                try(BufferedReader input = new BufferedReader(new InputStreamReader(inputStream))){

            /*
            Reading the input data into the variables
            */
                    JSONParser parser = new JSONParser();
                    Object object = parser.parse(input);
                    JSONArray jsonArray = (JSONArray) object;

                    for(int j = 0; j < jsonArray.size(); j++) {
                        JSONObject resp = (JSONObject) jsonArray.get(j);
                        //System.out.println(resp.toJSONString());
                        JSONObject eoa = (JSONObject) resp.get("endOfAuthority");
                        if((boolean) eoa.get("shunting") == true) {
                            break;
                        }

                        JSONObject sp = (JSONObject) resp.get("speedProfile");
                        JSONArray speedSegmentsJSON = (JSONArray) sp.get("speedSegments");

                        for(int i = 0; i < speedSegmentsJSON.size(); i++) {
                            JSONObject curr = (JSONObject) speedSegmentsJSON.get(i);
                            int[] newSegment = new int[3];
                            newSegment[0] = ((Long) ((JSONObject) ((JSONObject) curr.get("begin")).get("chainage")).get("iMeters")).intValue();
                            newSegment[1] = ((Long) ((JSONObject) curr.get("v_STATIC")).get("bSpeed")).intValue() * 5;
                            newSegment[2] = ((Long) ((JSONObject) ((JSONObject) ((JSONObject) speedSegmentsJSON.get(i)).get("end")).get("chainage")).get("iMeters")).intValue();
                            speedSegments.add(newSegment);
                        }
                    }


                }
            }
            catch (NullPointerException | IOException | ParseException npe){
                npe.printStackTrace();
            }
        }

        for(int[] segment: speedSegments) {
            //System.out.println("begin: " + segment[0] + " v: " + segment[1] + " end: " + segment[2]);
        }

        try {
            this.logger = new Logging(this.localBus, Integer.parseInt(this.rbcID), "RBC ");
        } catch(IOException e) {
            e.printStackTrace();
        }
        //this.messageHandler = new MessageHandler(this.localBus, this.rbcID, this.trainIdsToRouts, scenario);




        this.messageHandler = new TMSMessageHandler(this.localBus, this.rbcID, speedSegments, scenario);
        this.messageSender = new MessageSender(this.localBus, this.rbcID, false);
        this.messageReceiver = new MessageReceiver(this.localBus, this.rbcID, "all", true);

        this.bTG = createBTG(this.localBus);

        this.localBus.post(new ToLogEvent("rbc", "log", "RBC initialized"));
    }

    private BaliseTelegramGenerator createBTG(EventBus localBus) {
        // Create Empty Instance of ListOfBalise
        ListOfBalises lob = new ListOfBalises(1, 12);

        // Adding BaliseGroups
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 1, 1, 0, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 2, 1, 584, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 3, 2, 398, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 4, 3, 346, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 5, 4, 183, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 6, 5, 489, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 7, 6, 440, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 8, 7, 126, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 9, 8, 84, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 10, 9, 199, false, null));

        // Add 1 Balise to BaliseGroups
        lob.getBaliseGroup(1).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));
        lob.getBaliseGroup(2).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));
        lob.getBaliseGroup(3).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));
        lob.getBaliseGroup(4).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));
        lob.getBaliseGroup(5).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));
        lob.getBaliseGroup(6).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));
        lob.getBaliseGroup(7).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));
        lob.getBaliseGroup(8).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));
        lob.getBaliseGroup(9).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));
        lob.getBaliseGroup(10).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));

        // Add Connections
        lob.addConnection(1, 2);
        lob.addConnection(2, 3);
        lob.addConnection(3, 4);
        lob.addConnection(4, 5);
        lob.addConnection(5, 6);
        lob.addConnection(6, 7);
        lob.addConnection(7, 8);
        lob.addConnection(8, 9);
        lob.addConnection(9, 10);


        return new BaliseTelegramGenerator(localBus, lob);
    }

    private boolean validTarget(List<String> targetList) {
        for(String target : targetList) {
            if(target.contains("tsm") || target.contains("all")) {
                if(!target.contains(";")) {
                    return true;
                } else if(target.contains(";R=" + this.rbcID)) {
                    return true;
                }
            }
        }
        return false;
    }

}
