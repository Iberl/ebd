package de.ibw.tms.plan_pro.adapter;

import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import plan_pro.modell.geodaten._1_9_0.CGEOKante;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlanProTmsAdapterTest {


    void createTopology() {
        int iGeo = 0;
        int iTopGeo = 0;
        PlanData.getInstance();
        PlanProTmsAdapter Adapter = PlanProTmsAdapter.getPlanAdapter();
        Collection GeoEdgeCol = Adapter.geoBundle.getModel(CGEOKante.class).getAll();
        iGeo = GeoEdgeCol.size();
        Collection<TopologyGraph.Edge> TopEdgeCol = PlanData.topGraph.edgeRepo.values();
        for(TopologyGraph.Edge E : TopEdgeCol) {
            if(E.getPaintListGeo() == null) continue;
            iTopGeo += E.getPaintListGeo().size();
        }
        assertEquals(iGeo, iTopGeo);
    }
}