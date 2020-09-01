package de.ibw.tms.etcs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public enum Q_SCALE implements Serializable {
    SCALE_10_CM,
    SCALE_1_M,
    SCALE_10_M,
    SPARE;

    @Override
    public String toString() {
        return "Q_SCALE{" +
                "flag=" + flag +
                '}';
    }

    @Expose
    public final int flag;

    Q_SCALE() {
        this.flag = 1 << this.ordinal();
    }

}
