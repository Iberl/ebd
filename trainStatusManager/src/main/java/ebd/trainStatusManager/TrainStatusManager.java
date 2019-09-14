package ebd.trainStatusManager;

import ebd.breakingCurveCalculator.BreakingCurveCalculator;
import ebd.drivingDynamics.DrivingDynamics;
import ebd.messageReceiver.MessageReceiver;
import ebd.messageSender.MessageSender;
import ebd.routeData.RouteData;
import ebd.speedSupervisionModule.SpeedSupervisionModule;
import ebd.trainData.TrainData;
import org.greenrobot.eventbus.EventBus;

public class TrainStatusManager {

    private String etcsTrainID;
    private String rbcID;
    private String urlToTrainconfigurator;
    private String pathToDrivingStrategy;

    private EventBus localEventBus = new EventBus();
    private EventBus globalEventBus = EventBus.getDefault();

    private RouteData routeData;
    private TrainData trainData;
    private MessageReceiver messageReceiver;
    private MessageSender messageSender;
    private SpeedSupervisionModule speedSupervisionModule;
    private BreakingCurveCalculator breakingCurveCalculator;
    private DrivingDynamics drivingDynamics;


    public TrainStatusManager(String etcsTrainID, String rbcID, String urlToTrainconfigurator, String pathToDrivingStrategy){
        this.rbcID = rbcID;
        this.pathToDrivingStrategy = pathToDrivingStrategy;
        localEventBus.register(this);
        this.etcsTrainID = etcsTrainID;
        this.urlToTrainconfigurator = urlToTrainconfigurator;
        setUpTrain();
    }

    private void setUpTrain() {
        this.routeData = new RouteData(localEventBus);
        this.trainData = new TrainData(localEventBus,"resources/test650.json");
        this.messageReceiver = new MessageReceiver(localEventBus,this.etcsTrainID,"whatID");
        this.messageSender = new MessageSender(localEventBus,this.etcsTrainID, this.rbcID, "whatID");
        this.speedSupervisionModule = new SpeedSupervisionModule(localEventBus);
        this.breakingCurveCalculator = new BreakingCurveCalculator(localEventBus);
        this.drivingDynamics = new DrivingDynamics(localEventBus,pathToDrivingStrategy);
    }
}
