package de.ibw.tms.ma.common;

import de.ibw.tms.ma.Chainage;

import java.security.InvalidParameterException;

public class UnknownChainage extends Chainage {



    public UnknownChainage() {
        super(-1);
    }

    public int getiMeters() {
        throw new InvalidParameterException("Chainage is unknown.");
    }

    @Override
    public String toString() {
        return "UnknownChainage{}";
    }
}
