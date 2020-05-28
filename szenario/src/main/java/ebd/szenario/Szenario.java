package ebd.szenario;


import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.configHandler.InitFileHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageSender.SendETCSMessageEvent;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.logging.Logging;
import ebd.messageLibrary.message.trackmessages.Message_24;
import ebd.messageLibrary.packet.trackpackets.Packet_5;
import ebd.messageSender.MessageSender;
import ebd.radioBlockCenter.RadioBlockCenter;
import ebd.szenario.util.clients.InfrastructureClient;
import ebd.szenario.util.handler.InputHandler;
import ebd.szenario.util.handler.SzenarioEventHandler;
import ebd.szenario.util.events.LoadEvent;
import ebd.szenario.util.events.SzenarioExceptionEvent;
import ebd.szenario.util.server.DMIServer;
import ebd.szenario.util.server.GUIServer;
import ebd.trainStatusManager.TrainStatusManager;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.*;

import static ebd.messageLibrary.util.ETCSVariables.*;

public class Szenario implements Runnable {

    static class btgGenerator {
        public static void sendLinkingInformation(MessageSender ms) {
            // Create Linking Information
            Packet_5 li = new Packet_5(Q_DIR_NOMINAL, Q_SCALE_1M, new Packet_5.Packet_5_Link(0, false, 0, 1, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(584, false, 0, 2, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(398, false, 0, 3, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(346, false, 0, 4, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(183, false, 0, 5, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(489, false, 0, 6, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(440, false, 0, 7, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(126, false, 0, 8, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(84, false, 0, 9, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
            li.links.add(new Packet_5.Packet_5_Link(199, false, 0, 10, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));

            Message_24 message_24 = new Message_24((AppTime.currentTimeMillis() / 10l) % T_TRAIN_UNKNOWN, false, 0);
            message_24.packets.add(li);
            for(int etcsID : InitFileHandler.getInstance().getEtcsIDs()){
                ms.send(new SendETCSMessageEvent("rbc;R=1", "ms", message_24, "mr;T=" + etcsID));
            }

        }
    }


    private EventBus globalEventBus;
    private Thread szenarioThread = new Thread(this);
    private ConfigHandler ch;
    private InitFileHandler iFH;

    private SzenarioEventHandler szenarioEventHandler;
    private InputHandler inputHandler;
    private Logging logger;
    private MessageSender messageSenderTrack;

    /*
    Sockets
     */
    private InfrastructureClient infrastructureClient;

    /*
    Server
     */
    private GUIServer guiServer;
    private DMIServer dmiServer;

    /*
    TrackSide
     */
    private RadioBlockCenter rbc = null;

    /*
    TrainSide
     */
    private TrainManager tm = null;

    public Szenario() {
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
        this.szenarioEventHandler = new SzenarioEventHandler();

        this.ch = ConfigHandler.getInstance();
        this.iFH = InitFileHandler.getInstance();
        try {
            this.logger = new Logging();
            this.infrastructureClient = new InfrastructureClient();
            if(ch.allowGUI) this.guiServer = new GUIServer();
            this.dmiServer = new DMIServer();
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.inputHandler = new InputHandler();
        this.messageSenderTrack = new MessageSender(new EventBus(), "szenario", false);

        System.out.println("This is the virtual environment for the ETCS@EBD project");
        szenarioThread.start();
        if(ch.autoStart) load(new LoadEvent("szenario", "szenario"));
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
            this.globalEventBus.post(new SzenarioExceptionEvent("szenario", "Szenario",
                    new NotCausedByAEvent(),ie));
        }
    }

    public void join(){
        try {
            this.szenarioThread.join();
        } catch (InterruptedException e) {
            InterruptedException ie = new InterruptedException("TSM was interrupted: " + e.getMessage());
            ie.setStackTrace(e.getStackTrace());
            this.globalEventBus.post(new SzenarioExceptionEvent("szenario", "Szenario",
                    new NotCausedByAEvent(),ie));
        }
    }

    /**
     * Reacts to a {@link DisconnectEvent} and stops the clock.
     * @param de a {@link DisconnectEvent}
     */
    @Subscribe
    public void disconnect(DisconnectEvent de){
        if(!validTarget(de.target)){
            return;
        }
        synchronized (this){
            this.notify();
        }
        globalEventBus.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void load(LoadEvent loe){
        String driverName = ConfigHandler.getInstance().pathToDriverProfileJson;
        driverName = driverName.replace("DrivingStrategy.json", "");
        String routeName = ConfigHandler.getInstance().pathToSzenarioJSON;
        routeName = routeName.replace("szenario", "");
        routeName = routeName.replace(".json", "");
        System.out.printf("Running this scenario with a %s driving strategy a route %s%n", driverName, routeName);

        String msg = "ETCS start up";
        EventBus.getDefault().post(new ToLogEvent("glb", "log", msg));

        this.rbc = new RadioBlockCenter(1);

        try {
            this.tm = new TrainManager();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btgGenerator.sendLinkingInformation(this.messageSenderTrack);
    }

    private boolean validTarget(String target) {

        if(target.contains("szenario") || target.contains("all")){
            return true;
        }

        return false;
    }
}
