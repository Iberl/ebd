package de.ibw.smart.logic.safety.self.tests;

import de.ibw.feed.Balise;
import de.ibw.smart.logic.safety.SmartSafety;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CBalise;

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
 * @since 2020-09-04
 */
public class SmartSafetyContinousConnectTest {


    private PlanData PD = PlanData.getInstance();
    private ArrayList<TopologyGraph.Node> nodeList;
    private ArrayList<TopologyGraph.Edge> edgeList;
    private final int I_TRYS_FOR_FINAL_ROUTE = 70;

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
        SmartSafety ModulUnderTest = SmartSafety.getSmartSafety();

        try {
            ModulUnderTest.checkIfRouteIsContinuousConnected(null, null);
            // this assert shall not be called, since code above thorws Nullpointer
            Assertions.assertEquals("Exception", false);
        } catch (Exception E) {
            Assertions.assertTrue(true);
        }
    }

    /**
     * Kontrolliert, dass die Routenliste nicht leer sein darf
     */
    @Test
    public void checkIfRouteIsContinuousWithEmptyTrackList() {
        SmartSafety ModulUnderTest = SmartSafety.getSmartSafety();
        try {
            ModulUnderTest.checkIfRouteIsContinuousConnected(null, new ArrayList<>());
            // this assert shall not be called, since code above thorws Nullpointer
            Assertions.assertEquals("Exception", false);
        } catch (Exception E) {
            Assertions.assertTrue(true);
        }
    }

    /**
     * Kontrolliert das sie SmartSafty erkennt, dass zu wenig Routenelemente gegeben sind.
     */
    @Test
    public void checkIfRouteIsContinuousWithToLessItems() {
        SmartSafety ModulUnderTest = SmartSafety.getSmartSafety();
        Pair<Route.TrackElementType, TrackElement> test1 = new ImmutablePair<>(Route.TrackElementType.CROSSOVER_TYPE, this.pickRandomNode());
        TopologyGraph.Node N = pickRandomNode();
        try {
            ArrayList<Pair<Route.TrackElementType, TrackElement>> list1 = new ArrayList();
            list1.add(test1);
            ModulUnderTest.checkIfRouteIsContinuousConnected(null, list1);
            // this assert shall not be called, since code above thorws Nullpointer
            Assertions.assertEquals("Exception", false);
        } catch (Exception E) {
            Assertions.assertTrue(true);
        }
        try {
            ArrayList<Pair<Route.TrackElementType, TrackElement>> list2 = new ArrayList();
            list2.add(new ImmutablePair<>(Route.TrackElementType.RAIL_TYPE, this.pickRandomEdge()));
            ModulUnderTest.checkIfRouteIsContinuousConnected(null, list2);
            // this assert shall not be called, since code above thorws Nullpointer
            Assertions.assertEquals("Exception", false);
        } catch (Exception E) {
            Assertions.assertTrue(true);
        }
    }

    /**
     * Kontrolliert, ob SmartSafety erkennt, dass ein Routen-Element in der Liste null ist.
     */
    @Test
    public void checkIfSmartSaftyRecogniseInvalidNullValues() {
        SmartSafety ModulUnderTest = SmartSafety.getSmartSafety();
        ArrayList<ArrayList<Pair<Route.TrackElementType, TrackElement>>> testRoutes = new ArrayList<>();
        for(int i = 0; i < this.I_TRYS_FOR_FINAL_ROUTE; i++) {
            if(testRoutes.size() <= this.I_AMOUNT_OF_TESTS_4_ACCEPTED_ROUTE_TESTS) {
                ArrayList<Pair<Route.TrackElementType, TrackElement>> OneRoute = generateRandomContinousRoute();
                if(null != OneRoute) {
                    testRoutes.add(OneRoute);
                }
            }
        }
        for(ArrayList<Pair<Route.TrackElementType, TrackElement>> Route : testRoutes) {
            try {
                Route = malifiyRouteWithNullEntry(Route);
                ModulUnderTest.checkIfRouteIsContinuousConnected(null, Route);
                // this assert shall not be called, since code above thorws Nullpointer
                Assertions.assertEquals("Exception", false);
            } catch (Exception E) {
                Assertions.assertTrue(true);
            }
        }
    }


    /**
     * Kontrolliert, ob SmartSafety erkennt, dass die Route in Ordnung ist
     */
    @Test
    public void checkIfRouteContinousShallReturnTrue() {
        SmartSafety ModulUnderTest = SmartSafety.getSmartSafety();
        ArrayList<ArrayList<Pair<Route.TrackElementType, TrackElement>>> testRoutes = new ArrayList<>();
        for(int i = 0; i < this.I_TRYS_FOR_FINAL_ROUTE; i++) {
            if(testRoutes.size() <= this.I_AMOUNT_OF_TESTS_4_ACCEPTED_ROUTE_TESTS) {
                ArrayList<Pair<Route.TrackElementType, TrackElement>> OneRoute = generateRandomContinousRoute();
                if(null != OneRoute) {
                    testRoutes.add(OneRoute);
                }
            }
        }
        for(ArrayList<Pair<Route.TrackElementType, TrackElement>> Route : testRoutes) {
            boolean bResult = ModulUnderTest.checkIfRouteIsContinuousConnected(null, Route);

            Assertions.assertTrue(bResult);
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
        SmartSafety ModulUnderTest = SmartSafety.getSmartSafety();
        ArrayList<ArrayList<Pair<Route.TrackElementType, TrackElement>>> testRoutes = prepareWorkingRoutes(new ArrayList<>());

        for(ArrayList<Pair<Route.TrackElementType, TrackElement>> Route : testRoutes) {

                Route = malifiyRouteWithWrongEntry(Route, malification);


            try {

                boolean b = (ModulUnderTest.checkIfRouteIsContinuousConnected(null, Route));
                if(b) {
                    System.out.println("bad result");
                }
                Assertions.assertFalse(b);

            } catch (Exception E) {
                E.printStackTrace();

                Assertions.fail();
            }
        }
    }

    private ArrayList<Pair<Route.TrackElementType, TrackElement>> malifiyRouteWithWrongEntry(ArrayList<Pair<Route.TrackElementType, TrackElement>> route, MalifyRouteWithWrongValues malifyPosition) {
        ArrayList<Pair<Route.TrackElementType, TrackElement>> newMalicousRoute = new ArrayList<>();
        int iMaliciousIndex =  Math.abs(new Random().nextInt()) % (route.size() - 1);
        Pair<Route.TrackElementType, TrackElement> BadItem = null;
        switch (malifyPosition) {
            case MALIFY_START: {
                iMaliciousIndex = 0;

                Pair<Route.TrackElementType, TrackElement> maliciosItem = route.get(iMaliciousIndex);
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

                Pair<Route.TrackElementType, TrackElement> maliciosItem = route.get(iMaliciousIndex);
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

    private ArrayList<Pair<Route.TrackElementType, TrackElement>> replaceMiddleElementWithOtherOne(ArrayList<Pair<Route.TrackElementType, TrackElement>> route, ArrayList<Pair<Route.TrackElementType, TrackElement>> newMalicousRoute, int iMaliciousIndex) {
        Route.TrackElementType BadType;
        Pair<Route.TrackElementType, TrackElement> BadItem;
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

    private ArrayList<Pair<Route.TrackElementType, TrackElement>> invertType(ArrayList<Pair<Route.TrackElementType, TrackElement>> route, ArrayList<Pair<Route.TrackElementType, TrackElement>> newMalicousRoute, int iMaliciousIndex, Pair<Route.TrackElementType, TrackElement> maliciosItem, Route.TrackElementType originalElementType) {
        Pair<Route.TrackElementType, TrackElement> BadItem;
        Route.TrackElementType BadType = Route.TrackElementType.RAIL_TYPE;
        if(originalElementType.equals(Route.TrackElementType.RAIL_TYPE)) {
            BadType = Route.TrackElementType.CROSSOVER_TYPE;
        }
        BadItem = new ImmutablePair<>(BadType, maliciosItem.getRight());
        return createMalicousRoute(route, newMalicousRoute, iMaliciousIndex, BadItem);
    }

    private ArrayList<Pair<Route.TrackElementType, TrackElement>> replaceElementWithOtherOne(ArrayList<Pair<Route.TrackElementType, TrackElement>> route, ArrayList<Pair<Route.TrackElementType, TrackElement>> newMalicousRoute, int iMaliciousIndex, Route.TrackElementType originalElementType, boolean isStart) {

        if(originalElementType.equals(Route.TrackElementType.CROSSOVER_TYPE)) {
            return handleStartOrEndWithMalicousCrossover(route, newMalicousRoute, iMaliciousIndex, isStart);
        } else {
            return handleStartOrEndWithMalicousRail(route, newMalicousRoute, iMaliciousIndex, isStart);
        }
    }

    private ArrayList<Pair<Route.TrackElementType, TrackElement>> handleStartOrEndWithMalicousCrossover(ArrayList<Pair<Route.TrackElementType, TrackElement>> route, ArrayList<Pair<Route.TrackElementType, TrackElement>> newMalicousRoute, int iMaliciousIndex, boolean isStart) {
        Route.TrackElementType BadType;
        Pair<Route.TrackElementType, TrackElement> BadItem;
        BadType = Route.TrackElementType.CROSSOVER_TYPE;
        TopologyGraph.Node MaliciousNode = getMalicousNode(route, isStart);
        BadItem = new ImmutablePair<>(BadType, MaliciousNode);
        return createMalicousRoute(route, newMalicousRoute, iMaliciousIndex, BadItem );
    }

    private TopologyGraph.Node getMalicousNode(ArrayList<Pair<Route.TrackElementType, TrackElement>> route, boolean isStart) {
        return isStart ? pickRandomNode(route.get(1)) : pickRandomNode(route.get(route.size()-2));
    }

    private ArrayList<Pair<Route.TrackElementType, TrackElement>> handleStartOrEndWithMalicousRail(ArrayList<Pair<Route.TrackElementType, TrackElement>> route, ArrayList<Pair<Route.TrackElementType, TrackElement>> newMalicousRoute, int iMaliciousIndex, boolean isStart) {
        Route.TrackElementType BadType;
        Pair<Route.TrackElementType, TrackElement> BadItem;
        BadType = Route.TrackElementType.RAIL_TYPE;
        TopologyGraph.Edge MaliciousStartEdge = isStart ? pickRandomEdge(route.get(1)) : pickRandomEdge(route.get(route.size() -2));
        BadItem = new ImmutablePair<>(BadType, MaliciousStartEdge);
        return createMalicousRoute(route, newMalicousRoute, iMaliciousIndex, BadItem );
    }


    private ArrayList<Pair<Route.TrackElementType, TrackElement>> createMalicousRoute(ArrayList<Pair<Route.TrackElementType, TrackElement>> route, ArrayList<Pair<Route.TrackElementType, TrackElement>> newMalicousRoute, int iMaliciousIndex, Pair<Route.TrackElementType, TrackElement> badItem) {
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


    private ArrayList<ArrayList<Pair<Route.TrackElementType, TrackElement>>> prepareWorkingRoutes(ArrayList<ArrayList<Pair<Route.TrackElementType, TrackElement>>> testRoutes) {
        for(int i = 0; i < this.I_AMOUNT_OF_TESTS_4_NEGATIVE_ROUTE_TESTS; i++) {
            if(testRoutes.size() <= this.I_AMOUNT_OF_TESTS_4_NEGATIVE_ROUTE_TESTS) {
                ArrayList<Pair<Route.TrackElementType, TrackElement>> OneRoute = generateRandomContinousRoute();
                if(null != OneRoute) {
                    testRoutes.add(OneRoute);
                }
            }
        }
        return testRoutes;
    }


    private ArrayList<Pair<Route.TrackElementType, TrackElement>> malifiyRouteWithNullEntry(ArrayList<Pair<Route.TrackElementType, TrackElement>> route) {
        ArrayList<Pair<Route.TrackElementType, TrackElement>> newMalicousRoute = new ArrayList<>();
        int iMaliciousIndex =  Math.abs(new Random().nextInt()) % (route.size() - 1);
        Pair<Route.TrackElementType, TrackElement> maliciosItem = route.get(iMaliciousIndex);
        Pair<Route.TrackElementType, TrackElement> BadNullItem = null;
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

    private ArrayList<Pair<Route.TrackElementType, TrackElement>> generateRandomContinousRoute() {
        int iTargetAmountOfRouteElements = calcRouteElementAmount();
        return generateRandomContinousRoute(iTargetAmountOfRouteElements);


    }

    /**
     * Generiert aus PlanPro-Daten zufällige zusammenhängende Strecken.
     * @param iTargetAmountOfRouteElements int - Anzahl der Beteiligten Elmente (Kanten oder Knoten)
     * @param beginnOnEdge boolean - bestimmt ob die Zufallsstrecke auf einer Kante beginnt
     * @return Streckenlisten mit Art (Knoten oder Kante) und konkretem Element.
     */
    public ArrayList<Pair<Route.TrackElementType, TrackElement>> generateRandomContinousRoute(int iTargetAmountOfRouteElements,
                                                                                              boolean beginnOnEdge,
                                                                                              boolean beginnWithBalise) {
        ArrayList<Pair<Route.TrackElementType, TrackElement>> RouteResult = new ArrayList<>();
        ArrayList<TrackElement> visitedElements = new ArrayList<>();

        TopologyGraph.Edge NewWay = null;
        TrackElement CurrentElement;
        if(beginnWithBalise) {
            CurrentElement = handleBeginOnBalise(RouteResult,visitedElements);
        } else if(beginnOnEdge) {
            CurrentElement = handleBeginOnEdge(RouteResult, visitedElements);
        } else {
            CurrentElement = handleBeginOnNode(RouteResult, visitedElements);
        }
        for(int i = visitedElements.size(); i <= iTargetAmountOfRouteElements; i = visitedElements.size() ) {
            int iWayIndex;

            ArrayList<TopologyGraph.Edge> possibleWays = new ArrayList<>();
            TopologyGraph.Node CurrentNode = (TopologyGraph.Node) CurrentElement;
            for(TopologyGraph.Edge E: CurrentNode.inEdges) {
                if(!visitedElements.contains(E))possibleWays.add(E);
            }
            for(TopologyGraph.Edge E: ((TopologyGraph.Node) CurrentElement).outEdges) {
                if(!visitedElements.contains(E))possibleWays.add(E);
            }
            if(possibleWays.isEmpty()) {
                if(RouteResult.size() < I_LOWEST_ROUTE_LENGTH) return null;
                else return RouteResult;

            } if(possibleWays.size() == 1) iWayIndex = 0;
            else iWayIndex = Math.abs(new Random().nextInt()) % (possibleWays.size() - 1);
            NewWay = possibleWays.get(iWayIndex);
            if(i == iTargetAmountOfRouteElements) break;
            CurrentElement = prepareNewIteration(RouteResult, visitedElements, NewWay);

        }
        return returnFinishedRoute(RouteResult, visitedElements, NewWay);
    }

    private TrackElement handleBeginOnBalise(ArrayList<Pair<Route.TrackElementType, TrackElement>> routeResult, ArrayList<TrackElement> visitedElements) {
        boolean bDirectionNodeA = new Random().nextBoolean();
        TopologyGraph.Edge EdgeWithBalise = pickRandomEdgeWithBalise();
        return provideTrackElement4Edge(routeResult, visitedElements, bDirectionNodeA, EdgeWithBalise);
    }

    private TopologyGraph.Edge pickRandomEdgeWithBalise() {
       ArrayList<Balise> balises = new ArrayList<>(Balise.baliseByNid_bg.getAll());
       Balise B = (Balise) pickRandomElement(balises);
       TestUtil.lastRandomBalise = B;
       return PlanData.topGraph.EdgeRepo.get(B.getTopPositionOfDataPoint().getIdentitaet().getWert());
    }

    @Nullable
    private ArrayList<Pair<Route.TrackElementType, TrackElement>> generateRandomContinousRoute(int iTargetAmountOfRouteElements) {
        ArrayList<Pair<Route.TrackElementType, TrackElement>> RouteResult = new ArrayList<>();
        ArrayList<TrackElement> visitedElements = new ArrayList<>();
        boolean beginnOnEdge = new Random().nextBoolean();
        TopologyGraph.Edge NewWay = null;
        TrackElement CurrentElement;
        if(beginnOnEdge) {
            CurrentElement = handleBeginOnEdge(RouteResult, visitedElements);
        } else {
            CurrentElement = handleBeginOnNode(RouteResult, visitedElements);
        }
        for(int i = visitedElements.size(); i <= iTargetAmountOfRouteElements; i = visitedElements.size() ) {
            int iWayIndex;

            ArrayList<TopologyGraph.Edge> possibleWays = new ArrayList<>();
            TopologyGraph.Node CurrentNode = (TopologyGraph.Node) CurrentElement;
            for(TopologyGraph.Edge E: CurrentNode.inEdges) {
                if(!visitedElements.contains(E))possibleWays.add(E);
            }
            for(TopologyGraph.Edge E: ((TopologyGraph.Node) CurrentElement).outEdges) {
                if(!visitedElements.contains(E))possibleWays.add(E);
            }
            if(possibleWays.isEmpty()) {
                if(RouteResult.size() < I_LOWEST_ROUTE_LENGTH) return null;
                else return RouteResult;

            } if(possibleWays.size() == 1) iWayIndex = 0;
            else iWayIndex = Math.abs(new Random().nextInt()) % (possibleWays.size() - 1);
            NewWay = possibleWays.get(iWayIndex);
            if(i == iTargetAmountOfRouteElements) break;
            CurrentElement = prepareNewIteration(RouteResult, visitedElements, NewWay);

        }
        return returnFinishedRoute(RouteResult, visitedElements, NewWay);
    }

    private TrackElement handleBeginOnEdge(ArrayList<Pair<Route.TrackElementType, TrackElement>> routeResult, ArrayList<TrackElement> visitedElements) {
        boolean bDirectionNodeA = new Random().nextBoolean();
        TopologyGraph.Edge OldEdge = pickRandomEdge();
        return provideTrackElement4Edge(routeResult, visitedElements, bDirectionNodeA, OldEdge);
    }

    private TrackElement provideTrackElement4Edge(ArrayList<Pair<Route.TrackElementType, TrackElement>> routeResult, ArrayList<TrackElement> visitedElements, boolean bDirectionNodeA, TopologyGraph.Edge oldEdge) {
        TrackElement currentElement = null;
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

    private TrackElement handleBeginOnNode(ArrayList<Pair<Route.TrackElementType, TrackElement>> routeResult, ArrayList<TrackElement> visitedElements) {
        TrackElement CurrentElement;
        CurrentElement = this.pickRandomNode();
        visitedElements.add(CurrentElement);
        routeResult.add(new ImmutablePair<>(Route.TrackElementType.CROSSOVER_TYPE, CurrentElement));
        return CurrentElement;
    }

    private ArrayList<Pair<Route.TrackElementType, TrackElement>> returnFinishedRoute(ArrayList<Pair<Route.TrackElementType, TrackElement>> routeResult, ArrayList<TrackElement> visitedElements, TopologyGraph.Edge newWay) {
        boolean bEndOnEdge = new Random().nextBoolean();
        if(bEndOnEdge) {
            routeResult.add(new ImmutablePair(Route.TrackElementType.RAIL_TYPE, newWay));
        } else {
            TopologyGraph.Node LastTargetNode = getNodeNotVisited(visitedElements, newWay);
            routeResult.add(new ImmutablePair<>(Route.TrackElementType.CROSSOVER_TYPE, LastTargetNode));
        }
        return routeResult;
    }

    private TrackElement prepareNewIteration(ArrayList<Pair<Route.TrackElementType, TrackElement>> routeResult, ArrayList<TrackElement> visitedElements, TopologyGraph.Edge newWay) {
        TrackElement CurrentElement;
        visitedElements.add(newWay);
        CurrentElement = getNodeNotVisited(visitedElements, newWay);
        visitedElements.add(CurrentElement);
        routeResult.add(new ImmutablePair<>(Route.TrackElementType.CROSSOVER_TYPE, CurrentElement));
        return CurrentElement;
    }

    private TopologyGraph.Node getNodeNotVisited(ArrayList<TrackElement> visitedElements, TopologyGraph.Edge newWay) {
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
    private TopologyGraph.Node pickRandomNode(Pair<Route.TrackElementType, TrackElement> notConnectedWith) {
        TrackElement ElementNotConnectedWith = notConnectedWith.getRight();
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

    private TopologyGraph.Edge pickRandomEdge(Pair<Route.TrackElementType, TrackElement> notConnectedWith) {
        TrackElement ElementNotConnectedWith = notConnectedWith.getRight();
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
        if(edgeList == null) edgeList = new ArrayList<TopologyGraph.Edge>(PlanData.topGraph.EdgeRepo.values());
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