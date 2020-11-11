package de.ibw.tms.plan_pro.adapter.topology;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.net.elements.PositionedRelation;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.ma.positioning.GeometricCoordinate;
import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.intf.IEdge;
import de.ibw.tms.plan_pro.adapter.topology.intf.INode;
import de.ibw.tms.plan_pro.adapter.topology.trackbased.ICompareTrackMeter;
import de.ibw.util.DefaultRepo;
import org.apache.commons.lang3.NotImplementedException;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjekt;
import plan_pro.modell.geodaten._1_9_0.*;

import java.util.*;

/**
 * Der Graph aus Knoten und Kanten der Topologie
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class TopologyGraph {

    private static Node LeftmostNode = null;

    /**
     * Setzen des Startknotens
     * @param leftmostNode {@link Node} - Startknoten links
     */
    public static void setLeftmostNode(Node leftmostNode) {
        LeftmostNode = leftmostNode;
    }

    /**
     * Holen des Startknotens
     * @return Node - Holt Startknoten
     */
    public static Node getLeftmostNode() {
        return LeftmostNode;
    }

    /**
     * @deprecated
     * Holt die X-coordinate des Startknotens
     * @return Double - X-coordinate
     */
    public static Double getXofCurrentLeftMostNode() {
        throw new NotImplementedException("deprecated");
        /*
        if(LeftmostNode == null) {
            return null;
        }
        GeometricCoordinate xy = (GeometricCoordinate) LeftmostNode.getGeoCoordinates();
        if(xy == null) return null;
        return xy.getX();

         */
    }

    /**
     * Repository, das eine Topoologisch Kante {@link Edge} &uuml;ber die String-PlanPro-Id der Knoten speichert
     */
    public static DefaultRepo<String, DefaultRepo<String, Edge>> twoTopPointBelongsToEdgeRepo = new DefaultRepo<>();


    // String is the CTOP_Kante_ID
    /**
     * HashMap die f&uuml;r die PlanPro-Kanten ID die Topologische Kante speichert
     */
    public HashMap<String, Edge> edgeRepo = new HashMap<>();
        // String is TopNode_ID
    /**
     * HashMap die f&uuml;r die PlanPro-Knoten ID einen Topologische Knoten speichert
     */
    public static HashMap<String, Node> NodeRepo = new HashMap<>();
        @Deprecated
        public static HashMap<CPunktObjekt, Node> NodeMap = new HashMap<>();

    /**
     * Topologischer Knoten
     */
    public static class Node extends ArrayList<PositionedRelation> implements INode {

        /**
         * Knoten Bezeichnung
         */
        public String name;
        /**
         * PlanPro Knoten Id
         */
        public String TopNodeId;
        /**
         * Knoten realisierung
         */
        public Object NodeImpl;
        /**
         * Klasse des Knoten
         */
        public Class NodeType;
        /**
         * Kanten eingehend
         */
        public final HashSet<Edge> inEdges;
        /**
         * Kanten ausgehend
         */
        public final HashSet<Edge> outEdges;
            //public GeoCoordinates Coordinates;

        /**
         * Konstruktur zur instanziierung eines Knoten
         * @param name {@link String} - Bezeichnung des Knoten
         * @param topNodeId {@link String} - PlanPro Id des Knoten
         * @param GeoCo {@link GeometricCoordinate} - Coordinaten des Knotens
         */
        public Node(String name, String topNodeId, GeometricCoordinate GeoCo) {
                this.name = name;
                TopNodeId = topNodeId;
                inEdges = new HashSet<Edge>();
                outEdges = new HashSet<Edge>();
                // @TODO Relation having no Geo co
                //this.setGeoCoordinates(GeoCo);
                NodeRepo.put(this.TopNodeId, this);

            }

        /**
         * Generiert eine Kante diesem und einem weiteren Knoten
         * @param Node {@link Node} - Weiterer Knoten zur Kante
         * @param E {@link Edge} - Kante aus beiden Knoten
         * @return Node - diesen Knoten
         */
        public Node addEdge(Node Node, Edge E){
                //Edge e = new Edge(this, topConnectFromA, node, topConnectFromB, iTopLength);
                outEdges.add(E);
                Node.inEdges.add(E);
                return this;
        }

        /**
         * @deprecated
         * Diese Methode zieht die Vermittlung zur Weiche
         * @return CrossoverModel - Vermittlung zur Logischen Weiche
         */
        public CrossoverModel getModel() {
            throw new NotImplementedException("deprecated");
            //return CrossoverModel.CrossoverRepo.getModel(this);
            }

        /**
         * Knotenbezeichnung als String
         * @return String - Bezeichnung des Knoten
         */

        @Override
        public String toString() {
            return name;
        }

        /**
         * Knotenname in Ansichten
         * @return String - Bezeichnung des Knoten
         */
        public String getViewName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Node that = (Node) o;
            return Objects.equals(name, that.name) &&
                    Objects.equals(TopNodeId, that.TopNodeId) &&
                    Objects.equals(NodeImpl, that.NodeImpl) &&
                    Objects.equals(NodeType, that.NodeType);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), name, TopNodeId, NodeImpl, NodeType);
        }
    }

    /**
     * Topologische Kante
     */
    public static class Edge extends TrackEdge implements IEdge {



            private Rail R = null;

            private ArrayList<CGEOKante> paintListGeo = new ArrayList<>();
        /**
         * Knoten A der Kante
         */
        public final Node A;
        /**
         * Verbindungsart des Knoten A (Spitze, Rechts, Links)
         */
        public final TopologyConnect TopConnectFromA;
        /**
         * Knoten B dieser Kante
         */
        public final Node B;
        /**
         * Verbindungsart des Knoten B (Spitze, Rechts, Links)
         */
        public final TopologyConnect TopConnectFromB;
        /**
         * Kantenl&auml;nge in meter
         */
            public final double dTopLength;
        /**
         * PlanPro KantenId
         */
        @Expose
        public String sId;

        /**
         * Diese Methode gibt an ob von Knotea A zum Knoten B dieser Kante in Streckenkilometrierung verl&auml;ft.
         * @return Boolean - gibt an ob Kante in Streckenorientierung
         */
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

        public String getRefId() {
            return PlanData.getRefIdOfEdge(this);
        }

        /**
         * Geographische Kanten dieser topologischen Kante
         * @return List - Geo-Kanten-Liste
         */
        public ArrayList<CGEOKante> getPaintListGeo() {
                return paintListGeo;
        }

        /**
         * Setzt die Geographische Kante dieser Topologischen Kante
         * @param paintListGeo - {@link List} - Geo-Kantenliste
         */
        public void setPaintListGeo(ArrayList<CGEOKante> paintListGeo) {
                if(paintListGeo == null || paintListGeo.isEmpty()) throw new IllegalArgumentException("The list of geo edges is empty or null");
                ArrayList<CGEOKante> remainingGeoEdges = new ArrayList<>(paintListGeo);
                ArrayList<CGEOKante> sortedPaintListGeo = new ArrayList<>();

                //TODO get Coordinate via implementation of node
                GeometricCoordinate reference = (GeometricCoordinate) A.getGeoCoordinates();

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
                    GeometricCoordinate nodeA = PlanData.GeoNodeRepo.getModel(edge.getIDGEOKnotenA().getWert());
                    GeometricCoordinate nodeB = PlanData.GeoNodeRepo.getModel(edge.getIDGEOKnotenB().getWert());

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

            private CGEOKante getNextGeoEdge(List<CGEOKante> geoEdges, GeometricCoordinate reference) {
                for(CGEOKante geoEdge : geoEdges) {
                    if(pointLaysOnEdge(geoEdge, reference)) {
                        return geoEdge;
                    }
                }
                throw new IllegalArgumentException("No geo edge in given list starts at the reference point");
            }

            private boolean pointLaysOnEdge(CGEOKante edge, GeometricCoordinate point) {
                GeometricCoordinate nodeA = PlanData.GeoNodeRepo.getModel(edge.getIDGEOKnotenA().getWert());
                GeometricCoordinate nodeB = PlanData.GeoNodeRepo.getModel(edge.getIDGEOKnotenB().getWert());
                return point.equals(nodeA) || point.equals(nodeB);
            }

            private double getDistanceBetween(GeometricCoordinate nodeA, GeometricCoordinate nodeB) {
                double dx = Math.abs(nodeA.getX() - nodeB.getX());
                double dy = Math.abs(nodeA.getY() - nodeB.getY());
                return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
            }

        /**
         * Gleis-Model (geographisch) dieser Kante.
         * Hat aber nicht die geographischen Subkanten.
         * @return Rail - Gleis als Modell
         */
        public Rail getRail() {
                return R;
            }

        /**
         * Setzt das logische-geographische Gleis dieser topologischen Kante
         * @param r - {@link Rail} - Das Gleis, das gesetzt wird.
         */
        public void setRail(Rail r) {
                R = r;
            }

            private CTOPKante PlanProEdge;

        /**
         * Gibt die Topologische Kante nach Definition in PlanPro wider
         * @return CTOPKante - PlanPro-Topologische-Kante
         */
        public CTOPKante getPlanProEdge() {
                return PlanProEdge;
            }

        /**
         * Dieser Konstruktur instanziiert eine Topologische Kante
         * @param A {@link Node} - Topologischer Knoten A
         * @param topConnectFromA {@link TopologyConnect} - Verbindungsart an A (Rechts, Links, Spitze)
         * @param B {@link Node} - Topologischer Knoten B
         * @param topConnectFromB {@link TopologyConnect} - Verbindungsart an B (Rechts, Links, Spitze)
         * @param Edge - {@link CTOPKante} - PlanPro-Modell dieser Kante
         */
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

        /**
         * Diese Method vergleicht zwei Kanten ob sie identisch sind
         * @param obj - {@link Object} - Kantenobject zum Vergeich mit dieser Kante
         * @return boolean - gibt an ob die Kanten identisch sind
         */
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

        /**
         * Bezeichnung der Kante in Ansichten
         * @return String - Ansichtsname der Kante
         */
            public String getViewName() {
                throw new NotImplementedException("not used");
                //TODO:
               //return null;
            }

        /**
         * Diese Methode untersucht ob zwei Knoten Ids den Knoten dieser Kante angeh&ouml;ren.
         * @param sIdTopNode1 {@link String} - Knoten-Id 1
         * @param sIdTopNode2 {@link String} - Knoten-Id 2
         * @return boolean - gibt an ob die Knoten dieser Kante teilhaft sind
         */
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

