package de.ibw.tms.ma.physical;

public class RailConnector extends TrackElement {
    private String sConnectorName = "Connector";



    @Override
    public String getViewName() {
        return sConnectorName;
    }

    public RailConnector(String s) {
        this.sConnectorName = s;
    }




}
