package ebd.globalUtils.events.tmsDummy;

import ebd.globalUtils.events.NormalEvent;

public class TMSDummyStartEvent extends NormalEvent {

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from the module the event is addressed to or 'all' if more than on target should be reached
     */
    public TMSDummyStartEvent(String source, String target) {
        super(source, target);
    }

}
