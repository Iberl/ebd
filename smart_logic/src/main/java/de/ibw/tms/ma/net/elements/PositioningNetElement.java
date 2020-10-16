package de.ibw.tms.ma.net.elements;

import de.ibw.rtm.intf.IRTMAssociatedPositioningSystem;
import de.ibw.rtm.intf.IRTMPositioningNetElement;
import org.railMl.rtm4rail.RTMAssociatedPositioningSystem;

import java.util.List;

public abstract class PositioningNetElement extends CompositedNetElement implements IRTMPositioningNetElement {

    private List<IRTMAssociatedPositioningSystem> positioningSystems;

    public PositioningNetElement(String sName) {
        super(sName);
    }

    @Override
    public List<RTMAssociatedPositioningSystem> getAssociatedPositioningSystem() {
        return null;
    }

    public List<IRTMAssociatedPositioningSystem> getPositioningSystems() {
        return positioningSystems;
    }
}
