package ebd.szenario.util;

import ebd.globalUtils.events.DisconnectEvent;
import org.greenrobot.eventbus.EventBus;

public class SzenarioEventHandler {

    EventBus globalEventBus;

    public SzenarioEventHandler(){
        this.globalEventBus = EventBus.getDefault();
    }
}
