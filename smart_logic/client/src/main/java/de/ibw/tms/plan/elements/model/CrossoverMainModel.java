package de.ibw.tms.plan.elements.model;

import de.ibw.tms.plan.elements.BranchingSwitch;
/**
 * Status einer Weiche
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class CrossoverMainModel {
    /**
     * Status der Weichenlage
     */
    public BranchingSwitch.SwitchStatus SwitchStatus = BranchingSwitch.SwitchStatus.RIGHT;
    /**
     * Dauer der Umschaltzeit der Weiche beim Wechsel einer Weichenlage.
     */
    public float fLinkageTimeInMs = 1000.0f;

}
