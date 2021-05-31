package ebd.globalUtils.events.tmsDummy;

public class StepEvent extends Event {

    /**
     * Constructs an TriggerEvent
     */
    public StepEvent(String trainId) {
        super("tms", trainId);
    }

}
