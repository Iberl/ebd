package de.ibw.tms.ma.location;

import de.ibw.rtm.intf.IRTMAreaLocation;
import de.ibw.rtm.intf.IRTMAssociatedNetElement;
import de.ibw.tms.ma.net.elements.PositionedRelation;
import de.ibw.tms.ma.positioned.elements.SpotElement;
import de.ibw.tms.ma.positioning.GeometricCoordinate;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.RTMAssociatedNetElement;

import java.util.List;

public class AreaLocation extends EntityLocation implements IRTMAreaLocation {
    public static final String CLASS_IDENTIFIER = "Area_Location";


    private List<IRTMAssociatedNetElement> associatedNetElements;

    public AreaLocation() {
        super(CLASS_IDENTIFIER);

    }

    @Override
    public List<RTMAssociatedNetElement> getAssociatedNetElement() {
        throw new NotImplementedException("Converter needed");
    }

    public List<IRTMAssociatedNetElement> getAssociatedNetElements() {
        return associatedNetElements;
    }
}
