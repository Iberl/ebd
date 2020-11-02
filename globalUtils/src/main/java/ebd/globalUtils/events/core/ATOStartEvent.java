package ebd.globalUtils.events.core;

import ebd.globalUtils.events.NormalEvent;

public class ATOStartEvent extends NormalEvent {
    /**
     * Signals a train to switch to ATO Start
     *
     * @param source ID from the module the event was sent by
     * @param target ID from the module the event is addressed to or 'all' if more than on target should be reached
     */
    public ATOStartEvent(String source, String target) {
        super(source, target);
    }
}
