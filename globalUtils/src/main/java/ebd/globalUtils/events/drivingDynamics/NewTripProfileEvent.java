package ebd.globalUtils.events.drivingDynamics;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.spline.Spline;

import java.util.List;

public class NewTripProfileEvent extends NormalEvent {

    /**
     * A trip profile that will be used by driving dynamics to determine
     * the max speed at any given position.
     */
    public Spline tripProfile;

    public int refLocID;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from from the target module or "all" if more then one target should be reached.
     */
    public NewTripProfileEvent(String source, String target, Spline tripProfile, int refLocID) {
        super(source, target);
        this.tripProfile = tripProfile;
        this.refLocID = refLocID;
    }
}
