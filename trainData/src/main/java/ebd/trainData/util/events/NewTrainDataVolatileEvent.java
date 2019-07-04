package ebd.trainData.util.events;

import ebd.globalUtils.events.NormalEvent;
import ebd.trainData.TrainDataVolatile;

import java.util.List;

public class NewTrainDataVolatileEvent extends NormalEvent {
    public final TrainDataVolatile trainDataVolatile;

    public NewTrainDataVolatileEvent(String source, List<String> eventTargets, TrainDataVolatile trainDataVolatile) {
        super(source, eventTargets);
        this.trainDataVolatile = trainDataVolatile;
    }
}
