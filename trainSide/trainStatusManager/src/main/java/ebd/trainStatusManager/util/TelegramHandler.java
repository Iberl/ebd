package ebd.trainStatusManager.util;

import ebd.globalUtils.events.messageReceiver.ReceivedTelegramEvent;
import ebd.globalUtils.events.trainStatusMananger.NewLocationEvent;
import ebd.globalUtils.location.Location;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void receivedTelegram(ReceivedTelegramEvent rte){
        RouteDataVolatile routeDataVolatile = this.localBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
        Map<Integer, Location> linkingInformation = routeDataVolatile.getLinkingInformation();
        //TODO Remember NID_C
        Location newLoc = linkingInformation.get(rte.telegram.NID_BG);
        //this.localBus.post(new NewLocationEvent("tsm", Collections.singletonList("all"), newLoc));
        this.localBus.postSticky(new NewLocationEvent("tsm", Collections.singletonList("all"), newLoc));
    }



}
