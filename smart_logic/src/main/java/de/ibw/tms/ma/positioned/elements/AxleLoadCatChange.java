package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.etcs.M_AXLELOADCAT;

public class AxleLoadCatChange extends ETCSRouteSuitabilityDataPoint {
    public static final String CLASS_IDENTIFIER = "Axle_Load_Cat_Change";

    private M_AXLELOADCAT m_axleloadcat;

    public AxleLoadCatChange() {
        super(CLASS_IDENTIFIER);
    }

    public M_AXLELOADCAT getM_axleloadcat() {
        return m_axleloadcat;
    }

    public void setM_axleloadcat(M_AXLELOADCAT m_axleloadcat) {
        this.m_axleloadcat = m_axleloadcat;
    }
}
