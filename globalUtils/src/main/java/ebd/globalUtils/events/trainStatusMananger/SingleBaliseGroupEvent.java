package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.location.Location;

public class SingleBaliseGroupEvent extends NormalEvent {


    public Location newLoc;

    /**
     * A {@link SingleBaliseGroupEvent} occurs when a SingleBaliseGroup is crossed. This prompts a PositionReport with
     * package_1 to signal the RBC that a clarification is necessary.
     *
     * @param source ID from the module the event was sent by
     * @param target ID from the module the event is addressed to or 'all' if more than on target should be reached
     */
    public SingleBaliseGroupEvent(String source, String target, Location newLoc) {
        super(source, target);
        this.newLoc = newLoc;
    }
}
