package de.ibw.rtm.intf;

import org.railMl.rtm4rail.RTMGeometricCoordinate;
import org.railMl.rtm4rail.RTMLinearCoordinate;

import java.math.BigDecimal;

public interface IRTMAssociatedNetElement {
    RTMGeometricCoordinate getGeometricCoordinateBegin();

    void setGeometricCoordinateBegin(RTMGeometricCoordinate value);

    RTMLinearCoordinate getLinearCoordinateBegin();

    void setLinearCoordinateBegin(RTMLinearCoordinate value);

    RTMGeometricCoordinate getGeometricCoordinateEnd();

    void setGeometricCoordinateEnd(RTMGeometricCoordinate value);

    RTMLinearCoordinate getLinearCoordinateEnd();

    void setLinearCoordinateEnd(RTMLinearCoordinate value);

    String getNetElementRef();

    void setNetElementRef(String value);

    Double getIntrinsicCoordBegin();

    void setIntrinsicCoordBegin(Double value);

    Double getIntrinsicCoordEnd();

    void setIntrinsicCoordEnd(Double value);

    boolean isKeepsOrientation();

    void setKeepsOrientation(boolean value);

    Integer getSequence();

    void setSequence(Integer value);

    BigDecimal getPosBegin();

    void setPosBegin(BigDecimal value);

    BigDecimal getPosEnd();

    void setPosEnd(BigDecimal value);
}
