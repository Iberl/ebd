package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

public class SwitchInfrastructureDirectionEvent extends NormalEvent {

    /**
     * Constructs an Event
     *
     * @param source ID from the module the event was sent by
     * @param target ID from the module the event is sent to
     */
    public SwitchInfrastructureDirectionEvent(String source, String target) {
        super(source, target);
    }
}
