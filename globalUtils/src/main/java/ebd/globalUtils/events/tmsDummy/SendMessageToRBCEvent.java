package ebd.globalUtils.events.tmsDummy;

import ebd.rbc_tms.Message;

/**
 * @author Christopher Bernjus
 */
public class SendMessageToRBCEvent extends Event {

    /** Message to be send to TMS */
    public Message message;

    /**
     * Constructs an Event
     *
     * @param message {@link ebd.globalUtils.events.tmsDummy.SendMessageToRBCEvent#message}
     *
     * @author Christopher Bernjus
     */
    public SendMessageToRBCEvent(String source, Message message) {
        super(source, "com");
        this.message = message;
    }
}
