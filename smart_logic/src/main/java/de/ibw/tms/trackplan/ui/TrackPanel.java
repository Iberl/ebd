package de.ibw.tms.trackplan.ui;

import de.ibw.tms.ma.physical.DoubleSlip;
import de.ibw.tms.ma.physical.SingleSlip;
import de.ibw.tms.ma.physical.SlipConnectionPoint;
import de.ibw.tms.plan.elements.BranchingSwitch;
import de.ibw.tms.plan.elements.interfaces.ITrack;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.trackplan.controller.RouteController;

import javax.swing.*;
import java.util.ArrayList;
/**
 * Panel das innerhalb eines Rechts-Click Dialogs verwendet wird.
 * Betrifft genau ein Element in der Kartenansicht, das sich im Clickbereich befand.
 *
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-12
 */
public class TrackPanel extends javax.swing.JPanel {

    private Iinteractable TrackElementModel = null;

    private static int windowWidth = 150;




    private void setModel(Iinteractable Model) {
        this.TrackElementModel = Model;
    }
    private RouteController RouteCntrl;

    /**
     * Erstellt das Panel zu einem Element das sich in der Kartenansicht in der n&auml;he des Rechtsclick befand.
     * @param Model {@link Iinteractable} - Model des Elments das in diesem Panel verarbeitet wird.
     * @param RoutePort {@link RouteViewPort} - Port um in dieser Komponente Routeninformation der Ma anzupassen
     * @param isMainWindow boolean - ist dieses Panel im Hauptfenster des TMS angesteuer worden
     */
    public TrackPanel(Iinteractable Model, RouteViewPort RoutePort, boolean isMainWindow) {
        super();


        this.setModel(Model);
        ArrayList<JComponent> uiList = TrackElementModel.getViewElements();
        javax.swing.JPanel listPane = new javax.swing.JPanel();
        BoxLayout WindowLayout = new BoxLayout(listPane, BoxLayout.Y_AXIS);
        listPane.setLayout(WindowLayout);
        for(JComponent UiElement: uiList) {
            if(isMainWindow) {
                listPane.add(UiElement);
            }
        }
        if(!isMainWindow) {
            listPane.add(uiList.get(0));
        }

        this.add(listPane);
        this.RouteCntrl = new RouteController(RoutePort);

        if(this.TrackElementModel instanceof BranchingSwitch) {
            BranchingSwitch TrackElement = (BranchingSwitch) this.TrackElementModel;
            SlipConnectionPoint SlipPoint = TrackElement.getBranchingPoint();
            if(SlipPoint instanceof SingleSlip) {
                String desc = "Single Slip";
                if(!isMainWindow) {
                    this.add(new RouteComponent(desc, ((SingleSlip) SlipPoint).getRemotePoint(), this.RouteCntrl));
                }
            } else {
                if(SlipPoint instanceof DoubleSlip) {
                    DoubleSlip DSlip = (DoubleSlip) SlipPoint;
                    String desc = "Double Slip";
                    TrackElement TeA = DSlip.getFirstSlipA().getRemotePoint();
                    TrackElement TeB = DSlip.getSecondSlipB().getRemotePoint();
                    String sDescA = DSlip.getFirstSlipA().getViewName();
                    String sDescB = DSlip.getSecondSlipB().getViewName();
                    if(!isMainWindow) {
                        this.add(new RouteComponent(sDescA, TeA,
                                this.RouteCntrl));
                        this.add(new RouteComponent(sDescB, TeB,
                                this.RouteCntrl));
                    }
                }
            }
        } else {
            if(!isMainWindow) {
                this.add(new RouteComponent(((ITrack) this.TrackElementModel).getTrackReference(), this.RouteCntrl));
            }
        }


    }




}
