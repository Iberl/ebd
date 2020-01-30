package ebd.trainStatusManager.util.supervisors;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.position.Position;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import ebd.globalUtils.events.trainStatusMananger.TsmTripEndEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Collections;

/**
 * This class supervises the distance the train has traveled the current trip. If the distance is close to or
 * greater than the current movement authority and the train has stopped, a end of mission is signaled.
 *<br>
 * //TODO This class can expanded to do other distance related checks.
 *
 * @author Lars Schulze-Falck
 */
public class TripSupervisor {
    //TODO Respect Dangerpoint, Overlaps etc.
    //TODO Own module, Remember SRS 3 A.3.5
    private EventBus localBus;
    private TrainDataVolatile trainDataVolatile;
    private double L_TRAIN;
    private int etcsID;
    private boolean missionEnded = true;
    /**
     * In [m]
     */
    private double targetReachedDistance;

    private BreakingCurve breakingCurve = null;

    /**
     * Constructor
     * @param localBus The local {@link EventBus}
     */
    public TripSupervisor(EventBus localBus){
        this.localBus = localBus;
        this.localBus.register(this);
        this.trainDataVolatile = this.localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        TrainDataPerma trainDataPerma = this.localBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        this.L_TRAIN = trainDataPerma.getL_train();
        this.etcsID = trainDataPerma.getId();
        this.targetReachedDistance = ConfigHandler.getInstance().targetReachedDistance;
    }

    /**
     * This method listens to clock tick events. On every tick, this class checks the the current traveled distance
     * and if there are any related measures that have to be taken.
     * @param cTE A {@link ClockTickEvent}
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cTE){
        if(this.breakingCurve == null) return;

        Position curPos = trainDataVolatile.getCurrentPosition();
        if(curPos == null) return;

        double distanceToEMA = this.breakingCurve.getHighestXValue() - curPos.totalDistanceToPastLocation(this.breakingCurve.getRefLocation().getId());

        if(distanceToEMA <= this.targetReachedDistance && trainDataVolatile.getCurrentSpeed() == 0){
            sendEndOfMission();
        }
    }

    /**
     * This method updates the breaking curve.
     * @param bce A {@link NewBreakingCurveEvent}
     */
    @Subscribe
    public void updateBC(NewBreakingCurveEvent bce){
        this.breakingCurve = bce.breakingCurveGroup.getServiceDecelerationCurve();
        this.missionEnded = false;
    }

    /**
     * Sends the necessary events to signal and log an end of mission.
     */
    private void sendEndOfMission() {
        //TODO Send Message 150
        if(!this.missionEnded){
            this.localBus.post(new TsmTripEndEvent("tsm", Collections.singletonList("tsm")));
            String msg = "Train " + etcsID + " reached the target location";
            this.localBus.post(new ToLogEvent("tsm", Collections.singletonList("log"), msg));
            this.missionEnded = true;
        }
    }



}
