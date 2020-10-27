package de.ibw.tms.etcs;

import java.security.InvalidParameterException;

public class ETCS_LENGTH {
    private short sLength;

    public short getsLength() {
        return sLength;
    }

    public void setsLength(short sLength) {
        if(sLength < 0) throw new InvalidParameterException("Length must not be negative");
        this.sLength = sLength;
    }
}
