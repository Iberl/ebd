package ebd.speedSupervisionModule;

import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Collections;

public class Clock implements Runnable {

    EventBus eventBus;
    boolean running = true;

    public Clock(EventBus eventBus){
        this.eventBus = eventBus;
        this.eventBus.register(this);
    }

    @Override
    public void run() {

        while(running){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.eventBus.post(new ClockTickEvent("clock", "all", 2));
        }
    }

    @Subscribe
    public void stop(DisconnectEvent de){
        this.running = false;
    }
}
