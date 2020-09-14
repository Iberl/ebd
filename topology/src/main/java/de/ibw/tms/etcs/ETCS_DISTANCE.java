package de.ibw.tms.etcs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class ETCS_DISTANCE implements Serializable {
    @Expose
    public short sDistance;

    @Override
    public String toString() {
        return "ETCS_DISTANCE{" +
                "sDistance=" + sDistance +
                '}';
    }
}
