package de.ibw.rtm.intf;

import org.railMl.rtm4rail.TLateralSide;
import org.railMl.rtm4rail.TVerticalSide;

public interface IRTMLinearCoordinate extends IRTMPositioningSystemCoordinate {
    Double getLateralDistance();

    void setLateralDistance(Double value);

    double getMeasure();

    void setMeasure(double value);

    Double getVerticalDistance();

    void setVerticalDistance(Double value);

    TLateralSide getLateralSide();

    void setLateralSide(TLateralSide value);

    TVerticalSide getVerticalSide();

    void setVerticalSide(TVerticalSide value);
}
