package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.etcs.Q_FRONT;
import de.ibw.tms.ma.SpeedSegment;

public class SpeedChange extends InformationPoint {
    public static final String CLASS_IDENTIFIER = "Speed_Change";
    private Q_FRONT q_front;
    private boolean q_diff;

    private SpeedSegment SpeegSeg;

    public SpeedChange() {
        super(CLASS_IDENTIFIER);

    }

    public Q_FRONT getQ_front() {
        return q_front;
    }

    public void setQ_front(Q_FRONT q_front) {
        this.q_front = q_front;
    }

    public boolean isQ_diff() {
        return q_diff;
    }

    public void setQ_diff(boolean q_diff) {
        this.q_diff = q_diff;
    }

    public SpeedSegment getSpeegSeg() {
        return SpeegSeg;
    }

    public void setSpeegSeg(SpeedSegment speegSeg) {
        SpeegSeg = speegSeg;
    }
}
