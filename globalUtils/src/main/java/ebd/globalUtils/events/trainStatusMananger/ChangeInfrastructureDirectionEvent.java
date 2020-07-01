package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

public class ChangeInfrastructureDirectionEvent extends NormalEvent {

    public final int infrastructureID;

    /**
     * Constructs an Event
     *
     * @param source ID from the module the event was sent by
     * @param target ID from the module the event is addressed to or 'all' if more than on target should be reached
     */
    public ChangeInfrastructureDirectionEvent(String source, String target, int infrastructureID) {
        super(source, target);
        this.infrastructureID = infrastructureID;
    }
}
