package de.ibw.tms.ma.location;

public class OrderedAssociatedNetElement extends AssociatedNetElement {
    private Integer sequence;

    @Override
    public Integer getSequence() {
        return sequence;
    }

    @Override
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
