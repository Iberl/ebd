package ebd.globalUtils.events;

/**
 * Superclass for all Events send over an EventBus
 * This is done to provide an easy way to listen to all events.
 *
 * @author Lars Schulze-Falck, Christopher Bernjus
 */
public class Event {

	/** ID from the module the event was sent by. */
	public String source;
	/** ID from from the target module or 'all' if more then one target should be reached. */
	public String target;

	/**
	 * Constructs an Event
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param target
	 *          ID from from the target module or 'all' if more then one target should be reached.
	 */
	public Event(String source, String target) {
		this.source = source;
		this.target = target;
	}
}