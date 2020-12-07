package de.ibw.tms.ma.positioned.elements;

import java.util.List;

public class AllocationSectionGroup extends LinearContiguousTrackArea {
    public static final String CLASS_IDENTIFIER = "Allocation_Section_Group";

    private List<AllocationSection> allocationSections;

    public AllocationSectionGroup() {
        super(CLASS_IDENTIFIER);
    }

    public List<AllocationSection> getAllocationSections() {
        return allocationSections;
    }

    public void setAllocationSections(List<AllocationSection> allocationSections) {
        this.allocationSections = allocationSections;
    }
}
