package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.etcsModeAndLevel.ETCSMode;
import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class ModeChangeRequestEvent extends NormalEvent {

    public ETCSMode newMode;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     */
    public ModeChangeRequestEvent(String source, List<String> targets, ETCSMode newMode) {
        super(source, targets);
        this.newMode = newMode;
    }
}
