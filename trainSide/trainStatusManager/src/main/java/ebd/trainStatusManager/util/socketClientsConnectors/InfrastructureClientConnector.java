package ebd.trainStatusManager.util.socketClientsConnectors;

import ebd.globalUtils.appTime.AppTime;
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

    private EventBus localEventBus;
    private EventBus globalEventBus;
    private TrainDataVolatile trainDataVolatile;
    private int etcsID;
    private String eventSource;
    private List<String> targets = Collections.singletonList("szenario");

    private int tickCounter = 0;
    private int updateMultiplier;

    private double carry;

    public InfrastructureClientConnector(EventBus localEventBus, int etcsID){
        this.localEventBus = localEventBus;
        this.localEventBus.register(this);
        this.globalEventBus = EventBus.getDefault();

        this.trainDataVolatile = null;

        this.etcsID = etcsID;

        this.eventSource = "tsm;T=" + this.etcsID;

        this.updateMultiplier = ConfigHandler.getInstance().infrastructureUpdateMultiplier;
    }

    @Subscribe
    public void clockTick(ClockTickEvent cte){
        if(this.trainDataVolatile == null){
            NewTrainDataVolatileEvent ntdve = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class);
            if(ntdve == null) return;
            this.trainDataVolatile = ntdve.trainDataVolatile;
        }

        this.tickCounter += 1;
        if(this.tickCounter <= this.updateMultiplier) return;
        this.tickCounter = 0;

        double deltaTime = cte.deltaT;

        double curV = this.trainDataVolatile.getCurrentSpeed();
        curV = curV * 3.6; //To km/h

        /*
        To reduce rounding to integer errors, the difference between the the int and the double is carried over,
        weighted with the time spend between clock ticks and then added back in.
         */
        double weightedCarry = this.carry * deltaTime;

        curV += weightedCarry;
        long curVlong = Math.round(curV);
        this.carry = (curV - curVlong) / deltaTime;
        this.globalEventBus.post(new UpdatingInfrastructureEvent(eventSource,targets,(int)curVlong));
    }
}
