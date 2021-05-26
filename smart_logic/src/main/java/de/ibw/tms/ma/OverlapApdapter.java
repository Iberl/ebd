package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.internal.util.EOA;

public class OverlapApdapter extends EOA.Overlap {
    @Expose
    public int d_startol;
    @Expose
    public int t_ol;
    @Expose
    public int d_ol;
    @Expose
    public int v_releaseol;

    public OverlapApdapter(EOA.Overlap o) {
        super(o.d_startol, o.t_ol, o.d_ol, o.v_releaseol);
        this.d_startol = o.d_startol;
        this.t_ol = o.t_ol;
        this.d_ol = o.d_ol;
        this.v_releaseol = o.v_releaseol;
    }

    @Override
    public String toString() {
        return "OverlapApdapter{" +
                "d_startol=" + d_startol +
                ", t_ol=" + t_ol +
                ", d_ol=" + d_ol +
                ", v_releaseol=" + v_releaseol +
                '}';
    }

    public EOA.Overlap convert() {
        return new EOA.Overlap(this.d_startol, this.t_ol, this.d_ol, this.v_releaseol);
    }
}
