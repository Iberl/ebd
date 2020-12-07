package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.rbc_tms.util.EOA;

public class EoaSectionAdapter extends EOA.Section {
    @Expose
    public int l_section;
    @Expose
    public boolean q_sectiontimer;
    @Expose
    public Integer t_sectiontimer;
    @Expose
    public Integer d_sectiontimerstoploc;

    public EoaSectionAdapter(EOA.Section s) {
        super(s.l_section, s.q_sectiontimer, s.t_sectiontimer, s.d_sectiontimerstoploc);
        this.l_section = s.l_section;
        this.q_sectiontimer = s.q_sectiontimer;
        this.t_sectiontimer = s.t_sectiontimer;
        this.d_sectiontimerstoploc = s.d_sectiontimerstoploc;
    }

    @Override
    public String toString() {
        return "EoaSectionAdapter{" +
                "l_section=" + l_section +
                ", q_sectiontimer=" + q_sectiontimer +
                ", t_sectiontimer=" + t_sectiontimer +
                ", d_sectiontimerstoploc=" + d_sectiontimerstoploc +
                '}';
    }

    public EOA.Section convert() {
        return new EOA.Section(this.l_section, this.q_sectiontimer, this.t_sectiontimer, this.d_sectiontimerstoploc);
    }
}
