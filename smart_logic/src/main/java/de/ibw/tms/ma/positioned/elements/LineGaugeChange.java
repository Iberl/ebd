package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.etcs.M_LINEGAUGE;

public class LineGaugeChange extends ETCSRouteSuitabilityDataPoint {
    public static final String CLASS_IDENTIFIER = "Line_Gauge_Change";

    private M_LINEGAUGE m_linegauge;

    public LineGaugeChange() {
        super(CLASS_IDENTIFIER);
    }

    public M_LINEGAUGE getM_linegauge() {
        return m_linegauge;
    }

    public void setM_linegauge(M_LINEGAUGE m_linegauge) {
        this.m_linegauge = m_linegauge;
    }
}
