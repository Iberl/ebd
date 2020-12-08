package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.ma.physical.MovableTrackElement;

public class AllocationSection extends LinearContiguousTrackArea {
    public static final String CLASS_IDENTIFIER = "Allocation_Section";

    private MovableTrackElement AllocatedElement;

    public AllocationSection() {
        super(CLASS_IDENTIFIER);
    }

    public MovableTrackElement getAllocatedElement() {
        return AllocatedElement;
    }

    public void setAllocatedElement(MovableTrackElement allocatedElement) {
        AllocatedElement = allocatedElement;
    }
}
