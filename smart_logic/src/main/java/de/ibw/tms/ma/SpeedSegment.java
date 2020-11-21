package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.etcs.NC_CDDIFF;
import de.ibw.tms.etcs.NC_DIFF;
import de.ibw.tms.ma.location.LinearLocation;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.positioned.elements.LinearContiguousTrackArea;
import de.ibw.tms.ma.topologie.ApplicationDirection;

import java.io.Serializable;
@JsonIgnoreProperties(value = {
        "ssp"
})
public class SpeedSegment extends LinearContiguousTrackArea implements Serializable {
    public static final String CLASS_IDENTIFIER = "Speed_Segment";
    private SSP ssp;
    //vorerst true
    @Expose
    private SpotLocation speedChangeBegin;
    @Expose
    private SpotLocation speedChangeEnd;
    @Expose
    private ApplicationDirection direction;
    @Expose
    private ETCS_SPEED v_STATIC;
    // vorerst null
    @Expose
    private NC_CDDIFF nc_CDDIFF;
    @Expose
    private NC_DIFF nc_DIFF;


    private SpeedChange ChangeA;
    private SpeedChange ChangeB;


    public SpeedSegment(de.ibw.tms.ma.location.SpotLocation begin, de.ibw.tms.ma.location.SpotLocation end, ApplicationDirection direction) {
        super(CLASS_IDENTIFIER);

        this.direction = direction;

    }





    public SSP getSsp() {
        return ssp;
    }

    public void setSsp(SSP ssp) {
        this.ssp = ssp;
    }

    public ETCS_SPEED getV_STATIC() {
        return v_STATIC;
    }

    public void setV_STATIC(ETCS_SPEED v_STATIC) {
        this.v_STATIC = v_STATIC;
    }

    public NC_CDDIFF getNc_CDDIFF() {
        return nc_CDDIFF;
    }

    public void setNc_CDDIFF(NC_CDDIFF nc_CDDIFF) {
        this.nc_CDDIFF = nc_CDDIFF;
    }

    public NC_DIFF getNc_DIFF() {
        return nc_DIFF;
    }

    public void setNc_DIFF(NC_DIFF nc_DIFF) {
        this.nc_DIFF = nc_DIFF;
    }


    public ApplicationDirection getDirection() {
        return direction;
    }

    public void setDirection(ApplicationDirection direction) {
        this.direction = direction;
    }

    public SpeedChange getChangeA() {
        return ChangeA;
    }

    public void setChangeA(SpeedChange changeA) {
        ChangeA = changeA;
        this.speedChangeBegin = ChangeA.getIntrinsicCoord();
    }

    public SpeedChange getChangeB() {
        return ChangeB;

    }

    public void setChangeB(SpeedChange changeB) {
        ChangeB = changeB;
        this.speedChangeEnd = ChangeB.getIntrinsicCoord();
    }

    @Override
    public String toString() {
        return "SpeedSegment{" +
                "speedChangeBegin=" + speedChangeBegin +
                ", speedChangeEnd=" + speedChangeEnd +
                ", direction=" + direction +
                ", v_STATIC=" + v_STATIC +
                ", nc_CDDIFF=" + nc_CDDIFF +
                ", nc_DIFF=" + nc_DIFF +
                '}';
    }
}
