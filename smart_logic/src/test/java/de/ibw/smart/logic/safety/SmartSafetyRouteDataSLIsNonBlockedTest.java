package de.ibw.smart.logic.safety;

import de.ibw.feed.Balise;
import de.ibw.smart.logic.datatypes.BlockedArea;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.smart.logic.safety.self.tests.TestUtil;
import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.ma.EoaAdapter;
import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.ma.RbcMaAdapter;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.DefaultRepo;
import ebd.globalUtils.configHandler.TrainsHandler;
import ebd.rbc_tms.util.EOA;
import ebd.rbc_tms.util.ETCSVariables;
import ebd.rbc_tms.util.PositionInfo;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Die Smart-Logic hat ein Submodul, das pr&uuml;ft, ob blockierte Elemente vorhanden sind.
 * Dieser Test stellt die funktionale Korrektheit sicher
 */
class SmartSafetyRouteDataSLIsNonBlockedTest {

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
            TestUtil.generateRandomContinousRoute(3, true, false
            , TestUtil.RouteConfig.BALISE_NEAR_CROSSING);
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
     * Pr&uuml;ft ob Smart-Logic zwei uberlappende MAs auf einem Streckenabschnitt erkennt.
     */
    @RepeatedTest(100)
    public void checkIfTracksAreBlockedByTwoTrainsOnSameTrack() throws InterruptedException {
        this.initTestEnv();
        // zwei Züge blockieren auf der gleichen Strecke
        int iTrainOne = 1;
        int iTrainTwo = 2;
        BigDecimal dTrainToNextPointOne;
        BigDecimal dTrainToNextPointTwo;
        String sidEdgeBothTrainsStandingOn;
        // Abstand zur Balise Position Report train1 andn train2
        int d_lrbg = 20;
        int d_lrbg_train2 = 15;

        String sidNodeBothTrainsRunningTo;
        int iLengthTrainOne = 1;
        int iLengthTrainTwo = 2;
        // true if Node B of Topology Edge is in trigger direction Nominal

        TopologyGraph.Node NodeRunningTo = null;
        TopologyGraph.Edge TrainStandingOn = null;
        int q_dir = 1;

        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListe =
                TestUtil.generateRandomContinousRoute(7, true, true
                , TestUtil.RouteConfig.BALISE_NEAR_CROSSING);
        Balise B = TestUtil.lastRandomBalise;


        Pair<Route.TrackElementType, TrackElement> StartTrail = routenListe.get(0);
        Pair<Route.TrackElementType, TrackElement> FirstWaypoint = routenListe.get(1);
        NodeRunningTo = (TopologyGraph.Node) FirstWaypoint.getValue();


        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListeNEW4TEST = new ArrayList<>();
        routenListeNEW4TEST.add(routenListe.get(0));
        routenListeNEW4TEST.add(routenListe.get(0));

        double iLengthFirstTrail = (double) ((TopologyGraph.Edge) StartTrail.getRight()).dTopLength;
        TrainStandingOn = (TopologyGraph.Edge) StartTrail.getValue();
        sidEdgeBothTrainsStandingOn = TrainStandingOn.sId;
        sidNodeBothTrainsRunningTo = NodeRunningTo.TopNodeId;

        // untersucht ob Balise auf der Top-Kante des Zuges steht
        if(!B.getTopPositionOfDataPoint().getIdentitaet().getWert().equals(sidEdgeBothTrainsStandingOn)) {
            throw new InvalidParameterException("Starting Edge has not Balise given");
        }

        if(TrainStandingOn.B.equals(NodeRunningTo)) {

            dTrainToNextPointOne =
                    new BigDecimal(iLengthFirstTrail).subtract(
                            B.getBalisenPositionFromNodeA().add(BigDecimal.valueOf(d_lrbg))
                    );
            dTrainToNextPointTwo = new BigDecimal(iLengthFirstTrail).subtract(
                    B.getBalisenPositionFromNodeA().add(BigDecimal.valueOf(d_lrbg_train2))
            );
        } else if(TrainStandingOn.A.equals(NodeRunningTo)) {

            dTrainToNextPointOne = B.getBalisenPositionFromNodeA().subtract(BigDecimal.valueOf(d_lrbg));
            dTrainToNextPointTwo = B.getBalisenPositionFromNodeA().subtract(BigDecimal.valueOf(d_lrbg_train2));
        }
        else {
            throw new InvalidParameterException("Node Train is running to, is not connected with start edge");
        }




        MaRequestWrapper MaRW_Train1 = TestUtil.preserveRequest4NonBlockedTest(iTrainOne, dTrainToNextPointOne.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeBothTrainsRunningTo, iLengthTrainOne);
        MaRequestWrapper MaRW_Train2 = TestUtil.preserveRequest4NonBlockedTest(iTrainTwo, dTrainToNextPointTwo.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeBothTrainsRunningTo, iLengthTrainTwo);

        EoaAdapter eoaAda_Train1 = generateEoa(70);
        EoaAdapter eoaAda_Train2 = generateEoa(35);

        RbcMaAdapter RbcMa_Train1 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train1, Q_SCALE.SCALE_1_M.flag);
        RbcMaAdapter RbcMa_Train2 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train2, Q_SCALE.SCALE_1_M.flag);
        int nid_prvlbg = -1;


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


        PositionInfo PosInfoTrain2 = new PositionInfo(Q_SCALE.SCALE_1_M.flag, nid_ref_Balise, nid_prvlbg, d_lrbg_train2,
                q_lrbg, q_dlrbg, l_doubtover, l_doubtunder, Q_SCALE.SCALE_1_M.flag, iTrainOne,
                i_Speed_5_km_per_hour, q_dirtrain, m_mode, m_level, nid_ntc);

        SmartSafety.lastPositionReport.update(iTrainOne, PosInfoTrain1);
        SmartSafety.lastPositionReport.update(iTrainTwo, PosInfoTrain2);

        //RbcMaAdapter RbcMa = TestUtil.preserveMA4NonBlockedTest()

        assertTrue(Safety.checkIfRouteIsNonBlocked(MaRW_Train1, RbcMa_Train1, routenListeNEW4TEST), "The first request must not have blockage");
        assertFalse(Safety.checkIfRouteIsNonBlocked(MaRW_Train2, RbcMa_Train2, routenListeNEW4TEST), "The second request have to have a blockage");

    }

    /**
     * Diese TestMethode pr&uuml;ft, ob zwei Züge die Erlaubnis erhalten auf der gleiche Strecke zu stehen.
     * Das Block-Modul soll beide MA-Blockaden als akzeptiert ausstellen.
     * Im Szenario stehen beide Z&uuml;ge kurz vor und nach einer Balise, die Z&uuml;ge bewegen sich voneinander weg.
     * Es entsteht keine &Uuml;berlappung.
     * @throws InterruptedException
     */
    @RepeatedTest(100)
    public void checkIfTwoTrainsNonIntersectingOnSameTrailAreSafe() throws InterruptedException {
        this.initTestEnv();
        // zwei Züge blockieren auf der gleichen Strecke
        int iTrainOne = 1;
        int iTrainTwo = 2;
        BigDecimal dTrainToNextPointOne;
        BigDecimal dTrainToNextPointTwo;
        String sidEdgeBothTrainsStandingOn;
        // Abstand zur Balise Position Report train1 andn train2
        int d_lrbg = 7;
        int d_lrbg_train2 = 8;

        String sidNodeOneTrainRunningTo;
        String sidNodeSecondTrainRunningTo;
        int iLengthTrainOne = 1;
        int iLengthTrainTwo = 2;
        // true if Node B of Topology Edge is in trigger direction Nominal

        TopologyGraph.Node NodeTrain1RunningTo = null;
        TopologyGraph.Node NodeTrain2RunningTo = null;

        TopologyGraph.Edge TrainStandingOn = null;
        int q_dir = 1;

        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListe =
                TestUtil.generateRandomContinousRoute(7, true, true,
                        TestUtil.RouteConfig.BALISE_NEAR_CROSSING);
        Balise B = TestUtil.lastRandomBalise;


        Pair<Route.TrackElementType, TrackElement> StartTrail = routenListe.get(0);
        Pair<Route.TrackElementType, TrackElement> FirstWaypoint = routenListe.get(1);
        NodeTrain1RunningTo = (TopologyGraph.Node) FirstWaypoint.getValue();


        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListeNEW4TEST = new ArrayList<>();
        routenListeNEW4TEST.add(routenListe.get(0));
        routenListeNEW4TEST.add(routenListe.get(0));

        double iLengthFirstTrail = (double) ((TopologyGraph.Edge) StartTrail.getRight()).dTopLength;
        TrainStandingOn = (TopologyGraph.Edge) StartTrail.getValue();
        NodeTrain2RunningTo = TrainStandingOn.A == NodeTrain1RunningTo ? TrainStandingOn.B : TrainStandingOn.A;

        sidEdgeBothTrainsStandingOn = TrainStandingOn.sId;
        sidNodeOneTrainRunningTo = NodeTrain1RunningTo.TopNodeId;
        sidNodeSecondTrainRunningTo = NodeTrain2RunningTo.TopNodeId;

        // untersucht ob Balise auf der Top-Kante des Zuges steht
        if(!B.getTopPositionOfDataPoint().getIdentitaet().getWert().equals(sidEdgeBothTrainsStandingOn)) {
            throw new InvalidParameterException("Starting Edge has not Balise given");
        }
        // Train b is running reverse
        if(TrainStandingOn.B.equals(NodeTrain1RunningTo)) {

            dTrainToNextPointOne =
                    new BigDecimal(iLengthFirstTrail).subtract(
                            B.getBalisenPositionFromNodeA().add(BigDecimal.valueOf(d_lrbg))
                    );
            dTrainToNextPointTwo = B.getBalisenPositionFromNodeA().subtract(BigDecimal.valueOf(d_lrbg_train2));


        } else if(TrainStandingOn.A.equals(NodeTrain1RunningTo)) {

            dTrainToNextPointOne = B.getBalisenPositionFromNodeA().subtract(BigDecimal.valueOf(d_lrbg));
            dTrainToNextPointTwo = new BigDecimal(iLengthFirstTrail).subtract(
                    B.getBalisenPositionFromNodeA().add(BigDecimal.valueOf(d_lrbg_train2)));
        }
        else {
            throw new InvalidParameterException("Node Train is running to, is not connected with start edge");
        }
        if(dTrainToNextPointOne.compareTo(BigDecimal.valueOf(d_lrbg)) <= 0) {
            System.err.println("Train 1 is positioned behind distance to next Waypoint. So this test cannot be processed. Test is skipped");
            return;
        }


        if(dTrainToNextPointTwo.compareTo(BigDecimal.valueOf(d_lrbg_train2)) <= 0 ) {
            System.err.println("Train 2 is positioned behind distance to next Waypoint. So this test cannot be processed. Test is skipped");
            return;
        }
        // falls der Trigger einer Balise nicht nominal sei, muss das Q_Dir negiert werden
        // nominale Balisen triggern auf Knoten B.




        MaRequestWrapper MaRW_Train1 = TestUtil.preserveRequest4NonBlockedTest(iTrainOne, dTrainToNextPointOne.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeOneTrainRunningTo, iLengthTrainOne);
        MaRequestWrapper MaRW_Train2 = TestUtil.preserveRequest4NonBlockedTest(iTrainTwo, dTrainToNextPointTwo.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeSecondTrainRunningTo, iLengthTrainTwo);

        int lEOATrain1 = dTrainToNextPointOne.compareTo(new BigDecimal(70)) > 0 ? 70 : dTrainToNextPointOne.intValue()-2;
        int lEOATrain2 = dTrainToNextPointTwo.compareTo(new BigDecimal(35)) > 0 ? 35 : dTrainToNextPointTwo.intValue()-2;

        if(lEOATrain1 <= 0) lEOATrain1 = 1;
        if(lEOATrain2 <= 0) lEOATrain2 = 1;

        EoaAdapter eoaAda_Train1 = generateEoa(lEOATrain1);
        EoaAdapter eoaAda_Train2 = generateEoa(lEOATrain2);

        RbcMaAdapter RbcMa_Train1 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train1, Q_SCALE.SCALE_1_M.flag);
        RbcMaAdapter RbcMa_Train2 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train2, Q_SCALE.SCALE_1_M.flag);
        int nid_prvlbg = -1;


        // Orientation of the train in relation to the direction of the LRBG
        int q_dirlrbg = 1; // nominal 0 would be reverse
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
                q_dirlrbg, q_dlrbg, l_doubtover, l_doubtunder, Q_SCALE.SCALE_1_M.flag, iTrainOne,
                i_Speed_5_km_per_hour, q_dirtrain, m_mode, m_level, nid_ntc);


        PositionInfo PosInfoTrain2 = new PositionInfo(Q_SCALE.SCALE_1_M.flag, nid_ref_Balise, nid_prvlbg, d_lrbg_train2,
                q_dirlrbg, q_dlrbg, l_doubtover, l_doubtunder, Q_SCALE.SCALE_1_M.flag, iTrainTwo,
                i_Speed_5_km_per_hour, q_dirtrain, m_mode, m_level, nid_ntc);

        SmartSafety.lastPositionReport.update(iTrainOne, PosInfoTrain1);
        SmartSafety.lastPositionReport.update(iTrainTwo, PosInfoTrain2);

        //RbcMaAdapter RbcMa = TestUtil.preserveMA4NonBlockedTest()

        assertTrue(Safety.checkIfRouteIsNonBlocked(MaRW_Train1, RbcMa_Train1, routenListeNEW4TEST), "The first request must not have blockage");
        boolean isSuccess = Safety.checkIfRouteIsNonBlocked(MaRW_Train2, RbcMa_Train2, routenListeNEW4TEST);
        if(isSuccess) {

        } else {
            System.out.println("breakpoint");
            System.out.println("Balise: " + B.getBalisenPositionFromNodeA());

        }

        assertTrue(isSuccess, "The second request is allowed also");


    }
    /**
     * Diese TestMethode pr&uuml;ft, ob zwei Z&uuml;ge Erlaubnis erhalten auf der gleichen Strecke zu fahren.
     * Das Block-Modul soll nur die erste MA-Blockade als akzeptiert ausstellen.
     * Im Szenario stehen beide Z&uuml;ge kurz vor und nach einer Balise, die Z&uuml;ge bewegen sich aufeinander zu,
     * sodass, es zu einer &Uuml;berlappung kommt.
     * Das Blockademodul, soll die zweite Anfrage verwerfen.
     * @throws InterruptedException
     */
    @RepeatedTest(100)
    public void checkIfTwoTrainsIntersectingOnSameTrailBeeingDetected() throws InterruptedException {
        this.initTestEnv();
        // zwei Züge blockieren auf der gleichen Strecke
        int iTrainOne = 1;
        int iTrainTwo = 2;
        BigDecimal dTrainToNextPointOne;
        BigDecimal dTrainToNextPointTwo;
        String sidEdgeBothTrainsStandingOn;
        // Abstand zur Balise Position Report train1 andn train2
        int d_lrbg = 7;
        int d_lrbg_train2 = 8;

        //Die Entfernung der beiden Zuege ist dlrbg (7) + drbg-Train2 (8) 15

        String sidNodeOneTrainRunningTo;
        String sidNodeSecondTrainRunningTo;
        int iLengthTrainOne = 1;
        int iLengthTrainTwo = 2;
        // true if Node B of Topology Edge is in trigger direction Nominal

        TopologyGraph.Node NodeTrain1RunningTo = null;
        TopologyGraph.Node NodeTrain2RunningTo = null;

        TopologyGraph.Edge TrainStandingOn = null;
        int q_dir = 1;

        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListe =
                TestUtil.generateRandomContinousRoute(7, true, true,
                        TestUtil.RouteConfig.BALISE_NEAR_CROSSING);
        Balise B = TestUtil.lastRandomBalise;


        Pair<Route.TrackElementType, TrackElement> StartTrail = routenListe.get(0);
        Pair<Route.TrackElementType, TrackElement> FirstWaypoint = routenListe.get(1);
        NodeTrain1RunningTo = (TopologyGraph.Node) FirstWaypoint.getValue();


        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListeNEW4TEST = new ArrayList<>();
        routenListeNEW4TEST.add(routenListe.get(0));
        routenListeNEW4TEST.add(routenListe.get(0));

        double iLengthFirstTrail = (double) ((TopologyGraph.Edge) StartTrail.getRight()).dTopLength;
        TrainStandingOn = (TopologyGraph.Edge) StartTrail.getValue();
        NodeTrain2RunningTo = TrainStandingOn.A == NodeTrain1RunningTo ? TrainStandingOn.B : TrainStandingOn.A;

        sidEdgeBothTrainsStandingOn = TrainStandingOn.sId;
        sidNodeOneTrainRunningTo = NodeTrain1RunningTo.TopNodeId;
        sidNodeSecondTrainRunningTo = NodeTrain2RunningTo.TopNodeId;

        // untersucht ob Balise auf der Top-Kante des Zuges steht
        if(!B.getTopPositionOfDataPoint().getIdentitaet().getWert().equals(sidEdgeBothTrainsStandingOn)) {
            throw new InvalidParameterException("Starting Edge has not Balise given");
        }
        // Train b is running reverse
        if(TrainStandingOn.B.equals(NodeTrain1RunningTo)) {

            dTrainToNextPointOne =
                    new BigDecimal(iLengthFirstTrail).subtract(
                            B.getBalisenPositionFromNodeA()).add(BigDecimal.valueOf(d_lrbg));

            dTrainToNextPointTwo = B.getBalisenPositionFromNodeA().add(BigDecimal.valueOf(d_lrbg_train2));


        } else if(TrainStandingOn.A.equals(NodeTrain1RunningTo)) {

            dTrainToNextPointOne = B.getBalisenPositionFromNodeA().add(BigDecimal.valueOf(d_lrbg));
            dTrainToNextPointTwo = new BigDecimal(iLengthFirstTrail).subtract(
                    B.getBalisenPositionFromNodeA()).add(BigDecimal.valueOf(d_lrbg_train2));
        }
        else {
            throw new InvalidParameterException("Node Train is running to, is not connected with start edge");
        }
        if(dTrainToNextPointOne.compareTo(BigDecimal.valueOf(0)) <= 0) {
            System.err.println("Train 1 is positioned on before Start of Track. Test skipped");
            return;
        }


        if(dTrainToNextPointTwo.compareTo(BigDecimal.valueOf(0)) <= 0 ) {
            System.err.println("Train 2 is positioned on before Start of Track. Test skipped");
            return;
        }
        // falls der Trigger einer Balise nicht nominal sei, muss das Q_Dir negiert werden
        // nominale Balisen triggern auf Knoten B.




        MaRequestWrapper MaRW_Train1 = TestUtil.preserveRequest4NonBlockedTest(iTrainOne, dTrainToNextPointOne.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeOneTrainRunningTo, iLengthTrainOne);
        MaRequestWrapper MaRW_Train2 = TestUtil.preserveRequest4NonBlockedTest(iTrainTwo, dTrainToNextPointTwo.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeSecondTrainRunningTo, iLengthTrainTwo);

        int lEOATrain1 = dTrainToNextPointOne.compareTo(new BigDecimal(10)) > 0 ? 10 : d_lrbg;
        int lEOATrain2 = dTrainToNextPointTwo.compareTo(new BigDecimal(10)) > 0 ? 10 : d_lrbg_train2;


        EoaAdapter eoaAda_Train1 = generateEoa(lEOATrain1);
        EoaAdapter eoaAda_Train2 = generateEoa(lEOATrain2);

        RbcMaAdapter RbcMa_Train1 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train1, Q_SCALE.SCALE_1_M.flag);
        RbcMaAdapter RbcMa_Train2 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train2, Q_SCALE.SCALE_1_M.flag);
        int nid_prvlbg = -1;


        // Orientation of the train in relation to the direction of the LRBG
        int q_dirlrbg = 1; // nominal 0 would be reverse
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
                q_dirlrbg, q_dlrbg, l_doubtover, l_doubtunder, Q_SCALE.SCALE_1_M.flag, iTrainOne,
                i_Speed_5_km_per_hour, q_dirtrain, m_mode, m_level, nid_ntc);


        PositionInfo PosInfoTrain2 = new PositionInfo(Q_SCALE.SCALE_1_M.flag, nid_ref_Balise, nid_prvlbg, d_lrbg_train2,
                q_dirlrbg, q_dlrbg, l_doubtover, l_doubtunder, Q_SCALE.SCALE_1_M.flag, iTrainOne,
                i_Speed_5_km_per_hour, q_dirtrain, m_mode, m_level, nid_ntc);

        SmartSafety.lastPositionReport.update(iTrainOne, PosInfoTrain1);
        SmartSafety.lastPositionReport.update(iTrainTwo, PosInfoTrain2);

        //RbcMaAdapter RbcMa = TestUtil.preserveMA4NonBlockedTest()

        assertTrue(Safety.checkIfRouteIsNonBlocked(MaRW_Train1, RbcMa_Train1, routenListeNEW4TEST), "The first request must not have blockage");
        assertFalse(Safety.checkIfRouteIsNonBlocked(MaRW_Train2, RbcMa_Train2, routenListeNEW4TEST), "The isnt fail, but it shall because of Overlap");



    }

    /**
     * Diese TestMethode pr&uuml;ft, ob zwei Z&uuml;ge Erlaubnis erhalten auf der gleichen Strecke zu fahren.
     * Das Block-Modul soll nun die beide MA-Blockaden als akzeptiert ausstellen.
     * Im Szenario stehen beide Z&uuml;ge kurz vor und nach einer Balise, die Z&uuml;ge bewegen sich aufeinander zu,
     * sodass, es zu KEINER &Uuml;berlappung kommt.
     * Das Blockademodul, soll die beiden Anfragen akzeptieren.
     * @throws InterruptedException
     */
    @RepeatedTest(100)
    public void checkIfTwoTrainsNonIntersectingOnSameTrailBeeingAllowed() throws InterruptedException {
        this.initTestEnv();
        // zwei Züge blockieren auf der gleichen Strecke
        int iTrainOne = 1;
        int iTrainTwo = 2;
        BigDecimal dTrainToNextPointOne;
        BigDecimal dTrainToNextPointTwo;
        String sidEdgeBothTrainsStandingOn;
        // Abstand zur Balise Position Report train1 andn train2
        int d_lrbg = 15;
        int d_lrbg_train2 = 20;

        //Die Entfernung der beiden Zuege ist dlrbg (15) + drbg-Train2 (20) 35

        String sidNodeOneTrainRunningTo;
        String sidNodeSecondTrainRunningTo;
        int iLengthTrainOne = 1;
        int iLengthTrainTwo = 2;
        // true if Node B of Topology Edge is in trigger direction Nominal

        TopologyGraph.Node NodeTrain1RunningTo = null;
        TopologyGraph.Node NodeTrain2RunningTo = null;

        TopologyGraph.Edge TrainStandingOn = null;
        int q_dir = 1;

        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListe =
                TestUtil.generateRandomContinousRoute(7, true, true,
                        TestUtil.RouteConfig.BALISE_NOT_NEAR_CROSSING);
        Balise B = TestUtil.lastRandomBalise;


        Pair<Route.TrackElementType, TrackElement> StartTrail = routenListe.get(0);
        Pair<Route.TrackElementType, TrackElement> FirstWaypoint = routenListe.get(1);
        NodeTrain1RunningTo = (TopologyGraph.Node) FirstWaypoint.getValue();


        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListeNEW4TEST = new ArrayList<>();
        routenListeNEW4TEST.add(routenListe.get(0));
        routenListeNEW4TEST.add(routenListe.get(0));

        double iLengthFirstTrail = (double) ((TopologyGraph.Edge) StartTrail.getRight()).dTopLength;
        TrainStandingOn = (TopologyGraph.Edge) StartTrail.getValue();
        NodeTrain2RunningTo = TrainStandingOn.A == NodeTrain1RunningTo ? TrainStandingOn.B : TrainStandingOn.A;

        sidEdgeBothTrainsStandingOn = TrainStandingOn.sId;
        sidNodeOneTrainRunningTo = NodeTrain1RunningTo.TopNodeId;
        sidNodeSecondTrainRunningTo = NodeTrain2RunningTo.TopNodeId;

        // untersucht ob Balise auf der Top-Kante des Zuges steht
        if(!B.getTopPositionOfDataPoint().getIdentitaet().getWert().equals(sidEdgeBothTrainsStandingOn)) {
            throw new InvalidParameterException("Starting Edge has not Balise given");
        }
        // Train b is running reverse
        if(TrainStandingOn.B.equals(NodeTrain1RunningTo)) {

            dTrainToNextPointOne =
                    new BigDecimal(iLengthFirstTrail).subtract(
                            B.getBalisenPositionFromNodeA()).add(BigDecimal.valueOf(d_lrbg));

            dTrainToNextPointTwo = B.getBalisenPositionFromNodeA().add(BigDecimal.valueOf(d_lrbg_train2));
            if(B.getBalisenPositionFromNodeA().compareTo(BigDecimal.valueOf(d_lrbg)) <= 0) {
                System.err.println("Train 1 is positioned on before Start of Track. Test skipped");
                return;
            }
            if(new BigDecimal(iLengthFirstTrail).subtract(B.getBalisenPositionFromNodeA()).compareTo(BigDecimal.valueOf(d_lrbg_train2)) <= 0) {
                System.err.println("Train 2 is positioned on before Start of Track. Test skipped");
                return;
            }

        } else if(TrainStandingOn.A.equals(NodeTrain1RunningTo)) {

            dTrainToNextPointOne = B.getBalisenPositionFromNodeA().add(BigDecimal.valueOf(d_lrbg));
            dTrainToNextPointTwo = new BigDecimal(iLengthFirstTrail).subtract(
                    B.getBalisenPositionFromNodeA()).add(BigDecimal.valueOf(d_lrbg_train2));

            if(B.getBalisenPositionFromNodeA().compareTo(BigDecimal.valueOf(d_lrbg_train2)) <= 0) {
                System.err.println("Train 1 is positioned on before Start of Track. Test skipped");
                return;
            }
            if(new BigDecimal(iLengthFirstTrail).subtract(B.getBalisenPositionFromNodeA()).compareTo(BigDecimal.valueOf(d_lrbg)) <= 0) {
                System.err.println("Train 2 is positioned on before Start of Track. Test skipped");
                return;
            }
        }
        else {
            throw new InvalidParameterException("Node Train is running to, is not connected with start edge");
        }



        if(dTrainToNextPointOne.compareTo(BigDecimal.valueOf(d_lrbg)) <= 0) {
            System.err.println("Train 1 is positioned on before Start of Track. Test skipped");
            return;
        }


        if(dTrainToNextPointTwo.compareTo(BigDecimal.valueOf(d_lrbg_train2)) <= 0 ) {
            System.err.println("Train 2 is positioned on before Start of Track. Test skipped");
            return;
        }
        // falls der Trigger einer Balise nicht nominal sei, muss das Q_Dir negiert werden
        // nominale Balisen triggern auf Knoten B.




        MaRequestWrapper MaRW_Train1 = TestUtil.preserveRequest4NonBlockedTest(iTrainOne, dTrainToNextPointOne.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeOneTrainRunningTo, iLengthTrainOne);
        MaRequestWrapper MaRW_Train2 = TestUtil.preserveRequest4NonBlockedTest(iTrainTwo, dTrainToNextPointTwo.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeSecondTrainRunningTo, iLengthTrainTwo);

        int lEOATrain1 = dTrainToNextPointOne.compareTo(new BigDecimal(5)) > 0 ? 5 : 1;
        int lEOATrain2 = dTrainToNextPointTwo.compareTo(new BigDecimal(5)) > 0 ? 5 : 1;



        EoaAdapter eoaAda_Train1 = generateEoa(lEOATrain1);
        EoaAdapter eoaAda_Train2 = generateEoa(lEOATrain2);

        RbcMaAdapter RbcMa_Train1 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train1, Q_SCALE.SCALE_1_M.flag);
        RbcMaAdapter RbcMa_Train2 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train2, Q_SCALE.SCALE_1_M.flag);
        int nid_prvlbg = -1;


        // Orientation of the train in relation to the direction of the LRBG
        int q_dirlrbg = 1; // nominal 0 would be reverse
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
                q_dirlrbg, q_dlrbg, l_doubtover, l_doubtunder, Q_SCALE.SCALE_1_M.flag, iTrainOne,
                i_Speed_5_km_per_hour, q_dirtrain, m_mode, m_level, nid_ntc);


        PositionInfo PosInfoTrain2 = new PositionInfo(Q_SCALE.SCALE_1_M.flag, nid_ref_Balise, nid_prvlbg, d_lrbg_train2,
                q_dirlrbg, q_dlrbg, l_doubtover, l_doubtunder, Q_SCALE.SCALE_1_M.flag, iTrainOne,
                i_Speed_5_km_per_hour, q_dirtrain, m_mode, m_level, nid_ntc);

        SmartSafety.lastPositionReport.update(iTrainOne, PosInfoTrain1);
        SmartSafety.lastPositionReport.update(iTrainTwo, PosInfoTrain2);

        //RbcMaAdapter RbcMa = TestUtil.preserveMA4NonBlockedTest()

        assertTrue(Safety.checkIfRouteIsNonBlocked(MaRW_Train1, RbcMa_Train1, routenListeNEW4TEST), "The first request must not have blockage");
        boolean isSuccess = Safety.checkIfRouteIsNonBlocked(MaRW_Train2, RbcMa_Train2, routenListeNEW4TEST);
        if(!isSuccess) {
            System.out.println("Balise: " + B.getBalisenPositionFromNodeA());
            System.out.println("breakpoint");
        }
        assertTrue(isSuccess, "The is a fail, but it shall be allowed because of no Overlap");



    }

    /**
     * Diese Testmethode untersucht, dass die SmartSafety erkennt, dass zwei Fahrzeuge die gleiche Weiche in der
     * MA beanspruchen, weil ein Zug durch seine Ausdehnung sich noch im Grenzbereich der Weiche befindet muss
     * die Logik das einfahren des Zweiten Zuges verhindern.
     * @throws InterruptedException


    public void checkIfTwoTrainsIntersectingOverCrossingDetected() throws InterruptedException {
        this.initTestEnv();
        int iTrainOne = 1;
        int iTrainTwo = 2;
        BigDecimal dTrainToNextPointOne;
        BigDecimal dTrainToNextPointTwo;
        String sidEdgeBothTrainsStandingOn;
        // Abstand zur Balise Position Report train1 andn train2
        int d_lrbg = 15;
        int d_lrbg_train2 = 20;

        //Die Entfernung der beiden Zuege ist dlrbg (15) + drbg-Train2 (20) 35

        String sidNodeOneTrainRunningTo;
        String sidNodeSecondTrainRunningTo;
        int iLengthTrainOne = 10;
        int iLengthTrainTwo = 7;
        // true if Node B of Topology Edge is in trigger direction Nominal

        TopologyGraph.Node FirstNodeTrain1RunningTo = null;
        TopologyGraph.Node FirstNodeTrain2RunningTo = null;

        TopologyGraph.Edge BaliseStandingOn = null;
        int q_dir = 1;

        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListe =
                TestUtil.generateRandomContinousRoute(7, true, true,
                        TestUtil.RouteConfig.BALISE_TARGET_POINTS_TO_PEEK_AND_NOT_NEAR_CROSSING);
        Balise B = TestUtil.lastRandomBalise;


        Pair<Route.TrackElementType, TrackElement> StartTrail = routenListe.get(0);
        Pair<Route.TrackElementType, TrackElement> FirstWaypoint = routenListe.get(1);
        FirstNodeTrain1RunningTo = (TopologyGraph.Node) FirstWaypoint.getValue();


        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListeNEW4TEST = new ArrayList<>();
        routenListeNEW4TEST.add(routenListe.get(0));
        routenListeNEW4TEST.add(routenListe.get(1));
        routenListeNEW4TEST.add(routenListe.get(2));

        TopologyGraph.Edge EdgeTrain2IsStandinOn = (TopologyGraph.Edge) routenListe.get(2).getRight();
        TopologyGraph.Node NodeOfCrossoverBeeingBlocked = (TopologyGraph.Node) routenListe.get(1).getRight();
        CrossingSwitch CS = (CrossingSwitch) NodeOfCrossoverBeeingBlocked.NodeImpl;
       // gibt die diestance von Top-Knoten A an wo der Grenzbereich Beginnt-Ende in Relation zu Switch CS
        BigDecimal dDistanceFromAToLimitedCrossingSpace = CS.getInsecureRangeRelative(EdgeTrain2IsStandinOn);


        //Gleisl&auml;ngen
        double iLengthFirstTrail = (double) ((TopologyGraph.Edge) StartTrail.getRight()).dTopLength;
        BigDecimal dLengthEndTrailOfTrain2 = BigDecimal.valueOf(EdgeTrain2IsStandinOn.dTopLength);

        BaliseStandingOn = (TopologyGraph.Edge) StartTrail.getValue();
        FirstNodeTrain2RunningTo = FirstNodeTrain1RunningTo;


        sidNodeOneTrainRunningTo = FirstNodeTrain1RunningTo.TopNodeId;
        sidNodeSecondTrainRunningTo = FirstNodeTrain2RunningTo.TopNodeId;

        // untersucht ob Balise auf der Top-Kante des Zuges steht
        if(!B.getTopPositionOfDataPoint().getIdentitaet().getWert().equals(sidNodeOneTrainRunningTo)) {
            throw new InvalidParameterException("Starting Edge has not Balise given");
        }
        // blockierte Weiche ist am Knoten A der Topologischen Kante auf der der Zug 2 steht
        boolean isTrain2OnCrossingSwitchAtNodeA = EdgeTrain2IsStandinOn.A.equals(FirstNodeTrain1RunningTo);

        if(dLengthEndTrailOfTrain2.compareTo(new BigDecimal("7")) > 0) {
            // Strecke nicht nutzbar zu wenig Gleis  auf dem Blockierten Gleisstueck von Zug 2
            System.err.println("End Trail is to short. Test skipped");
        }


        // Train b is running reverse
        // Train 2 steht auf der Weiche auf die Train 1 einf&auml;hrt. Die Z&uuml;ge sehen sich an.
        if(BaliseStandingOn.B.equals(FirstNodeTrain1RunningTo)) {




            // Zug 1 bewegt sich durch die Spitze zum Zweig auf dem Zug 2 sich noch im Grenzbereich befindet
            dTrainToNextPointOne =
                    new BigDecimal(iLengthFirstTrail).subtract(
                            B.getBalisenPositionFromNodeA()).add(new BigDecimal("2"));

            if(isTrain2OnCrossingSwitchAtNodeA) {
                // TOP-Knoten A ist der Knoten an den die doppelt belegte Weiche liegt
                // Die Zug-Front ist drei Meter nach der Grenze so dass nur das Heck im Bereich ragt.
                dTrainToNextPointTwo = dDistanceFromAToLimitedCrossingSpace.add(new BigDecimal("7"));

            } else {
                // Top-Knoten B ist die betroffen Weiche
                dTrainToNextPointTwo = dLengthEndTrailOfTrain2.subtract(dDistanceFromAToLimitedCrossingSpace)
                        .subtract(new BigDecimal("7"));
            }
        } else if(BaliseStandingOn.A.equals(FirstNodeTrain1RunningTo)) {
            // Zug 1 bewegt sich durch die Spitze zum Zweig auf dem Zug 2 sich noch im Grenzbereich befindet
            dTrainToNextPointOne = B.getBalisenPositionFromNodeA().add(new BigDecimal("2"));
            if(isTrain2OnCrossingSwitchAtNodeA) {
                // TOP-Knoten A ist der Knoten an den die doppelt belegte Weiche liegt
                // Die Zug-Front ist drei Meter nach der Grenze so dass nur das Heck im Bereich ragt.
                dTrainToNextPointTwo = dDistanceFromAToLimitedCrossingSpace.add(new BigDecimal("7"));

            } else {
                // Top-Knoten B ist die betroffen Weiche
                dTrainToNextPointTwo = (dLengthEndTrailOfTrain2.subtract(dDistanceFromAToLimitedCrossingSpace))
                        .subtract(new BigDecimal("7"));
            }

        }
        else {
            throw new InvalidParameterException("Node Train is running to, is not connected with start edge");
        }


        MaRequestWrapper MaRW_Train1 = TestUtil.preserveRequest4NonBlockedTest(iTrainOne, dTrainToNextPointOne.doubleValue(),
                sidNodeOneTrainRunningTo, sidNodeOneTrainRunningTo, iLengthTrainOne);
        MaRequestWrapper MaRW_Train2 = TestUtil.preserveRequest4NonBlockedTest(iTrainTwo, dTrainToNextPointTwo.doubleValue(),
                sidNodeSecondTrainRunningTo, sidNodeSecondTrainRunningTo, iLengthTrainTwo);

        int lEOATrain1 = dTrainToNextPointOne.intValue();
        int lEOATrain2 = dTrainToNextPointTwo.intValue();



        EoaAdapter eoaAda_Train1 = generateEoa(lEOATrain1);
        EoaAdapter eoaAda_Train2 = generateEoa(lEOATrain2);

        RbcMaAdapter RbcMa_Train1 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train1, Q_SCALE.SCALE_1_M.flag);
        RbcMaAdapter RbcMa_Train2 = TestUtil.preserveMA4NonBlockedTest(eoaAda_Train2, Q_SCALE.SCALE_1_M.flag);
        int nid_prvlbg = -1;


        // Orientation of the train in relation to the direction of the LRBG
        int q_dirlrbg = 1; // nominal 0 would be reverse
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
                q_dirlrbg, q_dlrbg, l_doubtover, l_doubtunder, Q_SCALE.SCALE_1_M.flag, iTrainOne,
                i_Speed_5_km_per_hour, q_dirtrain, m_mode, m_level, nid_ntc);


        PositionInfo PosInfoTrain2 = new PositionInfo(Q_SCALE.SCALE_1_M.flag, nid_ref_Balise, nid_prvlbg, d_lrbg_train2,
                q_dirlrbg, q_dlrbg, l_doubtover, l_doubtunder, Q_SCALE.SCALE_1_M.flag, iTrainOne,
                i_Speed_5_km_per_hour, q_dirtrain, m_mode, m_level, nid_ntc);

        SmartSafety.lastPositionReport.update(iTrainOne, PosInfoTrain1);
        SmartSafety.lastPositionReport.update(iTrainTwo, PosInfoTrain2);

        //RbcMaAdapter RbcMa = TestUtil.preserveMA4NonBlockedTest()

        assertTrue(Safety.checkIfRouteIsNonBlocked(MaRW_Train1, RbcMa_Train1, routenListeNEW4TEST), "The first request must not have blockage");


    }
    */
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