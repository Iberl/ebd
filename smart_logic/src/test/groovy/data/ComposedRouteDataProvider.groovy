package data

import de.ibw.history.data.ComposedRoute
import de.ibw.tms.trackplan.ui.Route
import de.ibw.tms.ma.common.DefaultObject
import de.ibw.tms.ma.location.SpotLocationIntrinsic
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological
import org.apache.commons.lang3.tuple.ImmutablePair
import org.apache.commons.lang3.tuple.Pair
import spock.lang.Specification

import java.lang.reflect.Field

/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @since 2021-04-06
 * @version 1.0
 *
 */
class ComposedRouteDataProvider extends Specification {

    private  void addNode(ArrayList<TopologyGraph.Node> nodeList) {
        String nodeName = String.valueOf(nodeList.size());
        nodeList.add(new TopologyGraph.Node(nodeName, nodeName, null));
    }



    public  boolean set(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }

    private  init(ComposedRoute target, List lengthOfElments, List trackOrder, double startpercent, double endpercent ) {


        ArrayList<TopologyGraph.Edge> edgeList = new ArrayList<>();
        ArrayList<TopologyGraph.Node> nodeList = new ArrayList<>();
        for (int i = 0; i < lengthOfElments.size(); i++) {
            TopologyGraph.Edge TE = null
            TopologyGraph.Edge StubTE = null;
            if (i == 0) {
                addNode(nodeList);
                addNode(nodeList);
                if ((i + 1) < lengthOfElments.size()) {
                    // Erste und letzte Edge
                    StubTE = Stub(TopologyGraph.Edge);
                    set(StubTE, "A", nodeList.get(0));
                    set(StubTE, "TopConnectFromA", TopologyConnect.ENDE);
                    set(StubTE, "B", nodeList.get(1));
                    set(StubTE, "TopConnectFromB", TopologyConnect.ENDE);

                } else {
                    // Erste Edge aber nicht letzte

                    StubTE = Stub(TopologyGraph.Edge);

                    set(StubTE, "A", nodeList.get(0));
                    set(StubTE, "TopConnectFromA", TopologyConnect.ENDE);
                    set(StubTE, "B", nodeList.get(1));
                    set(StubTE, "TopConnectFromB", TopologyConnect.SPITZE);
                }


            } else {
                addNode(nodeList)
                if((i + 1) < lengthOfElments.size()) {
                    // Nicht Erste aber letzte
                    TopologyGraph.Edge LastTE = edgeList.get(edgeList.size()-1);
                    TopologyGraph.Node LastN = nodeList.get(nodeList.size()-1);
                    StubTE = Stub(TopologyGraph.Edge);

                    set(StubTE, "A", LastTE.B);
                    set(StubTE, "TopConnectFromA", TopologyConnect.LINKS);
                    set(StubTE, "B", LastN);
                    set(StubTE, "TopConnectFromB", TopologyConnect.ENDE);

                } else {
                    // Mitte
                    TopologyGraph.Edge LastTE = edgeList.get(edgeList.size()-1);
                    TopologyGraph.Node LastN = nodeList.get(nodeList.size()-1);
                    StubTE = Stub(TopologyGraph.Edge);
                    set(StubTE, "A", LastTE.B);
                    set(StubTE, "TopConnectFromA", TopologyConnect.LINKS);
                    set(StubTE, "B", LastN);
                    set(StubTE, "TopConnectFromB", TopologyConnect.SPITZE);

                }

            }

            StubTE.dTopLength = lengthOfElments.get(i) as double;

            if (trackOrder.get(i) == 1) {

                StubTE.getRefNode() >> StubTE.A;
            } else {
                StubTE.getRefNode() >> StubTE.B;

            }
            StubTE.getUuid() >> UUID.randomUUID()
            StubTE.getId() >> StubTE.getUuid().toString()
            DefaultObject.topologyRepository.update(StubTE.getUuid(),StubTE)
            edgeList.add(StubTE);
        }
        for(int i = 0; i < edgeList.size(); i++) {
            Pair<Route.TrackElementType, ITopological> P =
                    new ImmutablePair<>(Route.TrackElementType.RAIL_TYPE, edgeList.get(i));

            target.add(P);
        }
        SpotLocationIntrinsic first = new SpotLocationIntrinsic();
        first.setIntrinsicCoord(startpercent as Double);
        SpotLocationIntrinsic last = new SpotLocationIntrinsic();
        last.setIntrinsicCoord(endpercent as Double);
        target.setFirstSpot(first);
        target.setLastSpot(last);
    }
    public ComposedRoute generateComposedRoute(List lengthOfElments, List trackOrder, double startpercent, double endpercent) {
        ComposedRoute RouteData = new ComposedRoute();
        init(RouteData, lengthOfElments,trackOrder, startpercent, endpercent);
        return RouteData;
    }
}
