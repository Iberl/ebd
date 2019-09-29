package ebd.szenario.util.events;

import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;

import java.util.List;

public class SzenarioExceptionEvent extends ExceptionEvent {


    public SzenarioExceptionEvent(String source, List<String> targets, Event cause, Exception exception) {
        super(source, targets, cause, exception, ExceptionEventTyp.FATAL);
    }
}
