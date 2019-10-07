package ebd.trainStatusManager.util.supervisors;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.etcsPacketToSplineConverters.MovementAuthorityConverter;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
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
import java.util.Collections;

public class TripSupervisor {
    //TODO Respect Dangerpoint, Overlaps etc.
    //TODO Own module, Remember SRS 3 A.3.5
    private EventBus localBus;
    private double L_TRAIN;
    private int etcsID;
    private boolean missionEnded = true;



    private BreakingCurve breakingCurve = null;

    public TripSupervisor(EventBus localBus){
        this.localBus = localBus;
        this.localBus.register(this);
        TrainDataPerma trainDataPerma = this.localBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        this.L_TRAIN = trainDataPerma.getL_train();
        this.etcsID = trainDataPerma.getId();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cTE){
        if(this.breakingCurve == null) return;

        TrainDataVolatile trainDataVolatile = this.localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        Position curPos = trainDataVolatile.getCurrentPosition();
        if(curPos == null) return;

        double distanceToEMA = this.breakingCurve.getHighestXValue() - curPos.totalDistanceToPastLocation(this.breakingCurve.getRefLocation().getId());
        //distanceToEMA -= 20; // Catch trains that are close to a target

        if(distanceToEMA <= 5 && trainDataVolatile.getCurrentSpeed() == 0){
            sendEndOfMission();
            this.localBus.post(new TsmTripEndEvent("tsm", Collections.singletonList("tsm")));
        }
    }

    @Subscribe
    public void updateBC(NewBreakingCurveEvent bce){
        this.breakingCurve = bce.breakingCurve;
        this.missionEnded = false;
    }

    private void sendEndOfMission() {
        //TODO Send Message 150
        if(!this.missionEnded){
            this.localBus.post(new ToLogEvent("tsm", Collections.singletonList("log"), "Train " + etcsID + " reached the target location"));
            this.missionEnded = true;
        }
    }



}
