package de.ibw.util;

public class DoubleCoord implements ICoord<Double> {

    private Double x;
    private Double y;

    @Override
    public Double getX() {
        return x;
    }

    @Override
    public void setX(Double x) {
        this.x = x;
    }

    @Override
    public Double getY() {
        return y;
    }

    @Override
    public void setY(Double y) {
        this.y = y;
    }
}
