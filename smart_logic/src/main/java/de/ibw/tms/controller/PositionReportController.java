package de.ibw.tms.controller;

import de.ibw.feed.Balise;
import de.ibw.tms.MainTmsSim;
import de.ibw.tms.data.store.DataStore;
import de.ibw.tms.ma.GeoCoordinates;
import de.ibw.tms.ma.physical.SingleSlip;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.ma.topologie.PositionedRelation;
import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.PlanProTmsAdapter;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.trackbased.TopologyFactory;
import de.ibw.tms.trackplan.controller.Intf.IController;
import de.ibw.tms.trackplan.ui.ZoomFrame;
import de.ibw.tms.train.model.TrainDistance;
import de.ibw.tms.train.model.TrainModel;
import de.ibw.util.DefaultRepo;
import de.ibw.util.DoubleCoord;
import de.ibw.util.UtilFunction;
import ebd.rbc_tms.payload.Payload_14;
import ebd.rbc_tms.util.PositionInfo;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CDatenpunkt;
import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.basistypen._1_9_0.ENUMWirkrichtung;
import plan_pro.modell.geodaten._1_9_0.CGEOKnoten;
import plan_pro.modell.geodaten._1_9_0.CTOPKante;
import plan_pro.modell.geodaten._1_9_0.CTOPKnoten;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

import static ebd.rbc_tms.util.ETCSVariables.*;

/**
 * Diese Komponente implementiert, was das TMS bei eingehenden PositionReports unternimmt.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class PositionReportController extends SubmissionPublisher implements IController {

    private static PositionReportController instance;




    /**
     * Die L&auml;nge des Zuges in Meter, falls das RBC keine Angabe gemacht hat.
     */
    public double D_DEFAULT_MIN_LENGTH = 10d;

    /**
     * Singelton zu diesem Controller
     * @return PositionReportController - Controller verwaltet PositionReports im TMS
     */
    public static PositionReportController getInstance() {
        if(instance == null) {
            instance = new PositionReportController();
        }
        return instance;
    }


    /**
     * Verwaltet eingehenden PositionReport
     * @param PositonReport - {@link Payload_14} - Informationen des Position-Reports
     * @param sRBC {@link String} - Name des RBC
     */
    public synchronized void servePositionReport(Payload_14 PositonReport, String sRBC) {
        boolean bSaveable = true;
        Integer iEngineId = null;
        TrainModel Tm = null;

        PlanProTmsAdapter refAdapter = PlanProTmsAdapter.getPlanAdapter();

        double dDistanceToTrainFromReferencePoint;

        try {
            boolean b_A_IsTarget = false;
            boolean b_TOP_NODE_PASSED = false;
            iEngineId = PositonReport.trainInfo.nid_engine;
            double distanceToNextTargetPoint = 0;
            Tm = TrainModel.TrainRepo.getModel(iEngineId);

            if (Tm == null) {
                Tm = initTrainModel(iEngineId);
            }
            int q_scale = PositonReport.positionInfo.q_scale;
            double distance_from_dp = PositonReport.positionInfo.d_lrbg;
            System.out.println("TMS " + "Engine ID: " + iEngineId + " POS_REP_Distance: " + distance_from_dp);
            int bgId = PositonReport.positionInfo.nid_lrbg;
            Tm.setNid_lrbg(bgId);
            Tm.setsLastKnownRBC(sRBC);
            Tm.setQ_DIR(PositonReport.positionInfo.q_dirtrain);
            Balise B = Balise.baliseByNid_bg.getModel(bgId);
            CTOPKante CurrentTopKante = B.getTopPositionOfDataPoint();
            ENUMWirkrichtung BalisReferenc = B.getPlanProDataPoint().getPunktObjektTOPKante().get(0).getWirkrichtung().getWert();


            //TODO
            double dDistanceFromRefPointToBalise = getdDistanceFromRefPointtoBalise(B);
            TopologyGraph.Edge E = PlanData.topGraph.EdgeRepo.get(CurrentTopKante.getIdentitaet().getWert());


            if(BalisReferenc.equals(ENUMWirkrichtung.GEGEN)) {
                System.out.println("TMS " + "Engine ID: " + iEngineId + " Distance from Node B To Balise: " + dDistanceFromRefPointToBalise);
            } else System.out.println("TMS " + "Engine ID: " + iEngineId + " Distance from Node A To Balise: " + dDistanceFromRefPointToBalise);
            System.out.println("Before TOP_KANTE_ID: " + CurrentTopKante.getIdentitaet().getWert());

            distance_from_dp = calcDistanceFromDP(q_scale, distance_from_dp);
            System.out.println("TMS " + "Engine ID: " + iEngineId + " POS_REP_Distance_RECOG_Q_SCALE: " + distance_from_dp);

            TopologyGraph topologyGraph = PlanData.topGraph;
            TopologyGraph.Node TargetNode = null;

            TopologyGraph.Edge NewTrainPositionEdge = topologyGraph.EdgeRepo.get(CurrentTopKante.getIdentitaet().getWert());
            if(NewTrainPositionEdge == null) {
                throw new NullPointerException("Balise Not on Track in TopologyGraph");
            }
            if(PositonReport.positionInfo.q_dirtrain == Q_DIRTRAIN_NOMINAL) {
                TargetNode = NewTrainPositionEdge.B;
                distanceToNextTargetPoint = dDistanceFromRefPointToBalise;
                dDistanceToTrainFromReferencePoint = NewTrainPositionEdge.dTopLength - dDistanceFromRefPointToBalise  + distance_from_dp;
                b_A_IsTarget = false;

            } else if(PositonReport.positionInfo.q_dirtrain == Q_DIRTRAIN_REVERSE) {
                TargetNode = NewTrainPositionEdge.A;
                distanceToNextTargetPoint = dDistanceFromRefPointToBalise;
                dDistanceToTrainFromReferencePoint = dDistanceFromRefPointToBalise  - distance_from_dp;
                b_A_IsTarget = true;
            } else {
                throw new InvalidParameterException("Q_DirTrain is not nominal and not reverse");
            }
            System.out.println("TMS " + "Engine ID: " + iEngineId + " DistanceToNextWaypoint: " + distanceToNextTargetPoint);
            if(distanceToNextTargetPoint < 5.0d) distanceToNextTargetPoint = 5.0d;


            while(distance_from_dp > distanceToNextTargetPoint) {

                b_TOP_NODE_PASSED = true;
                TopologyGraph.Edge TempPosEdge = findNewTrainPosition(NewTrainPositionEdge, TargetNode);
                if(TempPosEdge.A == TargetNode) {
                    TargetNode = TempPosEdge.B;
                    b_A_IsTarget = false;
                } else if(TempPosEdge.B == TargetNode) {
                    TargetNode = TempPosEdge.A;
                    b_A_IsTarget = true;
                } else {
                    throw new Exception("Node missmatch, cannot find node connection");
                }
                NewTrainPositionEdge = TempPosEdge;
                dDistanceToTrainFromReferencePoint = distance_from_dp - distanceToNextTargetPoint;

                System.out.println("TMS " + "Engine ID: " + iEngineId + " DistanceToTrainFromReferencePoint: " + dDistanceToTrainFromReferencePoint);
                distanceToNextTargetPoint = distanceToNextTargetPoint + NewTrainPositionEdge.dTopLength;
                System.out.println("TMS " + "Engine ID: " + iEngineId + " DistanceToNextWaypoint: " + distanceToNextTargetPoint);


            }

            Tm = handleTrainLength(Tm, PositonReport.positionInfo);


            DoubleCoord CoordTrainFront = new DoubleCoord();
            DoubleCoord CoordTrainEnd = new DoubleCoord();
            //dDistanceToTrainFromReferencePoint = distanceToNextTargetPoint - distance_from_dp;



            DefaultRepo<String, CBasisObjekt> geoPointRepo = PlanData.getInstance().getGeoBundle().getModel(CGEOKnoten.class);
            DefaultRepo<String, CBasisObjekt> topNodeRepo = PlanData.getInstance().getGeoBundle().getModel(CTOPKnoten.class);

            //CTOPKante TopKante =  B.getTopPositionOfDataPoint();
            String sKnotenAid = NewTrainPositionEdge.A.TopNodeId;
            String sKnotenBid = NewTrainPositionEdge.B.TopNodeId;
            CTOPKnoten N_A = (CTOPKnoten) topNodeRepo.getModel(sKnotenAid);
            CTOPKnoten N_B = (CTOPKnoten) topNodeRepo.getModel(sKnotenBid);
            CGEOKnoten GeoNodeA = (CGEOKnoten) geoPointRepo.getModel(N_A.getIDGEOKnoten().getWert());
            CGEOKnoten GeoNodeB = (CGEOKnoten) geoPointRepo.getModel(N_B.getIDGEOKnoten().getWert());
            GeoCoordinates Geo_A = PlanData.GeoNodeRepo.getModel(GeoNodeA.getIdentitaet().getWert());
            GeoCoordinates Geo_B = PlanData.GeoNodeRepo.getModel(GeoNodeB.getIdentitaet().getWert());

            Line2D.Double resultPainting = new Line2D.Double();
            double d_distance_from_referencePointToTrainEnd = dDistanceToTrainFromReferencePoint - Tm.length;
            double d_DistanceTrainToTargetPoint = 0d;
            if(TargetNode == NewTrainPositionEdge.A) {
                // TargetNode is A => Train comes from B

                // Geo_B is referencePoint
                CoordTrainFront = (DoubleCoord) UtilFunction.calcTargetGeoByStartPoint(CoordTrainFront,
                        -dDistanceToTrainFromReferencePoint, Geo_B, Geo_A);



                CoordTrainEnd = (DoubleCoord) UtilFunction.calcTargetGeoByStartPoint(CoordTrainEnd,
                        -d_distance_from_referencePointToTrainEnd, Geo_B, Geo_A);

                    if(dDistanceToTrainFromReferencePoint < 0) {
                        d_DistanceTrainToTargetPoint = NewTrainPositionEdge.dTopLength -1 ;
                    } else d_DistanceTrainToTargetPoint = dDistanceToTrainFromReferencePoint;



                Tm.setdDistanceToNodeRunningTo(d_DistanceTrainToTargetPoint);

            } else if(TargetNode == NewTrainPositionEdge.B) {
                // TargetNode is B => Train comes from A

                // Geo_A is referencePoint
                CoordTrainFront= (DoubleCoord) UtilFunction.calcTargetGeoByStartPoint(CoordTrainFront,
                        dDistanceToTrainFromReferencePoint, Geo_A, Geo_B);
                CoordTrainEnd = (DoubleCoord) UtilFunction.calcTargetGeoByStartPoint(CoordTrainEnd,
                        d_distance_from_referencePointToTrainEnd, Geo_A, Geo_B);

                    d_DistanceTrainToTargetPoint = NewTrainPositionEdge.dTopLength - dDistanceToTrainFromReferencePoint;

                Tm.setdDistanceToNodeRunningTo(d_DistanceTrainToTargetPoint);

            } else {
                throw new Exception("Node missmatch, cannot find node connection");
            }

            resultPainting = new Line2D.Double(CoordTrainEnd.getX(), CoordTrainEnd.getY(), CoordTrainFront.getX(),
                                    CoordTrainFront.getY());

            Tm.setTrainUiLine(resultPainting);
            Tm.setEdgeTrainStandsOn(NewTrainPositionEdge);
            System.out.println("Result TOP_KANTE: " + NewTrainPositionEdge.sId);
            Tm.setNodeTrainRunningTo(TargetNode);
            System.out.println(("Result TOP_NODE drivingTo: " + TargetNode.TopNodeId));
            TrainDistance TD = null;
            //DEBUG
            if(b_A_IsTarget == true) {
                double d1 = NewTrainPositionEdge.dTopLength - d_distance_from_referencePointToTrainEnd;
               if(d1 > NewTrainPositionEdge.dTopLength) {
                   d1 = NewTrainPositionEdge.dTopLength - 1;
               }
                double d2 = NewTrainPositionEdge.dTopLength - dDistanceToTrainFromReferencePoint;
               if(d2 - d1 < 5.0d) {
                   d2 -= 5.0d;
                   if(d2 < 0){
                       d2 = 1;
                   }
               }
               TD = new TrainDistance(false,d2, d1);
            } else {
                double d1 = NewTrainPositionEdge.dTopLength;
                if(d_distance_from_referencePointToTrainEnd > 0) {
                    d1 = NewTrainPositionEdge.dTopLength - d_distance_from_referencePointToTrainEnd;
                }
                double d2 = NewTrainPositionEdge.dTopLength - dDistanceToTrainFromReferencePoint;
                TD = new TrainDistance(true, d2,d1);
            }
            Tm.setDistanceRefPointOfEdge(TD);


        } catch(Exception E) {
            E.printStackTrace();
            bSaveable = false;
        }
        if(bSaveable) {

            TrainModel.TrainRepo.update(iEngineId, Tm);

            DataStore.getInstance().update(PositonReport);
            this.publish();
        }
        MainTmsSim.MainFrame.repaint();
    }

    private double getdDistanceFromRefPointtoBalise(Balise b) {
        CDatenpunkt DataPoint = b.getPlanProDataPoint();
        CTOPKante Top = b.getTopPositionOfDataPoint();


        if(DataPoint.getPunktObjektTOPKante().get(0).getWirkrichtung().getWert().equals(ENUMWirkrichtung.GEGEN)) {
            // change A and B
            double lengthOfTopEdge = Top.getTOPKanteAllg().getTOPLaenge().getWert().doubleValue();
            return lengthOfTopEdge - DataPoint.getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue();
        } else return DataPoint.getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue();
    }

    private TrainModel handleTrainLength(TrainModel tm, PositionInfo positionInfo) {
        if(positionInfo.q_length == Q_LENGTH_CONFIRMED_BY_DRIVER ||
                positionInfo.q_length == Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE) {
                    tm.length = positionInfo.l_trainint;
        } else {
            tm.length = D_DEFAULT_MIN_LENGTH;
        }
        return tm;
    }

    private TopologyGraph.Edge findNewTrainPosition(TopologyGraph.Edge newTrainPositionEdge, TopologyGraph.Node targetNode) throws Exception {
        TopologyGraph.Node targetN = targetNode;
        Rail Rail_Current = newTrainPositionEdge.getRail();
        CrossoverModel CrossoverMod = CrossoverModel.CrossoverRepo.getModel(targetN);
        if(CrossoverMod == null) {
            // Train stands on endpoint.

            System.out.println("Trains stands on Endpoint");
            return newTrainPositionEdge;

        }
        SingleSlip Slip = CrossoverMod.getRailWaySlip();
        PositionedRelation PosRel = Slip.getOutputRelation();
        TrackElement TE_From = PosRel.getFrom();
        TrackElement TE_To = PosRel.getTo();
        Rail R_From = (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(TE_From);
        Rail R_To = (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(TE_To);
        Rail R_Next = null;
        if(R_From == Rail_Current) {
            R_Next = R_To;
        } else if (R_To == Rail_Current) {
            R_Next = R_From;
        } else {
            throw new Exception("Next Rail for Position Report not found");
        }
        newTrainPositionEdge = R_Next.getEdge();
        if(newTrainPositionEdge == null) {
            throw new NullPointerException("Balise Not on Track in TopologyGraph");
        }

        return newTrainPositionEdge;
    }

    private double calcDistanceFromDP(int q_scale, double distance_from_dp) {
        switch (q_scale) {
            case Q_SCALE_10CM: {
                distance_from_dp = distance_from_dp * 0.1d;
                break;
            }
            case Q_SCALE_1M: {

                break;
            }
            case Q_SCALE_10M: {
                distance_from_dp = distance_from_dp * 10.0d;
                break;
            }
        }
        return distance_from_dp;
    }

    private TrainModel initTrainModel(Integer iEngineId) {
        TrainModel Tm;
        Tm = TrainModel.getDefaultModel();
        Tm.label = String.valueOf(iEngineId);
        Tm.iTrainId = iEngineId;
        Tm.category = "Freight";
        //Package Train Data
        Tm.iSpeedMax = 200;
        Tm.length = 100;
        return Tm;
    }

    /**
     * Dieser Controller sendet Nachricht an alle Komponenten des TMS, die sich eingeschrieben haben,
     * dass es einen neuen PositionReport gab.
     */
    @Override
    public void publish() {
        this.standardSubscription();
        this.submit("Apply Position of Reports");
    }


    /**
     * Eine Liste von eintragenen Empf&auml;ngern, die Nachricht erhalten, wenn PositionReports eintreffen.
     * Dazu geh&ouml;ren das Zoom-Fenster und Panels das TMS-Hauptfenster und die Fenster, die zum erstellen von
     * MAs ge&ouml;ffnet wurden.
     * @return List - eine Liste von Empf&auml;ngern
     */
    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        ArrayList<JPanel> panels = MainTmsSim.trackPanelRepository;
        ArrayList<Flow.Subscriber> returnList = new ArrayList<>();
        for(JPanel P: panels) {
            if(P != null) {
                if(P.isVisible()) {
                    returnList.add((Flow.Subscriber) P);
                }
            }
        }
        returnList.add(ZoomFrame.getPositionSubscriber());

        return returnList;
    }
}

