package ebd.globalUtils.events.messageReceiver;

import ebd.globalUtils.events.NormalEvent;
import ebd.messageLibrary.message.Message;

import java.util.List;

/**
 * Event send to TSM by the Message Receiver containing an received Message
 *
 * @author Christopher Bernjus
 */
public class ReceivedMessageEvent extends NormalEvent {

	/** The received Message carried by the event */
	public Message message;
	/** Sender ID of the received Message */
	public String sender;

	/**
	 * Constructs an ReceivedMessageEvent
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param target
	 *          ID from from the target module or "all" if more then one target should be reached.
	 * @param message
	 *          The Message received by Message Receiver
	 * @param sender
	 *          Sender ID of the received Message
	 */
	public ReceivedMessageEvent(String source, String target, Message message, String sender) {
		super(source, target);
		this.message = message;
		this.sender = sender;
	}

}
