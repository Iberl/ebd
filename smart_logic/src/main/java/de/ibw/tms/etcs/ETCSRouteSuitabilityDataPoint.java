package de.ibw.tms.etcs;

import de.ibw.tms.ma.RouteSuitabilityData;

public class ETCSRouteSuitabilityDataPoint {
    private ETCS_DISTANCE d_suitability;
    private Q_SUITABILITY q_suitability;

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

    public RouteSuitabilityData getDataStores() {
        return dataStores;
    }

    public void setDataStores(RouteSuitabilityData dataStores) {
        this.dataStores = dataStores;
    }

    private RouteSuitabilityData dataStores;



}
