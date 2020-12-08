package de.ibw.rtm.intf;

import org.railMl.rtm4rail.RTMIntrinsicCoordinate;
import org.railMl.rtm4rail.RTMValidity;

import java.util.List;

public interface IRTMAssociatedPositioningSystem extends IRTMBaseObject {
    List<RTMIntrinsicCoordinate> getIntrinsicCoordinate();

    List<RTMValidity> getIsValid();

    String getPositioningSystemRef();

    void setPositioningSystemRef(String value);
}
