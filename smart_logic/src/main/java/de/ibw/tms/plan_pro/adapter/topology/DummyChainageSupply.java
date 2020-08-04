package de.ibw.tms.plan_pro.adapter.topology;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.plan_pro.adapter.topology.intf.ChainageSupplyInterface;

public class DummyChainageSupply implements ChainageSupplyInterface {


    @Override
    public Chainage getModel(TopologyGraph.Node Key) {
        return new Chainage(100);
    }
}
