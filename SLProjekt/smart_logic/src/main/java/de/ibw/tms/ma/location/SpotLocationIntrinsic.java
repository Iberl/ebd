package de.ibw.tms.ma.location;

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
