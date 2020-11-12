package ebd.routeData.util.events;

import ebd.globalUtils.events.NormalEvent;
import ebd.routeData.RouteDataVolatile;

public class NewRouteDataVolatileEvent extends NormalEvent {
    public final RouteDataVolatile routeDataVolatile;

    public NewRouteDataVolatileEvent(String source, String target, RouteDataVolatile routeDataVolatile) {
        super(source, target);
        this.routeDataVolatile = routeDataVolatile;
    }
}
