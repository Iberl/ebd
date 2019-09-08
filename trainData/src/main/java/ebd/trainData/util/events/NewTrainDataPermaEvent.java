package ebd.trainData.util.events;

import ebd.globalUtils.events.NormalEvent;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;

import java.util.List;

public class NewTrainDataPermaEvent extends NormalEvent {
    public final TrainDataPerma trainDataPerma;

    public NewTrainDataPermaEvent(String source, List<String> eventTargets, TrainDataPerma trainDataPerma) {
        super(source, eventTargets);
        this.trainDataPerma = trainDataPerma;
    }
}
