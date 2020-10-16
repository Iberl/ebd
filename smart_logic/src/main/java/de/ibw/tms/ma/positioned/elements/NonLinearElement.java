package de.ibw.tms.ma.positioned.elements;

import de.ibw.rtm.intf.IRTMNonLinearNetElement;
import de.ibw.tms.ma.net.elements.PositioningNetElement;

public class NonLinearElement extends PositioningNetElement implements IRTMNonLinearNetElement {
    public static final String CLASS_IDENTIFIER = "NonLinearElement";

    public NonLinearElement() {
        super(CLASS_IDENTIFIER);
    }
}
