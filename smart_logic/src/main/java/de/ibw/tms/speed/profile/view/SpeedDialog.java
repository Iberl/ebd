package de.ibw.tms.speed.profile.view;

import de.ibw.tms.co.CartesianDialog;
import de.ibw.tms.co.CartesianPanel;
import de.ibw.tms.ma.Route;
import de.ibw.tms.speed.profile.model.CartesianSpeedModel;
import de.ibw.tms.trackplan.MaCreatingFrame;
import de.ibw.tms.trackplan.ui.RouteComponent;
import de.ibw.tms.train.controller.TrainController;
import de.ibw.tms.train.ui.SingleTrainSubPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SpeedDialog extends CartesianDialog {
    public static JFrame Parent = null;
    public static SpeedDialog SpDialog = null;
    CartesianPanel panel;
    private CartesianSpeedModel CSM;

    public static void displaySpeedDialog(CartesianSpeedModel CSM, Route RouteData) {
        JFrame MaFrame =  MaCreatingFrame.CurrentMaCreatingFrame;
        SpDialog = new SpeedDialog(CSM, MaFrame, RouteData);
        SpDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        SpDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                TrainController TC = SingleTrainSubPanel.TrainPanel.getSubController();
                TC.setCSM(RouteComponent.CSM);
                SpDialog.dispose();
            }
        });
        SpDialog.setVisible(true);

    }


    public SpeedDialog(CartesianSpeedModel CSM, JFrame parentFrame, Route RouteData) {
        super(parentFrame, "Speed Dialog");
        this.CSM = CSM;
        Parent = parentFrame;
        SpDialog = this;
        panel = new SpeedPanel(CSM, RouteData);
        this.getContentPane().add(panel);
        setTitle("Speed Profile");
        setSize(700, 700);

        this.setResizable(false);


    }




    public void showUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Speed Profile");
        setSize(700, 700);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {



            public void run() {
                CartesianDialog frame = new SpeedDialog(null, new JFrame(),null);

            }
        });
    }
}
