package de.ibw.tms.trackplan.ui;

import de.ibw.tms.ma.LinearLocation;
import de.ibw.tms.ma.Route;
import de.ibw.tms.trackplan.TrackplanGraphicPanel;
import de.ibw.tms.trackplan.controller.RouteController;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Flow;

public class RouteViewPort implements Flow.Subscriber<Route> {



    private Route R;

    public Route getRouteModel() {

        System.out.println("--getModel--");
        System.out.println(this.R);
        return R;

    }
    public void setRouteModel(Route routeModel) {
        this.R = routeModel;
    }

    private TrackplanGraphicPanel TrackPanel = null;

    private RouteController RouteCntrl = null;

    public RouteViewPort(Route RouteModel, TrackplanGraphicPanel trackPanel) {
        trackPanel.setRoutePort(this);
        TrackPanel = trackPanel;
        this.setRouteModel(RouteModel);



    }

    private Flow.Subscription windowSubscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.windowSubscription = subscription;
        subscription.request(1);
    }



    @Override
    public void onNext(Route item) {



            this.setRouteModel(item);
            TrackPanel.setRoutePort(this);

        System.out.println("-Set Model-");
            System.out.println(item);
            System.out.println(this.getRouteModel());
            RouteViewPort.this.TrackPanel.repaint();




        this.windowSubscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        this.TrackPanel.repaint();
    }

    public void setRouteCntrl(RouteController routeCntrl) {
        RouteCntrl = routeCntrl;
    }

    public void paintRoute(Graphics2D g2d)  {

        Route R = this.getRouteModel();
        System.out.println(R.toString());
        ArrayList paintList = new ArrayList();
        LinearLocation LinLoc = R.getLocation();

        if(LinLoc.getBegin() != null) {

            paintList.add((IPaintable) LinLoc.getBegin());
        }
        if(LinLoc.getEnd() != null) {
            paintList.add((IPaintable) LinLoc.getEnd());
        }


        paintList.addAll(R.getWaypointsList());

        for(Object oToPaint : paintList)
        {
            System.out.println("Image painted");
            IPaintable ToPaint = (IPaintable) oToPaint;
            ToPaint.paintImage(g2d);
        }
    }


}
