package ebd.trainStatusManager;

import ebd.globalUtils.etcsPacketToSplineConverters.MovementAuthorityConverter;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import ebd.trainStatusManager.util.events.TsmTripEndEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Arrays;

public class TripSupervisor {
    //TODO Respect Dangerpoint, Overlaps etc.
    //TODO Own module, Remember SRS 3 A.3.5
    private EventBus localBus;
    private double L_TRAIN;



    /**
     * Distance to end of movement authority in [m], reduced by 20 m to account for imprecision.
     */
    private double distanceToEMA = Double.NaN;

    public TripSupervisor(EventBus localBus){
        this.localBus = localBus;
        this.localBus.register(this);
        TrainDataPerma trainDataPerma = this.localBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        this.L_TRAIN = trainDataPerma.getL_train();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cTE){
        if(Double.isNaN(distanceToEMA)){
            return;
        }
        TrainDataVolatile trainDataVolatile = this.localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;

        if(trainDataVolatile.getCurTripDistance() >= this.distanceToEMA && trainDataVolatile.getCurrentSpeed() == 0){
            this.localBus.post(new TsmTripEndEvent("tsm", Arrays.asList("tsm")));
        }



    }

    @Subscribe
    public void updateEMA(NewRouteDataVolatileEvent rdve){
        if(rdve.routeDataVolatile.getPacket_15() == null){
            return;
        }
        Packet_15 p15 = rdve.routeDataVolatile.getPacket_15();
        this.distanceToEMA = MovementAuthorityConverter.p15ToD_EMA(p15) - 20;

    }



}