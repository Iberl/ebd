package de.ibw.tms.etcs;

import java.security.InvalidParameterException;

/**
 * 1 =^ 5 km/h
 * 110 =^ 550 km/h
 */
public class V_AXLELOAD {
    private byte bSpeedRestriction;

    public byte getbSpeedRestriction() {
        return bSpeedRestriction;
    }

    public void setbSpeedRestriction(byte bSpeedRestriction) {
        if( bSpeedRestriction < 0) throw new InvalidParameterException("Speed-Restriction must be between 0 - 127");
        this.bSpeedRestriction = bSpeedRestriction;
    }
}
