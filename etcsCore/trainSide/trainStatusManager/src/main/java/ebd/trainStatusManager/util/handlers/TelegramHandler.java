package ebd.trainStatusManager.util.handlers;

import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedTelegramEvent;
import ebd.globalUtils.events.trainStatusMananger.NewLocationEvent;
import ebd.globalUtils.events.trainStatusMananger.SingleBaliseGroupEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.message.Telegram;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;
import java.util.Objects;

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

    String src = "tsm";

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

        Location newLoc = makeLocation(rte.telegram, linkingInformation, rte);

        this.localBus.post(new NewLocationEvent(src, "all", newLoc));
        String msg = "Received a Balise Telegram with location information";
        this.localBus.post(new ToLogEvent(src, "log", msg));
        if(rte.telegram.N_PIG == 0){
            this.localBus.post(new SingleBaliseGroupEvent(src, src, newLoc));
        }
    }

    private Location makeLocation(Telegram telegram, Map<Integer, Location> linkingInformation, ReceivedTelegramEvent rte) {
        TrainDataVolatile trainDataVolatile = this.localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        Location linkLoc = linkingInformation.get(rte.telegram.NID_BG); //TODO Change to NID_LRBG when new linking info is developed
        Position curPos = trainDataVolatile.getCurrentPosition();
        Location curLoc = Objects.requireNonNull(curPos).getLocation();

        int NID_BG = telegram.NID_BG;
        int NID_C = telegram.NID_C;
        int NID_LRBG = (NID_C << 14) + NID_BG;
        int Q_DIRTRAIN;
        if(telegram.N_TOTAL == 0) Q_DIRTRAIN = curLoc.getDirection();
        else if (telegram.N_PIG == 0) Q_DIRTRAIN = 1;
        else Q_DIRTRAIN = 0;

        Location loc = new Location(NID_LRBG,curLoc.getId(), Q_DIRTRAIN, linkLoc.getDistanceToPrevious());
        return loc;
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
