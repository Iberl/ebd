package de.ibw.tms.ma.physical;

public abstract class SlipConnectionPoint extends SlipConnection {
    protected String sViewName = " ";
    public void setViewName(String sName) {
        this.sViewName = sName;
    }
}
