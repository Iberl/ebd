package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.physical.intf.IControlledElementStatus;

import java.util.List;

public class MovableTrackElement extends ControlledElement {
    public static final String CLASS_IDENTIFIER = "Movable_Track_Element";

    public TrackElementStatus getCurrentStatus() {
        return (TrackElementStatus) super.getStatus();
    }

    public void setCurrentStatus(TrackElementStatus status) {
        super.setStatus(status);
    }

    private int operationTime;
    private List<TrackElementStatus> listOfPossibleStatus;

    private TrackElementStatus requestedStatus;

    public MovableTrackElement() {
        super(CLASS_IDENTIFIER);
    }

    public int getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(int operationTime) {
        this.operationTime = operationTime;
    }

    public List<TrackElementStatus> getListOfPossibleStatus() {
        return listOfPossibleStatus;
    }

    public void setListOfPossibleStatus(List<TrackElementStatus> listOfPossibleStatus) {
        this.listOfPossibleStatus = listOfPossibleStatus;
    }


}
