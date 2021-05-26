package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.internal.util.ModeProfile;

public class SingleModeAdapter extends ModeProfile.Mode {
    @Expose
    public int d_mamode;
    @Expose
    public int m_mamode;
    @Expose
    public int v_mamode;
    @Expose
    public int l_mamode;
    @Expose
    public int l_ackmamode;
    @Expose
    public boolean q_mamode;


    public SingleModeAdapter(ModeProfile.Mode m) {
        super(m.d_mamode,m.m_mamode,m.v_mamode,m.l_mamode,m.l_ackmamode,m.q_mamode);
        this.d_mamode = m.d_mamode;
        this.m_mamode = m.m_mamode;
        this.v_mamode = m.v_mamode;
        this.l_mamode = m.l_mamode;
        this.l_ackmamode = m.l_ackmamode;
        this.q_mamode = m.q_mamode;
    }

    @Override
    public String toString() {
        return "SingleModeAdapter{" +
                "d_mamode=" + d_mamode +
                ", m_mamode=" + m_mamode +
                ", v_mamode=" + v_mamode +
                ", l_mamode=" + l_mamode +
                ", l_ackmamode=" + l_ackmamode +
                ", q_mamode=" + q_mamode +
                '}';
    }

    public ModeProfile.Mode convert() {
        return new ModeProfile.Mode(this.d_mamode, this.m_mamode, this.v_mamode,
                        this.l_mamode, this.l_ackmamode, this.q_mamode);

    }


}
