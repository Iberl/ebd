package de.ibw.smart.logic.intf.impl;

import de.ibw.history.PositionModul;
import de.ibw.history.data.RouteDataSL;
import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.datatypes.QueueUuidMapper;
import de.ibw.smart.logic.intf.*;
import de.ibw.smart.logic.intf.messages.MaRequestReturnPayload;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.smart.logic.safety.SafetyLogic;
import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.ma.RbcMaAdapter;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.Waypoint;
import de.ibw.tms.ma.common.NetworkResource;
import de.ibw.tms.ma.physical.ITrackElement;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.plan.NodeInformation;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan.elements.interfaces.ITrack;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import ebd.rbc_tms.message.Message_21;
import ebd.rbc_tms.payload.Payload_21;
import ebd.rbc_tms.util.EOA;
import ebd.rbc_tms.util.MA;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

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
        RbcMaAdapter MaAdapter = (RbcMaAdapter) Ma;
        MaRequestReturnPayload MaReturnPayload = new MaRequestReturnPayload();
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
        RouteDataSL requestedTrackElementList = new RouteDataSL();
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
        bIsOccupatonFree = Safety.checkIfRouteIsNonBlocked(iTrainId, R, MaAdapter,requestedTrackElementList);
        /**To Debug **/
        bIsOccupatonFree = true;
        if(bIsOccupatonFree) if(EBM != null) EBM.log("Route is drivable", SmartLogic.getsModuleId(SMART_SERVER_MA_MODUL));


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
            MA RbcMa = MaAdapter.convertToRbcMA();
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
            MaReturnPayload.setMaSuccessfull(uuid);
            PositionModul.getInstance().updateCurrentRoute(nid_engine_Id, requestedTrackElementList);
            sendMaResponseToTMS(MaReturnPayload, 3L);
        } else {
            MaReturnPayload.setErrorState(uuid,true, NO_ACK);
            sendMaResponseToTMS(MaReturnPayload, 2L);
        }

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
    private RouteDataSL identifyRouteElements(Route R, RouteDataSL requestedTrackElementList) {
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

                       throw new NullPointerException("Some elements cannot be Identifed");
                   }

                    TePair = new ImmutablePair<>(Route.TrackElementType.RAIL_TYPE, E);



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


        } catch(Exception E) {
            E.printStackTrace();
            return null;
        }

        return requestedTrackElementList;
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
