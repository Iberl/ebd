package de.ibw.history.data;

import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.Waypoint;
import de.ibw.tms.ma.common.NetworkResource;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import de.ibw.util.DefaultRepo;
import org.apache.commons.lang3.tuple.Pair;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Routendatenverarbeitung innerhalb der smartLogic
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-27
 */
public class ComposedRoute extends ArrayList<Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological>> {

    // Waypoints auf einer Kante innerhalb einer DKW
    public DefaultRepo<TrackEdge, Waypoint> dkwWaypointRepo = new DefaultRepo<>();
    // Waypoints zwischen zwei TrackEdges je String id
    public DefaultRepo<Pair<String, String>, Waypoint> waypointsBetweentTwoTrackEdges = new DefaultRepo<>();

    /**
     * Berechnet Ausdehnung der gesamten Strecke
     * @return BigDecimal - Streckenausdehnug
     */
    public BigDecimal getRouteLength() {
        BigDecimal result = new BigDecimal("0");
        Iterator<Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological>> it = this.iterator();
        while(it.hasNext()) {
            Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological> element = it.next();
            if(element.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {
                TopologyGraph.Edge E = (TopologyGraph.Edge) element.getValue();
                result.add(BigDecimal.valueOf(E.dTopLength));
            }
        }
        return result;

    }



}
