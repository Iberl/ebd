package ebd.trainStatusManager.util;

import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.trainStatusManager.util.events.TsmExceptionEvent;
import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Clock implements Runnable {

    private EventBus eventBus;
    private Thread clockThread;

    private boolean running = true;

    private List<String> exceptionTargets = Collections.singletonList("tsm");

    public Clock(EventBus eventBus) {
        this.eventBus = eventBus;

        this.clockThread = new Thread(this);
    }

    @Override
    public void run() {
        while(this.running){
            try {
                Thread.sleep(2000);
                eventBus.post(new ClockTickEvent("clock", Arrays.asList(new String[]{"all"})));
            } catch (InterruptedException e) {
                InterruptedException ie = new InterruptedException("Clock was interrupted: " + e.getMessage());
                ie.setStackTrace(e.getStackTrace());
                this.eventBus.post(new TsmExceptionEvent("tsm", this.exceptionTargets,new NotCausedByAEvent(),ie, ExceptionEventTyp.WARNING));
            }
        }
    }

    public void start(){
        this.clockThread.start();
    }

    public void stop(){
        this.running = false;
    }
}
