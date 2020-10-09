package ebd.rbc_tms.util;

import ebd.rbc_tms.util.annotations.CanBeNull;

import java.util.Objects;

/**
 * Position Information Sent By Trains
 *
 * @author Christopher Bernjus
 */
public class PositionInfo {

    /** {@link ETCSVariables#Q_SCALE} */
    public int q_scale;

    /** {@link ETCSVariables#NID_LRBG} */
    public int nid_lrbg;

    /** {@link ETCSVariables#NID_PRVLRBG} */
    @CanBeNull
    public Integer nid_prvlrbg;

    /** {@link ETCSVariables#D_LRBG} */
    public int d_lrbg;

    /** {@link ETCSVariables#Q_DIRLRBG} */
    public int q_dirlrbg;

    /** {@link ETCSVariables#Q_DLRBG} */
    public int q_dlrbg;

    /** {@link ETCSVariables#L_DOUBTOVER} */
    public int l_doubtover;

    /** {@link ETCSVariables#L_DOUBTUNDER} */
    public int l_doubtunder;

    /** {@link ETCSVariables#Q_LENGTH} */
    public int q_length;

    /** {@link ETCSVariables#L_TRAININIT} */
    @CanBeNull
    public Integer l_trainint;

    /** {@link ETCSVariables#V_TRAIN} */
    public int v_train;

    /** {@link ETCSVariables#Q_DIRTRAIN} */
    public int q_dirtrain;

    /** {@link ETCSVariables#M_MODE} */
    public int m_mode;

    /** {@link ETCSVariables#M_LEVEL} */
    public int m_level;

    /** {@link ETCSVariables#NID_NTC} */
    @CanBeNull
    public Integer nid_ntc;


    // Constructor

    /**
     * Constructs A {@link PositionInfo} Object
     *
     * @param q_scale {@link PositionInfo#q_scale}
     * @param nid_lrbg {@link PositionInfo#nid_lrbg}
     * @param nid_prvlrbg {@link PositionInfo#nid_prvlrbg}
     * @param d_lrbg {@link PositionInfo#d_lrbg}
     * @param q_dirlrbg {@link PositionInfo#q_dirlrbg}
     * @param q_dlrbg {@link PositionInfo#d_lrbg}
     * @param l_doubtover {@link PositionInfo#l_doubtover}
     * @param l_doubtunder {@link PositionInfo#l_doubtunder}
     * @param q_length {@link PositionInfo#q_length}
     * @param l_trainint {@link PositionInfo#l_trainint}
     * @param v_train {@link PositionInfo#v_train}
     * @param q_dirtrain {@link PositionInfo#q_dirtrain}
     * @param m_mode {@link PositionInfo#m_mode}
     * @param m_level {@link PositionInfo#m_level}
     * @param nid_ntc {@link PositionInfo#nid_ntc}
     *
     * @author Christopher Bernjus
     */
    public PositionInfo(int q_scale, int nid_lrbg, Integer nid_prvlrbg, int d_lrbg, int q_dirlrbg, int q_dlrbg, int l_doubtover, int l_doubtunder,
                        int q_length, Integer l_trainint, int v_train, int q_dirtrain, int m_mode, int m_level, Integer nid_ntc) {
        this.q_scale = q_scale;
        this.nid_lrbg = nid_lrbg;
        this.nid_prvlrbg = nid_prvlrbg;
        this.d_lrbg = d_lrbg;
        this.q_dirlrbg = q_dirlrbg;
        this.q_dlrbg = q_dlrbg;
        this.l_doubtover = l_doubtover;
        this.l_doubtunder = l_doubtunder;
        this.q_length = q_length;
        this.l_trainint = l_trainint;
        this.v_train = v_train;
        this.q_dirtrain = q_dirtrain;
        this.m_mode = m_mode;
        this.m_level = m_level;
        this.nid_ntc = nid_ntc;
    }


    // Functions

    @Override
    public String toString() {
        return "PositionInfo{" + "q_scale=" + q_scale + ", nid_lrbg=" + nid_lrbg + ", nid_prvlrbg=" + (nid_prvlrbg == null ? "null" : nid_prvlrbg) + ", d_lrbg=" + d_lrbg +
               ", q_dirlrbg=" + q_dirlrbg + ", q_dlrbg=" + q_dlrbg + ", l_doubtover=" + l_doubtover + ", l_doubtunder=" + l_doubtunder +
               ", q_length=" + q_length + ", l_trainint=" + (l_trainint == null ? "null" : l_trainint) + ", v_train=" + v_train + ", q_dirtrain=" + q_dirtrain + ", m_mode=" +
               m_mode + ", m_level=" + m_level + ", nid_ntc=" + (nid_ntc == null ? "null" : nid_ntc) + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        PositionInfo that = (PositionInfo) o;
        return q_scale == that.q_scale && nid_lrbg == that.nid_lrbg && d_lrbg == that.d_lrbg && q_dirlrbg == that.q_dirlrbg &&
               q_dlrbg == that.q_dlrbg && l_doubtover == that.l_doubtover && l_doubtunder == that.l_doubtunder && q_length == that.q_length &&
               v_train == that.v_train && q_dirtrain == that.q_dirtrain && m_mode == that.m_mode && m_level == that.m_level &&
               Objects.equals(nid_prvlrbg, that.nid_prvlrbg) && Objects.equals(l_trainint, that.l_trainint) && Objects.equals(nid_ntc, that.nid_ntc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(q_scale, nid_lrbg, nid_prvlrbg, d_lrbg, q_dirlrbg, q_dlrbg, l_doubtover, l_doubtunder, q_length, l_trainint, v_train,
                            q_dirtrain, m_mode, m_level, nid_ntc);
    }

}
