package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.ma.occupation.Occupation;

import java.util.List;

/*

 */
public class DangerArea extends TrackArea {
    public static final String CLASS_IDENTIFIER = "Danger_Area";

    private List<Occupation> occupations;

    public DangerArea() {
        super(CLASS_IDENTIFIER);
    }

    public DangerArea(String sName) {
        super(sName);
    }

    public List<Occupation> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<Occupation> occupations) {
        this.occupations = occupations;
    }
}
