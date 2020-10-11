package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class ReleaseSpeedModeStateEvent extends NormalEvent {

    public boolean inRSM;
    public final double curReleaseSpeed;
    public double releaseDistance;

    /**
     * Constructs an Event
     *  @param source  ID from the module the event was sent by
     * @param target ID from all modules the event is addressed to
     * @param inReleaseSpeedSupervision If the trains speed supervision should be in ReleaseSpeedMode
     * @param curReleaseSpeed
     */
    public ReleaseSpeedModeStateEvent(String source,
                                      String target,
                                      boolean inReleaseSpeedSupervision,
                                      double curReleaseSpeed,
                                      double releaseDistance) {
        super(source, target);
        this.inRSM = inReleaseSpeedSupervision;
        this.curReleaseSpeed = curReleaseSpeed;
        this.releaseDistance = releaseDistance;
    }
}
