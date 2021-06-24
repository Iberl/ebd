package de.ibw.tms.ui.route.view;

import de.ibw.tms.trackplan.ui.Route;
import de.ibw.tms.ui.route.model.RouteModel;

import javax.swing.*;
import java.awt.*;

public class RouteManager extends JFrame {
    private static RouteManager instance = null;
    public static RouteManager getInstance(boolean isVisible) {
        if(instance == null) {
            instance = new RouteManager();
        }
        instance.setMinimumSize(new Dimension(300, 50));
        instance.pack();
        instance.setVisible(isVisible);

        return instance;
    }

    private JLabel HeadLabel;
    private JComboBox<RouteModel> routeChooser;


    private RouteManager() {
        super("TMS Route Manager");
        this.getContentPane().setLayout(new BorderLayout());
        this.HeadLabel = new JLabel("Select Route for edit");
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        routeChooser = new JComboBox<>();

        initRouteChooser();
        this.getContentPane().add(this.HeadLabel, BorderLayout.NORTH);
        this.getContentPane().add(this.routeChooser);


    }

    private void initRouteChooser() {
        routeChooser.removeAllItems();
        for(RouteModel R : RouteModel.routeRepository.getAll()) {
            routeChooser.addItem(R);
        }
        RouteModel EmptyModel = new RouteModel(RouteModel.CREATE_NEW);
        routeChooser.addItem(EmptyModel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RouteModel.routeRepository.update("Route A", new RouteModel("Route A"));
            RouteModel.routeRepository.update("Route B", new RouteModel("Route B"));
            RouteManager.getInstance(true);
        });
        while(true) {

        }

    }

}
