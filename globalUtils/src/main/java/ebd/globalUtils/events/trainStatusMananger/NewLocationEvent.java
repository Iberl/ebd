package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.location.Location;

import java.util.List;

public class NewLocationEvent extends NormalEvent {

    public Location newLocation;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from from the target module or 'all' if more then one target should be reached.
     */
    public NewLocationEvent(String source, String target, Location newLocation) {
        super(source, target);
        this.newLocation = newLocation;
    }
}
