package ebd.globalUtils.szenario;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

/**
 * This event signals TrainManger in Scenario to remove a train
 */
public class RemoveTrainEvent extends NormalEvent {

    /**
     * ETCS ID of the train to be removed
     */
    public int etcsID;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     */
    public RemoveTrainEvent(String source, List<String> targets, int etcsID) {
        super(source, targets);
        this.etcsID = etcsID;
    }
}
