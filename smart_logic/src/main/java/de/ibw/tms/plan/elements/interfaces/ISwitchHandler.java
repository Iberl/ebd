package de.ibw.tms.plan.elements.interfaces;

import de.ibw.tms.plan.NodeInformation;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.ThreadedRepo;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrAnlage;

import java.util.ArrayList;
import java.util.List;

public interface ISwitchHandler {

    static NodeInformation getNodeInfoBySwitchId(String switchId) {
        return PlanData.SwitchRepo.getModel(switchId);
    }


    static String getNodeId(TopologyGraph.Node N) {
        return PlanData.SwitchIdRepo.getModel(N);
    }

    static ThreadedRepo<CWKrAnlage, ArrayList<CrossingSwitch>> getAllSwitches() {
        return PlanData.CrossingSwitchRepoByAnlage;
    }

    static void registerNode(TopologyGraph.Node N, String switchId) {
        NodeInformation NI = getNodeInfoBySwitchId(switchId);
        if(NI == null) NI = new NodeInformation();
        if(!NI.contains(N)) {
            NI.add(N);
        }
        PlanData.SwitchRepo.update(switchId, NI);
        PlanData.SwitchIdRepo.update(N,switchId);
    }


    static void registerCrossingSwitch(CWKrAnlage A, CrossingSwitch CS) {
        ArrayList<CrossingSwitch> switchList = (ArrayList<CrossingSwitch>) getCrossingSwitches(A);
        if(!switchList.contains(CS)) switchList.add(CS);
        PlanData.CrossingSwitchRepoByAnlage.update(A,switchList);
    }


    static List<CrossingSwitch> getCrossingSwitches(CWKrAnlage A) {
        ArrayList<CrossingSwitch> switchList = PlanData.CrossingSwitchRepoByAnlage.getModel(A);
        if(switchList == null) {
            switchList = new ArrayList<>();
        }
        return switchList;
    }


}
