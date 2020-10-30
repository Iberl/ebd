package ebd.trainStatusManager.util.supervisors;

import ebd.globalUtils.enums.SpeedInterventionLevel;
import ebd.globalUtils.enums.SpeedSupervisionState;
import ebd.globalUtils.events.dmi.DMIUpdateEvent;
import ebd.globalUtils.events.drivingDynamics.NewTripProfileEvent;
import ebd.globalUtils.events.speedDistanceSupervision.SsmReportEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Spline;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class DMIUpdateSupervisor {

    private final EventBus localEventBus;
    private final TrainDataVolatile trainDataVolatile;
    private final RouteDataVolatile routeDataVolatile;
    private SpeedInterventionLevel currentSil;
    private SpeedSupervisionState currentSsState;
    private int curRefLocID;
    private double curMaxTripDistance = 0;

    public DMIUpdateSupervisor(EventBus localEventBus) {
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);
        trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        routeDataVolatile = this.localEventBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;
    }

    @Subscribe
    public void clockTick(ClockTickEvent cte){
        updateDMISpeeds();
        
    }

    @Subscribe
    public void getSDSReport(SsmReportEvent ssmre){
        this.currentSil = ssmre.interventionLevel;
        this.currentSsState = ssmre.supervisionState;
    }

    @Subscribe
    public void curTripProfile(NewTripProfileEvent ntpe){
        this.curRefLocID = ntpe.refLocID;
        Spline curProfile = ntpe.tripProfile;
        if(curProfile instanceof ForwardSpline) this.curMaxTripDistance = Double.MAX_VALUE;
        else if(curProfile instanceof BackwardSpline) this.curMaxTripDistance = ((BackwardSpline) curProfile).getHighestXValue();
        else {
            this.curMaxTripDistance = 0;
        }
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
        double currentPermSpeed = this.trainDataVolatile.getCurrentMaximumSpeed();
        double currentWarnSpeed = this.trainDataVolatile.getCurrentWarningSpeed();
        double currentIntervSpeed = this.trainDataVolatile.getCurrentServiceIntervention2Speed();
        double curApplReleaseSpeed = this.trainDataVolatile.getCurrentApplicableReleaseSpeed();

        String source = "dd;T=" + this.trainDataVolatile.getEtcsID();
        EventBus.getDefault().post(new DMIUpdateEvent(source, "dmi", speed, targetSpeed, (int)distanceToDrive,
                curApplReleaseSpeed, this.currentSil, this.currentSsState, currentIndSpeed,
                currentPermSpeed, currentWarnSpeed, currentIntervSpeed, this.trainDataVolatile.getCurTripDistance()));
    }
}
