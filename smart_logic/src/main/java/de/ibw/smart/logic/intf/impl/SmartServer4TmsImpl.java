package de.ibw.smart.logic.intf.impl;

import de.ibw.history.PositionData;
import de.ibw.history.PositionModul;
import de.ibw.history.TrackAndOccupationManager;
import de.ibw.history.data.ComposedRoute;
import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.datatypes.QueueUuidMapper;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.smart.logic.intf.*;
import de.ibw.smart.logic.intf.messages.Converter;
import de.ibw.smart.logic.intf.messages.MaRequestReturnPayload;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.smart.logic.safety.SafetyLogic;
import de.ibw.tms.etcs.*;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.mob.common.NID_ENGINE;
import de.ibw.tms.ma.occupation.MARequestOccupation;
import de.ibw.tms.ma.physical.MoveableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.ui.Route;
import de.ibw.util.DefaultRepo;
import ebd.SlConfigHandler;
import ebd.internal.message.Message_21;
import ebd.internal.payload.Payload_21;
import ebd.internal.util.EOA;
import ebd.internal.util.MA;
import ebd.messageLibrary.message.trackmessages.Message_3;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.*;
import ebd.rbc_tms.message.tms.ETCSTrackMessage;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Diese Klasse verwaltet die Serverroutine des SL Servers.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1
 * @since 2021-06-17
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

    public static final String NO_TRAIN_INFORMATION = "013";

    /**
     * Der Zug in seinem Status kann die Anforderung nicht ausf&uuml;hren
     */
    public static final String TRAIN_NOT_FULFIL_ROUTE_CRITERIA_ERROR  = "015";
    /**
     * Das Geschwindigkeitsprofil ist nicht zul&auml;ssig
     */
    public static final String SSP_CHECK_ERROR  = "015";


    /**
     * Der Startpunkt muss auf der Startkante der Route liegen, der Code wird im Negativfall wiedergegeben
     */
    public static final String START_POINT_NOT_ON_ROUTE = "031";

    /**
     * Der Endpunkt muss auf der letzten Kante der Route liegen, der Code wird im Negativfall wiedergegeben
     */
    public static final String END_POINT_NOT_ON_ROUTE = "032";

    /**
     * Kanten innerhalb einer Route muessen verbunden sein.
     */
    public static final String TRACK_EDGE_NOT_CONNECTED_WITH_NEXT_TRACK_EDGE = "033";

    /**
     * Die Verbindung zweier Kanten muss auch von den Richtungen her befahrbar sein.
     */
    public static final String TRACK_EDGE_CONNECTION_IS_NOT_TRAFFICALLY = "034";

    /**
     * To Define by FD
     * Das Moveable Track Element weist nicht den angeforderten Status auf
     */
    public static final String MTE_HAS_NOT_REQUIERED_STATUS = "134";


    /**
     * Die Route muss auch von den Verbindungsstatus richtig sein. Wenn nicht wird der Fehlerocde wiedergegeben.
     */
    public static final String ROUTE_ELEMENT_HAS_WRONG_STATUS = "035";

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

    /**
     * Lokal Var of Linking Module making Module exchangeable e.g. for Testing
     */
    private ILinkingIntf etcsLinkingModule = null;

    public synchronized ILinkingIntf getEtcsLinkingModule() {
        if(etcsLinkingModule == null) {
            etcsLinkingModule = LinkingModule.getInstance();
        }
        return etcsLinkingModule;
    }

    public void setEtcsLinkingModule(ILinkingIntf etcsLinkingModule) {
        this.etcsLinkingModule = etcsLinkingModule;
    }

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

        EBM = EventBusManager.RootEventBusManger;


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
        EoaLocation.setNetElementRef(R.getLastEdge().getId());
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

        if(SlConfigHandler.getInstance().byPassSmartLogicControl) {

            Payload_21 MaPayload = new Payload_21(iTrainId, MaAdapter.convertToRbcMA());
            Message_21 msg = new Message_21(uuid,tms_id, rbc_id, MaPayload);
            acknowledge(uuid, requestedTrackElementList, 1L, true, msg);
                serveValidMa(uuid, MaReturnPayload, null, iTrainId);
            return;
        }


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
        //method under: sends message to tms if not clear position
        boolean isClearPosition = setTrainForStartPositionOfRoute(iTrainId, uuid, MaReturnPayload, MaAdapter, requestedTrackElementList);
        if(!isClearPosition) {
            // deny futher checks // response for not accepting is send in setTrainForStartPositionOfRoute
            return;
        }

        //continous connect
        try {
            requestedTrackElementList = identifyRouteElements(iTrainId , R, requestedTrackElementList);
        } catch (SmartLogicException | Exception e) {
            if(EBM != null) EBM.log("Route not existing", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
            MaReturnPayload.setErrorState(uuid, false,e.getMessage() );
            sendMaResponseToTMS(MaReturnPayload, 2L);
            if(EBM != null) EBM.log("SL ELement-Reservation FAIL; TrainId: " + iTrainId + "UUID: " + uuid.toString(),
                    SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
            return;

        }
        if(EBM != null) EBM.log("Route exists", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
        try {
            checkMteStatus(requestedTrackElementList);
        } catch (SmartLogicException | Exception e) {
        if(EBM != null) EBM.log("MTE having not right status", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
        MaReturnPayload.setErrorState(uuid, false,e.getMessage() );
        sendMaResponseToTMS(MaReturnPayload, 2L);
        if(EBM != null) EBM.log("SL ELement-Reservation FAIL; TrainId: " + iTrainId + "UUID: " + uuid.toString(),
                SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
        return;

    }

        ETCS_DISTANCE NoDistance = new ETCS_DISTANCE();
        NoDistance.sDistance = 0;
        // neuer occupation constructor
        NID_ENGINE nid_engine = new NID_ENGINE(iTrainId);
        // mo == null wird in setTrainForStartPositionOfRoute checked, so dass es nicht null sein kann
        MovableObject mo = MovableObject.ObjectRepo.getModel(nid_engine);
        MovementAuthority movementAuthority = new MovementAuthority();
        movementAuthority.setMOB(mo);
        MARequestOccupation MAO = new MARequestOccupation(requestedTrackElementList,movementAuthority, true );

        boolean isRouteNotBlocked = Safety.checkIfRouteIsNonBlocked(MAO);

        if(!isRouteNotBlocked) {
            if(EBM != null) EBM.log("Route is not drivable", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));

            MaReturnPayload.setErrorState(uuid, false,ELEMENT_RESERVATION_ERROR );
            sendMaResponseToTMS(MaReturnPayload, 2L);
            if(EBM != null) EBM.log("SL ELement-Reservation FAIL - Route is blocked; TrainId: " + iTrainId +
                            "UUID: " + uuid.toString(),
                    SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
            return;
        }





        try {
            if(EBM != null) EBM.log("Before Route creating occupation length: "
                            + requestedTrackElementList.getRouteLength(),
                    SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
            MAO = (MARequestOccupation) requestedTrackElementList.createSubRoute(NoDistance, NoDistance, 1, MAO);
            if(EBM != null) EBM.log("Reserved Occupation Length: " + MAO.getMeterLength().doubleValue(),
                    SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
            if(EBM != null) EBM.log("Route Length: " + requestedTrackElementList.getRouteLength(),
                    SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
            if(
                    requestedTrackElementList.getRouteLength().subtract(MAO.getMeterLength()).abs().
                            compareTo(BigDecimal.valueOf(1.0d))
                    > 0) {
                System.err.println("ERROR, occupation is not as long as requested");
            }
        } catch (SmartLogicException e) {
            e.printStackTrace();
            MAO = null;
        }

        //Weichenstatus abgleichen
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
        /*
        bRouteElementAreTheRightOnes = Safety.checkIfRouteIsContinuousConnected(iTrainId, R, requestedTrackElementList);
        bRouteElementAreTheRightOnes = true;
        if(!bRouteElementAreTheRightOnes) {
            if(EBM != null) EBM.log("FAIL Route is not continuous connected. TrainId-> " + iTrainId + "UUID-> " + uuid.toString(), SafetyLogic.TRACK_SAFETY );
            MaReturnPayload.setErrorState(uuid, true,NOT_ALL_ELEMENTS_GIVEN_FOR_RESERVATION_ERROR );
            sendMaResponseToTMS(MaReturnPayload, 2L);
            return;
        } else if(EBM != null) EBM.log("SUCCESSFUL Route is continuous connected. TrainId-> " + iTrainId + "UUID-> " + uuid.toString(), SafetyLogic.TRACK_SAFETY );
        */
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


        sendAcknowledgementToRBC(iTrainId, R, uuid, lPriority, MaReturnPayload, bAcknowledgeMA, requestedTrackElementList, RbcMa, MAO, nid_engine_Id, MaMsg);

    }

    private void checkMteStatus(ComposedRoute requestedTrackElementList) throws SmartLogicException {



            ArrayList<Waypoint> ewWaypoints = new ArrayList<>(requestedTrackElementList.waypointsBetweentTwoTrackEdges.getAll());
            for (Waypoint w : ewWaypoints) {
                TrackElementStatus neededStatus = w.getNecessaryElementStatus();
                MoveableTrackElement MTE = w.getTrackElement();

                if (neededStatus.statusList.size() > MTE.getCurrentStatus().statusList.size()) {
                    throw new SmartLogicException(SmartServer4TmsImpl.MTE_HAS_NOT_REQUIERED_STATUS);
                }

                for (int i = 0; i < neededStatus.statusList.size(); i++) {

                    if(!neededStatus.statusList.get(i).equals(MTE.getCurrentStatus().statusList.get(i))) {
                        printError(requestedTrackElementList.waypointsBetweentTwoTrackEdges, w);


                        throw new SmartLogicException(SmartServer4TmsImpl.MTE_HAS_NOT_REQUIERED_STATUS);
                    }
                }

            }





    }

    private void printError(DefaultRepo<Pair<String, String>, Waypoint> waypointsBetweentTwoTrackEdges, Waypoint w) {

        for(Pair<String, String> locationBetweenEdges : waypointsBetweentTwoTrackEdges.getKeys()) {
            if(w.equals(waypointsBetweentTwoTrackEdges.getModel(locationBetweenEdges))) {
                String sError = "Switch Waypoint having wrong status at between: "
                        + locationBetweenEdges.getLeft() + " and " + locationBetweenEdges.getRight();
                EventBusManager.RootEventBusManger.log(sError, SMART_SERVER_MA_MODUL);
                System.err.println("Switch Waypoint having wrong status at between: "
                        + locationBetweenEdges.getLeft() + " and " + locationBetweenEdges.getRight());
                break;
            }
        }


    }

    private void sendAcknowledgementToRBC(int iTrainId, Route R, UUID uuid, Long lPriority, MaRequestReturnPayload MaReturnPayload, Boolean bAcknowledgeMA, ComposedRoute requestedTrackElementList, MA RbcMa, MARequestOccupation MAO, int nid_engine_Id, Message_21 MaMsg) {
        bAcknowledgeMA = acknowledge(uuid, requestedTrackElementList, lPriority, bAcknowledgeMA, MaMsg);
        if(bAcknowledgeMA == null) bAcknowledgeMA = false;
        if(bAcknowledgeMA) {
            handleMaAckReceived(iTrainId, R, uuid, MaReturnPayload, requestedTrackElementList, RbcMa, MAO, nid_engine_Id);
        } else {
            handleInvalidRequest(uuid, MaReturnPayload, NO_ACK);
        }
    }

    private Boolean acknowledge(UUID uuid, ComposedRoute CompRoute, Long lPriority, Boolean bAcknowledgeMA, Message_21 MaMsg)
                        throws InvalidParameterException {
        ILinkingIntf etcsLinkingModule = this.getEtcsLinkingModule();
        ArrayList<TrackPacket> trackPackets = new ArrayList<>();
        Payload_21 P = MaMsg.getPayload();
        int nid_lrbg = P.ma.nid_lrbg;
        Packet_21 GradientProfilePacket = null;
        Packet_80 ModeProfilePacket = null;
        Packet_27 SpeedProfile = null;
        Packet_5 LinkingPacket = etcsLinkingModule.generateLinkingByRoute(CompRoute, nid_lrbg);
        GradientProfilePacket = Converter.convertGradientProfile(P.ma.gradientProfile);
        
        trackPackets.add(GradientProfilePacket);

        ModeProfilePacket = Converter.convertModeProfile(P.ma.modeProfile);
        trackPackets.add(ModeProfilePacket);

        SpeedProfile = Converter.convertSpeedProfile(P.ma.speedProfile);
        trackPackets.add(SpeedProfile);

        if(LinkingPacket != null) {
            trackPackets.add(LinkingPacket);
        }



        int q_dir = P.ma.q_dir;
        int q_scale = P.ma.q_scale;
        int v_loa = P.ma.eoa.v_loa;
        int t_loa = P.ma.eoa.t_loa;
        boolean q_endtimer = P.ma.eoa.endTimer != null;
        boolean q_dangerpoint = P.ma.eoa.dangerPoint != null;
        boolean q_overlap = P.ma.eoa.overlap != null;
        int t_endtimer = 0;
        int d_endtimerstartloc = 0;
        int d_DP = 0;
        int v_release_DP = 0;
        int d_startol = 0;
        int t_ol = 0;
        int d_ol = 0;

        int v_release_ol = 0;

        if(q_endtimer) {
            t_endtimer = P.ma.eoa.endTimer.t_endtimer;
            d_endtimerstartloc = P.ma.eoa.endTimer.d_endtimerstartloc;
        }

        if(q_dangerpoint) {
            d_DP = P.ma.eoa.dangerPoint.d_dp;
            v_release_DP = P.ma.eoa.dangerPoint.v_releasedp;
        }

        if(q_overlap) {
            d_startol = P.ma.eoa.overlap.d_startol;
            t_ol = P.ma.eoa.overlap.t_ol;
            d_ol = P.ma.eoa.overlap.d_ol;
            v_release_ol = P.ma.eoa.overlap.v_releaseol;
        }

        Packet_15.Packet_15_Section endSection = null;
        try {
            endSection = new Packet_15.Packet_15_Section(CompRoute.getRouteLength().intValue(),
                    false,1,1);
        } catch (SmartLogicException e) {
            throw new InvalidParameterException("Route Length was not available: " + e.getMessage());
        }
        Packet_15 MaPacket = new Packet_15(q_dir, q_scale, v_loa, t_loa, endSection, q_endtimer,
                    t_endtimer, d_endtimerstartloc, q_dangerpoint, d_DP, v_release_DP,
                    q_overlap, d_startol, t_ol, d_ol, v_release_ol);


        // dnager t_train is functional unknown therefore null
        long t_train = 0;
        boolean isRequestingAck = false;

        ebd.messageLibrary.message.trackmessages.Message_3 MaContent =
                new Message_3(t_train, isRequestingAck, nid_lrbg, MaPacket);
        MaContent.packets = trackPackets;
        ebd.rbc_tms.message.tms.ETCSTrackMessage EtcsMa =
                new ETCSTrackMessage(Integer.parseInt(MaMsg.header.tms_id), Integer.parseInt(MaMsg.header.rbc_id),
                        P.nid_engine, MaContent);

        PriorityMessage priorityMessage = new PriorityMessage(EtcsMa, lPriority);
        ackQueues.createQueue(uuid);

        this.RbcClient.sendMessage(priorityMessage);
        bAcknowledgeMA = true;//ackQueues.poll(uuid);

        return bAcknowledgeMA;
    }







    private boolean setTrainForStartPositionOfRoute(int iTrainId, UUID uuid, MaRequestReturnPayload MaReturnPayload, RbcMaAdapter MaAdapter, ComposedRoute requestedTrackElementList) {
        PositionModul.getInstance().resetTimeFilter();
        PositionData TrainPosition = PositionModul.getInstance().getCurrentPosition(iTrainId);
        MovableObject mo = MovableObject.ObjectRepo.getModel(new NID_ENGINE(iTrainId));

        if(TrainPosition == null || TrainPosition.getPos() == null || mo == null) {
            if(EBM != null) EBM.log("Train Position Unknown", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
            MaReturnPayload.setErrorState(uuid, false,NO_TRAIN_INFORMATION );
            sendMaResponseToTMS(MaReturnPayload, 2L);
            if(EBM != null) EBM.log("SL Train-Status FAIL; TrainId: " + iTrainId + "UUID: " + uuid.toString(),
                    SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
            return false;
        } else {
            if(MaAdapter.nid_lrbg != TrainPosition.getPos().nid_lrbg) {
                if(EBM != null) EBM.log("Train Position Unknown (REFERRED BALISE CHANGED)", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
                MaReturnPayload.setErrorState(uuid, false,NO_TRAIN_INFORMATION );
                sendMaResponseToTMS(MaReturnPayload, 2L);
                if(EBM != null) EBM.log("SL Train-Status (REFERRED BALISE CHANGED) FAIL; TrainId: " + iTrainId + "UUID: " + uuid.toString(),
                        SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));
                return false;
            } else {
                // TODO ????!!!
                return true;
            }
        }
    }

    private void handleMaAckReceived(int iTrainId, Route R, UUID uuid, MaRequestReturnPayload MaReturnPayload,  ComposedRoute requestedTrackElementList, MA RbcMa, MARequestOccupation MAO, int nid_engine_Id) {
        try {
            TrackAndOccupationManager.transferMaRequestBlockListIntoRealBlockList(iTrainId, MAO, RbcMa, R, requestedTrackElementList);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            if(EBM != null)
                EBM.log("Ma Check has failure: " + e.getMessage(), SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));


        }

        serveValidMa(uuid, MaReturnPayload, requestedTrackElementList, nid_engine_Id);
    }

    private void serveValidMa(UUID uuid, MaRequestReturnPayload MaReturnPayload, ComposedRoute requestedTrackElementList, int nid_engine_Id) {
        MaReturnPayload.setMaSuccessfull(uuid);
        if(requestedTrackElementList != null) {
            PositionModul.getInstance().updateCurrentRoute(nid_engine_Id, requestedTrackElementList);
        }
        sendMaResponseToTMS(MaReturnPayload, 3L);
    }

    private void handleInvalidRequest(UUID uuid, MaRequestReturnPayload maReturnPayload, String errorReason) {

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
        svlLocation.setNetElementRef(r.getLastEdge().getId());

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
    private ComposedRoute identifyRouteElements(int iTrainId, Route R, ComposedRoute requestedTrackElementList) throws SmartLogicException {

            requestedTrackElementList.generateFromRoute(R, iTrainId);
            EventBusManager.RootEventBusManger.log("Composed Route Length after generate from Route: " +
                    requestedTrackElementList.getRouteLength(), ROUTE_COMPONENTS_IDENTIFY);
            return requestedTrackElementList;


    }


/*
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



    }
    */


















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
