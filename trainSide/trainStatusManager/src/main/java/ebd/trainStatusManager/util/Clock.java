package ebd.trainStatusManager.util;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.trainStatusManager.util.events.TsmExceptionEvent;
import org.greenrobot.eventbus.EventBus;

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

    private int tickTime; //in [ms]
    private double timeAccFactor;


    private boolean running = true;
    private boolean paused;
    private long lastClockTickTime; //in [ns]

    private List<String> exceptionTargets = Collections.singletonList("tsm");
    private List<String> eventTargets = Collections.singletonList("all");


    public Clock(EventBus eventBus) {
        this.eventBus = eventBus;
        this.lastClockTickTime = System.nanoTime();
        this.timeAccFactor = ConfigHandler.getInstance().timeAccFactor;
        this.clockThread = new Thread(this);
    }

    @Override
    public void run() {
        while(this.running){
            try {
                if(!paused){
                    long timeDifference = System.nanoTime() - this.lastClockTickTime;
                    double deltaT = timeDifference / 1E9;
                    this.eventBus.post(new ClockTickEvent("clock", this.eventTargets, deltaT));
                    this.lastClockTickTime = System.nanoTime();
                }
                Thread.sleep(this.tickTime);
            } catch (InterruptedException e) {
                InterruptedException ie = new InterruptedException("Clock was interrupted: " + e.getMessage());
                ie.setStackTrace(e.getStackTrace());
                this.eventBus.post(new TsmExceptionEvent("tsm", this.exceptionTargets,new NotCausedByAEvent(),ie, ExceptionEventTyp.WARNING));
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
        if(!paused) this.lastClockTickTime = System.nanoTime();
        this.paused = paused;
    }
}
