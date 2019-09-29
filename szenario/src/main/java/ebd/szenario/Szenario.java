package ebd.szenario;

import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.logger.Logging;
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

public class Szenario implements Runnable {

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
        this.rbc = new RadioBlockCenter("1", Collections.singletonList(192));
        this.tsm = new TrainStatusManager("192", "1",
                "blaa", "TestDrivingProfile.json", true);
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
