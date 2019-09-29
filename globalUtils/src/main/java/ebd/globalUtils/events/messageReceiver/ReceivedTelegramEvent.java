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
	/** Sender ID of the received Telegram */
	public String sender;

	/**
	 * Constructs an ReceivedMessageEvent
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param targets
	 *          ID from all modules the event is adressed to
	 * @param telegram
	 *          The Telegram received by Message Receiver
	 * @param sender
	 *          Sender ID of the received Telegram
	 */
	public ReceivedTelegramEvent(String source, List<String> targets, Telegram telegram, String sender) {
		super(source, targets);
		this.telegram = telegram;
		this.sender = sender;
	}

}
