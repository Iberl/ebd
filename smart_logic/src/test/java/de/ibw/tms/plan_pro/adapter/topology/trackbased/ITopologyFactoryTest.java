package de.ibw.tms.plan_pro.adapter.topology.trackbased;

import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.DefaultRepo;
import org.junit.jupiter.api.Test;
import plan_pro.modell.basisobjekte._1_9_0.CBereichObjektTeilbereich;
import plan_pro.modell.geodaten._1_9_0.CStrecke;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

class ITopologyFactoryTest {





    @Test
    void connectTopology() throws JAXBException {
        ITopologyFactory ModulUnderTest = null;
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