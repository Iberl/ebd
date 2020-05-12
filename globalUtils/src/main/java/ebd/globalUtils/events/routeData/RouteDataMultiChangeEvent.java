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
     * @param target ID from from the target module or 'all' if more then one target should be reached.
     * @param fieldNamesToFieldValues A map of field names and valid field values
     */
    public RouteDataMultiChangeEvent(String source, String target, Map<String,Object> fieldNamesToFieldValues) {
        super(source, target);
        this.fieldNamesToFieldValues = fieldNamesToFieldValues;
    }
}
