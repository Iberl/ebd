package ebd.routeData.tests;

import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.routeData.util.events.RouteDataExceptionEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class RDTestHandler {

    public RouteDataVolatile routeDataVolatile = null;

    public RDTestHandler(){
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void newTrainData(NewRouteDataVolatileEvent nrdve){
        this.routeDataVolatile = nrdve.routeDataVolatile;
        System.out.println("New Data recieved");
    }

    @Subscribe
    public void exception(RouteDataExceptionEvent rdee){
        rdee.exception.printStackTrace();
    }
}
