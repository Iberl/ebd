package ebd.globalUtils.events.core;

import ebd.globalUtils.events.NormalEvent;

public class TrainToAtoUpdateEvent extends NormalEvent {

    /**
     * Format: "etcsID information"
     */
    public final String information;

    /**
     * Signals a train to switch ATO off
     * @param source ID from the module the event was sent by
     * @param target ID from the module the event is addressed to or 'all' if more than on target should be reached
     * @param information A String containing information from a train for ATO
     */
    public TrainToAtoUpdateEvent(String source, String target, String information) {
        super(source, target);
        this.information = information;
    }
}
