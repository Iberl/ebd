package de.ibw.tms.ma;

import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.physical.TrackElement;

import java.io.Serializable;

public class SpeedChange extends SpotLocation implements Serializable {
    boolean q_FRONT;
    // anders als in specification
    // jetzt ETCS 4 Werte 2 Bits
    byte q_DIFF;

    public SpeedChange(Chainage chainage, TrackElement trackElement, SectionOfLine lineSection) {
        super(chainage, trackElement, lineSection);
        this.q_FRONT = true;
        this.q_DIFF = 0;
    }

    public boolean isQ_FRONT() {
        return q_FRONT;
    }

    public void setQ_FRONT(boolean q_FRONT) {
        this.q_FRONT = q_FRONT;
    }

    public byte getQ_DIFF() {
        return q_DIFF;
    }

    public void setQ_DIFF(byte q_DIFF) {
        this.q_DIFF = q_DIFF;
    }
}
