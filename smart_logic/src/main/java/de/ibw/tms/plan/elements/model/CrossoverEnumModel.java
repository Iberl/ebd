package de.ibw.tms.plan.elements.model;

import de.ibw.tms.plan.elements.BranchingSwitch;
import de.ibw.tms.trackplan.EnumModel;
/**
 * Dieses Enum beschreibt die Lage einer Weiche mit deren Zungen
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class CrossoverEnumModel extends EnumModel {


    /**
     * Inhalte dieses EnumModels
     * @return EnumField[] - mögliche Status einer Weiche
     */

    @Override
    public EnumField[] getEnumMappingList() {
        return new EnumField[] {
                new EnumField(BranchingSwitch.SwitchStatus.RIGHT, "Right"),
                new EnumField(BranchingSwitch.SwitchStatus.BUSY, "Busy"),
                new EnumField(BranchingSwitch.SwitchStatus.LEFT, "Left"),
                new EnumField(BranchingSwitch.SwitchStatus.UNSAFE, "Unsafe"),
                new EnumField(BranchingSwitch.SwitchStatus.UNSAFE_LEFT, "Unsafeleft"),
                new EnumField(BranchingSwitch.SwitchStatus.UNSAFE_RIGHT, "Unsaferight"),
        };

    }
}
