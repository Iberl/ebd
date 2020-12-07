package de.ibw.tms.ma.net.elements;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.common.INetResource;
import de.ibw.tms.ma.positioning.GeometricCoordinate;

public interface ILocatedNetEntity extends INetResource {
    GeometricCoordinate getGeoCoordinates();
    void setGeoCoordinates(GeometricCoordinate geoCoordinates);
    Chainage getChainageBeginn();
    void setChainageBeginn(Chainage chainageBeginn);
    Chainage getChainageEnd();
    void setChainageEnd(Chainage chainageEnd);



}
