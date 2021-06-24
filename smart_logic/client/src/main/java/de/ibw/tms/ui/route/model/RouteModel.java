package de.ibw.tms.ui.route.model;

import de.ibw.tms.trackplan.ui.Route;
import de.ibw.util.DefaultRepo;

import java.util.ArrayList;

/**
 * Eine Route in der Ansicht
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.10
 * @since 2021-06-24
 *
 */
public class RouteModel {

    /**
     * Dieses Repository Speichert eine Route unter einem Nutzerdefinierten Namen
     */
    public static DefaultRepo<String, RouteModel> routeRepository = new DefaultRepo<>();

    public static final String CREATE_NEW = "*";


    private String sRouteModelName;
    private Route route;
    private Integer nid_engineId;


    public RouteModel(String sName) {
        this.sRouteModelName = sName;
        this.route = new Route(new ArrayList<>());
        this.nid_engineId = null;


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

    public int getNid_engineId() {
        return nid_engineId;
    }

    public void setNid_engineId(int nid_engineId) {
        this.nid_engineId = nid_engineId;
    }

    @Override
    public String toString() {
        if(sRouteModelName == null) return "ERROR";
        return sRouteModelName;
    }
}
