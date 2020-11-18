package ebd.trainStatusManager.util.supervisors;

import ebd.globalUtils.etcsPacketConverters.GradientProfileConverter;
import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class TrackSupervisor{

    private EventBus localEventBus;
    private RouteDataVolatile routeDataVolatile;
    private TrainDataVolatile trainDataVolatile;
    private Packet_21 package21;
    private ForwardSpline gradientProfil;

    public TrackSupervisor(EventBus localEventBus){
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);
        this.routeDataVolatile = localEventBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
        this.trainDataVolatile = localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void clock(ClockTickEvent cte){
        updateCurrentGradient();
    }

    private void updateCurrentGradient() {
        Packet_21 newP21 = this.routeDataVolatile.getPacket_21();
        if(newP21 == null){
            return;
        }
        else if (this.package21 == null){
            this.package21 = newP21;
            this.gradientProfil = GradientProfileConverter.packet21ToGP(this.package21, routeDataVolatile.getCurrentGradient());
        }
        else if(!this.package21.equals(this.routeDataVolatile.getPacket_21())){
            this.package21 = this.routeDataVolatile.getPacket_21();
            this.gradientProfil = GradientProfileConverter.packet21ToGP(this.package21, routeDataVolatile.getCurrentGradient());
        }

        /*
        This distance value is only vaild as long as we assume that the reference location
        for both package 21 and package 15 are always equal. Once this is no longer the case, this has to be rewritten
         to include a different distance calculation.
        //TODO check this until no longer true
         */
        double curDis = this.trainDataVolatile.getCurTripSectionDistance();
        double curGrad = this.gradientProfil.getPointOnCurve(curDis);
        this.localEventBus.post(new RouteDataChangeEvent("tsm", "rd", "currentGradient", curGrad));

    }


}
