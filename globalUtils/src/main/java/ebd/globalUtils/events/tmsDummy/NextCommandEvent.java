package ebd.globalUtils.events.tmsDummy;

public class NextCommandEvent extends Event {

    /**
     * Constructs an NextCommandEvent
     */
    public NextCommandEvent(String trainId) {
        super(trainId, trainId);
    }

}
