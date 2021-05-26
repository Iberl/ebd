package de.ibw.tms.ma.occupation;

import de.ibw.history.TrackAndOccupationManager;
import de.ibw.history.data.ComposedRoute;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.tms.etcs.ETCS_DISTANCE;
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

    public MARequestOccupation(ComposedRoute cr, MovementAuthority movementAuthority, boolean shallStore) {
        super(CLASS_IDENTIFIER);
        new MARequest(movementAuthority, this);
        ETCS_DISTANCE noDistance = new ETCS_DISTANCE();
        noDistance.sDistance = 0;

        try {

            MARequestOccupation temp = (MARequestOccupation) cr.createSubRoute(noDistance, noDistance, 1, this);
            this.setApplicationDirection(temp.getApplicationDirection());
            this.setTrackEdgeSections(temp.getTrackEdgeSections());
        } catch (SmartLogicException e) {
            e.printStackTrace();
        }


        if(shallStore) {
            TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                    MARequestOccupation.class, this);

        }

    }

    /**
     * @Deprecated
     * @param e
     * @param qScale1m
     * @param i
     * @param qScale1m1
     * @param i1
     */
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
