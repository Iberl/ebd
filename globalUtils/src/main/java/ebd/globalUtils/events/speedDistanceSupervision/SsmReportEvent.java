package ebd.globalUtils.events.speedDistanceSupervision;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;

public class SsmReportEvent extends NormalEvent {

    public final SpeedInterventionLevel interventionLevel;
    public final SpeedSupervisionState supervisionState;
    public final double releaseDistance;
    public final double releaseSpeed;

    /**
     * Constructs an Event
     * @param source  ID from the module the event was sent by
     * @param target ID from all modules the event is addressed to
     * @param interventionLevel The current {@link SpeedInterventionLevel}
     * @param superVisionState The current {@link SpeedSupervisionState}
     * @param releaseDistance the current distance relative to the reference location at which release speed starts in [m].
     * @param releaseSpeed the current applicable release speed in [m/s]
     */
    public SsmReportEvent(String source, String target,
                          SpeedInterventionLevel interventionLevel, SpeedSupervisionState superVisionState, double releaseDistance, double releaseSpeed) {
        super(source, target);
        this.interventionLevel = interventionLevel;
        this.supervisionState = superVisionState;
        this.releaseDistance = releaseDistance;
        this.releaseSpeed = releaseSpeed;
    }
}
