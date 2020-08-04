package de.ibw.tms.plan.elements;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.physical.Trail;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.plan.elements.interfaces.IConnectable;
import de.ibw.tms.plan.elements.interfaces.ITrack;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class Rail extends Line2D.Double implements Iinteractable, ITrack {

    public static double dRailTolerance = 2.0d;

    public String segmentName = " ";
    private TopologyGraph.Edge Edge;

    public TopologyGraph.Edge getEdge() {
        return Edge;
    }

    public void setEdge(TopologyGraph.Edge edge) {
        Edge = edge;
    }

    public int iStroke = 3;

    private Trail TrailModel;

    public Trail getTrailModel() {
        return TrailModel;
    }

    public IConnectable ConA;
    public IConnectable ConB;

    public Rail(float x1, float y1, float x2, float y2) {
        super(x1 *PlanData.f_STRETCH_X, y1, x2 * PlanData.f_STRETCH_X,
                y2);
    }

    @Deprecated
    public Rail(ElementConnectionPoint LeftPoint, ElementConnectionPoint RightPoint, ArrayList<Rail> addTo,
                Chainage C,  ApplicationDirection Navigal, int vmax, ApplicationDirection Direction, TrackElementStatus Status){
        super(LeftPoint.x, LeftPoint.y, RightPoint.x, RightPoint.y);
        addTo.add(this);

        if(y1 == y2) {
            this.iStroke = 10;
        }


    }


    public Rail(double x1, double y1, double x2, double y2, List<Rail> addTo, IConnectable IConA, IConnectable IConB,
                Chainage Cb, Chainage Cc,  ApplicationDirection Navigal, int vmax, ApplicationDirection Direction, TrackElementStatus Status,
                String sectionName
    ) {
        this(x1,y1,x2,y2,addTo,IConA, IConB,Cb, Cc, Navigal, vmax, Direction, Status);
        this.segmentName = sectionName;

    }

    public Rail(double x1, double y1, double x2, double y2, List<Rail> addTo, IConnectable IConA, IConnectable IConB,
         Chainage Cb, Chainage Cc,  ApplicationDirection Navigal, int vmax, ApplicationDirection Direction, TrackElementStatus Status
    ) {
        super(x1 , y1, x2 ,  y2 );
        addTo.add(this);

        if(y1 == y2) {
            this.iStroke = 10;
        }

        ConA = IConA;
        ConB = IConB;
        TrailModel = new Trail(Cb, Cc, (TrackElement) ConA, (TrackElement) ConB, Navigal, vmax, Direction,  Status);
        PlanData.TrackElementPositionCalc.put(TrailModel, this);
    }

    public double getXatPort(boolean isPortA) {
        if(isPortA) return this.x1;
        else return this.x2;
    }
    public double getYatPortA(boolean isPortA) {
        if(isPortA) return this.y1;
        else return this.y2;
    }


    @Override
    public ArrayList<JComponent> getViewElements() {
        ArrayList<JComponent> uiList = new ArrayList<JComponent>();
        uiList.add(new JLabel("<HTML><b><u>".concat(this.getViewName()).concat("</u></b></HTML>")));
        uiList.add(new JSeparator(SwingConstants.HORIZONTAL));
        return uiList;
    }

    @Override
    public String getViewName() {
        return "Rail";
    }

    @Override
    public TrackElement getTrackReference() {
        return this.getTrailModel();
    }
}
