package ebd.routeData.util.events;

import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.ExceptionEvent;

import java.util.List;

/**
 * @author Lars Schulze-Falck
 */
public class RouteDataExceptionEvent extends ExceptionEvent {

    /**
     * @param source    ID from the module the event was sent by
     *                  TODO: Define Format for IDs
     * @param targets   ID from all modules the event is adressed to
     *                  TODO: Define Format for IDs
     * @param cause     The Event causing an Exception
     * @param exception
     */
    public RouteDataExceptionEvent(String source, List<String> targets, Event cause, Exception exception) {
        super(source, targets, cause, exception);
    }
}