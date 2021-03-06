package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.enums.ETCSMode;
import ebd.globalUtils.events.Event;

public class ModeReportEvent extends Event {

    public final ETCSMode curMode;

    /**
     * Constructs an Event
     *
     * @param source ID from the module the event was sent by
     * @param target ID from from the target module or 'all' if more then one target should be reached.
     * @param curMode The current ETCS Mode of the train
     */
    public ModeReportEvent(String source, String target, ETCSMode curMode) {
        super(source, target);
        this.curMode = curMode;
    }
}
