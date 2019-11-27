package ebd.globalUtils.events.szenario;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class UpdatingInfrastructureEvent extends NormalEvent {

    public int speedInKmh;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     */
    public UpdatingInfrastructureEvent(String source, List<String> targets, int speedInKmh) {
        super(source, targets);
        this.speedInKmh = speedInKmh;
    }
}
