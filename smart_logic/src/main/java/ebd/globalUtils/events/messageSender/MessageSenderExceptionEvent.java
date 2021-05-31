package ebd.globalUtils.events.messageSender;

import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;

public class MessageSenderExceptionEvent extends ExceptionEvent {

	/**
	 * @param source    ID from the module the event was sent by
	 *
	 * @param target   ID from from the target module or "all" if more then one target should be reached.
	 *
	 * @param cause     The Event causing an Exception
	 * @param exception
	 */
	public MessageSenderExceptionEvent(String source, String target, Event cause, Exception exception) {
		super(source, target, cause, exception);
	}
}
