package de.ibw.tms.etcs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class ETCS_TIMER implements Serializable {
    @Expose
    public short sTimer;

    @Override
    public String toString() {
        return "ETCS_TIMER{" +
                "sTimer=" + sTimer +
                '}';
    }
}
