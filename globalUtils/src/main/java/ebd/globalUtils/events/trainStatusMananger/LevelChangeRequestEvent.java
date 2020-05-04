package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.etcsModeAndLevel.ETCSLevel;
import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class LevelChangeRequestEvent extends NormalEvent {

    public ETCSLevel newLevel;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from all modules the event is addressed to
     */
    public LevelChangeRequestEvent(String source, String target, ETCSLevel newLevel) {
        super(source, target);
        this.newLevel = newLevel;
    }
}
