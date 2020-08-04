package de.ibw.tms.co;

import de.ibw.tms.speed.profile.view.SpeedDialog;

import javax.swing.*;

public class Cartesian {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {



            public void run() {
                CartesianDialog frame = new SpeedDialog(null,new JFrame(), null);

            }
        });
    }

}


