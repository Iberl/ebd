package de.ibw.tms.ma.positioning;

import de.ibw.rtm.intf.IRTMGeometricCoordinate;
import org.apache.commons.lang3.NotImplementedException;
import plan_pro.modell.geodaten._1_9_0.CStrecke;

import java.util.Objects;

public class GeometricCoordinate extends PositioningSystemCoordinate implements IRTMGeometricCoordinate {
    public static final String CLASS_IDENTIFIER = "Geometric_Coordinate";


    private double x;
    private double y;
    private double z;
    private Double track_meter;
    private CStrecke Track;

    public GeometricCoordinate() {
        super(CLASS_IDENTIFIER);
    }


    public double getX() {
        return x;
    }
    public float getFloatX() {
        return (float) x;

    }


    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public float getFloatY() {
        return (float) y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public Double getZ() {
        return z;
    }

    @Override
    public void setZ(Double value) {
        z = value;
    }


    public Double getTrack_meter() {
        return track_meter;
    }

    public void setTrack_meter(Double track_meter) {
        this.track_meter = track_meter;
    }

    public CStrecke getTrack() {
        return Track;
    }

    public void setTrack(CStrecke track) {
        Track = track;
    }

    /*public void addMeters(double dEastingMeters, double dNorthingMeters) {
        Angle a = Angle.fromDegreesLatitude(this.x);
        Angle b = Angle.fromDegreesLongitude(this.y);
        UTMCoord old = UTMCoord.fromLatLon(a,b);
        UTMCoord newUTM = new UTMCoord(old.getLatitude(),
                old.getLongitude(), old.getZone(), old.getHemisphere(), old.getEasting() + dEastingMeters,
                old.getNorthing() + dNorthingMeters);
        LatLon newLat = UTMCoord.locationFromUTMCoord(newUTM.getZone(), newUTM.getHemisphere(),
                newUTM.getEasting() , newUTM.getNorthing());
        this.x = newLat.latitude.degrees;
        this.y = newLat.longitude.degrees;
     }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        de.ibw.tms.ma.positioned.GeometricCoordinate that = (de.ibw.tms.ma.positioned.GeometricCoordinate) o;
        return Double.compare(that.getX(), x) == 0 &&
                Double.compare(that.getY(), y) == 0 /*&&
                Double.compare(that.height, height) == 0*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String getPositioningSystemRef() {
        return this.getId();
    }

    @Override
    public void setPositioningSystemRef(String value) {
        throw new NotImplementedException("UUID is set automatically and not setable.");
    }
}
