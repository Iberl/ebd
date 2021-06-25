package ebd.internal.util;

import ebd.messageLibrary.util.ETCSVariables;
import ebd.internal.util.annotations.CanBeNull;
import ebd.internal.util.annotations.MinOneElem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * End Of Authority Used In Movement Authorities
 *
 * @author Christopher Bernjus
 */
public class EOA {

    /** Subclass For Handling EOA Sections */
    public static class Section {

        /** {@link ETCSVariables#L_SECTION} */
        public int l_section;

        /** {@link ETCSVariables#Q_SECTIONTIMER} */
        public boolean q_sectiontimer;

        // TODO extract?

        /** {@link ETCSVariables#T_SECTIONTIMER} */
        @CanBeNull
        public Integer t_sectiontimer;

        /** {@link ETCSVariables#D_SECTIONTIMERSTOPLOC} */
        @CanBeNull
        public Integer d_sectiontimerstoploc;


        // Constructor

        /**
         * Constructs A {@link Section} Object
         *
         * @param l_section {@link Section#l_section}
         * @param q_sectiontimer {@link Section#q_sectiontimer}
         * @param t_sectiontimer {@link Section#t_sectiontimer}
         * @param d_sectiontimerstoploc {@link Section#d_sectiontimerstoploc}
         *
         * @author Christopher Bernjus
         */
        public Section(int l_section, boolean q_sectiontimer, Integer t_sectiontimer, Integer d_sectiontimerstoploc) {
            this.l_section = l_section;
            this.q_sectiontimer = q_sectiontimer;
            this.t_sectiontimer = t_sectiontimer;
            this.d_sectiontimerstoploc = d_sectiontimerstoploc;
        }


        // Functions

        @Override
        public String toString() {
            return "Section{" + "l_section=" + l_section + ", q_sectiontimer=" + q_sectiontimer + ", t_sectiontimer=" + (t_sectiontimer == null ? "null" : t_sectiontimer) +
                   ", d_sectiontimerstoploc=" + (d_sectiontimerstoploc == null ? "null" : d_sectiontimerstoploc) + '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Section section = (Section) o;
            return l_section == section.l_section && q_sectiontimer == section.q_sectiontimer &&
                   Objects.equals(t_sectiontimer, section.t_sectiontimer) && Objects.equals(d_sectiontimerstoploc, section.d_sectiontimerstoploc);
        }

        @Override
        public int hashCode() {
            return Objects.hash(l_section, q_sectiontimer, t_sectiontimer, d_sectiontimerstoploc);
        }

    }

    /** Subclass For Handling Endtimers */
    public static class EndTimer {

        /** {@link ETCSVariables#T_ENDTIMER} */
        public int t_endtimer;

        /** {@link ETCSVariables#D_ENDTIMERSTARTLOC} */
        public int d_endtimerstartloc;


        // Constructor

        /**
         * Constructs A {@link EndTimer} Object
         *
         * @param t_endtimer {@link EndTimer#t_endtimer}
         * @param d_endtimerstartloc {@link EndTimer#d_endtimerstartloc}
         *
         * @author Christopher Bernjus
         */
        public EndTimer(int t_endtimer, int d_endtimerstartloc) {
            this.t_endtimer = t_endtimer;
            this.d_endtimerstartloc = d_endtimerstartloc;
        }


        // Functions

        @Override
        public String toString() {
            return "EndTimer{" + "t_endtimer=" + t_endtimer + ", d_endtimerstartloc=" + d_endtimerstartloc + '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            EndTimer endTimer = (EndTimer) o;
            return t_endtimer == endTimer.t_endtimer && d_endtimerstartloc == endTimer.d_endtimerstartloc;
        }

        @Override
        public int hashCode() {
            return Objects.hash(t_endtimer, d_endtimerstartloc);
        }

    }

    /** Subclass For Handling Dangerpoints */
    public static class DangerPoint {

        /** {@link ETCSVariables#D_DP} */
        public int d_dp;

        /** {@link ETCSVariables#V_RELEASEDP} */
        public int v_releasedp;


        // Constructor

        /**
         * Constructs A {@link DangerPoint} Object
         *
         * @param d_dp {@link DangerPoint#d_dp}
         * @param v_releasedp {@link DangerPoint#v_releasedp}
         *
         * @author Christopher Bernjus
         */
        public DangerPoint(int d_dp, int v_releasedp) {
            this.d_dp = d_dp;
            this.v_releasedp = v_releasedp;
        }


        // Functions

        @Override
        public String toString() {
            return "DangerPoint{" + "d_dp=" + d_dp + ", v_releasedp=" + v_releasedp + '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            DangerPoint that = (DangerPoint) o;
            return d_dp == that.d_dp && v_releasedp == that.v_releasedp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(d_dp, v_releasedp);
        }

    }

    /** Subclass For Handling Overlaps */
    public static class Overlap {

        /** {@link ETCSVariables#D_STARTOL} */
        public int d_startol;

        /** {@link ETCSVariables#T_OL} */
        public int t_ol;

        /** {@link ETCSVariables#D_OL} */
        public int d_ol;

        /** {@link ETCSVariables#V_RELEASEOL} */
        public int v_releaseol;


        // Constructor
        
        public Overlap(int d_startol, int t_ol, int d_ol, int v_releaseol) {
            this.d_startol = d_startol;
            this.t_ol = t_ol;
            this.d_ol = d_ol;
            this.v_releaseol = v_releaseol;
        }


        // Functions

        @Override
        public String toString() {
            return "Overlap{" + "d_startol=" + d_startol + ", t_ol=" + t_ol + ", d_ol=" + d_ol + ", v_releaseol=" + v_releaseol + '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Overlap overlap = (Overlap) o;
            return d_startol == overlap.d_startol && t_ol == overlap.t_ol && d_ol == overlap.d_ol && v_releaseol == overlap.v_releaseol;
        }

        @Override
        public int hashCode() {
            return Objects.hash(d_startol, t_ol, d_ol, v_releaseol);
        }

    }


    // EOA

    /** {@link ETCSVariables#Q_DIR} */
    @CanBeNull
    public Integer q_dir;

    /** {@link ETCSVariables#Q_SCALE} */
    @CanBeNull
    public Integer q_scale;

    /** {@link ETCSVariables#V_LOA} */
    public int v_loa;

    /** {@link ETCSVariables#T_LOA} */
    public int t_loa;

    /** List Of {@link Section}s */
    @MinOneElem
    public List<Section> sections;

    /** {@link EndTimer} */
    @CanBeNull
    public EndTimer endTimer;

    /** {@link DangerPoint} */
    @CanBeNull
    public DangerPoint dangerPoint;

    /** {@link Overlap} */
    @CanBeNull
    public Overlap overlap;


    // Constructor

    /**
     * Constructs A {@link EOA} Object With Empty List
     *
     * @param q_dir {@link EOA#q_dir}
     * @param q_scale {@link EOA#q_scale}
     * @param v_loa {@link EOA#v_loa}
     * @param t_loa {@link EOA#t_loa}
     * @param endTimer {@link EndTimer}
     * @param dangerPoint {@link DangerPoint}
     * @param overlap {@link Overlap}
     *
     * @author Christopher Bernjus
     */
    public EOA(Integer q_dir, Integer q_scale, int v_loa, int t_loa, EndTimer endTimer, DangerPoint dangerPoint,
               Overlap overlap) {
        this.q_dir = q_dir;
        this.q_scale = q_scale;
        this.v_loa = v_loa;
        this.t_loa = t_loa;
        this.sections = new ArrayList<>();
        this.endTimer = endTimer;
        this.dangerPoint = dangerPoint;
        this.overlap = overlap;
    }

    /**
     * Constructs A {@link EOA} Object With Given List
     *
     * @param q_dir {@link EOA#q_dir}
     * @param q_scale {@link EOA#q_scale}
     * @param v_loa {@link EOA#v_loa}
     * @param t_loa {@link EOA#t_loa}
     * @param sections List Of {@link Section}s
     * @param endTimer {@link EndTimer}
     * @param dangerPoint {@link DangerPoint}
     * @param overlap {@link Overlap}
     *
     * @author Christopher Bernjus
     */
    public EOA(Integer q_dir, Integer q_scale, int v_loa, int t_loa, List<Section> sections, EndTimer endTimer, DangerPoint dangerPoint,
               Overlap overlap) {
        this.q_dir = q_dir;
        this.q_scale = q_scale;
        this.v_loa = v_loa;
        this.t_loa = t_loa;
        this.sections = sections;
        this.endTimer = endTimer;
        this.dangerPoint = dangerPoint;
        this.overlap = overlap;
    }


    // Functions

    @Override
    public String toString() {
        return "EOA{" + "q_dir=" + (q_dir == null ? "null" : q_dir) + ", q_scale=" + (q_scale == null ? "null" : q_scale) + ", v_loa=" + v_loa + ", t_loa=" + t_loa + ", sections=" + sections.toString() +
               ", endTimer=" + (endTimer == null ? "null" : endTimer.toString()) + ", dangerPoint=" + (dangerPoint == null ? "null" : dangerPoint.toString()) + ", overlap=" + (overlap == null ? "null" : overlap.toString()) + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        EOA eoa = (EOA) o;
        return v_loa == eoa.v_loa && t_loa == eoa.t_loa && Objects.equals(q_dir, eoa.q_dir) && Objects.equals(q_scale, eoa.q_scale) &&
               sections.equals(eoa.sections) && Objects.equals(endTimer, eoa.endTimer) && Objects.equals(dangerPoint, eoa.dangerPoint) &&
               Objects.equals(overlap, eoa.overlap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(q_dir, q_scale, v_loa, t_loa, sections, endTimer, dangerPoint, overlap);
    }

}
