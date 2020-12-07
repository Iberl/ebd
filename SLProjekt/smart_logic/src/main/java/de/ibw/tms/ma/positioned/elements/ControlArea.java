package de.ibw.tms.ma.positioned.elements;

import java.util.ArrayList;
import java.util.List;

public class ControlArea extends ExpandedTrackAreas {
    public static final String CLASS_IDENTIFIER = "Control_Area";

    List<InterlockingSubAreas> interlockingSubAreas;
    List<SmartLogicArea> smartLogicAreas;

    public ControlArea() {
        super(CLASS_IDENTIFIER);
    }

    public List<InterlockingSubAreas> getInterlockingSubAreas() {
        return interlockingSubAreas;
    }

    public void setInterlockingSubAreas(List<InterlockingSubAreas> interlockingSubAreas) {
        this.interlockingSubAreas = interlockingSubAreas;
    }

    public List<SmartLogicArea> getSmartLogicAreas() {
        return smartLogicAreas;
    }

    public void setSmartLogicAreas(List<SmartLogicArea> smartLogicAreas) {
        this.smartLogicAreas = smartLogicAreas;
    }
}
