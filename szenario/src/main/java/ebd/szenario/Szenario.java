package ebd.szenario;

import ebd.baliseTelegramGenerator.Balise;
import ebd.baliseTelegramGenerator.BaliseGroup;
import ebd.baliseTelegramGenerator.BaliseTelegramGenerator;
import ebd.baliseTelegramGenerator.ListOfBalises;
import ebd.dmi.ui.DMIDisplayConnector;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageSender.SendMessageEvent;
import ebd.globalUtils.events.szenario.NewWaitTimeAtStationEvent;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.logging.Logging;
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
import ebd.szenario.util.events.*;
import ebd.trainStatusManager.TrainStatusManager;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import java.io.IOException;
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
        try {
            this.logger = new Logging();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new DMIDisplayConnector(globalEventBus);
        System.out.println("This is the virtual environment for the ETCS@EBD project");

        this.szenarioEventHandler = new SzenarioEventHandler();
        this.inputHandler = new InputHandler();
        this.messageSenderTrack = new MessageSender(new EventBus(), "szenario", false);

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

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void load1(LoadOneEvent loe){
        System.out.println("Scenario 1: In this scenario, a combined train of type 650 with a max speed of 120 km/h is driven by a strict driver from A to B");
        String msg = "ETCS start up";
        EventBus.getDefault().post(new ToLogEvent("glb", Collections.singletonList("log"), msg));
        Route a = new Route("AB", 1000,new int[]{0,100,900,80},new int[]{0,1,750,0});
        List<Route> listRoute = new ArrayList<>();
        listRoute.add(a);
        Map<Integer, List<Route>> mapRoute = new HashMap<>();
        mapRoute.put(192, listRoute);
        this.rbc = new RadioBlockCenter("1", mapRoute, 1);
        this.tsm = new TrainStatusManager(192, 1,
                "bbblaaaa127.0.0.1:8080/Trainconfigurator", "StrictDrivingStrategy.json", true);

        btgGenerator.sendLinkingInformation(this.messageSenderTrack);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void load2(LoadTwoEvent lte){
        System.out.println("Scenario 2: In this scenario, a combined train of type 650 with a max speed of 120 km/h is driven by a speeding driver from A to B");
        String msg = "ETCS start up";
        EventBus.getDefault().post(new ToLogEvent("glb", Collections.singletonList("log"), msg));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Route a = new Route("AB", 1000,new int[]{0,100,900,80},new int[]{0,1,750,0});
        List<Route> listRoute = new ArrayList<>();
        listRoute.add(a);
        Map<Integer, List<Route>> mapRoute = new HashMap<>();
        mapRoute.put(192, listRoute);
        this.rbc = new RadioBlockCenter("1", mapRoute, 2);
        this.tsm = new TrainStatusManager(192, 1,
                "bbblaaaa127.0.0.1:8080/Trainconfigurator", "RiskyDrivingStrategy.json", true);

        btgGenerator.sendLinkingInformation(this.messageSenderTrack);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void load3(LoadThreeEvent lte){
        System.out.println("Scenario 3: In this scenario, a combined train of type 650 with a max speed of 120 km/h is driven by a strict driver from A to 1, then from 1 to 2 and from 2 to C");
        String msg = "ETCS start up";
        EventBus.getDefault().post(new ToLogEvent("glb", Collections.singletonList("log"), msg));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Route a = new Route("A1", 600,new int[]{0,100},new int[]{0,1});
        Route b = new Route("12", 1900,new int[]{0,100,900,80,700,120},new int[]{0,1,750,0,450,-2});
        Route c = new Route("2C", 1700,new int[]{0,80,300,120},new int[]{0,-2, 600,1});

        List<Route> listRoute = new ArrayList<>();
        listRoute.add(a);
        listRoute.add(b);
        listRoute.add(c);
        Map<Integer, List<Route>> mapRoute = new HashMap<>();
        mapRoute.put(192, listRoute);
        this.rbc = new RadioBlockCenter("1", mapRoute, 3);
        this.tsm = new TrainStatusManager(192, 1,
                "bbblaaaa127.0.0.1:8080/Trainconfigurator", "StrictDrivingStrategy.json", true);

        btgGenerator.sendLinkingInformation(this.messageSenderTrack);
        EventBus.getDefault().post(new NewWaitTimeAtStationEvent("szenario", Collections.singletonList("all"), 20));
    }

/*    @Subscribe
    public void load4(LoadFourEvent lfe){
        System.out.println("Scenario 1: In this scenario, a combined train of type 650 with a top speed of 120 km/h is driven by a strict driver from A to B, then from B to A");
        Route a = new Route("AB", 1000,new int[]{0,100,900,80},new int[]{0,1,750,0});
        Route b = new Route("BC", 2000,new int[]{0,80,600,120},new int[]{0,0,300,-2});
        List<Route> listRoute = new ArrayList<>();
        listRoute.add(a);
        listRoute.add(b);
        Map<Integer, List<Route>> mapRoute = new HashMap<>();
        mapRoute.put(192, listRoute);
        this.rbc = new RadioBlockCenter("1", mapRoute, 3);
        this.tsm = new TrainStatusManager(192, 1,
                "bbblaaaa127.0.0.1:8080/Trainconfigurator", "StrictDrivingStrategy.json", true);

        btgGenerator.sendLinkingInformation(this.messageSenderTrack);
        EventBus.getDefault().post(new NewWaitTimeAtStationEvent("szenario", Collections.singletonList("all"), 20));
    }*/

    private boolean validTarget(List<String> targetList) {
        for(String target : targetList){
            if(target.contains("szenario") || target.contains("all")){
                return true;
            }
        }
        return false;
    }
}
