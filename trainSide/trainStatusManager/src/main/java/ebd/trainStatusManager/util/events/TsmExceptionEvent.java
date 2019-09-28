package ebd.trainStatusManager.util.events;

import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;

import java.util.List;

public class TsmExceptionEvent extends ExceptionEvent {

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
    public TsmExceptionEvent(String source, List<String> targets, Event cause, Exception exception) {
        super(source, targets, cause, exception);
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
    public TsmExceptionEvent(String source, List<String> targets, Event cause, Exception exception, ExceptionEventTyp exceptionEventTyp) {
        super(source, targets, cause, exception, exceptionEventTyp);
    }
}
