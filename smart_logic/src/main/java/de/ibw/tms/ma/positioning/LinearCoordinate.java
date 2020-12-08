package de.ibw.tms.ma.positioning;

import de.ibw.rtm.intf.IRTMLinearCoordinate;
import ebd.messageLibrary.serialization.annotations.IfTrue;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.TLateralSide;
import org.railMl.rtm4rail.TVerticalSide;

public class LinearCoordinate extends PositioningSystemCoordinate implements IRTMLinearCoordinate {

    public static final String CLASS_IDENTIFIER = "Linear_Coordinate";


    private double lateralOffset;
    private double measure;
    private double verticalOffset;
    private TLateralSide lateralSide;
    private TVerticalSide verticalSide;

    public LinearCoordinate() {
        super(CLASS_IDENTIFIER);
    }

    @Override
    public Double getLateralDistance() {
        return lateralOffset;
    }

    @Override
    public void setLateralDistance(Double value) {
        this.lateralOffset = value;
    }

    @Override
    public double getMeasure() {
        return measure;
    }

    @Override
    public void setMeasure(double value) {
        measure = value;
    }

    @Override
    public Double getVerticalDistance() {
        return verticalOffset;
    }

    @Override
    public void setVerticalDistance(Double value) {
        verticalOffset = value;
    }

    @Override
    public TLateralSide getLateralSide() {
        return lateralSide;
    }

    @Override
    public void setLateralSide(TLateralSide value) {
        this.lateralSide = value;
    }

    @Override
    public TVerticalSide getVerticalSide() {
        return this.verticalSide;
    }

    @Override
    public void setVerticalSide(TVerticalSide value) {
        verticalSide = value;
    }

    @Override
    public String getPositioningSystemRef() {
        return this.getId();
    }

    @Override
    public void setPositioningSystemRef(String value) {
        throw new NotImplementedException("Ref is implemented by UUID and not setable.");
    }
}
