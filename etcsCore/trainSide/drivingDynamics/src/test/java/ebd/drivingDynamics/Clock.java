package ebd.drivingDynamics;

import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Clock implements Runnable {

    private EventBus eventBus;
    private boolean run = true;

    public Clock(EventBus eventBus) {
        this.eventBus = eventBus;
        this.eventBus.register(this);
    }

    @Override
    public void run() {
        while(run){
            try {
                Thread.sleep(2000);
                eventBus.post(new ClockTickEvent("clock", "all", 2, 0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Subscribe
    public void stop(DisconnectEvent de){
        run = false;
        this.eventBus.unregister(this);
    }
}
