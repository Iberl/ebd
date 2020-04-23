package ebd.trainStatusManager;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.BreakingCurveCalculator;
import ebd.breakingCurveCalculator.utils.events.BreakingCurveExceptionEvent;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.drivingDynamics.DrivingDynamics;
import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.drivingDynamics.DDLockEvent;
import ebd.globalUtils.events.drivingDynamics.DDUnlockEvent;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageSender.SendMessageEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.ContinueClockEvent;
import ebd.globalUtils.events.trainStatusMananger.PauseClockEvent;
import ebd.globalUtils.events.trainStatusMananger.PositionEvent;
import ebd.globalUtils.events.trainStatusMananger.TsmTripEndEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.position.Position;
import ebd.logging.Logging;
import ebd.messageLibrary.message.trainmessages.Message_150;
import ebd.messageLibrary.message.trainmessages.Message_155;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import ebd.routeData.RouteData;
import ebd.speedSupervisionModule.SpeedSupervisionModule;
import ebd.trainData.TrainData;
import ebd.trainStatusManager.util.Clock;
import ebd.trainStatusManager.util.events.TsmExceptionEvent;
import ebd.trainStatusManager.util.handlers.ExceptionHandler;
import ebd.trainStatusManager.util.handlers.GlobalHandler;
import ebd.trainStatusManager.util.handlers.MessageHandler;
import ebd.trainStatusManager.util.handlers.TelegramHandler;
import ebd.trainStatusManager.util.socketClientsConnectors.InfrastructureClientConnector;
import ebd.trainStatusManager.util.supervisors.MessageAuthorityRequestSupervisor;
import ebd.trainStatusManager.util.supervisors.PositionReportSupervisor;
import ebd.trainStatusManager.util.supervisors.DistanceSupervisor;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TrainStatusManager implements Runnable {

    private EventBus localEventBus = new EventBus();
    private EventBus globalEventBus = EventBus.getDefault();
    ConfigHandler ch;

    private int etcsTrainID;
    private int rbcID;
    private Thread tsmThread = new Thread(this);

    /*
    Handlers
     */
    private Logging logger;
    private ExceptionHandler exceptionHandler;
    private GlobalHandler globalHandler;
    private MessageHandler messageHandler;
    private TelegramHandler telegramHandler;

    /*
    ClientConnectors
     */
    private InfrastructureClientConnector infrastructureClientConnector;

    /*
    Internal modules
     */
    private RouteData routeData;
    private TrainData trainData;
    private MessageReceiver messageReceiver;
    private MessageSender messageSender;
    private SpeedSupervisionModule speedSupervisionModule;
    private DistanceSupervisor distanceSupervisor;
    private MessageAuthorityRequestSupervisor messageAuthorityRequestSupervisor;
    private PositionReportSupervisor positionReportSupervisor;
    private BreakingCurveCalculator breakingCurveCalculator;
    private DrivingDynamics drivingDynamics;

    private Clock clock;


    public TrainStatusManager(int etcsTrainID, int rbcID){
        this.localEventBus.register(this);
        this.ch = ConfigHandler.getInstance();
        this.etcsTrainID = etcsTrainID;
        this.rbcID = rbcID;
        setUpTrain();
        this.tsmThread.start();
        connectToRBC(this.rbcID);
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            InterruptedException ie = new InterruptedException("TSM was interrupted: " + e.getMessage());
            ie.setStackTrace(e.getStackTrace());
            this.globalEventBus.post(new TsmExceptionEvent("tsm;T=" + this.etcsTrainID, Collections.singletonList("rsm;R=" + this.rbcID),
                    new NotCausedByAEvent(),ie, ExceptionEventTyp.WARNING));
        }
    }

    public void join(){
        try {
            this.tsmThread.join();
        } catch (InterruptedException e) {
            InterruptedException ie = new InterruptedException("TSM was interrupted: " + e.getMessage());
            ie.setStackTrace(e.getStackTrace());
            this.globalEventBus.post(new TsmExceptionEvent("tsm;T=" + this.etcsTrainID, Collections.singletonList("rsm;R=" + this.rbcID),
                    new NotCausedByAEvent(),ie, ExceptionEventTyp.WARNING));
        }
    }

    /**
     * Listens to
     * @param nbce
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void newBreakingCurve(NewBreakingCurveEvent nbce){
        if(!validTarget(nbce.targets)){
            return;
        }

        this.localEventBus.post(new DDUnlockEvent("tsm", Collections.singletonList("dd")));
        this.localEventBus.post(new ToLogEvent("tsm", Collections.singletonList("log"),
                "Calculated a new breaking curve"));


        if(ch.debug){
            savingBreakingCurves(nbce);
        }
    }

    @Subscribe
    public void pauseClock(PauseClockEvent pce){
        if(!validTarget(pce.targets)) return;
        this.clock.setPaused(true);
    }

    @Subscribe
    public void continueClock(ContinueClockEvent cce){
        if(!validTarget(cce.targets)) return;
        this.clock.setPaused(false);
    }

    /**
     * Reacts to a {@link TsmTripEndEvent} send out by the {@link DistanceSupervisor}
     * @param tee
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void tripEnd(TsmTripEndEvent tee){
        if(!validTarget(tee.targets)){
            return;
        }
        this.localEventBus.post(new DDLockEvent("tsm", Collections.singletonList("dd")));
        //TODO until better TrainsManager exists:
        Message_150 msg150 = new Message_150();
        msg150.NID_ENGINE = this.etcsTrainID;
        Packet_0 p0 = new Packet_0();
        msg150.PACKET_POSITION = p0;
        this.infrastructureClientConnector.disconnect();
        SendMessageEvent sme = new SendMessageEvent("tsm", Collections.singletonList("ms"), msg150, Collections.singletonList("mr;R=" + this.etcsTrainID));
        this.messageSender.send(sme);
        disconnect(new DisconnectEvent("tsm", Collections.singletonList("tsm")));
    }

    /**
     * Reacts to a {@link DisconnectEvent} and stops the clock.
     * @param de a {@link DisconnectEvent}
     */
    @Subscribe
    public void disconnect(DisconnectEvent de){
        if(!validTarget(de.targets)){
            return;
        }


        this.clock.stop();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().post(new ToLogEvent("glb", Collections.singletonList("log"), "ETCS shut down"));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            this.notify();
        }
    }

    /**
     * Connects this train to the RBC specified by sending a {@link Message_155}
     * @param rbcID The RBC identification
     */
    private void connectToRBC(int rbcID) {
        Position curPos = new Position(0,true, new InitalLocation());
        EventBus.getDefault().post(new PositionEvent("tsm;T=" + this.etcsTrainID, Collections.singletonList("all"),curPos));
        Message_155 msg155 = new Message_155();
        long curTime = AppTime.currentTimeMillis();
        msg155.T_TRAIN = (curTime / 10) % ETCSVariables.T_TRAIN_UNKNOWN; //Resolution of T_Train is 10 ms, format is int
        msg155.NID_ENGINE = this.etcsTrainID;
        this.localEventBus.post(new SendMessageEvent("tsm", Collections.singletonList("ms"), msg155, Collections.singletonList("mr;R=" + rbcID)));
        this.localEventBus.post(new ToLogEvent("tsm", Collections.singletonList("log"), "Send communication initiation to RBC " + rbcID));
    }

    /**
     * Initializes all needed instances of handlers, connections and modules, then starts the {@link Clock}.
     */
    private void setUpTrain() {
        /*
        Handlers
         */
        try {
            //System.out.println(this.etcsTrainID);
            this.logger = new Logging(this.localEventBus,this.etcsTrainID, "TRN ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.exceptionHandler = new ExceptionHandler(this.localEventBus);
        this.globalHandler = new GlobalHandler(this.localEventBus,this.etcsTrainID);
        this.messageHandler = new MessageHandler(this.localEventBus,this.etcsTrainID,this.rbcID);
        this.telegramHandler = new TelegramHandler(this.localEventBus, this.etcsTrainID);

        /*
        SocketClientConnectors
         */
        this.infrastructureClientConnector = new InfrastructureClientConnector(this.localEventBus, this.etcsTrainID, this.etcsTrainID);

        /*
        Modules
         */

        this.routeData = new RouteData(this.localEventBus);

        this.trainData = new TrainData(this.localEventBus);

        this.messageReceiver = new MessageReceiver(this.localEventBus,String.valueOf(this.etcsTrainID),"tsm", false);
        this.messageSender = new MessageSender(this.localEventBus,String.valueOf(this.etcsTrainID), true);
        this.speedSupervisionModule = new SpeedSupervisionModule(this.localEventBus);
        this.distanceSupervisor = new DistanceSupervisor(this.localEventBus);
        this.messageAuthorityRequestSupervisor = new MessageAuthorityRequestSupervisor(this.localEventBus, String.valueOf(this.etcsTrainID), String.valueOf(this.rbcID));
        this.positionReportSupervisor = new PositionReportSupervisor(this.localEventBus,String.valueOf(this.etcsTrainID), String.valueOf(this.rbcID));
        this.breakingCurveCalculator = new BreakingCurveCalculator(this.localEventBus);
        this.drivingDynamics = new DrivingDynamics(this.localEventBus, this.etcsTrainID);


        Position curPos = new Position(0,true, new InitalLocation());
        Map<String,Object> changesForTD = new HashMap<>();
        changesForTD.put("currentPosition",curPos);
        changesForTD.put("currentSpeed", 0d);
        changesForTD.put("etcsID", this.etcsTrainID);
        this.localEventBus.post(new TrainDataMultiChangeEvent("tsm", Collections.singletonList("td"),changesForTD));

        this.clock = new Clock(this.localEventBus);
        this.clock.start(ConfigHandler.getInstance().trainClockTickInMS);

        this.localEventBus.post(new ToLogEvent("tsm", Collections.singletonList("log"), "TSM initialized"));
    }

    /**
     * Saves the breakingCurves to files to be analysed
     * @param nbce {@link NewBreakingCurveEvent}
     */
    private void savingBreakingCurves(NewBreakingCurveEvent nbce) {
        List<BreakingCurve> lobc = new ArrayList<>();
        lobc.add(nbce.breakingCurveGroup.getEmergencyDecelerationCurve());
        lobc.add(nbce.breakingCurveGroup.getEmergencyInterventionCurve());
        lobc.add(nbce.breakingCurveGroup.getServiceDecelerationCurve());
        lobc.add(nbce.breakingCurveGroup.getServiceInterventionCurve());
        lobc.add(nbce.breakingCurveGroup.getServiceWarningCurve());
        lobc.add(nbce.breakingCurveGroup.getPermittedSpeedCurve());
        lobc.add(nbce.breakingCurveGroup.getServiceIndicationCurve());
        lobc.add(nbce.breakingCurveGroup.getServiceCoastingPhaseCurve());

        for(BreakingCurve bCurve : lobc) {
            double xPosition = 0d;
            double step = bCurve.getHighestXValue() / 100000d;
            FileWriter fW;
            try {

                fW = new FileWriter(bCurve.getID() + ".txt");
                BufferedWriter writer = new BufferedWriter(fW);
                writer.write("");

                while (xPosition <= bCurve.getHighestXValue()) {

                    Double yValue = bCurve.getPointOnCurve(xPosition);
                    writer.append(String.format("%f:%f%n", xPosition, yValue));
                    xPosition += step;
                }

                writer.close();

            } catch (IOException e1) {
                List<String> eventTargets = new ArrayList<>();
                eventTargets.add("tsm;");
                localEventBus.post(new BreakingCurveExceptionEvent("bcc", eventTargets, nbce, e1));
            }
        }
    }

    /**
     * True if this Instance is a vaild target of the event
     * @param targetList the target list a the event
     * @return True if this instance is a vaild target of the event
     */
    private boolean validTarget(List<String> targetList){

        for(String target : targetList){
            if(target.contains("tsm") || target.contains("all")){
                if(!target.contains(";")){
                    return true;
                }
                else if (target.contains(";T=" + this.etcsTrainID)){
                    return true;
                }
            }
        }
        return false;
    }



}
