package ebd.core.util.events;

import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;

public class SzenarioExceptionEvent extends ExceptionEvent {

    public SzenarioExceptionEvent(String source, String target, Event cause, Exception exception) {
        super(source, target, cause, exception);
    }

    public SzenarioExceptionEvent(String source, String target, Event cause, Exception exception, ExceptionEventTyp exceptionEventTyp) {
        super(source, target, cause, exception, exceptionEventTyp);
    }
}
