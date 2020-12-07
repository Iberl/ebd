package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.EntityLocation;
import de.ibw.tms.ma.GeoCoordinates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LocatedNetEntity implements Serializable {
    private Chainage chainageBeginn;
    private Chainage chainageEnd;
    private GeoCoordinates geoCoordinates;

    private EntityLocation MainLocation;
    private List<EntityLocation> locationList = new ArrayList<>();


    public GeoCoordinates getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(GeoCoordinates geoCoordinates) {
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

    public EntityLocation getMainLocation() {
        return MainLocation;
    }

    public void setMainLocation(EntityLocation mainLocation) {

        MainLocation = mainLocation;
        if(!locationList.contains(MainLocation)) {
            locationList.add(mainLocation);
        }
    }
}
