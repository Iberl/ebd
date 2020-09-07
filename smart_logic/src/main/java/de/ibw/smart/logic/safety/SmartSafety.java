package de.ibw.smart.logic.safety;



import de.ibw.feed.Balise;
import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.datatypes.BlockedArea;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.smart.logic.intf.messages.DbdRequestReturnPayload;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.smart.logic.safety.self.tests.SmartSafetyContinousConnectTest;
import de.ibw.tms.intf.cmd.CheckDbdCommand;
import de.ibw.tms.ma.EoaSectionAdapter;
import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.ma.RbcMaAdapter;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.train.model.TrainModel;
import de.ibw.util.DefaultRepo;
import de.ibw.util.ThreadedRepo;
import ebd.ConfigHandler;
import ebd.rbc_tms.Message;
import ebd.rbc_tms.payload.Payload_14;
import ebd.rbc_tms.util.ETCSVariables;
import ebd.rbc_tms.util.MA;
import ebd.rbc_tms.util.PositionInfo;
import ebd.rbc_tms.util.TrainInfo;
import info.dornbach.dbdclient.DBDClient;
import org.apache.commons.beanutils.locale.BaseLocaleConverter;
import org.apache.commons.collections.buffer.CircularFifoBuffer;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CDatenpunkt;
import plan_pro.modell.geodaten._1_9_0.CTOPKante;

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

import static de.ibw.smart.logic.datatypes.BlockedArea.BLOCK_Q_SCALE.Q_SCALE_1M;


/**
 * Dieses Modul stellt alle Tests dar, die die SmartLogic bei eingehenden Anfragen des TMS unternehmen muss.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-09-02
 */
public class SmartSafety {
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
    private static SmartSafety instance;
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
     */
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
    public static SmartSafety getSmartSafety() {
        if(instance == null) {
            instance = new SmartSafety();

        }

        return instance;
    }

    private SmartSafety() {
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
    private volatile ThreadedRepo<Integer, List<BlockedArea>> blockList = new ThreadedRepo<>();



    private synchronized List<BlockedArea> getAllAreaNotBlockedByOwn(int iTrainId) {
        List<BlockedArea> ownBlocking = blockList.getModel(iTrainId);
        if(ownBlocking == null) ownBlocking = new ArrayList<>();
        Collection<List<BlockedArea>> all = blockList.getAll();
        List<BlockedArea> result = Collections.synchronizedList(new ArrayList<>());
        for(List<BlockedArea> trainset: all) {
            result.addAll(trainset);
        }
        for(BlockedArea B : ownBlocking) {
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
    public synchronized boolean checkIfRouteIsNonBlocked(MaRequestWrapper maRequest, RbcMaAdapter maAdapter, ArrayList<Pair<Route.TrackElementType, TrackElement>> requestedTrackElementList) {
        AtomicInteger iSumSectionsLength = new AtomicInteger(0);
        List<BlockedArea> toBlock = Collections.synchronizedList(new ArrayList<>());
        int iQ_DirTrain = -1;
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

            iQ_DirTrain = PosInfo.q_dirtrain;
            iQ_DirLength = PosInfo.q_length;
            iQ_Scale = PosInfo.q_scale;
            iDistance_LRBG = PosInfo.d_lrbg;
            iNID_LRBG = PosInfo.nid_lrbg;
            B = Balise.baliseByNid_bg.getModel(iNID_LRBG);

            AtomicInteger distanceFromTrainToNextNode = new AtomicInteger(0);
            int iRequestSize = requestedTrackElementList.size();
            Pair<Route.TrackElementType, TrackElement> StartElement = requestedTrackElementList.get(0);
            Pair<Route.TrackElementType, TrackElement> EndElement = requestedTrackElementList.get(iRequestSize -1);
            BlockedArea StartArea = handleStartElement(dSumOfWholeMaTrack, StartElement, maRequest.Tm, iQ_DirLength, iQ_Scale
                ,iDistance_LRBG, iNID_LRBG, iQ_DirTrain, EndElement,iEoaQ_Scale, iSumSectionsLength,distanceFromTrainToNextNode);
            // start Area is blocked
            if(StartArea == null) return false; // returns false, das Startgebiet des Zuges ist blockiert
            toBlock.add(StartArea);


                for(int i = 1; i < requestedTrackElementList.size() - 1; i++) {
                    // erstes und letztes Element wird nicht mit i referenziet letztes Element in letzter iteration
                    // => i + 1
                    Pair<Route.TrackElementType, TrackElement> Element1 = requestedTrackElementList.get(i);
                    Pair<Route.TrackElementType, TrackElement> Element2 = requestedTrackElementList.get(i + 1);
                    // Waypoint between start and end have to be crossover nodes, ui is in this manner implemented
                    if(!Element1.getKey().equals(Route.TrackElementType.CROSSOVER_TYPE)) return false;
                    if(!Element2.equals(EndElement)) {
                        if (!Element2.getKey().equals(Route.TrackElementType.CROSSOVER_TYPE)) return false;

                    } else {
                        // Element2 ist End Element aber Element1 ist eine Weiche
                        // also muss die Weiche als Blockiert eingetragen werden
                        TopologyGraph.Node N = (TopologyGraph.Node) Element1.getValue();

                        toBlock.add(new BlockedArea(N, N.TopNodeId));
                        break;
                    }
                    TopologyGraph.Node N1 = (TopologyGraph.Node) Element1.getValue();
                    TopologyGraph.Node N2 = (TopologyGraph.Node) Element2.getValue();
                    TopologyGraph.Edge E = TopologyGraph.twoTopPointBelongsToEdgeRepo.
                            getModel(N1.TopNodeId).getModel(N2.TopNodeId);
                    toBlock.add(new BlockedArea(N1, N1.TopNodeId));
                    toBlock.add(new BlockedArea(N2, N2.TopNodeId));
                    toBlock.add(new BlockedArea(E, Q_SCALE_1M, 0 , Q_SCALE_1M, (int) Math.floor(E.dTopLength)+ 1));
                    int iSumDistance = distanceFromTrainToNextNode.get();
                    iSumDistance += Math.floor(E.dTopLength);
                    distanceFromTrainToNextNode.set(iSumDistance);
                }
                if(EndElement.getKey().equals(Route.TrackElementType.CROSSOVER_TYPE)) {
                    TopologyGraph.Node NC = (TopologyGraph.Node) EndElement.getValue();
                    toBlock.add(new BlockedArea(NC, NC.TopNodeId));
                } else if(EndElement.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {
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

                            toBlock.add(new BlockedArea(Ed, Q_SCALE_1M, 0,
                                    Q_SCALE_1M, (int) dDistanceFromRecentNode));
                        } else {
                            toBlock.add(new BlockedArea(Ed, Q_SCALE_1M, (int) dDistanceFromRecentNode, Q_SCALE_1M,
                                    (int) Math.ceil(Ed.dTopLength)));
                        }
                    }
                }

                toBlock = calcCrossoverSignals(toBlock);

                List<BlockedArea> blockedAreas = getAllAreaNotBlockedByOwn(maRequest.Tm.iTrainId);
                for(BlockedArea ThisArea : toBlock)
                for(BlockedArea OtherArea: blockedAreas) {
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
    private ArrayList<BlockedArea> calcCrossoverSignals(List<BlockedArea> toBlock) {
        ArrayList<BlockedArea> crossoverAreas = new ArrayList<>(toBlock);
        for(BlockedArea BA : toBlock) {
            ArrayList<BlockedArea> limitAreas = BA.getListOfEdgeLimits();
            for(BlockedArea L_BA : limitAreas) {
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

    private BlockedArea handleStartElement(BigDecimal dSumOfWholeMaTrack, Pair startElement, TrainModel tm, int iQ_dirLength, int iQ_scale, int iDistance_lrbg, int iNID_lrbg, int iQ_DirTrain, Pair endElement, int iEoaQ_Scale, AtomicInteger iSumSectionsLength, AtomicInteger distanceFromTrainToNextNode) {
        int iTrainId = tm.iTrainId;


        BlockedArea StartArea = null;
        Route.TrackElementType TET = (Route.TrackElementType) startElement.getKey();
        if (TET.equals(Route.TrackElementType.CROSSOVER_TYPE)) {
            TopologyGraph.Node N = (TopologyGraph.Node) startElement.getValue();
            StartArea = new BlockedArea(N, N.TopNodeId);
            return StartArea;
        } else if (TET.equals(Route.TrackElementType.RAIL_TYPE)) {
            //TODO Check if Train is standing on trail still
            distanceFromTrainToNextNode.set((int) tm.getdDistanceToNodeRunningTo());
            iSumSectionsLength.set((int) tm.getdDistanceToNodeRunningTo());
            TrackElement StartEL = (TrackElement) startElement.getValue();
            double distanceToA1 = 0;
            double distanceToA2 = 0;
            Balise B = Balise.baliseByNid_bg.getModel(iNID_lrbg);
            CDatenpunkt D = B.getPlanProDataPoint();
            double dDistanceBaliseFromA = D.getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue();

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
                StartArea = new BlockedArea((TopologyGraph.Edge) StartEL, Q_SCALE_1M, (int) Math.floor(distanceToA1),
                        Q_SCALE_1M, (int) Math.ceil(distanceToA2));
            }
        }
        List<BlockedArea> blockList = getAllAreaNotBlockedByOwn(iTrainId);
        for(BlockedArea OtherArea: blockList) {
            if(StartArea.compareIfIntersection(OtherArea)) {
                // has intersection so SL reject
                return null;
            }
        }


        return StartArea;
    }


    @NotNull
    private BlockedArea handleMoveToA(TrainModel tm, BigDecimal dMaTrackLength, TopologyGraph.Edge startEL) {
        double distanceToA2;
        double distanceToA1;
        BlockedArea StartArea;
        distanceToA2 = tm.getdDistanceToNodeRunningTo();
        distanceToA1 = distanceToA2 - dMaTrackLength.doubleValue();

        distanceToA2 = distanceToA2 + tm.length;
        if(distanceToA2 > startEL.dTopLength) distanceToA2 = startEL.dTopLength;

        StartArea = new BlockedArea(startEL, Q_SCALE_1M, (int) Math.floor(distanceToA1),
                Q_SCALE_1M, (int) Math.ceil(distanceToA2));
        return StartArea;
    }

    @NotNull
    private BlockedArea handleMovingToB(TrainModel tm, int iQ_scale, BigDecimal dMaTrackLength, int iTrainId, TopologyGraph.Edge startEL, double dDistanceBaliseFromA, TopologyGraph.Edge startEdge) {
        double distanceToA2;
        double distanceToA1;
        BlockedArea StartArea;
        //double dTrainFront = calcTrainFront(iTrainId, iQ_scale, iMaTrackLength, dDistanceBaliseFromA, true);
        distanceToA1 = startEdge.dTopLength - tm.getdDistanceToNodeRunningTo();
        distanceToA2 = distanceToA1 + dMaTrackLength.doubleValue();

        distanceToA1 = distanceToA1 - tm.length;
        if(distanceToA1 < 0) distanceToA1 = 0;

        StartArea = new BlockedArea(startEL, Q_SCALE_1M, (int) Math.floor(distanceToA1),
                Q_SCALE_1M, (int) Math.ceil(distanceToA2));
        return StartArea;
    }

    private boolean calcIsMovingToB(String sIdOfEdgeOfTrain, TrainModel tm) {
        TopologyGraph.Edge E = PlanData.topGraph.EdgeRepo.get(sIdOfEdgeOfTrain);
        TopologyGraph.Node N = TopologyGraph.NodeRepo.get(tm.getsNodeIdTrainRunningTo());
        if(E == null) throw new InvalidParameterException("Edge of Train not found");
        if(E.A.equals(N)) return false;
        if(E.B.equals(N)) return true;
        throw new InvalidParameterException("Edge has not Node, which train running to.");
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


        iTrainId = maRequest.Tm.iTrainId;
        // check if some elements blocked
        List<EoaSectionAdapter> sectionlist = maAdapter.eoa.sections;
        for(EoaSectionAdapter ES : sectionlist) {

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
            blockLastPositionReports(iTrainId);
            throw new InvalidParameterException("Balse requested not found");
        }
        iQ_DirTrain = CurrentPosition.q_dirtrain;
        iQ_DirLength = CurrentPosition.q_length;
        if(true != checkQ_Length(iQ_DirLength)) {
            blockLastPositionReports(iTrainId);
            throw new InvalidParameterException("No Train Length information available");
        }




        return CurrentPosition;
    }

    private synchronized void blockLastPositionReports(int iTrainId) {
        List<BlockedArea> blockedAreasById = blockList.getModel(iTrainId);
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
            TopologyGraph.Edge E = PlanData.topGraph.EdgeRepo.get(BaliseEdge.getIdentitaet().getWert());
            BlockedArea BA = new BlockedArea(E, Q_SCALE_1M, 0, Q_SCALE_1M, 0);
            blockedAreasById.add(BA);
        }
        blockList.update(iTrainId, blockedAreasById);
    }

    /**
     * Diese Methode untersucht ob alle Routenelemente durchwegs verbunden sind.
     * @param maRequest - {@link MaRequestWrapper} - Anfragedatend des TMS
     * @param requestedTrackElementList - {@link ArrayList} - Eine Liste der Routenelemente die verbunden sein sollten.
     * @return boolean - ist Route durchwegs verbunden
     */
    public synchronized boolean checkIfRouteIsContinuousConnected(MaRequestWrapper maRequest, ArrayList<Pair<Route.TrackElementType, TrackElement>> requestedTrackElementList) {
        if(requestedTrackElementList == null) {
            throw new NullPointerException("Track List is null");
        } else if (requestedTrackElementList.isEmpty()) {
            throw new InvalidParameterException("Track List is empty");
        } else if (requestedTrackElementList.size() < 2) {
            throw new InvalidParameterException("Route with only one Track Element is not supported. (2 is min)");
        } else if(routeHasNullValue(requestedTrackElementList)) {
            throw new InvalidParameterException("Route must not have null value content");
        }
        Pair<Route.TrackElementType, TrackElement> FirstElement = requestedTrackElementList.get(0);
        Pair<Route.TrackElementType, TrackElement> LastElement = requestedTrackElementList.get(requestedTrackElementList.size() -1);
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

    private boolean handleDifferentialElements(Pair<Route.TrackElementType, TrackElement> edgeElement, Pair<Route.TrackElementType, TrackElement> nodeElement, TopologyGraph.Node N, TopologyGraph.Edge E) {
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

    private boolean firstOrLastElmentIsNOTconnectedWithMiddle(Pair<Route.TrackElementType, TrackElement> middleElement, Pair<Route.TrackElementType, TrackElement> firstOrLastElement) throws InvalidParameterException {
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

    private void handleWrongElements(Pair<Route.TrackElementType, TrackElement> WrongTypeElement, boolean shallBeEdge) throws InvalidParameterException {
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
    private boolean bothElementsSameType(Pair<Route.TrackElementType, TrackElement> elementA,
                                         Pair<Route.TrackElementType, TrackElement> elementB, Route.TrackElementType type) {
        return elementA.getLeft().equals(type) && elementB.getLeft().equals(type);
    }


    private boolean routeHasNullValue(ArrayList<Pair<Route.TrackElementType, TrackElement>> requestedTrackElementList) {
        for(Pair<Route.TrackElementType, TrackElement> RouteElement: requestedTrackElementList) {
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
    public synchronized boolean checkIfRouteElementStatusIsCorrect(MaRequestWrapper maRequest, ArrayList<Pair<Route.TrackElementType, TrackElement>> requestedTrackElementList) {
        DBDClient dbdclient = new DBDClient();
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
            handlePositionHistory(iTrainId, PosInf);
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

    private void handlePositionHistory(int iTrainId, PositionInfo posInf) {
        CircularFifoBuffer buffer = positionHistory.getModel(iTrainId);
        if(buffer == null) buffer = new CircularFifoBuffer(100);
        buffer.add(posInf);
        positionHistory.update(iTrainId, buffer);
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
                        selectClass(SmartSafetyContinousConnectTest.class)
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
    public synchronized void handleFlankProtection(MaRequestWrapper maRequest, ArrayList<Pair<Route.TrackElementType, TrackElement>> requestedTrackElementList) {
    }
    /**
     * Noch nicht implementiert
     */
    public synchronized boolean checkSSP(MA ma) {
        return true;
    }

    /**
     * Noch nicht implementiert
     */
    public synchronized void unlockElementsNotUsed(ArrayList<Pair<Route.TrackElementType, TrackElement>> requestedTrackElementList) {

    }

    public static void main(String[] args) {
        SmartSafety safety = SmartSafety.getSmartSafety();
        safety.slSelfCheck(null);
    }

    /**
     * Check ob eine Weiche in der Blockierten Liste vorhanden ist.
     * @param cdc
     */
    public void checkIfDbdElementIsNotBlocked(CheckDbdCommand cdc) {
        String checkSid = cdc.sId;
        for(List<BlockedArea> l :this.blockList.getAll()) {
            for(BlockedArea BA : l) {
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
        SmartLogic.outputQueue.offer(BlockMessage);
    }


}
