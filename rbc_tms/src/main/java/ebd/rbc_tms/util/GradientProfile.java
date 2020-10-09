package ebd.rbc_tms.util;

import ebd.rbc_tms.util.annotations.CanBeNull;
import ebd.rbc_tms.util.annotations.MinOneElem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Gradient Profile Used In Movement Authorities
 *
 * @author Christopher Bernjus
 */
public class GradientProfile {

    /** Subclass For Handling Gradients */
    public static class Gradient {

        /** {@link ETCSVariables#D_GRADIENT} */
        public int d_gradient;

        /** {@link ETCSVariables#Q_GDIR} */
        public boolean q_gdir;

        /** {@link ETCSVariables#G_A} */
        public int g_a;


        // Constructor

        /**
         * Constructs A {@link Gradient} Object
         *
         * @param d_gradient {@link Gradient#d_gradient}
         * @param q_gdir {@link Gradient#q_gdir}
         * @param g_a {@link Gradient#g_a}
         *
         * @author Christopher Bernjus
         */
        public Gradient(int d_gradient, boolean q_gdir, int g_a) {
            this.d_gradient = d_gradient;
            this.q_gdir = q_gdir;
            this.g_a = g_a;
        }


        // Functions

        @Override
        public String toString() {
            return "Gradient{" + "d_gradient=" + d_gradient + ", q_gdir=" + q_gdir + ", g_a=" + g_a + '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Gradient gradient = (Gradient) o;
            return d_gradient == gradient.d_gradient && q_gdir == gradient.q_gdir && g_a == gradient.g_a;
        }

        @Override
        public int hashCode() {
            return Objects.hash(d_gradient, q_gdir, g_a);
        }

    }


    // Gradient Profile

    /** {@link ETCSVariables#Q_DIR} */
    @CanBeNull
    public Integer q_dir;

    /** {@link ETCSVariables#Q_SCALE} */
    @CanBeNull
    public Integer q_scale;

    /** List Of {@link Gradient}s */
    @MinOneElem
    public List<Gradient> gradients = new ArrayList<>();


    // Constructors

    /**
     * Constructs A {@link GradientProfile} Object With Empty List
     *
     * @param q_dir {@link GradientProfile#q_dir}
     * @param q_scale {@link GradientProfile#q_scale}
     *
     * @author Christopher Bernjus
     */
    public GradientProfile(Integer q_dir, Integer q_scale) {
        this.q_dir = q_dir;
        this.q_scale = q_scale;
    }

    /**
     * Constructs A {@link GradientProfile} Object With Given List
     *
     * @param q_dir {@link GradientProfile#q_dir}
     * @param q_scale {@link GradientProfile#q_scale}
     * @param gradients List Of {@link Gradient}s
     *
     * @author Christopher Bernjus
     */
    public GradientProfile(Integer q_dir, Integer q_scale, List<Gradient> gradients) {
        this.q_dir = q_dir;
        this.q_scale = q_scale;
        this.gradients = gradients;
    }


    // Functions

    @Override
    public String toString() {
        return "GradientProfile{" + "q_dir=" + (q_dir == null ? "null" : q_dir) + ", q_scale=" + (q_scale == null ? "null" : q_scale) + ", gradients=" + gradients.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        GradientProfile that = (GradientProfile) o;
        return Objects.equals(q_dir, that.q_dir) && Objects.equals(q_scale, that.q_scale) && gradients.equals(that.gradients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(q_dir, q_scale, gradients);
    }

}
