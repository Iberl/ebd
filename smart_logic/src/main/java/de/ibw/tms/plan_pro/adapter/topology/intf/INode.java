package de.ibw.tms.plan_pro.adapter.topology.intf;

import de.ibw.tms.ma.positioning.GeometricCoordinate;

public interface INode extends ITopological {

    default GeometricCoordinate getGeoCoordinates() {
        GeometricCoordinate GeoCo = new GeometricCoordinate();
        GeoCo.setX(1);
        GeoCo.setY(1);
        GeoCo.setZ(1.0d);
        return GeoCo;
    }
}
