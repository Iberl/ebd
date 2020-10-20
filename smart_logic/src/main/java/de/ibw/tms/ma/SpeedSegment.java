package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.etcs.NC_CDDIFF;
import de.ibw.tms.etcs.NC_DIFF;
import de.ibw.tms.ma.location.LinearLocation;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.topologie.ApplicationDirection;

import java.io.Serializable;
@JsonIgnoreProperties(value = {
        "ssp"
})
public class SpeedSegment extends LinearLocation implements Serializable {
    private SSP ssp;
    //vorerst true
    @Expose
    public de.ibw.tms.ma.location.SpotLocation speedChangeBegin;
    @Expose
    public de.ibw.tms.ma.location.SpotLocation speedChangeEnd;
    @Expose
    public ApplicationDirection direction;
    @Expose
    public ETCS_SPEED v_STATIC;
    // vorerst null
    @Expose
    public NC_CDDIFF nc_CDDIFF;
    @Expose
    public NC_DIFF nc_DIFF;

    public SpeedSegment(de.ibw.tms.ma.location.SpotLocation begin, de.ibw.tms.ma.location.SpotLocation end, ApplicationDirection direction) {
        super(begin, end, direction);
        speedChangeBegin = begin;
        speedChangeEnd = end;
        this.direction = direction;

    }

    public void setSpeedChangeBegin(de.ibw.tms.ma.location.SpotLocation speedChangeBegin) {
        this.speedChangeBegin = speedChangeBegin;
    }

    public SSP getSsp() {
        return ssp;
    }

    public void setSsp(SSP ssp) {
        this.ssp = ssp;
    }


    @Override
    public de.ibw.tms.ma.location.SpotLocation getBegin() {
        return super.getBegin();
    }

    public de.ibw.tms.ma.location.SpotLocation getSpeedChangeEnd() {
        return speedChangeEnd;
    }


    public void setSpeedChangeEnd(SpotLocation speedChangeEnd) {
        this.speedChangeEnd = speedChangeEnd;
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
