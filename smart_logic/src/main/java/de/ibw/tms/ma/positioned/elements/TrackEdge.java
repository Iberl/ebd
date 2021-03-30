package de.ibw.tms.ma.positioned.elements;

import java.util.List;

public class TrackEdge extends SpotElement {
    public static final String CLASS_IDENTIFIER = "Track_Edge";

    private List<TrackArea> trackAreas;


    public TrackEdge() {
        super(CLASS_IDENTIFIER);
    }
}
