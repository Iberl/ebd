package de.ibw.tms.ui.route.view;

import de.ibw.tms.trackplan.ui.Route;
import de.ibw.tms.ui.route.model.RouteModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RouteModelUI extends JFrame {
    private static RouteModelUI instance = null;
    public static RouteModelUI getInstance(boolean isVisible) {
        if (instance == null) {
            instance = new RouteModelUI();
        }
        instance.setMinimumSize(new Dimension(300, 50));

        if(instance.getRM() == null) {
            instance.setVisible(false);
        } else {
            if(isVisible) {
                instance.updateUI();
            }
            instance.setVisible(isVisible);
        }
        instance.pack();
        return instance;
    }

    private void updateUI() {
        String sName = RM.getsRouteModelName();
        if(sName == null || sName.isEmpty() || sName.equals(RouteModel.CREATE_NEW)) {
            sName = "Route 1";
        }
        this.NameField.setText(sName);
        updateHeading();
        updateEdgeSections();
        updateIntrinsicValue();
        this.validate();
        this.repaint();
    }

    private void updateHeading() {
        String desc = getRouteLabel();
        this.setTitle(desc);
        this.HeadLabel.setText(desc);
    }

    private void updateIntrinsicValue() {
        Route R = RM.getRoute();
        if(R == null) {
            IntrinsicValue.setText("");
        } else {
            double dIntriniscFactor = R.getIntrinsicCoordOfTargetTrackEdge();
            IntrinsicValue.setText(String.valueOf(dIntriniscFactor));
        }
    }

    private void updateEdgeSections() {
        this.EdgeListingArea.setText("");
        if(RM.getRoute() != null) {
            Route R = RM.getRoute();
            List<String> sectionList = R.getElementListIds();
            if(sectionList != null) {
                StringBuilder sections = new StringBuilder();
                for(int i = 0; i < sectionList.size(); i++) {
                    String section = sectionList.get(i);
                    if(i != 0) {
                        sections.append(System.lineSeparator());
                    }
                    sections.append(section);
                }
                this.EdgeListingArea.setText(sections.toString());

            }
        }
    }

    private boolean routeEdgesEditableInText;

    private RouteModel RM = null;

    private JLabel HeadLabel;
    private JButton BottomSubmitButton;
    private JPanel CenterPanel;
    private JLabel NameLabel;
    private JTextField NameField;
    private JLabel EngineLabel;
    private JLabel EngineValue;
    private JLabel EdgeLabel;
    private JTextArea EdgeListingArea;
    private JLabel ChangeEdgeListingLabel;
    private JCheckBox EdgeListEditBox;
    private JLabel RouteLengthLabel;
    private JLabel RouteLengthValue;
    private JLabel IntrinsicLabel;
    private JLabel IntrinsicValue;
    private JLabel IntrinsicLength;
    private JLabel IntrinsicLengthValue;

    private JPanel LeftPanel;
    private JPanel RightPanel;

    private RouteModelUI() {
        super("Route Model");
        this.routeEdgesEditableInText = false;
        String desc = getRouteLabel();
        this.setTitle(desc);
        this.getContentPane().setLayout(new BorderLayout());
        this.HeadLabel = new JLabel(desc);
        this.initCenterPanel();
        this.BottomSubmitButton = new JButton("Save Route-Name");

        this.LeftPanel = new JPanel();
        LeftPanel.setMinimumSize(new Dimension(50,50));
        this.RightPanel = new JPanel();
        RightPanel.setMinimumSize(new Dimension(50,50));

        this.getContentPane().add(LeftPanel, BorderLayout.WEST);
        this.getContentPane().add(RightPanel, BorderLayout.EAST);

        this.getContentPane().add(HeadLabel, BorderLayout.NORTH);
        this.getContentPane().add(CenterPanel, BorderLayout.CENTER);
        this.getContentPane().add(BottomSubmitButton, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

    }

    @NotNull
    private String getRouteLabel() {
        String desc = "Route Model";
        if(RM != null && RM.getsRouteModelName() != null && RM.getsRouteModelName().isEmpty() ) {
            desc = "Route Model " + RM.getsRouteModelName();
        }
        return desc;
    }

    private void initCenterPanel() {

        if(CenterPanel == null) {
            CenterPanel = new JPanel();
            CenterPanel.setLayout(new GridLayout(7,2));
            addCenterUI();

        }


    }

    private void addCenterUI() {
        this.NameLabel = new JLabel("Route Name");
        CenterPanel.add(this.NameLabel);
        this.NameField = new JTextField();
        CenterPanel.add(this.NameField);
        this.EngineLabel = new JLabel("Nid Engine ID");
        CenterPanel.add(this.EngineLabel);
        this.EngineValue = new JLabel();
        CenterPanel.add(this.EngineValue);
        this.EdgeLabel = new JLabel("Gleiskantenbezeichner");
        CenterPanel.add(EdgeLabel);
        this.EdgeListingArea = new JTextArea();
        this.EdgeListingArea.setEditable(false);
        CenterPanel.add(this.EdgeListingArea);
        this.ChangeEdgeListingLabel  = new JLabel("Edit Bezeichnerliste");
        CenterPanel.add(this.ChangeEdgeListingLabel);
        this.EdgeListEditBox = new JCheckBox();
        this.EdgeListEditBox.setSelected(false);
        CenterPanel.add(EdgeListEditBox);
        this.RouteLengthLabel = new JLabel("Routenlänge");
        CenterPanel.add(RouteLengthLabel);
        this.RouteLengthValue = new JLabel();
        CenterPanel.add(this.RouteLengthValue);
        this.IntrinsicLabel = new JLabel("Intrinsic Factor");
        CenterPanel.add(this.IntrinsicLabel);
        this.IntrinsicValue = new JLabel();
        CenterPanel.add(this.IntrinsicValue);
        this.IntrinsicLength = new JLabel("Intrinsische Länge");
        CenterPanel.add(this.IntrinsicLength);
        this.IntrinsicLengthValue = new JLabel("");
        CenterPanel.add(this.IntrinsicLengthValue);


    }

    public RouteModel getRM() {
        return RM;
    }

    public void setRM(RouteModel RM) {
        this.RM = RM;
    }

    public static void main(String[] args) {
        RouteModel RM = new RouteModel("Route B");
        RM.setNid_engineId(3);
        ArrayList<String> sections = new ArrayList<>();
        sections.add("11W10L");
        sections.add("11W11R");
        sections.add("11W12S");
        Route R = new Route(null);
        R.setElementListIds(sections);
        R.setIntrinsicCoordOfTargetTrackEdge(0.5d);
        RM.setRoute(R);

        SwingUtilities.invokeLater(() -> {
            RouteModelUI MUT = RouteModelUI.getInstance(false);
            MUT.setRM(RM);
            RouteModelUI.getInstance(true);
        });
        while(true);
    }


}
