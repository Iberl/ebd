package de.ibw.history.data;

import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.common.NetworkResource;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import de.ibw.util.DefaultRepo;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class RouteDataSL extends ArrayList<Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological>> {

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
