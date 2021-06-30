package de.ibw.tms.ui.route.model;

import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.trackbased.TopologyFactory;
import de.ibw.tms.trackplan.ui.Route;
import de.ibw.tms.ui.route.view.RouteModelUI;
import de.ibw.util.DefaultRepo;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;

/**
 * Eine Route in der Ansicht
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.10
 * @since 2021-06-30
 *
 */
public class RouteModel {


    /**
     * Vordefinierer Routenname
     */
    public static final String FD_ROUTE = "FD Route";

    /**
     * Dieses Repository Speichert eine Route unter einem Nutzerdefinierten Namen
     */
    public static DefaultRepo<String, RouteModel> routeRepository = new DefaultRepo<>();


    public static boolean isRouteSelected() {
        return RouteModelUI.isRouteActive();
    }

    public static final String CREATE_NEW = "*";


    private String sRouteModelName;
    private Route route;
    private Integer nid_engineId;





    public RouteModel(String sName) {
        this.sRouteModelName = sName;
        this.route = new Route(new ArrayList<>());
        this.nid_engineId = null;


    }

    /**
     * Fuege die Gleiskantenbezeichnung zur Route hinzu
     * @param E - Kante aus der die Bezeichnung entommen wird
     * @throws InvalidParameterException - wirft Fehler, wenn die Kante nicht fuer Routen passend ist
     *                                   - Kanten in einer DKW zum Beispiel sollen nicht angegeben werden
     *
     */
    public void addEdgeToRoute(TopologyGraph.Edge E) throws InvalidParameterException {
        checkIfEdgeAddableToRoute(E);
        this.route.addEdge(E);
    }

    /**
     * Checkt ob eine Kante zu der Route hinzugefuegt werden kann
     * @param E - Kante für die Route
     * @throws InvalidParameterException - Invalide Kanten - Kannten innerhalb einer DKW muessen nicht angegeben werden
     */
    public void checkIfEdgeAddableToRoute(TopologyGraph.Edge E) throws InvalidParameterException {
        String refId = E.getRefId();
        if(refId == null || refId.isEmpty()) throw new InvalidParameterException("Ref Id is not creatable");
        if(refId.contains("LL") || refId.contains("RR") || refId.contains("LR") || refId.contains("RL")) {
            throw new InvalidParameterException("Es müssen keine Kanten in einer DKW selektieirt werden.");
        }
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
