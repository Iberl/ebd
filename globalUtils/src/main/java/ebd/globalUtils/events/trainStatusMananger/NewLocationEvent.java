package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.location.Location;

import java.util.List;

public class NewLocationEvent extends NormalEvent {

    public Location newLocation;

    /**
     * NewLocationEvent signals the crossing of a balise. This event is used to update the reference location of the current position
     * and as possible trigger for information requests.
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from from the target module or 'all' if more then one target should be reached.
     */
    public NewLocationEvent(String source, String target, Location newLocation) {
        super(source, target);
        this.newLocation = newLocation;
    }
}
