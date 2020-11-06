package de.ibw.tms.ma.occupation;

import de.ibw.tms.ma.mob.position.SafeMOBPosition;
import de.ibw.tms.ma.positioned.elements.train.MaxSafeFrontEnd;
import de.ibw.tms.ma.positioned.elements.train.MinSafeRearEnd;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import ebd.globalUtils.position.Position;

/**
 * Belegung durch Fahrzeug
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-30
 *
 */
public class VehicleOccupation extends Occupation {
    public static final String CLASS_IDENTIFIER = "Vehicle_Occupation";

    private SafeMOBPosition Position;

    public VehicleOccupation() {
        super(CLASS_IDENTIFIER);
    }
    public VehicleOccupation(TopologyGraph.Edge e, BLOCK_Q_SCALE qScale1m, int i, BLOCK_Q_SCALE qScale1m1, int i1) {
        super(e,qScale1m,i,qScale1m1,i1,CLASS_IDENTIFIER);
    }

    public SafeMOBPosition getPosition() {
        return Position;
    }

    public void setPosition(SafeMOBPosition position) {
        Position = position;
    }

    public MinSafeRearEnd getBegin() {
        return (MinSafeRearEnd) Position.getBegin();
    }
    public MaxSafeFrontEnd getEnd() {
        return (MaxSafeFrontEnd) Position.getEnd();
    }

}
