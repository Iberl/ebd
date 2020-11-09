package de.ibw.tms.plan_pro.adapter.topology.intf;

import de.ibw.tms.ma.positioning.GeometricCoordinate;

public interface INode {

    default GeometricCoordinate getGeoCoordinates() {
        return null;
    }
}
