package de.ibw.tms.ma.spotsma;

import de.ibw.rtm.intf.IRTMSpotLocation;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.positioned.elements.SpotElement;

import java.security.InvalidParameterException;

public class MASpots extends SpotElement {

    public MASpots(String sName) {
        super(sName);
    }

    @Override
    public void setLocation(IRTMSpotLocation location) {
        if(!(location instanceof SpotLocationIntrinsic)) throw new InvalidParameterException("Location of MA Spots" +
                " must use intrinsic location");
        super.setLocation(location);
    }
}
