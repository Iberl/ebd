package ebd.routeData.util.events;

import ebd.routeData.RouteDataVolatile;
import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class NewRouteDataVolatileEvent extends NormalEvent {
    public final RouteDataVolatile routeDataVolatile;

    public NewRouteDataVolatileEvent(String source, String target, RouteDataVolatile routeDataVolatile) {
        super(source, target);
        this.routeDataVolatile = routeDataVolatile;
    }
}
