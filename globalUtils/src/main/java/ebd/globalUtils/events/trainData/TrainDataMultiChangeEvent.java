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
     * @param targets ID from all modules the event is addressed to
     * @param fieldNameToFieldValueMap A mapping of the names of fields in TrainDataVolatile and the associated value.
     */
    public TrainDataMultiChangeEvent(String source, List<String> targets, Map<String, Object> fieldNameToFieldValueMap) {
        super(source, targets);
        this.fieldNameToFieldValue = fieldNameToFieldValueMap;
    }
}
