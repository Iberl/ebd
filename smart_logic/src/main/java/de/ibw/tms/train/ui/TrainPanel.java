package de.ibw.tms.train.ui;

import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.trackplan.TrackplanGraphicPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TrainPanel extends JPanel {

    ArrayList<SingleTrainSubPanel> subPanelList = new ArrayList();
    BoxLayout SubPanelLayout;
    JFrame ParentFrame;
    SingleTrainSubPanel TrainSubPanel;
    TrackplanGraphicPanel TrackPanel;
    MaRequestWrapper R;

    public TrainPanel(JFrame frame, TrackplanGraphicPanel trackPanel, MaRequestWrapper Request) {
        super();
        this.ParentFrame = frame;
        this.TrackPanel = trackPanel;
        this.R = Request;

        //this.TrackPanel = new TrackplanGraphicPanel();


        //this.add(new SingleTrainSubPanel());
        //CartesianPanel P = new CartesianPanel();
        //this.add(P);


        JButton NewTrainButton = new JButton("Neuer Zug");
        NewTrainButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                /* to change
                SingleTrainSubPanel TrainSubPanel =

                // TrainPanel.this.add(TrainSubPanel);
                subPanelList.add(TrainSubPanel);
                MainTmsSim.MainFrame.revalidate();
                */

            }
        });

        //this.add(this.TrackPanel);
        this.setVisible(true);
        //this.setBorder(BorderFactory.createEmptyBorder(500,0,0,0));
        this.TrainSubPanel = new SingleTrainSubPanel(TrackPanel, this.ParentFrame);
        this.add(TrainSubPanel);
        this.add(NewTrainButton);






    }


}
