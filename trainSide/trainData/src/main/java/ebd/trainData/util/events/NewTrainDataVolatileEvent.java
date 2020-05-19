package ebd.trainData.util.events;

import ebd.globalUtils.events.NormalEvent;
import ebd.trainData.TrainDataVolatile;

import java.util.List;

public class NewTrainDataVolatileEvent extends NormalEvent {
    public final TrainDataVolatile trainDataVolatile;

    public NewTrainDataVolatileEvent(String source, String target, TrainDataVolatile trainDataVolatile) {
        super(source, target);
        this.trainDataVolatile = trainDataVolatile;
    }
}
