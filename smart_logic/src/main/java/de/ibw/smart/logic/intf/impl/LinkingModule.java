package de.ibw.smart.logic.intf.impl;

import de.ibw.feed.Balise;
import de.ibw.history.data.ComposedRoute;
import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.ILinkingIntf;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.tms.ma.Waypoint;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import de.ibw.tms.trackplan.ui.Route;
import de.ibw.util.ThreadedRepo;
import ebd.messageLibrary.packet.trackpackets.Packet_5;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Diese Klasse verwaltet das Linking.
 * Die smartLogic sendet dem Zug das Linking ueber das RBC
 * Das Linking ist das Packet 5 im ETCS
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.10
 * @since 2021-06-21
 */
public class LinkingModule implements ILinkingIntf {

    private volatile static LinkingModule instance;
    private static EventBusManager EBM = null;
    private static String MODULE_NAME = "Linking_Modul";

    private Packet_5 result = null;


    /**
     * Singelton
     * @return LinkingModule - Instanz dieses Modules
     */
    public static synchronized LinkingModule getInstance() {
        if(instance == null) {
            instance = new LinkingModule();
            EBM = EventBusManager.RootEventBusManger;
        }
        return instance;
    }

    /***
     * Die Composed Route beinhaltet alle Gleiskanten (Topology.Edge Class)
     * Die Balisen in der Balise.class hat ein Repository "baliseOnEdge" es speichert alle Balisen auf der Kante
     * @param compRoute - ComposedRoute vollstaendige Route als Array von Edge und weiteren Topologie elemente
     *                  - Array in Durchlauf der Fahrtrichtung
     *                  - Composed Route erbt von einem Array von Pairs
     *                  - Pair<-LEFT : Typ der Topologie
     *                  - Pair->RIGHT : Tatsächlicher Wert e.g eine Edge
     * @param nid_lrbg  - Start-Referenz-Balise
     * @return Packet_5 - das ETCS-Linking-Profile
     */
    public synchronized Packet_5 generateLinkingByRoute(ComposedRoute compRoute, int nid_lrbg) {
        EBM.log("Creating Linking for Route, Start NID_LRBG: " + nid_lrbg, SmartLogic.getsModuleId(MODULE_NAME));

        result = null;
        int iterations = 0;
        BigDecimal routeLengthBeingIterated = new BigDecimal("0.0");
        TopologyGraph.Edge LastEdge = null;
        for (Pair<Route.TrackElementType, ITopological> RoutePart: compRoute) {
            if(RoutePart == null) continue;
            if(RoutePart.getLeft().equals(Route.TrackElementType.RAIL_TYPE)) {
                LastEdge = handleEdgeRailType(compRoute, nid_lrbg, iterations, routeLengthBeingIterated, LastEdge, RoutePart);
            }
            iterations++;
        }

        if(result == null) {
            EBM.log("Linking done - Start Balise " + nid_lrbg  +
                    " is existing on route alone",  SmartLogic.getsModuleId(MODULE_NAME));
        } else {
            int iLinkds = result.links.size() + 1;
            EBM.log("Linking done - Route having " + iLinkds + "links (excluding Start-Balise)"
            , SmartLogic.getsModuleId(MODULE_NAME));
        }

        return result;
    }

    private TopologyGraph.Edge handleEdgeRailType(ComposedRoute compRoute, int nid_lrbg, int iterations, BigDecimal routeLengthBeingIterated, TopologyGraph.Edge LastEdge, Pair<Route.TrackElementType, ITopological> RoutePart) {
        TopologyGraph.Edge E = (TopologyGraph.Edge) RoutePart.getRight();
        if(LastEdge != null) {
            checkPreviosEdgeForBeginLinkedToDKW(compRoute, nid_lrbg, routeLengthBeingIterated, LastEdge, E);
        }

        ArrayList<Balise> baliseList = Balise.baliseOnEdge.getModel(E);
        if(baliseList != null && !baliseList.isEmpty()) {
            handleBalises(baliseList, nid_lrbg, iterations, compRoute, routeLengthBeingIterated, LastEdge, E);
        }

        LastEdge = E;
        return LastEdge;
    }

    private void handleBalises(ArrayList<Balise> baliseList, int nid_lrbg, int iterations, ComposedRoute CR,
                               BigDecimal routeLengthBeingIterated, TopologyGraph.Edge lastEdge, TopologyGraph.Edge CurrentEdge) {
        ThreadedRepo<Double, Balise> sorted = new ThreadedRepo<>();
        Boolean trainComesFromA = null;
        for(Balise B : baliseList) {
            if(lastEdge != null && iterations < CR.size() - 1) {
                if(trainComesFromA == null) {
                    trainComesFromA = CurrentEdge.A.equals(lastEdge.A) || CurrentEdge.A.equals(lastEdge.B);
                }
                sorted.update(B.getBalisenPositionFromNodeA().doubleValue(), B);

            } else if(lastEdge == null && iterations == CR.size() - 1) {
                // es gibt nur eine Kante sie ist auf beiden Seiten begrenzt
                BigDecimal first = new BigDecimal(CR.getFirstSpot().getIntrinsicCoord() * CurrentEdge.dTopLength);
                BigDecimal last = new BigDecimal(CR.getLastSpot().getIntrinsicCoord() * CurrentEdge.dTopLength);

                if(trainComesFromA == null) {
                    if(first.compareTo(last) < 0) {
                        // First ist zwar vor last aber  der Bezugspunkt ist B
                        // also kommt der Zug aus Knoten B
                        trainComesFromA = !CurrentEdge.B.equals(CurrentEdge.getRefNode());
                    } else {

                        trainComesFromA = CurrentEdge.B.equals(CurrentEdge.getRefNode());
                    }
                }
                BigDecimal BalisenDistance = B.getBalisenPositionFromNodeA();
                if (CurrentEdge.B.equals(CurrentEdge.getRefNode())) {
                    BalisenDistance = new BigDecimal(CurrentEdge.dTopLength).subtract(BalisenDistance);
                }

                if (first.compareTo(last) < 0) {
                    if (first.compareTo(BalisenDistance) < 0 && BalisenDistance.compareTo(last) < 0) {
                        sorted.update(B.getBalisenPositionFromNodeA().doubleValue(), B);
                    }
                } else {
                    if (last.compareTo(BalisenDistance) < 0 && BalisenDistance.compareTo(first) < 0) {
                        sorted.update(B.getBalisenPositionFromNodeA().doubleValue(), B);
                    }
                }
            } else if(lastEdge == null) {
                // erste Kante
                if(trainComesFromA == null) {
                    TopologyGraph.Edge NextEdge = null;
                    for (Pair<Route.TrackElementType, ITopological> RoutePart : CR) {
                        if (RoutePart.getLeft().equals(Route.TrackElementType.RAIL_TYPE)) {
                            TopologyGraph.Edge ScopedEdge = (TopologyGraph.Edge) RoutePart.getRight();
                            if (CurrentEdge.equals(ScopedEdge)) continue;
                            else {
                                NextEdge = ScopedEdge;
                                break;
                            }
                        }
                    }
                    trainComesFromA = CurrentEdge.B.equals(NextEdge.A) ||
                            CurrentEdge.B.equals(NextEdge.B);
                }

            } else {
                // letzte Kante
                if(trainComesFromA == null) trainComesFromA = CurrentEdge.A.equals(lastEdge.A) ||
                        CurrentEdge.A.equals(lastEdge.B);


            }
        }

    }

    private void checkPreviosEdgeForBeginLinkedToDKW(ComposedRoute compRoute, int nid_lrbg, BigDecimal routeLengthBeingIterated, TopologyGraph.Edge LastEdge, TopologyGraph.Edge E) {
        Pair<String, String> keys = new ImmutablePair<>(E.getRefId(), LastEdge.getRefId());
        Waypoint W = compRoute.waypointsBetweentTwoTrackEdges.getModel(keys);
        if(W != null) {
            ArrayList<TrackEdge> edgeKey = compRoute.dkwWaypointRepo.getKeys();
            if(edgeKey != null) {
                for(TrackEdge Edge : edgeKey) {
                    checkForDkwEdge(compRoute, nid_lrbg, routeLengthBeingIterated, W, (TopologyGraph.Edge) Edge, LastEdge);
                }
            }
        }
    }

    private void checkForDkwEdge(ComposedRoute compRoute, int nid_lrbg,
                                 BigDecimal routeLengthBeingIterated, Waypoint W, TopologyGraph.Edge Edge,
                                 TopologyGraph.Edge LastEdge) {
        TopologyGraph.Edge TE = Edge;
        Waypoint HitWaypoint = compRoute.dkwWaypointRepo.getModel(TE);
        if(HitWaypoint != null) {
            if(W.equals(HitWaypoint)) {
                ArrayList<Balise> baliseList = Balise.baliseOnEdge.getModel(TE);
                handleBalises(baliseList, nid_lrbg, -1, compRoute, routeLengthBeingIterated, LastEdge, TE);
            }
        }
    }






}
