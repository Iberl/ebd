package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.etcs.M_CURRENT;

public class AllowedCurrentConsumptionChange extends InformationPoint {
    public static final String CLASS_IDENTIFIER = "Allowed_Current_Consumption_Change";

    private M_CURRENT m_current;

    public AllowedCurrentConsumptionChange() {
        super(CLASS_IDENTIFIER);
    }

    public M_CURRENT getM_current() {
        return m_current;
    }

    public void setM_current(M_CURRENT m_current) {
        this.m_current = m_current;
    }
}
