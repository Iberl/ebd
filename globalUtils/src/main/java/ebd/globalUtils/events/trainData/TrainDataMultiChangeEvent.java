package ebd.globalUtils.events.trainData;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;
import java.util.Map;

public class TrainDataMultiChangeEvent extends NormalEvent {
    /**
     * A mapping of the names of fields in TrainDataVolatile and the associated value.
     */
    public Map<String, Object> fieldNameToFieldValue;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from from the target module or "all" if more then one target should be reached.
     * @param fieldNameToFieldValueMap A mapping of the names of fields in TrainDataVolatile and the associated value.
     */
    public TrainDataMultiChangeEvent(String source, String target, Map<String, Object> fieldNameToFieldValueMap) {
        super(source, target);
        this.fieldNameToFieldValue = fieldNameToFieldValueMap;
    }
}
