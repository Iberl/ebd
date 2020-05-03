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
	public String destination;

	/**
	 * Constructs an SendMessageEvent
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param target
	 *          ID from from the target module or "all" if more then one target should be reached.
	 * @param message
	 *          The Message to send
	 * @param destination
	 * 			List of all Destinations to send the message to
	 */
	public SendMessageEvent(String source, String target, Message message, String destination) {
		super(source, target);
		this.message = message;
		this.destination = destination;
	}

}
