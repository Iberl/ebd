package ebd.internal.payload;

import ebd.internal.message.Message_24;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.internal.Payload;
import ebd.internal.util.Constants;

import java.util.Objects;

/**
 * Payload for A {@link Message_24}
 *
 * @author Christopher Bernjus
 */
public class Payload_24 extends Payload {

    /** {@link ETCSVariables#NID_ENGINE} */
    public int nid_engine;

    /** {@link ETCSVariables#NID_EM} */
    public int nid_em;

    /** {@link ETCSVariables#M_ACK} */
    public boolean m_ack;

    /** {@link ETCSVariables#NID_LRBG} */
    public int nid_lrbg;


    // Constructor

    /**
     * Constructs A {@link Payload_24} Object
     *
     * @param nid_engine {@link Payload_24#nid_engine}
     * @param nid_em {@link Payload_24#nid_em}
     * @param m_ack {@link Payload_24#m_ack}
     * @param nid_lrbg {@link Payload_24#nid_lrbg}
     *
     * @author Christopher Bernjus
     */
    public Payload_24(int nid_engine, int nid_em, boolean m_ack, int nid_lrbg) {
        this.nid_engine = nid_engine;
        this.nid_em = nid_em;
        this.m_ack = m_ack;
        this.nid_lrbg = nid_lrbg;
    }


    // Functions

    @Override
    public String toString() {
        return "Payload_24{" + "nid_engine=" + nid_engine + ", nid_em=" + nid_em + ", m_ack=" + m_ack + ", nid_lrbg=" + nid_lrbg + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payload_24 that = (Payload_24) o;
        return nid_engine == that.nid_engine && nid_em == that.nid_em && m_ack == that.m_ack && nid_lrbg == that.nid_lrbg;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Constants.MSG_UNCONDITIONAL_EMERGENCY_STOP, nid_engine, nid_em, m_ack, nid_lrbg);
    }

}
