package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.etcs.M_VOLTAGE;
import de.ibw.tms.etcs.NID_CTRACTION;

public class VoltageChange extends ETCSRouteSuitabilityDataPoint {
    public static final String CLASS_IDENTIFIER = "Voltage_Change";

    private M_VOLTAGE m_voltage;
    private NID_CTRACTION nid_ctraction;

    public VoltageChange() {
        super(CLASS_IDENTIFIER);

    }

    public M_VOLTAGE getM_voltage() {
        return m_voltage;
    }

    public void setM_voltage(M_VOLTAGE m_voltage) {
        this.m_voltage = m_voltage;
    }

    public NID_CTRACTION getNid_ctraction() {
        return nid_ctraction;
    }

    public void setNid_ctraction(NID_CTRACTION nid_ctraction) {
        this.nid_ctraction = nid_ctraction;
    }
}
