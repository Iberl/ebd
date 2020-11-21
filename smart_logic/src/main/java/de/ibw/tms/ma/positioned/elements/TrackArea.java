package de.ibw.tms.ma.positioned.elements;

import org.railMl.rtm4rail.TApplicationDirection;

import java.util.List;

public class TrackArea extends LinearElement {
    TApplicationDirection applicationDirection;
    List<TrackEdgeSection> trackEdgeSections;

    public TrackArea(String sName) {
        super(sName);
    }

    public TApplicationDirection getApplicationDirection() {
        return applicationDirection;
    }

    public void setApplicationDirection(TApplicationDirection applicationDirection) {
        this.applicationDirection = applicationDirection;
    }

    public List<TrackEdgeSection> getTrackEdgeSections() {
        return trackEdgeSections;
    }

    public void setTrackEdgeSections(List<TrackEdgeSection> trackEdgeSections) {
        this.trackEdgeSections = trackEdgeSections;
    }
}
