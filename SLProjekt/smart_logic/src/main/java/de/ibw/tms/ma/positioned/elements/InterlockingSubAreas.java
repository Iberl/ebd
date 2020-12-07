package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.ma.physical.LocatedNetEntity;

import java.util.List;

public class InterlockingSubAreas extends ExpandedTrackAreas {
    public static final String CLASS_IDENTIFIER = "Interlocking_Sub_Areas";

    private List<LocatedNetEntity> locatedNetEntityList;
    private ControlArea ContrlArea;
    private SmartLogicArea smartLogicArea;

    public InterlockingSubAreas(String sName) {
        super(sName);
    }


    public List<LocatedNetEntity> getLocatedNetEntityList() {
        return locatedNetEntityList;
    }

    public void setLocatedNetEntityList(List<LocatedNetEntity> locatedNetEntityList) {
        this.locatedNetEntityList = locatedNetEntityList;
    }

    public ControlArea getContrlArea() {
        return ContrlArea;
    }

    public void setContrlArea(ControlArea contrlArea) {
        ContrlArea = contrlArea;
    }

    public SmartLogicArea getSmartLogicArea() {
        return smartLogicArea;
    }

    public void setSmartLogicArea(SmartLogicArea smartLogicArea) {
        this.smartLogicArea = smartLogicArea;
    }
}
