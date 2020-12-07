package de.ibw.tms.ma.physical;

import com.google.gson.annotations.Expose;

public abstract class ControlledTrackElement extends TrackElement {
    @Expose
    TrackElementStatus Status;
    @Expose
    private int operationTime = 2;

    public int getOperationTime() {
        return operationTime;
    }

    public ControlledTrackElement(TrackElementStatus status, int operationTime) {
        Status = status;
        this.operationTime = operationTime;
    }
    public ControlledTrackElement() {

    }

    public TrackElementStatus getStatus() {
        return Status;
    }

    public void setStatus(TrackElementStatus status) {
        Status = status;
    }

    public void setOperationTime(int operationTime) {
        this.operationTime = operationTime;
    }
}
