package de.ibw.tms.ui.route.model;

import de.ibw.tms.plan.elements.interfaces.IConnectable;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Eine Geographische Karte eines Zuges in dem Trackpanel des TMS
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.10
 * @since 2021-06-28
 *
 */
public class TrainEdgeReference extends Line2D.Double implements Iinteractable, IConnectable {

    //public static DefaultRepo<CGEOKante, TrainEdgeReference> ReferenceRepo = new DefaultRepo();

    //private TopologyGraph.Edge E = null;
    private GeoEdgeReference GeoRef = null;
    private Integer TrainId = null;


    public GeoEdgeReference getGeoRef() {
        return GeoRef;
    }

    public void setGeoRef(GeoEdgeReference geoRef) {
        GeoRef = geoRef;
    }

    @Override
    public String getViewName() {
        return "Train Test";
    }

    @Override
    public ArrayList<JComponent> getViewElements() {
        ArrayList<JComponent> uiList = new ArrayList<JComponent>();
        uiList.add(new JLabel("<HTML><b><u>".concat(this.getViewName()).concat("</u></b></HTML>")));
        uiList.add(new JSeparator(SwingConstants.HORIZONTAL));
        return uiList;
    }

    public Integer getTrainId() {
        return TrainId;
    }

    public void setTrainId(Integer trainId) {
        TrainId = trainId;
    }
}
