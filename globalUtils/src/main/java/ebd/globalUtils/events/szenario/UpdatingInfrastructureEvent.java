package ebd.globalUtils.events.szenario;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class UpdatingInfrastructureEvent extends NormalEvent {

    public int speedInKmh;
    public int infrastructureID;

    /**
     * Constructs an Event
     *  @param source  ID from the module the event was sent by
     * @param target ID from from the target module or "all" if more then one target should be reached.
     * @param infrastructureID
     */
    public UpdatingInfrastructureEvent(String source, String target, int infrastructureID, int speedInKmh) {
        super(source, target);
        this.speedInKmh = speedInKmh;
        this.infrastructureID = infrastructureID;
    }
}
