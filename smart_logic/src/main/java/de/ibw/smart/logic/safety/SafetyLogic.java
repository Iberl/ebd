package de.ibw.smart.logic.safety;



import de.ibw.feed.Balise;
import de.ibw.history.PositionData;
import de.ibw.history.PositionModul;
import de.ibw.history.data.PositionEnterType;
import de.ibw.history.data.RouteDataSL;
import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.smart.logic.intf.messages.DbdRequestReturnPayload;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.smart.logic.safety.self.tests.SafetyLogicContinousConnectTest;
import de.ibw.tms.intf.cmd.CheckDbdCommand;
import de.ibw.tms.ma.common.NetworkResource;
import de.ibw.tms.ma.occupation.MARequestOccupation;
import de.ibw.tms.ma.occupation.Occupation;
import de.ibw.tms.ma.EoaSectionAdapter;
import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.ma.RbcMaAdapter;
import de.ibw.tms.ma.Route;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import de.ibw.tms.train.model.TrainModel;
import de.ibw.util.DefaultRepo;
import de.ibw.util.ThreadedRepo;
import de.ibw.util.UtilFunction;
import ebd.ConfigHandler;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.rbc_tms.Message;
import ebd.rbc_tms.payload.Payload_14;
import ebd.rbc_tms.util.MA;
import ebd.rbc_tms.util.PositionInfo;
import ebd.rbc_tms.util.TrainInfo;
import org.apache.commons.collections.buffer.CircularFifoBuffer;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.tuple.Pair;

import static de.ibw.tms.ma.occupation.Occupation.BLOCK_Q_SCALE.Q_SCALE_1M;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;


import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



/**
 * Dieses Modul stellt alle Tests dar, die die SmartLogic bei eingehenden Anfragen des TMS unternehmen muss.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-09
 */
public class SafetyLogic {
    /**
     * Modulname der Smart-Safety im Logging
     */
    public static final String SMART_SAFETY = "SMART-SAFETY";
    /**
     * Untermodul der Routenanalyse der Smart-Safety im Logging
     */
    public static final String TRACK_SAFETY = "TRACK-SAFETY";
    /**
     * Untermodul der Selbstuntersuchung der Smart-Logic
     */
    public static final String SELF_CHECK = "SELF-CHECK";
    /**
     * Nachricht, wenn ein noch nicht definiertes Routen-Element besteht.
     */
    public static final String UNKNOWN_TRACK_ELEMENT_GIVEN = "Input Track Element Is Unknowed (Only Edges and Nodes allowed)";
    private static SafetyLogic instance;
    /**
     * Ein Repository, dass durch eine ZugId die Positionsdaten des Zuges speichert.
     */
    public static DefaultRepo<Integer, PositionInfo> lastPositionReport = new DefaultRepo<>();
    /**
     * Ein Repository, dass durch eine ZugId, die Zugdaten zum Zug speichert.
     */
    public static DefaultRepo<Integer, TrainInfo> trainInformation = new DefaultRepo<>();
    /**
     * Ein Repository, dass durch eine ZugId, vergangene Positionsdaten speichert.
     *
     */
    @Deprecated
    public static DefaultRepo<Integer, CircularFifoBuffer> positionHistory  = new DefaultRepo<Integer, CircularFifoBuffer>();
    // when trespass new Trail between new Endnode save meters of passed tracks form balise on
    // if balise is not on current trail we know how far it is away
    // First Integer is Train ID // Second Integer is meter of from balise to nearest point of currentTrack
    /**
     * Ein Repository, das f&uuml;r eine Zug Id, die Meter ab der letzten Balise speichert
     */
    public static DefaultRepo<Integer, Integer> passedMetersSinceLrbg = new DefaultRepo<>();

    private EventBusManager EBM = null;

    /**
     * Ein Singleton, dass Sicherheitslogic der SmartLogic widergibt.
     * @return SmartSafety - Die Sicherheitsanalyse der SmartLogic
     */
    public static SafetyLogic getSmartSafety() {
        if(instance == null) {
            instance = new SafetyLogic();

        }

        return instance;
    }

    private SafetyLogic() {
        if(EBM == null) {
            try {
                EBM = EventBusManager.registerOrGetBus(1, false);
            } catch (IOException e) {
                System.out.println("Event Bus not available");
            }
        }
    }

    /**
     * Blockierte Abschnitte
     * Zugneutrale Abschnitte werden mit Zugnummer -1 blockiert
     */
    private volatile ThreadedRepo<Integer, List<Occupation>> blockList = new ThreadedRepo<>();

    /**
     * Gibt eine Liste der blockierten Elemente dieses Zuges wieder
     * @param iTrainId - nid-engineId des angeforderten Zuges
     * @return List - liste der belegten Abschnitte durch den Zug
     */
    public synchronized List<Occupation> getAllAreaBlockedByOwn(int iTrainId) {
        return blockList.getModel(iTrainId);
    }

    private synchronized List<Occupation> getAllAreaNotBlockedByOwn(int iTrainId) {
        List<Occupation> ownBlocking = blockList.getModel(iTrainId);
        if(ownBlocking == null) ownBlocking = new ArrayList<>();
        Collection<List<Occupation>> all = blockList.getAll();
        List<Occupation> result = Collections.synchronizedList(new ArrayList<>());
        for(List<Occupation> trainset: all) {
            result.addAll(trainset);
        }
        for(Occupation B : ownBlocking) {
            result.remove(B);
        }
        return result;

    }

    /**
     * Methode die untersucht ob auf der angeforderten MA blockierte Streckenabschnitte bestehen.
     * Es kann zum Beispiel durch einen anderen Zug auf der Strecke, blockierte Abschnitte bestehen.
     * @param maRequest - {@link MaRequestWrapper } - Anfragedaten zur MA
     * @param maAdapter {@link RbcMaAdapter } - Daten die zum RBC gesendet werden sollen, wenn die Anfrage ok ist.
     * @param requestedTrackElementList {@link ArrayList} - Eine Liste der Routenelemente die auch nicht blockiert
     *                                                   sein sollten. Das untersucht diese Methode.
     * @return - hat die Route keine blockierten Elemente oder Abschnitte
     */
    public synchronized boolean checkIfRouteIsNonBlocked(MaRequestWrapper maRequest, RbcMaAdapter maAdapter, RouteDataSL requestedTrackElementList) {
        AtomicInteger iSumSectionsLength = new AtomicInteger(0);
        List<Occupation> toBlock = Collections.synchronizedList(new ArrayList<>());
        int iQ_DirLrbg = -1;
        int iQ_DirLength = -1;
        int iQ_Scale = -1;
        int iDistance_LRBG = 0;
        int iNID_LRBG = -1;
        BigDecimal dSumOfWholeMaTrack = new BigDecimal("0");


        Balise B = null;
        PositionInfo PosInfo = null;
        try {
            PosInfo = guardCheckIfPositonReportIsOk(maRequest, maAdapter, iSumSectionsLength);
            dSumOfWholeMaTrack = maAdapter.calcLengthOfSection();

            int iEoaQ_Scale = maAdapter.q_scale;
            if(requestedTrackElementList.size() < 2) {
                throw new InvalidParameterException(
                        "To Less Elements requested, there must be at least one End and one Start Track Element");
            }

            iQ_DirLrbg = PosInfo.q_dirlrbg;
            iQ_DirLength = PosInfo.q_length;
            iQ_Scale = PosInfo.q_scale;
            iDistance_LRBG = PosInfo.d_lrbg;
            iNID_LRBG = PosInfo.nid_lrbg;


            AtomicInteger distanceFromTrainToNextNode = new AtomicInteger(0);
            int iRequestSize = requestedTrackElementList.size();
            Pair<Route.TrackElementType, ITopological> StartElement = requestedTrackElementList.get(0);
            Pair<Route.TrackElementType, ITopological> EndElement = requestedTrackElementList.get(iRequestSize -1);




                for(int i = 1; i < requestedTrackElementList.size() - 1; i++) {
                    // erstes und letztes Element wird nicht mit i referenziet letztes Element in letzter iteration
                    // => i + 1
                    Pair<Route.TrackElementType, ITopological> Element1 = requestedTrackElementList.get(i);
                    Pair<Route.TrackElementType, ITopological> Element2 = requestedTrackElementList.get(i + 1);
                    // Waypoint between start and end have to be crossover nodes, ui is in this manner implemented
                    if(!Element1.getKey().equals(Route.TrackElementType.CROSSOVER_TYPE)) return false;
                    if(!Element2.equals(EndElement)) {
                        if (!Element2.getKey().equals(Route.TrackElementType.CROSSOVER_TYPE)) return false;

                    } else {
                        // Element2 ist End Element aber Element1 ist eine Weiche
                        // also muss die Weiche als Blockiert eingetragen werden
                        TopologyGraph.Node N = (TopologyGraph.Node) Element1.getValue();


                        break;
                    }
                    TopologyGraph.Node N1 = (TopologyGraph.Node) Element1.getValue();
                    TopologyGraph.Node N2 = (TopologyGraph.Node) Element2.getValue();
                    TopologyGraph.Edge E = TopologyGraph.twoTopPointBelongsToEdgeRepo.
                            getModel(N1.TopNodeId).getModel(N2.TopNodeId);
                    toBlock.add(new MARequestOccupation(E, Q_SCALE_1M, 0 , Q_SCALE_1M, (int) Math.floor(E.dTopLength)+ 1));
                    int iSumDistance = distanceFromTrainToNextNode.get();
                    iSumDistance += Math.floor(E.dTopLength);
                    distanceFromTrainToNextNode.set(iSumDistance);
                }
                if(EndElement.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {
                    if (StartElement.getValue().equals(EndElement.getValue())) {
                        // Es handelt sich um nur ein Gleisabschnitt ohne Topologischen Knoten
                        // Dieser wird im Start-Blocked-Area gespeichert

                    } else {

                        TopologyGraph.Node N = (TopologyGraph.Node) requestedTrackElementList.
                                get(requestedTrackElementList.size() -2).getRight();

                        boolean bMovesToB;
                        double dDistanceFromRecentNode = iSumSectionsLength.get() - distanceFromTrainToNextNode.get();
                        TopologyGraph.Edge Ed = (TopologyGraph.Edge) EndElement.getValue();

                        // N war der Knoten der vorher zur Kante führte somit gilt:
                        // der Ausdruck wird true, weil A der Ursprung war
                        // false wenn B der Urspurng war
                        bMovesToB = Ed.A.equals(N);
                        if (bMovesToB) {

                            toBlock.add(new MARequestOccupation(Ed, Q_SCALE_1M, 0,
                                    Q_SCALE_1M, (int) dDistanceFromRecentNode));
                        } else {
                            toBlock.add(new MARequestOccupation(Ed, Q_SCALE_1M, (int) dDistanceFromRecentNode, Q_SCALE_1M,
                                    (int) Math.ceil(Ed.dTopLength)));
                        }
                    }
                }
                // TODO PositionData usage
                toBlock = calcCrossoverSignals(toBlock);

                List<Occupation> occupations = getAllAreaNotBlockedByOwn(maRequest.Tm.iTrainId);
                for(Occupation ThisArea : toBlock)
                for(Occupation OtherArea: occupations) {
                    if(ThisArea.compareIfIntersection(OtherArea)) {

                        return false;
                    }

                }




            blockList.update(maRequest.Tm.iTrainId, toBlock);




            // block Elements as successful
            return true;
        } catch (Exception E) {
            E.printStackTrace();
            return false;
        }

    }

    /**
     * Berechnet Grenzzeichen, falls ein Zug sich im Grenzzeichen befindet.
     * @param toBlock - alle bisherigen Blockaden
     */
    private ArrayList<Occupation> calcCrossoverSignals(List<Occupation> toBlock) {
        ArrayList<Occupation> crossoverAreas = new ArrayList<>(toBlock);
        for(Occupation BA : toBlock) {
            ArrayList<Occupation> limitAreas = BA.getListOfEdgeLimits();
            for(Occupation L_BA : limitAreas) {
                if(!crossoverAreas.contains(L_BA)) crossoverAreas.add(L_BA);
            }
        }
        return crossoverAreas;
    }
/*
    private BlockedArea createStartBlocking(Pair<Route.TrackElementType, TrackElement> startElement, TrainModel tm) {
        if(startElement.getLeft().equals(Route.TrackElementType.CROSSOVER_TYPE)) {
            TopologyGraph.Node StartNode = (TopologyGraph.Node) startElement.getRight();
            return new BlockedArea(StartNode, StartNode.TopNodeId);
        } else {
            BlockedArea StartEdgeBlock = null;
            TopologyGraph.Edge StartEdge = (TopologyGraph.Edge) startElement.getRight();
            StartEdgeBlock = new BlockedArea(StartEdge,)
        }

    }
*/

    /**
     * @deprecated
     * @param dSumOfWholeMaTrack
     * @param startElement
     * @param tm
     * @param iQ_dirLength
     * @param iQ_scale
     * @param iDistance_lrbg
     * @param iNID_lrbg
     * @param iQ_DirLrbg
     * @param endElement
     * @param iEoaQ_Scale
     * @param iSumSectionsLength
     * @param distanceFromTrainToNextNode
     * @return
     */
    private Occupation handleStartElement(BigDecimal dSumOfWholeMaTrack, Pair startElement, TrainModel tm, int iQ_dirLength, int iQ_scale, int iDistance_lrbg, int iNID_lrbg, int iQ_DirLrbg, Pair endElement, int iEoaQ_Scale, AtomicInteger iSumSectionsLength, AtomicInteger distanceFromTrainToNextNode) {
        throw new NotImplementedException("deprecated");
        /*
        int iTrainId = tm.iTrainId;


        Occupation StartArea = null;
        Route.TrackElementType TET = (Route.TrackElementType) startElement.getKey();
        if (TET.equals(Route.TrackElementType.CROSSOVER_TYPE)) {
            TopologyGraph.Node N = (TopologyGraph.Node) startElement.getValue();
            StartArea = new Occupation(N, N.TopNodeId);
            return StartArea;
        } else if (TET.equals(Route.TrackElementType.RAIL_TYPE)) {
            //TODO Check if Train is standing on trail still
            distanceFromTrainToNextNode.set((int) tm.getdDistanceToNodeRunningTo());
            iSumSectionsLength.set((int) tm.getdDistanceToNodeRunningTo());
            PositioningNetElement StartEL = (PositioningNetElement) startElement.getValue();
            double distanceToA1 = 0;
            double distanceToA2 = 0;
            Balise B = Balise.baliseByNid_bg.getModel(iNID_lrbg);

            double dDistanceBaliseFromA = B.getBalisenPositionFromNodeA().doubleValue();

            //boolean bMovesToB = ETCSVariables.Q_DIRTRAIN_NOMINAL == iQ_DirTrain;
            String sIdOfEdgeOfTrain = tm.getEdgeTrainStandsOn().sId;
            String sIdStartEdgeOfMa = ((TopologyGraph.Edge)startElement.getValue()).sId;
            TopologyGraph.Edge StartEdge = PlanData.topGraph.EdgeRepo.get(sIdOfEdgeOfTrain);
            boolean bMovesToB = calcIsMovingToB(sIdOfEdgeOfTrain, tm);
            if (!sIdOfEdgeOfTrain.equals(sIdStartEdgeOfMa)) {

                // Train stands no more on rail beeing requested
                // reject MA
                return null;
            }
            // endelement is in pair // StartEl is unpacked
            if (endElement.getValue().equals(StartEL)) {
                // MA endet auf dem Start element



                if (bMovesToB) {
                    // Train moves to B Point
                    StartArea = handleMovingToB(tm, iQ_scale, dSumOfWholeMaTrack, iTrainId, (TopologyGraph.Edge) StartEL, dDistanceBaliseFromA, StartEdge);
                } else {
                    // Train moves to A Point

                    StartArea = handleMoveToA(tm, dSumOfWholeMaTrack, (TopologyGraph.Edge) StartEL);
                }

            } else {
                double dCurrentTrackLength = ((TopologyGraph.Edge) StartEL).dTopLength;
                if (bMovesToB) {
                    distanceToA1 = dCurrentTrackLength - tm.getdDistanceToNodeRunningTo() - tm.length;
                    distanceToA2 = dCurrentTrackLength;
                    if(distanceToA1 < 0) distanceToA1 = 0;

                } else {

                    distanceToA1 = 0;
                    distanceToA2 = tm.getdDistanceToNodeRunningTo() + tm.length;
                    if(distanceToA2 > dCurrentTrackLength) distanceToA2 = dCurrentTrackLength;
                }
                distanceFromTrainToNextNode.set((int) Math.floor(distanceToA2 - distanceToA1) + 1);
                StartArea = new Occupation((TopologyGraph.Edge) StartEL, Q_SCALE_1M, (int) Math.floor(distanceToA1),
                        Q_SCALE_1M, (int) Math.ceil(distanceToA2));
            }
        }
        List<Occupation> blockList = getAllAreaNotBlockedByOwn(iTrainId);
        for(Occupation OtherArea: blockList) {
            if(StartArea.compareIfIntersection(OtherArea)) {
                // has intersection so SL reject
                return null;
            }
        }


        return StartArea;
        */

    }


    /**
     * @deprecated
     * @param tm
     * @param dMaTrackLength
     * @param startEL
     * @return
     */
    private Occupation handleMoveToA(TrainModel tm, BigDecimal dMaTrackLength, TopologyGraph.Edge startEL) {
        throw new NotImplementedException("deprecated");
        /*
        double distanceToA2;
        double distanceToA1;
        Occupation StartArea;
        distanceToA2 = tm.getdDistanceToNodeRunningTo();
        distanceToA1 = distanceToA2 - dMaTrackLength.doubleValue();
        if(distanceToA1 < 0) distanceToA1 = 0;

        distanceToA2 = distanceToA2 + tm.length;
        if(distanceToA2 > startEL.dTopLength) distanceToA2 = startEL.dTopLength;

        StartArea = new Occupation(startEL, Q_SCALE_1M, (int) Math.floor(distanceToA1),
                Q_SCALE_1M, (int) Math.ceil(distanceToA2));
        return StartArea;
        */

    }

    /**
     * @deprecated
     */
    private Occupation handleMovingToB(TrainModel tm, int iQ_scale, BigDecimal dMaTrackLength, int iTrainId, TopologyGraph.Edge startEL, double dDistanceBaliseFromA, TopologyGraph.Edge startEdge) {
        throw new NotImplementedException("deprecated");
        /*
        double distanceToA2;
        double distanceToA1;
        Occupation StartArea;
        //double dTrainFront = calcTrainFront(iTrainId, iQ_scale, iMaTrackLength, dDistanceBaliseFromA, true);
        distanceToA1 = startEdge.dTopLength - tm.getdDistanceToNodeRunningTo();
        distanceToA2 = distanceToA1 + dMaTrackLength.doubleValue();

        distanceToA1 = distanceToA1 - tm.length;
        if(distanceToA1 < 0) distanceToA1 = 0;

        StartArea = new Occupation(startEL, Q_SCALE_1M, (int) Math.floor(distanceToA1),
                Q_SCALE_1M, (int) Math.ceil(distanceToA2));
        return StartArea;

         */
    }

    /**
     * @deprecated
     * @param sIdOfEdgeOfTrain
     * @param tm
     * @return
     */
    private boolean calcIsMovingToB(String sIdOfEdgeOfTrain, TrainModel tm) {
        throw new NotImplementedException("deprecated");
        /*
        TopologyGraph.Edge E = PlanData.topGraph.EdgeRepo.get(sIdOfEdgeOfTrain);
        TopologyGraph.Node N = TopologyGraph.NodeRepo.get(tm.getsNodeIdTrainRunningTo());
        if(E == null) throw new InvalidParameterException("Edge of Train not found");
        if(E.A.equals(N)) return false;
        if(E.B.equals(N)) return true;
        throw new InvalidParameterException("Edge has not Node, which train running to.");

         */
    }

    private double calcTrainFront(int iTrainId, int iQ_scale, int iDistance_lrbg, double dDistanceBaliseFromA, boolean bMovesToB) {
        int iMetersOnPassedTracks = 0;
        Integer iPassedMetersSinceLrbg = passedMetersSinceLrbg.getModel(iTrainId);
        if(iPassedMetersSinceLrbg != null) {
            iMetersOnPassedTracks = iPassedMetersSinceLrbg;
        }

        if(bMovesToB) return dDistanceBaliseFromA + (iDistance_lrbg * Math.pow(10, iQ_scale) / 10.0d -iMetersOnPassedTracks);
        else return dDistanceBaliseFromA - (iDistance_lrbg * Math.pow(10, iQ_scale) / 10.0d - iMetersOnPassedTracks);
    }

    private synchronized PositionInfo guardCheckIfPositonReportIsOk(MaRequestWrapper maRequest, RbcMaAdapter maAdapter, AtomicInteger iSumSectionsLength) throws Exception {
        int iTrainId;
        int iNID_LRBG;
        Balise B;
        int iQ_DirTrain;
        int iQ_DirLength;

        if(maRequest == null) {
            throw new InvalidParameterException("Ma Request is null");
        }
        if(maRequest.Tm == null) throw new InvalidParameterException("Trainmodel of Request is null");
        if(maRequest.Tm.iTrainId < 0) throw new InvalidParameterException("Train Id is negative");
        if(maAdapter == null) throw new InvalidParameterException("Ma Adapter Util is null");
        if(maAdapter.eoa == null) throw new InvalidParameterException("Eoa of Ma is null");
        if(maAdapter.eoa.sections.isEmpty()) throw new InvalidParameterException("Eoa Sections are empty");


        iTrainId = maRequest.Tm.iTrainId;
        // check if some elements blocked
        List<EoaSectionAdapter> sectionlist = maAdapter.eoa.sections;
        for(EoaSectionAdapter ES : sectionlist) {
            if(ES.l_section < 0) throw new InvalidParameterException("Length of Eoa Section is negative");
            int iSum = iSumSectionsLength.get();
            iSum += ES.l_section;
            iSumSectionsLength.set(iSum);
        }
        if(iSumSectionsLength.get() == 0) throw new InvalidParameterException("Sum of EOA-Sections is 0 meter");
        PositionInfo CurrentPosition = lastPositionReport.getModel(iTrainId);
        if(CurrentPosition == null) {
            throw new Exception("No Position Info for Train");
        }
        iNID_LRBG = CurrentPosition.nid_lrbg;
        B = Balise.baliseByNid_bg.getModel(iNID_LRBG);
        if(B == null) {

            throw new InvalidParameterException("Balse requested not found");
        }

        iQ_DirLength = CurrentPosition.q_length;
        if(!checkQ_Length(iQ_DirLength)) {

            throw new InvalidParameterException("No Train Length information available");
        }




        return CurrentPosition;
    }


    @Deprecated
    private synchronized void blockLastPositionReports(int iTrainId) {
        throw new NotImplementedException("deprecated");
        /*
        List<Occupation> blockedAreasById = blockList.getModel(iTrainId);
        CircularFifoBuffer lastPositions = positionHistory.getModel(iTrainId);
        if(lastPositions == null) return;
        List<PositionInfo> lastInfo = new ArrayList<PositionInfo>(lastPositions).subList(0,10);
        if(blockedAreasById == null) {
            blockedAreasById = new ArrayList<>();
        }
        for(PositionInfo ToBlockPosition: lastInfo) {
            int nid_lrbg = ToBlockPosition.nid_lrbg;
            Balise B = Balise.baliseByNid_bg.getModel(nid_lrbg);
            if(B == null) continue;
            CTOPKante BaliseEdge = B.getTopPositionOfDataPoint();
            TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(BaliseEdge.getIdentitaet().getWert());
            Occupation BA = new Occupation(E, Q_SCALE_1M, 0, Q_SCALE_1M, 0);
            blockedAreasById.add(BA);
        }
        blockList.update(iTrainId, blockedAreasById);

         */
    }

    /**
     * Diese Methode untersucht ob alle Routenelemente durchwegs verbunden sind.
     * @param maRequest - {@link MaRequestWrapper} - Anfragedatend des TMS
     * @param requestedTrackElementList - {@link ArrayList} - Eine Liste der Routenelemente die verbunden sein sollten.
     * @return boolean - ist Route durchwegs verbunden
     */
    public synchronized boolean checkIfRouteIsContinuousConnected(MaRequestWrapper maRequest, RouteDataSL requestedTrackElementList) {
        if(requestedTrackElementList == null) {
            throw new NullPointerException("Track List is null");
        } else if (requestedTrackElementList.isEmpty()) {
            throw new InvalidParameterException("Track List is empty");
        } else if (requestedTrackElementList.size() < 2) {
            throw new InvalidParameterException("Route with only one Track Element is not supported. (2 is min)");
        } else if(routeHasNullValue(requestedTrackElementList)) {
            throw new InvalidParameterException("Route must not have null value content");
        }
        Pair<Route.TrackElementType, ITopological> FirstElement = requestedTrackElementList.get(0);
        Pair<Route.TrackElementType, ITopological> LastElement = requestedTrackElementList.get(requestedTrackElementList.size() -1);
        try {
            if (requestedTrackElementList.size() == 2) {
                if (bothElementsSameType(FirstElement, LastElement, Route.TrackElementType.RAIL_TYPE)) {
                    return FirstElement.getRight().equals(LastElement.getRight());
                } else if (bothElementsSameType(FirstElement, LastElement, Route.TrackElementType.CROSSOVER_TYPE)) {
                    TopologyGraph.Node NodeA = null;
                    TopologyGraph.Node NodeB = null;
                    try {
                        NodeA = (TopologyGraph.Node) FirstElement.getRight();
                    } catch (Exception Ex) {
                        handleWrongElements(FirstElement, false);
                    }
                    try {
                        NodeB = (TopologyGraph.Node) LastElement.getRight();
                    } catch (Exception Ex) {
                        handleWrongElements(LastElement, false);
                    }
                    return checkIfNodesConnected(NodeA, NodeB);
                } else {
                    TopologyGraph.Node N  = null;
                    TopologyGraph.Edge E = null;
                    // two elements are node to edge or edge to node
                    if(FirstElement.getLeft().equals(Route.TrackElementType.RAIL_TYPE)) {
                        return handleDifferentialElements(FirstElement, LastElement, N, E);

                    } else {
                        return handleDifferentialElements(LastElement, FirstElement, N, E);
                    }

                }
            } else {
                int iLastIndex = requestedTrackElementList.size() - 1;
                for (int i = 0; i < requestedTrackElementList.size(); i++) {
                    if (i == 0) {
                        // only start and end may be rail type index 1 cannot be rail type
                        if (firstOrLastElmentIsNOTconnectedWithMiddle(requestedTrackElementList.get(1), FirstElement))
                            return false;
                        else continue;
                    }
                    if (i + 1 == iLastIndex) {
                        boolean lastElementIsNotConnected = firstOrLastElmentIsNOTconnectedWithMiddle(requestedTrackElementList.get(i), LastElement);
                        return !lastElementIsNotConnected;
                    } else {
                        if (bothElementsSameType(requestedTrackElementList.get(i), requestedTrackElementList.get(i + 1), Route.TrackElementType.CROSSOVER_TYPE)) {
                            TopologyGraph.Node NodeA = null;
                            try {
                                NodeA = (TopologyGraph.Node) requestedTrackElementList.get(i).getRight();
                            } catch (Exception Ex) {
                                handleWrongElements(requestedTrackElementList.get(i), false);
                            }
                            TopologyGraph.Node NodeB = null;
                            try {
                                NodeB = (TopologyGraph.Node) requestedTrackElementList.get(i + 1).getRight();
                            } catch (Exception Ex) {
                                handleWrongElements(requestedTrackElementList.get(i + 1), false);
                            }
                            if (!checkIfNodesConnected(NodeA, NodeB)) return false;
                        } else return false; // middle elements has to be CrossoverNodes


                    }
                }
            }
        } catch (InvalidParameterException IVP) {
            String sMessage = IVP.getMessage();
            EBM.log(sMessage, TRACK_SAFETY );
            return false;
        }


        return true;
    }

    private boolean handleDifferentialElements(Pair<Route.TrackElementType, ITopological> edgeElement, Pair<Route.TrackElementType, ITopological> nodeElement, TopologyGraph.Node N, TopologyGraph.Edge E) {
        try {
            N = (TopologyGraph.Node) nodeElement.getRight();

        } catch (Exception Ex) {
            handleWrongElements(nodeElement, false);
        }
        try {
            E = (TopologyGraph.Edge) edgeElement.getRight();

        } catch (Exception Ex) {
            handleWrongElements(edgeElement, true);
        }
        return E.A.equals(N) || E.B.equals(N);
    }

    private boolean firstOrLastElmentIsNOTconnectedWithMiddle(Pair<Route.TrackElementType, ITopological> middleElement, Pair<Route.TrackElementType, ITopological> firstOrLastElement) throws InvalidParameterException {
        if(bothElementsSameType(firstOrLastElement, middleElement, Route.TrackElementType.RAIL_TYPE))
            return true;

        if(bothElementsSameType(firstOrLastElement, middleElement, Route.TrackElementType.CROSSOVER_TYPE)) {
            TopologyGraph.Node NodeA = null;
            try {
                NodeA = (TopologyGraph.Node) firstOrLastElement.getRight();
            } catch (Exception Ex) {
                handleWrongElements(firstOrLastElement, false);
            }
            TopologyGraph.Node NodeB = null;
            try {
                NodeB = (TopologyGraph.Node) middleElement.getRight();
            } catch (Exception Ex) {
                handleWrongElements(middleElement, false);
            }
            return !checkIfNodesConnected(NodeA, NodeB);
        } else {
            TopologyGraph.Edge E = null;
            TopologyGraph.Node N = null;
            try {
                E = (TopologyGraph.Edge) firstOrLastElement.getRight();
            } catch (Exception Ex) {
                handleWrongElements(firstOrLastElement, true);
            }
            try {
                N = (TopologyGraph.Node) middleElement.getRight();
            } catch (Exception Ex) {
                handleWrongElements(middleElement, false);
            }


            if(!checkIfEdgeHasNode(E,N)) return true;
        }
        return false;
    }

    private void handleWrongElements(Pair<Route.TrackElementType, ITopological> WrongTypeElement, boolean shallBeEdge) throws InvalidParameterException {
        String sId;
        if(shallBeEdge) {
            sId = WrongTypeElement.getRight() instanceof TopologyGraph.Node ? ((TopologyGraph.Node) WrongTypeElement.getRight()).TopNodeId : null;
        } else {
            sId = WrongTypeElement.getRight() instanceof TopologyGraph.Edge ? ((TopologyGraph.Edge) WrongTypeElement.getRight()).sId : null;
        }
        if(sId == null) throw new InvalidParameterException(UNKNOWN_TRACK_ELEMENT_GIVEN);

        else {
            String sMessage = null;
            if(shallBeEdge) {
                sMessage = "Element with id " + sId + " shall be Edge but is Node-Type";
            }  else {
                sMessage = "Element with id " + sId + " shall be Node but is Edge-Type";
            }
            throw new InvalidParameterException(sMessage);
        }
    }

    private boolean checkIfEdgeHasNode(TopologyGraph.Edge e, TopologyGraph.Node n) {
        return e.B.equals(n) || e.A.equals(n);
    }

    private boolean checkIfNodesConnected(TopologyGraph.Node nodeA, TopologyGraph.Node nodeB) {
        for(TopologyGraph.Edge E : nodeA.inEdges) {
            // Edge connects start with end point
            if(E.A.equals(nodeB) || E.B.equals(nodeB)) return true;
        }
        for(TopologyGraph.Edge E : nodeA.outEdges) {
            // Edge connects start with end point
            if(E.A.equals(nodeB) || E.B.equals(nodeB)) return true;
        }
        return false;
    }

    /**
     * checking for beeing smae type
     * @param elementA
     * @param elementB
     * @param type - type beeing same
     * @return
     */
    private boolean bothElementsSameType(Pair<Route.TrackElementType, ITopological> elementA,
                                         Pair<Route.TrackElementType, ITopological> elementB, Route.TrackElementType type) {
        return elementA.getLeft().equals(type) && elementB.getLeft().equals(type);
    }


    private boolean routeHasNullValue(RouteDataSL requestedTrackElementList) {
        for(Pair<Route.TrackElementType, ITopological> RouteElement: requestedTrackElementList) {
            if(RouteElement.getLeft() == null || RouteElement.getRight() == null) return true;
        }
        return false;
    }

    /**
     * Noch Nicht implementiert
     * Untersucht ob alle Status der Streckenelemente in Ordnung sind.
     * @param maRequest - {@link MaRequestWrapper } - Anfragedaten zur MA
     * @param requestedTrackElementList - {@link ArrayList} - Eine Liste der Routenelemente die Statusuntersuchung erfordern.
     * @return boolean
     */
    public synchronized boolean checkIfRouteElementStatusIsCorrect(MaRequestWrapper maRequest, RouteDataSL requestedTrackElementList) {
        //DBDClient dbdclient = new DBDClient();
        return true;
    }


    /**
     * Untersucht ob der PositionReport valide ist
     * @param PositionReport {@link Message} - RBC - PositionReport
     * @return boolean - ist Positionsangabe valide
     */
    public synchronized boolean handlePositionReport(Message<Payload_14> PositionReport) {
        try {
            int iTrainId;
            int iNidLrbg;
            int iQ_DirTrain;
            int iQ_Length;
            int iQ_Scale;

            Payload_14 P = PositionReport.getPayload();
            iTrainId = P.trainInfo.nid_engine;
            PositionInfo PosInf = P.positionInfo;
            iQ_DirTrain = PosInf.q_dirtrain;
            iQ_Length = PosInf.q_length;
            trainInformation.update(iTrainId, P.trainInfo);
            lastPositionReport.update(iTrainId, PosInf);
            new Thread(() -> handlePositionHistory(iTrainId, PosInf, PositionReport.getHeader())).start();
            unlockPassedElements(iTrainId, PosInf);
            iNidLrbg = PosInf.nid_lrbg;
            iQ_Scale = PosInf.q_scale;
            if(true != checkNidBg(iNidLrbg)) {
                throw new InvalidParameterException("Balise nid lrbg not found");
            }
            if(true != checkQ_Scale(iQ_Scale)) {
                throw new InvalidParameterException("Not Valid Q-Scale");
            }


            if(true != checkQ_DirTrain(iQ_DirTrain)) {
                throw new InvalidParameterException("Q_DirTrain invalid");
            }
            if(true != checkQ_Length(iQ_Length)) {
                throw new InvalidParameterException("Q_Length invalid");
            }

            return true;
        } catch(Exception E) {
            E.printStackTrace();
            return false;

        }
    }

    private void unlockPassedElements(int iTrainId, PositionInfo posInf) {
        double dDistanceToLrbg = posInf.d_lrbg;
        dDistanceToLrbg = dDistanceToLrbg * Math.pow(10.0d, posInf.q_scale) / 10.0d;
        passedMetersSinceLrbg.update(iTrainId, (int) dDistanceToLrbg);


    }

    private boolean checkQ_Scale(int iQ_scale) {
        return iQ_scale == ETCSVariables.Q_SCALE_1M || iQ_scale == ETCSVariables.Q_SCALE_10CM ||
                iQ_scale == ETCSVariables.Q_SCALE_10M;
    }

    private boolean checkNidBg(int iNidLrbg) {
        return Balise.baliseByNid_bg.getModel(iNidLrbg) != null;
    }

    private void handlePositionHistory(int iTrainId, PositionInfo posInf, Message.Header header) {
        PositionData PD = new PositionData(header.getTimestamp(), System.currentTimeMillis(),
                iTrainId, posInf);
        BigDecimal trainLength = UtilFunction.getTrainLength(posInf);



        PositionModul.getInstance().addPositionData(PD, PositionEnterType.ENTERED_VIA_POSITION_REPORT);
    }

    private boolean checkQ_Length(int iQ_Length) {
        return ETCSVariables.Q_LENGTH_CONFIRMED_BY_DRIVER == iQ_Length ||
                ETCSVariables.Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE == iQ_Length;
    }

    private boolean checkQ_DirTrain(int iQ_dirTrain) {
        return ETCSVariables.Q_DIRTRAIN_NOMINAL == iQ_dirTrain || ETCSVariables.Q_DIRTRAIN_REVERSE == iQ_dirTrain;
    }

    private synchronized boolean smartLogicWorking() {
        final LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectPackage("de.ibw.smart.logic.safety.self.tests"),
                        selectClass(SafetyLogicContinousConnectTest.class)
                )
                .build();

        final Launcher launcher = LauncherFactory.create();

        final boolean pathContainsTests = launcher.discover(request).containsTests();
        if (!pathContainsTests) {
            EBM.log("Path de.ibw.smart.logic.safety is invalid or not having tests", SMART_SAFETY);

        }

        final SummaryGeneratingListener listener = new SummaryGeneratingListener();

        launcher.execute(request, listener);

        final TestExecutionSummary summary = listener.getSummary();


        final long containersFoundCount = summary.getContainersFoundCount();
        EBM.log("containers Found Count  " + containersFoundCount, SELF_CHECK);


        final long containersSkippedCount = summary.getContainersSkippedCount();
        EBM.log("containers Skipped Count  " + containersSkippedCount, SELF_CHECK);

        final long testsFoundCount = summary.getTestsFoundCount();
        EBM.log("tests Found Count  " + testsFoundCount, SELF_CHECK);


        final long testsSkippedCount = summary.getTestsSkippedCount();
        EBM.log("tests Skipped Count  " + testsSkippedCount, SELF_CHECK);
        StringWriter resultWriter = new StringWriter();

        summary.printFailuresTo(new PrintWriter(resultWriter));

        EBM.log("Test Results " + resultWriter.toString(), SELF_CHECK);


        return summary.getTestsFailedCount() == 0L;
    }

    /**
     * Untersucht ob die SmartLogic richtig funktioniert
     * @param maAdapter {@link RbcMaAdapter } - Daten die zum RBC gesendet werden sollen, wenn die Anfrage ok ist.
     * @return boolean - funktioniert SL
     */
    public synchronized boolean slSelfCheck(RbcMaAdapter maAdapter) {

        if(smartLogicWorking()){
            EBM.log("Self Test was successful. No Errors.", SMART_SAFETY);
            return true;
        }
        EBM.log("Self Test was not successful.", SMART_SAFETY);

        return false;
    }

    /**
     * Noch nicht implementiert
     * @param tms_id
     * @return
     */
    public synchronized boolean verifyTms(String tms_id) {
        return true;
    }

    /**
     * Noch nicht implementiert
     * @param maRequest
     * @param ma
     * @return
     */
    public synchronized boolean verifyTrainID(MaRequestWrapper maRequest, MA ma) {
        //return maRequest.Tm.iTrainId > 0;
        return true;
    }

    /**
     * Noch nicht implementiert
     * @param maRequest
     * @return
     */
    public synchronized boolean checkIfTrainStatusRequestIsFresh(MaRequestWrapper maRequest) {
        // check if Position Report is new 60S
        // Static var PositionReportTimeout

        return true;
    }

    /**
     * Noch nicht implementiert
     * Danger Zones must be retrievable to calculate routes
     * @return
     */
    public synchronized boolean dangerZonesAreReceivable() {
        return true;
    }
    /**
     * Noch nicht implementiert
     */
    public synchronized boolean checkTrainForRouteCriteria() {
        return true;
    }
    /**
     * Noch nicht implementiert
     */
    public synchronized void handleFlankProtection(MaRequestWrapper maRequest, RouteDataSL requestedTrackElementList) {
    }
    /**
     * Noch nicht implementiert
     */
    public synchronized boolean checkSSP(MA ma) {
        return true;
    }

    /**
     * Noch nicht implementiert
     * @param requestedTrackElementList
     */
    public synchronized void unlockElementsNotUsed(RouteDataSL requestedTrackElementList) {

    }

    public static void main(String[] args) {
        SafetyLogic safety = SafetyLogic.getSmartSafety();
        safety.slSelfCheck(null);
    }

    /**
     * Methode zum Testen gegen dieses Modul.
     * Es l&ouml;scht s&auml;mtliche Eintr&auml;ge
     *
     * NUR F&Uuml;r TESTZWEICKE.
     * Kann nur in Testkonfiguration aufgerufen werden.
     */
    public void resetAllBlockings() {
        if(ConfigHandler.getInstance().isInTestMode) {
            EBM.log("CHECK Blockings Dumped from memory. ONLY FOR TESTS ALLOWED.", TRACK_SAFETY );
            this.blockList = new ThreadedRepo<>();
        } else {
            EBM.log("Reset only allowed in Test Mode", TRACK_SAFETY );
        }

    }


    /**
     * Check ob eine Weiche in der Blockierten Liste vorhanden ist.
     * @param cdc
     */
    public void checkIfDbdElementIsNotBlocked(CheckDbdCommand cdc) {
        String checkSid = cdc.sId;
        for(List<Occupation> l :this.blockList.getAll()) {
            for(Occupation BA : l) {
                if(BA.isSidBlocked(checkSid)) {
                    sendResponseDbdCommandToTms(false, cdc.sCrossoverEbdName, DbdRequestReturnPayload.BLOCK_FAIL_REASON);
                    return;
                }
            }
        }
        sendResponseDbdCommandToTms(true, cdc.sCrossoverEbdName,null);
    }

    private void sendResponseDbdCommandToTms(boolean isSuccess, String sCrossoverEbdName, String sFailReason) {
        long lPrio = ConfigHandler.getInstance().lCheckDbdReturn;
        DbdRequestReturnPayload  DbdPayload = new DbdRequestReturnPayload(sCrossoverEbdName);
        if(isSuccess) DbdPayload.setDbdSuccessfull();
        else DbdPayload.setErrorState(sFailReason);
        SmartServerMessage BlockMessage = new SmartServerMessage(DbdPayload.parseToJson(), lPrio);
        BlockMessage.setbIsFromSL(true);
        try {
            SmartLogic.outputQueue.put(BlockMessage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
