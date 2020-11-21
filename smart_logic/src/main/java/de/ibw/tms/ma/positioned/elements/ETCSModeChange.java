package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.etcs.L_ACKMAMODE;
import de.ibw.tms.etcs.L_MAMODE;
import de.ibw.tms.etcs.M_MAMODE;
import de.ibw.tms.ma.ModeChangeProfile;

import java.util.List;

public class ETCSModeChange extends InformationPoint {
    public static final String CLASS_IDENTIFIER = "ETCS_Mode_Change";

    private M_MAMODE m_mamode;
    private ETCS_SPEED v_maMode;
    private L_MAMODE l_mamode;
    private L_ACKMAMODE l_ackmamode;
    private boolean q_mamode;

    private List<ModeChangeProfile> profileList;

    public ETCSModeChange() {
        super(CLASS_IDENTIFIER);
    }

    public M_MAMODE getM_mamode() {
        return m_mamode;
    }

    public void setM_mamode(M_MAMODE m_mamode) {
        this.m_mamode = m_mamode;
    }

    public ETCS_SPEED getV_maMode() {
        return v_maMode;
    }

    public void setV_maMode(ETCS_SPEED v_maMode) {
        this.v_maMode = v_maMode;
    }

    public L_MAMODE getL_mamode() {
        return l_mamode;
    }

    public void setL_mamode(L_MAMODE l_mamode) {
        this.l_mamode = l_mamode;
    }

    public L_ACKMAMODE getL_ackmamode() {
        return l_ackmamode;
    }

    public void setL_ackmamode(L_ACKMAMODE l_ackmamode) {
        this.l_ackmamode = l_ackmamode;
    }

    public boolean isQ_mamode() {
        return q_mamode;
    }

    public void setQ_mamode(boolean q_mamode) {
        this.q_mamode = q_mamode;
    }

    public List<ModeChangeProfile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<ModeChangeProfile> profileList) {
        this.profileList = profileList;
    }
}
