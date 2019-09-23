package ebd.speedSupervisionModule.util.events;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;

import java.io.Serializable;
import java.util.List;

public class SsmReportEvent extends NormalEvent {

    public SpeedInterventionLevel interventionLevel;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     */
    public SsmReportEvent(String source, List<String> targets, SpeedInterventionLevel interventionLevel) {
        super(source, targets);
        this.interventionLevel = interventionLevel;
    }
}
