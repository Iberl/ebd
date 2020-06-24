package ebd.globalUtils.events.radioBlockCenter;

import ebd.globalUtils.events.NormalEvent;
import ebd.rbc_tms.message.Message_00;

/**
 *
 *
 * @author Christopher Bernjus
 */
public class SendTMSResponseEvent extends NormalEvent {

    public Message_00 response;

    /**
     * Constructs an Event
     *
     * @param response Response to send
     *
     * @author Christopher Bernjus
     */
    public SendTMSResponseEvent(String source, String target, Message_00 response) {
        super(source, target);
        this.response = response;
    }
}
