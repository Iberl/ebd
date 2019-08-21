package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

/**
 * This event signals a clock tick
 */
public class ClockTickEvent extends NormalEvent {

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *                TODO: Define Format for IDs
     * @param targets ID from all modules the event is adressed to
     */
    public ClockTickEvent(String source, List<String> targets) {
        super(source, targets);
    }
}
