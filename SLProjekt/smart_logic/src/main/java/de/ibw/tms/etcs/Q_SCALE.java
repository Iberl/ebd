package de.ibw.tms.etcs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.security.InvalidParameterException;

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

    public static Q_SCALE getScale(int i) {
        if(i == 0) return SCALE_10_CM;
        if(i == 1) return SCALE_1_M;
        if(i == 2) return SCALE_10_M;
        if(i == 3) return SPARE;
        throw new InvalidParameterException("i must be between inclosed 0-3");
    }

}
