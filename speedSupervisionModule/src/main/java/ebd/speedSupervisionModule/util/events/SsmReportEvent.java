package ebd.speedSupervisionModule.util.events;

import ebd.globalUtils.events.NormalEvent;

import java.io.Serializable;
import java.util.List;

public class SsmReportEvent extends NormalEvent {

    public boolean toFast;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     */
    public SsmReportEvent(String source, List<String> targets, boolean toFast) {
        super(source, targets);
        this.toFast = toFast;
    }
}
