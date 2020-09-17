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
import ebd.rbc_tms.util.EOA;
import ebd.rbc_tms.util.ETCSVariables;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SynchronousQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Die Smart-Logic hat ein Submodul, das pr&uuml;ft, ob blockierte Elemente vorhanden sind.
 * Dieser Test stellt die funktionale Korrektheit sicher
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class SmartSafetyRouteIsNonBlockedTestConcurrentChecks {

    private static Flow.Subscription subscription4Test;
    private static final SynchronousQueue<String> StartQueue = new SynchronousQueue<>();

    private static boolean isInShutdown = false;

    public static boolean isFirstTest = true;

    private static Subscriber<String> SL_LifeCycleListener = new Subscriber<>() {

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            subscription4Test = subscription;
            subscription4Test.request(1);
        }

        @Override
        public void onNext(String item) {
            if(item.equals("Started")) {
                StartQueue.offer("Started");
            } else if(item.equals("Shutdown")) {
                isInShutdown = false;
            }
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            subscription4Test.request(1);
        }
    };



    public static void initTestEnv() throws InterruptedException {

            new Thread() {
                @Override
                public void run() {
                    if(!isFirstTest) {
                        while(isInShutdown) {
                            try {
                                this.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    isFirstTest = false;
                    SmartLogic.addLifeCycleSubscriber(SL_LifeCycleListener);
                    SmartLogic.main(null);
                }
            }.start();





        try {
            StartQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void endTest() {


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isInShutdown = true;
        new Thread() {
            @Override
            public void run() {
                try {
                    SmartLogic.shutdownSmartLogic();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        }.start();




    }

    /**
     * Pr&uuml;ft ob Null-Werte als Anfrage abgefangen werden
     */
    @Test
    public void checkIfMainNullError() throws InterruptedException {
        initTestEnv();
        SmartSafety ModulUnderTest = SmartSafety.getSmartSafety();
        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListe =
            TestUtil.generateRandomContinousRoute(3, true, false,
                    TestUtil.RouteConfig.BALISE_NOT_NEAR_CROSSING);
        TopologyGraph.Edge E = (TopologyGraph.Edge) routenListe.get(0).getValue();
        TopologyGraph.Node N = (TopologyGraph.Node) routenListe.get(1).getValue();


        EoaAdapter eoaAda = generateEoa(300);

        RbcMaAdapter RbcMa = TestUtil.preserveMA4NonBlockedTest(eoaAda, Q_SCALE.SCALE_1_M.flag);
        MaRequestWrapper MRW = TestUtil.preserveRequest4NonBlockedTest(1,100d, E.sId,
               N.TopNodeId , 10);



            assertEquals(false, ModulUnderTest.checkIfRouteIsNonBlocked(null, RbcMa, routenListe));

            assertEquals(false,  ModulUnderTest.checkIfRouteIsNonBlocked(MRW, null, routenListe));
            assertEquals(false, ModulUnderTest.checkIfRouteIsNonBlocked(MRW, RbcMa, null));


            endTest();
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
        initTestEnv();
        // zwei Züge blockieren auf der gleichen Strecke
        int iTrainOne = 1;
        int iTrainTwo = 2;
        BigDecimal dTrainToNextPointOne;
        BigDecimal dTrainToNextPointTwo;
        String sidEdgeBothTrainsStandingOn;
        String sidNodeBothTrainsRunningTo;
        int iLengthTrainOne = 1;
        int iLengthTrainTwo = 2;



        SmartSafety ModulUnderTest = SmartSafety.getSmartSafety();
        ArrayList<Pair<Route.TrackElementType, TrackElement>> routenListe =
                TestUtil.generateRandomContinousRoute(7, true, true,
                        TestUtil.RouteConfig.BALISE_NOT_NEAR_CROSSING);
        int iMaxLength = calcMaxLengthOfTrack(routenListe);
        Pair<Route.TrackElementType, TrackElement> StartTrail = routenListe.get(0);
        Pair<Route.TrackElementType, TrackElement> FirstWaypoint = routenListe.get(1);
        int iLengthFirstTrail = (int) ((TopologyGraph.Edge) StartTrail.getRight()).dTopLength;
        dTrainToNextPointOne = new BigDecimal(iLengthFirstTrail).subtract(BigDecimal.valueOf(iLengthTrainOne)).subtract(BigDecimal.valueOf(10));
        dTrainToNextPointTwo = new BigDecimal(iLengthFirstTrail).subtract(dTrainToNextPointOne);
        sidEdgeBothTrainsStandingOn = ((TopologyGraph.Edge) StartTrail.getRight()).sId;
        sidNodeBothTrainsRunningTo = ((TopologyGraph.Node)FirstWaypoint.getRight()).TopNodeId;

        MaRequestWrapper MaRW_Train1 = TestUtil.preserveRequest4NonBlockedTest(iTrainOne, dTrainToNextPointOne.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeBothTrainsRunningTo, iLengthTrainOne);
        MaRequestWrapper MaRW_Train2 = TestUtil.preserveRequest4NonBlockedTest(iTrainTwo, dTrainToNextPointTwo.doubleValue(),
                sidEdgeBothTrainsStandingOn, sidNodeBothTrainsRunningTo, iLengthTrainTwo);

        generateEoa(dTrainToNextPointOne.subtract(BigDecimal.valueOf(10)).intValue());


        //RbcMaAdapter RbcMa = TestUtil.preserveMA4NonBlockedTest()

        //ModulUnderTest.checkIfRouteIsNonBlocked()
        endTest();
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