package de.ibw.tms.trackplan;

import de.ibw.tms.GraphicMoveByMouse;
import de.ibw.tms.MainTmsSim;
import de.ibw.tms.ma.GeoCoordinates;
import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.ma.Route;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.TopRailReturn;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.controller.TrackController;
import de.ibw.tms.trackplan.ui.MainGraphicPanel;
import de.ibw.tms.trackplan.ui.RouteViewPort;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import de.ibw.tms.trackplan.viewmodel.ZoomModel;
import de.ibw.util.DefaultRepo;
import plan_pro.modell.geodaten._1_9_0.CGEOKante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Flow;
/**
 * Panel das eine Streckenkarte beinhaltet
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public class TrackplanGraphicPanel extends JPanel implements Flow.Subscriber {




        private Flow.Subscription windowSubscription;



        private RouteViewPort RoutePort;
        private MaRequestWrapper R = null;

    /**
     * Gibt die Route einer MA an, die gerade geplant werden soll
     * @param routePort {@link RouteViewPort} - Vermittlung
     */
    public void setRoutePort(RouteViewPort routePort) {
        RoutePort = routePort;
    }

    private TrackController TrackController;


    /**
     * Gibt die gerade bearbeitete Route wider
     * @return Route
     */
    public Route getRouteModel() {
        return this.RoutePort.getRouteModel();
    }


    /**
     * Erstellt ein Panel mit der Streckenansicht
     * @param Request {@link MaRequestWrapper} - zu bearbeitende MA
     */
    public TrackplanGraphicPanel(MaRequestWrapper Request) {
            super();
            new GraphicMoveByMouse(this);
            boolean isMainWindow = false;
            this.R = Request;
            this.TrackController = de.ibw.tms.trackplan.controller.TrackController.getInstance(this);


            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    switch(e.getModifiersEx()) {
                        case InputEvent.BUTTON3_DOWN_MASK: {
                            TrackplanGraphicPanel.this.TrackController.handleMousePress(e.getPoint(), isMainWindow);
                            break;
                        }
                    }
                }
            });
            MainTmsSim.trackPanelRepository.add(this);
            this.setVisible(true);

            this.RoutePort = new RouteViewPort(this.R.getRoute(), this);
            TrackController.setRouteViewPort(this.RoutePort);






        }

        private void hitTest(Point point)
        {



        /*String mMsg= "Miss";
        Iterator rectangles= mRectangles.iterator();
        for (int i= 1; rectangles.hasNext(); i++) {
            Rectangle rec= (Rectangle) rectangles.next();
            if ((rec.x <= point.x && point.x <= (rec.x +rec.width)) &&
                    (rec.y <= point.y && point.y <= (rec.y +rec.height)))
            {

                    mMsg= "Hit #" +i;
                }
            }
        }
        repaint();
        */

        }

    /**
     * Gibt Vermittlung von Route zum Fenster wider.
     * @return RouteViewPort
     */
    public RouteViewPort getRoutePort() {
        return RoutePort;
    }

    /**
     * Gibt gerade bearbeitende MA wider.
     * @return MaRequestWrapper - MA in Wrapper
     */
    public MaRequestWrapper getR() {
        return R;
    }

    /**
     * Zeichnet die Kartenansicht in dieses Panel
     * @param g {@link Graphics} - Zeichenutil
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ZoomModel Zoom = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        TranslationModel T_Model = TranslationModel.getInstance();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.black);

        g2d.setFont(new Font("Century Schoolbook", Font.PLAIN, 12));
        MainGraphicPanel.paintCrossroad(T_Model,Zoom, g2d);
        MainGraphicPanel.paintBalises(T_Model, Zoom, g2d);
        g2d.scale(Zoom.getdZoomX(), Zoom.getdZoomY());
        g2d.translate(T_Model.getdMoveX(), T_Model.getdMoveY());
        g2d.scale(1,-1);
               /* Data.refreshData();
                Float xLower = d.getXLower();
                Float xUpper = d.getXUpper();
                Float xInterval = d.getXInterval();
                Float yLower = d.getYLower();
                Float yUpper = d.getYUpper();
                Float yInterval = d.getYInterval();
                Float dx = xUpper - xLower;
                Float dy = yUpper - yLower;

                drawCenteredString(g2d, d.getTitle(), 250, 25, (float) 0.);
                drawCenteredString(g2d, d.getXTitle(), 250, 475, (float) 0.);
                drawCenteredString(g2d, d.getYTitle(), 25, 250,
                        (float) -Math.PI / 2);
                drawCenteredString(g2d, xLower.toString(), 50, 475, (float) 0);
                drawCenteredString(g2d, xUpper.toString(), 450, 475, (float) 0);
                drawCenteredString(g2d, yLower.toString(), 25, 450, (float) 0);
                drawCenteredString(g2d, yUpper.toString(), 25, 50, (float) 0);*/

        g2d.setPaint(Color.gray);
        DefaultRepo<String, GeoCoordinates> geoPointRepo = PlanData.GeoNodeRepo;
        //TODO Carolin GeoKanten zeichnen
        HashMap edgeRepo = PlanData.topGraph.EdgeRepo;
        ArrayList<TopologyGraph.Edge> edgeList = new ArrayList<>(edgeRepo.values());
        for(TopologyGraph.Edge E : edgeList) {
            // diese Liste zeichenen
            ArrayList<CGEOKante> geoEdges = E.getPaintListGeo();
            if (geoEdges == null){
                System.out.println("Test");
                continue;
            }
            for(CGEOKante geoEdge : geoEdges) {
                if (geoEdge == null){
                    continue;
                }
                double strokeFactor = Math.max(Zoom.getdZoomX(), Zoom.getdZoomY());
                g2d.setStroke(new BasicStroke((float) (3 / strokeFactor)));
                GeoCoordinates nodeA = geoPointRepo.getModel(geoEdge.getIDGEOKnotenA().getWert());
                GeoCoordinates nodeB = geoPointRepo.getModel(geoEdge.getIDGEOKnotenB().getWert());
                Line2D.Double line = new Line2D.Double(nodeA.getX(), nodeA.getY(), nodeB.getX(), nodeB.getY());
                g2d.draw(line);
            }
        }
        g2d.setPaint(Color.yellow);
        List railList = PlanData.getInstance().railList;
        for(Object ORail : railList) {
            Rail R = (Rail) ORail;
            double strokeFactor = Math.max(Zoom.getdZoomX(), Zoom.getdZoomY());
            g2d.setStroke(new BasicStroke((float) (R.iStroke / strokeFactor)));
            g2d.draw(R);
        }
        /*for(TopRailReturn ReturnRail : PlanData.getInstance().returnRailEdge) {
            ArrayList<Line2D.Double> topRails =  ReturnRail.lineList;
            for(Line2D.Double RailPart : topRails) {
                g2d.setStroke(new BasicStroke(ReturnRail.iStroke));
                g2d.draw(RailPart);
            }

        }*/

        MainGraphicPanel.paintTrains(g2d);

        g2d.setPaint(Color.cyan);
        /*
        for(Object OCrossover: PlanData.getInstance().branchingSwitchList) {
            BranchingSwitch C = (BranchingSwitch) OCrossover;

            if(C.getStatus() == BranchingSwitch.CrossoverStatus.RIGHT) {
                g2d.setPaint(Color.RED);
            }
            if(C.getStatus() == BranchingSwitch.CrossoverStatus.LEFT) {
                g2d.setPaint(Color.BLUE);
            }

            g2d.setStroke(new BasicStroke(7));

            try {
                if(null != C.getImage()) {
                    g2d.drawImage(C.getImage(), null,  (int) ((double)C.x / Zoom.getdZoomX()), (int)
                            ((double )C.y / Zoom.getdZoomY()));
                }
                g2d.drawString(C.getViewName(),(float)(C.x - 5.0f),(float) C.y);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        /*for (Float x = 50f; x <= 450; x += 400 * xInterval / dx)
            g2d.draw(new Line2D.Float(x, 450, x, 50));
        for (Float y = 50f; y <= 450; y += 400 * yInterval / dy)
            g2d.draw(new Line2D.Float(45, y, 450, y));

        g2d.setPaint(Color.red);
        Float diam = 8f;
        int num_points = d.getNumberOfPoints();
        for (int i = 0; i < num_points; i++) {
            Float ex = 400 * (d.getPoint(i).x - xLower) / dx + 50;
            ex -= diam / 2;
            Float ey = -400 * (d.getPoint(i).y - yLower) / dy + 450;
            ey -= diam / 2;
            g2d.fill(new Ellipse2D.Float(ex, ey, diam, diam));
          */

        this.RoutePort.paintRoute(g2d);


        }







        private void drawCenteredString(Graphics2D g2d, String string,
                                        int x0, int y0, float angle) {
            FontRenderContext frc = g2d.getFontRenderContext();
            Rectangle2D bounds = g2d.getFont().getStringBounds(string, frc);
            LineMetrics metrics = g2d.getFont().getLineMetrics(string, frc);
            if (angle == 0) {
                g2d.drawString(string, x0 - (float) bounds.getWidth() / 2,
                        y0 + metrics.getHeight() / 2);
            } else {
                g2d.rotate(angle, x0, y0);
                g2d.drawString(string, x0 - (float) bounds.getWidth() / 2,
                        y0 + metrics.getHeight() / 2);
                g2d.rotate(-angle, x0, y0);
            }
        }

    /**
     * Meldet Sich als Empf&auml;nger von Neuzeichen-Befehlen an
     * @param subscription {@link java.util.concurrent.Flow.Subscription} Einschreibung
     */

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

        this.windowSubscription = subscription;
        subscription.request(1);
    }

    /**
     * Bereitet neuen empfang vor, nach erhalt einer Nachricht.
     * @param item - Nachricht
     */

    @Override
    public void onNext(Object item) {

        this.windowSubscription.request(1);
    }

    /**
     * Behandelt Fehler bei Empfang von Nachricht
     * @param t - Fehler
     */

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    /**
     * Zeichnet sich neu nach Erhalt eines Befehls.
     */

    @Override
    public void onComplete() {
        this.repaint();
    }
}


