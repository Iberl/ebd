package de.ibw.tms.trackplan;

import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.train.ui.TrainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MaCreatingFrame extends JFrame {

    public static MaCreatingFrame CurrentMaCreatingFrame = null;
    private MaRequestWrapper Request;
    private TrackplanGraphicPanel TrackPanel;
    private JFrame MainFrame;

    public MaCreatingFrame(MaRequestWrapper MovementAuthRequest, JFrame MainFrame) {
        super("MA beantragen");
        this.MainFrame = MainFrame;

        Request = MovementAuthRequest;

        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        TrackPanel = new TrackplanGraphicPanel(Request);

        this.add(TrackPanel);
        MaCreatingFrame.CurrentMaCreatingFrame = this;





        TrainPanel trainPanel = new TrainPanel(this, TrackPanel, Request);
        this.add(trainPanel,BorderLayout.SOUTH);

        this.setSize(700, 350);

        this.MainFrame.setVisible(false);
        addCloseHandler();
        this.setVisible(true);
    }

    protected void addCloseHandler() {
        this.addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {
                MaCreatingFrame.this.MainFrame.setVisible(true);
            }
        });
    }

    public static void main(String args[]) {
        new MaCreatingFrame(new MaRequestWrapper(null), new JFrame());
    }


}
