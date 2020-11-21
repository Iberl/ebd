package de.ibw.tms;

import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.tms.intf.SmartClient;
import de.ibw.tms.intf.SmartClientHandler;
import de.ibw.tms.trackplan.controller.TrackController;
import de.ibw.tms.trackplan.ui.MainGraphicPanel;
import de.ibw.tms.trackplan.ui.ZoomFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Flow;
/**
 * Diese Klasse ist der Main-Entry-Point des TMS.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-09-01
 */
public class MainTmsSim {

    /**
     * Status von Modus bisher nur Normal
     */
    public enum TmsMode {
        Normal
    }

    /**
     * Id dieses TMS
     */
    public static String S_TMS_ID = "1";
    /**
     * Das Haupfenster
     */
    public static JFrame MainFrame = null;
    private static ZoomFrame zoomFrame = null;
    /**
     * Panels von UIs beantragter MAs
     */
    public static ArrayList<JPanel> trackPanelRepository = new ArrayList<>();
    /**
     * Horcht auf Befehl neuzuzeichnen
     */
    public static Flow.Subscriber<String> MainSubscriber = new Flow.Subscriber<String>() {
        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            MainTmsSim.MaSubscription = subscription;
            MainTmsSim.MaSubscription.request(1);
        }

        @Override
        public void onNext(String planData) {



            MainTmsSim.MaSubscription.request(1);
            MainTmsSim.MainFrame.revalidate();
            MainTmsSim.updateSubViews();

        }




        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {

        }
    };


    private static boolean bFakeReceiver = true;
    private static boolean bSendRbcRequest = false;
    private static int iSendDummyPos = 3;

    /**
     * Main-Entry-Point
     * @param args
     */
    public static void main(String[] args) {
        //SmartLogic.createTestSend(true,bFakeReceiver, bSendRbcRequest, iSendDummyPos);
        startAsModul();



    }

    private static void startAsModul() {
        SmartLogic.IS_STARTED_AS_SL = false;
        try {
            EventBusManager.registerOrGetBus(Integer.parseInt(S_TMS_ID), true);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("TMS Logging Bus cannot be reserved.");
        }
        try {
            EventBusManager.startLogGuiServer(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Log Engine for TMS cannot be started.");
        }
        SmartClient SC = new SmartClient(null, 33330);
        // auch ungenutzt zur initialisierung wichtig
        SmartClientHandler ClientHandler = SmartClientHandler.getInstance();
        SC.start();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainTmsSim.MainFrame = MainTmsSim.createTmsFrame(MainTmsSim.TmsMode.Normal);
            }
        });
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoggingFrame();
            }
        });
    }

    /**
     * Erstellt das Hauptfenster des TMS
     * @param Mode {@link TmsMode}
     * @return JFrame
     */
    public static JFrame createTmsFrame(TmsMode Mode) {
        JFrame frame = new JFrame("TMS SIM");
        frame.getContentPane().setLayout(new BorderLayout());
        MainFrame = frame;

        if(Mode.equals(TmsMode.Normal)) {
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            addCommandPanel();
            zoomFrame = ZoomFrame.getZoomFrame();
        }
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

    private static void addSzenarioPanel() {


    }

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
        MainTmsSim.MainFrame.getContentPane().add(CommandPanel,BorderLayout.SOUTH);
        return CommandPanel;
    }


    private static Flow.Subscription MaSubscription;

    private static MainGraphicPanel TrackPanel = null;

    /**
     * Zeichnet Ma-Beantragunsfenster neu.
     */
    public static void updateSubViews() {
        if(TrackPanel != null) TrackPanel.repaint();
    }

}
