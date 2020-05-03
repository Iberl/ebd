package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class TsmTripEndEvent extends NormalEvent {
    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *
     * @param target ID from from the target module or "all" if more then one target should be reached.
     */
    public TsmTripEndEvent(String source, String target) {
        super(source, target);
    }
}
