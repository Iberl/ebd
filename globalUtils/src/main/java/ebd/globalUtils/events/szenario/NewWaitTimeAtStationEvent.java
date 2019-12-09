package ebd.globalUtils.events.szenario;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class NewWaitTimeAtStationEvent extends NormalEvent {
    /**
     * wait time in [s]
     */
    public int waitTime;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     * @param waitTime Wait time in [s]
     */
    public NewWaitTimeAtStationEvent(String source, List<String> targets, int waitTime) {
        super(source, targets);
        this.waitTime = waitTime;
    }
}
