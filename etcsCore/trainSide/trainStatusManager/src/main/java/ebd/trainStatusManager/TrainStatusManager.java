package ebd.trainStatusManager;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.BreakingCurveCalculator;
import ebd.breakingCurveCalculator.utils.events.BreakingCurveExceptionEvent;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.drivingDynamics.DrivingDynamics;
import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.configHandler.TrainsHandler;
import ebd.globalUtils.enums.ETCSMode;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageSender.SendETCSMessageEvent;
import ebd.globalUtils.events.routeData.RouteDataMultiChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.*;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.events.scenario.RemoveTrainEvent;
import ebd.logging.Logging;
import ebd.messageLibrary.message.trainmessages.Message_150;
import ebd.messageLibrary.message.trainmessages.Message_155;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import ebd.routeData.RouteData;
import ebd.routeData.RouteDataVolatile;
import ebd.speedAndDistanceSupervisionModule.DistanceSupervisor;
import ebd.speedAndDistanceSupervisionModule.SpeedSupervisor;
import ebd.trainData.TrainData;
import ebd.trainStatusManager.util.Clock;
import ebd.trainStatusManager.util.events.TsmExceptionEvent;
import ebd.trainStatusManager.util.handlers.ExceptionHandler;
import ebd.trainStatusManager.util.handlers.GlobalHandler;
import ebd.trainStatusManager.util.handlers.MessageHandler;
import ebd.trainStatusManager.util.handlers.TelegramHandler;
import ebd.trainStatusManager.util.socketConnectors.DMIServerConnector;
import ebd.trainStatusManager.util.socketConnectors.InfrastructureClientConnector;
import ebd.trainStatusManager.util.supervisors.*;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TrainStatusManager implements Runnable {

    private final EventBus localEventBus = new EventBus();
    private final EventBus globalEventBus = EventBus.getDefault();
    private ConfigHandler ch;

    private final int etcsTrainID;
    private final int rbcID;
    private final Thread tsmThread = new Thread(this);

    private final String source;

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
    private SpeedUpdateSupervisor speedUpdateSupervisor;
    private DMIServerConnector dmiServerConnector;
    private BreakingCurveCalculator breakingCurveCalculator;
    private DrivingDynamics drivingDynamics;

    private Clock clock;

    /**
     * Initializes a train.
     * @param etcsTrainID The ETCS ID of the train.
     * @param trainConfigID The ID of the train in the TrainConfigurator tool
     * @param infrastructureID The ID of the train in the EBD Infrastructure
     * @param rbcID The ID of the RBC the train should connect to
     */
    public TrainStatusManager(int etcsTrainID, int trainConfigID, int infrastructureID, int rbcID){
        this.localEventBus.register(this);
        this.ch = ConfigHandler.getInstance();
        this.etcsTrainID = etcsTrainID;
        this.rbcID = rbcID;
        this.source = "tsm;T=" + this.etcsTrainID;

        setUpTrain(trainConfigID, infrastructureID);
        this.tsmThread.start();
        connectToRBC(this.rbcID);
    }

    /**
     * Will be called inside TSM.
     */
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

    /**
     * Calls join on the TSM thread. This will block until the TSM thread is closed.
     */
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
     * Kills the train by stopping clock, disconnecting the train from the infrastructure and letting the
     * thread run out.
     */
    public void kill() {
        if(this.clock != null) this.clock.stop();
        if(this.infrastructureClientConnector != null) this.infrastructureClientConnector.disconnect();
        this.globalEventBus.post(new RemoveTrainEvent( this.source, "mr;R=" + this.rbcID, this.etcsTrainID));
        synchronized (this){
            this.notify();
        }
    }

    /**
     * Listens to
     * @param nbce
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void newBreakingCurve(NewBreakingCurveEvent nbce){
        if(!validTarget(nbce.target)){
            return;
        }

        //this.localEventBus.post(new DDUnlockEvent("tsm", "dd"));
        this.localEventBus.post(new ToLogEvent("tsm", "log",
                "Calculated a new breaking curve"));

        if(ch.debug){
            saveBreakingCurvesToFile(nbce);
        }
    }

    /**
     * This function checks if a new location was reached and if so, updates the position of the train to
     * reflect this. //TODO Move to TrackSupervisor?
     */
    @Subscribe
    public void reactToNewLocation(NewLocationEvent nle) {
        RouteDataVolatile routeDataVolatile = this.routeData.getRouteDataVolatile();
        if(routeDataVolatile.getLinkingInformation() == null) return;

        Location newLoc = nle.newLocation;


        Position oldPos = this.trainData.getTrainDataVolatile().getCurrentPosition();

        Map<Integer,Location> prefLocs = Objects.requireNonNull(oldPos).getPreviousLocations();
        double overshoot;

        if(prefLocs.size() > 0) {
            Double distanceToPrev = newLoc.getDistanceToPrevious();
            distanceToPrev = distanceToPrev != null ? distanceToPrev : 0;
            overshoot = oldPos.getIncrement() - distanceToPrev;
            prefLocs.put(newLoc.getId(),newLoc);
        }
        else {
            InitalLocation initLoc = new InitalLocation();
            prefLocs.put(initLoc.getId(),initLoc);
            prefLocs.put(newLoc.getId(),new Location(newLoc.getId(), initLoc.getId(), newLoc.getDirection(), oldPos.getIncrement()));
            overshoot = oldPos.getIncrement(); //Assumption: We always start at a location!
        }

        Position newPos = new Position(overshoot, newLoc.getDirection(), newLoc, prefLocs);
        this.localEventBus.post(new TrainDataChangeEvent("tsm","td","currentPosition",newPos));
        this.localEventBus.post(new NewPositionEvent("tsm","all", newPos));
    }


    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void reactToTripMode(ModeReportEvent mre){
        if(!validTarget(mre.target) || mre.curMode != ETCSMode.TRIP) return;

        //When in trip, delete route data.
        Map<String, Object> changeMap = new HashMap<>();
        changeMap.put("packet_15", null);
        changeMap.put("packet_21", null);
        changeMap.put("packet_27", null);
        this.localEventBus.post(new RouteDataMultiChangeEvent("tsm","rd", changeMap));
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
        msg150.positionPacket = p0;
        this.infrastructureClientConnector.disconnect();
        SendETCSMessageEvent sme = new SendETCSMessageEvent("tsm", "ms", msg150, "mr;R=" + this.rbcID);
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

    /**
     * Connects this train to the RBC specified by sending a {@link Message_155}
     * @param rbcID The RBC identification //TODO Noch Notwendig?
     */
    private void connectToRBC(int rbcID) {
        Position curPos = new Position(0,true, new InitalLocation());
        EventBus.getDefault().post(new PositionEvent("tsm;T=" + this.etcsTrainID, "all",curPos));
        Message_155 msg155 = new Message_155();
        long curTime = AppTime.currentTimeMillis();
        msg155.T_TRAIN = (curTime / 10) % ETCSVariables.T_TRAIN_UNKNOWN; //Resolution of T_Train is 10 ms, format is int
        msg155.NID_ENGINE = this.etcsTrainID;
        this.localEventBus.post(new SendETCSMessageEvent("tsm", "ms", msg155, "mr;R=" + rbcID));
        this.localEventBus.post(new ToLogEvent("tsm", "log", "Send communication initiation to RBC " + rbcID));
    }

    /**
     * Initializes all needed instances of handlers, connections and modules, then starts the {@link Clock}.
     */
    private void setUpTrain( int trainConfigID, int infrastructureID) {
        TrainsHandler th = TrainsHandler.getInstance();
        Integer startingBalise = th.getStartingBaliseGroup(this.etcsTrainID);
        int startingBGDir = th.getStartingMovementDir(this.etcsTrainID) ? 1 : 0;
        Boolean startingDirection = th.getStartingDirection(this.etcsTrainID);
        Integer startingIncrement = th.getStartingIncrement(this.etcsTrainID);
        if(startingBalise == null || startingDirection == null || startingIncrement == null){ //Train already removed, so we immediately kill the train
            kill();
            return;
        }

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

        this.messageReceiver = new MessageReceiver(this.localEventBus,String.valueOf(this.etcsTrainID),"tsm", true);
        this.messageSender = new MessageSender(this.localEventBus,String.valueOf(this.etcsTrainID), true);
        this.modeAndLevelSupervisor = new ModeAndLevelSupervisor(this.localEventBus);
        this.speedSupervisor = new SpeedSupervisor(this.localEventBus);
        this.distanceSupervisor = new DistanceSupervisor(this.localEventBus);
        this.messageAuthorityRequestSupervisor = new MessageAuthorityRequestSupervisor(this.localEventBus, String.valueOf(this.etcsTrainID), String.valueOf(this.rbcID));
        this.positionReportSupervisor = new PositionReportSupervisor(this.localEventBus,String.valueOf(this.etcsTrainID), String.valueOf(this.rbcID));
        this.trackSupervisor = new TrackSupervisor(this.localEventBus);
        this.speedUpdateSupervisor = new SpeedUpdateSupervisor(this.localEventBus);
        this.dmiServerConnector = new DMIServerConnector(this.localEventBus);
        this.breakingCurveCalculator = new BreakingCurveCalculator(this.localEventBus);
        this.drivingDynamics = new DrivingDynamics(this.localEventBus, this.etcsTrainID);

        Location newLoc = new Location(startingBalise, ETCSVariables.NID_LRBG_UNKNOWN, startingBGDir, 0d);
        Position curPos = new Position(startingIncrement, startingBGDir, newLoc);
        Map<String,Object> changesForTD = new HashMap<>();
        changesForTD.put("rbcID", rbcID);
        changesForTD.put("currentPosition",curPos);
        changesForTD.put("currentSpeed", 0d);
        changesForTD.put("currentApplicableReleaseSpeed", 0);
        this.localEventBus.post(new TrainDataMultiChangeEvent("tsm", "td",changesForTD));

        this.clock = new Clock(this.localEventBus);
        this.clock.start(ConfigHandler.getInstance().clockTickInMS);

        this.localEventBus.post(new ToLogEvent("tsm", "log", "TSM initialized"));
    }

    private void saveBreakingCurvesToFile(NewBreakingCurveEvent nbce){
        LocalDateTime ldt = LocalDateTime.now();
        String timeString =  DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ldt);
        String dirPathString = "results/breakingCurves/ID" + this.etcsTrainID + "_" + timeString.replaceAll(":", "-") + "/";
        BreakingCurve[] lobc = {nbce.emergencyBreakingCurve, nbce.serviceBreakingCurve, nbce.normalBreakingCurve};

        if(!new File(dirPathString).mkdirs()){
            System.err.println("Could not create necessary directories");
            System.exit(-1); //TODO Make better and Event
        }

        for(BreakingCurve bCurve : lobc) {
            FileWriter fW;
            String fileName = String.format("ID%d-%s", this.etcsTrainID, bCurve.getID());

            try {
                fW = new FileWriter(dirPathString + fileName);
                BufferedWriter writer = new BufferedWriter(fW);
                writer.write(bCurve.toStringAllKnots());
                writer.flush();
                writer.close();

            } catch (IOException e1) {
                localEventBus.post(new BreakingCurveExceptionEvent("bcc", "tsm", nbce, e1));
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
            else return target.contains(";T=" + this.etcsTrainID);
        }

        return false;
    }
}
