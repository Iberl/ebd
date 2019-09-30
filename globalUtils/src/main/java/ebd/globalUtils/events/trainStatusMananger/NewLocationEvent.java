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
     *                TODO: Define Format for IDs
     * @param targets ID from all modules the event is adressed to
     */
    public NewLocationEvent(String source, List<String> targets, Location newLocation) {
        super(source, targets);
        this.newLocation = newLocation;
    }
}
