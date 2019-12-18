package ebd.trainStatusManager.util.handlers;

import ebd.globalUtils.events.ExceptionEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Class for logging exceptions occurring on EventBus
 *
 * @author Christopher Bernjus
 */
public class ExceptionHandler {

	// -----------------
	// Exception Handler
	// -----------------

	public EventBus eventBus;


	// Constructor

	public ExceptionHandler(EventBus eventBus) {
		this.eventBus = eventBus;
		eventBus.register(this);
	}




	// Methods

	@Subscribe
	public void log(Exception e) {
		e.printStackTrace();
	}

	@Subscribe
	public void log(ExceptionEvent e) {
		System.err.println("An Message Exception occurred");
		System.err.println("On Message: " + e.cause);
		System.err.println("From Module: " + e.source);
		System.err.println("To Module: " + e.targets.toString());
		e.exception.printStackTrace();
	}

	public void unregister() {
		eventBus.unregister(this);
	}
}
