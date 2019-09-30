package ebd.trainStatusManager.util;

import ebd.globalUtils.events.messageReceiver.ReceivedTelegramEvent;
import ebd.globalUtils.events.trainStatusMananger.NewLocationEvent;
import ebd.globalUtils.location.Location;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Collections;
import java.util.Map;

public class TelegramHandler {

    //TODO: Respect SRS 3 A.3.3
    private EventBus localBus;
    private String etcsTrainID;

    public TelegramHandler(EventBus localBus, String etcsTrainID){
        this.localBus = localBus;
        this.localBus.register(this);
        this.etcsTrainID = etcsTrainID;
    }

    @Subscribe
    public void receivedTelegram(ReceivedTelegramEvent rte){
        RouteDataVolatile routeDataVolatile = this.localBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;

        Map<String, Location> linkingInformation = routeDataVolatile.getLinkingInformation();
        //TODO Remember NID_C
        Location newLoc = linkingInformation.get(String.valueOf(rte.telegram.NID_BG));
        this.localBus.postSticky(new NewLocationEvent("tsm", Collections.singletonList("dd"), newLoc));
    }



}
