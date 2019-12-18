package ebd.trainStatusManager.util.socketClientsConnectors;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.Event;
import ebd.globalUtils.events.szenario.UpdatingInfrastructureEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * //TODO Move up to main module of the program, use global events on this level
 */
public class InfrastructureClientConnector {

    EventBus localEventBus;
    EventBus globalEventBus;
    private int etcsID;
    private String eventSource;
    private List<String> targets = Collections.singletonList("szenario");

    private int tickCounter = 0;
    private int updateMultiplier;
    private long lastTimeInMS;

    private double carry;
    private double maxCarry;

    public InfrastructureClientConnector(EventBus localEventBus, int etcsID){
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);
        this.globalEventBus = EventBus.getDefault();
        this.etcsID = etcsID;

        this.eventSource = "tsm;T=" + this.etcsID;

        this.updateMultiplier = ConfigHandler.getInstance().infrastructureUpdateMultiplier;
        this.maxCarry = 3 * this.updateMultiplier * ConfigHandler.getInstance().trainClockTickInMS / 1000;
    }

    @Subscribe
    public void clockTick(ClockTickEvent cte){
        if(this.tickCounter <= this.updateMultiplier){
            this.tickCounter += 1;
            return;
        }

        long deltaTime = (this.lastTimeInMS - System.currentTimeMillis()) / 1000;
        this.lastTimeInMS = System.currentTimeMillis();

        this.tickCounter = 0;
        NewTrainDataVolatileEvent ntdve = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class);
        if(ntdve == null) return;

        TrainDataVolatile trainDataVolatile = ntdve.trainDataVolatile;

        double curV = trainDataVolatile.getCurrentSpeed();
        curV = curV * 3.6; //To km/h

        /*
        To reduce rounding to integer errors, the difference between the the int and the double is carried over,
        weighted with the time spend between clock ticks and then added back in.
        Because a pause in the execution of the process could lead to errors and to great carries, a sanity check
        will be performed.
         */
        double weightedCarry = this.carry * deltaTime;

        if(weightedCarry > this.maxCarry ){
            weightedCarry = 0;
        }
        curV += weightedCarry;
        long curVlong = Math.round(curV);
        this.carry = (curV - curVlong) / deltaTime;
        this.globalEventBus.post(new UpdatingInfrastructureEvent(eventSource,targets,(int)curVlong));
    }
}
