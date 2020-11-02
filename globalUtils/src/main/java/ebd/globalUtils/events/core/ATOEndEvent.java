package ebd.globalUtils.events.core;

import ebd.globalUtils.events.NormalEvent;

public class ATOEndEvent extends NormalEvent {
    /**
     * Signals a train to switch ATO off
     *
     * @param source ID from the module the event was sent by
     * @param target ID from the module the event is addressed to or 'all' if more than on target should be reached
     */
    public ATOEndEvent(String source, String target) {
        super(source, target);
    }
}
