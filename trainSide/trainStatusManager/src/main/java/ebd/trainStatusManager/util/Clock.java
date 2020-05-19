package ebd.trainStatusManager.util;

import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.trainStatusManager.util.events.TsmExceptionEvent;
import org.greenrobot.eventbus.EventBus;

import java.util.Collections;

/**
 * This is the clock of the train system, it determines the tact rate that is used by modules to schedule their
 * calculation. Every clock tick is signaled by an {@link ClockTickEvent}.
 *
 * @author Lars Schulze-Falck
 */
public class Clock implements Runnable {

    private EventBus eventBus;
    private Thread clockThread;

    private int tickTime; //in [ms]


    private boolean running = true;
    private boolean paused;
    private long lastClockTickTime; //in [ns]

    private String exceptionTarget = "tsm";
    private String eventTarget = "all";


    public Clock(EventBus eventBus) {
        this.eventBus = eventBus;
        this.lastClockTickTime = AppTime.nanoTime();
        this.clockThread = new Thread(this);
    }

    @Override
    public void run() {
        while(this.running){
            try {
                if(!paused){
                    long timeDifference = AppTime.nanoTime() - this.lastClockTickTime;
                    double deltaT = timeDifference / 1E9;
                    this.eventBus.post(new ClockTickEvent("clock", this.eventTarget, deltaT));
                    this.lastClockTickTime = AppTime.nanoTime();
                }
                Thread.sleep(this.tickTime);
            } catch (InterruptedException e) {
                InterruptedException ie = new InterruptedException("Clock was interrupted: " + e.getMessage());
                ie.setStackTrace(e.getStackTrace());
                this.eventBus.post(new TsmExceptionEvent("tsm", this.exceptionTarget, new NotCausedByAEvent(),ie, ExceptionEventTyp.WARNING));
            }
        }
    }

    /**
     * This method starts the encapsulated clock thread.
     * @param tickTime Time between two clock ticks
     */
    public void start(int tickTime){
        this.tickTime = tickTime;
        this.clockThread.start();
    }

    /**
     * This method stops the encapsulated clock thread after the current loop has run out.
     */
    public void stop(){
        this.running = false;
    }

    public boolean isPaused(){
        return this.paused;
    }

    public void setPaused (boolean paused){
        if(this.paused == paused) return;
        if(!paused) this.lastClockTickTime = AppTime.nanoTime();
        this.paused = paused;
    }
}
