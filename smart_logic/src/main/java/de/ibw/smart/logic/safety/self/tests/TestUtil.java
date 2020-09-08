package de.ibw.smart.logic.safety.self.tests;

import de.ibw.feed.Balise;
import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.train.model.TrainModel;
import ebd.rbc_tms.util.ETCSVariables;
import ebd.rbc_tms.util.MA;
import ebd.rbc_tms.util.SpeedProfile;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.concurrent.Flow;

/**
 * Test Werkzeuge, die zum Testen der Smart-Logic eingesetzt werden
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-09-04
 */
public class TestUtil {

    public static Balise lastRandomBalise = null;


    /**
     * Test-Strecke aus zuf&auml;lligen zusammenh&auuml;ngenden Strecken
     * @param iTargetAmountOfRouteElements int - Anzahl der Elemente bzw. L&auml;nge der Strecke
     * @param beginnOnEdge boolean - true Teststrecke beginnt auf Kante
     * @return Zufallsstrecke
     */
    public static ArrayList<Pair<Route.TrackElementType, TrackElement>> generateRandomContinousRoute(int iTargetAmountOfRouteElements,
                                 boolean beginnOnEdge, boolean beginnEdgeHasBalise
             ) {
        SmartSafetyContinousConnectTest Submodul = new SmartSafetyContinousConnectTest();
        return Submodul.generateRandomContinousRoute(iTargetAmountOfRouteElements, beginnOnEdge, beginnEdgeHasBalise);
    }

    /**
     * Diese Methode gibt einen MaRequestWrapper wider. Er enthält Routen-Daten und Informationen zum Erstellen der MA
     * @param iTrainId int - Nid-Engine-ID des betroffenen Zuges
     * @param dDistanceToNodeRunningTo double - Distanz zur n&auml;chst-m&ouml;glichen Zielknoten Topologischer-Knoten
     * @param sIdTopEdgeStandingOn {@link String} - Id der Topologischen Kante auf dem der Zug steht.
     * @param sidNodeRunnintTo {@link String} -  Id des Topologischen Knoten zu dem der Zug hinsteuert.
     * @param iLengthOfTrain int - L&auml;nge des Zuges
     * @return MaRequestWrapper - Der Request eienr MA an die SL
     */
    public static MaRequestWrapper preserveRequest4NonBlockedTest(int iTrainId, double dDistanceToNodeRunningTo,
                                                                  String sIdTopEdgeStandingOn,
                                                                  String sidNodeRunnintTo, int iLengthOfTrain



    ) {
        PlanData.getInstance();

        TopologyGraph.Edge E = PlanData.topGraph.EdgeRepo.get(sIdTopEdgeStandingOn);
        TopologyGraph.Node N = TopologyGraph.NodeRepo.get(sidNodeRunnintTo);
        TrainModel Tm = new TrainModel();
        Tm.setNid_lrbg(iTrainId);
        Tm.iTrainId = iTrainId;
        Tm.setdDistanceToNodeRunningTo(dDistanceToNodeRunningTo);
        Tm.setEdgeTrainStandsOn(E);
        Tm.setNodeTrainRunningTo(N);
        Tm.length = iLengthOfTrain;

        MARequest MaR = new MARequest();

        MaRequestWrapper Result = new MaRequestWrapper(MaR);
        Result.Tm = Tm;
        return Result;
    }

    /**
     * Generiert eine Ma f&uuml;r das RBC
     * @param eoaAda {@link EoaAdapter} - eine erweiterte EOA
     * @param iQScale int - QScale der EOA
     * @return RbcMaAdapter - eine erweiterte Ma
     */
    public static RbcMaAdapter preserveMA4NonBlockedTest(EoaAdapter eoaAda, int iQScale) {

        int iLength = eoaAda.sections.get(0).l_section;

        ArrayList<ebd.rbc_tms.util.GradientProfile.Gradient> gradients = new ArrayList<>();
        gradients.add(new ebd.rbc_tms.util.GradientProfile.Gradient(iLength, ETCSVariables.Q_GDIR_UPHILL, 0));
        ebd.rbc_tms.util.GradientProfile GradProfile = new ebd.rbc_tms.util.GradientProfile(1,
                Q_SCALE.SCALE_1_M.flag, gradients);
        SpeedProfile SpeedProfile = new SpeedProfile(1, Q_SCALE.SCALE_1_M.flag);
        MA Ma = new MA(false,0,0, iQScale, eoaAda,GradProfile, SpeedProfile,null,null );
        RbcMaAdapter Result = new RbcMaAdapter(Ma);
        return Result;

    }






}
