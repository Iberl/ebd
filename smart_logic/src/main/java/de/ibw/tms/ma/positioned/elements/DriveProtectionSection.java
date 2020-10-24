package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.ma.physical.MovableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;

import java.util.List;

public class DriveProtectionSection extends LinearContiguousTrackArea {
    public static final String CLASS_IDENTIFIER = "Drive_Protection_Section";

    private MovableTrackElement MoveableProtectedElement;
    private List<TrackElementStatus> requiredStatus;

    public DriveProtectionSection() {
        super(CLASS_IDENTIFIER);
    }

    public MovableTrackElement getMoveableProtectedElement() {
        return MoveableProtectedElement;
    }

    public void setMoveableProtectedElement(MovableTrackElement moveableProtectedElement) {
        MoveableProtectedElement = moveableProtectedElement;
    }

    public List<TrackElementStatus> getRequiredStatus() {
        return requiredStatus;
    }

    public void setRequiredStatus(List<TrackElementStatus> requiredStatus) {
        this.requiredStatus = requiredStatus;
    }
}
