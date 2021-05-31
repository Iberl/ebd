package ebd.globalUtils.events.trainData;

import ebd.globalUtils.events.NormalEvent;

/**
 * @author Lars Schulze-Falck
 */
public class TrainDataChangeEvent extends NormalEvent {

    public String fieldName;
    public Object fieldValue;
    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *
     * @param target ID from from the target module or "all" if more then one target should be reached.
     */
    public TrainDataChangeEvent(String source, String target, String fieldName, Object fieldValue) {
        super(source, target);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
