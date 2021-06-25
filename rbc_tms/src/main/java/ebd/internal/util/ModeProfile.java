package ebd.internal.util;

import ebd.internal.util.annotations.CanBeNull;
import ebd.internal.util.annotations.MinOneElem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Mode Profile Used In Movement Authorities
 *
 * @author Christopher Bernjus
 */
public class ModeProfile {

    /** Subclass For Handling Modes */
    public static class Mode {

        /** {@link ETCSVariables#D_MAMODE} */
        public int d_mamode;

        /** {@link ETCSVariables#M_MAMODE} */
        public int m_mamode;

        /** {@link ETCSVariables#V_MAMODE} */
        public int v_mamode;

        /** {@link ETCSVariables#L_MAMODE} */
        public int l_mamode;

        /** {@link ETCSVariables#L_ACKMAMODE} */
        public int l_ackmamode;

        /** {@link ETCSVariables#Q_MAMODE} */
        public boolean q_mamode;


        // Constructor

        /**
         * Constructs A {@link Mode} Object
         *
         * @param d_mamode {@link Mode#d_mamode}
         * @param m_mamode {@link Mode#m_mamode}
         * @param v_mamode {@link Mode#v_mamode}
         * @param l_mamode {@link Mode#l_mamode}
         * @param l_ackmamode {@link Mode#l_ackmamode}
         * @param q_mamode {@link Mode#q_mamode}
         *
         * @author Christopher Bernjus
         */
        public Mode(int d_mamode, int m_mamode, int v_mamode, int l_mamode, int l_ackmamode, boolean q_mamode) {
            this.d_mamode = d_mamode;
            this.m_mamode = m_mamode;
            this.v_mamode = v_mamode;
            this.l_mamode = l_mamode;
            this.l_ackmamode = l_ackmamode;
            this.q_mamode = q_mamode;
        }


        // Functions

        @Override
        public String toString() {
            return "Mode{" + "d_mamode=" + d_mamode + ", m_mamode=" + m_mamode + ", v_mamode=" + v_mamode + ", l_mamode=" + l_mamode +
                   ", l_ackmammode=" + l_ackmamode + ", q_mamode=" + q_mamode + '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Mode mode = (Mode) o;
            return d_mamode == mode.d_mamode && m_mamode == mode.m_mamode && v_mamode == mode.v_mamode && l_mamode == mode.l_mamode &&
                   l_ackmamode == mode.l_ackmamode && q_mamode == mode.q_mamode;
        }

        @Override
        public int hashCode() {
            return Objects.hash(d_mamode, m_mamode, v_mamode, l_mamode, l_ackmamode, q_mamode);
        }

    }


    // Mode Profile

    /** {@link ETCSVariables#Q_SCALE} */
    @CanBeNull
    public Integer q_dir;

    /** {@link ETCSVariables#Q_SCALE} */
    @CanBeNull
    public Integer q_scale;

    /** List Of {@link Mode}s */
    @MinOneElem
    public List<Mode> modes = new ArrayList<>();


    // Constructors

    /**
     * Constructs A {@link ModeProfile} Object With Empty List
     *
     * @param q_dir {@link ModeProfile#q_dir}
     * @param q_scale {@link ModeProfile#q_scale}
     *
     * @author Christopher Bernjus
     */
    public ModeProfile(Integer q_dir, Integer q_scale) {
        this.q_dir = q_dir;
        this.q_scale = q_scale;
    }

    /**
     * Constructs A {@link ModeProfile} Object With Given List
     *
     * @param q_dir {@link ModeProfile#q_dir}
     * @param q_scale {@link ModeProfile#q_scale}
     * @param modes List Of {@link Mode}s
     *
     * @author Christopher Bernjus
     */
    public ModeProfile(Integer q_dir, Integer q_scale, List<Mode> modes) {
        this.q_dir = q_dir;
        this.q_scale = q_scale;
        this.modes = modes;
    }


    // Functions

    @Override
    public String toString() {
        return "ModeProfile{" + "q_dir=" + (q_scale == null ? "null" : q_dir) + ", q_scale=" + (q_scale == null ? "null" : q_scale) + ", modes=" + modes.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ModeProfile that = (ModeProfile) o;
        return Objects.equals(q_dir, that.q_dir) && Objects.equals(q_scale, that.q_scale) && modes.equals(that.modes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(q_dir, q_scale, modes);
    }

}
