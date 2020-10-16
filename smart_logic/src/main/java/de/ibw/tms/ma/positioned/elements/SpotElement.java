package de.ibw.tms.ma.positioned.elements;

import de.ibw.rtm.intf.IRTMSpotLocation;
import de.ibw.tms.ma.net.elements.PositioningNetElement;

public class SpotElement extends PositioningNetElement {

    private IRTMSpotLocation Location;

    public SpotElement(String sName) {
        super(sName);
    }

    public IRTMSpotLocation getLocation() {
        return Location;
    }

    public void setLocation(IRTMSpotLocation location) {
        Location = location;
    }
}
