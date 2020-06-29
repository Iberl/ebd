package ebd.drivingDynamics.util;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.spline.Spline;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Collections;

public class TripProfileProvider {

    private final EventBus localEventBus;

    private enum Mode {
        FROM_BREAKINGCURVE,
        FROM_FILE, //TODO Implement
        FROM_SOCKET //TODO Implement
    }

    ConfigHandler ch = ConfigHandler.getInstance();
    TrainDataVolatile trainDataVolatile;

    private Mode mode;
    private Spline profile = null;

    public TripProfileProvider(EventBus localBus){
        this.localEventBus = localBus;
        this.localEventBus.register(this);
        this.trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        switch(ch.tripProfileMode){
            case("breakkingcurve"):
                this.mode = Mode.FROM_BREAKINGCURVE;
                break;
            case("file"):
                this.mode = Mode.FROM_FILE;
                break;
            case("socket"):
                this.mode = Mode.FROM_SOCKET;
                break;
            default:
                this.mode = Mode.FROM_BREAKINGCURVE;
        }
    }

    @Subscribe
    public void newBreakingCurveEvent(NewBreakingCurveEvent nbce){
        if(this.mode != Mode.FROM_BREAKINGCURVE) {
            getProfilefromSource(nbce.breakingCurveGroup.getPermittedSpeedCurve());
            //TODO Calculate the lowest curve of permitted/warning/service/emergency
            return;
        }

        this.profile = nbce.breakingCurveGroup.getPermittedSpeedCurve();
        Location profileRefLoc = nbce.breakingCurveGroup.getPermittedSpeedCurve().getRefLocation();
        this.localEventBus.post(new DDUpdateTripProfileEvent("dd",
                                "dd",
                                this.profile,
                                profileRefLoc.getId()));

    }


    public Spline getProfile() {
        return profile;
    }

    private void getProfilefromSource(BreakingCurve breakingCurve) {

        int etcsID = trainDataVolatile.getEtcsID();
        int refLocID = breakingCurve.getRefLocation().getId();

        if(this.mode == Mode.FROM_FILE) getProfilefromFile(etcsID, refLocID);
        else if (this.mode == Mode.FROM_SOCKET) getProfilefromSocket(etcsID, refLocID);

    }

    private void getProfilefromFile(int etcsID, int refLocID) {
        //TODO Implement after Spline File Format is determined
    }

    private void getProfilefromSocket(int etcsID, int refLocID) {
        //TODO Implement after Spline File Format is determined
    }
}
