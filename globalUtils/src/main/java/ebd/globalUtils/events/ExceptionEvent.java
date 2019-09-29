package ebd.globalUtils.events;

import ebd.globalUtils.events.util.ExceptionEventTyp;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Superclass for all Events that encapsulate an Exception and are send over an EventBus
 *
 * @author Lars Schulze-Falck, Christopher Bernjus
 */
public class ExceptionEvent extends Event {

    /**
     * The ExceptionEventTyp, defaults to CRITICAL
     */
    @NotNull
    public ExceptionEventTyp exceptionEventTyp = ExceptionEventTyp.CRITICAL;

	/**
	 * The Event causing an Exception. If there is not a Event causing the exception,
	 * use a {@link ebd.globalUtils.events.util.NotCausedByAEvent}
	 */
	@NotNull
	public Event cause;

	/**
	 * The exception that was thrown
	 */
	@NotNull
	public Exception exception;

	/**
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param targets
	 *          ID from all modules the event is addressed to
	 * @param cause
	 *          The Event causing an Exception
	 * @param exception
	 *          The thrown exception to be encapsulated
	 */
	public ExceptionEvent(String source, List<String> targets, Event cause, Exception exception) {
		super(source, targets);
		this.cause = cause;
		this.exception = exception;
	}

	/**
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param targets
	 *          ID from all modules the event is addressed to
	 * @param cause
	 *          The Event causing an Exception
	 * @param exception
	 *          The thrown exception
	 * @param exceptionEventTyp
	 * 			The fitting {@link ExceptionEventTyp}
	 */
	public ExceptionEvent(String source, List<String> targets, Event cause, Exception exception, ExceptionEventTyp exceptionEventTyp) {
		super(source, targets);
		this.cause = cause;
		this.exception = exception;
		this.exceptionEventTyp = exceptionEventTyp;
	}
}