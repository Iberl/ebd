package de.ibw.tms.ma;

import de.ibw.tms.ma.physical.MovableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.positioned.elements.SpotElement;

import java.io.Serializable;
import java.util.List;

public class Waypoint extends SpotElement implements Serializable {
    public static final String CLASS_IDENTIFIER = "Waypoint";


    private MovableTrackElement trackElement;
    private List<TrackElementStatus> necessaryElementStatus;

    public MovableTrackElement getTrackElement() {
        return trackElement;
    }

    public List<TrackElementStatus> getNecessaryElementStatus() {
        return necessaryElementStatus;
    }

    public Waypoint(MovableTrackElement trackElement, List<TrackElementStatus> elementStatus) {
        super(CLASS_IDENTIFIER);
        this.trackElement = trackElement;
        necessaryElementStatus = elementStatus;
    }
}
