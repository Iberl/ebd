package de.ibw.tms.trackplan.ui;

import de.ibw.feed.Balise;
import de.ibw.tms.GraphicMoveByMouse;
import de.ibw.tms.MainTmsSim;
import de.ibw.tms.ma.GeoCoordinates;
import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.physical.ControlledTrackElement;
import de.ibw.tms.ma.physical.RailConnector;
import de.ibw.tms.ma.physical.SingleSlip;
import de.ibw.tms.ma.repo.MaRepository;
import de.ibw.tms.plan.elements.BranchingSwitch;
import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.controller.TrackController;
import de.ibw.tms.trackplan.viewmodel.DijkstraAffineRoute;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import de.ibw.tms.trackplan.viewmodel.ZoomModel;
import de.ibw.tms.train.model.TrainDistance;
import de.ibw.tms.train.model.TrainModel;
import de.ibw.util.DefaultRepo;
import ebd.ConfigHandler;
import org.apache.log4j.Logger;
import plan_pro.modell.geodaten._1_9_0.CGEOKante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.Flow;

/**
 * Das Panel des Hauptfensters
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-08-24
 */
public class MainGraphicPanel extends JPanel implements Flow.Subscriber {
    private static Logger logger = Logger.getLogger( MainGraphicPanel.class );

    private static double TrainStroke = 7d;
    private TrackController TrackControl = null;

    private Flow.Subscription subscription = null;


    /**
     * Erstellt Komponenten des Hauptfensters
     */
    public MainGraphicPanel() {
        super();
        new GraphicMoveByMouse(this);
        MainTmsSim.trackPanelRepository.add(this);
        this.setVisible(true);
        this.TrackControl = de.ibw.tms.trackplan.controller.TrackController.getInstance(null);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                switch(e.getModifiersEx()) {
                    case InputEvent.BUTTON3_DOWN_MASK: {
                        boolean isMainWindow = true;
                        MainGraphicPanel.this.TrackControl.handleMousePress(e.getPoint(), isMainWindow);

                        break;
                    }
                }

            }
        });

        initBranchingSwitch();


    }

    private void initBranchingSwitch() {
        PlanData PD = PlanData.getInstance();
        for(BranchingSwitch BS :PD.branchingSwitchList) {

            BS.getController().publish();

        }
    }

    /**
     * Zeichnet Z&uuml;ge in das Fenster
     * @param g2d {@link Graphics2D} - Zeichenutil
     */
    public static void paintTrains(Graphics2D g2d) {
        ZoomModel Zoom = ZoomModel.getInstance();
        double strokeFactor = Math.max(Zoom.getdZoomX(), Zoom.getdZoomY());
        BasicStroke BS = new BasicStroke((float) (TrainStroke / strokeFactor));
        g2d.setStroke(BS);

        Collection<TrainModel> models = TrainModel.TrainRepo.getAll();
        for(TrainModel TM: models) {
            try {
                double d1 = 0;

                String sId = TM.getEdgeTrainStandsOn().sId;

                TrainDistance TD = TM.getDistanceRefPointOfEdge();
                if (TD == null) {
                    logger.error("Train-Modul: TrainId: " + TM.iTrainId + " cannot be painted.\n");
                    continue;
                }
                if(TD.getdDistance1() < 0 ) {
                    d1 = 0;
                } else {
                    d1 = TD.getdDistance1();
                }
                g2d.setPaint(TM.RepresentedColor);
                System.out.println(sId + " - D1: " + d1 + " - D2" + TD.getdDistance2());
                paintGeo(g2d, sId,TD.isIsfromA(), d1, TD.getdDistance2(), TM.RepresentedColor,
                        BS);
            } catch(Exception E) {
                E.printStackTrace();
                logger.error("Train-Modul: TrainId: " + TM.iTrainId + " cannot be painted.\n");
            }

        }


    }

    private static void rotate180(Line2D.Double toPaint) {
        toPaint.x1 = toPaint.x1 * -1;
        toPaint.y1 = toPaint.y1 * -1;
        toPaint.x2 = toPaint.x2 * -1;
        toPaint.y2 = toPaint.y2 * -1;
    }

    private static void mirror(Line2D.Double toPaint) {
        toPaint.x1 = toPaint.x1 * -1;
        toPaint.x2 = toPaint.x2 * -1;
    }

    /**
     * Zeichnte die Karte im Hauptfenster
     * @param g - Zeichenutil
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ZoomModel Zoom = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        TranslationModel T_Model = TranslationModel.getInstance();
        System.out.println("MainPanelRepaint");

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.black);

        g2d.setFont(new Font("Century Schoolbook", Font.PLAIN, 12));



        paintCrossroad(T_Model, Zoom, g2d);
        paintBalises(T_Model,Zoom,g2d);

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
        HashMap edgeRepo = PlanData.topGraph.edgeRepo;

        ArrayList<TopologyGraph.Edge> edgeList = new ArrayList<>(edgeRepo.values());
        for(TopologyGraph.Edge E : edgeList) {
            // diese Liste zeichenen
            ArrayList<CGEOKante> geoEdges = E.getPaintListGeo();
            if (geoEdges == null) continue;
            for(CGEOKante geoEdge : geoEdges) {
                if (geoEdge == null) continue;
                double strokeFactor = Math.max(Zoom.getdZoomX(), Zoom.getdZoomY());
                g2d.setStroke(new BasicStroke((float) (3 / strokeFactor)));
                GeoCoordinates nodeA = geoPointRepo.getModel(geoEdge.getIDGEOKnotenA().getWert());
                GeoCoordinates nodeB = geoPointRepo.getModel(geoEdge.getIDGEOKnotenB().getWert());



                Line2D.Double line = new Line2D.Double(nodeA.getX(), nodeA.getY(), nodeB.getX(), nodeB.getY());
                g2d.draw(line);
//                Ellipse2D.Double circle = new Ellipse2D.Double(nodeA.getX(), nodeA.getY(), 10, 10);
//                g2d.fill(circle);
                drawArrowHead(g2d, line);
                //drawArrowLine(g2d, nodeA.getX(), nodeA.getY(), nodeB.getX(), nodeB.getY(), 5, 5);
            }
        }
        /*g2d.setPaint(Color.yellow);
        List railList = PlanData.getInstance().railList;
        for(Object ORail : railList) {

            Rail R = (Rail) ORail;
            if(PlanData.trainOccupiedList.contains(R.getTrackReference())) {
                g2d.setPaint(Color.green);
            } else {
                g2d.setPaint(Color.yellow);
            }
            double strokeFactor = Math.max(Zoom.getdZoomX(), Zoom.getdZoomY());
            g2d.setStroke(new BasicStroke((float) (R.iStroke / strokeFactor)));
            g2d.draw(R);
        }*/

        paintTrains(g2d);

        paintConnectors(g2d);
        paintRequestedMa(g2d);
        // disable zoom for images

    }

    /**
     * Zeichnet alle Weichen
     * @param t_Model {@link TranslationModel} - Nachberechnung der Position.
     * @param zoom {@link ZoomModel }
     * @param g2d {@link Graphics2D}
     */
    public static void paintCrossroad(TranslationModel t_Model, ZoomModel zoom, Graphics2D g2d) {


        //g2d.translate(t_Model.getdMoveX(), t_Model.getdMoveY());
        
        g2d.setPaint(Color.cyan);
        ConfigHandler CH = ConfigHandler.getInstance();

        for(Object OCrossover: PlanData.getInstance().branchingSwitchList) {
            BranchingSwitch C = (BranchingSwitch) OCrossover;

            //debug
            SingleSlip SiBranch = (SingleSlip) C.getTrackReference();

            CrossoverModel TargetCrossoverModel = CrossoverModel.BranchToCrossoverModelRepo.getModel((ControlledTrackElement) SiBranch.getRemotePoint());
            String sTopId;
            String sTrackKilometers = "";
            try {
                CrossingSwitch CS = (CrossingSwitch) TargetCrossoverModel.getNode().NodeImpl;
                sTopId = CS.getEbdTitle(0,false,true);
                if(sTopId == null) {
                    sTopId = PlanData.getInstance().getNodeId(TargetCrossoverModel.getNode());
                }

                if(CH.showMeter) sTrackKilometers = retrieveTrackInfo(CS, true);
            } catch (Exception E) {
                sTopId = PlanData.getInstance().getNodeId(TargetCrossoverModel.getNode());
            }



            int x = (int) ((int) (C.x + t_Model.getdMoveX()) * zoom.getdZoomX());
            int y = (int) ((int) (C.y * -1 + t_Model.getdMoveY()) * zoom.getdZoomY());
            Paint prevPaint = g2d.getPaint();
            switch(C.getStatus()) {
                case BUSY: g2d.setPaint(Color.GREEN);
                     break;
                case RIGHT: g2d.setPaint(Color.RED);
                     break;
                case LEFT: g2d.setPaint(Color.BLUE);
                     break;
            }

            g2d.setStroke(new BasicStroke(1));

            try {
                if (null != C.getImage()) {
                    
                    g2d.drawImage(C.getImage(), null, x, y);
                }
                g2d.drawString(sTopId + sTrackKilometers, (float) (x - 5.0f), (float) y);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g2d.setPaint(prevPaint);
        }

        // g2d.translate(-t_Model.getdMoveX(), -t_Model.getdMoveY());
    }

    private static String retrieveTrackInfo(CrossingSwitch cs, boolean inShort) {
        StringBuilder result = new StringBuilder();
        for(String sTrackId : cs.getSupportedTracks()) {
            BigDecimal dKilo = cs.getTrackMeterByTrackId(sTrackId);
            if(!inShort)retrieveTrackInfoLong(result, sTrackId, dKilo);
            else {
                retrieveTrackInfoShort(result, sTrackId, dKilo);
            }
        }
        return result.toString();
    }

    private static void retrieveTrackInfoShort(StringBuilder result, String sTrackId, BigDecimal dKilo) {
        if(dKilo == null) {
            result.append("TId: ").append(sTrackId, 0, 3).append(" m: ").append("na");
        } else {
            result.append("TId: ").append(sTrackId, 0, 3).append(" m: ").append(dKilo);
        }
    }

    private static void retrieveTrackInfoLong(StringBuilder result, String sTrackId, BigDecimal dKilo) {
        if(dKilo == null) {
            result.append("TrackId: ").append(sTrackId, 0, 3).append(" has meter: ").append("na");
        } else {
            result.append("TrackId: ").append(sTrackId, 0, 3).append(" has meter: ").append(dKilo);
        }
    }

    /**
     * Zeichnet Balisen
     * @param t_Model {@link TranslationModel} - Nachberechnung der Position.
     * @param zoom {@link ZoomModel }
     * @param g2d {@link Graphics2D}
     */
    public static void paintBalises(TranslationModel t_Model, ZoomModel zoom, Graphics2D g2d) {
        Collection<Balise> balises = Balise.baliseByNid_bg.getAll();
        int iStepper = 0;
        for(Balise B : balises) {
            iStepper++;
            int x = (int) ((int) (B.getX() + t_Model.getdMoveX()) * zoom.getdZoomX());
            int y = (int) ((int) (B.getY() * -1 + t_Model.getdMoveY()) * zoom.getdZoomY());
            //int x = (int) B.getX();
            //int y = (int) B.getY();
            try {
                if (null != B.getImage()) {
                    String sBaliseDesc = "B" + B.getHashcodeOfBaliseDp();
                    double sTopLang = B.getTopPositionOfDataPoint().getTOPKanteAllg().getTOPLaenge().getWert().doubleValue();
                    g2d.drawImage(B.getImage(), null, x, y);
                    g2d.drawString(sBaliseDesc, (float) (x + 5.0f), (float) y + (iStepper % 7) * 5.0f);
                    g2d.drawString(sBaliseDesc + " " + String.valueOf(B.getPlanProDataPoint().getPunktObjektTOPKante().get(0).getAbstand().getWert()), (float) (x + 5.0f), (float) y + (iStepper % 7) * 5.0f + 10);


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void paintConnectors(Graphics2D g2d) {
        PlanData.getInstance();
        ArrayList<RailConnector> connectorList = PlanData.connectorList;
        float x = 1;
        for(RailConnector RC: connectorList) {
            try {
                x = ((float) RC.getPositionedRelations().get(0).getFrom().getChainageEnd().getiMeters()) / 10.0f;
            } catch(Exception E) {
                continue;
            }
            float y = 140.0f;
            g2d.setColor(new Color(0,150,150));

            g2d.drawString(RC.getViewName(),x - 5.0f,(float) y);
        }

    }

    private void paintRequestedMa(Graphics2D g2d) {
        Collection<MaRequestWrapper> maRequests = MaRepository.getMaList();
        System.out.println("CountRequest: " + maRequests.size());
        for(MaRequestWrapper Request: maRequests) {
            System.out.println(Request.getTm().label);
            Route R = Request.getRoute();
            System.out.println(R.toString());
            DijkstraAffineRoute DijkstraRoute = new DijkstraAffineRoute(R);
            DijkstraRoute.checkRailWayDefined();
            System.out.println("Before paintable");
            if(DijkstraRoute.isPaintable()) {
                System.out.println("it is paintable");
                ArrayList<Rail> railList = DijkstraRoute.getTrack();
                g2d.setColor(Request.getTm().RepresentedColor);
                for(Rail RailToPaint : railList) {
                    System.out.println("PaintedRail");
                    g2d.draw(RailToPaint);
                }

            }
        }
    }

    private static void paintGeo(Graphics2D g2d, String TopKanteId, boolean b_fromA, double distanceA1, Double distanceA2, Color color, Stroke stroke) throws Exception {
        // Get TopEdge
        HashMap edgeRepo = PlanData.topGraph.edgeRepo;
        TopologyGraph.Edge edge = (TopologyGraph.Edge) edgeRepo.get(TopKanteId);
        if(edge.dTopLength < distanceA1 || edge.dTopLength < distanceA2) throw new IllegalArgumentException("The desired point must lay on the top edge.");
        ArrayList<CGEOKante> geoEdgeList = edge.getPaintListGeo();

        double lengthOfGeoEdges = 0;
        for(CGEOKante geoEdge : geoEdgeList) {
            lengthOfGeoEdges += geoEdge.getGEOKanteAllg().getGEOLaenge().getWert().doubleValue();
        }
        LinkedGeo linkedGeo = null;
        try {
            linkedGeo = new LinkedGeo(geoEdgeList,b_fromA, edge);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        double prevDistance = 0;
        double geoEdgeLength = 0;
        CGEOKante geoEdge = null;

        // distanceA2 could be null
        if(distanceA2 == null) distanceA2 = edge.dTopLength;

        Color prevColor = g2d.getColor();
        Stroke prevStroke = g2d.getStroke();
        g2d.setColor(color);
        g2d.setStroke(stroke);

        /*if(!b_fromA) {
            double dTemp = distanceA1;
            distanceA1 = distanceA2;
            distanceA2 = dTemp;
            distanceA1 = edge.dTopLength - distanceA1;
            distanceA2 = edge.dTopLength - distanceA2;
        }*/


        if(Math.abs(edge.dTopLength - lengthOfGeoEdges) > 1) {
            distanceA1 = distanceA1 * lengthOfGeoEdges / edge.dTopLength;
            distanceA2 = distanceA2 * lengthOfGeoEdges / edge.dTopLength;
        }

        int i = b_fromA ? 0 : geoEdgeList.size() - 1;
        boolean first = true;
        for(i = 0; i < linkedGeo.getUsedEdgesSorted().size(); i++) {
            geoEdge = linkedGeo.getUsedEdgesSorted().get(i);
            geoEdgeLength = geoEdge.getGEOKanteAllg().getGEOLaenge().getWert().doubleValue();
            GeoCoordinates nodeA = PlanData.GeoNodeRepo.getModel(geoEdge.getIDGEOKnotenA().getWert());
            GeoCoordinates nodeB = PlanData.GeoNodeRepo.getModel(geoEdge.getIDGEOKnotenB().getWert());



            // First node
            if(prevDistance + geoEdgeLength < distanceA1) {
                prevDistance += geoEdgeLength;
                continue;
            }

            if(first && prevDistance + geoEdgeLength >= distanceA1) {
                first = false;
                nodeA = getGeoCoordinate(geoEdge, linkedGeo.isNextAccessedFromA(geoEdge), distanceA1 - prevDistance);
            }

            // Last node
            if(prevDistance + geoEdgeLength > distanceA2) {
                nodeB = getGeoCoordinate(geoEdge, linkedGeo.isNextAccessedFromA(geoEdge), distanceA2 - prevDistance);
            }

            // Draw Line
            Line2D.Double line = new Line2D.Double(nodeA.getX(), nodeA.getY(), nodeB.getX(), nodeB.getY());
            g2d.draw(line);
            /*
                g2d.drawString("Node A: " + i, (float)nodeA.getX(),(float) nodeA.getY());
                g2d.drawString("Node B: " + i, (float)nodeB.getX(),(float) nodeB.getY());
            */
            prevDistance += geoEdgeLength;
            if(prevDistance > distanceA2) break;
        }

        g2d.setColor(prevColor);
        g2d.setStroke(prevStroke);
    }

    /**
     * Berechnet die GeoCoordinate zu einer Topologischen Kante mit Bezug zu einem Knoten mit distanz.
     * @param TopKanteId {@link String} - Knoten Id PlanPro
     * @param b_fromA boolean - ist von A gemessen worden
     * @param distanceA1 double - Abstand zum Referenzknoten
     * @return GeoCoordinates - Geographischer Punkt
     */
    public static GeoCoordinates getGeoCoordinate(String TopKanteId, boolean b_fromA, double distanceA1) {
        // Get TopEdge
        HashMap edgeRepo = PlanData.topGraph.edgeRepo;
        TopologyGraph.Edge edge = (TopologyGraph.Edge) edgeRepo.get(TopKanteId);
        if(edge.dTopLength < distanceA1) throw new IllegalArgumentException("The desired point must lay on the top edge.");
        ArrayList<CGEOKante> geoEdgeList = edge.getPaintListGeo();

        double lengthOfGeoEdges = 0;
        for(CGEOKante geoEdge : geoEdgeList) {
            lengthOfGeoEdges += geoEdge.getGEOKanteAllg().getGEOLaenge().getWert().doubleValue();
        }

        if (geoEdgeList.isEmpty() || Math.abs(edge.dTopLength - lengthOfGeoEdges) > 1) {
            GeoCoordinates nodeA = edge.A.getGeoCoordinates();
            GeoCoordinates nodeB = edge.B.getGeoCoordinates();

            if(geoEdgeList.isEmpty()) return createGeoCoordinates(b_fromA, edge.dTopLength, distanceA1, nodeA, nodeB);
            else {
                distanceA1 = distanceA1 * lengthOfGeoEdges / edge.dTopLength;
            }


        }

            double    prevDistance  = 0;
            double    geoEdgeLength = 0;
            CGEOKante geoEdge       = null;

            int i = b_fromA ? 0 : geoEdgeList.size();
            for(; (b_fromA && i < geoEdgeList.size() || !b_fromA && i > 0); i = b_fromA ? (i + 1) : (i - 1)) {
                geoEdge = geoEdgeList.get(i);
                geoEdgeLength = geoEdge.getGEOKanteAllg().getGEOLaenge().getWert().doubleValue();
                if(distanceA1 <= prevDistance + geoEdgeLength) break;
                prevDistance += geoEdgeLength;
            }
            return getGeoCoordinate(geoEdge, b_fromA, distanceA1 - prevDistance);
    }

    private static GeoCoordinates getGeoCoordinate(CGEOKante geoEdge, boolean b_fromA, double distance) {
        double geoEdgeLength = geoEdge.getGEOKanteAllg().getGEOLaenge().getWert().doubleValue();
        if(geoEdgeLength < distance) {
            throw new IllegalArgumentException("The desired point must lay on the geo edge.");
        }

        // Helper values for calculating the coordinates
        GeoCoordinates nodeA = PlanData.GeoNodeRepo.getModel(geoEdge.getIDGEOKnotenA().getWert());
        GeoCoordinates nodeB = PlanData.GeoNodeRepo.getModel(geoEdge.getIDGEOKnotenB().getWert());

        // Create a new Coordinates instance
        return createGeoCoordinates(b_fromA, geoEdgeLength, distance, nodeA, nodeB);
    }

    private static GeoCoordinates createGeoCoordinates(boolean b_fromA, double edgeLength, double distance, GeoCoordinates nodeA, GeoCoordinates nodeB) {
        GeoCoordinates coordinates = new GeoCoordinates();

        double ratio = distance / edgeLength;
        double dx = ratio * (b_fromA ?  nodeB.getX() - nodeA.getX() : nodeA.getX() - nodeB.getX());
        double dy = ratio * (b_fromA ?  nodeB.getY() - nodeA.getY() : nodeA.getY() - nodeB.getY());
        
        if(b_fromA) {
            coordinates.setX(nodeA.getX() + dx);
            coordinates.setY(nodeA.getY() + dy);
        } else {
            coordinates.setX(nodeB.getX() + dx);
            coordinates.setY(nodeB.getY() + dy);
        }
        return coordinates;
    }

    private static void drawArrowHead(Graphics2D g2d, Line2D.Double line) {
        double dx = line.x2 - line.x1;
        double dy = line.y2 - line.y1;
        double angle = -Math.atan2(dx, dy);

        double w = 2d;
        double h = 4d;

        //   o
        //   /\
        //ul/__\ ur

        Path2D.Double arrowHead = new Path2D.Double();
        arrowHead.moveTo((line.x2), (line.y2));

        // x cos(angle) - y sin(angle)
        // x sin(angle) + y cos(angle)

        double x_ulnew = line.x2 + (-w * Math.cos(angle)) - (-h * Math.sin(angle));
        double y_ulnew = line.y2 + (-w * Math.sin(angle)) + (-h * Math.cos(angle));

        double x_urnew = line.x2 + (w * Math.cos(angle)) - (-h * Math.sin(angle));
        double y_urnew = line.y2 + (w * Math.sin(angle)) + (-h * Math.cos(angle));


        arrowHead.lineTo(x_ulnew, y_ulnew);
        arrowHead.lineTo(x_urnew, y_urnew);
        arrowHead.closePath();
        g2d.fill(arrowHead);
    }

    /**
     * Schreibt sich ein als Impuls wann neugezeichnet werden soll
     * @param subscription
     */

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    /**
     * Andere Komponente ruft neuzeichnen herfor
     * @param planData - unused
     */
    @Override
    public void onNext(Object planData) {
        this.repaint();
        this.subscription.request(1);
    }

    /**
     * Fehler beim Neuzeichnen
     * @param throwable - Fehler
     */

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * definiert was in Zusatz getan wird wenn neuzeichnen ankommt.
     */
    @Override
    public void onComplete() {

    }
}
