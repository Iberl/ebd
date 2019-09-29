package ebd.globalUtils.events.routeData;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;
import java.util.Map;

public class RouteDataMultiChangeEvent extends NormalEvent {

    /**
     * A map of field names and valid field values
     */
    public Map<String,Object> fieldNamesToFieldValues;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *                TODO: Define Format for IDs
     * @param targets ID from all modules the event is adressed to
     * @param fieldNamesToFieldValues A map of field names and valid field values
     */
    public RouteDataMultiChangeEvent(String source, List<String> targets, Map<String,Object> fieldNamesToFieldValues) {
        super(source, targets);
        this.fieldNamesToFieldValues = fieldNamesToFieldValues;
    }
}
