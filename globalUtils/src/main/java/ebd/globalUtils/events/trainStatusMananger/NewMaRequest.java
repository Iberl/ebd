package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class NewMaRequest extends NormalEvent {

    public int Q_MARQSTREASON;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from from the target module or "all" if more then one target should be reached.
     */
    public NewMaRequest(String source, String target, int Q_MARQSTREASON) {
        super(source, target);
        this.Q_MARQSTREASON = Q_MARQSTREASON;
    }
}
