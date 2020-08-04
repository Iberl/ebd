package de.ibw.tms.plan_pro.adapter.topology.trackbased;

import de.ibw.tms.data.store.DataStore;
import de.ibw.tms.ma.GeoCoordinates;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.DefaultRepo;
import plan_pro.modell.geodaten._1_9_0.CGEOKante;
import plan_pro.modell.geodaten._1_9_0.CGEOKnoten;
import plan_pro.modell.geodaten._1_9_0.CTOPKante;
import plan_pro.modell.geodaten._1_9_0.CTOPKnoten;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopologyFactory {


    private DefaultRepo geoBundle; // input
    private DefaultRepo geoNodeToGeoEdgesRepo; // input
    private DefaultRepo geoNodeToTopNodeRepo; // output
    private DefaultRepo topNodeToGeoNodeRepo; // output

    private void handleGeoEdges(TopologyGraph.Node StartNode, CGEOKnoten CurrentGeo, CGEOKnoten NextGeoNode, DefaultRepo<String, CGEOKnoten> geoPointRepo, HashMap<String, TopologyGraph.Edge> edgeRepo) {
        // return value
        ArrayList<CGEOKante> resultEdges = new ArrayList<>();
        // already visitedNodes
        ArrayList<String> visitedGeoNodesIds = new ArrayList<>();
        CGEOKnoten GeoPointer = CurrentGeo;
        String sGeoA = CurrentGeo.getIdentitaet().getWert();
        String sGeoB = NextGeoNode.getIdentitaet().getWert();
        CTOPKnoten LastTopNode = null;
        String sGeoCurrent = null;
        // all connected Edges
        List<CGEOKante> connectedEdges = (List<CGEOKante>) geoNodeToGeoEdgesRepo.getModel(GeoPointer.getIdentitaet().getWert());

        // check all nodes from branching point
        for (CGEOKante EdgeCheck4Connect : connectedEdges) {
            String sCheckA = EdgeCheck4Connect.getIDGEOKnotenA().getWert();
            String sCheckB = EdgeCheck4Connect.getIDGEOKnotenB().getWert();
            if (checkIfEdgeIsSearchedOne(sGeoA, sGeoB, sCheckA, sCheckB)) {
                resultEdges.add(EdgeCheck4Connect);

                visitedGeoNodesIds.add(sGeoA);
                visitedGeoNodesIds.add(sGeoB);
                //check if Geo node is top node also
                LastTopNode = geoNodeToTopNodeRepo.getModel(sGeoB);

                sGeoCurrent = sGeoB;
                while(LastTopNode == null) {

                    connectedEdges = geoNodeToGeoEdgesRepo.getModel(sGeoCurrent);
                    for (CGEOKante FolowedGeoEdge : connectedEdges) {
                        String strA = FolowedGeoEdge.getIDGEOKnotenA().getWert();
                        String strB = FolowedGeoEdge.getIDGEOKnotenB().getWert();
                        if(!visitedGeoNodesIds.contains(strA)) {
                            resultEdges.add(FolowedGeoEdge);
                            visitedGeoNodesIds.add(strA);
                            LastTopNode = geoNodeToTopNodeRepo.getModel(strA);
                            sGeoCurrent = strA;
                        } else if(!visitedGeoNodesIds.contains(strB)) {
                            resultEdges.add(FolowedGeoEdge);
                            visitedGeoNodesIds.add(strB);
                            LastTopNode = geoNodeToTopNodeRepo.getModel(strB);
                            sGeoCurrent = strB;
                        }
                    }

                }




            } else {
                continue;
            }
        }

        TopologyGraph.Node B = TopologyGraph.NodeRepo.get(LastTopNode.getIdentitaet().getWert());
        for(TopologyGraph.Edge OutEdge : StartNode.outEdges) {
            for(TopologyGraph.Edge InEdge: B.inEdges) {
                if(OutEdge.equals(InEdge)) {
                    OutEdge.setPaintListGeo(resultEdges);

                }
            }
        }
        for(TopologyGraph.Edge InEdge : StartNode.inEdges) {
            for(TopologyGraph.Edge OutEdge: B.outEdges) {
                if(OutEdge.equals(InEdge)) {
                    OutEdge.setPaintListGeo(resultEdges);

                }
            }
        }




    }

    private void relateEdgeToNode(CGEOKante geoEdge, CGEOKnoten geoNodeA) {
        ArrayList<CGEOKante> geoKanteListe = (ArrayList<CGEOKante>) geoNodeToGeoEdgesRepo.getModel(geoNodeA.getIdentitaet().getWert());
        if(geoKanteListe == null) {
            geoKanteListe = new ArrayList<>();
        }
        if(!geoKanteListe.contains(geoEdge)) {
            geoKanteListe.add(geoEdge);
        }
        geoNodeToGeoEdgesRepo.update(geoNodeA.getIdentitaet().getWert(), geoKanteListe);
    }

    private void fillGeoEdgeRelateToGeoNodeRepo(DefaultRepo<String, CGEOKnoten> geoPointRepo) {
        for (Object geoObject : ((DefaultRepo) geoBundle.getModel(CGEOKante.class)).getAll()) {
            CGEOKante geoEdge = (CGEOKante) geoObject;
            CGEOKnoten geoNodeA = geoPointRepo.getModel(geoEdge.getIDGEOKnotenA().getWert());
            CGEOKnoten geoNodeB = geoPointRepo.getModel(geoEdge.getIDGEOKnotenB().getWert());

            relateEdgeToNode(geoEdge, geoNodeA);
            relateEdgeToNode(geoEdge, geoNodeB);

        }
    }

    public static GeoCoordinates getGeoCoordinate(DefaultRepo nodeRepo, String sNodeA) {
        CTOPKnoten TopNode = (CTOPKnoten) nodeRepo.getModel(sNodeA);
        String sGeoNodeId = TopNode.getIDGEOKnoten().getWert();
        //CGEOKnoten geoPointOfNode = geoPointRepo.getModel(sGeoNodeId);
        GeoCoordinates CoordinateGeo = PlanData.GeoNodeRepo.getModel(sGeoNodeId);
        return CoordinateGeo;
    }

    public void connectTopology(List<CTOPKante> topLines) {
        TopologyGraph TG = new TopologyGraph();
        DefaultRepo<String, CTOPKnoten> nodeRepo = (DefaultRepo<String, CTOPKnoten>) geoBundle.getModel(CTOPKnoten.class);
        DefaultRepo<String, CGEOKnoten> geoPointRepo = (DefaultRepo<String, CGEOKnoten>) geoBundle.getModel(CGEOKnoten.class);


        for(CTOPKante Edge : topLines) {

            String sNodeA = Edge.getIDTOPKnotenA().getWert();
            String sNodeB = Edge.getIDTOPKnotenB().getWert();

            TopologyGraph.Node A = TopologyGraph.NodeRepo.get(sNodeA);
            if(A == null) {
                GeoCoordinates GeoA = getGeoCoordinate(nodeRepo,sNodeA);
                A = new TopologyGraph.Node("", sNodeA, GeoA);
            }
            TopologyGraph.Node B = TopologyGraph.NodeRepo.get(sNodeB);
            if(B == null) {
                GeoCoordinates GeoB = getGeoCoordinate(nodeRepo,sNodeB);
                B = new TopologyGraph.Node("", sNodeB , GeoB);
            }



            TopologyConnect tcA = TopologyConnect.fromValue(Edge.getTOPKanteAllg().getTOPAnschlussA().getWert().value());
            TopologyConnect tcB = TopologyConnect.fromValue(Edge.getTOPKanteAllg().getTOPAnschlussB().getWert().value());






            TopologyGraph.Edge tgEdge = new TopologyGraph.Edge(A,tcA,B,tcB, Edge);
            TG.EdgeRepo.put(Edge.getIdentitaet().getWert(),tgEdge);




        }



        // filling topNodetoGeoNodeRepo with key:ID of geoNodes, value:topNodes
        for (CTOPKnoten topNode : nodeRepo.getAll()) {
            CGEOKnoten geoNode = geoPointRepo.getModel(topNode.getIDGEOKnoten().getWert());
            geoNodeToTopNodeRepo.update(geoNode.getIdentitaet().getWert(),topNode);
            topNodeToGeoNodeRepo.update(topNode.getIdentitaet().getWert(), geoNode);
        }

        // filling geoEdgeToGeoNodeRepo with key:ID of geoNodes, value: geoEdge
        fillGeoEdgeRelateToGeoNodeRepo(geoPointRepo);

        // iterate over edges
        ArrayList<TopologyGraph.Edge> edgeList = new ArrayList<>(TG.EdgeRepo.values());




        for(TopologyGraph.Edge E : edgeList) {
            if(E.getPaintListGeo().isEmpty()) {

                CTOPKante TopKante = E.getPlanProEdge();
                String sTopNodeA = TopKante.getIDTOPKnotenA().getWert();
                CGEOKnoten currentGeo = (CGEOKnoten) topNodeToGeoNodeRepo.getModel(sTopNodeA);
                TopologyGraph.Node A = TopologyGraph.NodeRepo.get(sTopNodeA);
                String sGeoNodeId = currentGeo.getIdentitaet().getWert();
                List<CGEOKante> geoEdges = (List<CGEOKante>) geoNodeToGeoEdgesRepo.getModel(sGeoNodeId);
                for(CGEOKante GeoEdge : geoEdges) {
                    String sGeoA = GeoEdge.getIDGEOKnotenA().getWert();
                    String sGeoB = GeoEdge.getIDGEOKnotenB().getWert();
                    String sNextGeo = null;
                    CGEOKnoten NextGeoNode = null;
                    if(sGeoA.equals(sGeoNodeId)) {
                        sNextGeo = sGeoB;
                    } else if(sGeoB.equals(sGeoNodeId)) {
                        sNextGeo = sGeoA;
                    } else {
                        continue;
                    }
                    NextGeoNode = geoPointRepo.getModel(sNextGeo);
                    handleGeoEdges(A, currentGeo, NextGeoNode,geoPointRepo,TG.EdgeRepo);


                }

            }
        }







        PlanData.topGraph = TG;


    }

}
