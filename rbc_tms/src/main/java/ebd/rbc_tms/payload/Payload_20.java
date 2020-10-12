package ebd.rbc_tms.payload;

import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.Constants;
import ebd.rbc_tms.util.ETCSVariables;

import java.util.Objects;

/**
 * Payload for A {@link ebd.rbc_tms.message.Message_20}
 *
 * @author Christopher Bernjus
 */
public class Payload_20 extends Payload {

    /** {@link ETCSVariables#NID_ENGINE} */
    public int nid_engine;


    // Constructor

    /**
     * Constructs A {@link Payload_20} Object
     *
     * @param nid_engine {@link Payload_20#nid_engine}
     *
     * @author Christopher Bernjus
     */
    public Payload_20(int nid_engine) {
        this.nid_engine = nid_engine;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_20{" + "nid_engine=" + nid_engine + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_20 that = (Payload_20) o;
        return nid_engine == that.nid_engine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_POSITION_REPORT_REQUEST, nid_engine);
    }

}
