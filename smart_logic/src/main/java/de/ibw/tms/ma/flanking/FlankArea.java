package de.ibw.tms.ma.flanking;

import de.ibw.tms.ma.flanking.intf.IStaticFPD;
import de.ibw.tms.ma.positioned.elements.TrackArea;

import java.util.List;

public class FlankArea extends TrackArea {
    public static final String CLASS_IDENTIFIER = "Flank_Area";

    private List<IStaticFPD> staticFPDs;

    protected FlankArea(String sName) {
        super(sName);
    }

    public FlankArea() {
        super(CLASS_IDENTIFIER);
    }
}
