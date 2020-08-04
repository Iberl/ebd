package de.ibw.tms.plan.elements.model;

import de.ibw.tms.plan.elements.BranchingSwitch;
import de.ibw.tms.trackplan.EnumModel;

public class CrossoverEnumModel extends EnumModel {




    @Override
    public EnumField[] getEnumMappingList() {
        return new EnumField[] {
                new EnumField(BranchingSwitch.CrossoverStatus.RIGHT, "Right"),
                new EnumField(BranchingSwitch.CrossoverStatus.BUSY, "Busy"),
                new EnumField(BranchingSwitch.CrossoverStatus.LEFT, "Left"),
                new EnumField(BranchingSwitch.CrossoverStatus.UNSAFE, "Unsafe"),
                new EnumField(BranchingSwitch.CrossoverStatus.UNSAFE_LEFT, "Unsafeleft"),
                new EnumField(BranchingSwitch.CrossoverStatus.UNSAFE_RIGHT, "Unsaferight"),
        };

    }
}
