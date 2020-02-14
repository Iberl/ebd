package ebd.speedSupervisionModule.util.events;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;

import java.util.List;

public class SsmReportEvent extends NormalEvent {

    public SpeedInterventionLevel interventionLevel;
    public SpeedSupervisionState supervisionState;

    /**
     * Constructs an Event
     *  @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     * @param superVisionState
     */
    public SsmReportEvent(String source, List<String> targets,
                          SpeedInterventionLevel interventionLevel, SpeedSupervisionState superVisionState) {
        super(source, targets);
        this.interventionLevel = interventionLevel;
        this.supervisionState = superVisionState;
    }
}
