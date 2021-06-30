package de.ibw.tms.ui.route.view;

import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.ui.route.controller.RouteController;
import de.ibw.tms.ui.route.model.EndTrainIntrinsicCoordModel;
import de.ibw.tms.ui.route.model.RouteModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Dialog der die Intrinsische Laenge der Fahrt auf der letzten Kante ermittelt
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.10
 * @since 2021-06-30
 *
 */
public class IntriniscCoordView {

    private JLabel HeadLabel;

    private JPanel CenterPanel;
    private JLabel RefNodeLabel;
    private JLabel EndNodeLabel;
    private JSlider MeterSlider;

    private JLabel MeterLabel;
    private JTextField MeterField;
    private JLabel IntrinsicLabel;
    private JTextField IntrinsicField;

    private JPanel NordPanel;
    private JPanel LeftPanel;
    private JPanel RightPanel;

    private EndTrainIntrinsicCoordModel EndTrainModel;
    private TopologyGraph.Edge ScopedEdge;
    private JDialog dialog = null;

    /**
     * Konstruktor des Dialogs
     * @param parent - Aurufender Routen Frame
     * @param Model - Model Intrinsischen Koordinate
     */
    public IntriniscCoordView(JFrame parent, EndTrainIntrinsicCoordModel Model) {
        dialog = new JDialog(parent);
        EndTrainModel = Model;

        RouteController.Current = this;

        ScopedEdge = Model.getLastEdge();
        String sId = ScopedEdge.getRefId();

        if(Model.isAbsoluteMode()) {
            dialog.setTitle("Define End-Point on " + sId + " (Absolute Mode)");
        } else {
            dialog.setTitle("Define End-Point on " + sId + " (Normaler Mode)");
        }
        dialog.getContentPane().setLayout(new BorderLayout());

        this.HeadLabel = new JLabel("End Coordinate on " + sId);

        this.initCenterPanel();
        this.initNordPanel();


        this.LeftPanel = generateBorderPanel();
        this.RightPanel = generateBorderPanel();

        dialog.getContentPane().add(LeftPanel, BorderLayout.WEST);
        dialog.getContentPane().add(RightPanel, BorderLayout.EAST);



        dialog.getContentPane().add(NordPanel, BorderLayout.NORTH);
        dialog.getContentPane().add(CenterPanel, BorderLayout.CENTER);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(parent);
        dialog.setModal(true);
        dialog.pack();
        dialog.setVisible(true);

    }

    private void initNordPanel() {
        if(NordPanel == null) {
            NordPanel = new JPanel();

            NordPanel.setLayout(new BorderLayout());
            NordPanel.add(generateBorderPanel(), BorderLayout.EAST);
            NordPanel.add(generateBorderPanel(), BorderLayout.WEST);
            createNordCenterUi();


        }
    }

    private void createNordCenterUi() {
        JPanel NordMainPanel = new JPanel();
        NordMainPanel.setLayout(new GridLayout(4, 1));
        this.HeadLabel = new JLabel("End Coordinate on " + ScopedEdge.getRefId());
        TopologyGraph.Node RefNode = this.EndTrainModel.getNodeBasedForIntrinsicCoord();
        TopologyGraph.Node OppositeNode = this.ScopedEdge.A.equals(RefNode) ? this.ScopedEdge.B : this.ScopedEdge.A;
        this.RefNodeLabel = new JLabel("Start-Knoten: " + RefNode.name);
        this.EndNodeLabel = new JLabel("Ziel-Knoten: " + OppositeNode.name);
        int iCurrentMeter = EndTrainModel.getIntrinsicCoordSelected().multiply(
                BigDecimal.valueOf(ScopedEdge.dTopLength)).intValue();
        this.MeterSlider = new JSlider(JSlider.HORIZONTAL,0, (int) ScopedEdge.dTopLength,iCurrentMeter);
        MeterSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(!MeterSlider.getValueIsAdjusting()) {
                    int iMeter = ((JSlider) e.getSource()).getValue();
                    RouteController.updateIntrinsic(iMeter);
                }
            }
        });
        NordMainPanel.add(HeadLabel);
        NordMainPanel.add(RefNodeLabel);
        NordMainPanel.add(EndNodeLabel);
        NordMainPanel.add(MeterSlider);
        this.NordPanel.add(NordMainPanel, BorderLayout.CENTER);
    }

    private JPanel generateBorderPanel() {
        JPanel BorderPanel = new JPanel();
        BorderPanel.setMinimumSize(new Dimension(50,50));
        return BorderPanel;
    }

    private void initCenterPanel() {
        if(CenterPanel == null) {
            int iCurrentMeter = EndTrainModel.getIntrinsicCoordSelected().multiply(
                    BigDecimal.valueOf(ScopedEdge.dTopLength)).intValue();
            CenterPanel = new JPanel();
            CenterPanel.setLayout(new GridLayout(2,2));
            MeterLabel = new JLabel("Target Meter: ");
            CenterPanel.add(MeterLabel);
            MeterField = new JTextField(iCurrentMeter);
            MeterField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String sMeter = MeterField.getText();
                    RouteController.setIntrinsicViaMeter(sMeter);
                }
            });
            CenterPanel.add(MeterField);
            IntrinsicLabel = new JLabel("Target Intrinisic-Factor: ");
            CenterPanel.add(IntrinsicLabel);
            IntrinsicField = new JTextField(String.valueOf(EndTrainModel.getIntrinsicCoordSelected()));
            IntrinsicField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String sIntrin = IntrinsicField.getText();
                    RouteController.setIntrinsic(sIntrin);
                }
            });
            CenterPanel.add(IntrinsicField);

        }
    }

    /**
     * zeichnet den Dialog neu unter Bezug auf die Modelle
     */
    public void updateUI() {
        RouteModel RM = RouteModel.routeRepository.getModel(RouteModel.FD_ROUTE);
        this.EndTrainModel = new EndTrainIntrinsicCoordModel(RM);
        int iCurrentMeter = EndTrainModel.getIntrinsicCoordSelected().multiply(
                BigDecimal.valueOf(ScopedEdge.dTopLength)).intValue();
        TopologyGraph.Node RefNode = this.EndTrainModel.getNodeBasedForIntrinsicCoord();
        TopologyGraph.Node OppositeNode = this.ScopedEdge.A.equals(RefNode) ? this.ScopedEdge.B : this.ScopedEdge.A;
        this.RefNodeLabel.setText("Start-Knoten: " + RefNode.name);
        this.EndNodeLabel.setText("Ziel-Knoten: " + OppositeNode.name);
        this.MeterSlider.setValue(iCurrentMeter);
        this.MeterField.setText(String.valueOf(iCurrentMeter));
        this.IntrinsicField.setText(EndTrainModel.getIntrinsicCoordSelected().toString());

    }

    /**
     * schliest den Dialog
     */
    public void dispose() {
        if(dialog != null) dialog.dispose();
    }

}
