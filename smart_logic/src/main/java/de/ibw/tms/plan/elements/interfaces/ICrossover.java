package de.ibw.tms.plan.elements.interfaces;

import de.ibw.tms.plan.elements.BranchingSwitch;

public interface ICrossover extends  Iinteractable, IConnectable {
    void setfLinkageTimeInMs(float fLinkageTimeInMs);
    void setStatus(BranchingSwitch.SwitchStatus status);
}
