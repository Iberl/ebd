package de.ibw.rtm.intf;

import org.railMl.rtm4rail.RTMAssociatedNetElement;
import org.railMl.rtm4rail.RTMGeometricCoordinate;
import org.railMl.rtm4rail.RTMLinearCoordinate;
import org.railMl.rtm4rail.TApplicationDirection;

import java.util.List;

public interface IRTMLinearLocation extends IRTMBaseObject {
    List<RTMAssociatedNetElement> getAssociatedNetElement();

    List<RTMLinearCoordinate> getLinearCoordinate();

    List<RTMGeometricCoordinate> getGeometricCoordinate();

    TApplicationDirection getApplicationDirection();

    void setApplicationDirection(TApplicationDirection value);
}
