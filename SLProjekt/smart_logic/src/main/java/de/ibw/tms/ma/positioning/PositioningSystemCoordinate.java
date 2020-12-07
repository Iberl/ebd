package de.ibw.tms.ma.positioning;

import de.ibw.rtm.intf.IRTMPositioningSystemCoordinate;

public abstract class PositioningSystemCoordinate extends PositioningSystem implements IRTMPositioningSystemCoordinate {

    public PositioningSystemCoordinate(String sName) {
        super(sName);
    }
}
