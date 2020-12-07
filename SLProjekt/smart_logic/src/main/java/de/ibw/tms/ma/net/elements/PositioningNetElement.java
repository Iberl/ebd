package de.ibw.tms.ma.net.elements;

import de.ibw.rtm.intf.IRTMAssociatedPositioningSystem;
import de.ibw.rtm.intf.IRTMPositioningNetElement;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.RTMAssociatedPositioningSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class PositioningNetElement extends CompositedNetElement implements IRTMPositioningNetElement {

    private List<IRTMAssociatedPositioningSystem> positioningSystems;

    public PositioningNetElement(String sName) {
        super(sName);
        this.positioningSystems = new ArrayList<>();

    }

    @Override
    public List<RTMAssociatedPositioningSystem> getAssociatedPositioningSystem() {
        throw new NotImplementedException("Converter needed");
    }

    public List<IRTMAssociatedPositioningSystem> getPositioningSystems() {
        return positioningSystems;
    }
}
