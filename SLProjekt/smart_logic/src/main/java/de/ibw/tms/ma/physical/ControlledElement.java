package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.physical.intf.IControlledElementStatus;

public class ControlledElement extends LocatedNetEntity {
    private IControlledElementStatus status;
    private String label;

    public ControlledElement(String sName) {
        super(sName);
    }

    public IControlledElementStatus getStatus() {
        return status;
    }

    public void setStatus(IControlledElementStatus status) {
        status = status;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
