package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.ma.topologie.PositionedRelation;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.model.PlanData;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class Trail extends FlankAreaElement {




    private PositionedRelation createRelation(TrackElement FromElement, TrackElement ToElement, boolean bNavigable, int vmax,
                                ApplicationDirection Direction, TrackElementStatus Status) {
        PositionedRelation Relation = new PositionedRelation();
        Relation.createPositionedRelation(this, FromElement, ToElement, bNavigable, vmax,
                Direction, Status);
        return Relation;
    }

    public Trail(Chainage BegC, Chainage EndC, TrackElement Tfrom, TrackElement ToElement, ApplicationDirection NavigableDirection, int vmax,
                 ApplicationDirection RelationDirection, TrackElementStatus Status) {
        ArrayList relationList = new ArrayList();
        this.setChainageBeginn(BegC);
        this.setChainageEnd(EndC);

        if(RelationDirection == ApplicationDirection.BOTH) {
            addNominal(Tfrom, ToElement, NavigableDirection, vmax, Status, relationList);
            addReverse(Tfrom, ToElement, NavigableDirection, vmax, Status, relationList);

        } else if (RelationDirection == ApplicationDirection.NOMINAL) {
            addNominal(Tfrom, ToElement, NavigableDirection, vmax, Status, relationList);

        } else if(RelationDirection == ApplicationDirection.REVERSE) {

            addReverse(Tfrom, ToElement, NavigableDirection, vmax, Status, relationList);
        }
        this.updatePositionedRelation(relationList);

    }

    public Rail getRail() {
        return (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(this);
    }
    public String getPlanProId() {
        return this.getRail().getEdge().getPlanProEdge().getIdentitaet().getWert();
    }

    private void addReverse(TrackElement Tfrom, TrackElement ToElement, ApplicationDirection NavigableDirection, int vmax, TrackElementStatus Status,  ArrayList relationList) {
        boolean bNavigable;
        bNavigable = NavigableDirection == ApplicationDirection.BOTH ||
                NavigableDirection == ApplicationDirection.REVERSE;
        relationList.add(createRelation(ToElement, Tfrom, bNavigable, vmax, ApplicationDirection.REVERSE, Status));
    }

    private void addNominal(TrackElement Tfrom, TrackElement ToElement, ApplicationDirection NavigableDirection, int vmax, TrackElementStatus Status, ArrayList relationList) {
        boolean bNavigable = NavigableDirection == ApplicationDirection.BOTH ||
                NavigableDirection == ApplicationDirection.NOMINAL;


        relationList.add(createRelation(Tfrom,ToElement, bNavigable, vmax,  ApplicationDirection.NOMINAL, Status));
    }

    @Override
    public String getViewName() {
        List relationList = this.getPositionedRelations();
        PositionedRelation PositionA = (PositionedRelation) relationList.get(0);
        TrackElement FromElement = PositionA.getFrom();
        TrackElement ToElement = PositionA.getTo();

        return FromElement.getViewName().concat(" ").concat(ToElement.getViewName());
    }
    @Override
    public String toString() {
        try {

            return this.getViewName();
        } catch(Exception E) {
            Line2D.Double Coord = PlanData.TrackElementPositionCalc.translateTeToGraphic(this);
            int ix1 = (int) Coord.x1;
            int ix2 = (int) Coord.x2;
            int iy1 = (int) Coord.y1;
            int iy2 = (int) Coord.y2;
            return "x1:" + ix1 + "y1:" + iy1 + "x2:" + ix2 + "y2:" + iy2;

        }

    }


}
