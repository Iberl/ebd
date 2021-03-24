package de.ibw.smart.logic.intf.impl;

import de.ibw.history.PositionModul;
import de.ibw.history.data.ComposedRoute;
import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.datatypes.QueueUuidMapper;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.smart.logic.intf.*;
import de.ibw.smart.logic.intf.messages.MaRequestReturnPayload;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.smart.logic.safety.SafetyLogic;
import de.ibw.tms.etcs.*;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.occupation.MARequestOccupation;
import de.ibw.tms.ma.physical.MoveableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import de.ibw.tms.plan_pro.adapter.topology.trackbased.TopologyFactory;
import de.ibw.util.DefaultRepo;
import ebd.TescModul;
import ebd.rbc_tms.message.Message_21;
import ebd.rbc_tms.payload.Payload_21;
import ebd.rbc_tms.util.EOA;
import ebd.rbc_tms.util.MA;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Diese Klasse verwaltet die Serverroutine des SL Servers.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
 */
public class SmartServer4TmsImpl extends SmartLogicTmsProxy implements SmartServerFromTmsIntf, TmsIntf {

    /**
     * Modulbezeichnung von der MA-Verwaltung dieses Servers f&uuml;r das Logging
     */
    public static final String SMART_SERVER_MA_MODUL = "SMART-SERVER-MA-MODUL";
    /**
     * Modulbezeichnung der Checkroutine welche Routen-Elemente vorliegen f&uuml;r das Logging
     */
    public static final String ROUTE_COMPONENTS_IDENTIFY = "ROUTE-COMPONENTS-IDENTIFY";

    /**
     * Instanz dieses Servers
     */
    public static SmartServer4TmsImpl instance;


    /**
     * Dieser Mapper verwaltet Warteschlangen f&uuml;r Acknowledges vom RBC
     */
    public static QueueUuidMapper ackQueues = new QueueUuidMapper();

    /**
     * Selbstcheck der Smartlogic bereitet Fehler
     */
    public static final String SL_SELF_CHECK_ERROR = "001";
    /**
     * TMS konnte nicht von der SL identifiziert werden
     */
    public static final String TMS_NOT_IDENTIFIED_ERROR = "002";
    /**
     * Zug-Id konnte nicht verifiziert werden
     */
    public static final String TRAIN_ID_NOT_VERIFIED_ERROR = "003";
    /**
     * Einige Routen-Elemente f&uuml;r das Freigaben einer MA durch die SmartLogic sind belegt
     */
    public static final String ELEMENT_RESERVATION_ERROR = "004";
    /**
     * Die Liste der Routen Elemente ist nicht durchg&auml;nig definiert. Im Pfad fehlt ein anzugebendes Element
     */
    public static final String NOT_ALL_ELEMENTS_GIVEN_FOR_RESERVATION_ERROR = "009";
    /**
     * Ein Element hat einen Status, sodass die Route nicht von der SL freigegeben werden kann
     */
    public static final String STATUS_OF_ELEMENT_IS_WRONG_ERROR = "010";
    /**
     * Gefahrzonen konnten nicht abgerufen werden
     */
    public static final String NO_DANGERZONE_RETRIEVAL_ERROR = "011";

    /**
     * Der Zug in seinem Status kann die Anforderung nicht ausf&uuml;hren
     */
    public static final String TRAIN_NOT_FULFIL_ROUTE_CRITERIA_ERROR  = "015";
    /**
     * Das Geschwindigkeitsprofil ist nicht zul&auml;ssig
     */
    public static final String SSP_CHECK_ERROR  = "015";
    /**
     * Die weitergegebene MA wurde vom RBC nicht bes&auml;igt
     */
    public static final String NO_ACK = "NO_ACK";

    public static final String INVALID_REQUEST = "INVALID_REQUEST";





    /**
     * Modul for Messages to RBC
     */
    private RbcModul RbcClient;
    /**
     * Communication Server to TMS
     */
    private SmartServer smartServ;
    //private SmartLogicTmsProxy TmsProxy;

    private EventBusManager EBM = null;

    /**
     * Diese Implementierung des SmartServers hat ein Modul zum Empfangen von Nachrichten des RBC als RBD Modul
     * Diese Implementierung hat eine Serverkomponente, die mit dem TMS kommuniziert.
     * @param rbcCl - RBC Nachrichten Empfangs Modul
     * @param smartServer - Server der Anfragen des TMS verwaltet
     */
    public SmartServer4TmsImpl(RbcModul rbcCl, SmartServer smartServer) {
        super(smartServer);
        this.RbcClient = rbcCl;
        this.smartServ = smartServer;
        instance = this;


        try {
            EBM = EventBusManager.registerOrGetBus(1,false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //this.TmsProxy = new SmartLogicTmsProxy(smartServer);
    }

    private void sendMessageToTMS(SmartServerMessage SmartMessage) {
        try {
            SmartLogic.outputQueue.put(SmartMessage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sendMaResponseToTMS(MaRequestReturnPayload MaReturn, Long lPrio)  {
        SmartServerMessage SmartMessage = new SmartServerMessage(MaReturn.parseToJson(), lPrio);
        SmartMessage.setbIsFromSL(true);
        sendMessageToTMS(SmartMessage);
    }


    private TopologyGraph createTopology() {
        //new PlanProTmsAdapter()
        return null;
    }

    private void sendTrainStatusRequest(Message_21 Ma) {

    }


    /**
     * Diese Methode checkt die Eingegangen MA vom TMS
     *
     * @param Ma - eien MA zum RBC
     * @param uuid - KommunikationsId mit RBC
     * @param tms_id - Id des TMS
     * @param rbc_id - Id des angesprochenen RBCs
     * @param lPriority - Priority
     */

    @Override
    public synchronized void checkMovementAuthority(int iTrainId, Route R, MA Ma, UUID uuid, String tms_id, String rbc_id,
                                       Long lPriority) {
        MaRequestReturnPayload MaReturnPayload = new MaRequestReturnPayload();
        if(!guardMaCheck(R, Ma, uuid)) return;

        RbcMaAdapter MaAdapter = (RbcMaAdapter) Ma;

        MovementAuthority smartLogicMa;
        SpotLocationIntrinsic EoaLocation = new SpotLocationIntrinsic();
        EoaLocation.setIntrinsicCoord(R.getIntrinsicCoordOfTargetTrackEdge());
        T_EMA tEma = new T_EMA();
        tEma.setTime((short) MaAdapter.eoa.t_loa);
        boolean eoaQEndtimer = MaAdapter.eoa.endTimer != null;
        boolean eoaQDangerPoint = MaAdapter.eoa.dangerPoint != null;
        boolean eoaQOverlap = MaAdapter.eoa.overlap != null;
        ETCS_DISTANCE eoaEndTimerDistance = new ETCS_DISTANCE();
        ETCS_TIMER eoaEndTimer = new ETCS_TIMER();
        ETCS_DISTANCE eoaDangerPointDistance = new ETCS_DISTANCE();
        ETCS_SPEED eoaDangerPointSpeed = new ETCS_SPEED();
        DangerPoint DP;

        Overlap O = null;
        SvL Svl = null;
        SSP ssp = new SSP();
        GradientProfile GP = new GradientProfile(null);
        List<SpeedSegment> speedSegments = new ArrayList<>();
        eoaEndTimerDistance.sDistance = 0;

        /*EoA slEoA = generateEoA(R, MaAdapter, EoaLocation, tEma, eoaQEndtimer, eoaQDangerPoint, eoaQOverlap,
                eoaEndTimerDistance, eoaEndTimer, eoaDangerPointDistance, eoaDangerPointSpeed);
        if(slEoA.overlap != null) {
            Svl = slEoA.overlap.getSvl();
        }*/
        /*List<GradientAdapter> listGradients = MaAdapter.gradientProfile.gradients;
        for(GradientAdapter Gradient : listGradients) {
            GradientSegment GS = new GradientSegment();
            ETCS_GRADIENT etcs_gradient = new ETCS_GRADIENT();
            etcs_gradient.bGradient = (byte) Gradient.g_a;
            GS.setG_A(etcs_gradient);
            GS.setQ_GDIR(Gradient.q_gdir);
            GS.se
        }*/
        ModeChangeProfile ModeProfile = new ModeChangeProfile();






        //RbcMaAdapter MaAdapter = (RbcMaAdapter) Ma;
        SafetyLogic Safety = SafetyLogic.getSmartSafety();
        boolean bCheckOk = true;
        boolean bTmsIdentified = false;
        boolean bTrainIdIsVerified = false;
        boolean bIsOccupatonFree = false;
        boolean bTrainStatusIsFresh = false;
        boolean bRouteElementAreTheRightOnes = false;
        boolean bRouteElementStatusIsRight = false;
        boolean bRouteCriteriaCheck = false;
        boolean bSspCheckOk = false;
        Boolean bAcknowledgeMA = null;
        ComposedRoute requestedTrackElementList = new ComposedRoute();
        MA RbcMa = null;
        //smartLogicMa = new MovementAuthority();

        // SmartLogicException Invalid PLan Pro
        bCheckOk = Safety.slSelfCheck();
        if(!bCheckOk) {
            MaReturnPayload.setErrorState(uuid, false, SL_SELF_CHECK_ERROR);
            sendMaResponseToTMS(MaReturnPayload, 1L);
            return;
        } else {
            bTmsIdentified = Safety.verifyTms(tms_id);
            if(!bTmsIdentified) {
                MaReturnPayload.setErrorState(uuid, false, TMS_NOT_IDENTIFIED_ERROR);
                sendMaResponseToTMS(MaReturnPayload, 1L);
                return;
            } else {
                bTrainIdIsVerified = Safety.verifyTrainID(iTrainId, Ma);
                if(!bTrainIdIsVerified) {
                    MaReturnPayload.setErrorState(uuid, false, TRAIN_ID_NOT_VERIFIED_ERROR);
                    sendMaResponseToTMS(MaReturnPayload, 1L);
                    return;
                }
            }
        }
        if(EBM != null) EBM.log("Check Route", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));

        //continous connect
        requestedTrackElementList = identifyRouteElements(R, requestedTrackElementList);

        if(requestedTrackElementList == null) {
            if(EBM != null) EBM.log("Route not existing", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
            MaReturnPayload.setErrorState(uuid, false,ELEMENT_RESERVATION_ERROR );
            sendMaResponseToTMS(MaReturnPayload, 2L);
            if(EBM != null) EBM.log("SL ELement-Reservation FAIL; TrainId: " + iTrainId + "UUID: " + uuid.toString(),
                    SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
            return;
        } else {
            if(EBM != null) EBM.log("Route exists", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));

        }
        MARequestOccupation MAO = Safety.checkIfRouteIsNonBlocked(iTrainId, R, MaAdapter,requestedTrackElementList, uuid);
        // always unblock workaround

        bIsOccupatonFree = MAO != null;
        // PLEASE CHANGE above Line

        // speed segments decission
        // gradient segments decission
        // Ma sections
        // AxleLoadSpeedProfile stays null
        // Mode sections
        // Sustainability Data stays null
        // Ma Occupation will be filled
        // Flank Area stays null

        /**To Debug **/
        //bIsOccupatonFree = true;
        if(bIsOccupatonFree)
            if(EBM != null) EBM.log("Route is drivable", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));


        if(!bIsOccupatonFree) {
            if(EBM != null) EBM.log("Route is not drivable", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));

            MaReturnPayload.setErrorState(uuid, false,ELEMENT_RESERVATION_ERROR );
            sendMaResponseToTMS(MaReturnPayload, 2L);
            if(EBM != null) EBM.log("SL ELement-Reservation FAIL; TrainId: " + iTrainId + "UUID: " + uuid.toString(),
                    SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
            return;
        } else {
            if(EBM != null) EBM.log("SL ELement-Reservation Successfull; TrainId: " + iTrainId + "UUID: " + uuid.toString(),
                    SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
        }
        bTrainStatusIsFresh = Safety.checkIfTrainStatusRequestIsFresh(iTrainId, R);
        if(!bTrainStatusIsFresh) {
            // send and wait for position report
            // send set Status on block elements with timeout
        } else {
            // send set Status on block elements with timeout
        }

        bRouteElementAreTheRightOnes = Safety.checkIfRouteIsContinuousConnected(iTrainId, R, requestedTrackElementList);
        bRouteElementAreTheRightOnes = true;
        if(!bRouteElementAreTheRightOnes) {
            if(EBM != null) EBM.log("FAIL Route is not continuous connected. TrainId-> " + iTrainId + "UUID-> " + uuid.toString(), SafetyLogic.TRACK_SAFETY );
            MaReturnPayload.setErrorState(uuid, true,NOT_ALL_ELEMENTS_GIVEN_FOR_RESERVATION_ERROR );
            sendMaResponseToTMS(MaReturnPayload, 2L);
            return;
        } else if(EBM != null) EBM.log("SUCCESSFUL Route is continuous connected. TrainId-> " + iTrainId + "UUID-> " + uuid.toString(), SafetyLogic.TRACK_SAFETY );

        bRouteElementStatusIsRight = Safety.checkIfRouteElementStatusIsCorrect(iTrainId, R, requestedTrackElementList);
        if(!bRouteElementStatusIsRight) {
            MaReturnPayload.setErrorState(uuid, true, STATUS_OF_ELEMENT_IS_WRONG_ERROR);
            sendMaResponseToTMS(MaReturnPayload, 2L);
            return;
        }
        if(!handleDangerZones(uuid)) {
            // dangerPoints not manageable
            return;
        }
        bRouteCriteriaCheck = Safety.checkTrainForRouteCriteria();
        if(!bRouteCriteriaCheck) {
            MaReturnPayload.setErrorState(uuid, true, TRAIN_NOT_FULFIL_ROUTE_CRITERIA_ERROR);
            sendMaResponseToTMS(MaReturnPayload, 2L);
            return;
        }
        Safety.handleFlankProtection(iTrainId, R, requestedTrackElementList);


        bSspCheckOk = Safety.checkSSP(Ma);
        if(!bSspCheckOk) {
            MaReturnPayload.setErrorState(uuid, true, SSP_CHECK_ERROR);
            sendMaResponseToTMS(MaReturnPayload, 2L);
            return;
        }

        Safety.unlockElementsNotUsed(requestedTrackElementList);

        //checkPeekWaysOfTrailSwitch();
        //wrongSettingofTrailSwitch();
        //MaOverlap()
        int nid_engine_Id = 0;

        Payload_21 MaPayload = null;
        if(uuid == null) uuid = UUID.randomUUID();
        try {
            nid_engine_Id = iTrainId;
        } catch(Exception E) {
            E.printStackTrace();
            throw new InvalidParameterException("nid_engine_Id unknown");

        }
        try {
            RbcMa = MaAdapter.convertToRbcMA();
            MaPayload = new Payload_21(nid_engine_Id, RbcMa);
        } catch (Exception E) {
            E.printStackTrace();
            throw new InvalidParameterException("Payload 21 cannot be created");
        }
        Message_21 MaMsg = new Message_21(uuid,tms_id, rbc_id, MaPayload);


        if(EBM != null)
            EBM.log("Search for RBCs", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));


        PriorityMessage priorityMessage = new PriorityMessage(MaMsg, lPriority);
        ackQueues.createQueue(uuid);

        this.RbcClient.sendMessage(priorityMessage);
        try {
            bAcknowledgeMA = ackQueues.poll(uuid);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(bAcknowledgeMA == null) bAcknowledgeMA = false;
        if(bAcknowledgeMA) {
            handleMaAckReceived(iTrainId, R, uuid, MaReturnPayload, requestedTrackElementList, RbcMa, MAO, nid_engine_Id);
        } else {
            handleInvalidRequest(uuid, MaReturnPayload, NO_ACK);
        }

    }

    private void handleMaAckReceived(int iTrainId, Route R, UUID uuid, MaRequestReturnPayload MaReturnPayload,  ComposedRoute requestedTrackElementList, MA RbcMa, MARequestOccupation MAO, int nid_engine_Id) {
        try {
            SafetyLogic.getSmartSafety().transferMaRequestBlockListIntoRealBlockList(iTrainId, MAO, RbcMa, R, requestedTrackElementList);
        } catch (SmartLogicException e) {
            e.printStackTrace();
            if(EBM != null)
                EBM.log("Ma Check has failure: " + e.getMessage(), SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));

            return;
        }
        //
        serveValidMa(uuid, MaReturnPayload, requestedTrackElementList, nid_engine_Id);
    }

    private void serveValidMa(UUID uuid, MaRequestReturnPayload MaReturnPayload, ComposedRoute requestedTrackElementList, int nid_engine_Id) {
        MaReturnPayload.setMaSuccessfull(uuid);
        PositionModul.getInstance().updateCurrentRoute(nid_engine_Id, requestedTrackElementList);
        sendMaResponseToTMS(MaReturnPayload, 3L);
    }

    private void handleInvalidRequest(UUID uuid, MaRequestReturnPayload maReturnPayload, String errorReason) {
        SafetyLogic.getSmartSafety().removeOccupationOfCommunication(uuid);
        maReturnPayload.setErrorState(uuid,true, errorReason);
        sendMaResponseToTMS(maReturnPayload, 2L);
    }

    private EoA generateEoA(Route R, RbcMaAdapter ma, SpotLocationIntrinsic eoaLocation, T_EMA tEma, boolean eoaQEndtimer, boolean eoaQDangerPoint, boolean eoaQOverlap, ETCS_DISTANCE eoaEndTimerDistance, ETCS_TIMER eoaEndTimer, ETCS_DISTANCE eoaDangerPointDistance, ETCS_SPEED eoaDangerPointSpeed) {
        DangerPoint DP;
        Overlap O;

        if(eoaQEndtimer == false) {
            eoaEndTimerDistance = null;
            eoaEndTimer = null;
        } else {
            eoaEndTimerDistance.sDistance = (short) ma.eoa.endTimer.d_endtimerstartloc;
            eoaEndTimer.sTimer = (short) ma.eoa.endTimer.t_endtimer;

        }
        if(eoaQDangerPoint == false) {
            DP = null;
        } else {
            DP = generateDangerPoint(ma, eoaDangerPointDistance, eoaDangerPointSpeed);
        }
        if(eoaQOverlap == false) {
            O = null;
        } else {
            O = generateOverlap(R, ma);
        }
        Q_SCALE qs = Q_SCALE.getScale(ma.eoa.q_scale);
        EoA smartLogicEoA = new EoA(eoaLocation, ma.eoa.v_loa, tEma, eoaQEndtimer,
                eoaEndTimerDistance, eoaEndTimer, eoaQDangerPoint, DP, eoaQOverlap,O,qs);
        return smartLogicEoA;
    }

    @NotNull
    private Overlap generateOverlap(Route r, RbcMaAdapter ma) {
        SvL svl;
        Overlap O;
        O = new Overlap();
        SpotLocationIntrinsic svlLocation = new SpotLocationIntrinsic();
        svlLocation.setIntrinsicCoord(r.getIntrinsicCoordOfTargetTrackEdge());

        svl = new SvL(svlLocation);
        svl.setVmax(ma.eoa.overlap.v_releaseol);
        O.setSvl(svl);
        O.d_OL = new ETCS_DISTANCE();
        O.d_OL.sDistance = (short) ma.eoa.overlap.d_ol;
        O.d_STARTOL = new ETCS_DISTANCE();
        O.d_STARTOL.sDistance = (short) ma.eoa.overlap.d_startol;
        O.q_OL = Q_SCALE.getScale(ma.eoa.q_scale);
        O.q_STARTOL = Q_SCALE.getScale(ma.eoa.q_scale);
        O.t_OL = new ETCS_TIMER();
        O.t_OL.sTimer = (short) ma.eoa.overlap.t_ol;
        O.v_RELEASEOL = new ETCS_SPEED();
        O.v_RELEASEOL.bSpeed = (byte) ma.eoa.overlap.v_releaseol;
        return O;
    }

    @NotNull
    private DangerPoint generateDangerPoint(RbcMaAdapter ma, ETCS_DISTANCE eoaDangerPointDistance, ETCS_SPEED eoaDangerPointSpeed) {
        DangerPoint DP;
        eoaDangerPointDistance.sDistance = (short) ma.eoa.dangerPoint.d_dp;
        eoaDangerPointSpeed.bSpeed = (byte) ma.eoa.dangerPoint.v_releasedp;
        DP = new DangerPoint(eoaDangerPointDistance, eoaDangerPointSpeed);
        return DP;
    }

    @Nullable
    private boolean guardMaCheck(Route r, MA ma, UUID uuid) {
        MaRequestReturnPayload MaReturnPayload = new MaRequestReturnPayload();
        RbcMaAdapter rbcMa = (RbcMaAdapter) ma;
        if(r == null || r.getElementListIds() == null  || rbcMa == null || rbcMa.eoa == null ||
                rbcMa.eoa.sections == null || rbcMa.eoa.q_scale == null || rbcMa.speedProfile == null ||
                rbcMa.speedProfile.sections.isEmpty() ||
                rbcMa.gradientProfile == null || rbcMa.gradientProfile.gradients.isEmpty()
        ) {
            MaReturnPayload.setErrorState(uuid, false, SL_SELF_CHECK_ERROR);
            sendMaResponseToTMS(MaReturnPayload, 1L);
            return false;
        }
        return true;
    }


    private boolean handleDangerZones(UUID uuid) {
        SafetyLogic Safety = SafetyLogic.getSmartSafety();
        if(!Safety.dangerZonesAreReceivable()) {
            MaRequestReturnPayload MaReturnPayload = new MaRequestReturnPayload();
            MaReturnPayload.setErrorState(uuid, true,NO_DANGERZONE_RETRIEVAL_ERROR );
            sendMaResponseToTMS(MaReturnPayload, 2L);
            return false;
        }
        return true;
    }

    /**
     * Returns Route Elements in Train-Visiting-Order
     *
     * @param requestedTrackElementList
     * @return ArrayList of Pair with TrackElement and Element Type
     */
    private ComposedRoute identifyRouteElements(Route R, ComposedRoute requestedTrackElementList) {
        try{

            int iListCount = 0;


            System.out.println(R.getElementListIds().size());

            System.out.println("check done");

            List<String> idList = R.getElementListIds();

            int iIdCount = idList.size();

            for(int i = 0; i < iIdCount; i++) {
                Pair<Route.TrackElementType, ITopological> TePair = null;

                String sId  = idList.get(i);

                   TopologyGraph.Edge E =  PlanData.EdgeIdLookupRepo.getModel(sId);
                   if(E == null){
                        if(EBM != null) EBM.log("Edge Element (ID: " + sId + ") cannot be Identified", ROUTE_COMPONENTS_IDENTIFY);

                       throw new NullPointerException("Edge Element cannot be Identifed: " + sId);
                   }

                    TePair = new ImmutablePair<>(Route.TrackElementType.RAIL_TYPE, E);

                if(i > 0) {
                    TePair = addWaypoint(requestedTrackElementList, E);
                }
                requestedTrackElementList.add(TePair);


            }


            //ArrayList<Waypoint> wayList = R.getAllWaypointsInOrder();
           /* Waypoint WayStart = wayList.get(0);
            Waypoint WayEnd = wayList.get(wayList.size() - 1);

            if (handleWaypontsOnOneTrail(requestedTrackElementList, WayStart, WayEnd)) {
                return requestedTrackElementList;
            }
            wayList.remove(WayStart);
            wayList.remove(WayEnd);
            iListCount = wayList.size();


            if(iListCount == 1) {
                //one Waypoint plus start and End
                return handle3Waypoints(requestedTrackElementList, wayList, WayStart, WayEnd);
            } else {
                handleWaypointsMore3Waypoints(requestedTrackElementList, iListCount, wayList, WayStart, WayEnd);
            }




            */


        } catch(Exception | SmartLogicException E) {
            E.printStackTrace();
            return null;
        }

        return requestedTrackElementList;
    }

    private Pair<Route.TrackElementType, ITopological> addWaypoint(ComposedRoute requestedTrackElementList, TopologyGraph.Edge e) throws SmartLogicException {
        if(requestedTrackElementList.isEmpty()) throw new InvalidParameterException("Predeceeding Edge is missing");
        TopologyGraph.Edge PredecessorEdge = getLastTrackEdge(requestedTrackElementList);
        TopologyGraph.Node N = null;
        Waypoint W;

        TopologyConnect E_Connect = null;
        TopologyConnect Predecessor_Connect = null;
        // Kreiskanten bedueten zwei Knoten die sich von zwei Kanten treffen können
        if(PredecessorEdge.A.equals(e.A) || PredecessorEdge.A.equals(e.B)) {
            N = PredecessorEdge.A;
            Predecessor_Connect = PredecessorEdge.TopConnectFromA;

            if(PredecessorEdge.A.equals(e.A)) {
                E_Connect = e.TopConnectFromA;
            } else {
                E_Connect = e.TopConnectFromB;
            }
        }
        if(PredecessorEdge.B.equals(e.A) || PredecessorEdge.B.equals(e.B)) {
            N = PredecessorEdge.B;
            Predecessor_Connect = PredecessorEdge.TopConnectFromB;
            if(PredecessorEdge.B.equals(e.A)) {
                E_Connect = e.TopConnectFromA;
            } else {
                E_Connect = e.TopConnectFromB;
            }
        }






        if(N == null) {

            PredecessorEdge = replaceEdgeByEdgeContainingDigitalEnd(PredecessorEdge);
            e = replaceEdgeByEdgeContainingDigitalEnd(e);
            if(PredecessorEdge.A.equals(e.A) || PredecessorEdge.A.equals(e.B)) {
                N = PredecessorEdge.A;
                Predecessor_Connect = PredecessorEdge.TopConnectFromA;

                if(PredecessorEdge.A.equals(e.A)) {
                    E_Connect = e.TopConnectFromA;
                } else {
                    E_Connect = e.TopConnectFromB;
                }
            }
            if(PredecessorEdge.B.equals(e.A) || PredecessorEdge.B.equals(e.B)) {
                N = PredecessorEdge.B;
                Predecessor_Connect = PredecessorEdge.TopConnectFromB;
                if(PredecessorEdge.B.equals(e.A)) {
                    E_Connect = e.TopConnectFromA;
                } else {
                    E_Connect = e.TopConnectFromB;
                }
            }



            if(N == null) {
                System.err.println();
                throw new SmartLogicException("Two Track-Edges cannot be connected by a Waypoint");
            }

        }

        // Wenn e zu einer DKW gehört DKW Waypoint speichern und return
        String sCheckIfdkwId = e.getRefId().replace("L", "").replace("R", "");

        MoveableTrackElement DkwElement = TescModul.MoveableTrackElementAccess.getDkwById(sCheckIfdkwId);
        if(handleDkwLinkage(requestedTrackElementList, e, PredecessorEdge, DkwElement)) {
            // DKW Waypoint added
            return new ImmutablePair<>(Route.TrackElementType.RAIL_TYPE, e);
        }



        // Wenn PredecessorEdge zu einer DKW gehört return




        String sSwitchId = ISwitchHandler.getNodeId(N);
        MoveableTrackElement SwitchElement = TescModul.MoveableTrackElementAccess.getElementById(sSwitchId);
        TrackElementStatus TES = new TrackElementStatus();

        if (handleTrackElementStatusInsertingWaypoint(requestedTrackElementList, e, PredecessorEdge, E_Connect, Predecessor_Connect, SwitchElement, TES))
            return new ImmutablePair<>(Route.TrackElementType.RAIL_TYPE, e);

        throw new SmartLogicException("Waypoint has to be found, but cannot");



    }

    private TopologyGraph.Node useTopFactory(TopologyGraph.Edge e, TopologyGraph.Edge predecessorEdge) {

        DefaultRepo<TopologyGraph.Node, DefaultRepo<TopologyGraph.Node,TopologyGraph.Edge>> cons = TopologyFactory.connections;

        TopologyGraph.Edge E1 = predecessorEdge;;
        TopologyGraph.Edge E2 = e;

        E1 = replaceEdgeByEdgeContainingDigitalEnd(E1);
        E2 = replaceEdgeByEdgeContainingDigitalEnd(E2);
        if(E1.B.equals(E2.A) || E1.B.equals(E2.B)) {

           return E1.B;
        }
        if(E1.A.equals(E2.A) || E1.A.equals(E2.B)) {
            return E1.A;
        }
        return null;
        /*
        TopologyGraph.Node nResult = null;
        TopologyGraph.Edge E = null;
        if(cons.getModel(e.A) != null) {
            E = cons.getModel(e.A).getModel(predecessorEdge.A);
            if(E == null) E = cons.getModel(e.A).getModel(predecessorEdge.B);
            if(E != null) return e.A;

        }
        if(cons.getModel(e.B) != null) {
            E = cons.getModel(e.B).getModel(predecessorEdge.A);
            if(E == null) E = cons.getModel(e.B).getModel(predecessorEdge.A);
            if(E != null) return e.B;
        }
        return null;

        */

    }

    private TopologyGraph.Edge replaceEdgeByEdgeContainingDigitalEnd(TopologyGraph.Edge e) {
        DefaultRepo<TopologyGraph.Node,DefaultRepo<TopologyGraph.Node,TopologyGraph.Edge>> cons = TopologyFactory.connections;
        TopologyGraph.Edge E1 = e;
        DefaultRepo<TopologyGraph.Node, TopologyGraph.Edge> connectionRepo = null;
        System.out.println();
        if(e.TopConnectFromB.equals(TopologyConnect.ENDE_BESTDIG)) {
            System.out.println(e.A.sOldPlanProNodeId);
             connectionRepo =  cons.getModel(e.A);
        } else if(e.TopConnectFromA.equals(TopologyConnect.ENDE_BESTDIG)) {
            System.out.println(e.B.sOldPlanProNodeId);
            connectionRepo =  cons.getModel(e.B);
        }
        if(connectionRepo == null) return e;
        E1 = connectionRepo.sortValues().get(0);
        return E1;
    }

    private boolean handleDkwLinkage(ComposedRoute requestedTrackElementList, TopologyGraph.Edge e, TopologyGraph.Edge predecessorEdge, MoveableTrackElement dkwElement) throws SmartLogicException {
        if(dkwElement != null) {
            try {
                handleTrackEdgeOnDkw(requestedTrackElementList, e, dkwElement);
            } catch (SmartLogicException Ex) {
                return false;
            }
            return true;
        } else {
            Waypoint W = requestedTrackElementList.dkwWaypointRepo.getModel(predecessorEdge);
            if(W != null) {
                // vorhergehende Switch war dkw sodass die dKW mit den Knoten zur zweiten kante verbunden ist.
                // die dkw ist bereits der Waypoint
                return true;
            }
        }
        return false;
    }

    private void handleTrackEdgeOnDkw(ComposedRoute requestedTrackElementList, TopologyGraph.Edge e, MoveableTrackElement dkwElement) throws SmartLogicException {
        Waypoint W;
        TrackElementStatus DkwStateRequested = new TrackElementStatus();
        String sid = e.getRefId();
        String last2Char = sid.substring(sid.length() - 2);
        char c1 = last2Char.charAt(0);
        char c2 = last2Char.charAt(1);
        guardDirection(c1);
        guardDirection(c2);
        addDirectionState(DkwStateRequested, c1);
        addDirectionState(DkwStateRequested, c2);
        W = new Waypoint(dkwElement, DkwStateRequested);
        requestedTrackElementList.dkwWaypointRepo.update(e,W);
        return;
    }

    private boolean handleTrackElementStatusInsertingWaypoint(ComposedRoute requestedTrackElementList, TopologyGraph.Edge e, TopologyGraph.Edge predecessorEdge, TopologyConnect e_Connect, TopologyConnect predecessor_Connect, MoveableTrackElement switchElement, TrackElementStatus TES) {
        switch (predecessor_Connect) {
            case RECHTS -> {
                TES.statusList.add(TrackElementStatus.Status.RIGHT);
                insertWaypointInRouteRequested(requestedTrackElementList, e, predecessorEdge, switchElement, TES);
                return true;
            }
            case LINKS -> {
                TES.statusList.add(TrackElementStatus.Status.LEFT);
                insertWaypointInRouteRequested(requestedTrackElementList, e, predecessorEdge, switchElement, TES);
                return true;
            }
        }
        switch (e_Connect) {
            case RECHTS -> {
                TES.statusList.add(TrackElementStatus.Status.RIGHT);
                insertWaypointInRouteRequested(requestedTrackElementList, e, predecessorEdge, switchElement, TES);
                return true;
            }
            case LINKS -> {
                TES.statusList.add(TrackElementStatus.Status.LEFT);
                insertWaypointInRouteRequested(requestedTrackElementList, e, predecessorEdge, switchElement, TES);
                return true;
            }
        }
        return false;
    }

    private void insertWaypointInRouteRequested(ComposedRoute requestedTrackElementList, TopologyGraph.Edge e, TopologyGraph.Edge predecessorEdge, MoveableTrackElement switchElement, TrackElementStatus TES) {
        Waypoint W;
        W = new Waypoint(switchElement, TES);
        Pair<String, String> key = new ImmutablePair<>(predecessorEdge.getRefId(), e.getRefId());
        Pair<String, String> keyReverse = new ImmutablePair<>(e.getRefId(), predecessorEdge.getRefId());
        requestedTrackElementList.waypointsBetweentTwoTrackEdges.update(key, W);
        requestedTrackElementList.waypointsBetweentTwoTrackEdges.update(keyReverse, W);

    }



    private void addDirectionState(TrackElementStatus dkwStateRequested, char c) {
        if(c == 'L') dkwStateRequested.statusList.add(TrackElementStatus.Status.LEFT);
        else if(c == 'R') dkwStateRequested.statusList.add(TrackElementStatus.Status.RIGHT);
    }

    private void guardDirection(char c) throws SmartLogicException {
        if(c != 'L' && c != 'R' ) throw new SmartLogicException("DKW direction must be 'L' or 'R', but is: " + c);
    }

    private TopologyGraph.Edge getLastTrackEdge(ComposedRoute requestedTrackElementList) {
        return (TopologyGraph.Edge) requestedTrackElementList.get(requestedTrackElementList.size() - 1).getRight();
    }

    /*private void handleWaypointsMore3Waypoints(ArrayList<Pair> requestedTrackElementList, int iListCount, ArrayList<Waypoint> wayList, Waypoint wayStart, Waypoint wayEnd) {
        requestedTrackElementList.add(wayStart.getTrackElement());
        for(int i = 0; i < iListCount - 1; i++) {
            checkConnectionToNextWaypoint(requestedTrackElementList, wayList, i);
        }
        requestedTrackElementList.add(wayEnd.getTrackElement());
    }*/

   /* private void checkConnectionToNextWaypoint(ArrayList<Pair> requestedTrackElementList, ArrayList<Waypoint> wayList, int i) {
        ArrayList<PositionedRelation> posRelList;
        Waypoint W1 = wayList.get(i);
        Waypoint W2 = wayList.get(i + 1);
        TrackElement CT1 = W1.getTrackElement();
        TrackElement CT2 = W2.getTrackElement();
        posRelList = (ArrayList<PositionedRelation>) CT1.getPositionedRelations();
        for(PositionedRelation PosRel: posRelList) {
            checkConnection(requestedTrackElementList, CT1, CT2, PosRel);
        }
    }

    private void checkConnection(ArrayList<Pair> requestedTrackElementList, TrackElement CT1, TrackElement CT2, PositionedRelation PosRel) {
        TrackElement TE1 = PosRel.getFrom();
        TrackElement TE2 = PosRel.getTo();
        if(TE1 == CT1 && TE2 == CT2 || TE1 == CT2 && TE2 == CT1) {
            requestedTrackElementList.add(PosRel.getVia());
        }
    }*/

    /*private ArrayList<Pair> handle3Waypoints(ArrayList<Pair> requestedTrackElementList, ArrayList<Waypoint> wayList, Waypoint wayStart, Waypoint wayEnd) {
        requestedTrackElementList.add(wayStart.getTrackElement());
        requestedTrackElementList.add(wayList.get(0).getTrackElement());
        requestedTrackElementList.add(wayEnd.getTrackElement());
        return requestedTrackElementList;
    }*/

    /**
     * @deprecated
     * @param requestedTrackElementList
     * @param wayStart
     * @param wayEnd
     * @return
     */
    private boolean handleWaypontsOnOneTrail(ArrayList<TrackEdge> requestedTrackElementList, Waypoint wayStart, Waypoint wayEnd) {
        throw new NotImplementedException("deprecated");/*
        if(wayStart.getTrackElement() == wayEnd.getTrackElement()) {
            requestedTrackElementList.add(wayStart.getTrackElement());
            return true;
        }
        return false;
        */
    }


    private boolean checkSSP(MA ma) {
        return true;
    }


    private Message_21 getDummyMessage(UUID uuid, String tms_id, String rbc_id, int nid_engine_Id) {
        EOA.Section Sec = new EOA.Section(0, false, null,null);
        List<EOA.Section> sectionList = new ArrayList<>();
        sectionList.add(Sec);
        EOA.EndTimer endTimer = new EOA.EndTimer(0,0);
        EOA.DangerPoint dangerPoint = new EOA.DangerPoint(0,0);
        EOA.Overlap overlap = new EOA.Overlap(0,0,0,0);
        MA NewMa = new MA(true, 0, 0,0, new EOA(null,null, 5,0,sectionList,endTimer,
                dangerPoint,  overlap ),
                null, null,null,null

        );
        Payload_21 MaPayload = new Payload_21(nid_engine_Id, NewMa );
        return new Message_21(uuid, tms_id, rbc_id, MaPayload);
    }
}
