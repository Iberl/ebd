package de.ibw.tms.ma.flanking;

import de.ibw.tms.ma.Waypoint;
import de.ibw.tms.ma.flanking.intf.IFlankProtectionDevice;
import de.ibw.tms.ma.physical.FlankAreaElement;

/**
 * Potentielle Flankenschutz Gefahrstellen
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-30
 */
public class PotentialFPDs {
    private int distance;
    private Waypoint origin;
    private FlankArea FlankArea;
    private IFlankProtectionDevice flankProtectionDevice;

    public PotentialFPDs(de.ibw.tms.ma.flanking.FlankArea flankArea) {
        FlankArea = flankArea;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Waypoint getOrigin() {
        return origin;
    }

    public void setOrigin(Waypoint origin) {
        this.origin = origin;
    }

    public de.ibw.tms.ma.flanking.FlankArea getFlankArea() {
        return FlankArea;
    }

    public void setFlankArea(de.ibw.tms.ma.flanking.FlankArea flankArea) {
        FlankArea = flankArea;
    }

    public IFlankProtectionDevice getFlankProtectionDevice() {
        return flankProtectionDevice;
    }

    public void setFlankProtectionDevice(IFlankProtectionDevice flankProtectionDevice) {
        this.flankProtectionDevice = flankProtectionDevice;
    }
}
