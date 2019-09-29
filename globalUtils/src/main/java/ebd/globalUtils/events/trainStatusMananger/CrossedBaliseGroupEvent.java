package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class CrossedBaliseGroupEvent extends NormalEvent {

    public int baliseGroupID;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *                TODO: Define Format for IDs
     * @param targets ID from all modules the event is adressed to
     */
    public CrossedBaliseGroupEvent(String source, List<String> targets, int baliseGroupID) {
        super(source, targets);
        this.baliseGroupID = baliseGroupID;
    }
}
