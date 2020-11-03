package de.ibw.tms.plan.elements.interfaces;

import de.ibw.tms.plan.NodeInformation;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;

public interface ISwitchHandler {
    NodeInformation getNodeInfoBySwitchId(String switchId);
    String getNodeId(TopologyGraph.Node N);

    void registerNode(TopologyGraph.Node N, String switchId);

}
