package de.ibw.tms.train.ui;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class YAxis extends Line2D {

    Line2D AxisLine;
    double dMaxSpeed = 120;


    public YAxis(double x1, double yStart, double height, double dMaxSpeed) {
        this.AxisLine = new Line2D.Double();
        AxisLine.setLine(x1, -height + yStart , x1, yStart);
        this.dMaxSpeed = dMaxSpeed;

    }


    @Override
    public double getX1() {
        return AxisLine.getX1();
    }

    @Override
    public double getY1() {
        return AxisLine.getY1();
    }

    @Override
    public Point2D getP1() {
        return AxisLine.getP1();

    }

    @Override
    public double getX2() {
        return AxisLine.getX2();
    }

    @Override
    public double getY2() {
        return AxisLine.getY2();
    }

    @Override
    public Point2D getP2() {
        return AxisLine.getP2();
    }

    @Override
    public void setLine(double x1, double y1, double x2, double y2) {
        AxisLine.setLine(x1,y1,x2,y2);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return AxisLine.getBounds2D();
    }
}
