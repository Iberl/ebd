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
import ebd.messageLibrary.packet.trackpackets.Packet_0;
import ebd.messageLibrary.packet.trackpackets.Packet_5;
import ebd.messageSender.MessageSender;
import ebd.radioBlockCenter.RadioBlockCenter;
import ebd.szenario.util.InputHandler;
import ebd.szenario.util.SzenarioEventHandler;
import ebd.szenario.util.events.LoadOneEvent;
import ebd.szenario.util.events.SzenarioExceptionEvent;
import ebd.trainStatusManager.TrainStatusManager;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


import java.util.Collections;
import java.util.List;

import static ebd.messageLibrary.util.ETCSVariables.*;

public class Szenario implements Runnable {

    class btgGenerator {

        public BaliseTelegramGenerator createBTG() {
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
        }

        public void sendLinkingInformation(MessageSender ms) {
            // Create Linking Information
            Packet_5 li = new Packet_5(Q_DIR_NOMINAL, Q_SCALE_1M, new Packet_5.Packet_5_Link(300, false, 0, 1, Q_LINKORIENTATION_NOMINAL, Q_LINKREACTION_NO_REACTION, 12));
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
            ms.send(new SendMessageEvent("rbc;R=1", Collections.singletonList("ms;R=1"), message_24, Collections.singletonList("mr;T=192")));
        }
    }


    private EventBus globalEventBus;
    private Thread szenarioThread = new Thread(this);

    private SzenarioEventHandler szenarioEventHandler;
    private InputHandler inputHandler;
    private Logging logger;

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
