package ebd.globalUtils.events.messageReceiver;

import ebd.globalUtils.events.NormalEvent;
import ebd.messageLibrary.message.Telegram;

import java.util.List;

/**
 * Event send to TSM by the Message Receiver containing an received Telegram
 *
 * @author Christopher Bernjus
 */
public class ReceivedTelegramEvent extends NormalEvent {

	/** The Telegram carried by the event*/
	public Telegram telegram;

	/**
	 * Constructs an ReceivedMessageEvent
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param targets
	 *          ID from all modules the event is adressed to
	 * @param telegram
	 *          The Telegram received by Message Receiver
	 */
	public ReceivedTelegramEvent(String source, List<String> targets, Telegram telegram) {
		super(source, targets);
		this.telegram = telegram;
	}

}
