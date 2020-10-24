package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;

public class InformationPoint extends TrackArea {
    public static final String CLASS_IDENTIFIER = "Track_Edge";

    public InformationPoint() {
        super(CLASS_IDENTIFIER);
    }

    @Override
    public List<TrackEdgeSection> getTrackEdgeSections() {
        throw new UnsupportedOperationException("Information Point only has one track EdgeSection");
    }

    @Override
    public void setTrackEdgeSections(List<TrackEdgeSection> trackEdgeSections) {
        throw new UnsupportedOperationException("Information Point only has one track EdgeSection");
    }
    public TrackEdge getTrackEdge() {
        if(this.trackEdgeSections == null)
            return null;
        if(this.trackEdgeSections.size() == 1) {
            return this.trackEdgeSections.get(0).getTrackEdge();
        }
        throw new UnsupportedOperationException("InformationPoint must have exact one TrackEdgeSection");
    }

    public void setTrackEdge(TrackEdge TE) {
        if(this.trackEdgeSections == null)
            this.trackEdgeSections = new ArrayList<>();
        if(this.trackEdgeSections.size() == 1) {
            this.trackEdgeSections.get(0).setTrackEdge(TE);
        } else {
            TrackEdgeSection TES = new TrackEdgeSection();
            TES.setTrackEdge(TE);
            this.trackEdgeSections.clear();
            this.trackEdgeSections.add(TES);
        }
    }
    public SpotLocationIntrinsic getIntrinsicCoord() {
        if(this.trackEdgeSections == null)
            return null;
        if(this.trackEdgeSections.size() == 1) {
            return this.trackEdgeSections.get(0).getBegin();
        }
        throw new UnsupportedOperationException("InformationPoint must have exact one TrackEdgeSection");
    }
    public void setIntrinsicCoord(SpotLocationIntrinsic SLI) {
        if(this.trackEdgeSections == null)
            this.trackEdgeSections = new ArrayList<>();
        if(this.trackEdgeSections.size() == 1) {
            this.trackEdgeSections.get(0).setBegin(SLI);
            this.trackEdgeSections.get(0).setEnd(SLI);
        } else {
            TrackEdgeSection TES = new TrackEdgeSection();
            TES.setBegin(SLI);
            TES.setEnd(SLI);
            this.trackEdgeSections.clear();
            this.trackEdgeSections.add(TES);
        }
    }



}
