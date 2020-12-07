package de.ibw.tms.ma.positioned.elements;

public class SmartLogicArea extends ExpandedTrackAreas {
    public static final String CLASS_IDENTIFIER = "smartLogic_Area";

    private boolean blocked;

    public SmartLogicArea() {
        super(CLASS_IDENTIFIER);
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
