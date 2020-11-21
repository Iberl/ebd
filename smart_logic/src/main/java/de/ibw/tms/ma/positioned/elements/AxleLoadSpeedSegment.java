package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.etcs.M_AXLELOADCAT;
import de.ibw.tms.etcs.Q_FRONT;
import de.ibw.tms.etcs.V_AXLELOAD;
import de.ibw.tms.ma.AxleLoadSpeedProfile;

import java.util.List;

public class AxleLoadSpeedSegment extends LinearContiguousTrackArea {
    public static final String CLASS_IDENTIFIER = "Axle_Load_Speed_Segment";

    private Q_FRONT q_front;
    private M_AXLELOADCAT m_axleloadcat;
    private V_AXLELOAD v_axleload;
    private AxleLoadSpeedChange LoadChangeA;
    private AxleLoadSpeedChange LoadChangeB;
    private List<AxleLoadSpeedProfile> profileList;


    public AxleLoadSpeedSegment() {
        super(CLASS_IDENTIFIER);
    }

    public Q_FRONT getQ_front() {
        return q_front;
    }

    public void setQ_front(Q_FRONT q_front) {
        this.q_front = q_front;
    }

    public M_AXLELOADCAT getM_axleloadcat() {
        return m_axleloadcat;
    }

    public void setM_axleloadcat(M_AXLELOADCAT m_axleloadcat) {
        this.m_axleloadcat = m_axleloadcat;
    }

    public V_AXLELOAD getV_axleload() {
        return v_axleload;
    }

    public void setV_axleload(V_AXLELOAD v_axleload) {
        this.v_axleload = v_axleload;
    }

    public AxleLoadSpeedChange getLoadChangeA() {
        return LoadChangeA;
    }

    public void setLoadChangeA(AxleLoadSpeedChange loadChangeA) {
        LoadChangeA = loadChangeA;
    }

    public AxleLoadSpeedChange getLoadChangeB() {
        return LoadChangeB;
    }

    public void setLoadChangeB(AxleLoadSpeedChange loadChangeB) {
        LoadChangeB = loadChangeB;
    }

    public List<AxleLoadSpeedProfile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<AxleLoadSpeedProfile> profileList) {
        this.profileList = profileList;
    }
}
