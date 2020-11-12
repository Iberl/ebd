package ebd.trainStatusManager.util.socketConnectors;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.core.StopTrainEvent;
import ebd.globalUtils.events.core.UpdatingInfrastructureEvent;
import ebd.globalUtils.events.trainStatusMananger.ChangeInfrastructureDirectionEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Connects the the tsm to the EBD infrastructure server which controls the models train by sending out
 * {@link UpdatingInfrastructureEvent}. These can be used by a InfrastructureClient that listens to the
 * global bus to notify a infrastructure server of the current speed of this train.
 */
public class InfrastructureClientConnector {

    private final EventBus localEventBus;
    private final EventBus globalEventBus;
    private TrainDataVolatile trainDataVolatile;
    private final int infrastructureID;
    private final String eventSource;
    private final String target = "szenario";

    private int tickCounter = 1;
    private final int updateMultiplier;

    private double carry;
    private List<Double> speeds = new ArrayList<>(); // in [m/s]
    private List<Double> times = new ArrayList<>(); // in [s]

    private double time;

    /**
     * Constructs an Instance
     * @param localEventBus the local {@link EventBus}
     * @param etcsID the etcsID. Its also used as infrastructure ID.
     */
    public InfrastructureClientConnector(EventBus localEventBus, int etcsID, int infrastructureID){
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);
        this.globalEventBus = EventBus.getDefault();

        this.trainDataVolatile = null;

        this.infrastructureID = infrastructureID;
        this.eventSource = "tsm;T=" + etcsID;

        this.updateMultiplier = ConfigHandler.getInstance().infrastructureUpdateMultiplier;
        this.time = System.currentTimeMillis() / 1000.0;
    }

    /**
     * On every clock tick send out by the trains clock in {@link ebd.trainStatusManager.TrainStatusManager},
     * this method checks if it has to send out a {@link UpdatingInfrastructureEvent}. It it
     * @param cte A {@link ClockTickEvent}
     */
    @Subscribe
    public void clockTick(ClockTickEvent cte){
        if(this.trainDataVolatile == null){
            NewTrainDataVolatileEvent ntdve = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class);
            if(ntdve == null) return;
            this.trainDataVolatile = ntdve.trainDataVolatile;
        }

        this.speeds.add(this.trainDataVolatile.getCurrentSpeed());
        this.times.add(cte.deltaT);

        this.tickCounter += 1;
        /*
         * Only calculated a update and send it if there where updateMultiplier many clock tick events.
         *
         */
        if(this.tickCounter < this.updateMultiplier) return;
        this.tickCounter = 1;

        double averageSpeed = 0;
        double timeBetweenUpdates = (System.currentTimeMillis() / 1000.0) - this.time;

        /*
         Needed are km/H, speeds are in m/s, so the speeds are multiply with 3.6.
         To get an average speed between now and the last update, the delta times of every speed
         has to be divided by the time between updates, because this time is always slightly longer than
         the sum of all delta times. This means the train drives slightly longer, but at a lower speed,
         which nullifies this difference.
        */
        for(int i = 0; i < this.speeds.size(); i++){
            averageSpeed += (this.speeds.get(i) * 3.6) * (this.times.get(i) / timeBetweenUpdates);
        }

        /*
        To reduce rounding to integer errors, the difference between the long and the double is carried over,
        weighted with the time spend between updates and then added back in.
        We also only send speeds greater than 10 km/h to prevent problems with the infrastructure
        //TODO Remove after FeedBackAlgorithm is implemented
         */
        double weightedCarry = this.carry * timeBetweenUpdates;

        averageSpeed += weightedCarry;
        long curVlong = 5 * Math.round(averageSpeed/5.0);
        if(curVlong < 10) curVlong = 0;
        this.carry = (averageSpeed - curVlong) / timeBetweenUpdates;

        this.speeds = new ArrayList<>();
        this.times = new ArrayList<>();
        this.globalEventBus.post(new UpdatingInfrastructureEvent(this.eventSource,this.target,this.infrastructureID,(int)curVlong));
        this.time = System.currentTimeMillis() / 1000.0;
    }

    @Subscribe
    public void changeDirection(ChangeInfrastructureDirectionEvent cide){
        this.globalEventBus.post(new ChangeInfrastructureDirectionEvent(this.eventSource, this.target, this.infrastructureID));
    }

    /**
     * Signals the infrastructure client that this trains should be stopped.
     */
    public void disconnect() {
        this.globalEventBus.post(new StopTrainEvent(this.eventSource,this.target,this.infrastructureID));
    }
}
