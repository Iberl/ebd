package ebd.trainStatusManager.util;

import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.trainStatusManager.util.events.TsmExceptionEvent;
import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is the clock of the train system, it determines the tact rate that is used by modules to schedule their
 * calculation. Every clock tick is signaled by an {@link ClockTickEvent}.
 *
 * @author Lars Schulze-Falck
 */
public class Clock implements Runnable {

    private EventBus eventBus;
    private Thread clockThread;

    private boolean running = true;

    private List<String> exceptionTargets = Collections.singletonList("tsm");
    private List<String> eventTargets = Collections.singletonList("all");


    public Clock(EventBus eventBus) {
        this.eventBus = eventBus;
        this.clockThread = new Thread(this);
    }

    @Override
    //TODO connect to Configurator
    public void run() {
        while(this.running){
            try {
                eventBus.post(new ClockTickEvent("clock", eventTargets));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                InterruptedException ie = new InterruptedException("Clock was interrupted: " + e.getMessage());
                ie.setStackTrace(e.getStackTrace());
                this.eventBus.post(new TsmExceptionEvent("tsm", this.exceptionTargets,new NotCausedByAEvent(),ie, ExceptionEventTyp.WARNING));
            }
        }
    }

    /**
     * This method starts the encapsulated clock thread.
     */
    public void start(){
        this.clockThread.start();
    }

    /**
     * This method stops the encapsulated clock thread after the current loop has run out.
     */
    public void stop(){
        this.running = false;
    }
}
