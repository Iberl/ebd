package ebd.breakingCurveCalculator.utils.events;

import java.util.List;

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
     * {@link ExceptionEvent#ExceptionEvent(String, List, Event, Exception)}
     */
    public BreakingCurveExceptionEvent(String source, List<String> targets, Event cause, Exception exception) {
        super(source, targets, cause, exception);
    }
}