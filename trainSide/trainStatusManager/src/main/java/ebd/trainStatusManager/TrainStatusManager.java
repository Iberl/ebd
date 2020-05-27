package ebd.trainStatusManager;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.BreakingCurveCalculator;
import ebd.breakingCurveCalculator.utils.events.BreakingCurveExceptionEvent;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.drivingDynamics.DrivingDynamics;
import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.etcsModeAndLevel.ETCSMode;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageSender.SendMessageEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.*;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.szenario.RemoveTrainEvent;
import ebd.logging.Logging;
import ebd.messageLibrary.message.trainmessages.Message_150;
import ebd.messageLibrary.message.trainmessages.Message_155;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import ebd.routeData.RouteData;
import ebd.speedAndDistanceSupervisionModule.SpeedSupervisor;
import ebd.trainData.TrainData;
import ebd.trainStatusManager.util.Clock;
import ebd.trainStatusManager.util.events.TsmExceptionEvent;
import ebd.trainStatusManager.util.handlers.ExceptionHandler;
import ebd.trainStatusManager.util.handlers.GlobalHandler;
import ebd.trainStatusManager.util.handlers.MessageHandler;
import ebd.trainStatusManager.util.handlers.TelegramHandler;
import ebd.trainStatusManager.util.socketClientsConnectors.InfrastructureClientConnector;
import ebd.trainStatusManager.util.supervisors.MessageAuthorityRequestSupervisor;
import ebd.trainStatusManager.util.supervisors.ModeAndLevelSupervisor;
import ebd.trainStatusManager.util.supervisors.PositionReportSupervisor;
import ebd.speedAndDistanceSupervisionModule.DistanceSupervisor;
import ebd.trainStatusManager.util.supervisors.TrackSupervisor;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TrainStatusManager implements Runnable {

    private EventBus localEventBus = new EventBus();
    private EventBus globalEventBus = EventBus.getDefault();
    ConfigHandler ch;

    private int etcsTrainID;
    private int rbcID;
    private Thread tsmThread = new Thread(this);

    private String source;
    private List<String> scenarioTarget;
    private List<String> rbcTarget;

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
    The order of initialisation is important and reflected in the listing of the fields here!
     */
    private RouteData routeData;
    private TrainData trainData;
    private MessageReceiver messageReceiver;
    private MessageSender messageSender;
    private ModeAndLevelSupervisor modeAndLevelSupervisor;
    private SpeedSupervisor speedSupervisor;
    private DistanceSupervisor distanceSupervisor;
    private MessageAuthorityRequestSupervisor messageAuthorityRequestSupervisor;
    private PositionReportSupervisor positionReportSupervisor;
    private TrackSupervisor trackSupervisor;
    private BreakingCurveCalculator breakingCurveCalculator;
    private DrivingDynamics drivingDynamics;

    private Clock clock;


    public TrainStatusManager(int etcsTrainID, int trainConfigID, int infrastructureID, int rbcID){
        this.localEventBus.register(this);
        this.ch = ConfigHandler.getInstance();
        this.etcsTrainID = etcsTrainID;
        this.rbcID = rbcID;
        this.source = "tsm;T=" + this.etcsTrainID;
        this.scenarioTarget = Collections.singletonList("szenario");
        this.rbcTarget = Collections.singletonList("mr;R=" + this.rbcID);

        setUpTrain(trainConfigID, infrastructureID, rbcID);
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
            this.globalEventBus.post(new TsmExceptionEvent("tsm;T=" + this.etcsTrainID, "rsm;R=" + this.rbcID,
                    new NotCausedByAEvent(),ie, ExceptionEventTyp.WARNING));
        }
    }

    public void join(){
        try {
            this.tsmThread.join();
        } catch (InterruptedException e) {
            InterruptedException ie = new InterruptedException("TSM was interrupted: " + e.getMessage());
            ie.setStackTrace(e.getStackTrace());
            this.globalEventBus.post(new TsmExceptionEvent("tsm;T=" + this.etcsTrainID, "rsm;R=" + this.rbcID,
                    new NotCausedByAEvent(),ie, ExceptionEventTyp.WARNING));
        }
    }

    /**
     * Listens to
     * @param nbce
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void newBreakingCurve(NewBreakingCurveEvent nbce){
        if(!validTarget(nbce.target)){
            return;
        }

        //this.localEventBus.post(new DDUnlockEvent("tsm", "dd"));
        this.localEventBus.post(new ToLogEvent("tsm", "log",
                "Calculated a new breaking curve"));


        if(ch.debug){
            savingBreakingCurves(nbce);
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void reactToTripMode(ModeReportEvent mre){
        if(!validTarget(mre.target) || mre.curMode != ETCSMode.TRIP) return;

        //TODO fill with logic

    }

    @Subscribe
    public void pauseClock(PauseClockEvent pce){
        if(!validTarget(pce.target)) return;
        this.clock.setPaused(true);
    }

    @Subscribe
    public void continueClock(ContinueClockEvent cce){
        if(!validTarget(cce.target)) return;
        this.clock.setPaused(false);
    }

    /**
     * Reacts to a {@link TsmTripEndEvent} send out by the {@link DistanceSupervisor}
     * @param tee
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void tripEnd(TsmTripEndEvent tee){
        if(!validTarget(tee.target)){
            return;
        }
        //TODO until better TrainsManager exists:
        Message_150 msg150 = new Message_150();
        msg150.NID_ENGINE = this.etcsTrainID;
        Packet_0 p0 = new Packet_0();
        msg150.PACKET_POSITION = p0;
        this.infrastructureClientConnector.disconnect();
        SendMessageEvent sme = new SendMessageEvent("tsm", "ms", msg150, "mr;R=" + this.rbcID);
        this.messageSender.send(sme);
        disconnect(new DisconnectEvent("tsm", "tsm"));
    }

    /**
     * Reacts to a {@link DisconnectEvent} and stops the clock.
     * @param de a {@link DisconnectEvent}
     */
    @Subscribe
    public void disconnect(DisconnectEvent de){
        if(!validTarget(de.target)){
            return;
        }
        kill();
    }

    public void kill() {
        this.clock.stop();
        this.infrastructureClientConnector.disconnect();
        this.globalEventBus.post(new RemoveTrainEvent( this.source, this.rbcTarget, this.etcsTrainID));
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
        EventBus.getDefault().post(new PositionEvent("tsm;T=" + this.etcsTrainID, "all",curPos));
        Message_155 msg155 = new Message_155();
        long curTime = AppTime.currentTimeMillis();
        msg155.T_TRAIN = (curTime / 10) % ETCSVariables.T_TRAIN_UNKNOWN; //Resolution of T_Train is 10 ms, format is int
        msg155.NID_ENGINE = this.etcsTrainID;
        this.localEventBus.post(new SendMessageEvent("tsm", "ms", msg155, "mr;R=" + rbcID));
        this.localEventBus.post(new ToLogEvent("tsm", "log", "Send communication initiation to RBC " + rbcID));
    }

    /**
     * Initializes all needed instances of handlers, connections and modules, then starts the {@link Clock}.
     */
    private void setUpTrain( int trainConfigID, int infrastructureID, int rbcID) {
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
        this.infrastructureClientConnector = new InfrastructureClientConnector(this.localEventBus, this.etcsTrainID, infrastructureID);
        /*
        Modules
         */

        this.routeData = new RouteData(this.localEventBus);


        this.trainData = new TrainData(this.localEventBus, this.etcsTrainID, trainConfigID, infrastructureID);

        this.messageReceiver = new MessageReceiver(this.localEventBus,String.valueOf(this.etcsTrainID),"tsm", false);
        this.messageSender = new MessageSender(this.localEventBus,String.valueOf(this.etcsTrainID), true);
        this.modeAndLevelSupervisor = new ModeAndLevelSupervisor(this.localEventBus);
        this.speedSupervisor = new SpeedSupervisor(this.localEventBus);
        this.distanceSupervisor = new DistanceSupervisor(this.localEventBus);
        this.messageAuthorityRequestSupervisor = new MessageAuthorityRequestSupervisor(this.localEventBus, String.valueOf(this.etcsTrainID), String.valueOf(this.rbcID));
        this.positionReportSupervisor = new PositionReportSupervisor(this.localEventBus,String.valueOf(this.etcsTrainID), String.valueOf(this.rbcID));
        this.trackSupervisor = new TrackSupervisor(this.localEventBus);
        this.breakingCurveCalculator = new BreakingCurveCalculator(this.localEventBus);
        this.drivingDynamics = new DrivingDynamics(this.localEventBus, this.etcsTrainID);


        Position curPos = new Position(0,true, new InitalLocation());
        Map<String,Object> changesForTD = new HashMap<>();
        changesForTD.put("rbcID", rbcID);
        changesForTD.put("currentPosition",curPos);
        changesForTD.put("currentSpeed", 0d);
        changesForTD.put("releaseSpeed", ch.releaseSpeed);
        this.localEventBus.post(new TrainDataMultiChangeEvent("tsm", Collections.singletonList("td"),changesForTD));

        this.clock = new Clock(this.localEventBus);
        this.clock.start(ConfigHandler.getInstance().trainClockTickInMS);

        this.localEventBus.post(new ToLogEvent("tsm", "log", "TSM initialized"));
    }

    private void connectToRBC() {
        Position curPos = new Position(0,true, new InitalLocation());
        EventBus.getDefault().post(new PositionEvent("tsm;T=" + this.etcsTrainID, Collections.singletonList("all"),curPos));
        Message_155 msg155 = new Message_155();
        long curTime = AppTime.currentTimeMillis();
        msg155.T_TRAIN = (curTime / 10) % ETCSVariables.T_TRAIN_UNKNOWN;
        msg155.NID_ENGINE = this.etcsTrainID;
        this.localEventBus.post(new SendMessageEvent("tsm", Collections.singletonList("ms"), msg155, Collections.singletonList("mr;R=" + this.rbcID)));
        this.localEventBus.post(new ToLogEvent("tsm", Collections.singletonList("log"), "Send communication initiation to RBC " + this.rbcID));
    }

    private void saveBreakingCurvesToFile(NewBreakingCurveEvent nbce){
        if(!new File("results/breakingCurve/").mkdirs()){
            System.err.println("Could not create necessary directories");
            System.exit(-1); //TODO Make better and Event
        }

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
            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
            String time = dtf.format(ldt);
            String fileName = String.format("ETCS_ID_%d-%s-%s",this.etcsTrainID,bCurve.getID(),time);

            try {
                fW = new FileWriter("results/breakingCurves/" + fileName);
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
     * @param target the target list a the event
     * @return True if this instance is a vaild target of the event
     */
    private boolean validTarget(String target){

        if(target.contains("tsm") || target.contains("all")){
            if(!target.contains(";")){
                return true;
            }
            else if (target.contains(";T=" + this.etcsTrainID)){
                return true;
            }
        }

        return false;
    }
}
