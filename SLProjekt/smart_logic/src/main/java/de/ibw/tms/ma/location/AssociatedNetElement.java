package de.ibw.tms.ma.location;

import de.ibw.rtm.intf.IRTMAssociatedNetElement;
import de.ibw.rtm.intf.IRTMPositioningNetElement;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.RTMGeometricCoordinate;
import org.railMl.rtm4rail.RTMLinearCoordinate;

import java.math.BigDecimal;
import java.util.List;

public class AssociatedNetElement implements IRTMAssociatedNetElement {
    private Double intrinsicCoordBegin;
    private Double intrinsicCoordEnd;
    private boolean keepsOrientation;
    private List<IRTMPositioningNetElement> netElements;
    private BigDecimal posBegin;
    private BigDecimal posEnd;

    @Override
    public RTMGeometricCoordinate getGeometricCoordinateBegin() {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public void setGeometricCoordinateBegin(RTMGeometricCoordinate value) {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public RTMLinearCoordinate getLinearCoordinateBegin() {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public void setLinearCoordinateBegin(RTMLinearCoordinate value) {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public RTMGeometricCoordinate getGeometricCoordinateEnd() {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public void setGeometricCoordinateEnd(RTMGeometricCoordinate value) {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public RTMLinearCoordinate getLinearCoordinateEnd() {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public void setLinearCoordinateEnd(RTMLinearCoordinate value) {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public String getNetElementRef() {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public void setNetElementRef(String value) {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public Double getIntrinsicCoordBegin() {
        return intrinsicCoordBegin;
    }

    @Override
    public void setIntrinsicCoordBegin(Double value) {
        this.intrinsicCoordBegin = value;
    }

    @Override
    public Double getIntrinsicCoordEnd() {
        return this.intrinsicCoordEnd;
    }

    @Override
    public void setIntrinsicCoordEnd(Double value) {
        this.intrinsicCoordEnd = value;
    }

    @Override
    public boolean isKeepsOrientation() {
        return keepsOrientation;
    }
    @Override
    public void setKeepsOrientation(boolean keepsOrientation) {
        this.keepsOrientation = keepsOrientation;
    }

    @Override
    public Integer getSequence() {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public void setSequence(Integer value) {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public BigDecimal getPosBegin() {
        return posBegin;
    }

    @Override
    public void setPosBegin(BigDecimal value) {
        this.posBegin = value;
    }

    @Override
    public BigDecimal getPosEnd() {
        return posEnd;
    }

    @Override
    public void setPosEnd(BigDecimal value) {
        this.posEnd = value;
    }

    public List<IRTMPositioningNetElement> getNetElements() {
        return netElements;
    }

    public void setNetElements(List<IRTMPositioningNetElement> netElements) {
        this.netElements = netElements;
    }
}
