package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.etcs.Q_SUITABILITY;

public class ETCSRouteSuitabilityDataPoint extends InformationPoint {
    public static final String CLASS_IDENTIFIER = "ETCS_Route_Suitability_Datapoint";



    private ETCS_DISTANCE d_suitability;
    private Q_SUITABILITY q_suitability;


    public ETCSRouteSuitabilityDataPoint(String sName) {
        super(sName);
    }

    public ETCS_DISTANCE getD_suitability() {
        return d_suitability;
    }

    public void setD_suitability(ETCS_DISTANCE d_suitability) {
        this.d_suitability = d_suitability;
    }

    public Q_SUITABILITY getQ_suitability() {
        return q_suitability;
    }

    public void setQ_suitability(Q_SUITABILITY q_suitability) {
        this.q_suitability = q_suitability;
    }
}
