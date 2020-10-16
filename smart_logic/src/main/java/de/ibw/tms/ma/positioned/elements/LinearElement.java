package de.ibw.tms.ma.positioned.elements;

import de.ibw.rtm.intf.IRTMLinearNetElement;
import de.ibw.tms.ma.net.elements.PositioningNetElement;

public abstract class LinearElement extends PositioningNetElement implements IRTMLinearNetElement {

    public LinearElement(String sName) {
        super(sName);
    }
}
