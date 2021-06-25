package de.ibw.tms.plan.elements.model;

import de.ibw.feed.BaliseExtractor;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.tms.etcs.ETCS_GRADIENT;
import de.ibw.tms.gradient.profile.GradientTrailModel;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.net.elements.PositioningNetElement;
import de.ibw.tms.ma.physical.*;
import de.ibw.tms.ma.positioned.elements.GradientSegment;
import de.ibw.tms.ma.positioning.GeometricCoordinate;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.plan.NodeInformation;
import de.ibw.tms.plan.elements.BranchingSwitch;
import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.PlanProTmsAdapter;
import de.ibw.tms.plan_pro.adapter.topology.DummyChainageSupply;
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ChainageSupplyInterface;
import de.ibw.tms.plan_pro.adapter.topology.trackbased.ITopologyFactory;
import de.ibw.tms.plan_pro.adapter.topology.trackbased.TopologyFactory;
import de.ibw.tms.trackplan.ui.PlatformEdge;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import de.ibw.util.DefaultRepo;
import de.ibw.util.ThreadedRepo;
import ebd.TescModul;
import ebd.dbd.client.extension.RealDbdClient;
import javax.xml.bind.JAXBException;
import org.apache.commons.lang3.NotImplementedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Node;
import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektTOPKante;
import plan_pro.modell.basistypen._1_9_0.CBezeichnungElement;
import plan_pro.modell.geodaten._1_9_0.CGEOKante;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrAnlage;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspElement;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspKomponente;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.ENUMWKrArt;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.Flow;


/**
 * Daten Topographischer und Geographischer Art.
 * Hier wird in Zukunft auch das Gradientenprofil abgebildet.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-09
 */
public class PlanData implements Flow.Subscriber<GradientProfile> {



    private ITopologyFactory topologyFactory;

    public DefaultRepo<Class<?>, DefaultRepo<String, CBasisObjekt>> getGeoBundle() throws javax.xml.bind.JAXBException, IOException, IllegalAccessException {
        if(topologyFactory == null) {
            this.topologyFactory = new TopologyFactory();
        }
        return topologyFactory.getGeoBundle();
    }

    private List<GradientSegment> gradientSegmentList = new ArrayList<GradientSegment>();
    private List<SectionOfLine> sectionList = new ArrayList<SectionOfLine>();

    /**
     * Liste von Gradienten werden gesetzt
     * @param gradientSegmentList {@link List} - Gradientensegment-Liste
     */
    public void setGradientSegmentList(List<GradientSegment> gradientSegmentList) {
        this.gradientSegmentList = gradientSegmentList;
    }

    /**
     * Ein Reposory der als Schl&uuml;ssel den Identifieer eine PlanPro-GeoKnoten h&auml;lt und als Wert Geo-Coordinaten bereitstellt.
     */
    public static DefaultRepo<String, GeometricCoordinate> GeoNodeRepo = new DefaultRepo<>();
    /**
     * Bahnh&ouml;fe noch nicht vollst&auml;ndig implementiert
     */
    public static DefaultRepo<String, PlatformEdge> PlatformRepo = new DefaultRepo<>();

    /**
     * Ein Repository speichert als Schl&uuml;ssel die EBD-Bezeichnung 12W13 und als Value die Weiche
     */
    public static ThreadedRepo<String, NodeInformation> SwitchRepo = new ThreadedRepo<>();

    public static ThreadedRepo<TopologyGraph.Node, String> SwitchIdRepo = new ThreadedRepo<>();

    public static ThreadedRepo<CWKrAnlage, ArrayList<CrossingSwitch>> CrossingSwitchRepoByAnlage = new ThreadedRepo<>();

    /**
     * Ein Repository speichert als Schl&uuml;ssel die EBD-Bezeichnung 12W8L und als Value die Kante
     */
    public static ThreadedRepo<String, TopologyGraph.Edge> EdgeIdLookupRepo = new ThreadedRepo<>();

    /**
     * Ein Repository speichert zu jeder Kante die eindeutige BereichsId 12W8L
     */
    public static ThreadedRepo<TopologyGraph.Edge, String> EdgeLookupByIdRepo = new ThreadedRepo<>();


    /**
     * Der topGraph speichert das SL-TMS-interen Topologische Modell
     */
    public static TopologyGraph topGraph;
    /**
     * Erlaubte Streckengeschwindigkeit eines Gleises ({@link Rail}  in km/h
     */
    public static int vmax = 160; // km/h

    /**
     * Diese Klasse setzt ein TrackElement in Graphische Linien-Objekte um.
     * Sie setzt ebenfalls TrackElment-Knoten in Graphische-Punkte um
     */
    public static class TrackElementPositionCalc {
        /**
         * {@link HashMap} zum Ermitteln des Gleis {@link Rail} - TrackElement eines Gleismodells
         */
        private static HashMap<PositioningNetElement, Line2D.Double> positionMap = new HashMap<>();
        /**
         * Bisher unbenutzt
         * {@link HashMap} zum Ermitteln eines Point_RemoteOperated aus einem {@link BranchingSwitch} - TrackElement einer Weiche
         */
        private static HashMap<TopologyGraph.Node, Point2D.Double> pointMap = new HashMap<TopologyGraph.Node, Point2D.Double>();

        /**
         * dieses Put gibt als Key ein UI-Gleis dem logischen Gleis zu dem Value eines geographischen Gleis {@link Rail}
         * @param TE {@link de.ibw.tms.plan_pro.adapter.topology.TopologyGraph.Edge} - Ein logischen Gleis Trail
         * @param Line - ein {@link Rail} - geographisches Gleise
         */
        public static void put(TopologyGraph.Edge TE, Line2D.Double Line) {
            positionMap.put(TE, Line);
        }

        /**
         * dieses Put gibt als Key ein {@link Point_RemoteOperated} - ein Umschaltelement der Weiche als TrackElment zu dem Value eines {@link BranchingSwitch} - Trackelement einer Weiche
         * @param TE - {@link de.ibw.tms.plan_pro.adapter.topology.TopologyGraph.Node} - das UmschaltElement der Weiche
         * @param Point - {@link BranchingSwitch} - das Modell einer Weiche
         */
        public static void put(TopologyGraph.Node TE, Point2D.Double Point) {
            pointMap.put(TE, Point);
        }

        /**
         * Transferiert ein TrackElment zu einer zeichenbaren Linie
         * @param TE - {@link PositioningNetElement} - Ein logischen Gleis Trail
         * @return Line2D.Double - Eine Rail die zeichnbar ist
         */
        public static Line2D.Double translateTeToGraphic(PositioningNetElement TE) {
            return positionMap.get(TE);
        }
        /*
        public static int getY(TrackElement TE, Chainage C) throws Exception {
            int iMarginLeft = 0;


            Line2D.Double Line = positionMap.get(TE);
            if(Line == null) {
                Point2D Point = pointMap.get(TE);
                if(Point == null) {
                    throw new Exception("No Position found");
                } else {
                    return (int) Point.getY();
                }
            }

            double yStart = Line.y1;
            double yEnd = Line.y2;
            double xStart = Line.x1;
            double xEnd = Line.x2;
            int x1 = (int) xStart;
            int x2 = (int) xEnd;
            int y1 = (int) yStart;
            int y2 = (int) yEnd;
            if(y1 == y2) { return y1; }
            if(x1 == x2) throw new Exception("Vertical Line");
            double m = (yEnd - yStart) / (xEnd - xStart);
            iMarginLeft = C.getiMeters() -x1;
            if(iMarginLeft == 0) {
                return y1;
            }
            // computer graphics

            System.out.println(m * iMarginLeft);

            int yCalc = (int) ((int) ( m * iMarginLeft) + yStart);

            return (int) (yCalc);

        }
        */

    }


    private static PlanData instance;

    /**
     * Singleton zum Erstellen der Planungsdaten
     * @return PlanData - Planungsdaten
     */
    public static PlanData getInstance() {
        if(instance == null) {
            instance = new PlanData();
        }
        return instance;
    }

    /**
     * Not used
     */
    public static ArrayList<RailConnector> connectorList = new ArrayList<RailConnector>();
    /**
     * not used
     */
    public static RailConnector ConnectorBetween5To6 = new RailConnector("Con Between 5 And 6");
    /**
     * Not used
     */
    public static RailConnector ConnectorBetween9To10 = new RailConnector("Con Between 9 And 10");
    /**
     * Not used
     */
    public static EdgeOfMap RightEnd;
    /**
     * Not used
     */
    public static ArrayList trainOccupiedList = new ArrayList();
    /**
     * Not used
     */
    public static ArrayList<CrossingSwitch> RailSwitchList = new ArrayList<>();


    /**
     * Noch nicht verwendet
     * Gibt zu einem Geleis Rail Gradientsegmente an
     * @param key {@link GradientTrailModel} - Gleis mit Gradient
     * @param values {@link List} - values von mehreren GradientenSegmenten
     */
    public static void putGradientData(GradientTrailModel key, ArrayList<GradientSegment> values) {
        PlanData.getInstance().GradientMap.put(key,values);
    }

    /**
     * Gradientenzuordnung in {@link HashMap} key {@link GradientTrailModel} value {@link List} von {@link GradientSegment}
     */
    public HashMap<GradientTrailModel, ArrayList<GradientSegment>> GradientMap = new HashMap<GradientTrailModel, ArrayList<GradientSegment>>();

    private GradientProfile GP = new GradientProfile(null);
    private Flow.Subscription GradientSubscription;


    // Read data from panel in case user made any changes

    private String sTitle = "Gleisplan";

    /**
     * Liste aller Gleise die man zeichnen kann
     */
    public ArrayList<Rail> railList = new ArrayList<Rail>();

    //public ArrayList<TopRailReturn> returnRailEdge = new ArrayList<TopRailReturn>();
    /**
     * Liste von allen Weichen
     */
    public ArrayList<BranchingSwitch> branchingSwitchList = new ArrayList<BranchingSwitch>();

    /**
     * Rails und Weichen k&ouml;nnen per Kontextmenu angesteuert werden.
     * Hierf&uuml;r implementieren Gleise und Weichenklassen Iinteractable
     * @return List - die Liste mit Kontextmenu-interagierbaren Elementen
     */
    public ArrayList getInteractable() {
        List<Iinteractable> InteractionList = new ArrayList<Iinteractable>(branchingSwitchList);
        InteractionList.addAll(railList);
        return (ArrayList) InteractionList;
    }


    @Deprecated
    public static float f_PAINT_AREA_HEIGHT = 0.0f;
    /**
     * Dehnungsfaktor in x-Richtung beim Zeichnen von Elmente hier neutales Element 1
     */
    public static float f_STRETCH_X = 1.0f;



    private PlanData(){

        //Astetten
        //createDefaultPlan();
        //Beheim
        //createBeheimPlan();
        try {
            handleDataFromFile();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
        }
        if(SmartLogic.IS_STARTED_AS_SL) {
            RealDbdClient.getInstance();
        }

    }



    private void handleDataFromFile() throws IllegalAccessException {
        try {
            topologyFactory = new TopologyFactory();
            topologyFactory.connectTopology();
            topologyFactory.handleBranchingPoints();
            paintTopologyGraph(new DummyChainageSupply());
            //linkRailsToCrossover();
            topologyFactory.getBalises();

            topologyFactory.mapBalisesToCoordinate();

            setNodeToBranchingPoints();
            setEdges();

            handlePrintings();


            TescModul.getInstance().fetchIntialState();
        } catch (ParseException | JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    private void handlePrintings() {
        if(TranslationModel.TrackplanEnvironment.CurrentEnvironment.
                equals(TranslationModel.TrackplanEnvironment.KaefWilhelmstalEnv)) {


            printKaefWilhelmstal();
        } else if(TranslationModel.TrackplanEnvironment.CurrentEnvironment.
                equals(TranslationModel.TrackplanEnvironment.MartinsteinEnv210609)) {
            printMartinstein();
        }
    }

    private void printMartinstein() {
        ArrayList<String> debugNames = new ArrayList<>();
        debugNames.add("12W4S");
        debugNames.add("12W4L");
        debugNames.add("12W2ABR"); //TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get("C4E67DEB-D839-43C5-B701-0F38131CBE4D");

        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get("F87C984F-4961-4363-BAE8-6D20E1AEF33A");


        System.out.println("Test Martinstein");
        for(String sEdgeDesc : debugNames) {
            System.out.println(sEdgeDesc);
            System.out.println(PlanData.EdgeIdLookupRepo.getModel(sEdgeDesc).getPlanProId());
            System.out.println(PlanData.EdgeIdLookupRepo.getModel(sEdgeDesc).dTopLength);
            System.out.println("#GeoKanten:" + PlanData.EdgeIdLookupRepo.getModel(sEdgeDesc).getPaintListGeo().size());
            System.out.println(sEdgeDesc + "GeoLength");
            ArrayList<CGEOKante> geos = PlanData.EdgeIdLookupRepo.getModel(sEdgeDesc).getPaintListGeo();
            for (CGEOKante gEdge : geos) {
                System.out.println(gEdge.getGEOKanteAllg().getGEOLaenge().getWert());
            }
        }

    }

    private void printKaefWilhelmstal() {
        System.out.println("Test");

        System.out.println("13W4S");
        System.out.println(PlanData.EdgeIdLookupRepo.getModel("13W4S").getPlanProId());

        System.out.println("11W10L");
        System.out.println(PlanData.EdgeIdLookupRepo.getModel("11W10L").getPlanProId());

        System.out.println("13W1R");
        System.out.println(PlanData.EdgeIdLookupRepo.getModel("13W1R").getPlanProId());

        System.out.println("11W5R");
        System.out.println(PlanData.EdgeIdLookupRepo.getModel("11W5R").getPlanProId());


        System.out.println("13W3R");
        System.out.println(PlanData.EdgeIdLookupRepo.getModel("13W3R").getPlanProId());


        System.out.println("13W2S");
        System.out.println(PlanData.EdgeIdLookupRepo.getModel("13W2S").getPlanProId());

        System.out.println("Print 11W8L");

        System.out.println(PlanData.EdgeIdLookupRepo.getModel("11W8L").getPlanProId());

        System.out.println("Print 11W10L");

        System.out.println(PlanData.EdgeIdLookupRepo.getModel("11W10L").getPlanProId());
        System.out.println("Print 13W4S");
        System.out.println(PlanData.EdgeIdLookupRepo.getModel("13W4S").getPlanProId());
        System.out.println("Print 13W1S");
        System.out.println(PlanData.EdgeIdLookupRepo.getModel("13W1S").getPlanProId());
        System.out.println("Print 13W4S");
        System.out.println(PlanData.EdgeIdLookupRepo.getModel("13W4S").getPlanProId());
        System.out.println("Print 11W10L");
        System.out.println(PlanData.EdgeIdLookupRepo.getModel("11W10L").getPlanProId());
    }


    private void setEdges() {
        Collection<TopologyGraph.Edge> edges = PlanData.topGraph.edgeRepo.values();
        ArrayList<TopologyGraph.Edge> setEdges = new ArrayList<>();
        for(TopologyGraph.Edge E : edges) {
            lookupNamesWithinDKW(setEdges, E);

        }
        for(TopologyGraph.Edge E : edges) {
            lookupOtherCrossings(setEdges, E);
        }

    }

    private void lookupOtherCrossings(ArrayList<TopologyGraph.Edge> setEdges, TopologyGraph.Edge e) {
        if(setEdges.contains(e)) return;
        String Ref = null;
        Ref = getRefIdOfEdge(e);
        if (Ref == null) return;
        EdgeIdLookupRepo.update(Ref, e);
        EdgeLookupByIdRepo.update(e, Ref);
    }

    private void lookupNamesWithinDKW(ArrayList<TopologyGraph.Edge> setEdges, TopologyGraph.Edge e) {
        String Ref;
        TopologyConnect RefConnect = null;

        TopologyGraph.Node A = e.A;
        TopologyGraph.Node B = e.B;
        if(checkSameAnlage(A,B,true)) {
            Ref = handleSameAnlage(e);
            EdgeIdLookupRepo.update(Ref, e);
            EdgeLookupByIdRepo.update(e,Ref);
            setEdges.add(e);

        }
    }


    /**
     * Bestimmt den Referenzknoten anhand der Dominierenden Weichenid
     * @param e - TopologyGraph.Edge - Kante für die der Referenz-Knoten ermittelt wird.
     * @return TopologyGraph.Node - Referenzknoten
     * @throws InvalidParameterException - falls keine Referenz hergestellt werden kann
     */
    public static TopologyGraph.Node getRefNode(TopologyGraph.Edge e) throws InvalidParameterException {
        TopologyGraph.Node A = e.A;
        TopologyGraph.Node B = e.B;
        if(checkSameAnlage(A,B,true)) return getRefNodeSameAnlage(e);
        String aId = SwitchIdRepo.getModel(A);
        String bId = SwitchIdRepo.getModel(B);
        if(aId == null && bId == null) throw new InvalidParameterException("Both nodes are not switches");
        boolean isDKW;
        if(aId == null) {
            return e.B;
        } else if(bId == null) {
            return e.A;

        } else {


            int aCrossingNumber = generateCrossingNumber(aId);
            int bCrossingNumber = generateCrossingNumber(bId);
            if(aCrossingNumber < bCrossingNumber) {
               return e.A;
            } else {
               return e.B;
            }


        }

    }

    private static TopologyGraph.Node getRefNodeSameAnlage(TopologyGraph.Edge e) {
        TopologyGraph.Node A = e.A;
        TopologyGraph.Node B = e.B;
        CrossingSwitch CSA = (CrossingSwitch) A.NodeImpl;
        CrossingSwitch CSB = (CrossingSwitch) B.NodeImpl;

        boolean isADominating = isADominating(CSA, CSB);


        if(isADominating) {
            return A;
        } else {
            return B;
        }
    }


    /**
     * Holt aus der Edge die Bereichs-ID
     * @param e - Target Edge
     * @return String - Bereichs-ID
     */

    public static String getRefIdOfEdge(TopologyGraph.Edge e) {
        String Ref;
        TopologyConnect RefConnect = null;

        TopologyGraph.Node A = e.A;
        TopologyGraph.Node B = e.B;

        if(checkSameAnlage(A,B,true)) return handleSameAnlage(e);
        String aId = SwitchIdRepo.getModel(A);
        String bId = SwitchIdRepo.getModel(B);
        if(aId == null && bId == null) return null;
        boolean isDKW;
        if(aId == null) {
            Ref = bId;
            RefConnect = e.TopConnectFromB;

            isDKW = checkSameAnlage(B,B, true);
        } else if(bId == null) {
            Ref = aId;
            RefConnect = e.TopConnectFromA;

            isDKW = checkSameAnlage(A,A, true);
        } else {


            int aCrossingNumber = generateCrossingNumber(aId);
            int bCrossingNumber = generateCrossingNumber(bId);
            if(aCrossingNumber < bCrossingNumber) {
                Ref = aId;
                RefConnect = e.TopConnectFromA;

                isDKW = checkSameAnlage(A,A, true);
            } else {
                Ref = bId;
                RefConnect = e.TopConnectFromB;

                isDKW = checkSameAnlage(B,B, true);
            }


        }
        if(isDKW) {
            CrossingSwitch CS;

            if(Ref.equals(aId)) {
                CS = (CrossingSwitch) A.NodeImpl;
                List<CrossingSwitch> switchList = ISwitchHandler.getCrossingSwitches(CS.getAnlage());
                Ref = getLinkNameToDKW(CS, switchList);
                return refOfNodeConnectingDKW(Ref, A, e ,RefConnect);
            } else {
                CS = (CrossingSwitch) B.NodeImpl;
                List<CrossingSwitch> switchList = ISwitchHandler.getCrossingSwitches(CS.getAnlage());
                Ref = getLinkNameToDKW(CS, switchList);
                return refOfNodeConnectingDKW(Ref, B, e ,RefConnect);
            }


        }
        Ref = addOrientation(Ref, RefConnect);

        return Ref;
    }

    private static String refOfNodeConnectingDKW(String ref, TopologyGraph.Node a, TopologyGraph.Edge e, TopologyConnect refConnect) {
        if(refConnect.equals(TopologyConnect.LINKS)) return ref + "L";
        if(refConnect.equals(TopologyConnect.RECHTS)) return ref + "R";
        for(TopologyGraph.Edge E : a.inEdges) {
            if(e.equals(E)) continue;
            if(checkSameAnlage(E.A,E.B, true)) {
                if (E.getRefId().endsWith("RR")) return ref + "R";
                if (E.getRefId().endsWith("LL")) return ref + "L";
            }
        }
        for(TopologyGraph.Edge E : a.outEdges) {
            if(e.equals(E)) continue;
            if(checkSameAnlage(E.A,E.B, true)) {
                if (E.getRefId().endsWith("RR")) return ref + "R";
                if (E.getRefId().endsWith("LL")) return ref + "L";
            }
        }
        return ref + "E";
    }

    public static String getLinkNameToDKW(CrossingSwitch cs, List<CrossingSwitch> switchList) {
        String sResult = cs.getElement().getBezeichnung().getKennzahl().getWert() + "W";
        Integer iLowerNumber = null;
        int iSearchedNumber = -1;
        for(CrossingSwitch C : switchList) {
            int iW = getCrossNumber(C);
            iLowerNumber = handleLowerNumber(iLowerNumber, iW);
            if(C.equals(cs)) {
                iSearchedNumber = iW;
            }
        }
        if(iLowerNumber == iSearchedNumber) return sResult + iLowerNumber + "AB";
        else return sResult + iLowerNumber + "CD";

    }

    @NotNull
    private static Integer handleLowerNumber(Integer iLowerNumber, int iW) {
        if(iLowerNumber == null ) {
            iLowerNumber = iW;
        } else {
            if(iLowerNumber > iW) iLowerNumber = iW;
        }
        return iLowerNumber;
    }

    private static int getCrossNumber(CrossingSwitch c) {
        int iW = Integer.parseInt(c.getElement().getBezeichnung().getBezeichnungLageplanKurz().getWert());
        return iW;
    }

    @Nullable
    private static String addOrientation(String ref, TopologyConnect refConnect) {
        if(refConnect == null) return ref + "E";
        switch (refConnect) {
            case LINKS: {
                ref += "L";
                break;
            } case RECHTS: {
                ref += "R";
                break;
            } case SPITZE: {
                ref += "S";
                break;
            } default: {
                return "E";
            }

        }
        return ref;
    }

    /**
     * checks if node a and b belongen to same Anlage
     * @param a - Node A
     * @param b - Node B
     * @return true - same anlage else false
     */
    public static boolean checkSameAnlage(TopologyGraph.Node a, TopologyGraph.Node b, boolean shallBeDKW) {
        CrossingSwitch CSA;
        CrossingSwitch CSB;
        try {
            CSA = (CrossingSwitch) a.NodeImpl;
            CSB = (CrossingSwitch) b.NodeImpl;
        } catch(Exception E) {
            return false;
        }
        if(CSA == null || CSB == null) return false;
        if(shallBeDKW && !CSA.getAnlage().getWKrAnlageAllg().getWKrArt().getWert().equals(ENUMWKrArt.DKW)) return false;
        return CSA.isSameAnlage(CSB);
    }

    private static int generateCrossingNumber(String crossId) {
        return Integer.parseInt(crossId.split("W")[1]);
    }


    private void setNodeToBranchingPoints() {
        for(CrossingSwitch CS: RailSwitchList) {
            String switchId;
            List<CPunktObjektTOPKante> planProEdges = null;
            String sEdgeId1 = null;
            String sEdgeId2 = null;
            TopologyGraph.Edge E1 = null;
            TopologyGraph.Edge E2 = null;
            CWKrGspKomponente Komp = CS.getComponent();
            if(Komp == null) continue;
            planProEdges = Komp.getPunktObjektTOPKante();
            if(planProEdges == null) continue;
            if(planProEdges.size() < 2) continue;
            sEdgeId1 = planProEdges.get(0).getIDTOPKante().getWert();
            sEdgeId2 = planProEdges.get(1).getIDTOPKante().getWert();
            E1 = topGraph.edgeRepo.get(sEdgeId1);
            E2 = topGraph.edgeRepo.get(sEdgeId2);
            if(E1 == null || E2 == null) continue;
            TopologyGraph.Node N = null;
            if(E2.A.equals(E1.A) || E2.B.equals(E1.A)) {
                N = E1.A;
            } else if(E2.A.equals(E1.B) || E2.B.equals(E1.B)) {
                N = E1.B;
            }
            if(N == null) {
                if(E1.mergedNodes.contains(E2.A)) {
                    N = E2.A;
                } else if(E1.mergedNodes.contains(E2.B)) {
                    N = E2.B;
                } else if(E2.mergedNodes.contains(E1.A)) {
                    N = E1.A;
                } else if(E2.mergedNodes.contains(E1.B)) {
                    N = E1.B;
                } else throw new NullPointerException("Crossroad not between E1: " + E1.sId + " E2: " + E2.sId);
            }
            N.NodeType = CrossingSwitch.class;
            N.NodeImpl = CS;

            switchId = CS.getEbdTitle(0,false, true);

            N.name = switchId;
            N.TopNodeId = switchId;

            if(switchId != null) {
                if(CS.isDKW()) {
                    ArrayList<CrossingSwitch> switches = ISwitchHandler.getAllSwitches().getModel(CS.getAnlage());
                    int iLowestId = CS.getLocalElementId();
                    for(CrossingSwitch Switch : switches) {
                        if(iLowestId > Switch.getLocalElementId()) {
                            iLowestId = Switch.getLocalElementId();
                        }
                    }
                    String sPrefix = switchId.split("W")[0];
                    String sBetterId = sPrefix + "W" + iLowestId;
                    ISwitchHandler.registerNode(N, sBetterId);
                } else ISwitchHandler.registerNode(N, switchId);
            }




        }
    }

    private static String handleSameAnlage(TopologyGraph.Edge E) {
        String Ref;
        TopologyGraph.Node A = E.A;
        TopologyGraph.Node B = E.B;
        CrossingSwitch CSA = (CrossingSwitch) A.NodeImpl;
        CrossingSwitch CSB = (CrossingSwitch) B.NodeImpl;

        boolean isADominating = isADominating(CSA, CSB);
        CWKrGspElement RefElement = null;

            if(isADominating) {
                Ref =  initRef(CSA);
                Ref = addOrientation(Ref, E.TopConnectFromA);

                return addOrientation(Ref, E.TopConnectFromB);
            } else {
                Ref = initRef(CSB);
                Ref = addOrientation(Ref, E.TopConnectFromB);
                return addOrientation(Ref, E.TopConnectFromA);
            }



    }

    @Nullable
    private static String initRef(CrossingSwitch CS) {
            CWKrGspElement RefElement;
            String Ref;
            RefElement = CS.getElement();
            if(RefElement == null) return null;
            CBezeichnungElement Bez = RefElement.getBezeichnung();
            return Bez.getBezeichnungTabelle().getWert();
    }

    private static boolean isADominating(CrossingSwitch CSA, CrossingSwitch CSB) {

        return Integer.parseInt(CSA.getElement().getBezeichnung().getBezeichnungLageplanKurz().getWert())
                < Integer.parseInt(CSB.getElement().getBezeichnung().getBezeichnungLageplanKurz().getWert());
    }

    /**
     * @deprecated
     */
    private void linkRailsToCrossover() {
        throw new NotImplementedException("deprecated");/*
        Collection<CrossoverModel> models = CrossoverModel.CrossoverRepo.getAll();
        for(CrossoverModel M: models) {
            M.createPositionedRelation();

        }
        */
    }

    private void paintTopologyGraph(ChainageSupplyInterface ChainageSupply) {


        DefaultRepo<TopologyGraph.Node, RailConnector> railConnectorRepo = new DefaultRepo<>();



        // Balisenconnectors

        //Boolean bIsInOutMode = checkHavingOutMode();
        //if(bIsInOutMode == null) throw new InvalidParameterException("No suitable LeftmostNode setted or found");
        Collection<TopologyGraph.Node> nodes = TopologyGraph.NodeRepo.values();
        Stack<TopologyGraph.Node> nodesInQueue = new Stack<TopologyGraph.Node>();
        DefaultRepo<TopologyGraph.Node, Boolean> visitedNodes = new DefaultRepo<>();
        HashSet<TopologyGraph.Edge> visitedEdges = new HashSet<>();
        // visited Edges
        //DefaultRepo<TopologyGraph.Node, Integer> topologicalY = new DefaultRepo<>();
        //DefaultRepo<TopologyGraph.Node, Integer> topologicalX = new DefaultRepo<>();
        HashSet<TopologyGraph.Edge> edgesToPaint = null;
        int currentX = 0;
        int currentY = 1;
        int highestY = 1;
        ArrayList<Integer> reservedYlist = new ArrayList<>();
        for(TopologyGraph.Node N : nodes) {
            visitedNodes.update(N, false);
        }

        nodesInQueue.push(TopologyGraph.getLeftmostNode());
        visitedNodes.update(TopologyGraph.getLeftmostNode(),true);
        //topologicalX.update(TopologyGraph.getLeftmostNode(), 1);
        //topologicalY.update(TopologyGraph.getLeftmostNode(), 1);
        while(!nodesInQueue.isEmpty()) {
            TopologyGraph.Node N = nodesInQueue.pop();
            /*if(currentX < topologicalX.getModel(N)) {
                currentY = 1;
                currentX = topologicalX.getModel(N);
            }*/
            edgesToPaint = new HashSet<>();
            for(TopologyGraph.Edge E : N.outEdges) {

                if(!visitedEdges.contains(E)) {
                    edgesToPaint.add(E);
                }
            }
            for(TopologyGraph.Edge E : N.inEdges) {
                if(!visitedEdges.contains(E)) {
                    edgesToPaint.add(E);
                }
            }

            for(TopologyGraph.Edge E : edgesToPaint) {

                visitedEdges.add(E);
                TopologyGraph.Node N2 = null;
                TopologyConnect ConnectN2 = null;
                TopologyConnect ConnectN = null;
                if(E.A == N) {
                    N2 = E.B;
                    ConnectN2 = E.TopConnectFromB;
                    ConnectN = E.TopConnectFromA;
                } else {
                    N2 = E.A;
                    ConnectN2 = E.TopConnectFromA;
                    ConnectN = E.TopConnectFromB;
                }


                Chainage ChainageN = ChainageSupply.getModel(N);
                Chainage ChainageN2 = ChainageSupply.getModel(N2);

                float x1 = N.getGeoCoordinates().getFloatX();
                float y1 = N.getGeoCoordinates().getFloatY();
                float x2 = N2.getGeoCoordinates().getFloatX();
                float y2 = N2.getGeoCoordinates().getFloatY();

                handleCrossoverInput(N, N2, ConnectN2, ConnectN, ChainageN, ChainageN2, x1, y1, x2, y2);


                if(!visitedNodes.getModel(N2)) {
                    nodesInQueue.push(N2);
                    visitedNodes.update(N2, true);
                    //HandelTopologicalPainting handelTopologicalPainting = new HandelTopologicalPainting(ChainageSupply, topologicalY, topologicalX, currentX, currentY, highestY, reservedYlist, N, N2).invoke();
                    //currentY = handelTopologicalPainting.getCurrentY();







//TODO
                    /*
                    Rail R = new Rail(x1,y1,x2,y2, this.railList,null,null,ChainageN,ChainageN2,ApplicationDirection.BOTH
                            ,vmax  , ApplicationDirection.BOTH, new TrackElementStatus());
                    R.setEdge(E);
                    E.setRail(R);
                    */
                } else {
                    /*

                    Rail R = new Rail(x1,y1,x2,y2, this.railList,null,null,ChainageN,ChainageN2,ApplicationDirection.BOTH
                            ,vmax  , ApplicationDirection.BOTH, new TrackElementStatus());
                    R.setEdge(E);
                    E.setRail(R);

                    */

                }
            }
        }
    }

    private void handleCrossoverInput(TopologyGraph.Node n, TopologyGraph.Node n2, TopologyConnect connectN2, TopologyConnect connectN, Chainage chainageN, Chainage chainageN2, float x1, float y1, float x2, float y2) {
        String sName = "";
        if(connectN2.equals(TopologyConnect.SPITZE)) {
            try {
                sName = ((CrossingSwitch)n2.NodeImpl).getEbdTitle(0,false,true);
            } catch(Exception E) {
                sName = "";
            }
            SingleSlip RailWaySwitchSlip = new SingleSlip(chainageN2);
            BranchingSwitch RailwaySwitch = generateCrossover(RailWaySwitchSlip, x2,
                    y2,sName, BranchingSwitch.ViewType.Branch_LRU);


            CrossoverModel.createCrossoverModel(n2, connectN2, RailWaySwitchSlip, RailwaySwitch);

        }

        if(connectN.equals(TopologyConnect.SPITZE)) {
            try {
                sName = ((CrossingSwitch)n.NodeImpl).getEbdTitle(0,false,true);
            } catch(Exception E) {
                sName = "";
            }
            SingleSlip RailWaySwitchSlip = new SingleSlip(chainageN);
            BranchingSwitch RailwaySwitch = generateCrossover(RailWaySwitchSlip, x1,
                    y1,sName, BranchingSwitch.ViewType.Branch_LRU);


            CrossoverModel.createCrossoverModel(n, connectN, RailWaySwitchSlip, RailwaySwitch);
        }
    }

    /**
     * checks if leftmost Endnode has only out connection or only in connection and is suitable for graph start
     * @return true if is out mode because of having no in node
     * false if it is inMode
     */
    private Boolean checkHavingOutMode() {
        TopologyGraph.Node LeftNode = TopologyGraph.getLeftmostNode();
        if(LeftNode == null) return null;
        else {
            return LeftNode.inEdges.isEmpty();
        }
    }

    /**
     * @deprecated
     * @param BeheimWholeSection
     * @return
     */
    private ArrayList<GradientSegment> generateGradient4Beheim(SectionOfLine BeheimWholeSection) {
        throw new NotImplementedException("deprecated");
        /*
        ArrayList<GradientSegment> gradientProfiles = new ArrayList<>();
        Chainage LeftChainage = new Chainage(0);
        Chainage B2Chainage = new Chainage(982);
        Chainage B4Chainage = new Chainage(1370);
        Chainage B5Chainage = new Chainage(1511);
        Chainage B8Chainage = new Chainage(2565);
        Chainage B9Chainage = new Chainage(2650);
        Chainage B10Chainage = new Chainage(2848);

        SpotLocation LeftLocation = new SpotLocation(LeftChainage, null, BeheimWholeSection);
        SpotLocation B2Location = new SpotLocation(B2Chainage, null, BeheimWholeSection);
        SpotLocation B4Location = new SpotLocation(B4Chainage, null, BeheimWholeSection);
        SpotLocation B5Location = new SpotLocation(B5Chainage, null, BeheimWholeSection);
        SpotLocation B8Location = new SpotLocation(B8Chainage, null, BeheimWholeSection);
        SpotLocation B9Location = new SpotLocation(B9Chainage, null, BeheimWholeSection);
        SpotLocation B10Location = new SpotLocation(B10Chainage, null, BeheimWholeSection);


        GradientSegment GS_0_1000_8 = new GradientSegment(LeftLocation, B2Location, ApplicationDirection.BOTH);
        ETCS_GRADIENT etcsGradient8 = new ETCS_GRADIENT();
        etcsGradient8.bGradient = 8;
        //GS_0_1000_8.setGradient(etcsGradient8, true);
        gradientProfiles.add(GS_0_1000_8);

        GradientSegment GS_1000_1900_0 = new GradientSegment(B2Location, B4Location,ApplicationDirection.BOTH);
        ETCS_GRADIENT etcsGradient0 = new ETCS_GRADIENT();
        etcsGradient0.bGradient = 0;
        //GS_1000_1900_0.setGradient(etcsGradient0, false);
        gradientProfiles.add(GS_1000_1900_0);

        GradientSegment GS_1900_2200_M10 = new GradientSegment(B4Location,B5Location, ApplicationDirection.BOTH);
        ETCS_GRADIENT etcsGradientM10 = new ETCS_GRADIENT();
        etcsGradientM10.bGradient = 10;
        //GS_1900_2200_M10.setGradient(etcsGradientM10, false);
        gradientProfiles.add(GS_1900_2200_M10);

        GradientSegment GS_2200_2800_10 = new GradientSegment(B5Location, B8Location, ApplicationDirection.BOTH);
        ETCS_GRADIENT etcsGradient10 = new ETCS_GRADIENT();
        etcsGradient10.bGradient = 10;
        //GS_2200_2800_10.setGradient(etcsGradient10, true);
        gradientProfiles.add(GS_2200_2800_10);

        GradientSegment GS_2800_3000_M5 = new GradientSegment(B8Location, B9Location, ApplicationDirection.BOTH);
        ETCS_GRADIENT etcsGradientM5 = new ETCS_GRADIENT();
        etcsGradientM5.bGradient = 5;
        //GS_2800_3000_M5.setGradient(etcsGradientM5, false);
        gradientProfiles.add(GS_2800_3000_M5);

        GradientSegment GS_3000_3500_0 = new GradientSegment(B9Location, B10Location, ApplicationDirection.BOTH);
        //GS_3000_3500_0.setGradient(etcsGradient0, false);
        gradientProfiles.add(GS_3000_3500_0);







        return gradientProfiles;

         */
    }
/*
    private void createBeheimPlan() {
        SingleTrainSubPanel.xFactor = 0.1f;
        Chainage LeftChainage = new Chainage(0);
        Chainage RightChainage = new Chainage(2848);

        Chainage B1Chainage = new Chainage(584);
        Chainage B2Chainage = new Chainage(982);
        Chainage B3Chainage = new Chainage(1328);
        Chainage B4Chainage = new Chainage(1370);
        Chainage B5Chainage = new Chainage(1511);
        Chainage B5Con6Chainage = new Chainage(2000);
        Chainage B6Chainage = new Chainage(2000);
        Chainage B7Chainage = new Chainage(2440);
        Chainage B8Chainage = new Chainage(2565);
        Chainage B9Chainage = new Chainage(2650);
        Chainage B9Con10Chainage = new Chainage(2714);


        // left to right rails
        EdgeOfMap LeftEnd = new EdgeOfMap("Left Adorf");
        LeftEnd.setChainageBeginn(LeftChainage);
        LeftEnd.setChainageEnd(LeftChainage);
        RightEnd = new EdgeOfMap("Right Cehausen");
        RightEnd.setChainageBeginn(RightChainage);
        RightEnd.setChainageEnd(RightChainage);

        // Balisenconnectors
        connectorList = new ArrayList<RailConnector>();
        for(int i = 0; i <= 10; i++) {
            connectorList.add(new RailConnector("B ".concat(String.valueOf(i))));
        }



        //Rails
        //Rail LeftW14 = new Rail(0.0d, 150.0d, 400d, 150.0d, this.railList, LeftEnd,
        //      CW14.getBranchingPoint(), LeftChainage, CCW14, ApplicationDirection.BOTH, 250,
        //      ApplicationDirection.BOTH, new TrackElementStatus(), "Left Astetten - W14");

        Rail LeftTo1 = new Rail(0.0d, 150.0d, 40.0d, 150.0d, this.railList, LeftEnd,
                connectorList.get(1), LeftChainage, B1Chainage, ApplicationDirection.BOTH, 120, ApplicationDirection.BOTH,
                new TrackElementStatus(), "Adorf - Beheim");

        Rail Rail1To2 = new Rail(40.0d, 150.0d, 100.0d, 150.0d, this.railList, connectorList.get(1), connectorList.get(2),
                    B1Chainage, B2Chainage, ApplicationDirection.BOTH, 120, ApplicationDirection.BOTH,
                    new TrackElementStatus(), "Adorf - Beheim - 2"
                );
        Rail Rail2To3 = new Rail(100.0d, 150.0d, 140.0d, 150.0d, this.railList, connectorList.get(2),
                connectorList.get(3), B2Chainage, B3Chainage, ApplicationDirection.BOTH, 80, ApplicationDirection.BOTH,
                new TrackElementStatus(), "Beheim");

        Rail Rail3To4 = new Rail(140.0d, 150.0d, 190.0d, 150.0d, this.railList, connectorList.get(3),
                connectorList.get(4), B3Chainage, B4Chainage, ApplicationDirection.BOTH, 80, ApplicationDirection.BOTH,
                new TrackElementStatus(), "Beheim 2");

        Rail Rail4To5 = new Rail(190.0d, 150.0d, 220.0d, 150.0d, this.railList, connectorList.get(4),
                connectorList.get(5), B4Chainage, B5Chainage, ApplicationDirection.BOTH, 140,
                ApplicationDirection.BOTH, new TrackElementStatus(), "Beheim - Cehausen 1");

        Rail Rail5T5Half = new Rail(220.0d, 150.0d, 230.0d, 150.0d, this.railList,
                connectorList.get(5), ConnectorBetween5To6, B5Chainage, B5Con6Chainage, ApplicationDirection.BOTH,
                140, ApplicationDirection.BOTH, new TrackElementStatus(), "Beheim - Cehausen 2"
        );
        Rail Rail5HalfTo6 = new Rail(230.0d, 150.0d, 240.0d, 150.0d, this.railList,
            ConnectorBetween5To6, connectorList.get(6), B5Con6Chainage, B6Chainage, ApplicationDirection.BOTH,
            140, ApplicationDirection.BOTH, new TrackElementStatus(), "Beheim - Cehausen 3"
        );
        Rail Rail6To7 = new Rail(240.0d, 150.0d, 250.0d, 150.0d, this.railList,
                connectorList.get(6),
            connectorList.get(7), B6Chainage, B7Chainage, ApplicationDirection.BOTH, 120, ApplicationDirection.BOTH,
            new TrackElementStatus(), "Beheim - Cehausen 4"
        );
        Rail Rail7To8 = new Rail(250.0d, 150.0d, 280.0d, 150.0d, this.railList,
                connectorList.get(7), connectorList.get(8), B7Chainage, B8Chainage, ApplicationDirection.BOTH,
                100, ApplicationDirection.BOTH, new TrackElementStatus(), "Beheim - Cehausen 5"
        );
        Rail Rail8To9 = new Rail(280.0d, 150.0d, 300.0d, 150.0d, this.railList, connectorList.get(8),
                connectorList.get(9), B8Chainage, B9Chainage, ApplicationDirection.BOTH, 100, ApplicationDirection.BOTH,
                new TrackElementStatus(), "Cehausen 1");
        Rail Rail9To9Half = new Rail(300.0d, 150.0d, 320.0d, 150.0d, this.railList,
            connectorList.get(9), ConnectorBetween9To10, B9Chainage, B9Con10Chainage, ApplicationDirection.BOTH,
            100, ApplicationDirection.BOTH, new TrackElementStatus(), "Cehausen 2"
        );
        Rail Rail9HalfTo10 = new Rail(320.0d, 150.0d, 350.0d, 150.0d, this.railList,
            ConnectorBetween9To10, connectorList.get(10), B9Con10Chainage, RightChainage,
            ApplicationDirection.BOTH, 100, ApplicationDirection.BOTH, new TrackElementStatus(),
                "Cehausen Ende"
        );

        PositionedRelation PositionLCon1 = new PositionedRelation();
        PositionLCon1.createPositionedRelation(connectorList.get(1), LeftTo1.getTrackReference(), Rail1To2.getTrackReference(), true, 120,
                ApplicationDirection.BOTH, new TrackElementStatus());

        ArrayList<PositionedRelation> list = new ArrayList<PositionedRelation>();
        list.add(PositionLCon1);

        connectorList.get(1).updatePositionedRelation(list);

        PositionedRelation PositionCon2 = new PositionedRelation();
        PositionCon2.createPositionedRelation(connectorList.get(2), Rail1To2.getTrackReference(), Rail2To3.getTrackReference(), true, 80,
                ApplicationDirection.BOTH, new TrackElementStatus());

        list = new ArrayList<PositionedRelation>();
        list.add(PositionCon2);

        connectorList.get(2).updatePositionedRelation(list);

        PositionedRelation PositionCon3 = new PositionedRelation();

        PositionCon3.createPositionedRelation(connectorList.get(3), Rail2To3.getTrackReference(), Rail3To4.getTrackReference(), true, 80,
                ApplicationDirection.BOTH, new TrackElementStatus());

        list = new ArrayList<PositionedRelation>();
        list.add(PositionCon3);

        connectorList.get(3).updatePositionedRelation(list);

        PositionedRelation PositionCon4 = new PositionedRelation();
        PositionCon4.createPositionedRelation(connectorList.get(4), Rail3To4.getTrackReference(), Rail4To5.getTrackReference(), true, 80,
                ApplicationDirection.BOTH, new TrackElementStatus());
        list = new ArrayList<PositionedRelation>();
        list.add(PositionCon4);

        connectorList.get(4).updatePositionedRelation(list);

        PositionedRelation PositionCon5 = new PositionedRelation();
        PositionCon5.createPositionedRelation(connectorList.get(5), Rail4To5.getTrackReference(), Rail5T5Half.getTrackReference(),true, 140,
                ApplicationDirection.BOTH, new TrackElementStatus());
        list = new ArrayList<PositionedRelation>();
        list.add(PositionCon5);

        connectorList.get(5).updatePositionedRelation(list);

        PositionedRelation PositionCon5Half = new PositionedRelation();
        PositionCon5Half.createPositionedRelation(ConnectorBetween5To6, Rail5T5Half.getTrackReference(), Rail5HalfTo6.getTrackReference(),true, 120,
                ApplicationDirection.BOTH, new TrackElementStatus());
        list = new ArrayList<PositionedRelation>();
        list.add(PositionCon5Half);

        ConnectorBetween5To6.updatePositionedRelation(list);

        PositionedRelation PositionCon6 = new PositionedRelation();
        PositionCon5.createPositionedRelation(connectorList.get(6), Rail5T5Half.getTrackReference(), Rail6To7.getTrackReference(),true, 120,
                ApplicationDirection.BOTH, new TrackElementStatus());
        list = new ArrayList<PositionedRelation>();
        list.add(PositionCon6);

        connectorList.get(6).updatePositionedRelation(list);

        PositionedRelation PositionCon7 = new PositionedRelation();
        PositionCon7.createPositionedRelation(connectorList.get(7), Rail6To7.getTrackReference(), Rail7To8.getTrackReference(),true, 100,
                ApplicationDirection.BOTH, new TrackElementStatus());
        list = new ArrayList<PositionedRelation>();
        list.add(PositionCon7);

        connectorList.get(7).updatePositionedRelation(list);

        PositionedRelation PositionCon8 = new PositionedRelation();
        PositionCon8.createPositionedRelation(connectorList.get(8), Rail7To8.getTrackReference(), Rail8To9.getTrackReference(), true, 100,
                ApplicationDirection.BOTH, new TrackElementStatus());
        list = new ArrayList<PositionedRelation>();
        list.add(PositionCon8);

        connectorList.get(8).updatePositionedRelation(list);

        PositionedRelation PositionCon9 = new PositionedRelation();
        PositionCon9.createPositionedRelation(connectorList.get(9), Rail8To9.getTrackReference(), Rail9To9Half.getTrackReference(), true, 100,
                ApplicationDirection.BOTH, new TrackElementStatus());

        list = new ArrayList<PositionedRelation>();
        list.add(PositionCon9);

        connectorList.get(9).updatePositionedRelation(list);

        PositionedRelation PositionCon9Half = new PositionedRelation();
        PositionCon9Half.createPositionedRelation(ConnectorBetween9To10, Rail9To9Half.getTrackReference(), Rail9HalfTo10.getTrackReference(), true, 100,
                    ApplicationDirection.BOTH, new TrackElementStatus());

        list = new ArrayList<PositionedRelation>();
        list.add(PositionCon9Half);
        ConnectorBetween9To10.updatePositionedRelation(list);

        PositionedRelation EndRelation = new PositionedRelation();
        EndRelation.createPositionedRelation(RightEnd,Rail9HalfTo10.getTrackReference(), null, true, 0, ApplicationDirection.BOTH, new TrackElementStatus());
        list = new ArrayList<PositionedRelation>();
        list.add(EndRelation);
        RightEnd.updatePositionedRelation(list);
        SectionOfLine MainLine = new SectionOfLine();
        this.sectionList.add(MainLine);
        this.gradientSegmentList = this.generateGradient4Beheim(MainLine);
        MainLine.gradientLocations = this.gradientSegmentList;
        MainLine.addRails(this.railList);


    }
*/
    private BranchingSwitch generateCrossover(SingleSlip Point, double x, double y, String sName,
                                              BranchingSwitch.ViewType ViewType
                                              ) {


        // can have also equal x Position then isLeftOf returns null




        BranchingSwitch C = BranchingSwitch.createCrossover(null, Point, x,y, sName,
                ViewType);
        this.branchingSwitchList.add(C);

        return C;
    }
    /*
    private BranchingSwitch generateCrossover(DoubleSlip Point, double x, double y, String sName

                                              ) {
        // can have also equal x Position then isLeftOf returns null

        BranchingSwitch C = BranchingSwitch.createCrossover(null, Point, x,y, sName );
        this.branchingSwitchList.add(C);
        PlanData.TrackElementPositionCalc.put(Point.getFirstSlipA().getRemotePoint(), C);
        PlanData.TrackElementPositionCalc.put(Point.getSecondSlipB().getRemotePoint(), C);
        return C;
    }*/

    /**
     * Manuelles bearbeiten der Gradienten
     * @param subscription - subcribe
     */
    @Deprecated
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.GradientSubscription = subscription;
        this.GradientSubscription.request(1);
    }
    /**
    * Manuelles bearbeiten der Gradienten
    */
    @Deprecated
    @Override
    public void onNext(GradientProfile item) {
        this.GP = item;
        this.GradientSubscription.request(1);
    }
    /**
     * Manuelles bearbeiten der Gradienten
     */
    @Deprecated
    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
    /**
     * Manuelles bearbeiten der Gradienten
     */
    @Deprecated
    @Override
    public void onComplete() {

    }
    /*
    @Deprecated
    private class HandelTopologicalPainting {
        private ChainageSupplyInterface chainageSupply;
        private DefaultRepo<TopologyGraph.Node, Integer> topologicalY;
        private DefaultRepo<TopologyGraph.Node, Integer> topologicalX;
        private int currentX;
        private int currentY;
        private int highestY;
        private ArrayList<Integer> reservedYlist;
        private TopologyGraph.Node n;
        private TopologyGraph.Node n2;
        private float x1;
        private float y1;
        private float x2;
        private float y2;
        private Chainage chainageN2;

        public HandelTopologicalPainting(ChainageSupplyInterface ChainageSupply, DefaultRepo<TopologyGraph.Node, Integer> topologicalY, DefaultRepo<TopologyGraph.Node, Integer> topologicalX, int currentX, int currentY, int highestY, ArrayList<Integer> reservedYlist, TopologyGraph.Node n, TopologyGraph.Node n2) {
            chainageSupply = ChainageSupply;
            this.topologicalY = topologicalY;
            this.topologicalX = topologicalX;
            this.currentX = currentX;
            this.currentY = currentY;
            this.highestY = highestY;
            this.reservedYlist = reservedYlist;
            this.n = n;
            this.n2 = n2;
        }

        public int getCurrentY() {
            return currentY;
        }

        public int getHighestY() {
            return highestY;
        }

        public float getX1() {
            return x1;
        }

        public float getY1() {
            return y1;
        }

        public float getX2() {
            return x2;
        }

        public float getY2() {
            return y2;
        }

        public Chainage getChainageN2() {
            return chainageN2;
        }

        public HandelTopologicalPainting invoke() {
            topologicalX.update(n2, currentX + 1);
            currentY++;
            while(reservedYlist.contains(currentY)) {
                currentY++;
            }
            topologicalY.update(n2, currentY);
            if(highestY < currentY) {
                highestY = currentY;
            }
            x1 = topologicalX.getModel(n);
            y1 = topologicalY.getModel(n);
            x2 = topologicalX.getModel(n2);
            y2 = topologicalY.getModel(n2);

            chainageN2 = chainageSupply.getModel(n2);
            Chainage ChainageN1 = chainageSupply.getModel(n);
            return this;
        }
    }

     */
}
