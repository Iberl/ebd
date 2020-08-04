package de.ibw.tms.train.ui;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class XAxis extends Line2D {

    public Line2D AxisLine;
    public double dTrackLength = 120;


    public XAxis(double X1, double dWidth,double dYstart, double dHeight, double dTrackLength) {
        this.AxisLine = new Line2D.Double();
        AxisLine.setLine(X1,  -dYstart + dHeight , X1 + dWidth, -dYstart + dHeight );
        this.dTrackLength = dTrackLength;

    }

    public void setTrackWidth(double dTrackLength) {
        this.dTrackLength = dTrackLength;
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
