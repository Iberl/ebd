package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.ma.location.SpotLocationIntrinsic;

public class TrackEdgeSection extends LinearElement {
    public static final String CLASS_IDENTIFIER = "Track_Edge_Section";

    private TrackEdge trackEdge;
    private SpotLocationIntrinsic begin;
    private SpotLocationIntrinsic end;


    public TrackEdgeSection(String sName) {
        super(sName);
    }

    public TrackEdgeSection() {
        super(CLASS_IDENTIFIER);
    }

    public TrackEdge getTrackEdge() {
        return trackEdge;
    }

    public void setTrackEdge(TrackEdge trackEdge) {
        this.trackEdge = trackEdge;
    }

    public SpotLocationIntrinsic getBegin() {
        return begin;
    }

    public void setBegin(SpotLocationIntrinsic begin) {
        this.begin = begin;
    }

    public SpotLocationIntrinsic getEnd() {
        return end;
    }

    public void setEnd(SpotLocationIntrinsic end) {
        this.end = end;
    }
}
