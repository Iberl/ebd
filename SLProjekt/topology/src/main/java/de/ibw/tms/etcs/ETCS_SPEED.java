package de.ibw.tms.etcs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class ETCS_SPEED implements Serializable {
    // 5km/h * bSpeed
    @Expose
    public byte bSpeed;

    @Override
    public String toString() {
        return "ETCS_SPEED{" +
                "bSpeed=" + bSpeed +
                '}';
    }
}
