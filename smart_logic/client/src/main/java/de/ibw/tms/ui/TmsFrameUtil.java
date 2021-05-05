package de.ibw.tms.ui;

import de.ibw.tms.MainTmsSim;
import de.ibw.tms.entities.TmsJpaApp;
import de.ibw.tms.ui.TrackController;
import de.ibw.tms.trackplan.ui.MainGraphicPanel;
import de.ibw.tms.trackplan.ui.ZoomFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class TmsFrameUtil {

    private static ZoomFrame zoomFrame = null;
    private static MainGraphicPanel TrackPanel = null;
    private static Flow.Subscription MaSubscription;



    private static JPanel addCommandPanel() {
        JPanel CommandPanel = new JPanel();
        JButton RequestMaButton = new JButton("MA beantragen");
        RequestMaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TrackController.getInstance(null).requestMaAction();
            }
        });
        CommandPanel.add(RequestMaButton);
        JButton EditMaButton = new JButton("MA bearbeiten");
        EditMaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TrackController.getInstance(null).editMaAction();
            }
        });
        CommandPanel.add(EditMaButton);
        JButton DeleteMaButton = new JButton("MA löschen");
        DeleteMaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TrackController.getInstance(null).deleteMaAction();
            }
        });
        TmsJpaApp.TmsFramer.tmsFrame.getContentPane().add(CommandPanel, BorderLayout.SOUTH);
        return CommandPanel;
    }

    /**
     * Erstellt das Hauptfenster des TMS
     * @return JFrame
     */
    public static JFrame createTmsFrame() {
        JFrame frame = new JFrame("TMS SIM");
        frame.getContentPane().setLayout(new BorderLayout());
        TmsJpaApp.TmsFramer.tmsFrame = frame;

           frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            addCommandPanel();
            zoomFrame = ZoomFrame.getZoomFrame();
        String className = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
            return null;
        }

        //frame.setLayout(new GridBagLayout());
        //GridBagConstraints c = new GridBagConstraints();
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.ipady = 100;      //make this component tall
//
//        c.weighty = 1.0;
//        c.gridwidth = 1;
//        c.gridx = 0;
//        c.gridy = 0;

        TrackPanel = new MainGraphicPanel();

        frame.getContentPane().add(TrackPanel);

        frame.setSize(700, 550);

        frame.setVisible(true);
        return frame;
    }

    public static void updateFrame() {
        TmsJpaApp.TmsFramer.tmsFrame.revalidate();
        updateSubViews();
    }

    /**
     * Horcht auf Befehl neuzuzeichnen
     */
    public static Flow.Subscriber<String> MainSubscriber = new Flow.Subscriber<String>() {
        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            MaSubscription = subscription;
            MaSubscription.request(1);
        }

        @Override
        public void onNext(String planData) {



            MaSubscription.request(1);
            TmsJpaApp.TmsFramer.tmsFrame.revalidate();
            updateSubViews();

        }




        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {

        }
    };
    public static void updateSubViews() {
        if(TrackPanel != null) TrackPanel.repaint();
    }

}
