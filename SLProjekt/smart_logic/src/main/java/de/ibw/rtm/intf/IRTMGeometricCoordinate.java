package de.ibw.rtm.intf;

public interface IRTMGeometricCoordinate extends IRTMPositioningSystemCoordinate {
    double getX();

    void setX(double value);

    double getY();

    void setY(double value);

    Double getZ();

    void setZ(Double value);
}
