package ebd.rbc_tms.payload;

import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.Constants;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * Payload for A {@link ebd.rbc_tms.message.Message_23}
 *
 * @author Christopher Bernjus
 */
public class Payload_23 extends Payload {

    /** {@link ETCSVariables#NID_ENGINE} */
    public int nid_engine;

    /** {@link ETCSVariables#NID_EM} */
    public int nid_em;

    /** {@link ETCSVariables#M_ACK} */
    public boolean m_ack;

    /** {@link ETCSVariables#NID_LRBG} */
    public int nid_lrbg;

    /** {@link ETCSVariables#Q_DIR} */
    public int q_dir;

    /** {@link ETCSVariables#Q_SCALE} */
    public int q_scale;

    /** {@link ETCSVariables#D_REF} */
    public int d_ref;

    /** {@link ETCSVariables#D_EMERGENCYSTOP} */
    public int d_emergencystop;


    // Constructor

    /**
     * Constructs A {@link Payload_23} Object
     *
     * @param nid_engine {@link Payload_23#nid_engine}
     * @param nid_em {@link Payload_23#nid_em}
     * @param m_ack {@link Payload_23#m_ack}
     * @param nid_lrbg {@link Payload_23#nid_lrbg}
     * @param q_dir {@link Payload_23#q_dir}
     * @param q_scale {@link Payload_23#q_scale}
     * @param d_ref {@link Payload_23#d_ref}
     * @param d_emergencystop {@link Payload_23#d_emergencystop}
     *
     * @author Christopher Bernjus
     */
    public Payload_23(int nid_engine, int nid_em, boolean m_ack, int nid_lrbg, int q_dir, int q_scale, int d_ref, int d_emergencystop) {
        this.nid_engine = nid_engine;
        this.nid_em = nid_em;
        this.m_ack = m_ack;
        this.nid_lrbg = nid_lrbg;
        this.q_dir = q_dir;
        this.q_scale = q_scale;
        this.d_ref = d_ref;
        this.d_emergencystop = d_emergencystop;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_23{" + "nid_engine=" + nid_engine + ", nid_em=" + nid_em + ", m_ack=" + m_ack + ", nid_lrbg=" + nid_lrbg + ", q_dir=" +
               q_dir + ", q_scale=" + q_scale + ", d_ref=" + d_ref + ", d_emergencystop=" + d_emergencystop + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_23 that = (Payload_23) o;
        return nid_engine == that.nid_engine && nid_em == that.nid_em && m_ack == that.m_ack && nid_lrbg == that.nid_lrbg && q_dir == that.q_dir &&
               q_scale == that.q_scale && d_ref == that.d_ref && d_emergencystop == that.d_emergencystop;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_CONDITIONAL_EMERGENCY_STOP, nid_engine, nid_em, m_ack, nid_lrbg, q_dir, q_scale, d_ref, d_emergencystop);
    }

}
