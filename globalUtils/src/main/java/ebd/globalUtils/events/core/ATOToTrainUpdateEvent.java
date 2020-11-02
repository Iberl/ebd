package ebd.globalUtils.events.core;

import ebd.globalUtils.events.NormalEvent;

public class ATOToTrainUpdateEvent extends NormalEvent {

    /**
     * Format: "etcsID action [modifier]"
     */
    public final String information;

    /**
     * Transmits information form ATO Server to a train
     *  @param source ID from the module the event was sent by
     * @param target ID from the module the event is addressed to or 'all' if more than on target should be reached
     * @param information A String containing information from ATO Controll
     */
    public ATOToTrainUpdateEvent(String source, String target, String information) {
        super(source, target);
        this.information = information;
    }
}
