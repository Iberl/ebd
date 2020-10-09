package de.ibw.tms.ma.physical;

public class EdgeOfMap extends TrackElement {
    String sViewName = "";

    @Override
    public String getViewName() {
        return this.sViewName;
    }

    public EdgeOfMap(String sViewName) {
        this.sViewName = sViewName;
    }
}
