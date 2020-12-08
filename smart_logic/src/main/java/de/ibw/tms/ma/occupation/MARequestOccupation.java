package de.ibw.tms.ma.occupation;

import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;

public class MARequestOccupation extends Occupation {
    public static final String CLASS_IDENTIFIER = "MA_Request_Occupation";

    public MARequestOccupation() {
        super(CLASS_IDENTIFIER);
    }

    public MARequestOccupation(TopologyGraph.Edge e, BLOCK_Q_SCALE qScale1m, int i, BLOCK_Q_SCALE qScale1m1, int i1) {
        super(e,qScale1m,i,qScale1m1,i1,CLASS_IDENTIFIER);
    }
}
