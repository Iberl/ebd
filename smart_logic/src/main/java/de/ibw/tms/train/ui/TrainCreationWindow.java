package de.ibw.tms.train.ui;

import de.ibw.tms.MainTmsSim;
import de.ibw.tms.train.model.TrainModel;

import javax.swing.*;

public class TrainCreationWindow extends JDialog {


    private static int iWindowStartX = 100;
    private static int iWindowStartY = 100;
    private static int iWindowWidth = 100;
    private static int iWindowHeight = 100;



    private TrainModel Model;



    public TrainCreationWindow(TrainModel Model) {
    super(MainTmsSim.MainFrame);

        this.Model =  Model;
        JPanel listPane = new JPanel();
        BoxLayout WindowLayout = new BoxLayout(listPane, BoxLayout.Y_AXIS);
            listPane.setLayout(WindowLayout);
            // add
            listPane.add(new JLabel("Fancy Text"));
            //listPane.add(MainTmsSim.genCloseButton(this, "Zug-Erstellen abbrechen"));
            this.add(listPane);
            this.setBounds(iWindowStartX, iWindowStartY, iWindowWidth, iWindowHeight);

            this.setVisible(true);



    }

}
