package ebd;

import de.disposim.dbd.io.SessionClosedException;
import de.disposim.dbd.packet.IllegalNameLengthException;
import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.tms.ma.physical.MoveableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.plan.NodeInformation;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.ThreadedRepo;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.ibw.sessions.TescSession;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrAnlage;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.ENUMWKrArt;

import java.io.IOException;
import java.net.Socket;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

/**
 * Interaktion mit dem EBD Stellwerk oder sp&auml;ter weiteren Stellelemente
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.11
 * @since 2021-03-12
 */
public class TescModul {

    private static TescModul instance;

    private static String MODULE_NAME = "TESC-MODULE";

    public interface MoveableTrackElementAccess {
        /**
         * Moveable Track Element by Id 11W12 usw.
         * DKWs retrieved by Lowest Index of DKW
         * @param sId String id of MTE
         * @return MoveableTrackElement result
         */
        static MoveableTrackElement getElementById(String sId) {
            MoveableTrackElement Result = ElementStateByIdRepository.getModel(sId);
            if(Result == null) Result = DkwStateByRepo.getModel(sId);
            return Result;
        }

        /**
         * only searches in dkw
         * @param sLowerDkw String - like 11W12
         * @return MoveableTrackElement DKW MoveableTrackElement
         */
        static MoveableTrackElement getDkwById(String sLowerDkw) {
            return DkwStateByRepo.getModel(sLowerDkw);
        }

        static boolean isSidDkw(String sId) {
            if(DkwStateByRepo.getModel(sId) != null) return true;
            if(TescModul.getInstance().getParellelLowerEbdId.getModel(sId) != null) return true;
            return false;
        }


    }

    /**
     * Singleton
     * @return TescModul
     */
    public static TescModul getInstance() {
        if(instance == null) instance = new TescModul();
        return instance;
    }

    private TescSession Session;

    public void setSession(TescSession S) {
        Session = S;
    }

    private static ThreadedRepo<String, MoveableTrackElement> ElementStateByIdRepository;
    private static ThreadedRepo<String, MoveableTrackElement> DkwStateByRepo;
    private ThreadedRepo<String, Integer> StateChangesNotFound;
    public ThreadedRepo<String, String> getParellelLowerEbdId;

    private TescModul() {
        ElementStateByIdRepository = new ThreadedRepo<>();
        DkwStateByRepo = new ThreadedRepo<>();
        StateChangesNotFound = new ThreadedRepo<>();
        getParellelLowerEbdId = new ThreadedRepo<>();
    }

    /**
     * changes state of switch,
     * throws exception when operation controller cannot perform request
     * @param sId String - 11W45 for instances a valid switch shortage
     * @param switchStatus {@link TrackElementStatus} - status switch shall after changement
     * @return boolean - true for operation successful, even when the switch state has been the same than requested
     *                  - false, when requested status is not possible for switch
     * @throws IOException
     * @throws SessionClosedException
     * @throws IllegalNameLengthException
     */
    public boolean setState(String sId, TrackElementStatus switchStatus) throws IOException, SessionClosedException, IllegalNameLengthException {
        // Set Ist Lage "I" in Debug Moduls, sonst Sollage "S"
        String sPostfix = SlConfigHandler.getInstance().useInfrastructureServer ? "S" : "I";
        String dbdId = sId + sPostfix;
        if(ElementStateByIdRepository.containsKey(sId)) {
            MoveableTrackElement EwElement = ElementStateByIdRepository.getModel(sId);
            if(EwElement.getListOfPossibleStatus().contains(switchStatus)) {
                startTescSession();
                setStateOnInfrastructure(switchStatus, dbdId, 0);
                return true;
            } else return false;
        } else if(DkwStateByRepo.containsKey(sId)) {
            MoveableTrackElement DkwElement = DkwStateByRepo.getModel(sId);
            NodeInformation NI = ISwitchHandler.getNodeInfoBySwitchId(sId);
            if (NI == null) {
                EventBusManager.RootEventBusManger.
                        log("Dkw related Nodes for " + sId + " not found", SmartLogic.getsModuleId(MODULE_NAME));
                return false;
            }
            TopologyGraph.Node N1 = NI.get(0);
            CrossingSwitch CS_Refered = null;
            for (TopologyGraph.Node N : NI) {
                CrossingSwitch CS = (CrossingSwitch) N.NodeImpl;
                if (sId.endsWith(String.valueOf(CS.getLocalElementId()))) {
                    CS_Refered = CS;
                }
            }
            if (CS_Refered == null) {
                EventBusManager.RootEventBusManger.
                        log("Dkw related Nodes for " + sId + " not found", SmartLogic.getsModuleId(MODULE_NAME));

                return false;
            }


            CrossingSwitch LowerSwitch = CS_Refered;
            CrossingSwitch HigherSwitch = CS_Refered;
            String sLower;
            String sHigher;
            for(TopologyGraph.Node N : NI) {
                CrossingSwitch CS = (CrossingSwitch) N.NodeImpl;
                // only diff ids are relevant
                if(Math.abs(LowerSwitch.getLocalElementId() - CS.getLocalElementId()) == 0) continue;
                // neighbouring ok
                if(LowerSwitch.getLocalElementId() > CS.getLocalElementId()) {
                    HigherSwitch = LowerSwitch;
                    LowerSwitch = CS;
                    break;
                } else if (HigherSwitch.getLocalElementId() < CS.getLocalElementId()) {
                    LowerSwitch = HigherSwitch;
                    HigherSwitch = CS;
                    break;
                }
            }

            sLower = LowerSwitch.getEbdTitle(0,false, true) + sPostfix;
            sHigher = HigherSwitch.getEbdTitle(0,false,true) + sPostfix;

            if(DkwElement.getListOfPossibleStatus().contains(switchStatus)) {
                startTescSession();
                setStateOnInfrastructure(switchStatus, sLower, 0);
                setStateOnInfrastructure(switchStatus, sHigher, 1);
                return true;
            } else return false;
        } else {
            EventBusManager.RootEventBusManger.
                    log("Switch for " + sId + " not found", SmartLogic.getsModuleId(MODULE_NAME));
            return false;
        }



    }

    private void setStateOnInfrastructure(TrackElementStatus switchStatus, String dbdId, int index) throws IOException, SessionClosedException, IllegalNameLengthException {
        switch (switchStatus.statusList.get(index)) {
            case UNKNOWN -> {
                Session.set(dbdId, 0);
            }
            case LEFT -> {
                Session.set(dbdId, 1);
            } case RIGHT -> {
                Session.set(dbdId, 2);
            }
        }
    }

    /**
     * Input bei Tesc-Session des EBD-Anlagen-Control-Server
     * @param dbdId
     * @param state
     * @return
     */
    public boolean putNewState(String dbdId, int state) {
        EventBusManager.RootEventBusManger.
                log("New State: " + state + "entered for: " + dbdId, SmartLogic.getsModuleId(MODULE_NAME));
        guardState(state);
        String idKey = dbdId.replace("I", ""); // interface commits is-Value with I as postfix
        if(ElementStateByIdRepository.containsKey(idKey)) {
            handleEw(state, idKey);
        } else if(DkwStateByRepo.containsKey(idKey)) {
           NodeInformation NI = ISwitchHandler.getNodeInfoBySwitchId(idKey);
           if(NI == null) {
               StateChangesNotFound.update(idKey, state);
               String sLowerKey = getParellelLowerEbdId.getModel(dbdId);
               Integer state1 = StateChangesNotFound.getModel(sLowerKey);
               TrackElementStatus CurrentStatus = new TrackElementStatus();
               if(state1 != null) {
                   if(state1 == 0 && state == 0) {
                      return handleBothStateUnknown(sLowerKey, CurrentStatus);
                   } else {
                       return handleDkwState(state1, sLowerKey, state, CurrentStatus);
                   }
               }
           } else {
               TopologyGraph.Node N1 = NI.get(0);
               TopologyGraph.Node N2 = NI.get(1);
               CrossingSwitch S1 = (CrossingSwitch) N1.NodeImpl;
               CrossingSwitch LowerSwitch = S1;
               CrossingSwitch HigherSwitch = S1;

               for(TopologyGraph.Node N : NI) {
                   CrossingSwitch CS = (CrossingSwitch) N.NodeImpl;
                   if(LowerSwitch.getLocalElementId() > CS.getLocalElementId()) {
                       HigherSwitch = LowerSwitch;
                       LowerSwitch = CS;
                       break;
                   } else if (HigherSwitch.getLocalElementId() < CS.getLocalElementId()) {
                       LowerSwitch = HigherSwitch;
                       HigherSwitch = CS;
                       break;
                   }
               }
               String sHighKey = HigherSwitch.getEbdTitle(0, false, true);
               String sLowKey = LowerSwitch.getEbdTitle(0,false, true);
               StateChangesNotFound.update(sLowKey, state);

               getParellelLowerEbdId.update(sHighKey, sLowKey);
               Integer state2 = StateChangesNotFound.getModel(sHighKey);
               TrackElementStatus CurrentStatus = new TrackElementStatus();
               if(state2 == null) state2 = 0;

               if(state == 0 && state2 == 0) {
                       return handleBothStateUnknown(sLowKey, CurrentStatus);
               } else {
                       return handleDkwState(state, sLowKey, state2, CurrentStatus);

               }

           }
        } else {
            String sLowKey = getParellelLowerEbdId.getModel(idKey);
            StateChangesNotFound.update(idKey, state);
            if(sLowKey != null) {
                TrackElementStatus CurrentStatus = new TrackElementStatus();
                int state2 = state;
                Integer intState1 = StateChangesNotFound.getModel(sLowKey);
                if(intState1 != null) {
                    return handleDkwState(intState1, sLowKey, state2, CurrentStatus);
                }
            }
        }
        return false;
    }

    private boolean handleBothStateUnknown(String idKey, TrackElementStatus currentStatus) {

        MoveableTrackElement MTE = DkwStateByRepo.getModel(idKey);

        MTE.setCurrentStatus(currentStatus);
        DkwStateByRepo.update(idKey, MTE);
        EventBusManager.RootEventBusManger.
                log("Both state unknowwn for ID: " + idKey + " so set unknown.",
                        SmartLogic.getsModuleId(MODULE_NAME));
        return true;
    }

    private boolean handleDkwState(int state, String idKey, Integer state2, TrackElementStatus currentStatus) {
        if(state == 0 || state2 == 0) {
            return false;
        } else {
            handleState(state, currentStatus, 0);
            handleState(state2, currentStatus, 1);
            MoveableTrackElement MTE = DkwStateByRepo.getModel(idKey);
            MTE.setCurrentStatus(currentStatus);
            DkwStateByRepo.update(idKey, MTE);
            EventBusManager.RootEventBusManger.
                    log("DKW: " + idKey + "set to states: " + state + ", " + state2,
                            SmartLogic.getsModuleId(MODULE_NAME));
            return true;

        }
    }

    private void handleEw(int state, String idKey) {
        MoveableTrackElement MTE = ElementStateByIdRepository.getModel(idKey);
        TrackElementStatus NewState = new TrackElementStatus();
        handleState(state, NewState, 0);
        if(MTE.getListOfPossibleStatus().contains(NewState)) {
            MTE.setCurrentStatus(NewState);
            ElementStateByIdRepository.update(idKey, MTE);
        } else {
            // handle Security measurements -> smartLogic

            MTE.setCurrentStatus(NewState);
            ElementStateByIdRepository.update(idKey, MTE);
        }
        EventBusManager.RootEventBusManger.
                log("EW: " + idKey + "set to state: " + state ,SmartLogic.getsModuleId(MODULE_NAME));
    }

    private void handleState(int state, TrackElementStatus newState,int index) {
        if(newState == null) newState = new TrackElementStatus();
            while(index >= newState.statusList.size()) {
                newState.statusList.add(TrackElementStatus.Status.UNKNOWN);
            }
        switch (state) {
            case 0 -> {

                newState.statusList.set(index,TrackElementStatus.Status.UNKNOWN);

            }
            case 1 -> {
                newState.statusList.set(index, TrackElementStatus.Status.LEFT);

            }
            case 2 -> {
                newState.statusList.set(index, TrackElementStatus.Status.RIGHT);

            }
            default -> {
                throw new InvalidParameterException("Switch states by Interfaces must be in [0-2].");
            }
        }
    }

    private void guardState(int state) {
        if(state != 0 && state != 1 && state != 2) {
            throw new InvalidParameterException("Switch states by Interfaces must be in [0-2].");
        }
    }

    public void fetchIntialState() throws IOException {

        EventBusManager.RootEventBusManger.
                log("Tesc-Module: Fetch Initial State",SmartLogic.getsModuleId(MODULE_NAME));
        ArrayList<String> watchedEbdIds = new ArrayList<>();
        initialiseWithUnknown();

        startTescSession();

        watchedEbdIds.addAll(this.ElementStateByIdRepository.getKeys());

        System.out.println("WatchSize: " + watchedEbdIds.size());
        subscribeAllScoped(watchedEbdIds);
        subscribeDKW(this.DkwStateByRepo.getKeys());

        queryAllScoped(watchedEbdIds);

        System.out.println("Tesc-Module initiated successfully");

    }

    private void subscribeDKW(ArrayList<String> dkwKeys) {
        for(String sEbdId : dkwKeys) {
            System.out.println("Subscribed DKW: " + sEbdId + "I");

            NodeInformation NI = ISwitchHandler.getNodeInfoBySwitchId(sEbdId);

            for(TopologyGraph.Node N : NI) {
                CrossingSwitch CS = (CrossingSwitch) N.NodeImpl;
                try {
                    String ebdSubs = CS.getEbdTitle(0,false, true) + "I";
                    Session.subscribe(ebdSubs);
                    Session.query(ebdSubs);
                    System.out.println("DKW Subelment Subscribed: " + ebdSubs);
                } catch (InterruptedException | ExecutionException | SessionClosedException | IllegalNameLengthException | IOException e) {
                    e.printStackTrace();
                }
            }



        }

    }

    private void queryAllScoped(ArrayList<String> watchedEbdIds) throws IOException {
        for(String sEbdId : watchedEbdIds) {
            try {
                Session.query(sEbdId + "I");
            } catch (InterruptedException | ExecutionException | SessionClosedException | IllegalNameLengthException e) {
                e.printStackTrace();
            }
        }
    }

    private void subscribeAllScoped(ArrayList<String> watchedEbdIds) throws IOException {
        for(String sEbdId : watchedEbdIds) {
            try {
                Session.subscribe(sEbdId + "I");
                System.out.println("Subscribed: " + sEbdId + "I");
            } catch (InterruptedException | ExecutionException | SessionClosedException | IllegalNameLengthException e) {
                e.printStackTrace();
            }
        }
    }

    private void startTescSession() throws IOException {
        if(Session == null) {
            String sHost;
            int iPort = SlConfigHandler.getInstance().portOfInfrastructureServer;
            if (!SlConfigHandler.getInstance().useInfrastructureServer) {
                sHost = "localhost";

            } else {
                sHost = SlConfigHandler.getInstance().ipToInfrastructureServer;

            }

            Session = new TescSession(new Socket(sHost, iPort));
            Session.start();
        }

    }

    private void initialiseWithUnknown() {
        ThreadedRepo<CWKrAnlage, ArrayList<CrossingSwitch>> switchRepository = ISwitchHandler.getAllSwitches();
        ArrayList<CrossingSwitch> switchListByAnlage = null;
        int iOperationTime = SlConfigHandler.getInstance().defaultOperationTime;
        Iterator<ArrayList<CrossingSwitch>> it = switchRepository.getAll().iterator();
        while(it.hasNext()) {
            switchListByAnlage = it.next();
            CrossingSwitch Switch = switchListByAnlage.get(0);
            if(Switch.getAnlage().getWKrAnlageAllg().getWKrArt().getWert().equals(ENUMWKrArt.EW)) {
                TrackElementStatus CurrentStatus = new TrackElementStatus();
                CurrentStatus.statusList.add(TrackElementStatus.Status.UNKNOWN);
                String sLabel = Switch.getEbdTitle(0,false, true);
                MoveableTrackElement MTE = MoveableTrackElement.genmMoveableElementFactory(sLabel, iOperationTime,
                        null, null, null,
                        MoveableTrackElement.getEwPossibleStates(), CurrentStatus, Switch);

                if(ISwitchHandler.getNodeInfoBySwitchId(sLabel) != null) {
                    TopologyGraph.Node N = ISwitchHandler.getNodeInfoBySwitchId(sLabel).get(0);
                    if(N.getSwitchUI() != null) {
                        MTE.setSwitchUI(N.getSwitchUI());
                    }
                };

                ElementStateByIdRepository.update(sLabel, MTE);
                System.out.println("EW_Lable" + sLabel);
            } else if(Switch.isDKW()) {
                System.out.println("DKW size = " + switchListByAnlage.size());
                int iSmallestId = Switch.getLocalElementId();
                CrossingSwitch CsSmall = Switch;
                for (CrossingSwitch CS : switchListByAnlage) {
                    int iCurrentId = CS.getLocalElementId();
                    if(iSmallestId > iCurrentId) {
                        iSmallestId = iCurrentId;
                        CsSmall = CS;
                    }
                }
                TrackElementStatus CurrentStatus = new TrackElementStatus();
                CurrentStatus.statusList.add(TrackElementStatus.Status.UNKNOWN);
                CurrentStatus.statusList.add(1,TrackElementStatus.Status.UNKNOWN);
                String sLabel = CsSmall.getEbdTitle(0,false,true);
                MoveableTrackElement MTE = MoveableTrackElement.genmMoveableElementFactory(sLabel, iOperationTime,
                        null, null, null,
                        MoveableTrackElement.getDkwPossibleStates(), CurrentStatus, Switch);
                DkwStateByRepo.update(sLabel, MTE);
                System.out.println("DKW_Lable" + sLabel);


            }

        }
    }



}
