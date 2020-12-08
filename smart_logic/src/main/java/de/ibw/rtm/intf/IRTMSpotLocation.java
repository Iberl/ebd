package de.ibw.rtm.intf;

import org.railMl.rtm4rail.RTMGeometricCoordinate;
import org.railMl.rtm4rail.RTMLinearCoordinate;
import org.railMl.rtm4rail.TApplicationDirection;

import java.math.BigDecimal;

public interface IRTMSpotLocation extends IRTMBaseObject {
    RTMLinearCoordinate getLinearCoordinate();

    void setLinearCoordinate(RTMLinearCoordinate value);

    RTMGeometricCoordinate getGeometricCoordinate();

    void setGeometricCoordinate(RTMGeometricCoordinate value);

    String getNetElementRef();

    void setNetElementRef(String value);

    Double getIntrinsicCoord();

    void setIntrinsicCoord(Double value);

    TApplicationDirection getApplicationDirection();

    void setApplicationDirection(TApplicationDirection value);

    BigDecimal getPos();

    void setPos(BigDecimal value);
}
