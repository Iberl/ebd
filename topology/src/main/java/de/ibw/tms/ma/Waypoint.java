package de.ibw.tms.ma;

import de.ibw.tms.ma.physical.TrackElementStatus;

import java.io.Serializable;

public class Waypoint implements Serializable {

    private TrackElement TrackElement;
    private TrackElementStatus ElementStatus;

    public TrackElement getTrackElement() {
        return TrackElement;
    }

    public TrackElementStatus getElementStatus() {
        return ElementStatus;
    }

    public Waypoint(TrackElement trackElement, TrackElementStatus elementStatus) {
        TrackElement = trackElement;
        ElementStatus = elementStatus;
    }
}
