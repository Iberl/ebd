package ebd.szenario.util.events;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class LoadTwoEvent extends NormalEvent {
    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     */
    public LoadTwoEvent(String source, List<String> targets) {
        super(source, targets);
    }
}
