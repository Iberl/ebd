package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.rbc_tms.util.EOA;

public class DangerPointAdapter extends EOA.DangerPoint {
    @Expose
    public int d_dp;
    @Expose
    public int v_releasedp;
    public DangerPointAdapter(EOA.DangerPoint dangerPoint) {
        super(dangerPoint.d_dp, dangerPoint.d_dp);
        this.d_dp = dangerPoint.d_dp;
        this.v_releasedp = dangerPoint.v_releasedp;
    }

    @Override
    public String toString() {
        return "DangerPointAdapter{" +
                "d_dp=" + d_dp +
                ", v_releasedp=" + v_releasedp +
                '}';
    }

    public EOA.DangerPoint convert() {
        return new EOA.DangerPoint(this.d_dp, this.v_releasedp);
    }
}
