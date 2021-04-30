package ebd.globalUtils.events.radioBlockCenter;

import ebd.globalUtils.events.NormalEvent;
import ebd.messageLibrary.message.Message;


/**
 * @author Lars Schulze-Falck
 */
public class ReceivedTMSMessageEvent extends NormalEvent {

    public Message message;

    /**
     * Constructs an Event
     *
     * @param message Received Message
     *
     * @author Christopher Bernjus
     */
    public ReceivedTMSMessageEvent(String source, String target, Message message) {
        super(source, target);
        this.message = message;
    }
}
