package ebd.szenario.util.events;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class LoadEvent extends NormalEvent {
    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is adressed to
     */
    public LoadEvent(String source, List<String> targets) {
        super(source, targets);
    }
}