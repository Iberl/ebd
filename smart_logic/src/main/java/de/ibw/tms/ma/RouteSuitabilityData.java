package de.ibw.tms.ma;

import de.ibw.tms.etcs.ETCSRouteSuitabilityDataPoint;
import de.ibw.tms.etcs.ETCS_DISTANCE;

import java.util.ArrayList;

public class RouteSuitabilityData extends ArrayList<ETCSRouteSuitabilityDataPoint> {
    private boolean q_trackinit;
    private ETCS_DISTANCE d_trackinit;

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
}
