package de.ibw.rtm.intf;

import de.ibw.rtm.intf.IRTMNetworkResource;
import org.railMl.rtm4rail.RTMAssociatedPositioningSystem;

import java.util.List;

public interface IRTMPositioningNetElement extends IRTMNetworkResource {
    List<RTMAssociatedPositioningSystem> getAssociatedPositioningSystem();
}
