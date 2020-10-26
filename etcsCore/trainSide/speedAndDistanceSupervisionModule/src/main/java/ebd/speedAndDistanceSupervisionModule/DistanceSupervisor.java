package ebd.speedAndDistanceSupervisionModule;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.breakingCurveType.CurveType;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.etcsPacketConverters.MovementAuthorityConverter;
import ebd.globalUtils.events.bcc.BreakingCurveLimitedRequestEvent;
import ebd.globalUtils.events.drivingDynamics.DDHaltEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.trainStatusMananger.TsmTripEndEvent;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
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
 * //TODO This class can be expanded to do other distance related checks.
 *
 * @author Lars Schulze-Falck
 */
public class DistanceSupervisor {
    //TODO Remember SRS 3 A.3.5
    private final EventBus localBus;
    private final String eventSource = "sds";
    private final RouteDataVolatile routeDataVolatile;
    private final TrainDataVolatile trainDataVolatile;
    private final ConfigHandler ch;
    private final double L_TRAIN; //in [m]

    private BreakingCurve emergencyBC = null;
    private BreakingCurve serviceBC = null;

    private double startOfOverlapTimerDistance = 0;
    private double overlapMaxTime = Double.MAX_VALUE;
    private boolean overlapTimerRunning = false;
    private long overlapStartTime = 0;

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
    }


    /**
     * This method listens to clock tick events. On every tick, this class checks the the current traveled distance
     * and if there are any related measures that have to be taken.
     * @param  cte A {@link ClockTickEvent}
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cte){
        if(this.emergencyBC == null) return;
        Position curPos = trainDataVolatile.getCurrentPosition();
        if(curPos == null || curPos.getLocation().getId() == ETCSVariables.NID_LRBG_UNKNOWN) return;
        double estimatedFrontEnd = curPos.estimatedDistanceToPastLocation(this.serviceBC.getRefLocation().getId());

        double estimatedDistanceToEMA = this.serviceBC.endOfDefinedDistance()
                                - estimatedFrontEnd;
        double curSpeed = this.trainDataVolatile.getCurrentSpeed();

        /* Supervision of train halt */
        if(estimatedDistanceToEMA <= ch.targetReachedDistance && curSpeed > 0){
            this.localBus.post(new DDHaltEvent(this.eventSource, "dd"));
        }
        else if(estimatedDistanceToEMA <= ch.targetReachedDistance && curSpeed == 0){
            if(this.routeDataVolatile.isLastMABeforeEndOfMission()){
                sendEndOfMission();
            }
        }

        /*
        Supervision of Overlap Timer
         */
        if(curSpeed == 0 && this.overlapTimerRunning){
            this.overlapTimerRunning = false;
            this.startOfOverlapTimerDistance = Double.MIN_VALUE;
            this.overlapMaxTime = Double.MAX_VALUE;
        }
        else if(estimatedDistanceToEMA <= this.startOfOverlapTimerDistance && this.overlapMaxTime < Double.MAX_VALUE && !this.overlapTimerRunning){
            this.overlapTimerRunning = true;
            this.overlapStartTime = AppTime.currentTimeMillis();
        }
        if(this.overlapTimerRunning){
            long runningTime = AppTime.currentTimeMillis() - this.overlapStartTime;
            if(runningTime > this.overlapMaxTime){
                this.overlapTimerRunning = false;
                this.startOfOverlapTimerDistance = Double.MIN_VALUE;
                this.overlapMaxTime = Double.MAX_VALUE;

                revokeOverlap(); //Timeout of overlap revokes overlap, the train falls back on the danger point.
            }
        }
    }


    /**
     * This method updates the breaking curve.
     * @param bce A {@link NewBreakingCurveEvent}
     */
    @Subscribe
    public void updateBC(NewBreakingCurveEvent bce){
        this.emergencyBC = bce.emergencyBreakingCurve;
        this.serviceBC = bce.serviceBreakingCurve;

        /*
        Setting up Overlap Timer supervision
         */
        Packet_15 p15 = routeDataVolatile.getPacket_15();
        if(p15 != null){
            if(p15.Q_OVERLAP == ETCSVariables.Q_OVERLAP_NO_INFO){
                this.startOfOverlapTimerDistance = Double.MIN_VALUE;
                this.overlapMaxTime = Double.MAX_VALUE;
            }
            else {
                this.startOfOverlapTimerDistance = MovementAuthorityConverter.p15GetStartTimerDistance(p15);
                this.overlapMaxTime = MovementAuthorityConverter.p15GetOverlapTime(p15);
            }
        }
        this.overlapTimerRunning = false;
    }

    /**
     * Sends the necessary events to signal and log an end of mission.
     */
    private void sendEndOfMission() {
        this.localBus.post(new TsmTripEndEvent("tsm", "tsm"));
        String msg = "Train " + this.trainDataVolatile.getEtcsID() + " reached the target location";
        this.localBus.post(new ToLogEvent("tsm", "log", msg));
    }


    /*
    Revokes the Overlap. This modifies the current Packet_15 by setting Q_Overlap to {@link ETCSVariables#Q_OVERLAP_NO_INFO}
    and requesting a new breaking curve calculation, which then will not include an overlap.
     */
    private void revokeOverlap() {
        Packet_15 p15 = routeDataVolatile.getPacket_15();
        if(p15 == null) return;
        p15.Q_OVERLAP = ETCSVariables.Q_OVERLAP_NO_INFO;

        BreakingCurveLimitedRequestEvent bclre = new BreakingCurveLimitedRequestEvent("sds",
                "bc",
                "Overlap Revoked",
                p15,
                trainDataVolatile.getCurrentPosition()
                );

        this.localBus.post(new RouteDataChangeEvent("sds", "rd", "packet_15", p15));
        this.localBus.post(bclre);

    }
}
