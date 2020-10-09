package de.ibw.tms.train.ui;

import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.trackplan.TrackplanGraphicPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Das Panel beinhaltet die Kartenansicht einer neuen MA Erstellung.
 * Und auch das Panel darunter, dass Zugdaten verwaltet.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public class TrainPanel extends JPanel {



    private JFrame ParentFrame;
    private SingleTrainSubPanel TrainSubPanel;
    private TrackplanGraphicPanel TrackPanel;
    private MaRequestWrapper R;

    /**
     * Erstellt vom Hauptfenster zum Editiieren einer MA ein neues Fenster.
     * @param frame {@link JFrame} -  Der Frame des Hauptfensters
     * @param trackPanel {@link TrackplanGraphicPanel} - Die Zeichenfl&auml;che oder Karte.
     * @param Request {@link MaRequestWrapper} - Der Request der durch diese UI vom Nutzer erstellt wird.
     */
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
