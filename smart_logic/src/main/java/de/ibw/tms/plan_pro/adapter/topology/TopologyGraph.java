package de.ibw.tms.plan_pro.adapter.topology;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.GeoCoordinates;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.trackbased.ICompareTrackMeter;
import de.ibw.util.DefaultRepo;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;
import plan_pro.modell.geodaten._1_9_0.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TopologyGraph {

    private static Node LeftmostNode = null;

    public static void setLeftmostNode(Node leftmostNode) {
        LeftmostNode = leftmostNode;
    }

    public static Node getLeftmostNode() {
        return LeftmostNode;
    }

    public static Double getXofCurrentLeftMostNode() {
        if(LeftmostNode == null) {
            return null;
        }
        GeoCoordinates xy = LeftmostNode.getGeoCoordinates();
        if(xy == null) return null;
        return xy.getX();
    }
    public static DefaultRepo<String, DefaultRepo<String, Edge>> twoTopPointBelongsToEdgeRepo = new DefaultRepo<>();


    // String is the CTOP_Kante_ID
        public HashMap<String, Edge> EdgeRepo = new HashMap<>();
        // String is TopNode_ID
        public static HashMap<String, Node> NodeRepo = new HashMap<>();
        @Deprecated
        public static HashMap<CPunktObjekt, Node> NodeMap = new HashMap<>();


        public static class Node extends TrackElement {

            public final String name;
            public final String TopNodeId;
            public Object NodeImpl;
            public Class  NodeType;
            public final HashSet<Edge> inEdges;
            public final HashSet<Edge> outEdges;
            //public GeoCoordinates Coordinates;


            public Node(String name, String topNodeId, GeoCoordinates GeoCo) {
                this.name = name;
                TopNodeId = topNodeId;
                inEdges = new HashSet<Edge>();
                outEdges = new HashSet<Edge>();
                this.setGeoCoordinates(GeoCo);
                NodeRepo.put(this.TopNodeId, this);

            }
            public Node addEdge(Node Node, Edge E){
                //Edge e = new Edge(this, topConnectFromA, node, topConnectFromB, iTopLength);
                outEdges.add(E);
                Node.inEdges.add(E);
                return this;
            }

            public CrossoverModel getModel() {
                return CrossoverModel.CrossoverRepo.getModel(this);
            }


            @Override
            public String toString() {
                return name;
            }

            @Override
            public String getViewName() {
                return this.name;
            }
        }

        public static class Edge extends TrackElement {



            private Rail R = null;

            private ArrayList<CGEOKante> paintListGeo = new ArrayList<>();

            public final Node A;
            public final TopologyConnect TopConnectFromA;

            public final Node B;
            public final TopologyConnect TopConnectFromB;
            public final double dTopLength;
            @Expose
            public String sId;

            public Boolean isFromNodeAtoNodeBisInTrackDirection() {
                try {
                    ICompareTrackMeter CSA = (ICompareTrackMeter) A.NodeImpl;
                    ICompareTrackMeter CSB = (ICompareTrackMeter) B.NodeImpl;
                    return CSA.thisHasLowerTrackMeter(CSB);
                } catch(Exception E) {
                    E.printStackTrace();
                    return null;
                }
            }


            public ArrayList<CGEOKante> getPaintListGeo() {
                return paintListGeo;
            }

            public void setPaintListGeo(ArrayList<CGEOKante> paintListGeo) {
                if(paintListGeo == null || paintListGeo.isEmpty()) throw new IllegalArgumentException("The list of geo edges is empty or null");
                ArrayList<CGEOKante> remainingGeoEdges = new ArrayList<>(paintListGeo);
                ArrayList<CGEOKante> sortedPaintListGeo = new ArrayList<>();

                GeoCoordinates reference = A.getGeoCoordinates();

                /*boolean b_fromA;
                CGEOKante firstEdge = paintListGeo.get(0);
                CGEOKante lastEdge = paintListGeo.get(paintListGeo.size() - 1);
                if(reference.equals(PlanData.GeoNodeRepo.getModel(firstEdge.getIDGEOKnotenA().getWert())) || reference.equals(PlanData.GeoNodeRepo.getModel(firstEdge.getIDGEOKnotenA().getWert()))) {
                    b_fromA = true;
                } else if(reference.equals(PlanData.GeoNodeRepo.getModel(lastEdge.getIDGEOKnotenA().getWert())) || reference.equals(PlanData.GeoNodeRepo.getModel(lastEdge.getIDGEOKnotenA().getWert()))) {
                    b_fromA = false;
                } else {
                    throw new IllegalArgumentException("The list of geo edges does not start at nodeA of top edge");
                }

                int i = b_fromA ? 0 : paintListGeo.size();
                for(; (b_fromA && i < paintListGeo.size() || !b_fromA && i > 0); i = b_fromA ? (i + 1) : (i - 1)) {*/
                for(int i = 0; i < paintListGeo.size(); i++) {
                    CGEOKante edge = getNextGeoEdge(remainingGeoEdges, reference);
                    remainingGeoEdges.remove(edge);
                    GeoCoordinates nodeA = PlanData.GeoNodeRepo.getModel(edge.getIDGEOKnotenA().getWert());
                    GeoCoordinates nodeB = PlanData.GeoNodeRepo.getModel(edge.getIDGEOKnotenB().getWert());

                    if(reference.equals(nodeA)) {
                        sortedPaintListGeo.add(edge);
                        reference = nodeB;
                    } else if(reference.equals(nodeB)){
                        CGEOKante rotatedEdge = new CGEOKante();
                        CGEOKanteAllg edgeGeneral = edge.getGEOKanteAllg();
                        CGEOKanteAllg rotatedEdgeGeneral = new CGEOKanteAllg();

                        rotatedEdgeGeneral.setGEOForm(edgeGeneral.getGEOForm());
                        rotatedEdgeGeneral.setGEOLaenge(edgeGeneral.getGEOLaenge());

                        if(edgeGeneral.getGEORadiusB() != null) {
                            TCGEORadiusA newRadiusA = new TCGEORadiusA();
                            newRadiusA.setWert(edgeGeneral.getGEORadiusB().getWert());
                            rotatedEdgeGeneral.setGEORadiusA(newRadiusA);

                            TCGEORadiusB newRadiusB = new TCGEORadiusB();
                            newRadiusB.setWert(edgeGeneral.getGEORadiusA().getWert());
                            rotatedEdgeGeneral.setGEORadiusB(newRadiusB);
                        } else {
                            rotatedEdgeGeneral.setGEORadiusA(edgeGeneral.getGEORadiusA());
                            rotatedEdgeGeneral.setGEORadiusB(edgeGeneral.getGEORadiusB());
                        }

                        // TODO: Maybe Change Richtungswinkel
                        rotatedEdgeGeneral.setGEORichtungswinkel(edgeGeneral.getGEORichtungswinkel());
                        rotatedEdgeGeneral.setPlanQuelle(edgeGeneral.getPlanQuelle());
                        rotatedEdge.setGEOKanteAllg(edge.getGEOKanteAllg());

                        rotatedEdge.setIDGEOArt(edge.getIDGEOArt());
                        rotatedEdge.setIDGEOKnotenA(edge.getIDGEOKnotenB());
                        rotatedEdge.setIDGEOKnotenB(edge.getIDGEOKnotenA());
                        sortedPaintListGeo.add(rotatedEdge);
                        reference = nodeA;
                    } else {
                        throw new IllegalArgumentException("The list of geoedges is not in correct order");
                    }

                }

                this.paintListGeo = sortedPaintListGeo;
            }

            private CGEOKante getNextGeoEdge(List<CGEOKante> geoEdges, GeoCoordinates reference) {
                for(CGEOKante geoEdge : geoEdges) {
                    if(pointLaysOnEdge(geoEdge, reference)) {
                        return geoEdge;
                    }
                }
                throw new IllegalArgumentException("No geo edge in given list starts at the reference point");
            }

            private boolean pointLaysOnEdge(CGEOKante edge, GeoCoordinates point) {
                GeoCoordinates nodeA = PlanData.GeoNodeRepo.getModel(edge.getIDGEOKnotenA().getWert());
                GeoCoordinates nodeB = PlanData.GeoNodeRepo.getModel(edge.getIDGEOKnotenB().getWert());
                return point.equals(nodeA) || point.equals(nodeB);
            }

            private double getDistanceBetween(GeoCoordinates nodeA, GeoCoordinates nodeB) {
                double dx = Math.abs(nodeA.getX() - nodeB.getX());
                double dy = Math.abs(nodeA.getY() - nodeB.getY());
                return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
            }

            public Rail getRail() {
                return R;
            }

            public void setRail(Rail r) {
                R = r;
            }

            private CTOPKante PlanProEdge;

            public CTOPKante getPlanProEdge() {
                return PlanProEdge;
            }


            public Edge(Node A, TopologyConnect topConnectFromA, Node B, TopologyConnect topConnectFromB, CTOPKante Edge) {
                this.A = A;

                TopConnectFromA = topConnectFromA;
                this.B = B;
                TopConnectFromB = topConnectFromB;
                A.addEdge(B,this);
                this.PlanProEdge = Edge;
                this.sId = Edge.getIdentitaet().getWert();
                this.dTopLength = Edge.getTOPKanteAllg().
                        getTOPLaenge().getWert().doubleValue();

                DefaultRepo<String, Edge> SecondPointToEdgeRepo = twoTopPointBelongsToEdgeRepo.getModel(Edge.getIDTOPKnotenA().getWert());
                if(SecondPointToEdgeRepo == null) {
                    SecondPointToEdgeRepo = new DefaultRepo<String, Edge>();
                }
                SecondPointToEdgeRepo.update(Edge.getIDTOPKnotenB().getWert(), this);
                twoTopPointBelongsToEdgeRepo.update(Edge.getIDTOPKnotenA().getWert(), SecondPointToEdgeRepo);

                SecondPointToEdgeRepo = twoTopPointBelongsToEdgeRepo.getModel(Edge.getIDTOPKnotenB().getWert());
                if(SecondPointToEdgeRepo == null) {
                    SecondPointToEdgeRepo = new DefaultRepo<String, Edge>();
                }
                SecondPointToEdgeRepo.update(Edge.getIDTOPKnotenA().getWert(), this);
                twoTopPointBelongsToEdgeRepo.update(Edge.getIDTOPKnotenB().getWert(), SecondPointToEdgeRepo);

            }
            @Override
            public boolean equals(Object obj) {
                Edge e = null;
                try {
                    e = (Edge) obj;
                } catch (Exception E ) {
                    // Object is not an Edge
                    return false;
                }
                return e.A == A && e.B == B;
            }

            @Override
            public String getViewName() {
                //TODO:
                return null;
            }

            public boolean checkIfStartAndEndpointBelongsToThisEdge(String sIdTopNode1, String sIdTopNode2) {
                String sThisNode1 = this.getPlanProEdge().getIDTOPKnotenA().getWert();
                String sThisNode2 = this.getPlanProEdge().getIDTOPKnotenB().getWert();
                if(sThisNode1.equals(sIdTopNode1) && sThisNode2.equals(sIdTopNode2)) return true;
                if(sThisNode1.equals(sIdTopNode2) && sThisNode2.equals(sIdTopNode1)) return true;
                return false;
            }


        }

        public static void main(String[] args) {
           /* Node seven = new Node("7", topNodeId);
            Node five = new Node("5", topNodeId);
            Node three = new Node("3", topNodeId);
            Node eleven = new Node("11", topNodeId);
            Node eight = new Node("8", topNodeId);
            Node two = new Node("2", topNodeId);
            Node nine = new Node("9", topNodeId);
            Node ten = new Node("10", topNodeId);
            /*seven.addEdge(eleven, topConnectFromA, topConnectFromB).addEdge(eight, topConnectFromA, topConnectFromB);
            five.addEdge(eleven, topConnectFromA, topConnectFromB);
            three.addEdge(eight, topConnectFromA, topConnectFromB).addEdge(ten, topConnectFromA, topConnectFromB);
            eleven.addEdge(two, topConnectFromA, topConnectFromB).addEdge(nine, topConnectFromA, topConnectFromB).addEdge(ten, topConnectFromA, topConnectFromB);
            eight.addEdge(nine, topConnectFromA, topConnectFromB).addEdge(ten, topConnectFromA, topConnectFromB);




            Node[] allNodes = {seven, five, three, eleven, eight, two, nine, ten};

            //L <- Empty list that will contain the sorted elements

            ArrayList<Node> L = new ArrayList<Node>();

            //S <- Set of all nodes with no incoming edges
            HashSet<Node> S = new HashSet<Node>();
            for(Node n : allNodes){
                if(n.inEdges.size() == 0){
                    S.add(n);
                }
            }

            //while S is non-empty do
            while(!S.isEmpty()){
                //remove a node n from S
                Node n = S.iterator().next();
                S.remove(n);

                //insert n into L
                L.add(n);

                //for each node m with an edge e from n to m do
                for(Iterator<Edge> it = n.outEdges.iterator();it.hasNext();){
                    //remove edge e from the graph
                    Edge e = it.next();
                    Node m = e.B;
                    it.remove();//Remove edge from n
                    m.inEdges.remove(e);//Remove edge from m

                    //if m has no other incoming edges then insert m into S
                    if(m.inEdges.isEmpty()){
                        S.add(m);
                    }
                }
            }
            //Check to see if all edges are removed
            boolean cycle = false;
            for(Node n : allNodes){
                if(!n.inEdges.isEmpty()){
                    cycle = true;
                    break;
                }
            }
            if(cycle){
                System.out.println("Cycle present, topological sort not possible");
            }else{
                System.out.println("Topological Sort: "+Arrays.toString(L.toArray()));
            }

            */
        }


    }

