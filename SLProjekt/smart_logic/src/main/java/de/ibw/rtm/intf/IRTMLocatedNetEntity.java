package de.ibw.rtm.intf;

import org.railMl.rtm4rail.RTMAreaLocation;
import org.railMl.rtm4rail.RTMLinearLocation;
import org.railMl.rtm4rail.RTMSpotLocation;

import java.util.List;

public interface IRTMLocatedNetEntity extends IRTMBaseObject, IRTMNetworkResource {
    List<RTMAreaLocation> getAreaLocation();

    List<RTMLinearLocation> getLinearLocation();

    List<RTMSpotLocation> getSpotLocation();
}
