package de.ibw.rtm.intf;

import org.railMl.rtm4rail.RTMValidity;

import java.util.List;

public interface IRTMPositioningSystem extends IRTMBaseObject {
    List<RTMValidity> getIsValid();
}
