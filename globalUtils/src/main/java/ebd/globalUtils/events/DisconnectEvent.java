package ebd.globalUtils.events;

/**
 * This event signals all targeted subscribers that are registered on the global EventBus to unregister them self from the
 * global EventBus immediately.
 */
public class DisconnectEvent extends Event {
    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *                TODO: Define Format for IDs
     * @param target ID from all modules the event is adressed to
     */
    public DisconnectEvent(String source, String target) {
        super(source, target);
    }
}
