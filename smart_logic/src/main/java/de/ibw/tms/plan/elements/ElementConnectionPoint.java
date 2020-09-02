package de.ibw.tms.plan.elements;

import de.ibw.tms.plan.elements.interfaces.IConnectable;
import de.ibw.tms.plan.elements.model.PlanData;

import java.awt.geom.Point2D;
import java.util.ArrayList;

@Deprecated
public class ElementConnectionPoint extends Point2D.Double {

        // usualy two Rails
        private ArrayList<Rail> connectedRailList = new ArrayList<Rail>();


        public void removeConnection(Rail R) {
            connectedRailList.remove(R);
        }

        public ArrayList<Rail> getRails() {
            return connectedRailList;
        }


        public ElementConnectionPoint(double x, double y, IConnectable isComposit) {
           super(x,y);
        }
        public ElementConnectionPoint(float x, float y ){
            super(x * PlanData.f_STRETCH_X, PlanData.f_PAINT_AREA_HEIGHT - y);
        }

        public Boolean isLeftOf(ElementConnectionPoint compareToPoint) {
            if(this.x < compareToPoint.x) return true;
            else if(this.x > compareToPoint.x) return false;
            return null;

        }


}
