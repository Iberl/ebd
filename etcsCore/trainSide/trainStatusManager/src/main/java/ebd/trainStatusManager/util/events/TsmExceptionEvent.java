package ebd.trainStatusManager.util.events;

import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;

public class TsmExceptionEvent extends ExceptionEvent {

    /**
     *
     * @param source
     *          ID from the module the event was sent by
     * @param target
     *          ID from from the target module or 'all' if more then one target should be reached.
     * @param cause
     *          The Event causing an Exception
     * @param exception
     *          The thrown exception to be encapsulated
     */
    public TsmExceptionEvent(String source, String target, Event cause, Exception exception) {
        super(source, target, cause, exception);
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
    public TsmExceptionEvent(String source, String target, Event cause, Exception exception, ExceptionEventTyp exceptionEventTyp) {
        super(source, target, cause, exception, exceptionEventTyp);
    }
}
