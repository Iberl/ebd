package de.ibw.tms.trackplan.controller;

import de.ibw.tms.ma.Route;
import de.ibw.tms.trackplan.controller.Intf.IController;
import de.ibw.tms.trackplan.ui.RouteViewPort;
import de.ibw.tms.trackplan.ui.TrackWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class RouteController extends SubmissionPublisher<Route> implements IController<Route> {

    private RouteViewPort RoutePort = null;

    public Route getRouteData() {
        return RoutePort.getRouteModel();
    }

    public void setRouteData(Route R) {
        this.RoutePort.setRouteModel(R);
    }


    public RouteController(RouteViewPort routePort) {

        RoutePort = routePort;

    }



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
        TrackWindow.closeAllTrackWindows();

    }

    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        ArrayList<Flow.Subscriber> result = new ArrayList<Flow.Subscriber>();
        result.add(this.RoutePort);
        return result;
    }


}
