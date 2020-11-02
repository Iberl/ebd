package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.etcs.ETCS_TIMER;
import de.ibw.tms.etcs.Q_SCALE;

import java.io.Serializable;
@JsonIgnoreProperties(value = {
        "eoa"

})
public class Overlap implements Serializable {
    private EoA eoa;
    private SvL svl;

    @Override
    public String toString() {
        return "Overlap{" +
                "q_OL=" + q_OL +
                ", d_OL=" + d_OL +
                ", t_OL=" + t_OL +
                ", q_STARTOL=" + q_STARTOL +
                ", d_STARTOL=" + d_STARTOL +
                ", v_RELEASEOL=" + v_RELEASEOL +
                '}';
    }

    @Expose
    public Q_SCALE q_OL;
    @Expose
    public ETCS_DISTANCE d_OL;
    @Expose
    public ETCS_TIMER t_OL;
    @Expose
    public Q_SCALE q_STARTOL;
    @Expose
    public ETCS_DISTANCE d_STARTOL;
    @Expose
    public ETCS_SPEED v_RELEASEOL;

    public SvL getSvl() {
        return svl;
    }

    public void setSvl(SvL svl) {
        this.svl = svl;
    }
}
