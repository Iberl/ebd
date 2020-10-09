package ebd.rbc_tms.util;

import ebd.rbc_tms.util.annotations.CanBeNull;
import ebd.rbc_tms.util.annotations.MinOneElem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkingProfile {

    /** Subclass For Handling Links */
    public static class Link {

        /** {@link ETCSVariables#D_LINK } */
        public int d_link;

        /** {@link ETCSVariables#NID_C } */
        @CanBeNull
        public Integer nid_c;

        /** {@link ETCSVariables#NID_BG } */
        public int nid_bg;

        /** {@link ETCSVariables#Q_LINKORIENTATION } */
        public boolean q_linkorientation;

        /** {@link ETCSVariables#Q_LINKREACTION } */
        public int q_linkreaction;

        /** {@link ETCSVariables#Q_LOCACC } */
        public int q_locacc;


        // Constructor

        /**
         * Constructs A {@link Link} Object
         *
         * @param d_link {@link Link#d_link}
         * @param nid_c {@link Link#nid_c}
         * @param nid_bg {@link Link#nid_bg}
         * @param q_linkorientation {@link Link#q_linkorientation}
         * @param q_linkreaction {@link Link#q_linkreaction}
         * @param q_locacc {@link Link#q_locacc}
         *
         * @author Christopher Bernjus
         */
        public Link(int d_link, Integer nid_c, int nid_bg, boolean q_linkorientation, int q_linkreaction, int q_locacc) {
            this.d_link = d_link;
            this.nid_c = nid_c;
            this.nid_bg = nid_bg;
            this.q_linkorientation = q_linkorientation;
            this.q_linkreaction = q_linkreaction;
            this.q_locacc = q_locacc;
        }


        // Functions

        @Override
        public String toString() {
            return "Link{" + "d_link=" + d_link + ", nid_c=" + (nid_c == null ? "null" : nid_c) + ", nid_bg=" + nid_bg + ", q_linkorientation=" + q_linkorientation +
                   ", q_linkreaction=" + q_linkreaction + ", q_locacc=" + q_locacc + '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Link link = (Link) o;
            return d_link == link.d_link && nid_bg == link.nid_bg && q_linkorientation == link.q_linkorientation &&
                   q_linkreaction == link.q_linkreaction && q_locacc == link.q_locacc && Objects.equals(nid_c, link.nid_c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(d_link, nid_c, nid_bg, q_linkorientation, q_linkreaction, q_locacc);
        }

    }


    // Fields

    /** {@link ETCSVariables#Q_DIR} */
    @CanBeNull
    public Integer q_dir;

    /** {@link ETCSVariables#Q_SCALE} */
    @CanBeNull
    public Integer q_scale;

    /** List Of {@link Link}s */
    @MinOneElem
    public List<Link> links = new ArrayList<>();


    // Constructors

    /**
     * Constructs A {@link LinkingProfile} Object With Empty Lists
     * @param q_dir {@link LinkingProfile#q_dir}
     * @param q_scale {@link LinkingProfile#q_scale}
     *
     * @author Christopher Bernjus
     */
    public LinkingProfile(Integer q_dir, Integer q_scale) {
        this.q_dir = q_dir;
        this.q_scale = q_scale;
    }

    /**
     * Constructs A {@link LinkingProfile} Object With Given List
     * @param q_dir {@link LinkingProfile#q_dir}
     * @param q_scale {@link LinkingProfile#q_scale}
     * @param links List Of {@link Link}s
     *
     * @author Christopher Bernjus
     */
    public LinkingProfile(Integer q_dir, Integer q_scale, List<Link> links) {
        this.q_dir = q_dir;
        this.q_scale = q_scale;
        this.links = links;
    }


    // Functions

    @Override
    public String toString() {
        return "LinkingProfile{" + "q_dir=" + q_dir + ", q_scale=" + q_scale + ", links=" + links.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        LinkingProfile that = (LinkingProfile) o;
        return q_dir == that.q_dir && q_scale == that.q_scale && links.equals(that.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(q_dir, q_scale, links);
    }

}
