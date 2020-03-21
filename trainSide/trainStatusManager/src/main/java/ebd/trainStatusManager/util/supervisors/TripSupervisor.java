package ebd.trainStatusManager.util.supervisors;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.drivingDynamics.DDLockEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.trainStatusMananger.ReleaseSpeedModeStateEvent;
import ebd.globalUtils.events.trainStatusMananger.TsmTripEndEvent;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Collections;
import java.util.List;

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
    private final EventBus localBus;
    private final String eventSource;
    private final List<String> eventTarget;
    private final RouteDataVolatile routeDataVolatile;
    private final TrainDataVolatile trainDataVolatile;
    private final ConfigHandler ch;
    private final double L_TRAIN;

    private BreakingCurve breakingCurve = null;
    private boolean inRSM;

    /**
     * Constructor
     * @param localBus The local {@link EventBus}
     */
    public TripSupervisor(EventBus localBus){
        this.localBus = localBus;
        this.localBus.register(this);
        this.routeDataVolatile = this.localBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
        this.trainDataVolatile = this.localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        this.ch = ConfigHandler.getInstance();

        TrainDataPerma trainDataPerma = this.localBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        this.L_TRAIN = trainDataPerma.getL_train();

        this.eventSource = "tsm;T=" + trainDataVolatile.getEtcsID();
        this.eventTarget = Collections.singletonList("all");
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
        if(curPos == null || curPos.getLocation().getId() == ETCSVariables.NID_LRBG_UNKNOWN) return;
        double distanceToEMA = this.breakingCurve.getHighestXValue() - curPos.totalDistanceToPastLocation(this.breakingCurve.getRefLocation().getId());
        double curSpeed = this.trainDataVolatile.getCurrentSpeed();

        if(distanceToEMA <= ch.releaseSpeedDistance && curSpeed <= ch.releaseSpeed && curSpeed > 0 && !this.inRSM){
            this.inRSM = true;
            this.localBus.post(new ReleaseSpeedModeStateEvent(this.eventSource, this.eventTarget,true));
        }
        else if(distanceToEMA <= ch.targetReachedDistance && curSpeed == 0){
            this.inRSM = false;
            this.localBus.post(new ReleaseSpeedModeStateEvent(this.eventSource, this.eventTarget,false));
            this.localBus.post(new DDLockEvent(this.eventSource, Collections.singletonList("dd")));

            if(this.routeDataVolatile.isLastMABeforeEndOfMission()){
                sendEndOfMission();
            }
        }
    }

    /**
     * This method updates the breaking curve.
     * @param bce A {@link NewBreakingCurveEvent}
     */
    @Subscribe
    public void updateBC(NewBreakingCurveEvent bce){
        this.breakingCurve = bce.breakingCurveGroup.getPermittedSpeedCurve();
    }

    /**
     * Sends the necessary events to signal and log an end of mission.
     */
    private void sendEndOfMission() {
        //TODO Send Message 150
        this.localBus.post(new TsmTripEndEvent("tsm", Collections.singletonList("tsm")));
        String msg = "Train " + this.trainDataVolatile.getEtcsID() + " reached the target location";
        this.localBus.post(new ToLogEvent("tsm", Collections.singletonList("log"), msg));
    }



}
