package ebd.globalUtils.szenario;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class NewTrainEvent extends NormalEvent {

    /*
     * IDs of the train to be added
     */
    private int etcsID;
    private int trainConfigID;
    private int infrastructureID;
    private String scheduleID;
    private int rbcID;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     */
    public NewTrainEvent(String source,
                         List<String> targets,
                         int etcsID,
                         int trainConfigID,
                         int infrastructureID,
                         String scheduleID,
                         int rbcID) {
        super(source, targets);
        this.etcsID = etcsID;
        this.trainConfigID = trainConfigID;
        this.infrastructureID = infrastructureID;
        this.scheduleID = scheduleID;
        this.rbcID = rbcID;
    }
}
