package de.ibw.tms.ma.location;

import de.ibw.tms.ma.positioning.PositioningSystemCoordinate;

public class SpotLocationCoordinate extends SpotLocation {
    public static final String CLASS_IDENTIFIER = "Spot_Location_Coordinate";

    private PositioningSystemCoordinate positioningSystemCoordinate;

    public SpotLocationCoordinate() {
        super(CLASS_IDENTIFIER);
    }


    public PositioningSystemCoordinate getPositioningSystemCoordinate() {
        return positioningSystemCoordinate;
    }

    public void setPositioningSystemCoordinate(PositioningSystemCoordinate positioningSystemCoordinate) {
        this.positioningSystemCoordinate = positioningSystemCoordinate;
    }
}
