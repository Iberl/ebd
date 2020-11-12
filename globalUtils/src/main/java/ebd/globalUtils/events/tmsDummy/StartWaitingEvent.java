package ebd.globalUtils.events.tmsDummy;

public class StartWaitingEvent extends Event {

    /**
     * Constructs an StartWaitingEvent
     */
    public StartWaitingEvent(String trainId) {
        super(trainId, "tms");
    }

}
