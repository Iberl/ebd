package ebd.breakingCurveCalculator.utils.events;

import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;

/**
 * This Event signals and transmits an exception in the BreakingCurveCalculator module.
 * @author Lars Schulze-Falck
 *
 */
public class BreakingCurveExceptionEvent extends ExceptionEvent{

    /**
     * This Event signals and transmits an exception in the BreakingCurveCalculator module.
     * {@link ExceptionEvent#ExceptionEvent(String, String, Event, Exception)}
     */
    public BreakingCurveExceptionEvent(String source, String target, Event cause, Exception exception) {
        super(source, target, cause, exception);
    }
}