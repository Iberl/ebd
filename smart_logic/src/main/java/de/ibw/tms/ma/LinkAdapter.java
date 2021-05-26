package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.internal.util.LinkingProfile;

public class LinkAdapter extends LinkingProfile.Link {
    @Expose
    public int d_link;
    @Expose
    public Integer nid_c;
    @Expose
    public int nid_bg;
    @Expose
    public boolean q_linkorientation;
    @Expose
    public int q_linkreaction;
    @Expose
    public int q_locacc;

    public LinkAdapter(LinkingProfile.Link L) {
        super(L.d_link, L.nid_c, L.nid_bg, L.q_linkorientation, L.q_linkreaction, L.q_locacc);
        this.d_link = L.d_link;
        this.nid_c = L.nid_c;
        this.nid_bg = L.nid_bg;
        this.q_linkorientation = L.q_linkorientation;
        this.q_linkreaction = L.q_linkreaction;
        this.q_locacc = L.q_locacc;
    }

    @Override
    public String toString() {
        return "LinkAdapter{" +
                "d_link=" + d_link +
                ", nid_c=" + nid_c +
                ", nid_bg=" + nid_bg +
                ", q_linkorientation=" + q_linkorientation +
                ", q_linkreaction=" + q_linkreaction +
                ", q_locacc=" + q_locacc +
                '}';
    }

    public LinkingProfile.Link convert() {
        LinkingProfile.Link LiResult =
                new LinkingProfile.Link(this.d_link, this.nid_c, this.nid_bg, this.q_linkorientation,
                        this.q_linkreaction, this.q_locacc);
        return LiResult;
    }
}
