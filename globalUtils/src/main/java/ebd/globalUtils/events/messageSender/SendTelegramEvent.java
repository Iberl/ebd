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
	/** List of all Destinations to send the telegram to */
	public List<String> destinations;

	/**
	 * Constructs an SendTelegramEvent
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param targets
	 *          ID from all modules the event is adressed to
	 * @param telegram
	 *          The Telegram to send
	 * @param destinations
	 * 			List of all Destinations to send the telegram to
	 */
	public SendTelegramEvent(String source, List<String> targets, Telegram telegram, List<String> destinations) {
		super(source, targets);
		this.telegram = telegram;
		this.destinations = destinations;
	}

}
