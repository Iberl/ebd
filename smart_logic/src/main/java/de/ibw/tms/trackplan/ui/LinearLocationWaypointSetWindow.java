package de.ibw.tms.trackplan.ui;

import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.trackplan.controller.RouteController;
import de.ibw.tms.train.model.TrainModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Verwaltet Distanzfeld des Routenendes auf dem letzten Gleis einer topologischen Kante.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-11
 */
public class LinearLocationWaypointSetWindow extends JDialog {
    private RouteController RouteController;
    private JLabel StatusLabel = new JLabel("",JLabel.CENTER);

    /**
     * Erstellt den Dialog mit Schiebebalken
     * @param TE - Letzte Element der Route der MA
     * @param Frame - Zu welchen Frame wird der Dialog gesetzt.
     * @param P - Position dieses Dialoges
     * @param RC {@link RouteController} - Verwaltung falls neue Route angelegt wird
     * @param startingPointTrain  {@link TrainModel} - Zug zu dieser MA
     */
    public LinearLocationWaypointSetWindow(TrackElement TE, JFrame Frame, Point P, RouteController RC, TrainModel startingPointTrain) {

        super(Frame, "Set Linear Waypoint", true);



        this.setUndecorated(true);
        this.RouteController = RC;
        int windowWidth = 210;
        javax.swing.JPanel listPane = new javax.swing.JPanel();
        BoxLayout WindowLayout = new BoxLayout(listPane, BoxLayout.Y_AXIS);
        listPane.setLayout(WindowLayout);
        JSlider ChainageSlider = new JSlider();



        Rail R = (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(TE);
        double dTrackLength = R.getEdge().dTopLength;
        double dMinimum = RouteComponent.calcTrackLengthUntilLastWayoint(startingPointTrain);
        double dMax = dMinimum + dTrackLength;
        if(startingPointTrain.getEdgeTrainStandsOn().getRail().getTrailModel() == TE) {

            dMinimum = 0;
            dMax = startingPointTrain.getdDistanceToNodeRunningTo();
        }



        // länge des Tracks bestimmen



        ChainageSlider.setMinimum((int) Math.floor(dMinimum) +1);
        ChainageSlider.setMaximum((int) dMax);
        ChainageSlider.setValue((int) Math.floor(dMinimum) +1 );
        StatusLabel.setText("Chainage Value: " + ChainageSlider.getValue());
        ChainageSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                LinearLocationWaypointSetWindow.this.StatusLabel.setText("Chainage Value : " + ((JSlider)e.getSource()).getValue());
            }
        });
        listPane.add(new JLabel("Set Chainage"));
        listPane.add(ChainageSlider);
        listPane.add(StatusLabel);

        JButton SubmitButton = new JButton("Add Location");
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LinearLocationWaypointSetWindow.this.getRouteModel().setEndSpot(TE, ChainageSlider.getValue());


                LinearLocationWaypointSetWindow.this.RouteController.publish();
                LinearLocationWaypointSetWindow.this.dispose();
            }
        });
        listPane.add(SubmitButton);
        getContentPane().add(listPane);
        this.pack();
        this.setBounds(P.x, P.y, windowWidth,400);

        this.setVisible(true);

    }


    /**
     * Holt Route zu diesem Dialog
     * @return Route
     */
    public Route getRouteModel() {
        return this.RouteController.getRouteData();
    }
}
