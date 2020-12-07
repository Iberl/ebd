package de.ibw.tms.ma.physical;

import de.ibw.datatypes.PhoneNumber;
import de.ibw.tms.ma.positioned.elements.ControlArea;

import java.util.List;

public class MaintenanceOffice extends LocatedNetEntity {
    public static final String CLASS_IDENTIFIER = "Maintenance_Office";

    private PhoneNumber phoneNumber;
    private List<ControlArea> controlAreaList;

    public MaintenanceOffice() {
        super(CLASS_IDENTIFIER);
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ControlArea> getControlAreaList() {
        return controlAreaList;
    }

    public void setControlAreaList(List<ControlArea> controlAreaList) {
        this.controlAreaList = controlAreaList;
    }
}
