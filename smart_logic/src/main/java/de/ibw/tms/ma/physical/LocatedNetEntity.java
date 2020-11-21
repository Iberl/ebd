package de.ibw.tms.ma.physical;

import de.ibw.rtm.intf.IRTMEntityLocation;
import de.ibw.rtm.intf.IRTMGeometricCoordinate;
import de.ibw.rtm.intf.IRTMLocatedNetEntity;
import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.physical.intf.IPixelPosition;
import de.ibw.tms.ma.positioned.elements.NetEntity;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.RTMAreaLocation;
import org.railMl.rtm4rail.RTMLinearLocation;
import org.railMl.rtm4rail.RTMSpotLocation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LocatedNetEntity extends NetEntity implements IRTMLocatedNetEntity, Serializable {
    private Chainage chainageBeginn;
    private Chainage chainageEnd;
    private IRTMGeometricCoordinate geoCoordinates;
    private IPixelPosition PixelPosition;

    private List<IRTMEntityLocation> locationList = new ArrayList<>();

    public LocatedNetEntity(String sName) {
        super(sName);
    }

    public IRTMGeometricCoordinate getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(IRTMGeometricCoordinate geoCoordinates) {
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


    @Override
    public List<RTMAreaLocation> getAreaLocation() {
        throw new NotImplementedException("Converter has to be developed");
    }

    @Override
    public List<RTMLinearLocation> getLinearLocation() {
        throw new NotImplementedException("Converter has to be developed");
    }

    @Override
    public List<RTMSpotLocation> getSpotLocation() {
        throw new NotImplementedException("Converter has to be developed");
    }

    public List<IRTMEntityLocation> getLocationList() {
        return locationList;
    }


}
