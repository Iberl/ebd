package ebd.dmi.ui;

import ebd.globalUtils.events.dmi.DMIUpdateEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class DMIDisplayConnector {

    DMIDisplay dmiDisplay;

    public DMIDisplayConnector(EventBus eventBus) {
        eventBus.register(this);
        this.dmiDisplay = new DMIDisplay();
    }

    @Subscribe
    public void onDMIUpdateEvent(DMIUpdateEvent dmiUpdateEvent) {
        this.dmiDisplay.setCurrentSpeed(dmiUpdateEvent.getCurrentSpeed());
        this.dmiDisplay.setCurrentTargetSpeed(dmiUpdateEvent.getCurrentTargetSpeed());
        //this.dmiDisplay.setTargetDistance(dmiUpdateEvent.getTargetDistance());
    }
}
