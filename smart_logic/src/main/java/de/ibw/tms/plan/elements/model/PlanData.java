package de.ibw.tms.plan.elements.model;

import de.ibw.feed.BaliseExtractor;
import de.ibw.tms.etcs.ETCS_GRADIENT;
import de.ibw.tms.gradient.profile.GradientTrailModel;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.physical.*;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.ma.topologie.PositionedRelation;
import de.ibw.tms.plan.elements.BranchingSwitch;
import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.TopRailReturn;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.PlanProTmsAdapter;
import de.ibw.tms.plan_pro.adapter.topology.DummyChainageSupply;
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ChainageSupplyInterface;
import de.ibw.tms.trackplan.ui.PlatformEdge;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import de.ibw.tms.train.ui.SingleTrainSubPanel;
import de.ibw.util.DefaultRepo;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektTOPKante;
import plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspKomponente;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.Flow;

public class PlanData implements Flow.Subscriber<GradientProfile> {

    //public static double dZoomFactor = 2d;
    public static double dTranslateX = -1000d;
    public static double dTranslateY = 0d;




    private List<GradientSegment> gradientSegmentList = new ArrayList<GradientSegment>();
    private List<SectionOfLine> sectionList = new ArrayList<SectionOfLine>();

    public void setGradientSegmentList(List<GradientSegment> gradientSegmentList) {
        this.gradientSegmentList = gradientSegmentList;
    }

    /**
     * Key-String is id of GeoKnoten
     */
    public static DefaultRepo<String, GeoCoordinates> GeoNodeRepo = new DefaultRepo<>();
    public static DefaultRepo<String, PlatformEdge> PlatformRepo = new DefaultRepo<>();
    public static DefaultRepo<String, Trail> TrailRepo = new DefaultRepo<>();
    public static TopologyGraph topGraph;
    public static int vmax = 160; // km/h

    public static class TrackElementPositionCalc {
        private static HashMap<TrackElement, Line2D.Double> positionMap = new HashMap<TrackElement, Line2D.Double>();
        private static HashMap<TrackElement, Point2D.Double> pointMap = new HashMap<TrackElement, Point2D.Double>();

        public static void put(TrackElement TE, Line2D.Double Line) {
            positionMap.put(TE, Line);
        }
        public static void put(TrackElement TE, Point2D.Double Point) {
            pointMap.put(TE, Point);
        }

        public static Line2D.Double translateTeToGraphic(TrackElement TE) {
            return positionMap.get(TE);
        }

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


    }


    private static PlanData instance;

    public static PlanData getInstance() {
        if(instance == null) {
            instance = new PlanData();
        }
        return instance;
    }

    public static ArrayList<RailConnector> connectorList = new ArrayList<RailConnector>();
    public static RailConnector ConnectorBetween5To6 = new RailConnector("Con Between 5 And 6");
    public static RailConnector ConnectorBetween9To10 = new RailConnector("Con Between 9 And 10");
    public static EdgeOfMap RightEnd;
    public static ArrayList<TrackElement> trainOccupiedList = new ArrayList<TrackElement>();
    public static ArrayList<CrossingSwitch> RailSwitchList = new ArrayList<>();


    public static void setData(PlanData P) {
        instance = P;
    }

    public static void putGradientData(GradientTrailModel key, ArrayList<GradientSegment> values) {
        PlanData.getInstance();
        instance.GradientMap.put(key,values);
    }

    public HashMap<GradientTrailModel, ArrayList<GradientSegment>> GradientMap = new HashMap<GradientTrailModel, ArrayList<GradientSegment>>();

    private GradientProfile GP = new GradientProfile(null);
    private Flow.Subscription GradientSubscription;


    // Read data from panel in case user made any changes

    private String sTitle = "Gleisplan";

    public ArrayList<Rail> railList = new ArrayList<Rail>();
    public ArrayList<TopRailReturn> returnRailEdge = new ArrayList<TopRailReturn>();
    public ArrayList<BranchingSwitch> branchingSwitchList = new ArrayList<BranchingSwitch>();
    public HashMap<TrackElement, Double> HeightMap = new HashMap<TrackElement, Double>();


    public ArrayList getInteractable() {
        List<Iinteractable> InteractionList = new ArrayList<Iinteractable>(branchingSwitchList);
        InteractionList.addAll(railList);
        return (ArrayList) InteractionList;
    }



    public static float f_PAINT_AREA_HEIGHT = 0.0f;
    public static float f_STRETCH_X = 1.0f;



    private PlanData(){

        //Astetten
        //createDefaultPlan();
        //Beheim
        //createBeheimPlan();
        handleDataFromFile();

    }



    private void handleDataFromFile() {
        try {
            createFromFile();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void createFromFile() throws JAXBException, ParseException {
        JAXBContext jaxbContext = JAXBContext.newInstance(plan_pro.modell.planpro._1_9_0.ObjectFactory.class);

        //2. Use JAXBContext instance to create the Unmarshaller.
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        //3. Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.
        JAXBElement<CPlanProSchnittstelle> unmarshalledObject =
                (JAXBElement<plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle>)unmarshaller.unmarshal(
                        ClassLoader.getSystemResourceAsStream(
                                TranslationModel.TrackplanEnvironment.CurrentEnvironment.resourceLocation));

        //4. Get the instance of the required JAXB Root Class from the JAXBElement.
        plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle expenseObj = unmarshalledObject.getValue();
        System.out.println(expenseObj.getLSTZustand().getContainer().getGEOKante().size());

        PlanProTmsAdapter tmsAdapter = new PlanProTmsAdapter(PlanProTmsAdapter.PlanProVersion.V1_9_0_PATCHED, expenseObj);
        paintTopologyGraph(new DummyChainageSupply());
        linkRailsToCrossover();
        BaliseExtractor.getBalises(expenseObj, BaliseExtractor.ExtractorModeEnum.NORMAL);

        tmsAdapter.mapBalisesToCoordinate();

        setNodeToBranchingPoints();

    }

    private void setNodeToBranchingPoints() {
        for(CrossingSwitch CS: RailSwitchList) {
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
            E1 = topGraph.EdgeRepo.get(sEdgeId1);
            E2 = topGraph.EdgeRepo.get(sEdgeId2);
            if(E1 == null || E2 == null) continue;



        }
    }

    private void linkRailsToCrossover() {
        Collection<CrossoverModel> models = CrossoverModel.CrossoverRepo.getAll();
        for(CrossoverModel M: models) {
            M.createPositionedRelation();
        }

    }

    private void paintTopologyGraph(ChainageSupplyInterface ChainageSupply) {


        DefaultRepo<TopologyGraph.Node, RailConnector> railConnectorRepo = new DefaultRepo<>();
        EdgeOfMap LeftEnd = new EdgeOfMap("Left Adorf");
        LeftEnd.setChainageBeginn(new Chainage(0));
        LeftEnd.setChainageEnd(new Chainage(0));
        RightEnd = new EdgeOfMap("Right Cehausen");
        RightEnd.setChainageBeginn(new Chainage(1000));
        RightEnd.setChainageEnd(new Chainage(1000));


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
                    Rail R = new Rail(x1,y1,x2,y2, this.railList,null,null,ChainageN,ChainageN2,ApplicationDirection.BOTH
                            ,vmax  , ApplicationDirection.BOTH, new TrackElementStatus(), "");
                    R.setEdge(E);
                    E.setRail(R);
                } else {


                    Rail R = new Rail(x1,y1,x2,y2, this.railList,null,null,ChainageN,ChainageN2,ApplicationDirection.BOTH
                            ,vmax  , ApplicationDirection.BOTH, new TrackElementStatus(), "");
                    R.setEdge(E);
                    E.setRail(R);



                }
            }
        }
    }

    private void handleCrossoverInput(TopologyGraph.Node n, TopologyGraph.Node n2, TopologyConnect connectN2, TopologyConnect connectN, Chainage chainageN, Chainage chainageN2, float x1, float y1, float x2, float y2) {
        if(connectN2.equals(TopologyConnect.SPITZE)) {

            SingleSlip RailWaySwitchSlip = new SingleSlip(chainageN2);
            BranchingSwitch RailwaySwitch = generateCrossover(RailWaySwitchSlip, x2,
                    y2,"", BranchingSwitch.ViewType.Branch_LRU);


            CrossoverModel.createCrossoverModel(n2, connectN2, RailWaySwitchSlip, RailwaySwitch);

        }

        if(connectN.equals(TopologyConnect.SPITZE)) {
            SingleSlip RailWaySwitchSlip = new SingleSlip(chainageN);
            BranchingSwitch RailwaySwitch = generateCrossover(RailWaySwitchSlip, x1,
                    y1,"", BranchingSwitch.ViewType.Branch_LRU);


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

    private ArrayList<GradientSegment> generateGradient4Beheim(SectionOfLine BeheimWholeSection) {
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
        GS_0_1000_8.setGradient(etcsGradient8, true);
        gradientProfiles.add(GS_0_1000_8);

        GradientSegment GS_1000_1900_0 = new GradientSegment(B2Location, B4Location,ApplicationDirection.BOTH);
        ETCS_GRADIENT etcsGradient0 = new ETCS_GRADIENT();
        etcsGradient0.bGradient = 0;
        GS_1000_1900_0.setGradient(etcsGradient0, false);
        gradientProfiles.add(GS_1000_1900_0);

        GradientSegment GS_1900_2200_M10 = new GradientSegment(B4Location,B5Location, ApplicationDirection.BOTH);
        ETCS_GRADIENT etcsGradientM10 = new ETCS_GRADIENT();
        etcsGradientM10.bGradient = 10;
        GS_1900_2200_M10.setGradient(etcsGradientM10, false);
        gradientProfiles.add(GS_1900_2200_M10);

        GradientSegment GS_2200_2800_10 = new GradientSegment(B5Location, B8Location, ApplicationDirection.BOTH);
        ETCS_GRADIENT etcsGradient10 = new ETCS_GRADIENT();
        etcsGradient10.bGradient = 10;
        GS_2200_2800_10.setGradient(etcsGradient10, true);
        gradientProfiles.add(GS_2200_2800_10);

        GradientSegment GS_2800_3000_M5 = new GradientSegment(B8Location, B9Location, ApplicationDirection.BOTH);
        ETCS_GRADIENT etcsGradientM5 = new ETCS_GRADIENT();
        etcsGradientM5.bGradient = 5;
        GS_2800_3000_M5.setGradient(etcsGradientM5, false);
        gradientProfiles.add(GS_2800_3000_M5);

        GradientSegment GS_3000_3500_0 = new GradientSegment(B9Location, B10Location, ApplicationDirection.BOTH);
        GS_3000_3500_0.setGradient(etcsGradient0, false);
        gradientProfiles.add(GS_3000_3500_0);







        return gradientProfiles;
    }

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


    private void createDefaultPlan() {
        // First define all Brachnes
        // Second connect rails
        // Third connect waychanges

        Chainage LeftChainage = new Chainage(0);
        Chainage RightChainage = new Chainage(635);
        // left to right rails
        EdgeOfMap LeftEnd = new EdgeOfMap("Left Astetten");
        LeftEnd.setChainageBeginn(LeftChainage);
        LeftEnd.setChainageEnd(LeftChainage);
        EdgeOfMap RightEnd = new EdgeOfMap("Astetten - BÜ1");
        RightEnd.setChainageBeginn(RightChainage);
        RightEnd.setChainageEnd(RightChainage);


        // CW14
        Chainage CCW14 = new Chainage(400);
        SingleSlip SlipCW14 = new SingleSlip(CCW14);
        //Rail R00W14 = new Rail(10.0d, 50.0d, 49.9d, 50.0d, this.railList, LeftEnd,CCW14);
        BranchingSwitch CW14 = generateCrossover(SlipCW14, 400.0d, 150.0d, "W14",
                BranchingSwitch.ViewType.Branch_ORL);
        // CW15
        Chainage CCW15 = new Chainage(450);
        SingleSlip SlipCW15 = new SingleSlip(CCW15);
        BranchingSwitch CW15 = generateCrossover(SlipCW15, 450.0d, 150.0d, "W15",//TODO
                BranchingSwitch.ViewType.Branch_RLO);
        //CW12//13
        Chainage CCW1213 = new Chainage(300);
        DoubleSlip SlipCW1213 = new DoubleSlip(CCW1213);
        BranchingSwitch CW1213 = generateCrossover(SlipCW1213, 300.0d, 100.0d, "W12 W13");
        //CW16
        Chainage CCW16 = new Chainage(500);
        SingleSlip SlipCW16 = new SingleSlip(CCW16);
        BranchingSwitch CW16 = generateCrossover(SlipCW16, 500.0d, 100.0d, "W16",
                BranchingSwitch.ViewType.Branch_LRU
                );
        //CCW11
        Chainage CCW11 = new Chainage(200);
        SingleSlip SlipCW11 = new SingleSlip(CCW11);
        BranchingSwitch CW11 = generateCrossover(SlipCW11, 200.0d, 50.0d, "W11",
            BranchingSwitch.ViewType.Branch_ULR
        );

        // Rails

        Rail LeftW14 = new Rail(0.0d, 150.0d, 400d, 150.0d, this.railList, LeftEnd,
                CW14.getBranchingPoint(), LeftChainage, CCW14, ApplicationDirection.BOTH, 250,
                ApplicationDirection.BOTH, new TrackElementStatus(), "Left Astetten - W14");



        Rail W14W15 = new Rail(400.0d, 150.0d, 450d, 150.0d, this.railList, CW14.getBranchingPoint(),
                CW15.getBranchingPoint(), CCW14, CCW15, ApplicationDirection.BOTH, 250,
                ApplicationDirection.BOTH, new TrackElementStatus(), "W14 - W15");

        Rail W15Right = new Rail(450.0d, 150.0d, 635.0d, 150.0d, this.railList, CW15.getBranchingPoint(),
                RightEnd, CCW15, RightChainage, ApplicationDirection.BOTH, 250, ApplicationDirection.BOTH,
                new TrackElementStatus(), "W15 - BÜ");

        // Rails 2. Reihe
        Rail LeftW12 = new Rail(0.0d, 100.0d, 300.0d, 100.0d, this.railList, LeftEnd,
                CW1213.getBranchingPoint(), LeftChainage, CCW1213, ApplicationDirection.BOTH, 250,
                ApplicationDirection.BOTH, new TrackElementStatus(), "Left Astetten - W12/13");
        Rail W12W16 = new Rail(300.0d, 100.0d, 500.0d, 100.0d, this.railList, CW1213.getBranchingPoint(),
                CW16.getBranchingPoint(), CCW1213, CCW16, ApplicationDirection.BOTH, 250,
                ApplicationDirection.BOTH, new TrackElementStatus(), "W12/13 - W16");
        Rail W16Right = new Rail(500.0d, 100.0d, 635.0d, 100.0d, this.railList, CW16.getBranchingPoint(),
                RightEnd,CCW16, RightChainage, ApplicationDirection.BOTH, 250, ApplicationDirection.BOTH,
                new TrackElementStatus(), "W16 - BÜ");

        // Rails 3. Reihe
        Rail LeftW11 = new Rail(0.0d, 50.0d, 200.0d, 50.0d, this.railList, LeftEnd, CW11.getBranchingPoint(),
            LeftChainage, CCW11, ApplicationDirection.BOTH, 60, ApplicationDirection.BOTH,
                new TrackElementStatus(), "Left Astetten - W11");
        // Rail 3. Reihe zum Gleisbock (Gleisbock als Ende rechts)
        Rail W11Right = new Rail(200.0d, 50.0d, 635.0d, 50.0d, this.railList,
                CW11.getBranchingPoint(), RightEnd, CCW11, RightChainage, ApplicationDirection.BOTH, 60,
                ApplicationDirection.BOTH, new TrackElementStatus() , "W11 - BÜ");

        // Quergleise 1. Reihe bis 2. Reihe
        Rail W12W14 = new Rail(300.0d, 100.0d, 400.0d, 150.0d, this.railList, CW1213.getBranchingPoint(),
                CW14.getBranchingPoint(), CCW1213, CCW14, ApplicationDirection.BOTH, 60, ApplicationDirection.BOTH,
                new TrackElementStatus(), "W12/13 - W14");
        Rail W15W16 = new Rail(450.0d, 150.0d, 500.0d, 100.0d, this.railList,
                CW15.getBranchingPoint(), CW16.getBranchingPoint(), CCW15, CCW16, ApplicationDirection.BOTH, 60,
                ApplicationDirection.BOTH, new TrackElementStatus(), "W15 - W16");

        //Quergleise 2.bis 3. Reihe
        Rail W11W12 = new Rail(200.0d, 50.0d, 300.0d, 100.0d, this.railList, CW11.getBranchingPoint(),
                CW1213.getBranchingPoint(), CCW11, CCW1213, ApplicationDirection.BOTH, 60, ApplicationDirection.BOTH,
                new TrackElementStatus(), "W11 - W12/13");


        //Weiche W14
        PositionedRelation PositionLW14W15 = new PositionedRelation();
        PositionLW14W15.createPositionedRelation((TrackElement) CW14.getBranchingPoint(),(TrackElement) LeftW14.getTrailModel(),(TrackElement) W14W15.getTrailModel(), true, 250, ApplicationDirection.BOTH, new TrackElementStatus() );
        PositionedRelation PositionW12W14W15 = new PositionedRelation();
        PositionW12W14W15.createPositionedRelation((TrackElement) CW14.getBranchingPoint(),W12W14.getTrailModel(),(TrackElement) W14W15.getTrailModel(), true, 60, ApplicationDirection.BOTH, new TrackElementStatus() );

        List<PositionedRelation> list = new ArrayList<PositionedRelation>();
        list.add(PositionW12W14W15);
        list.add(PositionLW14W15);



        SlipCW14.updatePositionedRelation(list);
        SlipCW14.setOutputRelation(PositionLW14W15);

        //Weiche W15
        PositionedRelation PositionW14W15R = new PositionedRelation();
        PositionW14W15R.createPositionedRelation((TrackElement) CW15.getBranchingPoint(),(TrackElement) W14W15.getTrailModel(),(TrackElement) W15Right.getTrailModel(), true, 250, ApplicationDirection.BOTH, new TrackElementStatus() );
        PositionedRelation PositionW14W15W16 = new PositionedRelation();
        PositionW14W15W16.createPositionedRelation((TrackElement) CW15.getBranchingPoint(),W14W15.getTrailModel(),(TrackElement) W15W16.getTrailModel(), true, 60, ApplicationDirection.BOTH, new TrackElementStatus() );

        list = new ArrayList<PositionedRelation>();
        list.add(PositionW14W15R);
        list.add(PositionW14W15W16);

        SlipCW15.updatePositionedRelation(list);
        SlipCW15.setOutputRelation(PositionW14W15R);

        //Weiche W1213
        PositionedRelation PositionLW12W13VersionA = new PositionedRelation();
        PositionLW12W13VersionA.createPositionedRelation((TrackElement) CW1213.getBranchingPoint(),(TrackElement) LeftW12.getTrailModel(),(TrackElement) W12W16.getTrailModel(), true, 250, ApplicationDirection.BOTH, new TrackElementStatus() );
        PositionedRelation PositionLW12W13VersionB = new PositionedRelation();
        PositionLW12W13VersionB.createPositionedRelation((TrackElement) CW1213.getBranchingPoint(),(TrackElement) LeftW12.getTrailModel(),(TrackElement) W12W14.getTrailModel(), true, 60, ApplicationDirection.BOTH, new TrackElementStatus() );

        PositionedRelation PositionW11W13W12VersionA = new PositionedRelation();
        PositionW11W13W12VersionA.createPositionedRelation((TrackElement) CW1213.getBranchingPoint(),(TrackElement) W11W12.getTrailModel(),(TrackElement) W12W14.getTrailModel(), true, 250, ApplicationDirection.BOTH, new TrackElementStatus() );
        PositionedRelation PositionW11W13W12VersionB = new PositionedRelation();
        PositionW11W13W12VersionB.createPositionedRelation((TrackElement) CW1213.getBranchingPoint(),(TrackElement) W11W12.getTrailModel(),(TrackElement) W12W16.getTrailModel(), true, 60, ApplicationDirection.BOTH, new TrackElementStatus() );

        list = new ArrayList<PositionedRelation>();
        list.add(PositionLW12W13VersionA);
        list.add(PositionLW12W13VersionB);
        list.add(PositionW11W13W12VersionA);
        list.add(PositionW11W13W12VersionB);

        SlipCW1213.updatePositionedRelation(list, "From Left Astetten", "From W11");
        SlipCW1213.setOutputRelation(PositionLW12W13VersionA,PositionW11W13W12VersionA);


        //Weiche W16
        PositionedRelation PositionW12W16R = new PositionedRelation();
        PositionW12W16R.createPositionedRelation((TrackElement) CW16.getBranchingPoint(),(TrackElement) W12W16.getTrailModel(),(TrackElement) W16Right.getTrailModel(), true, 250, ApplicationDirection.BOTH, new TrackElementStatus() );
        PositionedRelation PositionW15W16R = new PositionedRelation();
        PositionW15W16R.createPositionedRelation((TrackElement) CW16.getBranchingPoint(),(TrackElement) W15W16.getTrailModel(),(TrackElement) W16Right.getTrailModel(), true, 60, ApplicationDirection.BOTH, new TrackElementStatus() );





        list = new ArrayList<PositionedRelation>();
        list.add(PositionW12W16R);
        list.add(PositionW15W16R);

        SlipCW16.updatePositionedRelation(list);
        SlipCW16.setOutputRelation(PositionW12W16R);

        // Weiche W11
        PositionedRelation PositionLW11R = new PositionedRelation();
        PositionLW11R.createPositionedRelation((TrackElement) CW11.getBranchingPoint(),(TrackElement) LeftW11.getTrackReference(),(TrackElement) W11Right.getTrackReference(), false, 0, ApplicationDirection.BOTH, new TrackElementStatus() );
        PositionedRelation PositionLW11W12 = new PositionedRelation();
        PositionLW11W12.createPositionedRelation((TrackElement) CW11.getBranchingPoint(),(TrackElement) LeftW11.getTrackReference(),(TrackElement) W11W12.getTrackReference(), true, 60, ApplicationDirection.BOTH, new TrackElementStatus() );





        list = new ArrayList<PositionedRelation>();
        list.add(PositionLW11W12);
        list.add(PositionLW11R);

        SlipCW11.updatePositionedRelation(list);
        SlipCW11.setOutputRelation(PositionLW11W12);








/*

        // Weichen auf der zweitenLinie
        // CW12
        generateCrossover(RW12W13, true, R10W12, false, RW11W12, false);
        //CW13
        generateCrossover(RW12W13, false, RW13W16, true, RW13W14, true);

        // CW 16

        // CW 11


       Rail RW14W15 = new Rail(50.0f, 50.0f, 52.0f, 50.0f, this.railList, null, null);
       Rail RW1507 = new Rail(52.1f, 50.0f, 164.0f, 50.0f, this.railList, null, null);



       //null

        // Cauton RW 14 W 15 connects tow crossofer no link to other rails
        //R00W14.ConB = RW14W15;
        //RW14W15.ConA = R00W14;

        //RW14W15.ConB = RW1507;
        //RW1507.ConA = RW14W15;
        //null

        Rail R10W12 = new Rail(10.0f, 100.0f, 30.0f, 100.0f, this.railList,null,null);
        Rail RW12W13 = new Rail(30.0f, 100.0f, 30.1f, 100.0f, this.railList,null,null);
        Rail RW13W16 = new Rail(30.1f, 100.0f, 57.0f, 100.0f, this.railList, null, null);
        Rail RW1617 = new Rail(57.0f, 100.0f, 164.0f, 100.0f, this.railList, null, null);



        Rail R20W11 = new Rail(10.0f, 150.0f, 20.0f, 150.0f, this.railList,null,null);
        Rail RW11G11 = new Rail(20.0f, 150.0f, 50.f, 150.0f, this.railList, null,null);


        // end left to right rails

        // down up line spanning rails

        Rail RW13W14 = new Rail(30.1f, 99.8f, 49.9f, 50.1f, this.railList, null,null);
        Rail RW15W16 = new Rail(52.1f, 50.1f, 56.9f, 99.8f, this.railList, null,null);
        //--

        Rail RW11W12 = new Rail(20.1f, 149.9f, 29.9f, 100.1f, this.railList, null,null);

        // end down up
        // Weichen auf der untersten Linie



        //ElementConnectionPoint MainCP = new ElementConnectionPoint()

       // Crossover.createCrossover()


*/






    }

    private BranchingSwitch generateCrossover(SingleSlip Point, double x, double y, String sName,
                                              BranchingSwitch.ViewType ViewType
                                              ) {


        // can have also equal x Position then isLeftOf returns null




        BranchingSwitch C = BranchingSwitch.createCrossover(null, Point, x,y, sName,
                ViewType);
        this.branchingSwitchList.add(C);
        PlanData.TrackElementPositionCalc.put(Point.getRemotePoint(), C);
        return C;
    }
    private BranchingSwitch generateCrossover(DoubleSlip Point, double x, double y, String sName

                                              ) {


        // can have also equal x Position then isLeftOf returns null




        BranchingSwitch C = BranchingSwitch.createCrossover(null, Point, x,y, sName );
        this.branchingSwitchList.add(C);
        PlanData.TrackElementPositionCalc.put(Point.getFirstSlipA().getRemotePoint(), C);
        PlanData.TrackElementPositionCalc.put(Point.getSecondSlipB().getRemotePoint(), C);
        return C;
    }

    public void refreshData() {
        boolean bInitialized = true;
        if (!bInitialized) {
            return;
        }





    }


    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.GradientSubscription = subscription;
        this.GradientSubscription.request(1);
    }

    @Override
    public void onNext(GradientProfile item) {
        this.GP = item;
        this.GradientSubscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {

    }

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
}
