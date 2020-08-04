package de.ibw.tms.trackplan.ui;

import de.ibw.tms.ma.physical.DoubleSlip;
import de.ibw.tms.ma.physical.SingleSlip;
import de.ibw.tms.ma.physical.SlipConnectionPoint;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan.elements.BranchingSwitch;
import de.ibw.tms.plan.elements.interfaces.ITrack;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.trackplan.controller.RouteController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TrackPanel extends javax.swing.JPanel {

    Iinteractable TrackElementModel = null;

    private static int windowWidth = 150;



    public void setLocationPopUp(int x, int y) {
        this.setLocation(x,y);
    }
    public void setModel(Iinteractable Model) {
        this.TrackElementModel = Model;
    }
    private RouteController RouteCntrl;

    public TrackPanel(Iinteractable Model, Point P, RouteViewPort RoutePort, boolean isMainWindow) {
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
                    this.add(new RouteComponent(desc, ((SingleSlip) SlipPoint).getRemotePoint(), this.RouteCntrl, P));
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
                                this.RouteCntrl, P));
                        this.add(new RouteComponent(sDescB, TeB,
                                this.RouteCntrl, P));
                    }
                }
            }
        } else {
            if(!isMainWindow) {
                this.add(new RouteComponent(((ITrack) this.TrackElementModel).getTrackReference(), this.RouteCntrl, P));
            }
        }


    }




}
