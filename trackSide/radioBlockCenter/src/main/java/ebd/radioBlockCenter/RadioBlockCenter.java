package ebd.radioBlockCenter;


import ebd.baliseTelegramGenerator.Balise;
import ebd.baliseTelegramGenerator.BaliseGroup;
import ebd.baliseTelegramGenerator.BaliseTelegramGenerator;
import ebd.baliseTelegramGenerator.ListOfBalises;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.logging.Logging;
import ebd.messageLibrary.packet.trackpackets.Packet_0;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import ebd.radioBlockCenter.util.Route;
import ebd.radioBlockCenter.util.SocketClient;

import ebd.radioBlockCenter.util.handlers.TMSMessageHandler;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
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

        SocketClient socketClient = new SocketClient("rbc");
        JSONParser jsonParser = new JSONParser();
        List<JSONObject> tmsInfos = new ArrayList<>();

        while(true) {
            try {
                socketClient.request("test");
                JSONObject resp = (JSONObject) jsonParser.parse((String) socketClient.outputQueue.take());
                JSONObject eoa = (JSONObject) resp.get("endOfAuthority");

                if((boolean) eoa.get("shunting") == true) break;
                tmsInfos.add(resp);
            } catch(Exception e) {
                System.err.println("Received an Error from TMS");;
                e.printStackTrace();
            }

        }

        for(JSONObject info: tmsInfos) {
            System.out.println(info.toJSONString());
        }

        try {
            this.logger = new Logging(this.localBus, Integer.parseInt(this.rbcID), "RBC ");
        } catch(IOException e) {
            e.printStackTrace();
        }
        //this.messageHandler = new MessageHandler(this.localBus, this.rbcID, this.trainIdsToRouts, scenario);




        this.messageHandler = new TMSMessageHandler(this.localBus, this.rbcID, tmsInfos, scenario);
        this.messageSender = new MessageSender(this.localBus, this.rbcID, false);
        this.messageReceiver = new MessageReceiver(this.localBus, this.rbcID, "all", true);

        this.bTG = createBTG(this.localBus);

        this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), "RBC initialized"));
    }

    private BaliseTelegramGenerator createBTG(EventBus localBus) {
        // Create Empty Instance of ListOfBalise
        ListOfBalises lob = new ListOfBalises(1, 12);

        // Adding BaliseGroups
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 0, 0, 0, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 1, 0, 300, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 2, 1, 300, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 3, 2, 300, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 4, 3, 100, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 5, 4, 300, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 6, 5, 300, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 7, 6, 300, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 8, 7, 300, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 9, 8, 300, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 10, 9, 300, false, null));
        lob.addBaliseGroup(new BaliseGroup(M_VERSION_2_0, 0, 11, 10, 200, false, null));

        // Add 1 Balise to BaliseGroups
        lob.getBaliseGroup(0).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));
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
        lob.getBaliseGroup(11).add(new Balise(M_DUP_NO_DUPLICATE, 0, new Packet_0(0)));

        // Add Connections
        lob.addConnection(0, 1);
        lob.addConnection(1, 2);
        lob.addConnection(2, 3);
        lob.addConnection(3, 4);
        lob.addConnection(4, 5);
        lob.addConnection(5, 6);
        lob.addConnection(6, 7);
        lob.addConnection(7, 8);
        lob.addConnection(8, 9);
        lob.addConnection(9, 10);
        lob.addConnection(10, 11);


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
