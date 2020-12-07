package de.ibw.tms.etcs;

import java.security.InvalidParameterException;

/**
 * Allowed Current consumption in 10 A
 */
public class M_CURRENT {
    private short sCurrent;

    public short getsCurrent() {
        return sCurrent;
    }

    public void setsCurrent(short sCurrent) {
        if( sCurrent < 0) throw new InvalidParameterException("Current must be between 0 - 1023");

        this.sCurrent = sCurrent;
    }
}
