package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.net.elements.PositionedRelation;

import java.util.List;

public class DoubleSlip extends SlipConnectionPoint {
    private boolean isInlyingType = true;
    private SingleSlip FirstSlipA;
    private SingleSlip SecondSlipB;



    public DoubleSlip(Chainage C) {

        this.FirstSlipA = new SingleSlip(C);
        this.SecondSlipB = new SingleSlip(C);
    }

    public SingleSlip getFirstSlipA() {
        return FirstSlipA;
    }

    public SingleSlip getSecondSlipB() {
        return SecondSlipB;
    }

    public void updatePositionedRelation(List<PositionedRelation> relationList, String sViewNameA, String sViewNameB) {
        /*
        this.FirstSlipA.updatePositionedRelation(relationList.subList(0,2));
        if(sViewNameA != null) {
            this.FirstSlipA.setViewName(sViewNameA);
        }
        this.SecondSlipB.updatePositionedRelation(relationList.subList(2,4));
        if(sViewNameB != null) {
            this.SecondSlipB.setViewName(sViewNameB);
        }

         */
    }


    public void updatePositionedRelation(List<PositionedRelation> relationList) {

        this.updatePositionedRelation(relationList, null, null);
    }

    public void setOutputRelation(PositionedRelation RelA, PositionedRelation RelB) {
        this.FirstSlipA.setOutputRelation(RelA);
        this.SecondSlipB.setOutputRelation(RelB);
    }


    public String getViewNameA() {
       return this.FirstSlipA.getViewName();
    }

    public String getViewNameB() {
        return this.SecondSlipB.getViewName();
    }


    public String getViewName() {
        return this.FirstSlipA.getViewName().concat(" ").concat(this.SecondSlipB.getViewName());
    }
}
