package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.net.elements.PositionedRelation;

import java.util.List;

public class SingleSlip extends SlipConnectionPoint {
    private Point_RemoteOperated RemotePoint;




    public SingleSlip(Chainage C) {
        super();
        //this.setChainageBeginn(C);
        //this.setChainageEnd(C);
        this.RemotePoint = new Point_RemoteOperated(C, null);

    }

    public Point_RemoteOperated getRemotePoint() {
        return RemotePoint;
    }



    public void setOutputRelation(PositionedRelation Relation) {
        this.RemotePoint.setTurnoutNeighbour(Relation);
    }
    public PositionedRelation getOutputRelation() {
        return this.RemotePoint.getTurnoutNeighbour();
    }


    public String getViewName() {
        //if(this.sViewName.equals(" ")) return this.RemotePoint.getViewName();
       // else return this.sViewName;
        return "";
    }


}
