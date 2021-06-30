package de.ibw.tms.ui.route.model;

import de.ibw.tms.plan.elements.interfaces.IConnectable;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.ui.route.controller.RouteController;
import de.ibw.tms.ui.route.view.RouteModelUI;
import de.ibw.tms.ui.route.view.TrackWindow;
import de.ibw.util.DefaultRepo;
import org.railMl.rtm4rail.Contractor;
import plan_pro.modell.geodaten._1_9_0.CGEOKante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
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
        return "Topologische Kante: ";
    }

    @Override
    public ArrayList<JComponent> getViewElements() {
        RouteModel RM = RouteModel.routeRepository.getModel(RouteModel.FD_ROUTE);
        if(RM == null) {
            return new ArrayList<>();
        }
        try {
            RM.checkIfEdgeAddableToRoute(E);
            ArrayList<JComponent> uiList = new ArrayList<JComponent>();
            uiList.add(new JLabel("<HTML><b><u>".concat(this.getViewName())
                    .concat(E.getRefId()).concat("</u></b></HTML>")));
            uiList.add(new JSeparator(SwingConstants.HORIZONTAL));
            uiList.add(generateAddButon());
            return uiList;
        } catch(InvalidParameterException IPE) {
            return new ArrayList<>();
        }

    }

    private JButton generateAddButon() {
        JButton result = new JButton("Gleiskante hinzufügen");
        result.addActionListener(handleAddEvent());
        return result;
    }

    private ActionListener handleAddEvent() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RouteController.addEdge(E);
            }
        };
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
