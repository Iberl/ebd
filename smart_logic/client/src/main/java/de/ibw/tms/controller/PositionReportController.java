package de.ibw.tms.controller;

import de.ibw.feed.Balise;
import de.ibw.tms.MainTmsSim;
import de.ibw.tms.data.store.DataStore;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.controller.Intf.IController;
import de.ibw.tms.trackplan.ui.ZoomFrame;
import de.ibw.tms.train.model.TrainModel;
import de.ibw.util.UtilFunction;
import ebd.SlConfigHandler;
import ebd.internal.payload.Payload_14;
import ebd.internal.util.PositionInfo;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;


import static ebd.messageLibrary.util.ETCSVariables.*;

/**
 * Diese Komponente implementiert, was das TMS bei eingehenden PositionReports unternimmt.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-08-25
 */
public class PositionReportController extends SubmissionPublisher implements IController {

    private static PositionReportController instance;






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
    public static BigDecimal calcDistanceToFirstNodeOfTrainViaBalise(TrainModel TrM) {
        boolean isNominal;
        int iEngineId = TrM.iTrainId;
        TopologyGraph.Edge NewTrainPositionEdge = TrM.getEdgeTrainStandsOn();
        Balise B = Balise.baliseByNid_bg.getModel(TrM.getNid_lrbg());
        if(B == null) return null;
        BigDecimal distanceToNextTargetPoint;
        BigDecimal dLengthOfEdge = new BigDecimal(NewTrainPositionEdge.dTopLength);
        BigDecimal trackMeterOfBalise = new BigDecimal(B.getPlanProDataPoint().getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue());

        if(iEngineId == 1) {

            isNominal = SlConfigHandler.getInstance().train1StartingInTrackDirection;
        } else if(iEngineId == 2) {
            isNominal = SlConfigHandler.getInstance().train2StartingInTrackDirection;

        } else return null;
        TopologyGraph.Node TargetNode;
        if(isNominal) {






            distanceToNextTargetPoint = dLengthOfEdge.subtract(trackMeterOfBalise);




        } else {


            distanceToNextTargetPoint = trackMeterOfBalise;


        }

        return distanceToNextTargetPoint.abs();
    }


    /**
     * Verwaltet eingehenden PositionReport
     * @param PositionReport - {@link Payload_14} - Informationen des Position-Reports
     * @param sRBC {@link String} - Name des RBC
     */
    public synchronized void servePositionReport(Payload_14 PositionReport, String sRBC) {
        boolean bSaveable = true;
        Integer iEngineId = null;




        //Old function
        TrainModel Tm = UtilFunction.servePositionReport(PositionReport, sRBC);


        if(Tm != null) {
            iEngineId = PositionReport.trainInfo.nid_engine;
            TrainModel.TrainRepo.update(iEngineId, Tm);

            DataStore.getInstance().update(PositionReport);
            this.publish();
        }
        MainTmsSim.MainFrame.repaint();
    }

    private BigDecimal calcNextTargetPointDistance(BigDecimal distanceToNextTargetPoint, TopologyGraph.Edge newTrainPositionEdge, TrainModel tm) {
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
        tm.length = UtilFunction.getTrainLength(positionInfo).intValue();
        return tm;
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

