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
     * @param target   ID from from the target module or "all" if more then one target should be reached.
     * @param cause     The Event causing an Exception
     * @param exception
     */
    public RouteDataExceptionEvent(String source, String target, Event cause, Exception exception) {
        super(source, target, cause, exception);
    }
}
