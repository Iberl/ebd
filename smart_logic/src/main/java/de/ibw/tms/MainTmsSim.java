package de.ibw.tms;

import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.ui.ScenarioPanel;
import de.ibw.tms.intf.SmartClient;
import de.ibw.tms.intf.SmartClientHandler;
import de.ibw.tms.intf.cmd.CheckMovementAuthority;
import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.ma.RbcMaAdapter;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.trackplan.controller.TrackController;
import de.ibw.tms.trackplan.ui.MainGraphicPanel;
import de.ibw.tms.trackplan.ui.ZoomFrame;
import ebd.rbc_tms.util.ETCSVariables;
import ebd.szenario.util.server.GUIServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Flow;

public class MainTmsSim {

    public enum TmsMode {
        Normal, EBD
    }

    public static String S_TMS_ID = "1";
    public static JFrame MainFrame = null;
    public static ZoomFrame zoomFrame = null;
    public static ArrayList<JPanel> trackPanelRepository = new ArrayList<>();
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

    public static void main(String[] args) {
        //SmartLogic.createTestSend(true,bFakeReceiver, bSendRbcRequest, iSendDummyPos);
        startAsModul();



    }

    private static void startAsModul() {
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

    public static CheckMovementAuthority generateMovementAuthority(MaRequestWrapper mar, RbcMaAdapter Ma4Rbc , long lPriority) {
        /*CheckMovementAuthority resultMa = new CheckMovementAuthority(lPriority, Ma4Rbc);
        resultMa.MaRequest = mar;

        return resultMa;
        */
         return null;
    }


    public static JFrame createTmsFrame(TmsMode Mode) {
        JFrame frame = new JFrame("TMS SIM");
        frame.getContentPane().setLayout(new BorderLayout());
        MainFrame = frame;

        if(Mode.equals(TmsMode.Normal)) {
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            addCommandPanel();
            zoomFrame = ZoomFrame.getZoomFrame();
        } else if(Mode.equals(TmsMode.EBD)) {
            addSzenarioPanel();
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
        ScenarioPanel ScenPanel = new ScenarioPanel();
        MainTmsSim.MainFrame.getContentPane().add(ScenPanel,BorderLayout.SOUTH);

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

    public static JButton genCloseButton(JWindow CurrentWindow, String sButtonName) {
        JButton CloseButton = new JButton(sButtonName);
        CloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentWindow.dispose();

            }
        });
        return CloseButton;
    }

    public static Flow.Subscription MaSubscription;

    public static MainGraphicPanel TrackPanel = null;

    public static void updateSubViews() {
        if(TrackPanel != null) TrackPanel.repaint();
    }

}
