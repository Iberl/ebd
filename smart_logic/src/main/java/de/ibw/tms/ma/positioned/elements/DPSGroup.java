package de.ibw.tms.ma.positioned.elements;

import java.util.List;

public class DPSGroup extends LinearContiguousTrackArea {
    public static final String CLASS_IDENTIFIER = "DPS_Group";

    private List<DriveProtectionSection> dps;

    public DPSGroup() {
        super(CLASS_IDENTIFIER);
    }

    public List<DriveProtectionSection> getDps() {
        return dps;
    }

    public void setDps(List<DriveProtectionSection> dps) {
        this.dps = dps;
    }
}
