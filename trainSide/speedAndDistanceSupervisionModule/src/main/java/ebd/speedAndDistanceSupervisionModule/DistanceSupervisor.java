package ebd.speedAndDistanceSupervisionModule;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.drivingDynamics.DDHaltEvent;
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

/**
 * This class supervises the distance the train has traveled the current trip. If the distance is close to or
 * greater than the current movement authority and the train has stopped, a end of mission is signaled.
 *<br>
 * //TODO This class can expanded to do other distance related checks.
 *
 * @author Lars Schulze-Falck
 */
public class DistanceSupervisor {
    //TODO Respect Dangerpoint, Overlaps etc.
    //TODO Remember SRS 3 A.3.5
    private final EventBus localBus;
    private final String eventSource;
    private final String eventTarget;
    private final RouteDataVolatile routeDataVolatile;
    private final TrainDataVolatile trainDataVolatile;
    private final ConfigHandler ch;
    private final double L_TRAIN; //in [m]

    private BreakingCurve breakingCurve = null;

    /**
     * If release speed == 0, handel it as if there was no release speed
     */
    private double curReleaseSpeed = 0; //in [m/s]
    private double curReleaseSpeedDistance = 0; // in [m]
    private boolean inRSM;

    private double dangerPointDistance; // in [m]

    /**
     * Constructor
     * @param localBus The local {@link EventBus}
     */
    public DistanceSupervisor(EventBus localBus){
        this.localBus = localBus;
        this.localBus.register(this);
        this.routeDataVolatile = this.localBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
        this.trainDataVolatile = this.localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        this.ch = ConfigHandler.getInstance();

        TrainDataPerma trainDataPerma = this.localBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        this.L_TRAIN = trainDataPerma.getL_train();
        this.dangerPointDistance = ch.minimumDangerPoint;

        this.eventSource = "tsm;T=" + trainDataVolatile.getEtcsID();
        this.eventTarget = "all";
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

        if(!this.inRSM
                && distanceToEMA <= this.curReleaseSpeedDistance
                && curSpeed <= this.curReleaseSpeed
                && curSpeed > 0  ){ //If release speed == 0, handel it as if there was no release speed
            this.inRSM = true;
            this.localBus.post(new ReleaseSpeedModeStateEvent(this.eventSource, this.eventTarget,true, this.curReleaseSpeed));
        }
        else if(distanceToEMA <= ch.targetReachedDistance && curSpeed > 0){
            this.localBus.post(new DDHaltEvent(this.eventSource, "dd"));
        }
        else if(distanceToEMA <= ch.targetReachedDistance && curSpeed == 0){
            this.inRSM = false;
            this.localBus.post(new ReleaseSpeedModeStateEvent(this.eventSource, this.eventTarget,false, 0d));
            this.localBus.post(new DDHaltEvent(this.eventSource, "dd"));

            if(this.routeDataVolatile.isLastMABeforeEndOfMission()){
                sendEndOfMission();
            }
        }
        else if(distanceToEMA < (0 - this.dangerPointDistance)){
            this.localBus.post(new ReleaseSpeedModeStateEvent(this.eventSource, this.eventTarget,false, 0d));
        }
    }

    /**
     * This method updates the breaking curve.
     * @param bce A {@link NewBreakingCurveEvent}
     */
    @Subscribe
    public void updateBC(NewBreakingCurveEvent bce){
        this.breakingCurve = bce.breakingCurveGroup.getPermittedSpeedCurve();
        this.curReleaseSpeed = calculateReleaseSpeed();
        this.curReleaseSpeedDistance = calculateReleaseSpeedDistance();
    }

    /**
     * Sends the necessary events to signal and log an end of mission.
     */
    private void sendEndOfMission() {
        this.localBus.post(new TsmTripEndEvent("tsm", "tsm"));
        String msg = "Train " + this.trainDataVolatile.getEtcsID() + " reached the target location";
        this.localBus.post(new ToLogEvent("tsm", "log", msg));
    }

    /**
     * Calculates the release speed based on the danger point distance in {@link ConfigHandler}. <br>
     *     A simplified calculation based on SRS 3.13.9.4.8.2 for only one target: EOA
     * @return The calculated release speed
     */
    private double calculateReleaseSpeed() {
        double releaseSpeed = this.routeDataVolatile.getPacket_15().V_RELEASEDP * 5 / 3.6;
        if(releaseSpeed <= 0){
            releaseSpeed = ch.releaseSpeed;
        }

        return releaseSpeed;
    }

    /**
     * Calculates based on the release speed the distance to EOA at which the train should switch in to release speed. <br>
     *     A simplified calculation based on SRS 3.13.9.4.8.2 for only one target: EOA
     * @return The calculated release speed
     */
    private double calculateReleaseSpeedDistance() {
        double distance = this.breakingCurve.getDistanceSpeedAlwaysLower(this.curReleaseSpeed);
        if(distance < Double.MAX_VALUE){
            return breakingCurve.getHighestXValue() - distance;
        }
        return ch.releaseSpeedDistance;
    }
}
