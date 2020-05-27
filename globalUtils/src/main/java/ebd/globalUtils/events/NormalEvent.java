package ebd.globalUtils.events;

import java.util.List;

public class NormalEvent extends Event {

	/**
	 * Constructs an Event
	 *
	 * @param source  ID from the module the event was sent by
	 * @param target ID from the module the event is addressed to or 'all' if more than on target should be reached
	 */
	public NormalEvent(String source, String target) {
		super(source, target);
	}
}
