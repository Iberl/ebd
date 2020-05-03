package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class CrossedBaliseGroupEvent extends NormalEvent {

    public int baliseGroupID;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *
     * @param target ID from from the target module or 'all' if more then one target should be reached.
     */
    public CrossedBaliseGroupEvent(String source, String target, int baliseGroupID) {
        super(source, target);
        this.baliseGroupID = baliseGroupID;
    }
}
