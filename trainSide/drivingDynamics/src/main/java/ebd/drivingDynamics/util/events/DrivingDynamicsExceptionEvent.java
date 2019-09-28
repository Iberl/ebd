package ebd.drivingDynamics.util.events;

import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;

import java.util.List;

public class DrivingDynamicsExceptionEvent extends ExceptionEvent {

    public DrivingDynamicsExceptionEvent(String source, List<String> targets, Event cause, Exception exception) {
        super(source, targets, cause, exception);
    }

    public DrivingDynamicsExceptionEvent(String source, List<String> targets, Event cause, Exception exception, ExceptionEventTyp exceptionEventTyp) {
        super(source, targets, cause, exception, exceptionEventTyp);
    }
}
