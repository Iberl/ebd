package ebd.internal.util;

import java.util.Objects;

/**
 * Superclass For Multiple Different Structured MAs
 *
 * @author Christopher Bernjus
 */
public abstract class GeneralMA {

    /** {@link ETCSVariables#M_ACK} */
    public boolean m_ack;

    /** {@link ETCSVariables#NID_LRBG} */
    public int nid_lrbg;

    /** {@link ETCSVariables#Q_DIR} */
    public int q_dir;

    /** {@link ETCSVariables#Q_SCALE} */
    public int q_scale;

    /** {@link EOA} */
    public EOA eoa;


    // Constructor

    /**
     * Constructs A {@link GeneralMA} Object
     *
     * @param m_ack {@link GeneralMA#m_ack}
     * @param nid_lrbg {@link GeneralMA#nid_lrbg}
     * @param q_dir {@link GeneralMA#q_dir}
     * @param q_scale {@link GeneralMA#q_scale}
     * @param eoa {@link EOA}
     *
     * @author Christopher Bernjus
     */
    public GeneralMA(boolean m_ack, int nid_lrbg, int q_dir, int q_scale, EOA eoa) {
        this.m_ack = m_ack;
        this.nid_lrbg = nid_lrbg;
        this.q_dir = q_dir;
        this.q_scale = q_scale;
        this.eoa = eoa;
    }


    // Functions

    @Override
    public String toString() {
        return "GeneralMA{" + "m_ack=" + m_ack + ", nid_lrbg=" + nid_lrbg + ", q_dir=" + q_dir + ", q_scale=" + q_scale + ", eoa=" + eoa.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        GeneralMA generalMA = (GeneralMA) o;
        return m_ack == generalMA.m_ack && nid_lrbg == generalMA.nid_lrbg && q_dir == generalMA.q_dir && q_scale == generalMA.q_scale &&
               Objects.equals(eoa, generalMA.eoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_ack, nid_lrbg, q_dir, q_scale, eoa);
    }

}
