package de.ibw.tms.ma.net.elements;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.common.UnknownChainage;
import de.ibw.tms.ma.positioning.GeometricCoordinate;
import de.ibw.tms.ma.positioning.UnknownPositioningSystemCoordinate;

public class UnknownLocatedNetEntity implements ILocatedNetEntity {
    @Override
    public GeometricCoordinate getGeoCoordinates() {
        return new UnknownPositioningSystemCoordinate();
    }

    @Override
    public void setGeoCoordinates(GeometricCoordinate geoCoordinates) {

    }

    @Override
    public Chainage getChainageBeginn() {
        return new UnknownChainage();
    }

    @Override
    public void setChainageBeginn(Chainage chainageBeginn) {

    }

    @Override
    public Chainage getChainageEnd() {
        return new UnknownChainage();
    }

    @Override
    public void setChainageEnd(Chainage chainageEnd) {

    }


}
