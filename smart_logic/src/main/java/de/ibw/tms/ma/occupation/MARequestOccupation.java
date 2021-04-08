package de.ibw.tms.ma.occupation;

import de.ibw.tms.ma.MARequest;
import de.ibw.tms.ma.MovementAuthority;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.occupation.intf.IMoveable;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;

public class MARequestOccupation extends Occupation implements IMoveable {
    public static final String CLASS_IDENTIFIER = "MA_Request_Occupation";

    private MARequest R;

    public MARequestOccupation() {
        super(CLASS_IDENTIFIER);
    }



    public MARequestOccupation(TopologyGraph.Edge e, BLOCK_Q_SCALE qScale1m, int i, BLOCK_Q_SCALE qScale1m1, int i1) {
        super(e,qScale1m,i,qScale1m1,i1,CLASS_IDENTIFIER);
    }

    public MARequest getR() {
        return R;
    }

    public void setR(MARequest r) {
        R = r;
    }

    @Override
    public MovableObject getTargetMoveableObject() {
        if(R == null) return null;
        if(R.ma == null) return null;
        return R.ma.getMOB();
    }
}
