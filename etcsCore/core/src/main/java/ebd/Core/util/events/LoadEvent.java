package ebd.Core.util.events;

import ebd.globalUtils.events.NormalEvent;

public class LoadEvent extends NormalEvent {
    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from all modules the event is adressed to
     */
    public LoadEvent(String source, String target) {
        super(source, target);
    }
}
