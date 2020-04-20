package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class ReleaseSpeedModeStateEvent extends NormalEvent {

    public boolean inRSM;
    public final double curReleaseSpeed;

    /**
     * Constructs an Event
     *  @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     * @param inReleaseSpeedSupervision If the trains speed supervision should be in ReleaseSpeedMode
     * @param curReleaseSpeed
     */
    public ReleaseSpeedModeStateEvent(String source, List<String> targets, boolean inReleaseSpeedSupervision, double curReleaseSpeed) {
        super(source, targets);
        this.inRSM = inReleaseSpeedSupervision;
        this.curReleaseSpeed = curReleaseSpeed;
    }
}
