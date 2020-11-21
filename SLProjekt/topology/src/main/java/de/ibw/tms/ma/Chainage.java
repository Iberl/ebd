package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Chainage implements Serializable {
    @Override
    public String toString() {
        return "Chainage{" +
                "iMeters=" + iMeters +
                '}';
    }

    @Expose
    public  int iMeters = 0;

    public Chainage(int iMeters) {
        this.iMeters = iMeters;
    }
    public int getiMeters() {
        return iMeters;
    }

}
