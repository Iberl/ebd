package ebd.rbc_tms.payload;

import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.Constants;
import ebd.rbc_tms.util.ETCSVariables;
import ebd.rbc_tms.util.MA;

import java.util.Objects;

/**
 * Payload for A {@link ebd.rbc_tms.message.Message_21}
 *
 * @author Christopher Bernjus
 */
public class Payload_21 extends Payload {

    /** {@link ETCSVariables#NID_ENGINE} */
    public int nid_engine;

    /** {@link MA} */
    public MA ma;


    // Constructor

    /**
     * Constructs A {@link Payload_21} Object
     *
     * @param nid_engine {@link ETCSVariables#NID_ENGINE}
     * @param ma {@link MA}
     *
     * @author Christopher Bernjus
     */
    public Payload_21(int nid_engine, MA ma) {
        this.nid_engine = nid_engine;
        this.ma = ma;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_21{" + "nid_engine=" + nid_engine + ", ma=" + ma.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_21 that = (Payload_21) o;
        return Objects.equals(nid_engine, that.nid_engine) && Objects.equals(ma, that.ma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_MA, nid_engine,  ma);
    }

}
