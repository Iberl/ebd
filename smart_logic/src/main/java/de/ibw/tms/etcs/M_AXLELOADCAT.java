package de.ibw.tms.etcs;

import java.security.InvalidParameterException;

public class M_AXLELOADCAT {
    byte bCategory;

    public byte getbCategory() {
        return bCategory;
    }

    public void setbCategory(byte bCategory) {
        if( bCategory < 0) throw new InvalidParameterException("Category must be between 0 - 127");
        this.bCategory = bCategory;
    }
}
