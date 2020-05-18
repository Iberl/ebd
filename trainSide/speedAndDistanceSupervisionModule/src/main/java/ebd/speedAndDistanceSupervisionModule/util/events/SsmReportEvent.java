package ebd.speedAndDistanceSupervisionModule.util.events;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;

public class SsmReportEvent extends NormalEvent {

    public SpeedInterventionLevel interventionLevel;
    public SpeedSupervisionState supervisionState;

    /**
     * Constructs an Event
     *  @param source  ID from the module the event was sent by
     * @param target ID from all modules the event is addressed to
     * @param superVisionState
     */
    public SsmReportEvent(String source, String target,
                          SpeedInterventionLevel interventionLevel, SpeedSupervisionState superVisionState) {
        super(source, target);
        this.interventionLevel = interventionLevel;
        this.supervisionState = superVisionState;
    }
}
