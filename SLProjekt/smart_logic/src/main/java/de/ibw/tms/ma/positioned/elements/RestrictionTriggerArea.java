package de.ibw.tms.ma.positioned.elements;

import java.util.List;

public class RestrictionTriggerArea extends TrackArea {
    public static final String CLASS_IDENTIFIER = "Restriction_Trigger_Area";

    private List<RestrictedArea> restrictedAreaList;
    private List<DangerArea> dangerZoneToBeCreated;
    private boolean removeCreatedArea;
    public RestrictionTriggerArea() {
        super(CLASS_IDENTIFIER);
    }

    public List<RestrictedArea> getRestrictedAreaList() {
        return restrictedAreaList;
    }

    public void setRestrictedAreaList(List<RestrictedArea> restrictedAreaList) {
        this.restrictedAreaList = restrictedAreaList;
    }

    public List<DangerArea> getDangerZoneToBeCreated() {
        return dangerZoneToBeCreated;
    }

    public void setDangerZoneToBeCreated(List<DangerArea> dangerZoneToBeCreated) {
        this.dangerZoneToBeCreated = dangerZoneToBeCreated;
    }

    public boolean isRemoveCreatedArea() {
        return removeCreatedArea;
    }

    public void setRemoveCreatedArea(boolean removeCreatedArea) {
        this.removeCreatedArea = removeCreatedArea;
    }
}
