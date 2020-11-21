package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.rbc_tms.util.LinkingProfile;

import java.util.ArrayList;
import java.util.List;

public class LinkingProfileAdapter extends LinkingProfile {
    @Expose
    public Integer q_dir;
    @Expose
    public Integer q_scale;
    @Expose
    public List<LinkAdapter> links = new ArrayList();
    public LinkingProfileAdapter(LinkingProfile lP) {
        super(lP.q_dir, lP.q_scale, lP.links);
        this.q_dir = lP.q_dir;
        this.q_scale = lP.q_scale;
        links = new ArrayList<>();
        for (Link L : lP.links) {
            LinkAdapter La = new LinkAdapter(L);
            links.add(La);
        }

    }

    @Override
    public String toString() {
        return "LinkingProfileAdapter{" +
                "q_dir=" + q_dir +
                ", q_scale=" + q_scale +
                ", links=" + links +
                '}';
    }

    public LinkingProfile convert() {
        ArrayList<Link> linkResults = new ArrayList<>();
        for(LinkAdapter LA : this.links) {
            linkResults.add(LA.convert());
        }

        LinkingProfile LpResule = new LinkingProfile(this.q_dir, this.q_scale, linkResults);
        return LpResule;
    }
}
