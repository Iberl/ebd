package ebd.trainStatusManager.util.handlers;

import ebd.globalUtils.events.logger.ToLogEvent;
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

/**
 * This class handles received telegrams for the {@link ebd.trainStatusManager.TrainStatusManager}
 *
 * @author Lars Schulze-Falck
 */
public class TelegramHandler {
    //TODO: Handle split telegrams
    //TODO: Respect SRS 3 A.3.3
    private EventBus localBus;
    private int etcsTrainID;

    private ReceivedTelegramEvent savedRTE = null;

    /**
     * Constructor
     * @param localBus the local {@link EventBus} of the train
     * @param etcsTrainID the ETCS ID of the train
     */
    public TelegramHandler(EventBus localBus, int etcsTrainID){
        this.localBus = localBus;
        this.localBus.register(this);
        this.etcsTrainID = etcsTrainID;
    }

    /**
     * Parses a received Telegram if linking information is available. If not, the telegram gets stored until such
     * information is received, overwriting the currently stored telegram.
     * @param rte A {@link ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent}
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void receivedTelegram(ReceivedTelegramEvent rte){
        RouteDataVolatile routeDataVolatile = this.localBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
        Map<Integer, Location> linkingInformation = routeDataVolatile.getLinkingInformation();
        if (linkingInformation == null || linkingInformation.size() < 1) {
            this.savedRTE = rte;
            return;
        }
        //TODO Remember NID_C
        Location newLoc = linkingInformation.get(rte.telegram.NID_BG);
        //this.localBus.post(new NewLocationEvent("tsm", Collections.singletonList("all"), newLoc));
        this.localBus.postSticky(new NewLocationEvent("tsm", "all", newLoc));
        String msg = "Received a Balise Telegram with location information";
        this.localBus.post(new ToLogEvent("tsm", "log", msg));
    }

    /**
     * Receives new linking information. If there is a received telegram stored and new information was received,
     * it will now be parsed.
     * @param rdve A {@link NewRouteDataVolatileEvent}
     */
    @Subscribe
    public void newRDV(NewRouteDataVolatileEvent rdve){
        if (this.savedRTE == null) return;
        RouteDataVolatile routeDataVolatile = rdve.routeDataVolatile;
        Map<Integer, Location> linkingInformation = routeDataVolatile.getLinkingInformation();
        if (linkingInformation == null || linkingInformation.size() < 1) {
            return;
        }
        receivedTelegram(this.savedRTE);
        this.savedRTE = null;
    }
}
