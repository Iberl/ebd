package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.rbc_tms.util.EOA;

public class EndTimerAdapter extends EOA.EndTimer {
    @Expose
    public int t_endtimer;
    @Expose
    public int d_endtimerstartloc;
    public EndTimerAdapter(EOA.EndTimer T) {
        super(T.t_endtimer, T.d_endtimerstartloc);
        this.t_endtimer = T.t_endtimer;
        this.d_endtimerstartloc = T.d_endtimerstartloc;
    }

    @Override
    public String toString() {
        return "EndTimerAdapter{" +
                "t_endtimer=" + t_endtimer +
                ", d_endtimerstartloc=" + d_endtimerstartloc +
                '}';
    }

    public EOA.EndTimer convert() {
        return  new EOA.EndTimer(this.t_endtimer,this.d_endtimerstartloc);
    }
}
