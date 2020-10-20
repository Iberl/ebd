package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.etcs.ETCS_TIMER;
import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.physical.TrackElement;

import java.io.Serializable;
@JsonIgnoreProperties(value = {
        "id",
        "firstName",
        "trackElement"
})
public class EoA extends SpotLocation implements Serializable {
    @Expose
    public int v_EMA;
    @Expose
    public boolean q_ENDTIMER;
    @Expose
    public Q_SCALE q_scale;
    @Expose
    public ETCS_DISTANCE d_ENDTIMERSTARTLOC;
    @Expose
    public ETCS_TIMER t_ENDTIMER;
    @Expose
    public boolean q_DANGERPOINT;
    @Expose
    public DangerPoint dangerPoint;
    @Expose
    public boolean q_OVERLAP;
    @Expose
    public Overlap overlap;


    public EoA(Chainage chainage, TrackElement trackElement, SectionOfLine lineSection) {
        super(chainage, trackElement, lineSection);

    }

    public int getV_EMA() {
        return v_EMA;
    }

    public void setV_EMA(int v_EMA) {
        this.v_EMA = v_EMA;
    }

    public boolean isQ_ENDTIMER() {
        return q_ENDTIMER;
    }

    public void setQ_ENDTIMER(boolean q_ENDTIMER) {
        this.q_ENDTIMER = q_ENDTIMER;
    }

    public Q_SCALE getQ_scale() {
        return q_scale;
    }

    public void setQ_scale(Q_SCALE q_scale) {
        this.q_scale = q_scale;
    }

    public ETCS_DISTANCE getD_ENDTIMERSTARTLOC() {
        return d_ENDTIMERSTARTLOC;
    }

    public void setD_ENDTIMERSTARTLOC(ETCS_DISTANCE d_ENDTIMERSTARTLOC) {
        this.d_ENDTIMERSTARTLOC = d_ENDTIMERSTARTLOC;
    }

    public ETCS_TIMER getT_ENDTIMER() {
        return t_ENDTIMER;
    }

    public void setT_ENDTIMER(ETCS_TIMER t_ENDTIMER) {
        this.t_ENDTIMER = t_ENDTIMER;
    }

    public boolean isQ_DANGERPOINT() {
        return q_DANGERPOINT;
    }

    public void setQ_DANGERPOINT(boolean q_DANGERPOINT) {
        this.q_DANGERPOINT = q_DANGERPOINT;
    }

    public DangerPoint getDangerPoint() {
        return dangerPoint;
    }

    public void setDangerPoint(DangerPoint dangerPoint) {
        this.dangerPoint = dangerPoint;
    }

    public boolean isQ_OVERLAP() {
        return q_OVERLAP;
    }

    public void setQ_OVERLAP(boolean q_OVERLAP) {
        this.q_OVERLAP = q_OVERLAP;
    }

    public Overlap getOverlap() {
        return overlap;
    }

    public void setOverlap(Overlap overlap) {
        this.overlap = overlap;
    }


    @Override
    public String toString() {
        return "EoA{" +
                "v_EMA=" + v_EMA +
                ", q_ENDTIMER=" + q_ENDTIMER +
                ", q_scale=" + q_scale +
                ", d_ENDTIMERSTARTLOC=" + d_ENDTIMERSTARTLOC +
                ", t_ENDTIMER=" + t_ENDTIMER +
                ", q_DANGERPOINT=" + q_DANGERPOINT +
                ", dangerPoint=" + dangerPoint +
                ", q_OVERLAP=" + q_OVERLAP +
                ", overlap=" + overlap +
                ", chainage=" + chainage +
                '}';
    }
}
