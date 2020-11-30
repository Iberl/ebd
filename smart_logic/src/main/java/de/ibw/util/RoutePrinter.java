package de.ibw.util;

import de.ibw.feed.Balise;
import de.ibw.history.data.ComposedRoute;
import de.ibw.smart.logic.safety.self.tests.SafetyLogicContinousConnectTest;
import de.ibw.tms.ma.Route;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import org.apache.commons.lang3.tuple.Pair;

public class RoutePrinter {

    public static void main(String[] args) {
        PlanData.getInstance();
        Balise B = Balise.baliseByNid_bg.getModel(4703);

        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(B.getTopPositionOfDataPoint().getIdentitaet().getWert());


        SafetyLogicContinousConnectTest Test = new SafetyLogicContinousConnectTest();
        ComposedRoute RD = Test.generateRandomContinousRouteOnBalise(4703, 7);
        print(RD);




       // Test.generateRandomContinousRoute(7,true, true)
    }

    private static void print(ComposedRoute rd) {

        for(Pair<Route.TrackElementType, ITopological> routeElement : rd) {
            ITopological El = routeElement.getRight();
            if(routeElement.getLeft().equals(Route.TrackElementType.RAIL_TYPE)) {
                TopologyGraph.Edge E = (TopologyGraph.Edge) El;
                System.out.println("Track Edge with ID " + E.getRefId());
            } else {
                TopologyGraph.Node N = (TopologyGraph.Node) El;
                System.out.println("Waypoint with ID " + ISwitchHandler.getNodeId(N));
            }
        }

    }


}
