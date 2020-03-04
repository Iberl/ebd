package ebd.szenario.util.handler;

import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.logger.LogToGUIPipeEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SzenarioEventHandler {

    EventBus globalEventBus;

    public SzenarioEventHandler(){
        this.globalEventBus = EventBus.getDefault();
        this.globalEventBus.register(this);
    }


    /**
     * Dummy to prevent warnings from {@link EventBus}
     */
    @Subscribe
    public void dummyHandler(LogToGUIPipeEvent ghe){
        System.out.println("Event was send");
    }
}
