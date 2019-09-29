package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class NewMaMessage extends NormalEvent {
    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     */
    public NewMaMessage(String source, List<String> targets) {
        super(source, targets);
    }
}
