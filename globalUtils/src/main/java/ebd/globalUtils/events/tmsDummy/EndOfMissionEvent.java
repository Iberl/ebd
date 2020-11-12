package ebd.globalUtils.events.tmsDummy;

public class EndOfMissionEvent extends Event {

    /**
     * Constructs an EndOfMissionEvent
     *
     * @param trainId
     */
    public EndOfMissionEvent(String trainId) {
        super(trainId, "tms");
    }

}
