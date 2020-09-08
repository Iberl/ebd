package de.ibw.smart.logic.safety;

import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.smart.logic.safety.self.tests.TestUtil;
import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.ma.EoaAdapter;
import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.ma.RbcMaAdapter;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.DefaultRepo;
import ebd.rbc_tms.util.EOA;
import ebd.rbc_tms.util.ETCSVariables;
import ebd.rbc_tms.util.PositionInfo;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Die Smart-Logic hat ein Submodul, das pr&uuml;ft, ob blockierte Elemente vorhanden sind.
 * Dieser Test stellt die funktionale Korrektheit sicher
 */


class SmartSafetyRouteIsNonBlockedTest {

    @Spy
    SmartSafety Safety = SmartSafety.getSmartSafety();


    @BeforeAll
    public static void setupSL() {
        SmartLogic.main(null);
    }

    @BeforeEach
    public void initTestEnv() throws InterruptedException {
        SmartSafety.getSmartSafety().resetAllBlockings();
        SmartSafety.lastPositionReport = new DefaultRepo<>();

    }




    /**
     * Pr&uuml;ft ob Null-Werte als Anfrage abgefangen werden
     */
    @Test
    public void checkIfMainNullError() throws InterruptedException {

        SmartSafety ModulUnderTest = SmartSafety.getSmartSafety();
        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListe =
            TestUtil.generateRandomContinousRoute(3, true, false);
        TopologyGraph.Edge E = (TopologyGraph.Edge) routenListe.get(0).getValue();
        TopologyGraph.Node N = (TopologyGraph.Node) routenListe.get(1).getValue();


        EoaAdapter eoaAda = generateEoa(300);

        RbcMaAdapter RbcMa = TestUtil.preserveMA4NonBlockedTest(eoaAda, Q_SCALE.SCALE_1_M.flag);
        MaRequestWrapper MRW = TestUtil.preserveRequest4NonBlockedTest(1,100d, E.sId,
               N.TopNodeId , 10);



            assertEquals(false, ModulUnderTest.checkIfRouteIsNonBlocked(null, RbcMa, routenListe));

            assertEquals(false,  ModulUnderTest.checkIfRouteIsNonBlocked(MRW, null, routenListe));
            assertEquals(false, ModulUnderTest.checkIfRouteIsNonBlocked(MRW, RbcMa, null));



    }


    @NotNull
    public EoaAdapter generateEoa(int l_SectionSum) {
        EOA eoa = new EOA(0,0, Q_SCALE.SCALE_1_M.flag, 0,null,null, null);
        eoa.sections = new ArrayList<>();
        eoa.sections.add(new EOA.Section(l_SectionSum,false,null,null));
        eoa.endTimer = new EOA.EndTimer(ETCSVariables.T_ENDTIMER_INFINITY, ETCSVariables.D_ENDTIMERSTARTLOC);
        EoaAdapter eoaAda = new EoaAdapter(eoa);
        return eoaAda;
    }

    /**
     * Pr&uuml;ft ob Smart-Logic zwei uberlappende MAs auf einem Streckenabschnitt erkannt werden.
     */
    @Test
    public void checkIfTracksAreBlockedByTwoTrainsOnSameTrack() throws InterruptedException {


        // zwei Züge blockieren auf der gleichen Strecke
        int iTrainOne = 1;
        int iTrainTwo = 2;
        BigDecimal dTrainToNextPointOne;
        BigDecimal dTrainToNextPointTwo;
        String sidEdgeBothTrainsStandingOn;
        String sidNodeBothTrainsRunningTo;
        int iLengthTrainOne = 1;
        int iLengthTrainTwo = 2;





        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListe =
                TestUtil.generateRandomContinousRoute(7, true, true);
        int iMaxLength = calcMaxLengthOfTrack(routenListe);
        Pair<Route.TrackElementType, TrackElement> StartTrail = routenListe.get(0);
        Pair<Route.TrackElementType, TrackElement> FirstWaypoint = routenListe.get(1);

        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListeNEW4TEST = new ArrayList<>();
        routenListeNEW4TEST.add(routenListe.get(0));

        int iLengthFirstTrail = (int) ((TopologyGraph.Edge) StartTrail.getRight()).dTopLength;
        dTrainToNextPointOne = new BigDecimal(iLengthFirstTrail).subtract(BigDecimal.valueOf(iLengthTrainOne)).subtract(BigDecimal.valueOf(10));
        dTrainToNextPointTwo = new BigDecimal(iLengthFirstTrail).subtract(dTrainToNextPointOne);
        sidEdgeBothTrainsStandingOn = ((TopologyGraph.Edge) StartTrail.getRight()).sId;
        sidNodeBothTrainsRunningTo = ((TopologyGraph.Node)FirstWaypoint.getRight()).TopNodeId;

        MaRequestWrapper MaRW_Train1 = TestUtil.preserveRequest4NonBlockedTest(iTrainOne, dTrainToNextPointOne.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeBothTrainsRunningTo, iLengthTrainOne);
        MaRequestWrapper MaRW_Train2 = TestUtil.preserveRequest4NonBlockedTest(iTrainTwo, dTrainToNextPointTwo.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeBothTrainsRunningTo, iLengthTrainTwo);

        EoaAdapter eoaAda_Train1 = generateEoa(10);
        EoaAdapter eoaAda_Train2 = generateEoa(7);

        RbcMaAdapter RbcMa_Train1 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train1, Q_SCALE.SCALE_1_M.flag);
        RbcMaAdapter RbcMa_Train2 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train2, Q_SCALE.SCALE_1_M.flag);
        int nid_prvlbg = -1;
        int d_lrbg = 15;

        // Orientation of the train in relation to the direction of the LRBG
        int q_lrbg = 1; // nominal 0 would be reverse
        // Qualifier telling on which side of the LRBG the estimated front end is
        int q_dlrbg = 1; // 0 would be reverse

        // L_DOUBTOVER is the over-reading amount plus the Q_LOCACC of the LRBG
        int l_doubtover = 32767; // Unknown

        // L_DOUBTUNDER is the under-reading amount plus the Q_LOCACC of the LRBG
        int l_doubtunder = 32767; // Unknown

        int i_Speed_5_km_per_hour = 0; // 1 would be 5 km/h 10 would be 50 km/h

        //Direction of train movement in relation to the LRBG orientation
        int q_dirtrain = 1;  // 0 would be reverse

        //Full Supervision
        int m_mode = 1;

        //Current Operating Level // Level 3
        int m_level = 4;

        //National System identity
        int nid_ntc = 1;

        int nid_ref_Balise = TestUtil.lastRandomBalise.getHashcodeOfBaliseDp();

        PositionInfo PosInfoTrain1 = new PositionInfo(Q_SCALE.SCALE_1_M.flag, nid_ref_Balise, nid_prvlbg, d_lrbg,
                q_lrbg, q_dlrbg, l_doubtover, l_doubtunder, Q_SCALE.SCALE_1_M.flag, iTrainOne,
                i_Speed_5_km_per_hour, q_dirtrain, m_mode, m_level, nid_ntc);

        int d_lrbg_train2 = 30;
        PositionInfo PosInfoTrain2 = new PositionInfo(Q_SCALE.SCALE_1_M.flag, nid_ref_Balise, nid_prvlbg, d_lrbg_train2,
                q_lrbg, q_dlrbg, l_doubtover, l_doubtunder, Q_SCALE.SCALE_1_M.flag, iTrainOne,
                i_Speed_5_km_per_hour, q_dirtrain, m_mode, m_level, nid_ntc);

        SmartSafety.lastPositionReport.update(iTrainOne, PosInfoTrain1);
        SmartSafety.lastPositionReport.update(iTrainTwo, PosInfoTrain2);

        //RbcMaAdapter RbcMa = TestUtil.preserveMA4NonBlockedTest()

        assertEquals(true,Safety.checkIfRouteIsNonBlocked(MaRW_Train1, RbcMa_Train1, routenListeNEW4TEST)
                , "The first request must not have blockage");
        assertEquals(false,Safety.checkIfRouteIsNonBlocked(MaRW_Train2, RbcMa_Train2, routenListeNEW4TEST)
                , "The second request have to have a blockage");


    }

    private int calcMaxLengthOfTrack(ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListe) {
        int iResultLength = 0;
        Pair<Route.TrackElementType, TrackElement> StartKomposition = routenListe.get(0);
        Pair<Route.TrackElementType, TrackElement> EndKomposition = routenListe.get(routenListe.size() - 1);
        for(int i = 0; i < routenListe.size() -2; i++) {
            Pair<Route.TrackElementType, TrackElement> Komposition = routenListe.get(i);
            TopologyGraph.Edge E = null;
            if(Komposition == StartKomposition) {
                if(Komposition.getLeft().equals(Route.TrackElementType.RAIL_TYPE)) {
                    E = (TopologyGraph.Edge) Komposition.getRight();
                    iResultLength = (int) E.dTopLength;
                } else {
                    throw new InvalidParameterException("Not valid Test setup");
                }
            } else {
                Pair<Route.TrackElementType, TrackElement> NextKomposition = routenListe.get(i + 1);
                if (NextKomposition == EndKomposition) {
                    if (NextKomposition.getLeft().equals(Route.TrackElementType.RAIL_TYPE)) {
                        E = (TopologyGraph.Edge) NextKomposition.getRight();
                        iResultLength += (int) E.dTopLength;
                    } else {
                        throw new InvalidParameterException("Not valid Test setup");
                    }
                } else {
                    if(Komposition.getLeft().equals(Route.TrackElementType.CROSSOVER_TYPE) &&
                            NextKomposition.getLeft().equals(Route.TrackElementType.CROSSOVER_TYPE)) {
                        try {
                            TopologyGraph.Node N1 = (TopologyGraph.Node) Komposition.getRight();
                            TopologyGraph.Node N2 = (TopologyGraph.Node) NextKomposition.getRight();
                            TopologyGraph.Edge Edge = TopologyGraph.twoTopPointBelongsToEdgeRepo.getModel(N1.TopNodeId)
                                    .getModel(N2.TopNodeId);
                            iResultLength += (int) Edge.dTopLength;
                        } catch(Exception Except) {
                            Except.printStackTrace();
                            throw new InvalidParameterException("Not valid Test setup");
                        }

                    } else {


                    throw new InvalidParameterException("Not valid Test setup");
                    }
                }
            }
        }
        return iResultLength;
    }



}