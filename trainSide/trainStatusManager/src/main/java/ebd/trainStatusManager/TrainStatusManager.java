package ebd.trainStatusManager;

import ebd.breakingCurveCalculator.BreakingCurveCalculator;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.drivingDynamics.DrivingDynamics;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.drivingDynamics.DDLockEvent;
import ebd.globalUtils.events.drivingDynamics.DDUnlockEvent;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.position.Position;
import ebd.logger.Logging;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import ebd.routeData.RouteData;
import ebd.speedSupervisionModule.SpeedSupervisionModule;
import ebd.trainData.TrainData;
import ebd.trainStatusManager.util.Clock;
import ebd.trainStatusManager.util.GlobalHandler;
import ebd.trainStatusManager.util.MessageHandler;
import ebd.trainStatusManager.util.TelegramHandler;
import ebd.trainStatusManager.util.events.TsmExceptionEvent;
import ebd.trainStatusManager.util.events.TsmTripEndEvent;
import ebd.trainStatusManager.util.supervisors.TripSupervisor;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.*;

public class TrainStatusManager implements Runnable {

    private String etcsTrainID;
    private String rbcID;
    private String urlToTrainconfigurator;
    private String pathToDrivingStrategy;

    private EventBus localEventBus = new EventBus();
    private EventBus globalEventBus = EventBus.getDefault();

    private Thread tsmThread = new Thread(this);

    /*
    Handlers
     */
    private Logging logger;
    private GlobalHandler globalHandler;
    private MessageHandler messageHandler;
    private TelegramHandler telegramHandler;

    /*
    Internal modules
     */
    private RouteData routeData;
    private TrainData trainData;
    private MessageReceiver messageReceiver;
    private MessageSender messageSender;
    private SpeedSupervisionModule speedSupervisionModule;
    private TripSupervisor tripSupervisor;
    private BreakingCurveCalculator breakingCurveCalculator;
    private DrivingDynamics drivingDynamics;

    private Clock clock;
    private boolean tripInProgress;


    public TrainStatusManager(String etcsTrainID, String rbcID, String urlToTrainconfigurator,
                              String pathToDrivingStrategy){
        this.localEventBus.register(this);
        this.etcsTrainID = etcsTrainID;
        this.rbcID = rbcID;
        this.urlToTrainconfigurator = urlToTrainconfigurator;
        this.pathToDrivingStrategy = pathToDrivingStrategy;
        setUpTrain(false);
        this.tsmThread.start();
    }

    public TrainStatusManager(String etcsTrainID, String rbcID, String urlToTrainconfigurator,
                              String pathToDrivingStrategy, boolean testing){
        this.localEventBus.register(this);
        this.etcsTrainID = etcsTrainID;
        this.rbcID = rbcID;
        this.urlToTrainconfigurator = urlToTrainconfigurator;
        this.pathToDrivingStrategy = pathToDrivingStrategy;
        setUpTrain(testing);
        this.tsmThread.start();
    }

    public TrainStatusManager(EventBus eventBus, String etcsTrainID, String rbcID, String urlToTrainconfigurator,
                              String pathToDrivingStrategy){
        this.localEventBus = eventBus;
        localEventBus.register(this);
        this.etcsTrainID = etcsTrainID;
        this.rbcID = rbcID;
        this.urlToTrainconfigurator = urlToTrainconfigurator;
        this.pathToDrivingStrategy = pathToDrivingStrategy;
        setUpTrain(true);
        this.tsmThread.start();
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

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void newBreakingCurve(NewBreakingCurveEvent nbce){
        if(!validTarget(nbce.targets)){
            return;
        }
        if(!this.tripInProgress){
            this.tripInProgress = true;
            this.localEventBus.post(new DDUpdateTripProfileEvent("tsm", Collections.singletonList("dd"),nbce.breakingCurve));
            this.localEventBus.post(new DDUnlockEvent("tsm", Collections.singletonList("dd")));
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void tripEnd(TsmTripEndEvent tee){
        if(!validTarget(tee.targets)){
            return;
        }
        this.localEventBus.post(new DDLockEvent("tsm", Collections.singletonList("dd")));
        this.tripInProgress = false;
        //TODO until better TrainsManager exists:
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
        synchronized (this){
            this.notify();
        }
    }

    private void setUpTrain(boolean testing) {
        /*
        Handlers
         */
        try {
            //System.out.println(this.etcsTrainID);
            this.logger = new Logging(this.localEventBus,Integer.parseInt(this.etcsTrainID));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.globalHandler = new GlobalHandler(this.localEventBus,this.etcsTrainID);
        this.messageHandler = new MessageHandler(this.localEventBus,this.etcsTrainID,this.rbcID);
        this.telegramHandler = new TelegramHandler(this.localEventBus, this.etcsTrainID);

        /*
        Modules
         */

        this.routeData = new RouteData(this.localEventBus);

        if(testing) this.trainData = new TrainData(this.localEventBus,"testTrain650.json");
        else this.trainData = new TrainData(this.localEventBus,this.urlToTrainconfigurator,this.etcsTrainID);

        this.messageReceiver = new MessageReceiver(this.localEventBus,this.etcsTrainID,"tsm");
        this.messageSender = new MessageSender(this.localEventBus,this.etcsTrainID, true);
        this.speedSupervisionModule = new SpeedSupervisionModule(this.localEventBus);
        this.tripSupervisor = new TripSupervisor(this.localEventBus);
        this.breakingCurveCalculator = new BreakingCurveCalculator(this.localEventBus);
        this.drivingDynamics = new DrivingDynamics(this.localEventBus,this.pathToDrivingStrategy);


        Position curPos = new Position(0,true, new InitalLocation());
        Map<String,Object> changesForTD = new HashMap<>();
        changesForTD.put("currentPosition",curPos);
        changesForTD.put("currentSpeed", 0d);
        this.localEventBus.post(new TrainDataMultiChangeEvent("tsm", Collections.singletonList("td"),changesForTD));

        this.clock = new Clock(this.localEventBus);
        this.clock.start();

        this.localEventBus.post(new ToLogEvent("tsm", Collections.singletonList("log"), "TSM initialized"));
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
