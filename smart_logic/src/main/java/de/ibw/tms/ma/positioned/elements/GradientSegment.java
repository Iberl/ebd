package de.ibw.tms.ma.positioned.elements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.ibw.tms.etcs.ETCS_GRADIENT;
import de.ibw.tms.ma.location.LinearLocation;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.topologie.ApplicationDirection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {
        "profileList", "begin", "end"

})
public class GradientSegment extends LinearContiguousTrackArea {
    public static final String CLASS_IDENTIFIER = "Gradient_Segment";
    private ETCS_GRADIENT g_A; // 0 - 254%o // 25,4% maximum
    private boolean q_GDIR; // 0: downhill 1: uphill



    public GradientSegment() {
        super(CLASS_IDENTIFIER);
    }

    public ETCS_GRADIENT getG_A() {
        return g_A;
    }

    public void setG_A(ETCS_GRADIENT g_A) {
        this.g_A = g_A;
    }

    public boolean isQ_GDIR() {
        return q_GDIR;
    }

    public void setQ_GDIR(boolean q_GDIR) {
        this.q_GDIR = q_GDIR;
    }
}
