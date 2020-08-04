package de.ibw.tms.trackplan.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TrackWindow extends JFrame {
    private static int windowWidth = 300;
    private static ArrayList<TrackWindow> instances = new ArrayList<TrackWindow>();
    public static void closeAllTrackWindows() {
        for(TrackWindow Window: instances) {
            Window.dispatchEvent(new WindowEvent(Window, WindowEvent.WINDOW_CLOSING));
        }
        instances = new ArrayList<TrackWindow>();
    }


    public TrackWindow(List panels, Point P, boolean isMainWindow) {

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
        instances.add(this);
    }

}
