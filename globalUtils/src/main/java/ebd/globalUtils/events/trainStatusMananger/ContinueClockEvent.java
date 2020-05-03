package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

/**
 * This event signals a clock tick
 */
public class ContinueClockEvent extends NormalEvent {

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *
     * @param target ID from from the target module or 'all' if more then one target should be reached.
     */
    public ContinueClockEvent(String source, String target) {
        super(source, target);
    }
}
