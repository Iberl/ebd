package de.ibw.rtm.intf;

import org.railMl.rtm4rail.RTMAssociatedNetElement;

import java.util.List;

public interface IRTMAreaLocation extends IRTMBaseObject {
    List<RTMAssociatedNetElement> getAssociatedNetElement();
}
