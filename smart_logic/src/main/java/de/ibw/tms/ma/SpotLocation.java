package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import de.ibw.rtm.intf.IRTMSpotLocation;
import de.ibw.tms.ma.physical.TrackElement;
import org.railMl.rtm4rail.RTMGeometricCoordinate;
import org.railMl.rtm4rail.RTMLinearCoordinate;
import org.railMl.rtm4rail.TApplicationDirection;

import java.io.Serializable;
import java.math.BigDecimal;


public class SpotLocation extends EntityLocation implements IRTMSpotLocation, Serializable {

    public static final String CLASS_IDENTIFIER = "Sport_Location";

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
        super(CLASS_IDENTIFIER);
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


    @Override
    public RTMLinearCoordinate getLinearCoordinate() {
        return null;
    }

    @Override
    public void setLinearCoordinate(RTMLinearCoordinate value) {

    }

    @Override
    public RTMGeometricCoordinate getGeometricCoordinate() {
        return null;
    }

    @Override
    public void setGeometricCoordinate(RTMGeometricCoordinate value) {

    }

    @Override
    public String getNetElementRef() {
        return null;
    }

    @Override
    public void setNetElementRef(String value) {

    }

    @Override
    public Double getIntrinsicCoord() {
        return null;
    }

    @Override
    public void setIntrinsicCoord(Double value) {

    }

    @Override
    public TApplicationDirection getApplicationDirection() {
        return null;
    }

    @Override
    public void setApplicationDirection(TApplicationDirection value) {

    }

    @Override
    public BigDecimal getPos() {
        return null;
    }

    @Override
    public void setPos(BigDecimal value) {

    }
}
