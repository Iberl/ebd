package de.ibw.tms.ui.route.model;

import de.ibw.tms.plan.elements.interfaces.IConnectable;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.DefaultRepo;
import plan_pro.modell.geodaten._1_9_0.CGEOKante;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Eine Geographische Karte in dem Trackpanel des TMS
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.10
 * @since 2021-06-23
 *
 */
public class GeoEdgeReference extends Line2D.Double implements Iinteractable, IConnectable {

    public static DefaultRepo<CGEOKante, GeoEdgeReference> ReferenceRepo = new DefaultRepo();

    private TopologyGraph.Edge E = null;
    private CGEOKante GeoE = null;

    @Override
    public String getViewName() {
        return "Beispiel Test";
    }

    @Override
    public ArrayList<JComponent> getViewElements() {
        ArrayList<JComponent> uiList = new ArrayList<JComponent>();
        uiList.add(new JLabel("<HTML><b><u>".concat(this.getViewName()).concat("</u></b></HTML>")));
        uiList.add(new JSeparator(SwingConstants.HORIZONTAL));
        return uiList;
    }

    public void setTopEdge(TopologyGraph.Edge e) {
        this.E = e;
    }

    public void setGeoEdge(CGEOKante geoEdge) {
        this.GeoE = geoEdge;
        ReferenceRepo.update(GeoE, this);
    }

    public TopologyGraph.Edge getE() {
        return E;
    }
}
