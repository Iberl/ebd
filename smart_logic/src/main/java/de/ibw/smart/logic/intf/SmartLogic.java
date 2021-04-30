package de.ibw.smart.logic.intf;

import de.ibw.feed.Balise;
import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.impl.SmartServer4TmsImpl;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.tms.MainTmsSim;
import de.ibw.tms.intf.SmartClient;
import de.ibw.tms.intf.SmartClientHandler;
import de.ibw.tms.ma.positioned.elements.NetEntity;
import de.ibw.tms.ma.positioned.elements.SmartLogicArea;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.util.UtilFunction;
import ebd.SlConfigHandler;
import ebd.rbc_tms.message.Message_14;
import ebd.rbc_tms.message.Message_15;
import ebd.rbc_tms.payload.Payload_14;
import ebd.rbc_tms.payload.Payload_15;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.rbc_tms.util.PositionInfo;
import ebd.rbc_tms.util.TrainInfo;
import ebd.core.util.server.GUIServer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Flow;
import java.util.concurrent.SynchronousQueue;

/**
 * Die Smart Logic mit ihren Komponenten
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-09-01
 */
public class SmartLogic extends NetEntity {
    public static final String CLASS_IDENTIFIER = "smartLogic";

    private SmartLogicArea smartLogicArea;





    /**
     * Gibt an ob das Modul als Smart-Logic oder als TMS gestartet wurde
     * true :=  SmartLogic
     * false := TMS
     */
    public static boolean IS_STARTED_AS_SL;

    /**
     * Name der Smart-Logic Komponente als Log-file
     */
    public static final String SMART_LOGIC = "SMART-LOGIC";

    private static SmartLogicLifecycleController LifeCycleController = new SmartLogicLifecycleController();

    public SmartLogic() {
        super(CLASS_IDENTIFIER);
    }

    public static void addLifeCycleSubscriber(Flow.Subscriber S) {
        LifeCycleController.addSubscriber(S);
    }


    /**
     * Gibt an ob die SmartLogic gerade herunterfährt
     */
    public static boolean isInShutdown = false;

    public static void shutdownSmartLogic() {
        if(!SlConfigHandler.getInstance().isInTestMode) {
            if(SmartLogic.EM != null) EM.log("Shudown of Smart Logic only allowed in Test-Mode.", SMART_LOGIC);
        }
        isInShutdown = true;
        if(RbcClient != null) {
            RbcClient.shutdown();
            //RbcClient.interrupt();
            RbcClient = null;
            if(SmartLogic.EM != null) EM.log("Client to RBC is shutdown.", SMART_LOGIC);
        }
        if(SmartServForTms != null) {
            SmartServForTms.shutdown();
            //SmartServForTms.interrupt();
            SmartServForTms = null;
            if(SmartLogic.EM != null) EM.log("SmartLogic Server for TMS Requests is shutdown.", SMART_LOGIC);
        }
        if(TmsReceiverProxy != null) {
            try {
                TmsReceiverProxy.getGroup().shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //TmsReceiverProxy.interrupt();
            TmsReceiverProxy = null;
            if(SmartLogic.EM != null) EM.log("SmartLogic Proxy from RBC to TMS is shutdown.", SMART_LOGIC);

        }
        try {
            if (SL_UI_Server != null) {

                    SL_UI_Server.disconnect(null);


                SL_UI_Server = null;
            }
        } catch(Exception Except) {
            Except.printStackTrace();
          SL_UI_Server = null;
        }
        LifeCycleController.sendMsg("Shutdown");

    }

    private static RbcModul RbcClient;

    /**
     * RBC Modul als Client an den Kommunikationsserver im RBC
     * @return
     */
    public static RbcModul getRbcClient() {
        return RbcClient;
    }


    private static SmartServer SmartServForTms;

    /**
     * Server von Anfragen des TMS in der SmartLogic
     * @return SmartServer - Server f&uuml;r Anfragen des TMS
     */
    public static SmartServer getSmartServForTms() {
        return SmartServForTms;
    }

    private static RbcModul TmsReceiverProxy;

    private static GUIServer SL_UI_Server;


    private static EventBusManager EM = null;

    /**
     * Gibt an wie lange auf ein Acknowledge vom RBC gewartet wird
     */
    public static int TIMEOUT_SETTING_WAITING_MA_ACK_IN_SECONDS = 60;

    /**
     * Ausgangswarteschlange der SL an das TMS
     */
    public static SynchronousQueue<SmartServerMessage> outputQueue = new SynchronousQueue<SmartServerMessage>();






    private static int iSmartId = 1;

    private static void initSmartLogic() {
        isInShutdown = false;
        boolean bIsClient = true;

        PlanData.getInstance();
        // first initial Client
        RbcClient = new RbcModul(bIsClient, null,22224);
        SmartServForTms = new SmartServer(null, 33330);
        TmsReceiverProxy = new RbcModul(!bIsClient, null, 22223);
        TmsReceiverProxy.setTmsHandler(SmartServer4TmsImpl.instance);

        //TmsIntf TestTms = new RbcModul.TestTms();

    }

    private static void startSmartLogicModules() {
        try {
            EM = EventBusManager.registerOrGetBus(1, false);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Logging Bus cannot be created.");
        }
        try {
            SL_UI_Server = EventBusManager.startLogGuiServer(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Logging Gui on SL cannot be started.");
        }
        RbcClient.start();
        SmartServForTms.start();
        TmsReceiverProxy.start();
        LifeCycleController.sendMsg("Started");
    }

    /**
     * Starten der SL
     */
    public static void startSmartLogic() {
        if(EM != null) {
            EM.log("Initialize smartLogic", getsModuleId(SMART_LOGIC));
        }
        initSmartLogic();
        startSmartLogicModules();
        if(EM != null) {
            EM.log("Smart Logic startet. Waiting for TMS 1", getsModuleId(SMART_LOGIC));
        }

    }

    @NotNull
    public static String getsModuleId(String sKomponent) {
        return sKomponent + " " + SmartLogic.iSmartId;
    }

    /**
     * Intialisiert die Komponenten der SmartLogic
     * @param bWithUi - boolean gibt an ob das TMS mit Oberfläche gestartet wird
     * @param bFakeRbcReceiver - boolean gibt an ob auf der RBC Seite ein Empfänger simuliert werden soll
     * @param bSendRbcRequest - boolean gibt an ob RBC eine Dummy Anfrage an das TMS stellen soll
     * @param bStartTms - boolean gibt an ob das TMS mitgestartet werden soll
     */
    public static void createSmartLogic(boolean bWithUi, boolean bFakeRbcReceiver, boolean bSendRbcRequest, boolean bStartTms) {
        RbcReceiver RemoteRbcReceiver = null;
        RbcModul RbcClient = null;
        try {
            EventBusManager.registerOrGetBus(iSmartId, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bFakeRbcReceiver) {

            RemoteRbcReceiver = new RbcReceiver(null, 22224);
        }
        if (bSendRbcRequest) {
            TrainInfo Info = new TrainInfo(0, 0, 0L);
            PositionInfo PosInfo = generatePositionInfo(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            Payload_15 MaRequestLoad = new Payload_15(Info, PosInfo, 0);
            Message_15 RbcMaRequest = new Message_15(UUID.randomUUID(), "TMS_A1", "RBC_1", MaRequestLoad);

            RbcClient = new RbcModul(RbcMaRequest, null, 22223);
        }
        SmartLogic.startSmartLogic();
        if(bStartTms) {
            startTmsSide(bWithUi,bFakeRbcReceiver,RemoteRbcReceiver);
        }


        /*if (bSendRbcRequest) {

            RbcClient.start();
        }
        if(iSendDummyPos > 0) {

            SmartLogic.generateRandomDummyPositionReport(iSendDummyPos);
        }
        if (bSendRbcRequest) {
            TrainInfo Info = new TrainInfo(0, 0, 0L);
            PositionInfo PosInfo = generatePositionInfo(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            Payload_15 MaRequestLoad = new Payload_15(Info, PosInfo, 0);
            Message_15 RbcMaRequest = new Message_15(UUID.randomUUID(), "TMS_A1", "RBC_1", MaRequestLoad);

            RbcClient = new RbcModul(RbcMaRequest, null, 22223);
            RbcClient.start();
        }*/



    }

    /**
     * Startet das TMS
     * @param bWithUi - boolean ob die Oberfläche gestartet werden soll
     * @param bFakeRbcReceiver - boolean ob die RBC Seite als Empfänger simuliert werden soll
     * @param remoteRbcReceiver - Der RBC Receiver der als Simulation f&uuml;r echte Empf&auml;ger dient
     */
    public static void startTmsSide(boolean bWithUi, boolean bFakeRbcReceiver, RbcReceiver remoteRbcReceiver) {
        SmartClient SC = new SmartClient(null, 33330);
        // auch ungenutzt zur initialisierung wichtig
        SmartClientHandler ClientHandler = SmartClientHandler.getInstance();
        SC.start();
        if (bFakeRbcReceiver) {
            remoteRbcReceiver.start();
        }
        //CheckMovementAuthority c = CheckMovementAuthority.getDummyMovementAuthorityCommand();
        PlanData.getInstance();
        if(bWithUi) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    MainTmsSim.MainFrame = MainTmsSim.createTmsFrame(MainTmsSim.TmsMode.Normal);
                }
            });
        }
    }

    /**
     * Dummy PositionReport Generator
     * @param iCount - int with number of Position Reports
     */
    public static void generateRandomDummyPositionReport(int iCount) {
        for(int i = 0; i < iCount; i++) {
            TrainInfo TrInfo = generateRandomTrainInfo(i);
            Balise B = pickRandomBalise(i);
            int i_BaliseId = Balise.hashOfBalise.getModel(B);
            boolean shallPrintLength = new Random().nextBoolean();
            int iPrintLength = ETCSVariables.Q_LENGTH_INFO_NOT_AVAILABLE;
            int iLength = Math.abs(new Random().nextInt() % 100 + 10);
            if(shallPrintLength) {
                iPrintLength = ETCSVariables.Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE;
                System.out.println("Train " + i + " is printing length");
                System.out.println("Train " + i + " has Length: " + iLength);

            } else {
                System.out.println("Train " + i + " is NOT printing length");

            }

            int iSpeed = Math.abs(new Random().nextInt() % 300 + 10);

            boolean isTrainNominal = new Random().nextBoolean();
            int iTrainNominal = ETCSVariables.Q_DIRTRAIN_REVERSE;
            if(isTrainNominal) {
                iTrainNominal = ETCSVariables.Q_DIRTRAIN_NOMINAL;
                System.out.println("Train " + i + " is moving nominal");
            } else {

                System.out.println("Train " + i + " is moving REVERSE");
            }


        PositionInfo PosInfo = generatePositionInfo(i_BaliseId, ETCSVariables.Q_SCALE_1M, ETCSVariables.INTEGER_NOVALUE,
                    ETCSVariables.Q_DIRLRBG_NOMINAL, ETCSVariables.Q_DLRBG_NOMINAL, ETCSVariables.INTEGER_NOVALUE,
                    iPrintLength, iLength, iSpeed,
                     iTrainNominal, ETCSVariables.M_MODE_FULL_SUPERVISION,
                ETCSVariables.M_LEVEL_3);

            Payload_14 MaRequestLoad = new Payload_14(TrInfo, PosInfo);


            Message_14 PositionMessage = new Message_14(UUID.randomUUID(), "TMS_A1", "RBC_1", MaRequestLoad);
            RbcModul RbcClient = new RbcModul(PositionMessage, null, 22223);
            RbcClient.start();
        }

    }

    /**
     * Eine Funktion zum Testen der PositionReports. Sie holt eine zufällige Balise aus der PlanPro Datei.
     * @param index - Zugnummer
     * @return Balise - Zufällige Balise aus der PlanPro Datei
     */
    public static Balise pickRandomBalise(int index) {
        ArrayList<Balise> allBalises = new ArrayList<>(Balise.baliseByNid_bg.getAll());
        int iRandom = Math.abs(new Random().nextInt() % allBalises.size());
        Balise DummyBalise = allBalises.get(iRandom);
        System.out.println("Train " + index + " Balise: X: " + DummyBalise.getX() + " Y: " + DummyBalise.getY());
        return DummyBalise;
    }

    private static TrainInfo generateRandomTrainInfo(int index) {
        int iTrainNidEngine = Math.abs(new Random().nextInt() % 10 + 1);
        System.out.println("Train " + index + " EngineId:"  +  iTrainNidEngine);
        TrainInfo TrInfo = new TrainInfo(index, iTrainNidEngine, ETCSVariables.T_TRAIN_UNKNOWN);
        return TrInfo;
    }

    /**
     * Test Utility Sendet als RBC einen PositionReport
     */
    public static void sendDummyPositionReport() {
        TrainInfo TrInfo = new TrainInfo(3, 3, ETCSVariables.T_TRAIN_UNKNOWN);
        ArrayList<Balise> allBalises = new ArrayList<>(Balise.baliseByNid_bg.getAll());
        Balise DummyBalise = allBalises.get(0);

        int i_BaliseId = Balise.hashOfBalise.getModel(DummyBalise);

        PositionInfo PosInfo = generatePositionInfo(i_BaliseId, ETCSVariables.Q_SCALE_1M, 300, ETCSVariables.Q_DIRLRBG_NOMINAL, ETCSVariables.Q_DLRBG_NOMINAL, ETCSVariables.INTEGER_NOVALUE, ETCSVariables.Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE, 70, 10, ETCSVariables.Q_DIRTRAIN_NOMINAL, ETCSVariables.M_MODE_FULL_SUPERVISION, ETCSVariables.M_LEVEL_3);
        Payload_14 PositionPayload = new Payload_14(TrInfo, PosInfo);
        Message_14 PositionReport = new Message_14("TMS_1", "RBC_1", PositionPayload);
        RbcModul RbcClient = new RbcModul(PositionReport, null, 22223);
        RbcClient.start();
    }

    /**
     * Test Utility generiert PositionReport
     * @param i_BaliseId id der Balise
     * @param qScale1m -
     * @param i -
     * @param qDirlrbgNominal  -
     * @param qDlrbgNominal  -
     * @param integerNovalue  -
     * @param qLengthConfirmedByMonitoringDevice  -
     * @param i2  -
     * @param i3  -
     * @param qDirtrainNominal  -
     * @param mModeFullSupervision  -
     * @param mLevel3  -
     * @return PositionInfo - Positionsangabe zur Balise
     */
    public static PositionInfo generatePositionInfo(int i_BaliseId, int qScale1m, int i, int qDirlrbgNominal, int qDlrbgNominal, int integerNovalue, int qLengthConfirmedByMonitoringDevice, int i2, int i3, int qDirtrainNominal, int mModeFullSupervision, int mLevel3) {
        return new PositionInfo(qScale1m, i_BaliseId, i_BaliseId, i,
                qDirlrbgNominal,
                qDlrbgNominal, integerNovalue, integerNovalue,
                qLengthConfirmedByMonitoringDevice, i2, i3,
                qDirtrainNominal, mModeFullSupervision,
                mLevel3, 0);
    }

    /**
     * Main EntryPoint der SmartLogic
     * @param args - keine Bedeutung
     */
    public static void main(String[] args) {
        //startSmartLogic();
        String version  = SmartLogic.class.getPackage().getImplementationVersion();
        System.out.println("Starting smartLogic version " + UtilFunction.showVersionString());



        startSmartLogicStd();





        /*boolean bIsClient = true;
        TmsIntf TestTms = new RbcModul.TestTms();
        TmsServer.setTmsHandler(TestTms);
        TestTms.setTmsServer(TmsServer);

        TmsServer.start();
        TmsClient.start();
        TrainInfo Info = new TrainInfo(0, 0, 0L);
        PositionInfo PosInfo = new PositionInfo(0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0);
        Payload_15 MaRequestLoad = new Payload_15(Info,PosInfo, 0);
        Message_15 RbcMaRequest = new Message_15(UUID.randomUUID(),"TMS_A1", "RBC_1", MaRequestLoad );
        RbcModul RbcClient = new RbcModul(RbcMaRequest, null, 22223);
        //if(b4Show)RbcClient.start();
        */
    }

    public static void startSmartLogicStd() {

        SmartLogic.IS_STARTED_AS_SL = true;
        boolean fakeRbcReceiver = false;
        boolean sendDummyRequest = false;
        int iSendDummyPos = 0;
        boolean withUI = true;
        boolean bStartTms = false;
        createSmartLogic(withUI, fakeRbcReceiver, sendDummyRequest, bStartTms);
    }
}
