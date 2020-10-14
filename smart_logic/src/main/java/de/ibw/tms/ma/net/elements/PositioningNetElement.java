package de.ibw.tms.ma.net.elements;

import de.ibw.rtm.intf.IRTMPositioningNetElement;
import org.railMl.rtm4rail.RTMAssociatedPositioningSystem;

import java.util.List;

public class PositioningNetElement extends CompositedNetElement implements IRTMPositioningNetElement {
    @Override
    public List<RTMAssociatedPositioningSystem> getAssociatedPositioningSystem() {
        return null;
    }
}
