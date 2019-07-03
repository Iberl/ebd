package ebd.globalUtils.events;

import java.util.List;

/**
 * Superclass for all Events send over an EventBus
 * This is done to provide an easy way to listen to all events.
 *
 * @author Lars Schulze-Falck, Christopher Bernjus
 */
public class Event {

	/** ID from the module the event was sent by */
	public String source;
	/** ID from all modules the event is adressed to */
	public List<String> targets;

	/**
	 * Constructs an Event
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 *          TODO: Define Format for IDs
	 * @param targets
	 *          ID from all modules the event is adressed to
	 *          TODO: Define Format for IDs
	 */
	public Event(String source, List<String> targets) {
		this.source = source;
		this.targets = targets;
	}
}