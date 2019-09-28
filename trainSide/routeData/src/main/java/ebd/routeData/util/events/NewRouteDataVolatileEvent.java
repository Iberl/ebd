package ebd.routeData.util.events;

import ebd.routeData.RouteDataVolatile;
import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class NewRouteDataVolatileEvent extends NormalEvent {
    public final RouteDataVolatile routeDataVolatile;

    public NewRouteDataVolatileEvent(String source, List<String> eventTargets, RouteDataVolatile routeDataVolatile) {
        super(source, eventTargets);
        this.routeDataVolatile = routeDataVolatile;
    }
}
