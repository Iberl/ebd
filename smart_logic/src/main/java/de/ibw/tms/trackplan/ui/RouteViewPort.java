package de.ibw.tms.trackplan.ui;

import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.location.LinearLocation;
import de.ibw.tms.trackplan.TrackplanGraphicPanel;
import de.ibw.tms.trackplan.controller.RouteController;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Flow;
/**
 * Stellt Beziehung zu genau eienr Route eines Zuges zu dem Streckenfenster einer MA her.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-12
 */
public class RouteViewPort implements Flow.Subscriber<Route> {



    private Route R;

    /**
     * Gibt aktuelle Route im Streckenfester wider.
     * @return Route
     */
    public Route getRouteModel() {

        System.out.println("--getModel--");
        System.out.println(this.R);
        return R;

    }

    /**
     * Setzt die Route einer Ma in dem Streckenfenster
     * @param routeModel {@link Route} - R
     */
    public void setRouteModel(Route routeModel) {
        this.R = routeModel;
    }

    private TrackplanGraphicPanel TrackPanel = null;

    private RouteController RouteCntrl = null;

    /**
     * Erstellt den Bezug von Route zum MA-Streckenfenster
     * @param RouteModel
     * @param trackPanel
     */
    public RouteViewPort(Route RouteModel, TrackplanGraphicPanel trackPanel) {
        trackPanel.setRoutePort(this);
        TrackPanel = trackPanel;
        this.setRouteModel(RouteModel);



    }

    private Flow.Subscription windowSubscription;

    /**
     * h&ouml;rt auf Nachrichten von Routen&auml;nderungen
     * @param subscription
     */

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.windowSubscription = subscription;
        subscription.request(1);
    }

    /**
     * Routen&auml;nderung umsetzen
     * @param item {@link Route}
     */

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

    /**
     * Fehler bei eingehender Routennachricht
     * @param throwable {@link Throwable} Fehler
     */

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * Nach verarbeiten der Nachricht wird neugezeichnet
     */

    @Override
    public void onComplete() {
        this.TrackPanel.repaint();
    }

    /**
     * Zeichnet Routen in das Ma-Streckenfenster ein
     * @param g2d {@link Graphics2D} - Zeichenutil
     */
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
