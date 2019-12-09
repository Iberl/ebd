package ebd.globalUtils.events.messageSender;

import ebd.globalUtils.events.NormalEvent;
import ebd.messageLibrary.message.Message;

import java.util.List;

/**
 * Event send to the Message Sender containing a Message to transfer over global Eventbus
 *
 * @author Christopher Bernjus
 */
public class SendMessageEvent extends NormalEvent {

	/** The Message transferred by the event*/
	public Message message;
	/** List of all Destinations to send the message to */
	public List<String> destinations;

	/**
	 * Constructs an SendMessageEvent
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param targets
	 *          ID from all modules the event is adressed to
	 * @param message
	 *          The Message to send
	 * @param destinations
	 * 			List of all Destinations to send the message to
	 */
	public SendMessageEvent(String source, List<String> targets, Message message, List<String> destinations) {
		super(source, targets);
		this.message = message;
		this.destinations = destinations;
	}

}
