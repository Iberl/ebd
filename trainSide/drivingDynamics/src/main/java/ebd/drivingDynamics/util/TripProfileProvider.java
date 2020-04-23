package ebd.drivingDynamics.util;

import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.spline.Spline;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Collections;

public class TripProfileProvider {

    private final EventBus localEventBus;
    private Location profileRefLoc;

    private enum Mode {
        FROM_BREAKINGCURVE,
        FROM_FILE, //TODO Implement
        FROM_SOCKET //TODO Implement
    }

    ConfigHandler ch = ConfigHandler.getInstance();

    private Mode mode;
    private Spline profile = null;

    public TripProfileProvider(EventBus localBus){
        this.localEventBus = localBus;
        this.localEventBus.register(this);
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
        if(this.mode != Mode.FROM_BREAKINGCURVE) return;

        this.profile = nbce.breakingCurveGroup.getPermittedSpeedCurve();
        this.profileRefLoc = nbce.breakingCurveGroup.getPermittedSpeedCurve().getRefLocation();
        this.localEventBus.post(new DDUpdateTripProfileEvent("dd",
                                Collections.singletonList("dd"),
                                this.profile,
                                this.profileRefLoc.getId()));

    }

    public Spline getProfile() {
        return profile;
    }
}
