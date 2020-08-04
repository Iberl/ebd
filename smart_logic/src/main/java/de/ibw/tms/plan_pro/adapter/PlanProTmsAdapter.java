package de.ibw.tms.plan_pro.adapter;

import de.ibw.feed.Balise;
import de.ibw.feed.BaliseExtractor;
import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.speed.profile.PointComparator;
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.speed.profile.model.SspRepository;
import de.ibw.tms.trackplan.ui.MainGraphicPanel;
import de.ibw.tms.trackplan.ui.PlatformEdge;
import de.ibw.util.DefaultRepo;
import plan_pro.modell.bahnsteig._1_9_0.*;
import plan_pro.modell.bahnuebergang._1_9_0.CBUEAnlage;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CDatenpunkt;
import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.basisobjekte._1_9_0.CBereichObjektTeilbereich;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektStrecke;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektTOPKante;
import plan_pro.modell.block._1_9_0.CBlockElement;
import plan_pro.modell.block._1_9_0.CBlockStrecke;
import plan_pro.modell.geodaten._1_9_0.*;
import plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrAnlage;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspElement;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspKomponente;

import java.security.InvalidParameterException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class PlanProTmsAdapter {

    private static PlanProTmsAdapter instance;
    public static PlanProTmsAdapter getPlanAdapter() {
        return instance;
    }
    private static final boolean B_PRINT_BALISE_LIST = true;



    plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle PlanProDefinition = null;

    public void setPlanProDefinition(CPlanProSchnittstelle planProDefinition) {
        PlanProDefinition = planProDefinition;
    }

    public enum PlanProVersion {
        V1_9_0_PATCHED
    }

    private Class[] aPlattformKeys;
    private Class[] aCrossingKeys;
    private Class[] aSpeedKeys;
    public DefaultRepo<Class, DefaultRepo> platformBundle = new DefaultRepo<>();
    public DefaultRepo<Class, DefaultRepo> geoBundle = new DefaultRepo<>();
    public DefaultRepo<Class, DefaultRepo> crossingBundle = new DefaultRepo<>();
    public DefaultRepo<Class, DefaultRepo> speedBundle = new DefaultRepo<>();


    public DefaultRepo<String, CStrecke> trackRepo = new DefaultRepo<>();
    public DefaultRepo<String, CTOPKnoten> geoNodeToTopNodeRepo = new DefaultRepo<>();
    public DefaultRepo<String, CGEOKnoten> topNodeToGeoNodeRepo = new DefaultRepo<>();
    public DefaultRepo<String, List<CGEOKante>> geoNodeToGeoEdgesRepo = new DefaultRepo<>();
    public DefaultRepo<String, List<CGEOKante>> geoEdgesToTopNodeRepo = new DefaultRepo<>();
    public DefaultRepo<String, List<CGEOKante>> geoEdgesToTopEdgesRepo = new DefaultRepo<>();


    public boolean bCheckAllNodesBeeingLeftmost = true;



    // An Crossing can have more components
    // W_Kr_Anlage with Crossing components
    public DefaultRepo<String, ArrayList<String>> crossingPartRelation = new DefaultRepo<>();
    // Relation between Crossing elements to crossing component
    // On crossing element can have many components
    public DefaultRepo<String, ArrayList<String>> crossingComponentRelation = new DefaultRepo<>();

    public DefaultRepo<String, ArrayList<CStreckePunkt>> pointsByTrackId = new DefaultRepo<>();



    public PlanProTmsAdapter(PlanProVersion Version, CPlanProSchnittstelle planProDefinition) throws ParseException {
        instance = this;
        if(Version == PlanProVersion.V1_9_0_PATCHED) {
            createTopology(planProDefinition);
            //handleSpeedProfile();

            //handlePlatformData();

            initBranchingPoints();
            handleBranchingPoints();
            initLevelCrossings();
            //TODO:
          //  handleLevelCrossings();


        }
    }

    public void createTopology(CPlanProSchnittstelle planProDefinition) {
        this.setPlanProDefinition(planProDefinition);
        aPlattformKeys = new Class[] {
                CBahnsteigAnlage.class, CBahnsteigKante.class, CBahnsteigZugang.class,

        };
        aCrossingKeys = new Class[]  {
                CWKrAnlage.class, CWKrGspElement.class, CWKrGspKomponente.class
        };
        aSpeedKeys = new Class[] {
                CBlockStrecke.class, CStrecke.class, CBlockElement.class, CStreckePunkt.class
        };

        handleGeoData();

        handleRailTopology();
    }

    private void handleSpeedProfile() {
        List<CBlockStrecke> listBlockStrecke = PlanProDefinition.getLSTZustand().getContainer().getBlockStrecke();
        List<CStrecke> listStrecke = PlanProDefinition.getLSTZustand().getContainer().getStrecke();
        List<CBlockElement> listBlockElement = PlanProDefinition.getLSTZustand().getContainer().getBlockElement();
        List<CStreckePunkt> listStreckePunkt = PlanProDefinition.getLSTZustand().getContainer().getStreckePunkt();
        List[] crossingContents = new List[] { listBlockStrecke, listStrecke, listBlockElement, listStreckePunkt};

        handlePlanProIndexing(aSpeedKeys, crossingContents, speedBundle);

        DefaultRepo<String, CStrecke> trackRepo = speedBundle.getModel(CStrecke.class);
        DefaultRepo<String, CStreckePunkt> trackPointRepo = speedBundle.getModel(CStreckePunkt.class);

        Collection<CStreckePunkt> allPoints = trackPointRepo.getAll();
        for(CStreckePunkt TrackPoint : allPoints) {
            String sTrackId = TrackPoint.getIDStrecke().getWert();
            ArrayList<CStreckePunkt> pointsOfTrack = pointsByTrackId.getModel(sTrackId);
            if(pointsOfTrack == null) {
                pointsOfTrack = new ArrayList<>();

            }
            pointsOfTrack.add(TrackPoint);
            pointsByTrackId.update(sTrackId, pointsOfTrack);
        }


        for(CBlockStrecke BlockStrecke : listBlockStrecke) {
            int iSpeed = BlockStrecke.getBlockStreckeAllg().getEntwurfsgeschwindigkeit().
                    getWert().intValue();
            ETCS_SPEED EtcsSpeed = new ETCS_SPEED();
            float fSpeedResolution = 3.6f / 5.0f;
            EtcsSpeed.bSpeed = (byte) (iSpeed * fSpeedResolution);

            CStrecke Track = trackRepo.getModel(BlockStrecke.getIDStrecke().getWert());
            ArrayList<CStreckePunkt> currentPoints = pointsByTrackId.getModel(Track.getIdentitaet().getWert());

            int iSize = currentPoints.size();
            if(iSize == 0) continue;

            currentPoints.sort(new PointComparator());
            //TODO: using Track for information
            CStreckePunkt BeginPoint = currentPoints.get(0);
            CStreckePunkt EndPoint = currentPoints.get(iSize - 1);
            Chainage BeginChainage = new Chainage(BeginPoint.getStreckeMeter().getWert().intValue());
            Chainage EndChainage = new Chainage(EndPoint.getStreckeMeter().getWert().intValue());

            // Rückwärtssuche von Strecke auf Objekt und Klasse
            // über Topology Graph rückwärtssuchen.

            TopologyGraph.Node NodeBeginn = TopologyGraph.NodeMap.get(BeginPoint);
            TopologyGraph.Node NodeEnd = TopologyGraph.NodeMap.get(EndPoint);



            List<CBereichObjektTeilbereich> trackPartList = Track.getBereichObjektTeilbereich();
            for(CBereichObjektTeilbereich TrackPart : trackPartList) {

            }


            SpotLocation BeginSpot = new SpeedChange(BeginChainage, NodeBeginn, null);
            SpotLocation EndSpot = new SpeedChange(EndChainage, NodeEnd, null );
            SpeedSegment Segment = new SpeedSegment(BeginSpot, EndSpot, ApplicationDirection.NOMINAL);
            Segment.setV_STATIC(EtcsSpeed);
            SspRepository.addSpeedSegment(Track.getIdentitaet().getWert(), BeginChainage.getiMeters(), Segment);


            //Segment.setSpeedChangeEnd(new SpeedChange());
        }

    }

    public void mapBalisesToCoordinate() {
        DefaultRepo<Integer, Balise> baliseByBg = Balise.baliseByNid_bg;
        DefaultRepo<Integer, Balise> tempBalises = new DefaultRepo();
        Collection<Balise> balisesList = baliseByBg.getAll();
        DefaultRepo<String, CTOPKnoten> topNodeRepo = geoBundle.getModel(CTOPKnoten.class);
        DefaultRepo<String, CGEOKnoten> geoPointRepo = geoBundle.getModel(CGEOKnoten.class);

        if(B_PRINT_BALISE_LIST) System.out.println("----Balise-List---");
        for(Balise B : balisesList) {
            CDatenpunkt DP = B.getPlanProDataPoint();
            double dA = DP.getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue();
           CTOPKante TopKante =  B.getTopPositionOfDataPoint();
           String sKnotenAid = TopKante.getIDTOPKnotenA().getWert();
           String sKnotenBid = TopKante.getIDTOPKnotenB().getWert();
           CTOPKnoten N_A = (CTOPKnoten) topNodeRepo.getModel(sKnotenAid);
           CTOPKnoten N_B = (CTOPKnoten) topNodeRepo.getModel(sKnotenBid);
           CGEOKnoten GeoNodeA = geoPointRepo.getModel(N_A.getIDGEOKnoten().getWert());
           CGEOKnoten GeoNodeB = geoPointRepo.getModel(N_B.getIDGEOKnoten().getWert());
           GeoCoordinates Geo_A = PlanData.GeoNodeRepo.getModel(GeoNodeA.getIdentitaet().getWert());
           GeoCoordinates Geo_B = PlanData.GeoNodeRepo.getModel(GeoNodeB.getIdentitaet().getWert());

           // getGeoCoordinate()
            GeoCoordinates geoCoordinate = MainGraphicPanel.getGeoCoordinate(TopKante.getIdentitaet().getWert(), true, dA);

            B.setX(geoCoordinate.getX());
            B.setY(geoCoordinate.getY());

            //UtilFunction.calcTargetGeoByStartPoint(B, dA, Geo_A, Geo_B);

            tempBalises.update(B.getHashcodeOfBaliseDp(), B);

            if(B_PRINT_BALISE_LIST)printBaliseInfo(B, DP, TopKante, Geo_A, Geo_B);


            BaliseExtractor.mapBaliseToDataPoint(DP, B);

        }
        if(B_PRINT_BALISE_LIST) System.out.println("----List-End---");
        Balise.baliseByNid_bg = tempBalises;


    }

    public void printBaliseInfo(Balise B, CDatenpunkt DP, CTOPKante topKante, GeoCoordinates geo_A, GeoCoordinates geo_B) {
        System.out.println("Nid-Bg: " + B.getHashcodeOfBaliseDp());
        System.out.println("TopKante-ID: " + topKante.getIdentitaet().getWert());
        System.out.println("DP Abstand: " + DP.getPunktObjektTOPKante().get(0).getAbstand().getWert());
        System.out.println("Geo_A_x: " + geo_A.getX() + " Geo_A_y: " + geo_A.getY());
        System.out.println("Geo_B_x: " + geo_B.getX() + " Geo_B_y: " + geo_B.getY());
    }


    private void initLevelCrossings() {
        List<CBUEAnlage> listBueAnlage = PlanProDefinition.getLSTZustand().getContainer().getBUEAnlage();

    }

    private void initBranchingPoints() {
        //List<CGleisAbschnitt> listCtrails =  PlanProDefinition.getLSTZustand().getContainer().getGleisAbschnitt();
        List<CWKrAnlage> listCrossings = PlanProDefinition.getLSTZustand().getContainer().getWKrAnlage();
        List<CWKrGspElement> listCrossingMovement = PlanProDefinition.getLSTZustand().getContainer().
                getWKrGspElement();
        List<CWKrGspKomponente> listCrossingComponents = PlanProDefinition.getLSTZustand().getContainer()
                .getWKrGspKomponente();


        List[] crossingContents = new List[] { listCrossings, listCrossingMovement, listCrossingComponents};

        handlePlanProIndexing(aCrossingKeys, crossingContents, crossingBundle);
    }



    private void handleBranchingPoints() throws ParseException {

        DefaultRepo<String, CWKrAnlage> crossingRepo = crossingBundle.getModel(CWKrAnlage.class);
        DefaultRepo<String, CWKrGspElement> crossingPartsRepo = crossingBundle.getModel(CWKrGspElement.class);
        DefaultRepo<String, CWKrGspKomponente> crossingKonponentsRepo = crossingBundle.getModel(CWKrGspKomponente.class);
        Collection<CWKrGspElement> listCrossingMovement = crossingPartsRepo.getAll();
        Collection<CWKrGspKomponente> listCrossingComponents = crossingKonponentsRepo.getAll();

        //coordinatePartsToCrossing(listCrossingMovement);
        //coordinateComponentsToPart(listCrossingComponents);


        Collection<CWKrAnlage> listCweiche = crossingRepo.getAll();

        for(CWKrGspKomponente Comp: listCrossingComponents) {
            String sElementId = null;
            String sAnlageId = null;
            CWKrGspElement Element = null;
            CWKrAnlage A = null;
            try {
                sElementId = Comp.getIDWKrGspElement().getWert();
            } catch(Exception E) {

            }
            if(sElementId != null) {
                Element = crossingPartsRepo.getModel(sElementId);
            }
            try {
                if(Element != null) sAnlageId = Element.getIDWKrAnlage().getWert();

            } catch(Exception E) {

            }
            if(sAnlageId != null) {
                A = crossingRepo.getModel(sAnlageId);
            }
            CrossingSwitch CS = new CrossingSwitch(A,Element,Comp);
            PlanData.RailSwitchList.add(CS);
        }

        // unused code //necessary????
        /*for(CWKrAnlage Branching : listCweiche ) {
            ENUMWKrArt kind = Branching.getWKrAnlageAllg().getWKrArt().getWert();
            String sMainBranch = Branching.getIdentitaet().getWert();
            CPunktObjektStrecke  ObjectTrack = null;


            switch (kind.value()) {
                case "EW": {
                    String sFirstPart = this.crossingPartRelation.getModel(sMainBranch).get(0);
                    CWKrGspElement FirstElement = crossingPartsRepo.getModel(sFirstPart);
                    CWKrGspKomponente FirstComponent = crossingKonponentsRepo.getModel(FirstElement.getIdentitaet()
                            .getWert());

                    ObjectTrack = FirstComponent.getPunktObjektStrecke().get(0);
                    Chainage C = parseTrackKilometersToChainage(ObjectTrack);
                    SingleSlip SL = new SingleSlip(C);
                    //TODO Topological
                    //BranchingSwitch BS = new BranchingSwitch(1000.0f,SL, );
                    break;
                }
                case "ABW": {
                    String sFirstPart = this.crossingPartRelation.getModel(sMainBranch).get(0);
                    CWKrGspElement FirstElement = crossingPartsRepo.getModel(sFirstPart);
                    CWKrGspKomponente FirstComponent = crossingKonponentsRepo.getModel(FirstElement.getIdentitaet()
                            .getWert());
                    ObjectTrack = FirstComponent.getPunktObjektStrecke().get(0);
                    Chainage C = parseTrackKilometersToChainage(ObjectTrack);
                    //FirstComponent.getZungenpaar().
                    DoubleSlip DL = new DoubleSlip(C);
                    //TODO: Schaltzeit fest vorgegeben und Topologie
                    //BranchingSwitch BS = new BranchingSwitch(1000.0f, DL,)

                }
                case "IBW": {
                    String sFirstPart = this.crossingPartRelation.getModel(sMainBranch).get(0);
                    CWKrGspElement FirstElement = crossingPartsRepo.getModel(sFirstPart);
                    CWKrGspKomponente FirstComponent = crossingKonponentsRepo.getModel(FirstElement.getIdentitaet()
                            .getWert());
                    ObjectTrack = FirstComponent.getPunktObjektStrecke().get(0);
                    Chainage C = parseTrackKilometersToChainage(ObjectTrack);
                    //FirstComponent.getZungenpaar().
                    DoubleSlip DL = new DoubleSlip(C);
                    //TODO: Schaltzeit fest vorgegeben und Topologie
                    //BranchingSwitch BS = new BranchingSwitch(1000.0f, DL,)
                } case "DKW": {
                    String sFirstPart = this.crossingPartRelation.getModel(sMainBranch).get(0);
                    CWKrGspElement FirstElement = crossingPartsRepo.getModel(sFirstPart);
                    CWKrGspKomponente FirstComponent = crossingKonponentsRepo.getModel(FirstElement.getIdentitaet()
                            .getWert());
                    ObjectTrack = FirstComponent.getPunktObjektStrecke().get(0);

                    Chainage C = parseTrackKilometersToChainage(ObjectTrack);
                    //FirstComponent.getZungenpaar().
                    DoubleSlip DL = new DoubleSlip(C);
                    //TODO: Schaltzeit fest vorgegeben und Topologie
                    //BranchingSwitch BS = new BranchingSwitch(1000.0f, DL,)
                } default: {

                }

            }
        }*/
    }

    private Chainage parseTrackKilometersToChainage(CPunktObjektStrecke objectTrack) throws ParseException {
        String sKilometers = objectTrack.getStreckeKm().getWert();
        Number numKilometers = NumberFormat.getInstance(Locale.GERMAN).parse(sKilometers);
        double dMeters = numKilometers.doubleValue() * 1000.0d;
        int iMeters = (int)dMeters;
        return new Chainage(iMeters);
    }

    private void coordinateComponentsToPart(Collection<CWKrGspKomponente> listCrossingComponents) {
        for(CWKrGspKomponente CrossingComponent : listCrossingComponents) {
            String sPartId = CrossingComponent.getIDWKrGspElement().getWert();
            String sComponentId = CrossingComponent.getIdentitaet().getWert();
            ArrayList<String> components = this.crossingComponentRelation.getModel(sComponentId);
            if(components == null) {
                components = new ArrayList<>();
            }
            components.add(sComponentId);
            this.crossingComponentRelation.update(sPartId, components);
        }


    }

    private void coordinatePartsToCrossing(Collection<CWKrGspElement> listCrossingMovement) {
        for(CWKrGspElement CrossingPart: listCrossingMovement) {
            String sBaseCrossingId = CrossingPart.getIDWKrAnlage().getWert();
            String sPartId = CrossingPart.getIdentitaet().getWert();
            ArrayList<String> parts = this.crossingPartRelation.getModel(sBaseCrossingId);
            if(parts == null) {
                parts = new ArrayList<>();
            }
            parts.add(sPartId);
            this.crossingPartRelation.update(sBaseCrossingId, parts);
        }
    }

    private void handleRailTopology() {

    }

    private void handlePlatformData() {
        List<CBahnsteigAnlage> platforms =  PlanProDefinition.getLSTZustand().getContainer().getBahnsteigAnlage();
        List<CBahnsteigKante> platformLines = PlanProDefinition.getLSTZustand().getContainer().getBahnsteigKante();
        List<CBahnsteigZugang> platformEntrance = PlanProDefinition.getLSTZustand().getContainer().getBahnsteigZugang();
        List[] plattformContents = new List[] { platforms, platformLines, platformEntrance};
        handlePlanProIndexing(aPlattformKeys, plattformContents, platformBundle);
        buildTmsPlatformModel(platformBundle);
    }

    private void handleGeoData() {
        List<CGEOPunkt> geoPoints = PlanProDefinition.getLSTZustand().getContainer().getGEOPunkt();
        geoBundle = new DefaultRepo<>();

        // Punkte enthalten dem payload der Coordinaten,
        // Aber Knoten werden als String-ID benutzt

        for(CGEOPunkt GeoPunkt: geoPoints) {
            if(GeoPunkt.getIDGEOKnoten() == null) continue;
            String sGeoKnotenId = GeoPunkt.getIDGEOKnoten().getWert();

            GeoCoordinates GeoCoordTms = new GeoCoordinates();
            CGEOPunktAllg GeoPointData =  GeoPunkt.getGEOPunktAllg();
            double x = GeoPointData.getGKX().getWert().doubleValue();
            double y = GeoPointData.getGKY().getWert().doubleValue();
            //double z = GeoPointData.getGKZ().getWert().doubleValue();
            GeoCoordTms.setX(x);
            GeoCoordTms.setY(y);

            //GeoCoordTms.setHeight(z);
            PlanData.GeoNodeRepo.update(sGeoKnotenId, GeoCoordTms);
        }

        List<CStreckePunkt> trackingInfos = PlanProDefinition.getLSTZustand().getContainer().getStreckePunkt();
        List<CStrecke> trackList = PlanProDefinition.getLSTZustand().getContainer().getStrecke();
        for(CStrecke Track : trackList) {
            this.trackRepo.update(Track.getIdentitaet().getWert(), Track);
        }
        for(CStreckePunkt Info : trackingInfos) {
            String sIdGeoNode = Info.getIDGEOKnoten().getWert();
            if(sIdGeoNode == null) continue;
            GeoCoordinates GeoCoordTms = PlanData.GeoNodeRepo.getModel(sIdGeoNode);
            if(GeoCoordTms == null) continue;
            CStrecke Track = this.trackRepo.getModel(Info.getIDStrecke().getWert());
            GeoCoordTms.setTrack(Track);
            GeoCoordTms.setTrack_meter(Info.getStreckeMeter().getWert().doubleValue());
            PlanData.GeoNodeRepo.update(sIdGeoNode, GeoCoordTms);
        }

        List<CGEOKnoten> geoNodes = PlanProDefinition.getLSTZustand().getContainer().getGEOKnoten();


        List<CGEOKante> geoLines = PlanProDefinition.getLSTZustand().getContainer().getGEOKante();




        List<CTOPKante> topLines = PlanProDefinition.getLSTZustand().getContainer().getTOPKante();
        List<CTOPKnoten> topNodes = PlanProDefinition.getLSTZustand().getContainer().getTOPKnoten();


        Class[] aGeoKeys = new Class[]{CGEOPunkt.class, CGEOKnoten.class, CGEOKante.class,
                CTOPKante.class, CTOPKnoten.class};
        List[] geoContents = new List[] {geoPoints, geoNodes, geoLines, topLines, topNodes};
        handlePlanProIndexing(aGeoKeys, geoContents, geoBundle);
        connectTopology(topLines);
    }

    private void connectTopology(List<CTOPKante> topLines) {
        TopologyGraph TG = new TopologyGraph();
        DefaultRepo<String, CTOPKnoten> nodeRepo = geoBundle.getModel(CTOPKnoten.class);
        DefaultRepo<String, CGEOKnoten> geoPointRepo = geoBundle.getModel(CGEOKnoten.class);


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



            if(tcA.equals(TopologyConnect.ENDE_BESTDIG) || bCheckAllNodesBeeingLeftmost) {
                checkIfLeftmost(nodeRepo, geoPointRepo, sNodeA, A);
            }
            if(tcB.equals(TopologyConnect.ENDE_BESTDIG) || bCheckAllNodesBeeingLeftmost) {
                checkIfLeftmost(nodeRepo, geoPointRepo, sNodeB, B);
            }


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
                CGEOKnoten currentGeo = topNodeToGeoNodeRepo.getModel(sTopNodeA);
                TopologyGraph.Node A = TopologyGraph.NodeRepo.get(sTopNodeA);
                String sGeoNodeId = currentGeo.getIdentitaet().getWert();
                List<CGEOKante> geoEdges = geoNodeToGeoEdgesRepo.getModel(sGeoNodeId);
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
        List<CGEOKante> connectedEdges = geoNodeToGeoEdgesRepo.getModel(GeoPointer.getIdentitaet().getWert());

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

    private boolean checkIfEdgeIsSearchedOne(String sGeoA, String sGeoB, String sCheckA, String sCheckB) {
        return sCheckA.equals(sGeoA) && sCheckB.equals(sGeoB) ||
                sCheckA.equals(sGeoB) && sCheckB.equals(sGeoA);
    }

    private String followGeoEdgesAndRelateToTopEdge(List geoEdgesOnTopEdge, String currentGeoNode_ID) {
        while (!geoNodeIsTopNodeAlso(currentGeoNode_ID)) {
            if (geoEdgesOnTopEdge.contains(geoNodeToGeoEdgesRepo.getModel(currentGeoNode_ID).get(0))) {
                geoEdgesOnTopEdge.add(geoNodeToGeoEdgesRepo.getModel(currentGeoNode_ID).get(1));
                if (currentGeoNode_ID.equals(geoNodeToGeoEdgesRepo.getModel(currentGeoNode_ID).get(1).getIDGEOKnotenA().toString())) {
                    currentGeoNode_ID = geoNodeToGeoEdgesRepo.getModel(currentGeoNode_ID).get(1).getIDGEOKnotenB().toString();
                }
                else {
                    currentGeoNode_ID = geoNodeToGeoEdgesRepo.getModel(currentGeoNode_ID).get(1).getIDGEOKnotenA().toString();
                }
            }
            else {
                geoEdgesOnTopEdge.add(geoNodeToGeoEdgesRepo.getModel(currentGeoNode_ID).get(0));
                if (currentGeoNode_ID.equals(geoNodeToGeoEdgesRepo.getModel(currentGeoNode_ID).get(0).getIDGEOKnotenA().toString())) {
                    currentGeoNode_ID = geoNodeToGeoEdgesRepo.getModel(currentGeoNode_ID).get(0).getIDGEOKnotenB().toString();
                }
                else {
                    currentGeoNode_ID = geoNodeToGeoEdgesRepo.getModel(currentGeoNode_ID).get(0).getIDGEOKnotenA().toString();
                }
            }
        }
        return currentGeoNode_ID;
    }

    private boolean geoNodeIsTopNodeAlso(String currentGeoNode_ID) {
        return geoNodeToTopNodeRepo.containsKey(currentGeoNode_ID);
    }

    private void fillGeoEdgeRelateToGeoNodeRepo(DefaultRepo<String, CGEOKnoten> geoPointRepo) {
        for (Object geoObject : geoBundle.getModel(CGEOKante.class).getAll()) {
            CGEOKante geoEdge = (CGEOKante) geoObject;
            CGEOKnoten geoNodeA = geoPointRepo.getModel(geoEdge.getIDGEOKnotenA().getWert());
            CGEOKnoten geoNodeB = geoPointRepo.getModel(geoEdge.getIDGEOKnotenB().getWert());

            relateEdgeToNode(geoEdge, geoNodeA);
            relateEdgeToNode(geoEdge, geoNodeB);

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

    private void checkIfLeftmost(DefaultRepo nodeRepo, DefaultRepo<String, CGEOKnoten> geoPointRepo, String sNodeA, TopologyGraph.Node a) {
        getGeoCoordinate(nodeRepo, sNodeA);
        //a.x = geoPointOfNode.getGEOPunktAllg().getGKX().getWert();
        //a.y = geoPointOfNode.getGEOPunktAllg().getGKY().getWert();
        if(TopologyGraph.getXofCurrentLeftMostNode() == null) {
            TopologyGraph.setLeftmostNode(a);
        } else {
            Double da = a.getGeoCoordinates().getX();
            if(da.compareTo(TopologyGraph.getXofCurrentLeftMostNode()) < 0) {
                TopologyGraph.setLeftmostNode(a);
            }
        }
    }

    public static GeoCoordinates getGeoCoordinate(DefaultRepo nodeRepo, String sNodeA) {
        CTOPKnoten TopNode = (CTOPKnoten) nodeRepo.getModel(sNodeA);
        String sGeoNodeId = TopNode.getIDGEOKnoten().getWert();
        //CGEOKnoten geoPointOfNode = geoPointRepo.getModel(sGeoNodeId);
        GeoCoordinates CoordinateGeo = PlanData.GeoNodeRepo.getModel(sGeoNodeId);
        return CoordinateGeo;
    }

    private void buildTmsPlatformModel(DefaultRepo<Class, DefaultRepo> platformBundle) {


        DefaultRepo bahnhofAnlageRepo = platformBundle.getModel(CBahnsteigAnlage.class);
        DefaultRepo bahnhofZugangRepo = platformBundle.getModel(CBahnsteigZugang.class);
        DefaultRepo bahnhofUiEdgeRepo = platformBundle.getModel(CBahnsteigKante.class);

        Collection zugangList = bahnhofZugangRepo.getAll();
        //List uiEdgeList = bahnhofUiEdgeRepo.getAll();
        initPlatforms(bahnhofAnlageRepo);
        handlePlatformEntrances(zugangList);
        //setPlatformCoordination();


        /*for(Object ObjectPlatformEdge : uiEdgeList) {
            CBahnsteigKante PlatformKante = (CBahnsteigKante) ObjectPlatformEdge;
            String sPlatformId =  PlatformKante.getIDBahnsteigAnlage().getWert();
            PlatformEdge PE = PlanData.PlatformRepo.getModel(sPlatformId);
            if(PE == null) continue;

            
            //PlatformKante.
            //CBahnsteigKanteAllg EdgeData = PlatformKante.getBahnsteigKanteAllg();
            //EdgeData.

        }
        */
    }

    @Deprecated
    private void setPlatformCoordination() {
        DefaultRepo bahnhofZugangRepo = platformBundle.getModel(CBahnsteigZugang.class);
        DefaultRepo topEdgeRepo = platformBundle.getModel(CTOPKante.class);
        DefaultRepo topNodeRepo = platformBundle.getModel(CTOPKnoten.class);
        DefaultRepo geoNodeRepo = platformBundle.getModel(CGEOKnoten.class);
        Collection<PlatformEdge> listPlattform = PlanData.PlatformRepo.getAll();

        for(PlatformEdge PE: listPlattform) {
            PlatformEdge.Entrances GeoEntrance = null;
            ArrayList<PlatformEdge.Entrances> entrances = PE.getZugangsListe();
            if(entrances.isEmpty()) return;
            GeoEntrance = entrances.get(0);
            for(PlatformEdge.Entrances Entrance : entrances) {
                if(Entrance.isHauptzugang()) {
                    GeoEntrance = Entrance;
                    break;
                }
            }
            if(GeoEntrance != null) {
                String sEntranceId = GeoEntrance.getsId();
                CBahnsteigZugang Entrance = (CBahnsteigZugang) bahnhofZugangRepo.getModel(sEntranceId);
                List<CPunktObjektTOPKante> edgeList = Entrance.getPunktObjektTOPKante();
                if(edgeList.isEmpty()) continue;
                CPunktObjektTOPKante Edge = edgeList.get(0);
                String sIdTopKante = Edge.getIDTOPKante().getWert();
                CTOPKante TopEdge = (CTOPKante) topEdgeRepo.getModel(sIdTopKante);
                if(TopEdge != null) {
                    String sIdNodeA = TopEdge.getIDTOPKnotenA().getWert();
                    String sIdNodeB = TopEdge.getIDTOPKnotenB().getWert();
                    CTOPKnoten TopNodeA = (CTOPKnoten) topNodeRepo.getModel(sIdNodeA);
                    CTOPKnoten TopNodeB = (CTOPKnoten) topNodeRepo.getModel(sIdNodeB);
                    if(TopNodeA == null || TopNodeB == null) continue;
                    String sIdGeoNodeA = TopNodeA.getIDGEOKnoten().getWert();
                    String sIdGeoNodeB = TopNodeB.getIDGEOKnoten().getWert();
                    CGEOKnoten GeoNodeA = (CGEOKnoten) geoNodeRepo.getModel(sIdGeoNodeA);
                    CGEOKnoten GeoNodeB = (CGEOKnoten) geoNodeRepo.getModel(sIdGeoNodeB);
                    if(GeoNodeA == null || GeoNodeB == null) continue;
                    GeoCoordinates GCOOA = PlanData.GeoNodeRepo.getModel(GeoNodeA.getIdentitaet().getWert());
                    GeoCoordinates GCOOB = PlanData.GeoNodeRepo.getModel(GeoNodeB.getIdentitaet().getWert());
                    GeoCoordinates GeoVector = new GeoCoordinates();
                    GeoVector.setX(GCOOB.getX() - GCOOA.getX());
                    GeoVector.setY(GCOOB.getY() - GCOOA.getY());


                    double dVectorLength = Math.sqrt(Math.pow(GeoVector.getX(),2) + Math.pow(GeoVector.getY(), 2));

                    if(GCOOA.getX() == GCOOB.getX() && GCOOA.getY() == GCOOB.getY()) {
                        PE.setGeoCoordinates(GCOOA);
                        PlanData.PlatformRepo.update(PE.getsIdAnlage(), PE);
                        continue;
                    }

                    if(dVectorLength == 0) {
                        PE.setGeoCoordinates(GCOOA);
                        PlanData.PlatformRepo.update(PE.getsIdAnlage(), PE);
                        continue;
                    }

                    // unify GeoVector
                    double x = GeoVector.getX();
                    double y = GeoVector.getY();
                    GeoVector.setX(x / dVectorLength);
                    GeoVector.setY(y / dVectorLength);
                    GeoCoordinates PlatformCoordinates = new GeoCoordinates();
                    PlatformCoordinates.setX(GCOOA.getX());
                    PlatformCoordinates.setY(GCOOA.getY());
                    //PlatformCoordinates.addMeters(GeoVector.getX(), GeoVector.getY());
                    PE.setGeoCoordinates(PlatformCoordinates);
                    PlanData.PlatformRepo.update(PE.getsIdAnlage(), PE);

                }


            }


        }
    }

    private void handlePlatformEntrances(Collection zugangList) {
        for(Object ObjectPlatformEntrance : zugangList) {
            CBahnsteigZugang PlatformEntrance = (CBahnsteigZugang) ObjectPlatformEntrance;
            String sPlatformId = PlatformEntrance.getIDBahnsteigAnlage().getWert();
            PlatformEdge PE = PlanData.PlatformRepo.getModel(sPlatformId);
            if(PE == null) continue;
            CBahnsteigZugangAllg PlatformEntranceDetail =  PlatformEntrance.getBahnsteigZugangAllg();
            if(PlatformEntranceDetail != null) {
                PlatformEdge.Entrances Zugang = new PlatformEdge.Entrances();
                Zugang.setsId(PlatformEntrance.getIdentitaet().getWert());
                TCBahnsteigZugangArt EntranceKind = PlatformEntranceDetail.getBahnsteigZugangArt();
                if (EntranceKind != null) {
                    ENUMBahnsteigZugangArt EnumEntranceKind = EntranceKind.getWert();
                    if (EnumEntranceKind != null) {
                        Zugang.setsZugangsArt(EnumEntranceKind.value());
                    }
                    TCHauptzugang MainEntrance = PlatformEntranceDetail.getHauptzugang();
                    if (MainEntrance != null) {
                        Zugang.setHauptzugang(MainEntrance.isWert());
                    }

                }
                PE.addEntrance(Zugang);
                PlanData.PlatformRepo.update(sPlatformId, PE);
            }

        }
    }

    private void initPlatforms(DefaultRepo bahnhofAnlageRepo) {
        for(Object ObjectPlatform : bahnhofAnlageRepo.getAll()) {
            // TMS MODEL
            PlatformEdge PE = new PlatformEdge();
            // PLAN PRO MODEL
            CBahnsteigAnlage CPlatform = (CBahnsteigAnlage) ObjectPlatform;
            String sPlatformId = CPlatform.getIdentitaet().getWert();
            PE.setsAnlagenBezeichnung(CPlatform.getBezeichnung().getBezeichnungBahnsteigAnlage().getWert());
            PlanData.PlatformRepo.update(sPlatformId, PE);
        }
    }

    private void handlePlanProIndexing(Object[] aKeys, List[] aContents, DefaultRepo targetBundle) {
        if(aKeys.length != aContents.length) throw new InvalidParameterException("Given arrays shall have same length");

        else {
            int iSize = aKeys.length;
            for(int i = 0; i < iSize; i++) {
                DefaultRepo<String, CBasisObjekt> defaultRepo = new DefaultRepo<>();
                Object Bundlekey = aKeys[i];
                List basicObjectList = aContents[i];
                for(Object BasicObject : basicObjectList) {
                    String key = null;
                    CBasisObjekt CBO = (CBasisObjekt) BasicObject;
                    key = CBO.getIdentitaet().getWert();
                    defaultRepo.update(key, CBO);
                }
                targetBundle.update(Bundlekey, defaultRepo);
            }
        }
    }


}
