package de.ibw.tms.ma;

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
public class GradientSegment extends LinearLocation implements Serializable {
    private ETCS_GRADIENT g_A; // 0 - 254%o // 25,4% maximum
    private boolean q_GDIR; // 0: downhill 1: uphill
    private int iBeginMeter;
    private int iEndMeter;

    public int getiBeginMeter() {
        return iBeginMeter;
    }

    public int getiEndMeter() {
        return iEndMeter;
    }

    @JsonIgnore
    private List<GradientProfile> profileList = new ArrayList<GradientProfile>();


    public GradientSegment(de.ibw.tms.ma.location.SpotLocation begin, de.ibw.tms.ma.location.SpotLocation end, ApplicationDirection direction) {
        super(begin, end, direction);
        this.iBeginMeter = begin.getChainage().getiMeters();
        this.iEndMeter = end.getChainage().getiMeters();
    }

    public void setGradient(ETCS_GRADIENT G, boolean isUphill) {
        this.g_A = G;
        this.q_GDIR = isUphill;

    }

    public ETCS_GRADIENT getG_A() {
        return g_A;
    }

    public boolean isQ_GDIR() {
        return q_GDIR;
    }

    @Override
    public void setBegin(de.ibw.tms.ma.location.SpotLocation begin) {
        super.setBegin(begin);
        this.iBeginMeter = begin.getChainage().getiMeters();
    }

    @Override
    public void setEnd(SpotLocation end) {
        super.setEnd(end);
        this.iEndMeter = end.getChainage().getiMeters();
    }

    public void addToProfile(GradientProfile GP) {
        if(!this.profileList.contains(GP)) {
            this.profileList.add(GP);
            GP.addSegment(this);
        }
    }

}
