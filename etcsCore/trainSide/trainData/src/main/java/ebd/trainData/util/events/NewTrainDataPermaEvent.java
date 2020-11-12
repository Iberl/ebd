package ebd.trainData.util.events;

import ebd.globalUtils.events.NormalEvent;
import ebd.trainData.TrainDataPerma;

public class NewTrainDataPermaEvent extends NormalEvent {
    public final TrainDataPerma trainDataPerma;

    public NewTrainDataPermaEvent(String source, String eventTarget, TrainDataPerma trainDataPerma) {
        super(source, eventTarget);
        this.trainDataPerma = trainDataPerma;
    }
}
