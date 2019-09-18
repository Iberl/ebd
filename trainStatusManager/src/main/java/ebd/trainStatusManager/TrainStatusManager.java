package ebd.trainStatusManager;

import ebd.breakingCurveCalculator.BreakingCurveCalculator;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.drivingDynamics.DrivingDynamics;
import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.drivingDynamics.DDUnlockEvent;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import ebd.routeData.RouteData;
import ebd.speedSupervisionModule.SpeedSupervisionModule;
import ebd.trainData.TrainData;
import ebd.trainData.util.availableAcceleration.BreakingPowerCurveCalculator;
import ebd.trainStatusManager.util.Clock;
import ebd.trainStatusManager.util.MessageHandler;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainStatusManager {

    private String etcsTrainID;
    private String rbcID;
    private String urlToTrainconfigurator;
    private String pathToDrivingStrategy;

    private EventBus localEventBus = new EventBus();
    private EventBus globalEventBus = EventBus.getDefault();

    /*
    Handlers
     */
    private MessageHandler messageHandler;

    /*
    Internal modules
     */
    private RouteData routeData;
    private TrainData trainData;
    private MessageReceiver messageReceiver;
    private MessageSender messageSender;
    private SpeedSupervisionModule speedSupervisionModule;
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
    }

    private void setUpTrain(boolean testing) {
        /*
        Handlers
         */
        this.messageHandler = new MessageHandler(this.localEventBus,this.etcsTrainID);

        /*
        Modules
         */

        this.routeData = new RouteData(this.localEventBus);

        if(testing) this.trainData = new TrainData(this.localEventBus,"C:\\intellij-workspace\\etcs\\resources\\test650.json");
        else this.trainData = new TrainData(this.localEventBus,this.urlToTrainconfigurator,this.etcsTrainID);

        this.messageReceiver = new MessageReceiver(this.localEventBus,this.etcsTrainID,"tsm");
        this.messageSender = new MessageSender(this.localEventBus,this.etcsTrainID, true);
        this.speedSupervisionModule = new SpeedSupervisionModule(this.localEventBus);
        this.breakingCurveCalculator = new BreakingCurveCalculator(this.localEventBus);
        this.drivingDynamics = new DrivingDynamics(this.localEventBus,this.pathToDrivingStrategy);

        Location curLoc = new Location("unknown", null, null);
        Position curPos = new Position(0,true, curLoc);
        Map<String,Object> changesForTD = new HashMap<>();
        changesForTD.put("currentPosition",curPos);
        changesForTD.put("currentSpeed", 0d);
        this.localEventBus.post(new TrainDataMultiChangeEvent("tsm",Arrays.asList("td"),changesForTD));

        this.clock = new Clock(this.localEventBus);
        this.clock.start();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void newBreakingCurve(NewBreakingCurveEvent nbce){
        if(!validTarget(nbce.targets)){
            System.out.println("dd");
            return;
        }
        if(!this.tripInProgress){
            this.tripInProgress = true;
            this.localEventBus.post(new DDUpdateTripProfileEvent("tsm", Arrays.asList("dd"),nbce.breakingCurve));
            this.localEventBus.post(new DDUnlockEvent("tsm", Arrays.asList("dd")));
        }
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
        this.globalEventBus.unregister(this);

    }

    /**
     * True if this Instance is a vaild target of the event
     * @param targetList the target list a the event
     * @return True if this instance is a vaild target of the event
     */
    private boolean validTarget(List<String> targetList){
        boolean result = false;

        for(String target : targetList){
            if(target.contains("tsm") || target.contains("all")){
                if(!target.contains(";")){
                    result = true;
                    break;
                }
                else if (target.contains(";T=" + this.etcsTrainID)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }


}
