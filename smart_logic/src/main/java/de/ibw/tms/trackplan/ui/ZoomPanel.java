package de.ibw.tms.trackplan.ui;

import de.ibw.tms.trackplan.controller.ZoomController;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import de.ibw.tms.trackplan.viewmodel.ZoomModel;
import de.ibw.tms.train.model.TrainModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZoomPanel extends JPanel {


    JLabel ZoomXLabel;
    JTextField ZoomXField;

    JLabel ZoomYLabel;
    JTextField ZoomYField;

    JButton ZoomInButton;
    JButton ZoomOutButton;
    JButton ZoomApplyButton;
    JFrame Parent;

    JLabel TrainSlectionLabel;
    JComboBox<TrainModel> TrainBox;
    JButton FocusButton;

    public ZoomPanel(JFrame parentFrame) {
        this.Parent = parentFrame;

        ZoomXLabel = new JLabel("X-Zoom: ");

        ZoomYLabel = new JLabel("Y-Zoom: ");
        JPanel xPanel = new JPanel();
        JPanel yPanel = new JPanel();
        JPanel directZoomPanel = new JPanel();
        JPanel focusTrainPanel = new JPanel();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        genX_ZoomField();
        genY_ZoomField();
        genZoomInButton();
        genZoomOutButton();
        genZoomApplyButton();
        xPanel.add(ZoomXLabel);
        xPanel.add(ZoomXField);
        yPanel.add(ZoomYLabel);
        yPanel.add(ZoomYField);
        directZoomPanel.add(ZoomInButton);
        directZoomPanel.add(ZoomOutButton);

        TrainSlectionLabel = new JLabel("Zugfokus wählen");
        focusTrainPanel.add(TrainSlectionLabel);
        TrainBox = new JComboBox<>();
        FocusButton = new JButton("Focus Train");
        FocusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TrainModel Tm = (TrainModel) TrainBox.getSelectedItem();
                if(true && Tm == null) return;
                ZoomController.getInstance().focusTrain(Tm);
            }
        });

        focusTrainPanel.add(TrainBox);
        focusTrainPanel.add(FocusButton);

        this.add(xPanel);
        this.add(yPanel);
        this.add(directZoomPanel);
        this.add(focusTrainPanel);
        this.add(ZoomApplyButton);

        this.setVisible(true);


    }

    private void genZoomApplyButton() {
        ZoomApplyButton = new JButton("Zoom anwenden");
        ZoomApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ZoomController zController = ZoomController.getInstance();
                zController.applyZoom();
                printMsgUpdateUI();

            }
        });


    }
    private void printMsgUpdateUI() {
        ZoomModel zMod = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        String x = String.valueOf(zMod.getdZoomX());
        String y = String.valueOf(zMod.getdZoomY());
        ZoomXField.setText(x);
        ZoomYField.setText(y);
        if(!zMod.getsInfo().isEmpty()) {
            JOptionPane.showMessageDialog(null, zMod.getsInfo());
        }
    }


    public synchronized void setTrainBoxEntries(Collection<TrainModel> trainModels) {
        List<TrainModel> trainList = new CopyOnWriteArrayList<TrainModel>(trainModels);
        TrainBox.removeAllItems();

        Iterator<TrainModel> it = trainList.iterator();
        while (it.hasNext()) {
            TrainModel value = it.next();
            TrainBox.addItem(value);
        }

    }

    private void genZoomOutButton() {
        ZoomOutButton = new JButton("-");
        ZoomOutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ZoomController zController = ZoomController.getInstance();
                zController.zoomOut();
                printMsgUpdateUI();
            }
        });

    }



    private void genZoomInButton() {
        ZoomInButton = new JButton("+");
        ZoomInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ZoomController zController = ZoomController.getInstance();
                zController.zoomIn();
                printMsgUpdateUI();
            }
        });
    }


    private void genX_ZoomField() {
        ZoomModel zMod = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        String x = String.valueOf(zMod.getdZoomX());
        ZoomXField = new JTextField(x);
        ZoomXField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ZoomController zController = ZoomController.getInstance();
                zController.changeX(ZoomXField.getText());
                printMsgUpdateUI();
            }
        });
    }

    private void genY_ZoomField() {
        ZoomModel zMod = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        String y = String.valueOf(zMod.getdZoomY());
        ZoomYField = new JTextField(y);
        ZoomYField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ZoomController zController = ZoomController.getInstance();
                zController.changeY(ZoomYField.getText());
                printMsgUpdateUI();
            }
        });
    }

}
