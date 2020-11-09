package de.ibw.tms.plan;

import de.ibw.tms.ma.physical.ITrackElement;
import de.ibw.tms.ma.topologie.PositionedRelation;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;

import java.util.ArrayList;
import java.util.List;

public class NodeInformation extends ArrayList<TopologyGraph.Node> implements ITrackElement {

    @Override
    public void updatePositionedRelation(List<PositionedRelation> relationList) {

    }

    @Override
    public List<PositionedRelation> getPositionedRelations() {
        return null;
    }

    @Override
    public String getViewName() {
        return null;
    }
}
