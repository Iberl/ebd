package de.ibw.tms.trackplan.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
/**
 * Neuer Frame der alle Elementbearbeitungs-Optionen bei Rechtsclick in der Streckenansicht wiedergibt.
 *
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-08-26
 */
public class TrackWindow extends JDialog {
    private static int windowWidth = 300;
    private static ArrayList<TrackWindow> instances = new ArrayList<TrackWindow>();




    /**
     * Entfernt alle Rechtsclck-Fenster
     */
    public static void closeAllTrackWindows() {
        for(TrackWindow Window: instances) {
            if(Window == null) continue;
            Window.dispose();
            Window.setVisible(false);

        }
        instances = new ArrayList<TrackWindow>();
    }

    /**
     * Erstellt ein Rechtsclick-Fenster
     * @param panels {@link List} eine Liste von Panels je element im Clickbereich.
     * @param P {@link Point} Punkt der im Streckenfester geclickt wurde.
     */
    public TrackWindow(JFrame frame, List panels, Point P) {
        super(frame, "Track Options", true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


        javax.swing.JPanel listPane = new javax.swing.JPanel();
        BoxLayout WindowLayout = new BoxLayout(listPane, BoxLayout.Y_AXIS);
        listPane.setLayout(WindowLayout);
        for(Object UiElement: panels) {
            listPane.add((Component) UiElement);
        }

        this.add(listPane);
        //listPane.add(MainTmsSim.genCloseButton(this, "schließen"));

        this.pack();
        this.setBounds(P.x, P.y, windowWidth,400);

        this.setVisible(true);

    }

}
