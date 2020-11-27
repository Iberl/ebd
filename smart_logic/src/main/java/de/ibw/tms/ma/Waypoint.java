package de.ibw.tms.ma;

import de.ibw.tms.ma.physical.MovableTrackElement;
import de.ibw.tms.ma.physical.MoveableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.positioned.elements.SpotElement;

import java.io.Serializable;
import java.util.List;

public class Waypoint extends SpotElement implements Serializable {
    public static final String CLASS_IDENTIFIER = "Waypoint";


    private MoveableTrackElement trackElement;
    private TrackElementStatus necessaryElementStatus;

    public MoveableTrackElement getTrackElement() {
        return trackElement;
    }

    public TrackElementStatus getNecessaryElementStatus() {
        return necessaryElementStatus;
    }

    public Waypoint(MoveableTrackElement trackElement, TrackElementStatus elementStatus) {
        super(CLASS_IDENTIFIER);
        this.trackElement = trackElement;
        necessaryElementStatus = elementStatus;
    }
}
