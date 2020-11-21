package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.positioned.elements.ControlArea;

public class ControlCenter extends LocatedNetEntity {
    public static final String CLASS_IDENTIFIER = "Control_Center";

    private ControlArea CA;

    public ControlCenter() {
        super(CLASS_IDENTIFIER);
    }

    public ControlArea getCA() {
        return CA;
    }

    public void setCA(ControlArea CA) {
        this.CA = CA;
    }
}
