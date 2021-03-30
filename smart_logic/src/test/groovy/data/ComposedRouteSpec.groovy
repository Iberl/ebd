package data

import de.ibw.history.data.ComposedRoute
import de.ibw.tms.etcs.ETCS_DISTANCE
import de.ibw.tms.ma.Route
import de.ibw.tms.ma.common.DefaultObject
import de.ibw.tms.ma.location.SpotLocationIntrinsic
import de.ibw.tms.ma.positioned.elements.TrackArea
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological
import org.apache.commons.lang3.tuple.ImmutablePair
import org.apache.commons.lang3.tuple.Pair
import plan_pro.modell.geodaten._1_9_0.CTOPKante
import plan_pro.modell.geodaten._1_9_0.CTOPKanteAllg
import spock.lang.Shared
import spock.lang.Specification

import java.lang.reflect.Array
import java.lang.reflect.Field
/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @since 2021-03-30
 * @version 1.0
 *
 */
class ComposedRouteSpec extends Specification {

    private void addNode(ArrayList<TopologyGraph.Node> nodeList) {
        String nodeName = String.valueOf(nodeList.size());
        nodeList.add(new TopologyGraph.Node(nodeName, nodeName, null));
    }



    public static boolean set(Object object, String fieldName, Object fieldValue) {
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



    public init(ComposedRoute MUT, List lengthOfElments, List trackOrder, double startpercent, double endpercent ) {


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

            MUT.add(P);
        }
        SpotLocationIntrinsic first = new SpotLocationIntrinsic();
        first.setIntrinsicCoord(startpercent as Double);
        SpotLocationIntrinsic last = new SpotLocationIntrinsic();
        last.setIntrinsicCoord(endpercent as Double);
        MUT.setFirstSpot(first);
        MUT.setLastSpot(last);
    }

    def "getLengthCheck"() {
        given:

        ComposedRoute MUT = new ComposedRoute();
        init(MUT, lOfElments, trackOrd, startperc as double, endperc as double)
        expect:

        BigDecimal result = MUT.getRouteLength()
        result >= BigDecimal.valueOf(expected as int - 1);
        result <= BigDecimal.valueOf(expected as int + 1);

        where:
        lOfElments | trackOrd | startperc | endperc | expected
        [100]           | [1]        | 0            | 0          | 0
        [100]           | [0]        | 0.2          | 0.6        | 40
        [0, 30]         | [0, 0]     | 0.2          | 0          | 30


    }

    def "getBackCheck"() {
        given:

        ComposedRoute MUT = new ComposedRoute();
        init(MUT, lOfElments, trackOrd, startperc as double, endperc as double)
        ETCS_DISTANCE dMeterGoBack = new ETCS_DISTANCE()
        dMeterGoBack.sDistance = (short) meterGoBack;
        int i_scale = scale;
        expect:
            SpotLocationIntrinsic result = MUT.getPositionGoBackFromEndOfTrack(null, dMeterGoBack, i_scale);
            double dPercent = result.intrinsicCoord;
            assert dPercent <= expectation + 0.01;
            assert dPercent >= expectation - 0.01;

        where:
        lOfElments      | trackOrd   | startperc    | endperc | meterGoBack | scale | expectation
        [100]           | [1]        | 0            | 0.2       | 2         | 2     | 0
        [100]           | [1]        | 0.2          | 0.6     | 32          | 0     | 0.568
        [0, 30]         | [0, 0]     | 0.2          | 0       | 21          | 1     | 0.3
        [100, 200]      | [1, 1]     | 0            | 1       | 250         | 1     | 0.5


    }

    def "createSubRoutCheck"() {
        given:

        ComposedRoute MUT = new ComposedRoute();
        init(MUT, lOfElments, trackOrd, startperc as double, endperc as double)
        ETCS_DISTANCE dStartMeter = new ETCS_DISTANCE()
        dStartMeter.sDistance = (short) startMeter;
        ETCS_DISTANCE dEndMeter = new ETCS_DISTANCE();
        dEndMeter.sDistance = (short) endMeter
        int i_scale = scale;
        TrackArea TA = new TrackArea("TestArea");
        TA = MUT.createSubRoute(dStartMeter, dEndMeter, i_scale, TA);
        expect:

        TA.getTrackEdgeSections().size() == expectation.size()
        Iterator<TrackEdgeSection> sectionIt = TA.getTrackEdgeSections().iterator()

        for(ArrayList SectionExpect : expectation) {
            def startExpect = SectionExpect.get(0) as double;
            def endExpect = SectionExpect.get(1) as double;
            if(sectionIt.hasNext()) {
                TrackEdgeSection AcutalSection = sectionIt.next();
                Double actualStart = AcutalSection.begin.intrinsicCoord;
                Double acutalEnd = AcutalSection.end.intrinsicCoord;
                assert actualStart < startExpect + 0.01;
                assert actualStart > startExpect - 0.01
                assert acutalEnd < endExpect + 0.01
                assert acutalEnd > endExpect - 0.01;


            } else {
                assert "Expectation has more elements than acutal" == "Bad"
            }
        }


        where:
        lOfElments      | trackOrd   | startperc    | endperc | startMeter  | endMeter | scale | expectation
         [100]           | [1]        | 0.2          | 0.6     | 20          | 70       | 0     | [[0.22, 0.53]]
         [0, 30]         | [0, 0]     | 0.2          | 0       | 3           | 24       | 1     | [[0.8, 0.9] ]
         [100, 200]      | [1, 1]     | 0            | 1       | 250         | 20       | 1     | [[ 0.75, 0.9 ]]
         [100, 200]      | [1, 1]     | 0            | 1       |  50         | 20      | 1     | [[ 0.5 , 1 ],[0, 0.9]]
         [100, 200, 100] | [1, 0, 1]  | 0.5          | 0.5     | 275         | 25      | 1     | [ [ 0.25, 0.25 ] ]
         [100, 200, 100] | [0, 0, 1]  | 0.75         | 0.75    | 50          | 50      | 1     | [[0, 0.25],[0,1],[0, 0.25]]
    }

}
