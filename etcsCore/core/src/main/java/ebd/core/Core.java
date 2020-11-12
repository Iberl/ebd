package ebd.core;


import ebd.core.util.clients.InfrastructureClient;
import ebd.core.util.events.LoadEvent;
import ebd.core.util.handler.InputHandler;
import ebd.core.util.server.ATOServer;
import ebd.core.util.server.DMIServer;
import ebd.core.util.server.GUIServer;
import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.configHandler.TrainsHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageSender.SendETCSMessageEvent;
import ebd.globalUtils.events.tmsDummy.TMSDummyStartEvent;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.logging.Logging;
import ebd.messageLibrary.message.trackmessages.Message_24;
import ebd.messageLibrary.packet.trackpackets.Packet_5;
import ebd.messageSender.MessageSender;
import ebd.radioBlockCenter.RadioBlockCenter;
import ebd.core.util.handler.ScenarioEventHandler;
import ebd.core.util.events.ScenarioExceptionEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

import static ebd.messageLibrary.util.ETCSVariables.*;

public class Core implements Runnable {

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
            for(int etcsID : TrainsHandler.getInstance().getEtcsIDs()){
                ms.send(new SendETCSMessageEvent("rbc;R=1", "ms", message_24, "mr;T=" + etcsID));
            }

        }
    }


    private final EventBus globalEventBus;
    private final Thread szenarioThread = new Thread(this);
    private ConfigHandler ch;
    private TrainsHandler iFH;

    private final ScenarioEventHandler szenarioEventHandler;
    private final InputHandler inputHandler;
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
    private ATOServer atoServer;

    /*
    TrackSide
     */
    private RadioBlockCenter rbc = null;

    /*
    TrainSide
     */
    private TrainManager tm = null;

    public Core() {
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
        this.szenarioEventHandler = new ScenarioEventHandler();

        this.ch = ConfigHandler.getInstance();
        this.iFH = TrainsHandler.getInstance();
        try {
            this.logger = new Logging();
            this.infrastructureClient = new InfrastructureClient();
            this.dmiServer = new DMIServer();
            if(ch.allowGUI) this.guiServer = new GUIServer();
            if(ch.allowATO) this.atoServer = new ATOServer();
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
            this.globalEventBus.post(new ScenarioExceptionEvent("szenario", "Core",
                    new NotCausedByAEvent(),ie));
        }
    }

    public void join(){
        try {
            this.szenarioThread.join();
        } catch (InterruptedException e) {
            InterruptedException ie = new InterruptedException("TSM was interrupted: " + e.getMessage());
            ie.setStackTrace(e.getStackTrace());
            this.globalEventBus.post(new ScenarioExceptionEvent("szenario", "Core",
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
        System.out.println("Welcome to the ETCS Train and RBC simulation");

        String msg = "ETCS start up";
        EventBus.getDefault().post(new ToLogEvent("glb", "log", msg));

        this.rbc = new RadioBlockCenter(1);

        try {
            this.tm = new TrainManager();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btgGenerator.sendLinkingInformation(this.messageSenderTrack);
        if(!ConfigHandler.getInstance().useTMSServer) EventBus.getDefault().post(new TMSDummyStartEvent("glb", "tms"));
    }

    private boolean validTarget(String target) {

        if(target.contains("szenario") || target.contains("all")){
            return true;
        }

        return false;
    }
}
