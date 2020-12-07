package de.ibw.tms.ma.physical;

import com.google.gson.annotations.Expose;

/**
 * @deprecated
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-10
 */
public abstract class ControlledTrackElement  {
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
