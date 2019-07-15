package ebd.trainData.util.events;

import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;

import java.util.List;

/**
 * @author Lars Schulze-Falck
 */
public class TrainDataExceptionEvent extends ExceptionEvent {

    /**
     * @param source    ID from the module the event was sent by
     *
     *                  TODO: Define Format for IDs
     * @param targets   ID from all modules the event is adressed to
     *                  TODO: Define Format for IDs
     *
     * @param cause     The Event causing an Exception
     *
     * @param exception The exception that was thrown
     */
    public TrainDataExceptionEvent(String source, List<String> targets, Event cause, Exception exception) {
        super(source, targets, cause, exception);
    }

    /**
     * @param source
     *              ID from the module the event was sent by
     *              TODO: Define Format for IDs
     *
     * @param targets
     *              ID from all modules the event is adressed to
     *              TODO: Define Format for IDs
     *
     * @param cause
     *              The Event causing an Exception
     *
     * @param exception
     *              The exception that was thrown
     *
     * @param exceptionEventTyp
     *              The {@link ExceptionEventTyp} appropriate to the exception
     */
    public TrainDataExceptionEvent(String source, List<String> targets, Event cause, Exception exception, ExceptionEventTyp exceptionEventTyp) {
        super(source, targets, cause, exception, exceptionEventTyp);
    }
}
