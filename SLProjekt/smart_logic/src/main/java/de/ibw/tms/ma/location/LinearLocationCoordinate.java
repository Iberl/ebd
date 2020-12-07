package de.ibw.tms.ma.location;

import de.ibw.tms.ma.positioning.PositioningSystemCoordinate;
import org.railMl.rtm4rail.TApplicationDirection;

public class LinearLocationCoordinate extends LinearLocation {
    public static final String CLASS_IDENTIFIER = "Linear_Location_Coordinate";

    private PositioningSystemCoordinate positioningSystemCoordinates;

    public LinearLocationCoordinate() {
        super(CLASS_IDENTIFIER);
    }

    public PositioningSystemCoordinate getPositioningSystemCoordinates() {
        return positioningSystemCoordinates;
    }

    public void setPositioningSystemCoordinates(PositioningSystemCoordinate positioningSystemCoordinates) {
        this.positioningSystemCoordinates = positioningSystemCoordinates;
    }
}
