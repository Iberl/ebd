package ebd.globalUtils.events.routeData;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

/**
 * @author Lars Schulze-Falck
 */
public class RouteDataChangeEvent extends NormalEvent {
    public String fieldName;
    public Object fieldValue;
    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *
     * @param target ID from from the target module or "all" if more then one target should be reached.
     */
    public RouteDataChangeEvent(String source, String target, String fieldName, Object fieldValue) {
        super(source, target);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
