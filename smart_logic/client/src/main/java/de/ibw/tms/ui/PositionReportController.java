package de.ibw.tms.ui;



import de.ibw.feed.Balise;
import de.ibw.history.PositionData;
import de.ibw.history.PositionModul;
import de.ibw.history.data.PositionEnterType;
import de.ibw.smart.logic.intf.messages.Converter;
import de.ibw.tms.MainTmsSim;
import de.ibw.tms.data.store.DataStore;
import de.ibw.tms.entities.TmsJpaApp;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.controller.Intf.IController;
import de.ibw.tms.trackplan.ui.ZoomFrame;
import de.ibw.tms.train.model.TrainDistance;
import de.ibw.tms.train.model.TrainModel;
import de.ibw.util.DefaultRepo;
import de.ibw.util.DoubleCoord;
import ebd.internal.Message;
import ebd.internal.payload.Payload_14;
import ebd.internal.util.PositionInfo;
import ebd.internal.util.TrainInfo;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.rbc_tms.message.rbc.ETCSTrainMessage;
import org.jetbrains.annotations.NotNull;
import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.geodaten._1_9_0.CGEOKnoten;
import plan_pro.modell.geodaten._1_9_0.CTOPKante;
import plan_pro.modell.geodaten._1_9_0.CTOPKnoten;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

import static ebd.messageLibrary.util.ETCSVariables.*;

/**
 * Diese Komponente implementiert, was das TMS bei eingehenden PositionReports unternimmt.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.5
 * @since 2021-04-08
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
     * Berechnet die Distanz zum n&auml;chsten Knoten von einem Knoten f&uuml;r einen Zug
     * @param TrM {@link TrainModel} - Modell des Zuges, f&uuml;r den eine Berechnung folgt.
     * @return BigDecimal - Entfernung in meter
     */
    /*public static BigDecimal calcDistanceToFirstNodeOfTrainViaBalise(TrainModel TrM) {
        boolean isNominal;
        int iEngineId = TrM.iTrainId;
        TopologyGraph.Edge NewTrainPositionEdge = TrM.getEdgeTrainStandsOn();
        Balise B = Balise.baliseByNid_bg.getModel(TrM.getNid_lrbg());
        if(B == null) return null;
        BigDecimal distanceToNextTargetPoint;
        BigDecimal dLengthOfEdge = new BigDecimal(NewTrainPositionEdge.dTopLength);
        BigDecimal trackMeterOfBalise = new BigDecimal(B.getPlanProDataPoint().getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue());

        if(iEngineId == 1) {

            isNominal = ConfigHandler.getInstance().train1StartingInTrackDirection;
        } else if(iEngineId == 2) {
            isNominal = ConfigHandler.getInstance().train2StartingInTrackDirection;

        } else return null;
        TopologyGraph.Node TargetNode;
        if(isNominal) {






            distanceToNextTargetPoint = dLengthOfEdge.subtract(trackMeterOfBalise);




        } else {


            distanceToNextTargetPoint = trackMeterOfBalise;


        }

        return distanceToNextTargetPoint.abs();
    }
*/

    /**
     * Verwaltet eingehenden PositionReport
     *
     */
    public synchronized void servePositionReport(ebd.rbc_tms.message.Message M) {
        //oldPositionReportHandler(PositonReport, sRBC);
        new Thread() {
            @Override
            public void run() {
                try {
                    PositionPacket ppMessage = null;
                    ETCSTrainMessage P_PosWithinTrainMessage = (ETCSTrainMessage) M;
                    int nidTrain = P_PosWithinTrainMessage.nid_engine;
                    ebd.messageLibrary.message.Message LibMessage = P_PosWithinTrainMessage.etcsMessage;
                    try {
                        ppMessage = Converter.retrievePosPacket(LibMessage);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                        return;
                    }

                    PositionInfo posInf = Converter.generateByPositionPacke(ppMessage);
                    PositionData PD = new PositionData(M.timestamp, System.currentTimeMillis(),
                            nidTrain, posInf);
                    System.out.println("Train " + nidTrain + ": distance " + PD.getPos().d_lrbg + " to " +
                            PD.getPos().nid_lrbg + "StartDir: " + PD.getPos().q_dlrbg

                    );
                    PositionModul.getInstance().addPositionData(PD, PositionEnterType.ENTERED_VIA_POSITION_REPORT);
                    TmsJpaApp.TmsFramer.repaint();
                    getTrainModel(nidTrain);
                    logTrain(nidTrain, posInf);
                } catch(InvalidParameterException IPE) {
                    IPE.printStackTrace();
                    System.err.println("TMS is Shuting down");
                    System.exit(-1);
                }
            }
        }.start();



    }

    private void logTrain(int nid_train, PositionInfo posInf) {
        System.out.println("Train " + nid_train + " has length: " + posInf.l_trainint);

    }

    private void oldPositionReportHandler(Payload_14 PositonReport, String sRBC) {
        boolean bSaveable = true;
        Integer iEngineId = null;
        TrainModel Tm = null;


        try {
            boolean b_A_IsTarget = false;
            iEngineId = PositonReport.trainInfo.nid_engine;
            BigDecimal distanceToNextTargetPoint = null;
            Tm = getTrainModel(iEngineId);
            int q_scale = PositonReport.positionInfo.q_scale;
            BigDecimal distance_from_dp = new BigDecimal(PositonReport.positionInfo.d_lrbg);
            System.out.println("TMS " + "Engine ID: " + iEngineId + " POS_REP_Distance: " + distance_from_dp);
            int bgId = PositonReport.positionInfo.nid_lrbg;
            Tm.setNid_lrbg(bgId);
            Tm.setsLastKnownRBC(sRBC);
            Tm.setQ_DIR(PositonReport.positionInfo.q_dirtrain);
            Balise B = Balise.baliseByNid_bg.getModel(bgId);
            CTOPKante CurrentTopKante = B.getTopPositionOfDataPoint();



            BigDecimal trackMeterOfBalise = new BigDecimal(B.getPlanProDataPoint().getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue());




            /*if(BalisReferenc.equals(ENUMWirkrichtung.GEGEN)) {
                System.out.println("TMS " + "Engine ID: " + iEngineId + " Distance from Node B To Balise: " + dDistanceFromRefPointToBalise);
            } else System.out.println("TMS " + "Engine ID: " + iEngineId + " Distance from Node A To Balise: " + dDistanceFromRefPointToBalise);
            System.out.println("Before TOP_KANTE_ID: " + CurrentTopKante.getIdentitaet().getWert());
            */
            distance_from_dp = calcDistanceFromDP(q_scale, distance_from_dp);
            System.out.println("TMS " + "Engine ID: " + iEngineId + " POS_REP_Distance_RECOG_Q_SCALE: " + distance_from_dp);

            TopologyGraph topologyGraph = PlanData.topGraph;
            TopologyGraph.Node TargetNode = null;

            TopologyGraph.Edge NewTrainPositionEdge = topologyGraph.edgeRepo.get(CurrentTopKante.getIdentitaet().getWert());
            if(NewTrainPositionEdge == null) {
                throw new NullPointerException("Balise Not on Track in TopologyGraph");
            }
            BigDecimal dLengthOfEdge = new BigDecimal(NewTrainPositionEdge.dTopLength);
            Boolean isNominal;
            if(iEngineId == 1) {
                isNominal = null;
                //isNominal = ConfigHandler.getInstance().train1StartingInTrackDirection;
            } else if(iEngineId == 2) {
                //isNominal = ConfigHandler.getInstance().train2StartingInTrackDirection;
                isNominal = null;
            } else return;
            if(isNominal == null) {
                isNominal = true;

            } if(isNominal) {
                TargetNode = NewTrainPositionEdge.B;





                distanceToNextTargetPoint = dLengthOfEdge.subtract(trackMeterOfBalise);


                b_A_IsTarget = false;

            } else {
                TargetNode = NewTrainPositionEdge.A;

                distanceToNextTargetPoint = trackMeterOfBalise;

                b_A_IsTarget = true;
            }

            Tm.setNodeTrainRunningTo(TargetNode);
            distanceToNextTargetPoint = distanceToNextTargetPoint.abs();
            Tm.setdDistanceToNodeRunningTo(distanceToNextTargetPoint.doubleValue());


            System.out.println("TMS " + "Engine ID: " + iEngineId + " DistanceToNextWaypoint: " + distanceToNextTargetPoint);

            while(distance_from_dp.compareTo(distanceToNextTargetPoint) > 0 ) {

                TopologyGraph.Edge TempPosEdge = findNewTrainPosition(NewTrainPositionEdge, TargetNode);
                Tm.addPassedElement(NewTrainPositionEdge);
                Tm.addPassedElement(TargetNode);
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
                //dDistanceToTrainFromReferencePoint = distance_from_dp.subtract(distanceToNextTargetPoint);

                //System.out.println("TMS " + "Engine ID: " + iEngineId + " DistanceToTrainFromReferencePoint: " + dDistanceToTrainFromReferencePoint);
                distanceToNextTargetPoint = calcNextTargetPointDistanc(distanceToNextTargetPoint, NewTrainPositionEdge, Tm);//distanceToNextTargetPoint + NewTrainPositionEdge.dTopLength;
                System.out.println("TMS " + "Engine ID: " + iEngineId + " DistanceToNextWaypoint: " + distanceToNextTargetPoint);


            }

            distanceToNextTargetPoint = distanceToNextTargetPoint.subtract(distance_from_dp);



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


            Tm.setEdgeTrainStandsOn(NewTrainPositionEdge);
            double distanceToBackOfTrain = distanceToNextTargetPoint.add(new BigDecimal(Tm.length)).doubleValue();
            if(distanceToBackOfTrain > NewTrainPositionEdge.dTopLength) {
                distanceToBackOfTrain = NewTrainPositionEdge.dTopLength -1;
            }
            TrainDistance TD = new TrainDistance(b_A_IsTarget, distanceToNextTargetPoint.doubleValue(), distanceToBackOfTrain);
            Tm.setNodeTrainRunningTo(TargetNode);
            /*

            MainGraphicPanel.getGeoCoordinate(NewTrainPositionEdge.sId, !b_A_IsTarget)


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

            double d1 = NewTrainPositionEdge.dTopLength - d_DistanceTrainToTargetPoint;
            if(d1 > NewTrainPositionEdge.dTopLength) {
                d1 = NewTrainPositionEdge.dTopLength - 1;
            } else if(d1 < 0) d1 = 0;

            double d2 = d1 - Tm.length;
            if(d2 < 0) d2 = 0;


            TD = new TrainDistance(b_A_IsTarget ,d2, d1);
            */
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
        TmsJpaApp.TmsFramer.tmsFrame.repaint();
    }

    @NotNull
    private synchronized TrainModel getTrainModel(Integer iEngineId) {
        TrainModel Tm;
        Tm = TrainModel.TrainRepo.getModel(iEngineId);

        if (Tm == null) {
            Tm = initTrainModel(iEngineId);
            TrainModel.TrainRepo.update(iEngineId, Tm);
        }
        return Tm;
    }

    private BigDecimal calcNextTargetPointDistanc(BigDecimal distanceToNextTargetPoint, TopologyGraph.Edge newTrainPositionEdge, TrainModel tm) {
        BigDecimal result = null;

        result = new BigDecimal(newTrainPositionEdge.dTopLength);
        return distanceToNextTargetPoint.add(result);



    }
    /*
    private double getdDistanceFromRefPointtoBalise(Balise b) {
        CDatenpunkt DataPoint = b.getPlanProDataPoint();
        CTOPKante Top = b.getTopPositionOfDataPoint();
        return DataPoint.getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue();


        if(DataPoint.getPunktObjektTOPKante().get(0).getWirkrichtung().getWert().equals(ENUMWirkrichtung.GEGEN)) {
            // change A and B
            double lengthOfTopEdge = Top.getTOPKanteAllg().getTOPLaenge().getWert().doubleValue();
            return lengthOfTopEdge - DataPoint.getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue();
        } else return DataPoint.getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue();

    }*/


    private TrainModel handleTrainLength(TrainModel tm, PositionInfo positionInfo) {
        /*if(positionInfo.q_length == Q_LENGTH_CONFIRMED_BY_DRIVER ||
                positionInfo.q_length == Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE) {
            tm.length = positionInfo.l_trainint;
        } else {
            tm.length = D_DEFAULT_MIN_LENGTH;
        }
        */
        if(positionInfo.l_trainint != null)
            tm.length = positionInfo.l_trainint;
        else tm.length = D_DEFAULT_MIN_LENGTH;
        return tm;
    }

    /**
     * new Position by Route
     * @param newTrainPositionEdge
     * @param targetNode
     * @return
     * @throws Exception
     */
    private TopologyGraph.Edge findNewTrainPosition(TopologyGraph.Edge newTrainPositionEdge, TopologyGraph.Node targetNode) throws Exception {
        return newTrainPositionEdge;

        /*
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
        */

    }

    private BigDecimal calcDistanceFromDP(int q_scale, BigDecimal distance_from_dp) {
        switch (q_scale) {
            case Q_SCALE_10CM: {
                distance_from_dp = distance_from_dp.multiply(new BigDecimal(0.1d));
                break;
            }
            case Q_SCALE_1M: {

                break;
            }
            case Q_SCALE_10M: {
                distance_from_dp = distance_from_dp.multiply(new BigDecimal(10.0d));
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
        if(TmsJpaApp.colorsOfEtcsTrains != null) {
            try {

                Color etcsColor = TmsJpaApp.colorsOfEtcsTrains.getColorForEtcsString(String.valueOf(iEngineId));
                Tm.RepresentedColor = etcsColor;
            } catch (InvalidParameterException IPE) {
                IPE.printStackTrace();
            }

        }
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

