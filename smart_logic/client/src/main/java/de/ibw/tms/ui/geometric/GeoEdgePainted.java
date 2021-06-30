package de.ibw.tms.ui.geometric;

import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class GeoEdgePainted extends Line2D.Double implements Iinteractable {
    TopologyGraph.Edge E = null;

    public static double dRailTolerance = 7.0d;

    GeoEdgePainted(TopologyGraph.Edge Edge) {
        this.E = Edge;
    }

    public TopologyGraph.Edge getTopEdge() {
        return E;
    }

    @Override
    public String getViewName() {
        return E.sId;
    }

    @Override
    public ArrayList<JComponent> getViewElements() {
        ArrayList<JComponent> uiList = new ArrayList<JComponent>();
        uiList.add(new JLabel("<HTML><b><u>".concat(this.getViewName()).concat("</u></b></HTML>")));
        uiList.add(new JSeparator(SwingConstants.HORIZONTAL));
        return uiList;
    }
}
