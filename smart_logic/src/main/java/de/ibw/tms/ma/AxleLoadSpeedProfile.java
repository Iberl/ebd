package de.ibw.tms.ma;

import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.ma.positioned.elements.AxleLoadSpeedSegment;

import java.util.List;

public class AxleLoadSpeedProfile {

    private boolean q_trackinit;
    private ETCS_DISTANCE d_trackinit;
    private List<AxleLoadSpeedSegment> segments;

    public boolean isQ_trackinit() {
        return q_trackinit;
    }

    public void setQ_trackinit(boolean q_trackinit) {
        this.q_trackinit = q_trackinit;
    }

    public ETCS_DISTANCE getD_trackinit() {
        return d_trackinit;
    }

    public void setD_trackinit(ETCS_DISTANCE d_trackinit) {
        this.d_trackinit = d_trackinit;
    }

    public List<AxleLoadSpeedSegment> getSegments() {
        return segments;
    }

    public void setSegments(List<AxleLoadSpeedSegment> segments) {
        this.segments = segments;
    }
}
