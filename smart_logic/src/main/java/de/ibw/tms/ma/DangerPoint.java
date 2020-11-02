package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.ma.spotsma.MASpots;

import java.io.Serializable;

/**
 * Danger Point
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-30
 */
public class DangerPoint extends MASpots implements Serializable {
    public static final String CLASS_IDENTIFIER = "Danger_Point";

    @Expose
    ETCS_DISTANCE d_OL;
    @Expose
    ETCS_SPEED v_RELEASEDP;

    public DangerPoint(ETCS_DISTANCE d_OL, ETCS_SPEED v_RELEASEDP) {
        super(CLASS_IDENTIFIER);
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
