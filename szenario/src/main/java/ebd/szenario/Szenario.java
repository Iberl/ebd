package ebd.szenario;

import ebd.baliseTelegramGenerator.Balise;
import ebd.baliseTelegramGenerator.BaliseGroup;
import ebd.baliseTelegramGenerator.BaliseTelegramGenerator;
import ebd.baliseTelegramGenerator.ListOfBalises;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.messageSender.SendMessageEvent;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.logger.Logging;
import ebd.messageLibrary.message.trackmessages.Message_24;
import ebd.messageLibrary.message.trainmessages.Message_132;
import ebd.messageLibrary.message.trainmessages.Message_155;
import ebd.messageLibrary.message.trainmessages.Message_157;
import ebd.messageLibrary.packet.Packet;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_0;
import ebd.messageLibrary.packet.trackpackets.Packet_5;
import ebd.messageLibrary.packet.trackpackets.Packet_58;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageSender.MessageSender;
import ebd.radioBlockCenter.RadioBlockCenter;
import ebd.radioBlockCenter.util.Route;
import ebd.szenario.util.InputHandler;
import ebd.szenario.util.SzenarioEventHandler;
import ebd.szenario.util.events.LoadOneEvent;
import ebd.szenario.util.events.SzenarioExceptionEvent;
import ebd.trainStatusManager.TrainStatusManager;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


import java.util.*;

import static ebd.messageLibrary.util.ETCSVariables.*;

public class Szenario implements Runnable {

    static class btgGenerator {

        /*public static BaliseTelegramGenerator createBTG() {
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

            return new BaliseTelegramGenerator(lob);
        }*/

        public static void sendLinkingInformation(MessageSender ms) {
            // Create Linking Information
            Packet_5 li = new Packet_5(Q_DIR_NOMINAL, Q_SCALE_1M, new Packet_5.Packet_5_Link(0, false, 0, 0, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(300, false, 0, 1, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(300, false, 0, 2, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(300, false, 0, 3, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(100, false, 0, 4, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(300, false, 0, 5, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(300, false, 0, 6, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(300, false, 0, 7, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(300, false, 0, 8, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(300, false, 0, 9, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(300, false, 0, 10, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(200, false, 0, 11, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));

            Message_24 message_24 = new Message_24((System.currentTimeMillis() / 10l) % T_TRAIN_UNKNOWN, false, 0);
            message_24.packets.add(li);
            ms.send(new SendMessageEvent("rbc;R=1", Collections.singletonList("ms"), message_24, Collections.singletonList("mr;T=192")));
        }
    }


    private EventBus globalEventBus;
    private Thread szenarioThread = new Thread(this);

    private SzenarioEventHandler szenarioEventHandler;
    private InputHandler inputHandler;
    private Logging logger;
    private MessageSender messageSenderTrack;
    private MessageSender messageSenderTrain;

    /*
    TrackSide
     */
    private RadioBlockCenter rbc = null;

    /*
    TrainSide
     */
    private TrainStatusManager tsm = null;

    public Szenario(){

        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);

        this.szenarioEventHandler = new SzenarioEventHandler();
        this.inputHandler = new InputHandler();
        this.messageSenderTrack = new MessageSender(new EventBus(), "szenario", false);
        this.messageSenderTrain = new MessageSender(new EventBus(), "192", true);

        szenarioThread.start();
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            InterruptedException ie = new InterruptedException("TSM was interrupted: " + e.getMessage());
            ie.setStackTrace(e.getStackTrace());
            this.globalEventBus.post(new SzenarioExceptionEvent("szenario", Collections.singletonList("Szenario"),
                    new NotCausedByAEvent(),ie));
        }
    }

    public void join(){
        try {
            this.szenarioThread.join();
        } catch (InterruptedException e) {
            InterruptedException ie = new InterruptedException("TSM was interrupted: " + e.getMessage());
            ie.setStackTrace(e.getStackTrace());
            this.globalEventBus.post(new SzenarioExceptionEvent("szenario", Collections.singletonList("Szenario"),
                    new NotCausedByAEvent(),ie));
        }
    }

    /**
     * Reacts to a {@link DisconnectEvent} and stops the clock.
     * @param de a {@link DisconnectEvent}
     */
    @Subscribe
    public void disconnect(DisconnectEvent de){
        if(!validTarget(de.targets)){
            return;
        }
        synchronized (this){
            this.notify();
        }
        globalEventBus.unregister(this);
    }

    @Subscribe
    public void load1(LoadOneEvent loe){
        System.out.println("Scenario 1: In this scenario, a combined train of type 650 with a top speed of 120 km/h is driven by a strict driver from A to B");
        Route a = new Route("A", 1000);
        List<Route> listRoute = new ArrayList<>();
        listRoute.add(a);
        Map<Integer, List<Route>> mapRoute = new HashMap<>();
        mapRoute.put(192, listRoute);
        this.rbc = new RadioBlockCenter("1", Collections.singletonList(192), mapRoute);
        this.tsm = new TrainStatusManager("192", "1",
                "bbblaaaa127.0.0.1:8080/Trainconfigurator", "RiskyDrivingStrategy.json", true);

        btgGenerator.sendLinkingInformation(this.messageSenderTrack);
        Message_155 msg155 = new Message_155();
        this.messageSenderTrain.send(new SendMessageEvent("ms;T=192", Collections.singletonList("ms"), msg155 ,Collections.singletonList("mr;R=1") ));
        this.messageSenderTrack.send(new SendMessageEvent("ms;R=1", Collections.singletonList("ms"), makeMessage(makePackage58()), Collections.singletonList("mr;T=192")));
    }

    private Message_24 makeMessage(TrackPacket packet){
        Message_24 m24 = new Message_24();
        m24.NID_LRBG = 0;
        m24.packets.add(packet);
        return m24;
    }

    private Packet_58 makePackage58(){

        Packet_58 packet58 = new Packet_58();
        packet58.Q_DIR = Q_DIR_NOMINAL;
        packet58.M_LOC = M_LOC_AT_BALISE_GROUP;

        return packet58;
    }

    private boolean validTarget(List<String> targetList) {
        for(String target : targetList){
            if(target.contains("szenario") || target.contains("all")){
                return true;
            }
        }
        return false;
    }
}
