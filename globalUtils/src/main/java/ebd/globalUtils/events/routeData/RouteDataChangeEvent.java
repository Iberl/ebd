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
     *                TODO: Define Format for IDs
     * @param targets ID from all modules the event is adressed to
     */
    public RouteDataChangeEvent(String source, List<String> targets, String fieldName, Object fieldValue) {
        super(source, targets);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
