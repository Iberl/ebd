package ebd.globalUtils.events.szenario;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class TerminateTrainEvent extends NormalEvent {
    public int infrastructureID;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from from the target module or "all" if more then one target should be reached.
     */
    public TerminateTrainEvent(String source, String target, int infrastructureID) {
        super(source, target);
        this.infrastructureID = infrastructureID;
    }
}
