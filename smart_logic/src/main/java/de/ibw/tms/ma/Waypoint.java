package de.ibw.tms.ma;

import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.net.elements.PositioningNetElement;

import java.io.Serializable;

public class Waypoint implements Serializable {

    private Movea TrackElement;
    private TrackElementStatus ElementStatus;

    public PositioningNetElement getTrackElement() {
        return TrackElement;
    }

    public TrackElementStatus getElementStatus() {
        return ElementStatus;
    }

    public Waypoint(PositioningNetElement trackElement, TrackElementStatus elementStatus) {
        TrackElement = trackElement;
        ElementStatus = elementStatus;
    }
}
