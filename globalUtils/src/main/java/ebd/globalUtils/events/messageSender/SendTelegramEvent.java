package ebd.globalUtils.events.messageSender;

import ebd.globalUtils.events.NormalEvent;
import ebd.messageLibrary.message.Telegram;

import java.util.List;

/**
 * Event send to the Message Sender containing a Telegram to transfer over global Eventbus
 *
 * @author Christopher Bernjus
 */
public class SendTelegramEvent extends NormalEvent {

	/** The Message transferred by the event*/
	public Telegram telegram;
	/** ID from from the target module or "all" if more then one target should be reached. to */
	public String destination;

	/**
	 * Constructs an SendTelegramEvent
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param target
	 *          ID from from the target module or "all" if more then one target should be reached.
	 * @param telegram
	 *          The Telegram to send
	 * @param destination
	 * 			ID from from the target module or "all" if more then one target should be reached.
	 */
	public SendTelegramEvent(String source, String target, Telegram telegram, String destination) {
		super(source, target);
		this.telegram = telegram;
		this.destination = destination;
	}

}
