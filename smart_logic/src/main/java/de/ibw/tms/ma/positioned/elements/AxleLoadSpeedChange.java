package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.etcs.Q_FRONT;

public class AxleLoadSpeedChange extends InformationPoint {
    public static final String CLASS_IDENTIFIER = "Axle_Load_Speed_Change";
    private Q_FRONT q_front;

    private AxleLoadSpeedSegment SpeedSegment;

    public AxleLoadSpeedChange() {
        super(CLASS_IDENTIFIER);
    }

    public Q_FRONT getQ_front() {
        return q_front;
    }

    public void setQ_front(Q_FRONT q_front) {
        this.q_front = q_front;
    }

    public AxleLoadSpeedSegment getSpeedSegment() {
        return SpeedSegment;
    }

    public void setSpeedSegment(AxleLoadSpeedSegment speedSegment) {
        SpeedSegment = speedSegment;
    }
}
