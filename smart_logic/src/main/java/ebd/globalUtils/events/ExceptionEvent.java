package ebd.globalUtils.events;

import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import org.jetbrains.annotations.NotNull;

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
	 * use a {@link NotCausedByAEvent}
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
	 * @param target
	 *          ID from from the target module or 'all' if more then one target should be reached.
	 * @param exception
	 *          The thrown exception
	 */
	public ExceptionEvent(String source, String target, @NotNull Exception exception){
		super(source,target);
		this.exception = exception;
		this.cause = new NotCausedByAEvent();
		this.exceptionEventTyp = ExceptionEventTyp.CRITICAL;
	}

	/**
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param target
	 *          ID from all modules the event is addressed to
	 * @param exception
	 *          The thrown exception to be encapsulated
	 */
	public ExceptionEvent(String source, String target, @NotNull Exception exception, @NotNull ExceptionEventTyp exceptionEventTyp){
		super(source,target);
		this.exception = exception;
		this.cause = new NotCausedByAEvent();
		this.exceptionEventTyp = exceptionEventTyp;
	}

	/**
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param target
	 *          ID from all modules the event is addressed to
	 * @param cause
	 *          The Event causing an Exception
	 * @param exception
	 *          The thrown exception to be encapsulated
	 */
	public ExceptionEvent(String source, String target, @NotNull Event cause, @NotNull Exception exception) {
		super(source, target);
		this.cause = cause;
		this.exception = exception;
	}

	/**
	 *
	 * @param source
	 *          ID from the module the event was sent by
	 * @param target
	 *          ID from from the target module or 'all' if more then one target should be reached.
	 * @param cause
	 *          The Event causing an Exception
	 * @param exception
	 *          The thrown exception
	 * @param exceptionEventTyp
	 * 			The fitting {@link ExceptionEventTyp}
	 */
	public ExceptionEvent(String source, String target, @NotNull Event cause, @NotNull Exception exception, @NotNull ExceptionEventTyp exceptionEventTyp) {
		super(source, target);
		this.cause = cause;
		this.exception = exception;
		this.exceptionEventTyp = exceptionEventTyp;
	}
}