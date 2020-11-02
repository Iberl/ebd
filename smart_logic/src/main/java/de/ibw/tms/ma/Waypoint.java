package de.ibw.tms.ma;

import de.ibw.tms.ma.physical.MovableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.net.elements.PositioningNetElement;
import de.ibw.tms.ma.positioned.elements.SpotElement;

import java.io.Serializable;
import java.util.List;

public class Waypoint extends SpotElement implements Serializable {
    public static final String CLASS_IDENTIFIER = "Waypoint";


    private MovableTrackElement TrackElement;
    private List<TrackElementStatus> ElementStatus;

    public MovableTrackElement getTrackElement() {
        return TrackElement;
    }

    public List<TrackElementStatus> getElementStatus() {
        return ElementStatus;
    }

    public Waypoint(MovableTrackElement trackElement, List<TrackElementStatus> elementStatus) {
        super(CLASS_IDENTIFIER);
        TrackElement = trackElement;
        ElementStatus = elementStatus;
    }
}
