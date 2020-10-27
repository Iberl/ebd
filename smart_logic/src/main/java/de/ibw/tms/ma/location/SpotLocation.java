package de.ibw.tms.ma.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import de.ibw.rtm.intf.IRTMGeometricCoordinate;
import de.ibw.rtm.intf.IRTMLinearCoordinate;
import de.ibw.rtm.intf.IRTMPositioningNetElement;
import de.ibw.rtm.intf.IRTMSpotLocation;
import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.SectionOfLine;
import de.ibw.tms.ma.common.DefaultObject;
import de.ibw.tms.ma.physical.TrackElement;
import jdk.jshell.spi.ExecutionControl;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.RTMGeometricCoordinate;
import org.railMl.rtm4rail.RTMLinearCoordinate;
import org.railMl.rtm4rail.TApplicationDirection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;


public class SpotLocation extends EntityLocation implements IRTMSpotLocation, Serializable {

    public static final String CLASS_IDENTIFIER = "Spot_Location";

    protected TApplicationDirection applicationDirection;
    protected IRTMPositioningNetElement NetElement;

    protected IRTMLinearCoordinate LinearCoordinateSlSide;
    protected IRTMGeometricCoordinate GeometricCoordinateSlSide;


    protected double intrinsicCoord;
    protected BigDecimal pos;

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

    public SpotLocation(String sName) {
        super(sName);
    }

    public SpotLocation() {
        super(CLASS_IDENTIFIER);
    }

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
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public void setLinearCoordinate(RTMLinearCoordinate value) {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public RTMGeometricCoordinate getGeometricCoordinate() {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public void setGeometricCoordinate(RTMGeometricCoordinate value) {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public String getNetElementRef() {
        return this.NetElement.getId();
    }

    @Override
    public void setNetElementRef(String value) {
        IRTMPositioningNetElement PosElement =
                (IRTMPositioningNetElement) DefaultObject.topologyRepository.getModel(UUID.fromString(value));
        NetElement = PosElement;
    }

    @Override
    public Double getIntrinsicCoord() {

        return intrinsicCoord;
    }

    @Override
    public void setIntrinsicCoord(Double value) {
        this.intrinsicCoord = value;
    }

    @Override
    public TApplicationDirection getApplicationDirection() {
        return this.applicationDirection;
    }

    @Override
    public void setApplicationDirection(TApplicationDirection value) {
        this.applicationDirection = value;
    }

    @Override
    public BigDecimal getPos() {

        return this.pos;
    }

    @Override
    public void setPos(BigDecimal value) {
        this.pos = value;

    }

    public IRTMLinearCoordinate getLinearCoordinateSlSide() {
        return LinearCoordinateSlSide;
    }

    public void setLinearCoordinateSlSide(IRTMLinearCoordinate linearCoordinateSlSide) {
        LinearCoordinateSlSide = linearCoordinateSlSide;
    }

    public IRTMGeometricCoordinate getGeometricCoordinateSlSide() {
        return GeometricCoordinateSlSide;
    }

    public void setGeometricCoordinateSlSide(IRTMGeometricCoordinate geometricCoordinateSlSide) {
        GeometricCoordinateSlSide = geometricCoordinateSlSide;
    }
}
