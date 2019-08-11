package ebd.globalUtils.events;

import java.util.List;

/**
 * This event signals all targeted subscribers that are registered on the global EventBus to unregister them self from the
 * global EventBus immediately.
 */
public class StopEvent extends Event {
    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *                TODO: Define Format for IDs
     * @param targets ID from all modules the event is adressed to
     */
    public StopEvent(String source, List<String> targets) {
        super(source, targets);
    }
}
