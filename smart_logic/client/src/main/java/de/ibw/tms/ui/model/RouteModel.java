package de.ibw.tms.ui.model;

import de.ibw.tms.trackplan.ui.Route;

/**
 * Eine Route in der Ansicht
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1
 * @since 2021-06-11
 *
 */
public class RouteModel {
    private String sRouteModelName;
    private Route route;

    public RouteModel() {

    }

    public String getsRouteModelName() {
        return sRouteModelName;
    }

    public void setsRouteModelName(String sRouteModelName) {
        this.sRouteModelName = sRouteModelName;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
