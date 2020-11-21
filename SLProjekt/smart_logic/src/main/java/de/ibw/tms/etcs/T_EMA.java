package de.ibw.tms.etcs;

import java.security.InvalidParameterException;

public class T_EMA {
    private short time;

    public short getTime() {
        return time;
    }

    public void setTime(short time) {
        if(time < 0 || time > 1023) throw new InvalidParameterException("Time must be positiv and maximum at 1023");
        this.time = time;
    }
}
