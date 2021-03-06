package de.ibw.tms.trackplan.controller;

import de.ibw.tms.trackplan.ui.Route;
import de.ibw.tms.trackplan.controller.Intf.IController;
import de.ibw.tms.trackplan.ui.RouteViewPort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
/**
 * Verwaltet beantragte Routen
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-11
 */
public class RouteController extends SubmissionPublisher<Route> implements IController<Route> {

    private RouteViewPort RoutePort = null;

    /**
     * Die verwaltete Route
     * @return Route
     */
    public Route getRouteData() {
        return RoutePort.getRouteModel();
    }

    /**
     * setzt die vom Controller verwaltete Route
     * @param R {@link Route} - Route zur Verwaltung
     */
    public void setRouteData(Route R) {
        this.RoutePort.setRouteModel(R);
    }

    /**
     * Instanziiert diesen Kontroller
     * @param routePort - Vermittlung zur Route
     */
    public RouteController(RouteViewPort routePort) {

        RoutePort = routePort;

    }

    /**
     * Benachrichtig alle Komponenten die sich registriert haben, dass eine Route ge&auml;ndert wurde.
     */

    @Override
    public void publish() {
        try {
            this.standardSubscription();

            if(this.getRouteData() != null) {
                this.submit(this.getRouteData());
            }

        } catch(IllegalStateException Ex) {
            Ex.printStackTrace();
        }


    }

    /**
     * Liste aller Nachrichten-Empf&auml;nger
     * @return List Empf&auml;nger
     */
    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        ArrayList<Flow.Subscriber> result = new ArrayList<Flow.Subscriber>();
        result.add(this.RoutePort);
        return result;
    }


}
