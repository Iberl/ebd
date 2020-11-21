package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.etcs.ETCS_SPEED;

import java.io.Serializable;

public class DangerPoint implements Serializable {
    @Expose
    ETCS_DISTANCE d_OL;
    @Expose
    ETCS_SPEED v_RELEASEDP;

    public DangerPoint(ETCS_DISTANCE d_OL, ETCS_SPEED v_RELEASEDP) {
        this.d_OL = d_OL;
        this.v_RELEASEDP = v_RELEASEDP;
    }

    @Override
    public String toString() {
        return "DangerPoint{" +
                "d_OL=" + d_OL +
                ", v_RELEASEDP=" + v_RELEASEDP +
                '}';
    }
}
