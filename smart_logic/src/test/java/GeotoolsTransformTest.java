import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.coords.UTMCoord;
import org.junit.jupiter.api.Test;

public class GeotoolsTransformTest {

    public static double degreeLatitutePerMeter = 1.0d / 111000d;
    public static double degreeLongitudePerMeter = 1.0d / 73000d;

    @Test
    void simpleTest() {

        Angle a = Angle.fromDegreesLatitude(49.2730766);
        Angle b = Angle.fromDegreesLongitude(11.4571343);
        UTMCoord neumarkt = UTMCoord.fromLatLon(a,b);
        UTMCoord rittershof = new UTMCoord(neumarkt.getLatitude(),
                neumarkt.getLongitude(), neumarkt.getZone(), neumarkt.getHemisphere(), neumarkt.getEasting() + 1000, neumarkt.getNorthing() + 3000);
        /*LatLon rittershofLat = UTMCoord.locationFromUTMCoord(rittershof.getZone(), rittershof.getHemisphere(),
                rittershof.getEasting() , rittershof.getNorthing());
        System.out.println(rittershofLat.latitude.degrees);
        System.out.println(rittershofLat.longitude.degrees);
        */
    }


}
