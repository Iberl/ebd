package ebd.globalUtils.events.messageLibrary;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

/**
 * Superclass for all Events send over an EventBus containing an Message or Telegram
 *
 * @author Christopher Bernjus
 */
public class MessageEvent extends NormalEvent {

	/** The Content transferred by the event*/
	public Object content;

	/**
	 * Constructs an MessageEvent
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 *          TODO: Define Format for IDs
	 * @param targets
	 *          ID from all modules the event is adressed to
	 *          TODO: Define Format for IDs
	 * @param content
	 *          A Message or Telegram transferred by the event
	 */
	public MessageEvent(String source, List<String> targets, Object content) {
		super(source, targets);
		this.content = content;
	}

}
