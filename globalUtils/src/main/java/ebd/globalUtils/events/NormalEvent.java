package ebd.globalUtils.events;

import java.util.List;

public class NormalEvent extends Event{


    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *                TODO: Define Format for IDs
     * @param targets ID from all modules the event is adressed to
     */
    public NormalEvent(String source, List<String> targets) {
        super(source, targets);
    }
}
