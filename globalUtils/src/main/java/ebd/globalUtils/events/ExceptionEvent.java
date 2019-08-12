package ebd.globalUtils.events;

import ebd.globalUtils.events.util.ExceptionEventTyp;

import java.util.List;

/**
 * Superclass for all Events that encapsulate an Exception and are send over an EventBus
 *
 * @author Lars Schulze-Falck, Christopher Bernjus
 */
public class ExceptionEvent extends Event {

    /**
     *
     */
    public ExceptionEventTyp exceptionEventTyp = ExceptionEventTyp.CRITICAL;

	/**
     * The Event causing an Exception
     */
	public Event cause;

	/**
     * The thrown exception
     */
	public Exception exception;

	/**
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 *          TODO: Define Format for IDs
	 * @param targets
	 *          ID from all modules the event is adressed to
	 *          TODO: Define Format for IDs
	 * @param cause
	 *          The Event causing an Exception
	 * @param exception
	 *          The thrown exception
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
     *          TODO: Define Format for IDs
     * @param targets
     *          ID from all modules the event is adressed to
     *          TODO: Define Format for IDs
     * @param cause
     *          The Event causing an Exception
     * @param exception
     *          The thrown exception
     * @param exceptionEventTyp
     *          The ExceptionEventTyp of the Exception
     */
    public ExceptionEvent(String source, List<String> targets, Event cause, Exception exception, ExceptionEventTyp exceptionEventTyp) {
        super(source, targets);
        this.cause = cause;
        this.exception = exception;
        this.exceptionEventTyp = exceptionEventTyp;
    }

}