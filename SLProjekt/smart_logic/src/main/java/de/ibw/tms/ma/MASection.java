package de.ibw.tms.ma;

import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.etcs.ETCS_LENGTH;
import de.ibw.tms.etcs.ETCS_TIMER;

public class MASection {
    private ETCS_LENGTH t_section;
    private ETCS_TIMER t_sectiontimer;
    private ETCS_DISTANCE d_sectiontimerstopploc;
    private boolean q_sectiontimer;

    public ETCS_LENGTH getT_section() {
        return t_section;
    }

    public void setT_section(ETCS_LENGTH t_section) {
        this.t_section = t_section;
    }

    public ETCS_TIMER getT_sectiontimer() {
        return t_sectiontimer;
    }

    public void setT_sectiontimer(ETCS_TIMER t_sectiontimer) {
        this.t_sectiontimer = t_sectiontimer;
    }

    public ETCS_DISTANCE getD_sectiontimerstopploc() {
        return d_sectiontimerstopploc;
    }

    public void setD_sectiontimerstopploc(ETCS_DISTANCE d_sectiontimerstopploc) {
        this.d_sectiontimerstopploc = d_sectiontimerstopploc;
    }

    public boolean isQ_sectiontimer() {
        return q_sectiontimer;
    }

    public void setQ_sectiontimer(boolean q_sectiontimer) {
        this.q_sectiontimer = q_sectiontimer;
    }
}
