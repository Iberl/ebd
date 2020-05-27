package ebd.globalUtils.events.radioBlockCenter;

import ebd.globalUtils.events.NormalEvent;
import ebd.rbc_tms.message.Message_00;

/**
 *
 *
 * @author Christopher Bernjus
 */
public class SendTMSResponseEvent extends NormalEvent {

    Message_00 message;

    /**
     * Constructs an Event
     *
     * @param message Received Message
     *
     * @author Christopher Bernjus
     */
    public SendTMSResponseEvent(String source, String target, Message_00 message) {
        super(source, target);
        this.message = message;
    }
}
