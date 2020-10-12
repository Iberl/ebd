package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.EntityLocation;
import de.ibw.tms.ma.net.elements.ILocatedNetEntity;
import de.ibw.tms.ma.positioning.GeometricCoordinate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LocatedNetEntity implements ILocatedNetEntity, Serializable {
    private Chainage chainageBeginn;
    private Chainage chainageEnd;
    private GeometricCoordinate geoCoordinates;

    private EntityLocation MainLocation;
    private List<EntityLocation> locationList = new ArrayList<>();


    public GeometricCoordinate getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(GeometricCoordinate geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
    }

    public Chainage getChainageBeginn() {
        return chainageBeginn;
    }

    public void setChainageBeginn(Chainage chainageBeginn) {
        this.chainageBeginn = chainageBeginn;
    }

    public Chainage getChainageEnd() {
        return chainageEnd;
    }

    public void setChainageEnd(Chainage chainageEnd) {
        this.chainageEnd = chainageEnd;
    }


}
