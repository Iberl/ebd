package de.ibw.tms.ui.route.model;

import de.ibw.tms.plan.elements.interfaces.IConnectable;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.ui.route.controller.RouteController;
import de.ibw.tms.ui.route.view.RouteModelUI;
import de.ibw.tms.ui.route.view.TrackWindow;
import de.ibw.util.DefaultRepo;
import plan_pro.modell.geodaten._1_9_0.CGEOKante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collection;

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
    public static volatile DefaultRepo<Integer, DefaultRepo<CGEOKante, TrainEdgeReference>> TrainRefRepo
            = new DefaultRepo();


    //private TopologyGraph.Edge E = null;
    private GeoEdgeReference GeoRef = null;
    private Integer TrainId = null;

    public static void removeAllRef(int iTrainId) {
        TrainRefRepo.update(iTrainId, new DefaultRepo<>());
    }

    public static Collection<TrainEdgeReference> getAllRefs() {
        ArrayList<TrainEdgeReference> result = new ArrayList<>();
        ArrayList<Integer> trains = TrainRefRepo.getKeys();
        for(Integer iTrain : trains) {
           DefaultRepo<CGEOKante, TrainEdgeReference> allRef = TrainRefRepo.getModel(iTrain);
            if(allRef == null) continue;
            result.addAll(allRef.getAll());

        }
        return result;
    }



    public GeoEdgeReference getGeoRef() {
        return GeoRef;
    }

    public void setGeoRef(GeoEdgeReference geoRef) {
        GeoRef = geoRef;
    }

    @Override
    public String getViewName() {
        return "Fahrerlaubnis ETCS-Train: " + TrainId;
    }

    @Override
    public ArrayList<JComponent> getViewElements() {
        ArrayList<JComponent> uiList = new ArrayList<JComponent>();
        uiList.add(new JLabel("<HTML><b><u>".concat(this.getViewName()).concat("</u></b></HTML>")));
        uiList.add(new JSeparator(SwingConstants.HORIZONTAL));
        uiList.add(generateDrivingbuton());
        return uiList;
    }

    private JButton generateDrivingbuton() {
        JButton result = new JButton("Fahrerlaubnis erstellen");
        result.addActionListener(handleMaStart());
        return result;
    }

    private ActionListener handleMaStart() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RouteController.createMP_Request(TrainId);
            }
        };
    }
    public Integer getTrainId() {
        return TrainId;
    }

    public void setTrainId(Integer trainId) {
        TrainId = trainId;

    }
}
