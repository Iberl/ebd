package de.ibw.tms.plan_pro.adapter.topology.trackbased;

import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.DefaultRepo;
import org.junit.jupiter.api.Test;
import plan_pro.modell.basisobjekte._1_9_0.CBereichObjektTeilbereich;
import plan_pro.modell.geodaten._1_9_0.CStrecke;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ITopologyFactoryTest {

    private DefaultRepo<String, TopologyGraph.Edge> edgeByReadableId = new DefaultRepo<>();
    private ArrayList<TopologyGraph.Edge> multible = new ArrayList<>();

    @Test
    void printBereichsnamen() {
        PlanData.getInstance();
        Collection<TopologyGraph.Edge> edges = PlanData.topGraph.edgeRepo.values();
        for(TopologyGraph.Edge E : edges) {
            print(E);
        }
        if(!multible.isEmpty()) {
            System.out.println("-----------EDGE NAME NOT UNIQUE----------");
            for (TopologyGraph.Edge E : multible) {
                print(E);
            }
        }
        assertTrue(multible.isEmpty(), "There are multible BereichsIDs: (Number of Edges) " + multible.size()
            + "of: " + edges.size());

    }

    private void print(TopologyGraph.Edge e) {
        System.out.println("-------");
        System.out.println("NomralId: " + e.sId);
        System.out.println("Kantenlaenge: " + e.dTopLength);
        printConnections(e);
        String edgeId = e.getRefId();
        TopologyGraph.Edge Old = edgeByReadableId.getModel(edgeId);
        if(Old == null) {
            edgeByReadableId.update(edgeId, e);
        } else {
            if(!multible.contains(e))
                multible.add(e);
            if(!multible.contains(Old)) {
                multible.add(Old);
            }
        }
        if(edgeId == null) System.out.println("No Id for Edge generated");
        else System.out.println("Edge has Id: " + edgeId);
    }

    private void printConnections(TopologyGraph.Edge e) {
        printNode(e.A, e.TopConnectFromA, "A");
        printNode(e.B, e.TopConnectFromB, "B");

    }

    private void printNode(TopologyGraph.Node a, TopologyConnect topConnectFromA, String s) {
        String isDKW = PlanData.checkSameAnlage(a,a) ? "yes" : "no";
        System.out.println("Node " + s +  " id: " + a.TopNodeId + " type: " + topConnectFromA.value() + " is DKW: " + isDKW);
        String sCrossoverName = ISwitchHandler.getNodeId(a);
        if(sCrossoverName == null) System.out.println("Node has no Id");
        else System.out.println("Node has Id: " + sCrossoverName);

    }


    @Test
    void connectTopology() throws JAXBException {
        ITopologyFactory ModulUnderTest = new TopologyFactory();
        System.out.println("TestBreak");
        TopologyGraph TG = ModulUnderTest.connectTopology();

        DefaultRepo<String, CStrecke > tracks = ModulUnderTest.getTrackRepo();
        ArrayList<CStrecke> trackList = new ArrayList<CStrecke>(tracks.getAll());


        CStrecke ExampleTrack = trackList.get(1);
        List<CBereichObjektTeilbereich> segmentList = ExampleTrack.getBereichObjektTeilbereich();
        CBereichObjektTeilbereich SegmentA = segmentList.get(0);
        CBereichObjektTeilbereich SegmentB = segmentList.get(1);
        TopologyGraph.Edge E1 = TG.edgeRepo.get(SegmentA.getIDTOPKante().getWert());
        TopologyGraph.Edge E2 = TG.edgeRepo.get(SegmentB.getIDTOPKante().getWert());





        int i = 1;
        for(CBereichObjektTeilbereich Area: segmentList) {
            TopologyGraph.Edge E = TG.edgeRepo.get(Area.getIDTOPKante().getWert());
            TopologyGraph.Node EA = E.A;
            TopologyGraph.Node EB = E.B;
            CrossoverModel MA = EA.getModel();

            System.out.println("---- Area " + i + " ----");
            System.out.println("EdgeID: " + E.sId);
            System.out.println("A Begrenzung: " + Area.getBegrenzungA().getWert().toString());
            System.out.println("A ID: " + E.A.TopNodeId);
            System.out.println("A Type: " + E.TopConnectFromA.value());
            System.out.println("B Begrenzung: " + Area.getBegrenzungB().getWert().toString());
            System.out.println("B ID: " + E.B.TopNodeId);
            System.out.println("B Type: " + E.TopConnectFromB.value());
            System.out.println("Length: " + E.dTopLength);

            i++;
        }

        //assertTrue(E1.B.equals(E2.A));



    }

}