package ebd.trainStatusManager.util.socketConnectors;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.enums.SpeedInterventionLevel;
import ebd.globalUtils.enums.SpeedSupervisionState;
import ebd.globalUtils.etcsPacketConverters.GradientProfileConverter;
import ebd.globalUtils.events.dmi.DMISpeedUpdateEvent;
import ebd.globalUtils.events.dmi.DMIUpdateEvent;
import ebd.globalUtils.events.drivingDynamics.NewTripProfileEvent;
import ebd.globalUtils.events.speedDistanceSupervision.SsmReportEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * This class supervises the connection between the Train and the DMIServer. It uses {@link TrainDataVolatile},
 * {@link RouteDataVolatile}, {@link SsmReportEvent} and {@link NewTripProfileEvent} to gather the necessary data.
 * and sends {@link DMIUpdateEvent} and {@link DMISpeedUpdateEvent} to DMIServer.
 */
public class DMIServerConnector {

    private final EventBus localEventBus;
    private final TrainDataVolatile trainDataVolatile;
    private final RouteDataVolatile routeDataVolatile;
    private final String source;
    private SpeedInterventionLevel currentSil = SpeedInterventionLevel.NO_INTERVENTION;
    private SpeedSupervisionState currentSsState = SpeedSupervisionState.CEILING_SPEED_SUPERVISION;
    private double curMaxTripDistance = 0;
    private double curOffsetToTripStart = 0;

    /**
     *
     * @param localEventBus Local {@link EventBus} of the train
     */
    public DMIServerConnector(EventBus localEventBus) {
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);
        trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        routeDataVolatile = this.localEventBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
        this.source = "tsm;T=" + this.trainDataVolatile.getEtcsID();
    }

    /**
     * Every clock tick, the DMI is updated with new speeds, distances and states of the train
     * @param cte {@link ClockTickEvent}
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void clockTick(ClockTickEvent cte){
        updateDMISpeeds();
    }

    /**
     * Collects current speed intervention levels and supervision states
     * @param ssmre {@link SsmReportEvent}
     */
    @Subscribe
    public void getSDSReport(SsmReportEvent ssmre){
        this.currentSil = ssmre.interventionLevel;
        this.currentSsState = ssmre.supervisionState;
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void curBreakingCurve(NewBreakingCurveEvent nbce){
        this.curOffsetToTripStart = trainDataVolatile.getCurTripDistance() - trainDataVolatile.getCurTripSectionDistance();
        this.curMaxTripDistance = nbce.serviceBreakingCurve.endOfDefinedDistance();

        updateDMIGP();
        updateDMISP(nbce.serviceBreakingCurve);
    }

    /**
     * Collects data and generates a {@link DMIUpdateEvent}
     */
    private void updateDMIGP() {
        Packet_21 packet_21 = this.routeDataVolatile.getPacket_21();
        String dmiString = GradientProfileConverter.packet21ToDMIString(packet_21,
                        this.routeDataVolatile.getCurrentGradient(),
                        this.curOffsetToTripStart);
        EventBus.getDefault().post(new DMIUpdateEvent(this.source, "dmi", dmiString));
    }

    /**
     * Collects data and generates a {@link DMIUpdateEvent}
     */
    private void updateDMISP(BreakingCurve serviceBC) {
        String spString = serviceBC.getSspDMIString(this.curOffsetToTripStart);
        EventBus.getDefault().post(new DMIUpdateEvent(this.source, "dmi", spString));
    }


    /**
     * This method gathers the new information from dynamic state, adds data saved in {@link TrainDataVolatile}
     * and send these to the DMI
     */
    private void updateDMISpeeds(){
        double speed = this.trainDataVolatile.getCurrentSpeed();
        double targetSpeed = this.trainDataVolatile.getTargetSpeed();
        double distanceToDrive = this.curMaxTripDistance - this.trainDataVolatile.getCurTripSectionDistance();
        double currentIndSpeed = this.trainDataVolatile.getCurrentIndicationSpeed();
        double currentWarnSpeed = this.trainDataVolatile.getCurrentWarningSpeed();
        double currentIntervSpeed = this.trainDataVolatile.getCurrentServiceIntervention2Speed();
        double curApplReleaseSpeed = this.trainDataVolatile.getCurrentApplicableReleaseSpeed();

        double currentPermSpeed;
        if(this.currentSsState == SpeedSupervisionState.RELEASE_SPEED_SUPERVISION) currentPermSpeed = curApplReleaseSpeed;
        else currentPermSpeed = this.trainDataVolatile.getCurrentMaximumSpeed();

        DMISpeedUpdateEvent dmiSpeedUpdateEvent = new DMISpeedUpdateEvent(this.source, "dmi", speed, targetSpeed, (int)distanceToDrive,
                curApplReleaseSpeed, this.currentSil, this.currentSsState, currentIndSpeed,
                currentPermSpeed, currentWarnSpeed, currentIntervSpeed, this.trainDataVolatile.getCurTripDistance());

        EventBus.getDefault().post(dmiSpeedUpdateEvent);
    }
}
