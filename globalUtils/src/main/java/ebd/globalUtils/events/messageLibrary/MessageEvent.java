package ebd.globalUtils.events.messageLibrary;

import ebd.globalUtils.events.NormalEvent;

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
	 * @param target
	 *          ID from the module the event is adressed to
	 *          TODO: Define Format for IDs
	 * @param content
	 *          A Message or Telegram transferred by the event
	 */
	public MessageEvent(String source, String target, Object content) {
		super(source, target);
		this.content = content;
	}

}
