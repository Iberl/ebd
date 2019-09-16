package ebd.globalUtils.events.drivingDynamics;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Spline;

import java.util.List;

public class DDUpdateTripProfileEvent extends NormalEvent {

    /**
     * A trip profile that will be used by driving dynamics to determine
     * the max speed at any given position.
     */
    public Spline tripProfile;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     */
    public DDUpdateTripProfileEvent(String source, List<String> targets, Spline tripProfile) {
        super(source, targets);
        this.tripProfile = tripProfile;
    }
}