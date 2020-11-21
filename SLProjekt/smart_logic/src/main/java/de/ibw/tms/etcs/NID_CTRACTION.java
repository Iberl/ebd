package de.ibw.tms.etcs;

import java.security.InvalidParameterException;

public class NID_CTRACTION {
    private short sTraction;

    public short getsTraction() {
        return sTraction;
    }

    public void setsTraction(short sTraction) {
        if(sTraction < 0 || sTraction > 1023) throw new InvalidParameterException("Only values from 0 to 1023 alowed.");
        this.sTraction = sTraction;
    }
}
