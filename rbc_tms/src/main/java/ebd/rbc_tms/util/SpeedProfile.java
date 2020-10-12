package ebd.rbc_tms.util;

import ebd.rbc_tms.util.annotations.CanBeNull;
import ebd.rbc_tms.util.annotations.MinOneElem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Speed Profile Used In Movement Authorities
 *
 * @author Christopher Bernjus
 */
public class SpeedProfile {

    /** Subclass For Handling Speed Sections */
    public static class Section {

        /** Subclass For Handling Categories */
        public static class Category {

            /** {@link ETCSVariables#Q_DIFF} */
            public int q_diff;

            /** {@link ETCSVariables#NC_CDDIFF} */
            public int nc_cddiff;

            /** {@link ETCSVariables#NC_DIFF} */
            public int nc_diff;

            /** {@link ETCSVariables#V_DIFF} */
            public int v_diff;


            // Constructor

            /**
             * Constructs A {@link Category} Object
             *
             * @param q_diff {@link Category#q_diff}
             * @param nc_cddiff {@link Category#nc_cddiff}
             * @param nc_diff {@link Category#nc_diff}
             * @param v_diff {@link Category#v_diff}
             *
             * @author Christopher Bernjus
             */
            public Category(int q_diff, int nc_cddiff, int nc_diff, int v_diff) {
                this.q_diff = q_diff;
                this.nc_cddiff = nc_cddiff;
                this.nc_diff = nc_diff;
                this.v_diff = v_diff;
            }


            // Functions

            @Override
            public String toString() {
                return "Category{" + "q_diff=" + q_diff + ", nc_cddiff=" + nc_cddiff + ", nc_diff=" + nc_diff + ", v_diff=" + v_diff + '}';
            }

            @Override
            public boolean equals(Object o) {
                if(this == o) return true;
                if(o == null || getClass() != o.getClass()) return false;
                Category category = (Category) o;
                return q_diff == category.q_diff && nc_cddiff == category.nc_cddiff && nc_diff == category.nc_diff && v_diff == category.v_diff;
            }

            @Override
            public int hashCode() {
                return Objects.hash(q_diff, nc_cddiff, nc_diff, v_diff);
            }

        }


        // Section

        /** {@link ETCSVariables#D_STATIC} */
        public int d_static;

        /** {@link ETCSVariables#V_STATIC} */
        public int v_static;

        /** {@link ETCSVariables#Q_FRONT} */
        public boolean q_front;

        /** List Of {@link Category}s */
        public List<Category> categories;


        // Constructors

        /**
         * Constructs A {@link Section} Object With Empty List
         *
         * @param d_static {@link Section#d_static}
         * @param v_static {@link Section#v_static}
         * @param q_front {@link Section#q_front}
         *
         * @author Christopher Bernjus
         */
        public Section(int d_static, int v_static, boolean q_front) {
            this.d_static = d_static;
            this.v_static = v_static;
            this.q_front = q_front;
        }

        /**
         * Constructs A {@link Section} Object With Given List
         *
         * @param d_static {@link Section#d_static}
         * @param v_static {@link Section#v_static}
         * @param q_front {@link Section#q_front}
         * @param categories List Of {@link Category}s
         *
         * @author Christopher Bernjus
         */
        public Section(int d_static, int v_static, boolean q_front, List<Category> categories) {
            this.d_static = d_static;
            this.v_static = v_static;
            this.q_front = q_front;
            this.categories = categories;
        }


        // Functions

        @Override
        public String toString() {
            return "Section{" + "d_static=" + d_static + ", v_static=" + v_static + ", q_front=" + q_front + ", categories=" + categories.toString() + '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Section section = (Section) o;
            return d_static == section.d_static && v_static == section.v_static && q_front == section.q_front &&
                   categories.equals(section.categories);
        }

        @Override
        public int hashCode() {
            return Objects.hash(d_static, v_static, q_front, categories);
        }

    }


    // Speed Profile

    /** {@link ETCSVariables#Q_DIR} */
    @CanBeNull
    public Integer q_dir;

    /** {@link ETCSVariables#Q_SCALE} */
    @CanBeNull
    public Integer q_scale;

    /** List Of {@link Section}s */
    @MinOneElem
    public List<Section> sections = new ArrayList<>();


    // Constructors

    /**
     * Constructs A {@link SpeedProfile} Object With Empty List
     *
     * @param q_dir {@link SpeedProfile#q_dir}
     * @param q_scale {@link SpeedProfile#q_scale}
     *
     * @author Christopher Bernjus
     */
    public SpeedProfile(Integer q_dir, Integer q_scale) {
        this.q_dir = q_dir;
        this.q_scale = q_scale;
    }

    /**
     * Constructs A {@link SpeedProfile} Object With Given List
     *
     * @param q_dir {@link SpeedProfile#q_dir}
     * @param q_scale {@link SpeedProfile#q_scale}
     * @param sections List Of {@link Section}s
     *
     * @author Christopher Bernjus
     */
    public SpeedProfile(Integer q_dir, Integer q_scale, List<Section> sections) {
        this.q_dir = q_dir;
        this.q_scale = q_scale;
        this.sections = sections;
    }


    // Functions

    @Override
    public String toString() {
        return "SpeedProfile{" + "q_dir=" + (q_dir == null ? "null" : q_dir) + ", q_scale=" + (q_scale == null ? "null" : q_scale) + ", sections=" + sections.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        SpeedProfile that = (SpeedProfile) o;
        return Objects.equals(q_dir, that.q_dir) && Objects.equals(q_scale, that.q_scale) && sections.equals(that.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(q_dir, q_scale, sections);
    }

}
