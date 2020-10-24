package de.ibw.tms.ma.location;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.SectionOfLine;
import de.ibw.tms.ma.physical.TrackElement;

public class SpotLocationIntrinsic extends SpotLocation {
    public static final String CLASS_IDENTIFIER = "Spot_Location_Intrinsic";



    public SpotLocationIntrinsic() {
        super(CLASS_IDENTIFIER);
    }

    @Override
    public Double getIntrinsicCoord() {
        return intrinsicCoord;
    }

    public void setIntrinsicCoord(double intrinsicCoord) {
        this.intrinsicCoord = intrinsicCoord;
    }
}
