package de.ibw.tms.ma.positioning;

import de.ibw.rtm.intf.IRTMIntrinsicCoordinate;
import de.ibw.rtm.intf.IRTMPositioningSystemCoordinate;
import de.ibw.tms.ma.common.DefaultObject;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.RTMGeometricCoordinate;
import org.railMl.rtm4rail.RTMLinearCoordinate;

import java.util.ArrayList;
import java.util.List;

public class IntrinsicCoordinate extends DefaultObject implements IRTMIntrinsicCoordinate {
    public static String CLASS_IDENTIFIER = "Intrinsic_Coordnate";

    /**
     * Prozentuale Position auf der Kante als Wert zwischen 0 und 1.
     */
    private double intrinsicCoord;
    private List<IRTMPositioningSystemCoordinate> coordinates = new ArrayList<>();

    public IntrinsicCoordinate() {
        super(CLASS_IDENTIFIER);
    }

    @Override
    public List<RTMLinearCoordinate> getLinearCoordinate() {
        return null;
    }

    @Override
    public List<RTMGeometricCoordinate> getGeometricCoordinate() {
        return null;
    }

    @Override
    public double getIntrinsicCoord() {
        return intrinsicCoord;
    }

    @Override
    public void setIntrinsicCoord(double value) {
        this.intrinsicCoord = value;
    }

    @Override
    public String getId() {
        return this.getUuid().toString();
    }

    @Override
    public void setId(String value) {

        throw new NotImplementedException("Id is unique set once");
    }
}
