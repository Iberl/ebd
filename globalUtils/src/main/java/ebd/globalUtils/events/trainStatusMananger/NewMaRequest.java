package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class NewMaRequest extends NormalEvent {

    public int Q_MARQSTREASON;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     */
    public NewMaRequest(String source, List<String> targets, int Q_MARQSTREASON) {
        super(source, targets);
        this.Q_MARQSTREASON = Q_MARQSTREASON;
    }
}
