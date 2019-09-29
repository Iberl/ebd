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
	 * @param targets
	 *          ID from all modules the event is adressed to
	 * @param message
	 *          The Message received by Message Receiver
	 * @param sender
	 *          Sender ID of the received Message
	 */
	public ReceivedMessageEvent(String source, List<String> targets, Message message, String sender) {
		super(source, targets);
		this.message = message;
		this.sender = sender;
	}

}
