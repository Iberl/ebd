package de.ibw.rtm.intf;

import org.railMl.rtm4rail.RTMGeometricCoordinate;
import org.railMl.rtm4rail.RTMLinearCoordinate;

import java.util.List;

public interface IRTMIntrinsicCoordinate extends IRTMBaseObject {
    List<RTMLinearCoordinate> getLinearCoordinate();

    List<RTMGeometricCoordinate> getGeometricCoordinate();

    double getIntrinsicCoord();

    void setIntrinsicCoord(double value);
}
