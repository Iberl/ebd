package de.ibw.tms.plan_pro.adapter.topology.intf;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;

public interface ChainageSupplyInterface {
    public Chainage getModel(TopologyGraph.Node Key);

}
