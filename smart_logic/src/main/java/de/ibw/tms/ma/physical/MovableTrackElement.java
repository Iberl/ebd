package de.ibw.tms.ma.physical;

import java.util.List;

public class MovableTrackElement extends ControlledElement {
    public static final String CLASS_IDENTIFIER = "Movable_Track_Element";

    private int operationTime;
    private List<TrackElementStatus> trackElementStatuses;

    public MovableTrackElement() {
        super(CLASS_IDENTIFIER);
    }

    public int getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(int operationTime) {
        this.operationTime = operationTime;
    }

    public List<TrackElementStatus> getTrackElementStatuses() {
        return trackElementStatuses;
    }

    public void setTrackElementStatuses(List<TrackElementStatus> trackElementStatuses) {
        this.trackElementStatuses = trackElementStatuses;
    }
}
