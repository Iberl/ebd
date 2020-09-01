package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.physical.TrackElement;

import java.io.Serializable;


public class SpotLocation implements Serializable {
    //TODO GEOCOORDINATES

    @Override
    public String toString() {
        return "SpotLocation{" +
                "chainage=" + chainage +
                '}';
    }

    @Expose
    public Chainage chainage;
    @JsonIgnore
    protected TrackElement trackElement;

    private SectionOfLine lineSection;

    public SpotLocation(Chainage chainage, TrackElement trackElement, SectionOfLine lineSection) {
        this.chainage = chainage;
        this.trackElement = trackElement;
        this.lineSection = lineSection;
    }


    public Chainage getChainage() {
        return chainage;
    }

    public void setChainage(Chainage chainage) {
        this.chainage = chainage;
    }

    public TrackElement getTrackElement() {
        return trackElement;
    }

    public void setTrackElement(TrackElement trackElement) {
        this.trackElement = trackElement;
    }

    public SectionOfLine getLineSection() {
        return lineSection;
    }

    public void setLineSection(SectionOfLine lineSection) {
        this.lineSection = lineSection;
    }


}
