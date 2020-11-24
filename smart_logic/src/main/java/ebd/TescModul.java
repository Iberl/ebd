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
 * @version 0.4
 * @since 2020-11-23
 */
public class TescModul {

    private static TescModul instance;

    private static String MODULE_NAME = "TESC-MODULE";


    /**
     * Singleton
     * @return TescModul
     */
    public static TescModul getInstance() {
        if(instance == null) instance = new TescModul();
        return instance;
    }

    private TescSession Session;

    private ThreadedRepo<String, MoveableTrackElement> ElementStateByIdRepository;
    private ThreadedRepo<String, MoveableTrackElement> DkwStateByRepo;
    private ThreadedRepo<String, Integer> StateChangesNotFound;
    private ThreadedRepo<String, String> getParellelLowerEbdId;

    private TescModul() {
        ElementStateByIdRepository = new ThreadedRepo<>();
        DkwStateByRepo = new ThreadedRepo<>();
        StateChangesNotFound = new ThreadedRepo<>();
        getParellelLowerEbdId = new ThreadedRepo<>();
    }

    public boolean setState(String sId, TrackElementStatus switchStatus) throws IOException, SessionClosedException, IllegalNameLengthException {
        // Set Ist Lage "I" in Debug Moduls, sonst Sollage "S"
        String sPostfix = ConfigHandler.getInstance().useInfrastructureServer ? "S" : "I";
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
            NodeInformation NI = ISwitchHandler.getNodeInfoBySwitchId(dbdId);
            if(NI == null) {
                EventBusManager.registerOrGetBus(1,false).
                        log("Dkw related Nodes for " + sId + " not found", SmartLogic.getsModuleId(MODULE_NAME));
                return false;
            }
            TopologyGraph.Node N1 = NI.get(0);
            TopologyGraph.Node N2 = NI.get(1);
            CrossingSwitch S1 = (CrossingSwitch) N1.NodeImpl;
            CrossingSwitch S2 = (CrossingSwitch) N2.NodeImpl;
            String sLower;
            String sHigher;
            if(S1.getLocalElementId() < S2.getLocalElementId()) {
                sLower = S1.getEbdTitle(0,false, true);
                sHigher = S2.getEbdTitle(0,false,true);
            } else {
                sLower = S2.getEbdTitle(0,false, true);
                sHigher = S1.getEbdTitle(0,false,true);
            }
            if(DkwElement.getListOfPossibleStatus().contains(switchStatus)) {
                startTescSession();
                setStateOnInfrastructure(switchStatus, sLower, 0);
                setStateOnInfrastructure(switchStatus, sHigher, 1);
                return true;
            } else return false;
        } else {
            EventBusManager.registerOrGetBus(1,false).
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
        try {
            EventBusManager.registerOrGetBus(1,false).
                    log("New State: " + state + "entered for: " + dbdId, SmartLogic.getsModuleId(MODULE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        guardState(state);
        String idKey = dbdId.replace("I", ""); // interface commits is-Value with I as postfix
        if(ElementStateByIdRepository.containsKey(idKey)) {
            handleEw(state, idKey);
        } else if(DkwStateByRepo.containsKey(dbdId)) {
           NodeInformation NI = ISwitchHandler.getNodeInfoBySwitchId(dbdId);
           if(NI == null) {
               StateChangesNotFound.update(dbdId, state);
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
               CrossingSwitch S2 = (CrossingSwitch) N2.NodeImpl;
               CrossingSwitch LowerSwitch;
               CrossingSwitch HigherSwich;
               if(S1.getLocalElementId() < S2.getLocalElementId()) {

                   HigherSwich = S2;
               } else {

                   HigherSwich = S1;
               }
               String sHighKey = HigherSwich.getEbdTitle(0, false, true);
               StateChangesNotFound.update(idKey, state);
               getParellelLowerEbdId.update(sHighKey, dbdId);
               Integer state2 = StateChangesNotFound.getModel(sHighKey);
               TrackElementStatus CurrentStatus = new TrackElementStatus();

               if(state2 != null) {
                   if(state == 0 && state2 == 0) {
                       return handleBothStateUnknown(idKey, CurrentStatus);
                   } else {
                       return handleDkwState(state, idKey, state2, CurrentStatus);

                   }
               }
           }
        } else {
            StateChangesNotFound.update(dbdId, state);
        }
        return false;
    }

    private boolean handleBothStateUnknown(String idKey, TrackElementStatus currentStatus) {
        currentStatus.statusList.add(TrackElementStatus.Status.UNKNOWN);
        currentStatus.statusList.add(1, TrackElementStatus.Status.UNKNOWN);
        MoveableTrackElement MTE = ElementStateByIdRepository.getModel(idKey);

        MTE.setCurrentStatus(currentStatus);
        ElementStateByIdRepository.update(idKey, MTE);
        try {
            EventBusManager.registerOrGetBus(1,false).
                    log("Both state unknowwn for ID: " + idKey + " so set unknown.",
                            SmartLogic.getsModuleId(MODULE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean handleDkwState(int state, String idKey, Integer state2, TrackElementStatus currentStatus) {
        if(state == 0 || state2 == 0) {
            return false;
        } else {
            handleState(state, currentStatus, 0);
            handleState(state2, currentStatus, 1);
            MoveableTrackElement MTE = ElementStateByIdRepository.getModel(idKey);
            MTE.setCurrentStatus(currentStatus);
            ElementStateByIdRepository.update(idKey, MTE);
            try {
                EventBusManager.registerOrGetBus(1,false).
                        log("DKW: " + idKey + "set to states: " + state + ", " + state2,
                                SmartLogic.getsModuleId(MODULE_NAME));
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        try {
            EventBusManager.registerOrGetBus(1,false).
                    log("EW: " + idKey + "set to state: " + state ,SmartLogic.getsModuleId(MODULE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleState(int state, TrackElementStatus newState,int index) {
        switch (state) {
            case 0 -> {
                newState.statusList.add(index,TrackElementStatus.Status.UNKNOWN);

            }
            case 1 -> {
                newState.statusList.add(index, TrackElementStatus.Status.LEFT);

            }
            case 2 -> {
                newState.statusList.add(index, TrackElementStatus.Status.RIGHT);

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

        try {
            EventBusManager.registerOrGetBus(1,false).
                    log("Tesc-Module: Fetch Initial State",SmartLogic.getsModuleId(MODULE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> watchedEbdIds = new ArrayList<>();
        initialiseWithUnknown();

        startTescSession();

        watchedEbdIds.addAll(this.ElementStateByIdRepository.getKeys());
        watchedEbdIds.addAll(this.DkwStateByRepo.getKeys());
        System.out.println("WatchSize: " + watchedEbdIds.size());
        subscribeAllScoped(watchedEbdIds);

        queryAllScoped(watchedEbdIds);

        System.out.println("Tesc-Module initiated successfully");

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
            int iPort;
            if (!ConfigHandler.getInstance().useInfrastructureServer) {
                sHost = "localhost";
                iPort = 1436;
            } else {
                sHost = ConfigHandler.getInstance().ipToInfrastructureServer;
                iPort = Integer.parseInt(ConfigHandler.getInstance().portOfInfrastructureServer);
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
                        MoveableTrackElement.getEwPossibleStates(), CurrentStatus);
                ElementStateByIdRepository.update(sLabel, MTE);
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
                        MoveableTrackElement.getDkwPossibleStates(), CurrentStatus);
                DkwStateByRepo.update(sLabel, MTE);



            }

        }
    }



}
