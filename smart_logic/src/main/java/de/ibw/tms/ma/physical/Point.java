package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.net.elements.PositionedRelation;

public class Point extends BranchingElement {
    private PointType type;
    private int turnaroundLength;
    private int turnaroundGradient;
    private PositionedRelation TurnoutNeighbour;

    public Point(PointType type, int turnaroundLength, int turnaroundGradient, PositionedRelation turnoutNeighbour) {
        this.type = type;
        this.turnaroundLength = turnaroundLength;
        this.turnaroundGradient = turnaroundGradient;
        TurnoutNeighbour = turnoutNeighbour;
    }
    public Point(PositionedRelation TurnRelation) {
        this.type = PointType.REMOTE_OPERATED;
        this.turnaroundLength = 3;
        this.turnaroundGradient = 3;
        TurnoutNeighbour = TurnRelation;
    }

    public PositionedRelation getTurnoutNeighbour() {
        return TurnoutNeighbour;
    }

    public void setTurnoutNeighbour(PositionedRelation turnoutNeighbour) {
        TurnoutNeighbour = turnoutNeighbour;
    }

}
