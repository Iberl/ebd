package de.ibw.smart.logic.safety.self.tests;

import de.ibw.feed.Balise;
import de.ibw.history.data.RouteDataSL;
import de.ibw.smart.logic.safety.SafetyLogic;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.occupation.Occupation;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import ebd.routeData.RouteData;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Dieser Test kontrolliert ein Modul in der SmartLogic.
 * Das Modul in der Smart-Safety untersucht, ob alle Routen-Element kontinuierlich verbunden sind.
 *
 * Es stellt Uitility-Function bereit, auf die auch andere Tests zugreifen
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-16
 */
public class SafetyLogicContinousConnectTest {


    private PlanData PD = PlanData.getInstance();
    private ArrayList<TopologyGraph.Node> nodeList;
    private ArrayList<TopologyGraph.Edge> edgeList;
    private final int I_TRYS_FOR_FINAL_ROUTE = 70;
    private int I_CURRENT_TRYS = 0;


    private final int I_LOWEST_ROUTE_LENGTH = 2;
    private final int I_MAX_ROUTE_LENGTH = 12;
    private final int I_AMOUNT_OF_TESTS_4_ACCEPTED_ROUTE_TESTS = 100;
    private final int I_AMOUNT_OF_TESTS_4_NEGATIVE_ROUTE_TESTS = 100;
    // for replacing existing routes with bad elements for testing
    private int iMalifyKind = 0;

    private enum MalifyRouteWithWrongValues {
        MALIFY_START, MALIFY_MIDDLE, MALIFY_END
    }


    /**
     * Kontrolliert, dass die Routenliste nicht null sein darf
     */
    @Test
    public void checkIfMainNullError() {
        SafetyLogic ModulUnderTest = SafetyLogic.getSmartSafety();

        try {
            ModulUnderTest.checkIfRouteIsContinuousConnected(null, null);
            // this assert shall not be called, since code above thorws Nullpointer
            assertEquals("Exception", false);
        } catch (Exception E) {
            assertTrue(true);
        }
    }

    /**
     * Kontrolliert, dass die Routenliste nicht leer sein darf
     */
    @Test
    public void checkIfRouteIsContinuousWithEmptyTrackList() {
        SafetyLogic ModulUnderTest = SafetyLogic.getSmartSafety();
        try {
            ModulUnderTest.checkIfRouteIsContinuousConnected(null, new RouteDataSL());
            // this assert shall not be called, since code above thorws Nullpointer
            assertEquals("Exception", false);
        } catch (Exception E) {
            assertTrue(true);
        }
    }

    /**
     * Kontrolliert das sie SmartSafty erkennt, dass zu wenig Routenelemente gegeben sind.
     */
    @Test
    public void checkIfRouteIsContinuousWithToLessItems() {
        SafetyLogic ModulUnderTest = SafetyLogic.getSmartSafety();
        Pair<Route.TrackElementType, ITopological> test1 = new ImmutablePair<>(Route.TrackElementType.CROSSOVER_TYPE, this.pickRandomNode());
        TopologyGraph.Node N = pickRandomNode();
        try {
            RouteDataSL list1 = new RouteDataSL();
            list1.add(test1);
            ModulUnderTest.checkIfRouteIsContinuousConnected(null, list1);
            // this assert shall not be called, since code above thorws Nullpointer
            assertEquals("Exception", false);
        } catch (Exception E) {
            assertTrue(true);
        }
        try {
            RouteDataSL list2 = new RouteDataSL();
            list2.add(new ImmutablePair<>(Route.TrackElementType.RAIL_TYPE, this.pickRandomEdge()));
            ModulUnderTest.checkIfRouteIsContinuousConnected(null, list2);
            // this assert shall not be called, since code above thorws Nullpointer
            assertEquals("Exception", false);
        } catch (Exception E) {
            assertTrue(true);
        }
    }

    /**
     * Kontrolliert, ob SmartSafety erkennt, dass ein Routen-Element in der Liste null ist.
     */
    @Test
    public void checkIfSmartSaftyRecogniseInvalidNullValues() {
        SafetyLogic ModulUnderTest = SafetyLogic.getSmartSafety();
        ArrayList<RouteDataSL> testRoutes = new ArrayList<>();
        for(int i = 0; i < this.I_TRYS_FOR_FINAL_ROUTE; i++) {
            if(testRoutes.size() <= this.I_AMOUNT_OF_TESTS_4_ACCEPTED_ROUTE_TESTS) {
                RouteDataSL OneRoute = generateRandomContinousRoute();
                if(null != OneRoute) {
                    testRoutes.add(OneRoute);
                }
            }
        }
        for(RouteDataSL Route : testRoutes) {
            try {
                Route = malifiyRouteWithNullEntry(Route);
                ModulUnderTest.checkIfRouteIsContinuousConnected(null, Route);
                // this assert shall not be called, since code above thorws Nullpointer
                assertEquals("Exception", false);
            } catch (Exception E) {
                assertTrue(true);
            }
        }
    }


    /**
     * Kontrolliert, ob SmartSafety erkennt, dass die Route in Ordnung ist
     */
    @Test
    public void checkIfRouteContinousShallReturnTrue() {
        SafetyLogic ModulUnderTest = SafetyLogic.getSmartSafety();
        ArrayList<RouteDataSL> testRoutes = new ArrayList<>();
        for(int i = 0; i < this.I_TRYS_FOR_FINAL_ROUTE; i++) {
            if(testRoutes.size() <= this.I_AMOUNT_OF_TESTS_4_ACCEPTED_ROUTE_TESTS) {
                RouteDataSL OneRoute = generateRandomContinousRoute();
                if(null != OneRoute) {
                    testRoutes.add(OneRoute);
                }
            }
        }
        for(RouteDataSL Route : testRoutes) {
            boolean bResult = ModulUnderTest.checkIfRouteIsContinuousConnected(null, Route);

            assertTrue(bResult);
        }
    }


    /**
     * Kontrolliert, dass die SmartSafety erkennt, dass das Start-Element nicht in Ordnung ist
     */

    @Test
    public void checkRouteHavingWrongStart() {

        checkRouteHavingWrongConnection(MalifyRouteWithWrongValues.MALIFY_START);

    }

    /**
     * Kontrolliert, dass die SmartSafety erkennt, dass das End-Element nicht in Ordnung ist
     */

    @Test
    public void checkRouteHavingWrongEnd() {

        checkRouteHavingWrongConnection(MalifyRouteWithWrongValues.MALIFY_END);

    }

    /**
     * Kontrolliert, dass die SmartSafety erkennt, dass das Element in der Mitte nicht in Ordnung ist
     */

    @Test
    void checkRouteHavingWrongMiddle() {

        checkRouteHavingWrongConnection(MalifyRouteWithWrongValues.MALIFY_MIDDLE);

    }


    private void checkRouteHavingWrongConnection(MalifyRouteWithWrongValues malification) {
        SafetyLogic ModulUnderTest = SafetyLogic.getSmartSafety();
        ArrayList<RouteDataSL> testRoutes = prepareWorkingRoutes(new ArrayList<>());

        for(RouteDataSL Route : testRoutes) {

                Route = malifiyRouteWithWrongEntry(Route, malification);


            try {

                boolean b = (ModulUnderTest.checkIfRouteIsContinuousConnected(null, Route));
                if(b) {
                    System.out.println("bad result");
                }
                assertFalse(b);

            } catch (Exception E) {
                E.printStackTrace();

                fail();
            }
        }
    }

    private RouteDataSL malifiyRouteWithWrongEntry(RouteDataSL route, MalifyRouteWithWrongValues malifyPosition) {
        RouteDataSL newMalicousRoute = new RouteDataSL();
        int iMaliciousIndex =  Math.abs(new Random().nextInt()) % (route.size() - 1);
        Pair<Route.TrackElementType, ITopological> BadItem = null;
        switch (malifyPosition) {
            case MALIFY_START: {
                iMaliciousIndex = 0;

                Pair<Route.TrackElementType, ITopological> maliciosItem = route.get(iMaliciousIndex);
                Route.TrackElementType OriginalElementType = maliciosItem.getLeft();
                switch(iMalifyKind % 2) {
                    case(0): {
                        //invert type of start element
                        return invertType(route, newMalicousRoute, iMaliciousIndex, maliciosItem, OriginalElementType);
                    }
                    case(1): {
                        //replace current start with other
                        return replaceElementWithOtherOne(route, newMalicousRoute, iMaliciousIndex, OriginalElementType, true);


                    }
                }

            }
            case MALIFY_MIDDLE: {
                while(route.size() <= 2) {
                    route =  generateRandomContinousRoute(calcRouteElementAmountWithLowLimit(3));

                }
                int iStartIndex = 1; // first element is not releveant for malify middle
                int iEndIndex = route.size() - 2; // last element is not relevant for malify middle
                if(iEndIndex == 1) iMaliciousIndex = 1;
                else iMaliciousIndex = Math.abs(new Random().nextInt()) % (iEndIndex - iStartIndex) + iStartIndex;
                return replaceMiddleElementWithOtherOne(route, newMalicousRoute, iMaliciousIndex);
            }
            case MALIFY_END: {
                iMaliciousIndex = route.size() - 1;

                Pair<Route.TrackElementType, ITopological> maliciosItem = route.get(iMaliciousIndex);
                Route.TrackElementType OriginalElementType = maliciosItem.getLeft();
                switch(iMalifyKind % 2) {
                    case(0): {
                        //invert type of start element
                        return invertType(route, newMalicousRoute, iMaliciousIndex, maliciosItem, OriginalElementType);

                    }
                    case(1): {
                        //replace current start with other
                        return replaceElementWithOtherOne(route, newMalicousRoute, iMaliciousIndex, OriginalElementType, false);


                    }
                }
            }
            default: {
                return null;
            }
        }

    }

    private RouteDataSL replaceMiddleElementWithOtherOne(RouteDataSL route, RouteDataSL newMalicousRoute, int iMaliciousIndex) {
        Route.TrackElementType BadType;
        Pair<Route.TrackElementType, ITopological> BadItem;
        BadType = Route.TrackElementType.CROSSOVER_TYPE;
        int iIndexNotConnected = -1;
        Boolean previousIndexIsNotConnected = new Random().nextBoolean();
        if(previousIndexIsNotConnected) {
            iIndexNotConnected = iMaliciousIndex -1;
        } else {
            iIndexNotConnected = iMaliciousIndex +1;
        }
        TopologyGraph.Node MaliciousNode = pickRandomNode(route.get(iIndexNotConnected));
        BadItem = new ImmutablePair<>(BadType, MaliciousNode);
        return createMalicousRoute(route, newMalicousRoute, iMaliciousIndex, BadItem );
    }

    private RouteDataSL invertType(RouteDataSL route, RouteDataSL newMalicousRoute, int iMaliciousIndex, Pair<Route.TrackElementType, ITopological> maliciosItem, Route.TrackElementType originalElementType) {
        Pair<Route.TrackElementType, ITopological> BadItem;
        Route.TrackElementType BadType = Route.TrackElementType.RAIL_TYPE;
        if(originalElementType.equals(Route.TrackElementType.RAIL_TYPE)) {
            BadType = Route.TrackElementType.CROSSOVER_TYPE;
        }
        BadItem = new ImmutablePair<>(BadType, maliciosItem.getRight());
        return createMalicousRoute(route, newMalicousRoute, iMaliciousIndex, BadItem);
    }

    private RouteDataSL replaceElementWithOtherOne(RouteDataSL route, RouteDataSL newMalicousRoute, int iMaliciousIndex, Route.TrackElementType originalElementType, boolean isStart) {

        if(originalElementType.equals(Route.TrackElementType.CROSSOVER_TYPE)) {
            return handleStartOrEndWithMalicousCrossover(route, newMalicousRoute, iMaliciousIndex, isStart);
        } else {
            return handleStartOrEndWithMalicousRail(route, newMalicousRoute, iMaliciousIndex, isStart);
        }
    }

    private RouteDataSL handleStartOrEndWithMalicousCrossover(RouteDataSL route, RouteDataSL newMalicousRoute, int iMaliciousIndex, boolean isStart) {
        Route.TrackElementType BadType;
        Pair<Route.TrackElementType, ITopological> BadItem;
        BadType = Route.TrackElementType.CROSSOVER_TYPE;
        TopologyGraph.Node MaliciousNode = getMalicousNode(route, isStart);
        BadItem = new ImmutablePair<>(BadType, MaliciousNode);
        return createMalicousRoute(route, newMalicousRoute, iMaliciousIndex, BadItem );
    }

    private TopologyGraph.Node getMalicousNode(RouteDataSL route, boolean isStart) {
        return isStart ? pickRandomNode(route.get(1)) : pickRandomNode(route.get(route.size()-2));
    }

    private RouteDataSL handleStartOrEndWithMalicousRail(RouteDataSL route, RouteDataSL newMalicousRoute, int iMaliciousIndex, boolean isStart) {
        Route.TrackElementType BadType;
        Pair<Route.TrackElementType, ITopological> BadItem;
        BadType = Route.TrackElementType.RAIL_TYPE;
        TopologyGraph.Edge MaliciousStartEdge = isStart ? pickRandomEdge(route.get(1)) : pickRandomEdge(route.get(route.size() -2));
        BadItem = new ImmutablePair<>(BadType, MaliciousStartEdge);
        return createMalicousRoute(route, newMalicousRoute, iMaliciousIndex, BadItem );
    }


    private RouteDataSL createMalicousRoute(RouteDataSL route, RouteDataSL newMalicousRoute, int iMaliciousIndex, Pair<Route.TrackElementType, ITopological> badItem) {
        for(int i = 0; i < route.size(); i++) {
            if(i == iMaliciousIndex) {
                newMalicousRoute.add(badItem);

            } else {
                newMalicousRoute.add(route.get(i));
            }
        }
        iMalifyKind++;
        return newMalicousRoute;
    }


    private ArrayList<RouteDataSL> prepareWorkingRoutes(ArrayList<RouteDataSL> testRoutes) {
        for(int i = 0; i < this.I_AMOUNT_OF_TESTS_4_NEGATIVE_ROUTE_TESTS; i++) {
            if(testRoutes.size() <= this.I_AMOUNT_OF_TESTS_4_NEGATIVE_ROUTE_TESTS) {
                RouteDataSL OneRoute = generateRandomContinousRoute();
                if(null != OneRoute) {
                    testRoutes.add(OneRoute);
                }
            }
        }
        return testRoutes;
    }


    private RouteDataSL malifiyRouteWithNullEntry(RouteDataSL route) {
        RouteDataSL newMalicousRoute = new RouteDataSL();
        int iMaliciousIndex =  Math.abs(new Random().nextInt()) % (route.size() - 1);
        Pair<Route.TrackElementType, ITopological> maliciosItem = route.get(iMaliciousIndex);
        Pair<Route.TrackElementType, ITopological> BadNullItem = null;
        boolean b = new Random().nextBoolean();
        if(b) {
            BadNullItem = new ImmutablePair<>(null, maliciosItem.getRight());
        } else {
            BadNullItem = new ImmutablePair<>(maliciosItem.getLeft(), null);
        }
        for(int i = 0; i < route.size(); i++) {
            if(i == iMaliciousIndex) {
                newMalicousRoute.add(BadNullItem);
            } else {
                newMalicousRoute.add(route.get(i));
            }
        }
        return newMalicousRoute;

    }

    private RouteDataSL generateRandomContinousRoute() {
        int iTargetAmountOfRouteElements = calcRouteElementAmount();
        return generateRandomContinousRoute(iTargetAmountOfRouteElements);


    }

    /**
     * Generiert f&uuml;r die angegebene Balisennummer eine Route mit angegebener Routen-Element-Anzahl
     * @param iBaliseNumber - nid-id of Balise
     * @param iRouteElementNumber - Routen-Element-Anzahl
     * @return RouteDataSL - die angeforderte Route
     */
    public RouteDataSL generateRandomContinousRouteOnBalise(int iBaliseNumber, int iRouteElementNumber) {
        RouteDataSL RouteResult = new RouteDataSL();
        ArrayList<ITopological> visitedElements = new ArrayList<>();
        TopologyGraph.Edge NewWay = null;
        ITopological CurrentElement;
        Balise B = Balise.baliseByNid_bg.getModel(iBaliseNumber);
        TopologyGraph.Edge EdgeOfBalise = PlanData.topGraph.edgeRepo.get(B.getTopPositionOfDataPoint().getIdentitaet().getWert());
        CurrentElement = handleBeginOnBalise(RouteResult, visitedElements, TestUtil.RouteConfig.BALISE_NEAR_CROSSING);



        return getRouteBeginingOnElementSpecified(iRouteElementNumber,TestUtil.RouteConfig.BALISE_NOT_NEAR_CROSSING,
                RouteResult, visitedElements,NewWay, CurrentElement);
    }

    /**
     * Generiert aus PlanPro-Daten zufällige zusammenhängende Strecken.
     * @param iTargetAmountOfRouteElements int - Anzahl der Beteiligten Elmente (Kanten oder Knoten)
     * @param beginnOnEdge boolean - bestimmt ob die Zufallsstrecke auf einer Kante beginnt
     * @return Streckenlisten mit Art (Knoten oder Kante) und konkretem Element.
     */
    public RouteDataSL generateRandomContinousRoute(
            int iTargetAmountOfRouteElements,
                                                                                      boolean beginnOnEdge,
                                                                                      boolean beginnWithBalise,
                                                                                      TestUtil.RouteConfig TestConfig) {
        RouteDataSL RouteResult = new RouteDataSL();
        ArrayList<ITopological> visitedElements = new ArrayList<>();

        TopologyGraph.Edge NewWay = null;
        ITopological CurrentElement;
        if(beginnWithBalise) {
            CurrentElement = handleBeginOnBalise(RouteResult,visitedElements, TestConfig);
        } else if(beginnOnEdge) {
            CurrentElement = handleBeginOnEdge(RouteResult, visitedElements);
        } else {
            CurrentElement = handleBeginOnNode(RouteResult, visitedElements);
        }
        return getRouteBeginingOnElementSpecified(iTargetAmountOfRouteElements, TestConfig, RouteResult, visitedElements, NewWay, CurrentElement);
    }

    @Nullable
    private RouteDataSL getRouteBeginingOnElementSpecified(int iTargetAmountOfRouteElements, TestUtil.RouteConfig TestConfig, RouteDataSL routeResult, ArrayList<ITopological> visitedElements, TopologyGraph.Edge newWay, ITopological currentElement) {
        for (int i = visitedElements.size(); i <= iTargetAmountOfRouteElements; i = visitedElements.size()) {
            int iWayIndex;

            ArrayList<TopologyGraph.Edge> possibleWays = new ArrayList<>();
            fillPossibleWays(visitedElements, (TopologyGraph.Node) currentElement, possibleWays, TestConfig);
            if (possibleWays.isEmpty()) {
                if (routeResult.size() < I_LOWEST_ROUTE_LENGTH) return null;
                else return routeResult;

            }
            if (possibleWays.size() == 1) iWayIndex = 0;
            else iWayIndex = Math.abs(new Random().nextInt()) % (possibleWays.size() - 1);
            newWay = possibleWays.get(iWayIndex);
            if (i == iTargetAmountOfRouteElements) break;
            currentElement = prepareNewIteration(routeResult, visitedElements, newWay);

        }
        return returnFinishedRoute(routeResult, visitedElements, newWay);
    }

    public void fillPossibleWays(ArrayList<ITopological> visitedElements, TopologyGraph.Node currentElement,
                                 ArrayList<TopologyGraph.Edge> possibleWays, TestUtil.RouteConfig testConfig) {

        for (TopologyGraph.Edge E : currentElement.inEdges) {
            if (checkIfEdgeIsPossible(E, currentElement, testConfig, visitedElements)) {
                possibleWays.add(E);
            }
        }
        for (TopologyGraph.Edge E : currentElement.outEdges) {
            if (checkIfEdgeIsPossible(E, currentElement, testConfig, visitedElements)) {
                possibleWays.add(E);
            }
        }
    }

    private boolean checkIfEdgeIsPossible(TopologyGraph.Edge E, TopologyGraph.Node currentElement, TestUtil.RouteConfig testConfig, ArrayList<ITopological> visitedElements) {
        switch (testConfig) {
            case BALISE_TARGET_POINTS_TO_PEEK_AND_NOT_NEAR_CROSSING: {
                if(visitedElements.size() != 1) {
                    return checkIfVisited(E,visitedElements);
                }
                if(E.A.equals(currentElement)) {
                    if(E.TopConnectFromA.equals(TopologyConnect.SPITZE)) {
                        return false;
                    } else return true;
                } else if(E.B.equals(currentElement)) {
                    if(E.TopConnectFromB.equals(TopologyConnect.SPITZE)) {
                        return false;
                    } return true;
                }
                return false;
            }
            default: {
                return checkIfVisited(E, visitedElements);
            }
        }
    }

    private boolean checkIfVisited(TopologyGraph.Edge e, ArrayList<ITopological> visitedElements) {
        if (!visitedElements.contains(e)) {
            return true;
        }
        return false;
    }

    private ITopological handleBeginOnBalise(RouteDataSL routeResult, ArrayList<ITopological> visitedElements,
                                           TopologyGraph.Edge EdgeWithBalise) {
        I_CURRENT_TRYS = 0;
        boolean bDirectionNodeA = new Random().nextBoolean();

        return provideTrackElement4Edge(routeResult, visitedElements, bDirectionNodeA, EdgeWithBalise);
    }

    private ITopological handleBeginOnBalise(RouteDataSL routeResult, ArrayList<ITopological> visitedElements, TestUtil.RouteConfig TestConfig) {
        I_CURRENT_TRYS = 0;
        boolean bDirectionNodeA = new Random().nextBoolean();
        TopologyGraph.Edge EdgeWithBalise = pickRandomEdgeWithBalise(TestConfig);
        return provideTrackElement4Edge(routeResult, visitedElements, bDirectionNodeA, EdgeWithBalise);
    }

    private TopologyGraph.Edge pickRandomEdgeWithBalise(TestUtil.RouteConfig TestConfig) {
       if(I_CURRENT_TRYS > I_TRYS_FOR_FINAL_ROUTE) {
           throw new InvalidParameterException("No Balise, that is beeing out of Crossover-Scpe found");
       }
       ArrayList<Balise> balises = new ArrayList<>(Balise.baliseByNid_bg.getAll());
       Balise B = (Balise) pickRandomElement(balises);
       TestUtil.lastRandomBalise = B;

       switch (TestConfig) {
           case BALISE_NEAR_CROSSING: {
               return PlanData.topGraph.edgeRepo.get(B.getTopPositionOfDataPoint().getIdentitaet().getWert());
           }
           case BALISE_NOT_NEAR_CROSSING: {
               return retrieveBaliseNotNearCrossing(TestConfig, B);
           }
           case BALISE_TARGET_POINTS_TO_PEEK_AND_NOT_NEAR_CROSSING: {
               return retrieveBaliseNotNearCrossing(TestConfig, B);
           }
           default: {
               throw new InvalidParameterException("Given Route Configuration not found");
           }
       }



    }

    private TopologyGraph.Edge retrieveBaliseNotNearCrossing(TestUtil.RouteConfig testConfig, Balise b) {
        if(!checkIfBaliseIsInCrossoverArea(b) ) {
            I_CURRENT_TRYS++;
            return pickRandomEdgeWithBalise(testConfig);
        }
        return PlanData.topGraph.edgeRepo.get(b.getTopPositionOfDataPoint().getIdentitaet().getWert());
    }

    private boolean checkIfBaliseIsInCrossoverArea(Balise B) {
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(B.getTopPositionOfDataPoint().getIdentitaet().getWert());
        CrossingSwitch CS = null;
        if (edgeHavingNonPeekConnection(E)) {
            // Weiche ist NICHT über spitze mit Kante der Balise verbunden

            Occupation Datapointarea = B.createAreaFromBalise();
            return Datapointarea.getListOfEdgeLimits().size() > 0;
        }
        return false;
    }

    private boolean edgeHavingNonPeekConnection(TopologyGraph.Edge e) {
        return e.TopConnectFromB.equals(TopologyConnect.LINKS) || e.TopConnectFromB.equals(TopologyConnect.RECHTS)

                ||

                e.TopConnectFromA.equals(TopologyConnect.LINKS) || e.TopConnectFromA.equals(TopologyConnect.RECHTS);
    }


    private RouteDataSL generateRandomContinousRoute(int iTargetAmountOfRouteElements) {
        RouteDataSL RouteResult = new RouteDataSL();
        ArrayList<ITopological> visitedElements = new ArrayList<>();
        boolean beginnOnEdge = new Random().nextBoolean();
        TopologyGraph.Edge NewWay = null;
        ITopological CurrentElement;
        if(beginnOnEdge) {
            CurrentElement = handleBeginOnEdge(RouteResult, visitedElements);
        } else {
            CurrentElement = handleBeginOnNode(RouteResult, visitedElements);
        }
        return getRouteBeginingOnElementSpecified(iTargetAmountOfRouteElements, TestUtil.RouteConfig.BALISE_NEAR_CROSSING, RouteResult, visitedElements, NewWay, CurrentElement);
    }

    private ITopological handleBeginOnEdge(RouteDataSL routeResult, ArrayList<ITopological> visitedElements) {
        boolean bDirectionNodeA = new Random().nextBoolean();
        TopologyGraph.Edge OldEdge = pickRandomEdge();
        return provideTrackElement4Edge(routeResult, visitedElements, bDirectionNodeA, OldEdge);
    }

    private ITopological provideTrackElement4Edge(RouteDataSL routeResult, ArrayList<ITopological> visitedElements, boolean bDirectionNodeA, TopologyGraph.Edge oldEdge) {
        ITopological currentElement = null;
        visitedElements.add(oldEdge);
        routeResult.add(new ImmutablePair(Route.TrackElementType.RAIL_TYPE, oldEdge));
        if(bDirectionNodeA) {
            currentElement = oldEdge.A;
        } else {
            currentElement = oldEdge.B;
        }
        visitedElements.add(currentElement);
        routeResult.add(new ImmutablePair<>(Route.TrackElementType.CROSSOVER_TYPE, currentElement));
        return currentElement;
    }

    private ITopological handleBeginOnNode(RouteDataSL routeResult, ArrayList<ITopological> visitedElements) {
        ITopological CurrentElement;
        CurrentElement = this.pickRandomNode();
        visitedElements.add(CurrentElement);
        routeResult.add(new ImmutablePair<>(Route.TrackElementType.CROSSOVER_TYPE, CurrentElement));
        return CurrentElement;
    }

    private RouteDataSL returnFinishedRoute(RouteDataSL routeResult, ArrayList<ITopological> visitedElements, TopologyGraph.Edge newWay) {
        boolean bEndOnEdge = new Random().nextBoolean();
        if(bEndOnEdge) {
            routeResult.add(new ImmutablePair(Route.TrackElementType.RAIL_TYPE, newWay));
        } else {
            TopologyGraph.Node LastTargetNode = getNodeNotVisited(visitedElements, newWay);
            routeResult.add(new ImmutablePair<>(Route.TrackElementType.CROSSOVER_TYPE, LastTargetNode));
        }
        return routeResult;
    }

    private ITopological prepareNewIteration(RouteDataSL routeResult, ArrayList<ITopological> visitedElements, TopologyGraph.Edge newWay) {
        ITopological CurrentElement;
        visitedElements.add(newWay);
        CurrentElement = getNodeNotVisited(visitedElements, newWay);
        visitedElements.add(CurrentElement);
        routeResult.add(new ImmutablePair<>(Route.TrackElementType.CROSSOVER_TYPE, CurrentElement));
        return CurrentElement;
    }

    private TopologyGraph.Node getNodeNotVisited(ArrayList<ITopological> visitedElements, TopologyGraph.Edge newWay) {
        TopologyGraph.Node LastTargetNode = newWay.A;
        if(visitedElements.contains(LastTargetNode)) {
            LastTargetNode = newWay.B;
        }
        return LastTargetNode;
    }

    private int calcRouteElementAmount() {
        return Math.abs(new Random().nextInt()) % (this.I_MAX_ROUTE_LENGTH  - this.I_LOWEST_ROUTE_LENGTH)  + this.I_LOWEST_ROUTE_LENGTH;
    }
    private int calcRouteElementAmountWithLowLimit(int iLowLength) {
        return Math.abs(new Random().nextInt()) % (this.I_MAX_ROUTE_LENGTH  - iLowLength)  + iLowLength;

    }


    private TopologyGraph.Node pickRandomNode() {
        if(nodeList == null) nodeList = new ArrayList<TopologyGraph.Node>(TopologyGraph.NodeRepo.values());
        return (TopologyGraph.Node) pickRandomElement(nodeList);

    }
    private TopologyGraph.Node pickRandomNode(Pair<Route.TrackElementType, ITopological> notConnectedWith) {
        ITopological ElementNotConnectedWith = notConnectedWith.getRight();
        for(int i = 0; i < I_TRYS_FOR_FINAL_ROUTE; i++) {

            TopologyGraph.Node ReturnNode = pickRandomNode();
            if(notConnectedWith.getLeft().equals(Route.TrackElementType.CROSSOVER_TYPE)) {
                if(checkEdgesNotConnected(new ArrayList<>(ReturnNode.inEdges), (TopologyGraph.Node)ElementNotConnectedWith)) {
                    if(checkEdgesNotConnected(new ArrayList<>(ReturnNode.outEdges), (TopologyGraph.Node)ElementNotConnectedWith)) {
                        return ReturnNode;
                    }
                }
            } else {
                TopologyGraph.Edge NotConnectedEdge = (TopologyGraph.Edge) ElementNotConnectedWith;
                if (!NotConnectedEdge.A.equals(ReturnNode) && !NotConnectedEdge.B.equals(ReturnNode)) {
                    return ReturnNode;
                }
            }

        }
        throw new InvalidParameterException("Bad Test environment not finding unconnected nodes");

    }
    private boolean checkEdgesNotConnected(List<TopologyGraph.Edge> edges, TopologyGraph.Node N) {
        for(TopologyGraph.Edge E: edges) {
            if(E.A.equals(N) || E.B.equals(N)) return false;
        }
        return true;
    }

    private TopologyGraph.Edge pickRandomEdge(Pair<Route.TrackElementType, ITopological> notConnectedWith) {
        ITopological ElementNotConnectedWith = notConnectedWith.getRight();
        for(int i = 0; i < I_TRYS_FOR_FINAL_ROUTE; i++) {

            TopologyGraph.Edge ReturnEdge = pickRandomEdge();
            if(notConnectedWith.getLeft().equals(Route.TrackElementType.CROSSOVER_TYPE)) {
                TopologyGraph.Node NotConnectedNode = (TopologyGraph.Node) notConnectedWith.getRight();
                if(!ReturnEdge.A.equals(NotConnectedNode) && !ReturnEdge.B.equals(NotConnectedNode)) {
                    return ReturnEdge;
                }
            } else {
                TopologyGraph.Edge NotConnectedEdge = (TopologyGraph.Edge) ElementNotConnectedWith;
                if(!NotConnectedEdge.equals(ReturnEdge)) {
                    return ReturnEdge;
                }
            }

        }
        throw new InvalidParameterException("Bad Test environment not finding unconnected nodes");

    }


    private TopologyGraph.Edge pickRandomEdge() {
        if(edgeList == null) edgeList = new ArrayList<TopologyGraph.Edge>(PlanData.topGraph.edgeRepo.values());
        return (TopologyGraph.Edge) pickRandomElement(edgeList);
    }

    private  Object pickRandomElement(ArrayList pickList) {
        if(pickList.isEmpty()) throw new InvalidParameterException("Bad Test Environment node List is empty");
        else {
            int iRandomIndex = Math.abs(new Random().nextInt()) % (pickList.size() -1 );
            return pickList.get(iRandomIndex);
        }
    }



}