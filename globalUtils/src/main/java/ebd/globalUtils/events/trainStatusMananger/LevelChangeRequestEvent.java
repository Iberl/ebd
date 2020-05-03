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
     * @param targets ID from all modules the event is addressed to
     */
    public LevelChangeRequestEvent(String source, List<String> targets, ETCSLevel newLevel) {
        super(source, targets);
        this.newLevel = newLevel;
    }
}
