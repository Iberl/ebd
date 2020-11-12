package ebd.globalUtils.events.radioBlockCenter;

import ebd.globalUtils.events.NormalEvent;
import ebd.rbc_tms.Message;

/**
 * @author Christopher Bernjus
 */
public class SendTMSMessageEvent extends NormalEvent {

    /** Message to be send to TMS */
    public Message message;

    /**
     * Constructs an Event
     *
     * @param message {@link SendTMSMessageEvent#message}
     *
     * @author Christopher Bernjus
     */
    public SendTMSMessageEvent(String source, String target, Message message) {
        super(source, target);
        this.message = message;
    }
}
