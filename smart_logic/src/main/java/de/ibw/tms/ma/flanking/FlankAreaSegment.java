package de.ibw.tms.ma.flanking;

import de.ibw.tms.ma.Waypoint;
import de.ibw.tms.ma.occupation.FlankOccupation;
import de.ibw.tms.ma.physical.FlankAreaElement;
import de.ibw.tms.ma.positioned.elements.ContiguousTrackArea;

import java.util.List;

public class FlankAreaSegment extends ContiguousTrackArea {
    public static final String CLASS_IDENTIFIER = "Flank_Area_Segment";

    private int distance;
    private Waypoint origin;
    private List<FlankAreaElement> flankAreaElementList;
    private List<FlankOccupation> flankOccupationcs;

    public FlankAreaSegment(List<FlankOccupation> occupations) {
        super(CLASS_IDENTIFIER);
        this.flankOccupationcs = occupations;
    }



}
