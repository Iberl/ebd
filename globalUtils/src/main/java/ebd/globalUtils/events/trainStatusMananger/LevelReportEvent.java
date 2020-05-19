package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.etcsModeAndLevel.ETCSLevel;
import ebd.globalUtils.events.Event;

public class LevelReportEvent extends Event {

    public ETCSLevel curLevel;

    /**
     * Constructs an Event
     *
     * @param source ID from the module the event was sent by
     * @param target ID from from the target module or 'all' if more then one target should be reached.
     * @param curLevel The current ETCS Level of the train
     */
    public LevelReportEvent(String source, String target, ETCSLevel curLevel) {
        super(source, target);
        this.curLevel = curLevel;
    }
}
