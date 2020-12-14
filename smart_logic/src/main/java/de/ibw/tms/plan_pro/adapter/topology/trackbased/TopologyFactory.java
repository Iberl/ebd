package de.ibw.tms.plan_pro.adapter.topology.trackbased;

import de.ibw.feed.Balise;
import de.ibw.feed.BaliseExtractor;
import de.ibw.tms.ma.positioning.GeometricCoordinate;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.ui.MainGraphicPanel;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import de.ibw.util.DefaultRepo;
import ebd.SlConfigHandler;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CDatenpunkt;
import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.geodaten._1_9_0.*;
import plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle;
import plan_pro.modell.signale._1_9_0.CSignal;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrAnlage;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspElement;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspKomponente;
import jakarta.xml.bind.*;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Diese Klasse dient zur Erzeugung eines Topologieschen Graphen
 */
public class TopologyFactory implements ITopologyFactory {


    private static final boolean B_PRINT_BALISE_LIST = true;
    /**
     * Dieses Feld gibt an, ob der erzeugte Graph in PlanData gespeichert werden soll
     */
    public static boolean shallAssignToActivePlanData = true;


    private List<CTOPKante> topLines; // input
    private DefaultRepo<Class<?>,DefaultRepo<String, CBasisObjekt>> geoBundle; // input

    public DefaultRepo<Class<?>, DefaultRepo<String, CBasisObjekt>> getGeoBundle() {
        return geoBundle;
    }

    private DefaultRepo<String, List<CGEOKante>> geoNodeToGeoEdgesRepo = new DefaultRepo<>(); // output
    private DefaultRepo<String, CTOPKnoten> geoNodeToTopNodeRepo = new DefaultRepo<>(); // output
    private DefaultRepo<String, CGEOKnoten> topNodeToGeoNodeRepo = new DefaultRepo<>(); // output

    private Class[] aPlattformKeys;
    private Class[] aCrossingKeys;
    private Class[] aSpeedKeys;


    private DefaultRepo<Class<?>, DefaultRepo<String, CBasisObjekt>> crossingBundle = new DefaultRepo<>();

    public static DefaultRepo<TopologyGraph.Node,DefaultRepo<TopologyGraph.Node,TopologyGraph.Edge>> connections = new DefaultRepo<>();


    private DefaultRepo<String, CStrecke> trackRepo = new DefaultRepo<>(); // output

    private DefaultRepo<String, CSignal> signalRepo = new DefaultRepo<>();

    private CPlanProSchnittstelle PlanProDefinition;

    /**
     * Diese Getter Methode gibt ein Repository zur&uuml;ck, das die String-Id eine Geo-Knoten als key besitzt.
     * Als Wertebreich werden Topologische Knoten zur&uuml;ckgegeben
     * @return Ein Repository mit Geo-Key und Value eine {@link CTOPKnoten}
     */
    public DefaultRepo<String, CTOPKnoten> getGeoNodeToTopNodeRepo() {
        return geoNodeToTopNodeRepo;
    }
    /**
     * Diese Getter Methode gibt ein Repository zurück, das die String-Id eine Top-Knoten als key besitzt.
     * Als Wertebreich werden Geographisch Knoten zurückgegeben
     * @return Ein Repository mit top-Key und Value eine {@link CGEOKnoten}
     */
    public DefaultRepo<String, CGEOKnoten> getTopNodeToGeoNodeRepo() {
        return topNodeToGeoNodeRepo;
    }

    /**
     *
     * @return Ein Repository, das die CStrecken key-StringIds zur {@link CStrecke} zuordnet
     */
    public DefaultRepo<String, CStrecke> getTrackRepo() {
        return trackRepo;
    }

    public void setTopLines(List<CTOPKante> topLines) {
        this.topLines = topLines;
    }

    public void setGeoBundle(DefaultRepo<Class<?>, DefaultRepo<String, CBasisObjekt>> geoBundle) {
        this.geoBundle = geoBundle;
    }

    public void setGeoNodeToGeoEdgesRepo(DefaultRepo<String, List<CGEOKante>> geoNodeToGeoEdgesRepo) {
        this.geoNodeToGeoEdgesRepo = geoNodeToGeoEdgesRepo;
    }

    /**
     * Construktor das die Factory intialisiert
     * @throws JAXBException - wenn die PlanPro Datei nicht verarbeitet werde konnte
     */
    public TopologyFactory() throws JAXBException {
        aCrossingKeys = new Class[]  {
                CWKrAnlage.class, CWKrGspElement.class, CWKrGspKomponente.class
        };
        initFromFile();
    }


    /**
     * Diese Methode generiert den {@link TopologyGraph}
     * @return TopologyGraph
     */
    public TopologyGraph connectTopology() {
        if(this.topLines == null || this.geoBundle == null || this.geoNodeToGeoEdgesRepo == null) {
            throw new NullPointerException("Topology Factory Parameters must not be null");
        }
        TopologyGraph TG = new TopologyGraph();
        DefaultRepo<String, CBasisObjekt> nodeRepo = geoBundle.getModel(CTOPKnoten.class);
        DefaultRepo<String, CBasisObjekt> geoPointRepo = geoBundle.getModel(CGEOKnoten.class);


        for(CTOPKante Edge : topLines) {

            String sNodeA = Edge.getIDTOPKnotenA().getWert();
            String sNodeB = Edge.getIDTOPKnotenB().getWert();

            TopologyGraph.Node A = TopologyGraph.NodeRepo.get(sNodeA);
            if(A == null) {
                GeometricCoordinate GeoA = getGeoCoordinate(nodeRepo,sNodeA);
                A = new TopologyGraph.Node("", sNodeA, GeoA);
            }
            TopologyGraph.Node B = TopologyGraph.NodeRepo.get(sNodeB);
            if(B == null) {
                GeometricCoordinate GeoB = getGeoCoordinate(nodeRepo,sNodeB);
                B = new TopologyGraph.Node("", sNodeB , GeoB);
            }



            TopologyConnect tcA = TopologyConnect.fromValue(Edge.getTOPKanteAllg().getTOPAnschlussA().getWert().value());
            TopologyConnect tcB = TopologyConnect.fromValue(Edge.getTOPKanteAllg().getTOPAnschlussB().getWert().value());
            if(TopologyGraph.getLeftmostNode() == null) {
                TopologyGraph.setLeftmostNode(A);
            }





            TopologyGraph.Edge tgEdge = new TopologyGraph.Edge(A,tcA,B,tcB, Edge);
            TG.edgeRepo.put(Edge.getIdentitaet().getWert(),tgEdge);




        }
        connectDigitalEndNodes(TG);

        if(TopologyGraph.getLeftmostNode() == null) throw new NullPointerException("Not Edge with End in A defined");

        // filling topNodetoGeoNodeRepo with key:ID of geoNodes, value:topNodes
        for (Object topNodeObj : nodeRepo.getAll()) {
            CTOPKnoten topNode = (CTOPKnoten) topNodeObj;
            CGEOKnoten geoNode = (CGEOKnoten) geoPointRepo.getModel(topNode.getIDGEOKnoten().getWert());
            geoNodeToTopNodeRepo.update(geoNode.getIdentitaet().getWert(),topNode);
            topNodeToGeoNodeRepo.update(topNode.getIdentitaet().getWert(), geoNode);
        }




        // filling geoEdgeToGeoNodeRepo with key:ID of geoNodes, value: geoEdge
        fillGeoEdgeRelateToGeoNodeRepo(geoPointRepo);




        // iterate over edges
        ArrayList<TopologyGraph.Edge> edgeList = new ArrayList<>(TG.edgeRepo.values());




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
                    String sNextGeo;
                    CGEOKnoten NextGeoNode;
                    if(sGeoA.equals(sGeoNodeId)) {
                        sNextGeo = sGeoB;
                    } else if(sGeoB.equals(sGeoNodeId)) {
                        sNextGeo = sGeoA;
                    } else {
                        continue;
                    }
                    NextGeoNode = (CGEOKnoten) geoPointRepo.getModel(sNextGeo);
                    //handleGeoEdges(A, currentGeo, NextGeoNode);


                }

            }
        }






        if(shallAssignToActivePlanData) PlanData.topGraph = TG;
        return TG;


    }

    private void connectDigitalEndNodes(TopologyGraph TG) {

        boolean bMergedSomething = true;

        ArrayList<TopologyGraph.Node> connectedNodes = new ArrayList<>();
        ArrayList<TopologyGraph.Node> unConnectedNodes = new ArrayList<>(TopologyGraph.Node.nodesWithDigitalisedEnds);
        initconnections(connections, unConnectedNodes);
        while(bMergedSomething) {
                bMergedSomething = false;
                for(int i = 0; i < unConnectedNodes.size(); i++) {
                    for(int j = 0; j < unConnectedNodes.size(); j++) {
                        TopologyGraph.Node N1 = unConnectedNodes.get(i);
                        TopologyGraph.Node N2 = unConnectedNodes.get(j);
                        if(connections.getModel(N1).getModel(N2) != null) continue;
                            if(N1.equals(N2)) continue;
                            if(isSamePosition(N1,N2)) {
                                bMergedSomething = true;
                                TopologyGraph.Edge E1 = getGivenEdge(N1,connections);
                                TopologyGraph.Edge E2 = getGivenEdge(N2,connections);
                                TopologyGraph.Node NewN1 = null;
                                TopologyGraph.Node NewN2 = null;

                                if (E1.A.equals(N1)) {
                                    NewN1 = E1.B;
                                } else {
                                    NewN1 = E1.A;
                                }
                                if (E2.A.equals(N2)) {
                                    NewN2 = E2.B;
                                } else {
                                    NewN2 = E2.A;
                                }


                                TopologyConnect TC1 = retrieveTopologyConnectNotBeeingEnd(E1);
                                TopologyConnect TC2 = retrieveTopologyConnectNotBeeingEnd(E2);
                                if (TC1 == null && TC2 == null) {
                                    throw new InvalidParameterException("TC1 and TC2 not connected directly");
                                }
                                if (TC1 == null) {
                                    TC1 = TopologyConnect.ENDE_BESTDIG;

                                }
                                if (TC2 == null) {
                                    TC2 = TopologyConnect.ENDE_BESTDIG;

                                }
                                TopologyGraph.Edge MergedEdge = new TopologyGraph.Edge(NewN1, TC1, NewN2, TC2, E1.getPlanProEdge(), E2.getPlanProEdge());
                                handleMergedNodes(MergedEdge, E1, E2);


                                for (String sPlanProEdgeId : MergedEdge.getPlanProIds()) {
                                    TG.edgeRepo.put(sPlanProEdgeId, MergedEdge);

                                }
                                updateConnections(connections, N1,N2, MergedEdge);



                            }
                    }
                }

        }

        System.out.println("TestEnd");
    }

    private void updateConnections(DefaultRepo<TopologyGraph.Node, DefaultRepo<TopologyGraph.Node, TopologyGraph.Edge>> connections, TopologyGraph.Node n1, TopologyGraph.Node n2, TopologyGraph.Edge mergedEdge) {
        DefaultRepo<TopologyGraph.Node, TopologyGraph.Edge> nA = connections.getModel(n1);
        DefaultRepo<TopologyGraph.Node, TopologyGraph.Edge> nB = connections.getModel(n2);
        nA.update(n2, mergedEdge );
        nB.update(n1,mergedEdge);
        connections.update(n1,nA);
        connections.update(n2,nB);
    }

    private TopologyGraph.Edge getGivenEdge(TopologyGraph.Node n1, DefaultRepo<TopologyGraph.Node, DefaultRepo<TopologyGraph.Node, TopologyGraph.Edge>> connections) {

        DefaultRepo<TopologyGraph.Node, TopologyGraph.Edge> currentResult = connections.getModel(n1);
        if(currentResult.getAll().isEmpty()) return retrieveFirstEdge(n1);
        else {
            return new ArrayList<>(currentResult.getAll()).get(0);
        }
    }

    private void initconnections(DefaultRepo<TopologyGraph.Node, DefaultRepo<TopologyGraph.Node, TopologyGraph.Edge>> connections, ArrayList<TopologyGraph.Node> unConnectedNodes) {
        for(TopologyGraph.Node N : unConnectedNodes) {
            connections.update(N, new DefaultRepo<>());
        }
    }

    /*private void connectEdgesAndRemoveOldEdges(TopologyGraph.Node n1, TopologyGraph.Node n2, TopologyGraph TG,
                                              ArrayList<TopologyGraph.Node> notConnectedNodes) {
 TopologyGraph.Edge E1 = retrieveFirstEdge(n1);
        TopologyGraph.Edge E2 = retrieveFirstEdge(n2);
        TopologyGraph.Node NewN1 = null;
        TopologyGraph.Node NewN2 = null;

        if (E1.A.equals(n1)) {
            NewN1 = E1.B;
        } else {
            NewN1 = E1.A;
        }
        if (E2.A.equals(n2)) {
            NewN2 = E2.B;
        } else {
            NewN2 = E2.A;
        }


        TopologyConnect TC1 = retrieveTopologyConnectNotBeeingEnd(E1);
        TopologyConnect TC2 = retrieveTopologyConnectNotBeeingEnd(E2);
        if (TC1 == null && TC2 == null) {
            throw new InvalidParameterException("TC1 and TC2 not connected directly");
        }
        if (TC1 == null) {
            TC1 = TopologyConnect.ENDE_BESTDIG;

        }
        if (TC2 == null) {
            TC2 = TopologyConnect.ENDE_BESTDIG;

        }


        TopologyGraph.Edge MergeEdge = merge(n1, n2, TG, notConnectedNodes, E1, E2, NewN1, NewN2, TC1, TC2);

        if (TC1.equals(TopologyConnect.ENDE_BESTDIG)) {
            mergeAgain(n1, TG, notConnectedNodes, NewN1, MergeEdge);
        } else if (TC2.equals(TopologyConnect.ENDE_BESTDIG)) {
            mergeAgain(n2,TG, notConnectedNodes, NewN2,MergeEdge);
        }

        notConnectedNodes.remove(n1);
        notConnectedNodes.remove(n2);





    }
*/
    private void mergeAgain(TopologyGraph.Node n1, TopologyGraph TG, ArrayList<TopologyGraph.Node> notConnectedNodes, TopologyGraph.Node NewN1, TopologyGraph.Edge MergeEdge) {
        TopologyGraph.Node NewN2;
        TopologyConnect TC2;
        TopologyConnect TC1;
        notConnectedNodes.remove(n1);
        ArrayList<TopologyGraph.Node> newConnections = new ArrayList(notConnectedNodes);
        for(TopologyGraph.Node NotConnectNode : newConnections) {
            if(NewN1.equals(NotConnectNode)) continue;
            if(isSamePosition(NewN1,NotConnectNode)) {
                TopologyGraph.Edge EndingEdge = retrieveNextEdge(NotConnectNode);
                if (EndingEdge.A.equals(NotConnectNode)) {
                    NewN2 = EndingEdge.B;
                } else {
                    NewN2 = EndingEdge.A;
                }
                TC1 = retrieveTopologyConnectNotBeeingEnd(MergeEdge);
                TC2 = retrieveTopologyConnectNotBeeingEnd(EndingEdge);
                merge(NewN1, NotConnectNode, TG, newConnections, MergeEdge,
                        EndingEdge, n1, NewN2,  TC1, TC2);

                return;
            }
        }
    }

    private TopologyGraph.Edge retrieveNextEdge(TopologyGraph.Node notConnectNode) {
        ArrayList<TopologyGraph.Edge> edgeList = new ArrayList<>(notConnectNode.inEdges);
        edgeList.addAll(notConnectNode.outEdges);
        for(TopologyGraph.Edge E : edgeList) {
            if (!E.TopConnectFromB.equals(TopologyConnect.ENDE_BESTDIG)) return E;
            if (!E.TopConnectFromA.equals(TopologyConnect.ENDE_BESTDIG)) return E;

        }
        throw new InvalidParameterException("Edge not found");
    }

    private TopologyGraph.Edge merge(TopologyGraph.Node n1, TopologyGraph.Node n2, TopologyGraph TG, ArrayList<TopologyGraph.Node> notConnectedNodes, TopologyGraph.Edge E1, TopologyGraph.Edge E2, TopologyGraph.Node NewN1, TopologyGraph.Node NewN2, TopologyConnect TC1, TopologyConnect TC2) {
        TopologyGraph.Edge MergedEdge = new TopologyGraph.Edge(NewN1, TC1, NewN2, TC2, E1.getPlanProEdge(), E2.getPlanProEdge());
        handleMergedNodes(MergedEdge, E1, E2);


        for (String sPlanProEdgeId : MergedEdge.getPlanProIds()) {
            TG.edgeRepo.put(sPlanProEdgeId, MergedEdge);

        }
        return MergedEdge;
    }

    private void handleMergedNodes(TopologyGraph.Edge mergedEdge, TopologyGraph.Edge e1, TopologyGraph.Edge e2) {
        mergedEdge.mergedNodes.addAll(e1.mergedNodes);
        mergedEdge.mergedNodes.addAll(e2.mergedNodes);
        if(!e1.A.equals(mergedEdge.A) && !e1.A.equals((mergedEdge.B))) mergedEdge.mergedNodes.add(e1.A);
        if(!e1.B.equals(mergedEdge.A) && !e1.B.equals((mergedEdge.B))) mergedEdge.mergedNodes.add(e1.B);
        if(!e2.A.equals(mergedEdge.A) && !e2.A.equals((mergedEdge.B))) mergedEdge.mergedNodes.add(e2.A);
        if(!e2.B.equals(mergedEdge.A) && !e2.B.equals((mergedEdge.B))) mergedEdge.mergedNodes.add(e2.B);


    }

    /*private void rekursiveMerge(TopologyGraph.Node n1, TopologyGraph.Node n2, TopologyGraph TG, TopologyGraph.Edge E1, TopologyGraph.Edge E2, TopologyConnect TC) {
        TopologyGraph.Edge MergedEdge = new TopologyGraph.Edge(n1, TopologyConnect.ENDE_BESTDIG, n2, TC, E1.getPlanProEdge(), E2.getPlanProEdge() );
        TG.edgeRepo.put(MergedEdge.getPlanProId(), MergedEdge);
        connectEdgesAndRemoveOldEdges(n1, n2, TG, connectedNodes);
    }*/

    private TopologyConnect retrieveTopologyConnectNotBeeingEnd(TopologyGraph.Edge e) {
        if(e.TopConnectFromA.equals(TopologyConnect.ENDE_BESTDIG) && e.TopConnectFromB.equals(TopologyConnect.ENDE_BESTDIG))
            return null;
        if(e.TopConnectFromA.equals(TopologyConnect.ENDE_BESTDIG)) return e.TopConnectFromB;
        if(e.TopConnectFromB.equals(TopologyConnect.ENDE_BESTDIG)) return e.TopConnectFromA;
        return null;
    }

    private TopologyGraph.Edge retrieveFirstEdge(TopologyGraph.Node n) {
        for(TopologyGraph.Edge E : n.inEdges)
            return E;
        for(TopologyGraph.Edge E : n.outEdges)
            return E;
        return null;
    }

    private boolean isSamePosition(TopologyGraph.Node n1, TopologyGraph.Node n2) {
        BigDecimal x1 = BigDecimal.valueOf(n1.getGeoCoordinates().getX());
        BigDecimal x2 = BigDecimal.valueOf(n2.getGeoCoordinates().getX());
        BigDecimal y1 = BigDecimal.valueOf(n1.getGeoCoordinates().getY());
        BigDecimal y2 = BigDecimal.valueOf(n2.getGeoCoordinates().getY());
        if(x1.subtract(x2).abs().compareTo(new BigDecimal(1)) > 0) return false;
        if(y1.subtract(y2).abs().compareTo(new BigDecimal(1)) > 0) return false;
        return true;

    }

    /**
     * Diese Methode generiert Weichen {@link CrossingSwitch} und speichert sie in eine Liste in {@link PlanData}
     * @throws ParseException - Wenn undefinierte Werte vorhanden sind, diese aber benötigt werden.
     */
    public void handleBranchingPoints() throws ParseException {
        initBranchingPoints();
        DefaultRepo<String, CBasisObjekt> crossingRepo = crossingBundle.getModel(CWKrAnlage.class);
        DefaultRepo<String, CBasisObjekt> crossingPartsRepo = crossingBundle.getModel(CWKrGspElement.class);
        DefaultRepo<String, CBasisObjekt> crossingKonponentsRepo = crossingBundle.getModel(CWKrGspKomponente.class);

        Collection<CBasisObjekt> listCrossingComponents = crossingKonponentsRepo.getAll();

        //coordinatePartsToCrossing(listCrossingMovement);
        //coordinateComponentsToPart(listCrossingComponents);




        for (Object o : listCrossingComponents) {
            CWKrGspKomponente Comp = (CWKrGspKomponente) o;
            String sElementId = null;
            String sAnlageId = null;
            CWKrGspElement Element = null;
            CWKrAnlage A = null;
            CSignal Signal = null;
            try {
                sElementId = Comp.getIDWKrGspElement().getWert();
            } catch (Exception E) {

            }
            if (sElementId != null) {
                Element = (CWKrGspElement) crossingPartsRepo.getModel(sElementId);
                try {
                    Signal = this.signalRepo.getModel(Element.getWeicheElement().getIDGrenzzeichen().getWert());
                } catch(Exception E) {
                    Signal = null;
                }
            }
            try {
                if (Element != null) sAnlageId = Element.getIDWKrAnlage().getWert();

            } catch (Exception E) {

            }
            if (sAnlageId != null) {
                A = (CWKrAnlage) crossingRepo.getModel(sAnlageId);

            }
            if(A == null) continue;
            CrossingSwitch CS = new CrossingSwitch(A, Element, Comp, Signal);
            PlanData.RailSwitchList.add(CS);
        }
    }

    /**
     * List - gibt eine Liste von Balisen aus der PlanProDatei wider
     */

    @Override
    public List<Balise> getBalises() {
        return BaliseExtractor.getBalises(PlanProDefinition, BaliseExtractor.ExtractorModeEnum.NORMAL);
    }

    @Override
    /**
     * Versieht die Balisen mit Koordinaten und speichert sie nach einem selbst entworfenen Hashcode statisch in die
     * Klasse {@link Balise}
     */
    public void mapBalisesToCoordinate() {
        DefaultRepo<Integer, Balise> baliseByBg = Balise.baliseByNid_bg;
        DefaultRepo<Integer, Balise> tempBalises = new DefaultRepo();
        Collection<Balise> balisesList = baliseByBg.getAll();
        DefaultRepo<String, CBasisObjekt> topNodeRepo = geoBundle.getModel(CTOPKnoten.class);
        DefaultRepo<String, CBasisObjekt> geoPointRepo = geoBundle.getModel(CGEOKnoten.class);

        SlConfigHandler CH = SlConfigHandler.getInstance();


        if(B_PRINT_BALISE_LIST) System.out.println("----Balise-List---");
        for(Balise B : balisesList) {
            CDatenpunkt DP = B.getPlanProDataPoint();
            double dA = DP.getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue();
            CTOPKante TopKante =  B.getTopPositionOfDataPoint();
            String sKnotenAid = TopKante.getIDTOPKnotenA().getWert();
            String sKnotenBid = TopKante.getIDTOPKnotenB().getWert();
            CTOPKnoten N_A = (CTOPKnoten) topNodeRepo.getModel(sKnotenAid);
            CTOPKnoten N_B = (CTOPKnoten) topNodeRepo.getModel(sKnotenBid);
            CGEOKnoten GeoNodeA = (CGEOKnoten) geoPointRepo.getModel(N_A.getIDGEOKnoten().getWert());
            CGEOKnoten GeoNodeB = (CGEOKnoten) geoPointRepo.getModel(N_B.getIDGEOKnoten().getWert());
            GeometricCoordinate Geo_A = PlanData.GeoNodeRepo.getModel(GeoNodeA.getIdentitaet().getWert());
            GeometricCoordinate Geo_B = PlanData.GeoNodeRepo.getModel(GeoNodeB.getIdentitaet().getWert());

            TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(TopKante.getIdentitaet().getWert());


            GeometricCoordinate geoCoordinate;
            try {
                boolean isAMissing;
                boolean isBMissing;
                BigDecimal decBalise = B.getMetersOfTrack();
                isAMissing = E.TopConnectFromA.equals(TopologyConnect.ENDE) || E.TopConnectFromA.equals(TopologyConnect.ENDE_BESTDIG);
                isBMissing = E.TopConnectFromB.equals(TopologyConnect.ENDE) || E.TopConnectFromB.equals(TopologyConnect.ENDE_BESTDIG);
                if(isAMissing && isBMissing) {
                    throw new InvalidParameterException("Both Topology Nodes are End-Nodes");
                } else if (!isAMissing && !isBMissing) {
                    CrossingSwitch CSA = (CrossingSwitch) E.A.NodeImpl;
                    CrossingSwitch CSB = (CrossingSwitch) E.B.NodeImpl;
                    BigDecimal decA = CSA.getTrackMeterByTrackId(B.getPlanProTrack().getIdentitaet().getWert());
                    BigDecimal decB = CSB.getTrackMeterByTrackId(B.getPlanProTrack().getIdentitaet().getWert());

                    BigDecimal decDistanceFromA = null;


                    if(decA.compareTo(decB) < 0) {

                        // not beachten die Balise befindet sich nicht zwischen a und b
                        if(!(decA.compareTo(decBalise) < 0 && decBalise.compareTo(decB) < 0)) throw new InvalidParameterException("Invalid Balise Data");

                        decDistanceFromA = decBalise.subtract(decA);



                    } else {
                        // not beachten die Balise befindet sich nicht zwischen a und b
                        if(!(decB.compareTo(decBalise) < 0 && decBalise.compareTo(decA) < 0)) throw new InvalidParameterException("Invalid Balise Data");

                        decDistanceFromA = decA.subtract(decBalise);



                    }

                    geoCoordinate = MainGraphicPanel.getGeoCoordinate(TopKante.getIdentitaet().getWert(), true, decDistanceFromA.doubleValue());



                } else {
                    Boolean isUpwardToEdge = null;
                    CrossingSwitch CS = null;
                    BigDecimal decResult = null;
                    if(isAMissing) {
                        CS = (CrossingSwitch) E.B.NodeImpl;

                    } else {
                        CS = (CrossingSwitch) E.A.NodeImpl;


                    }
                    BigDecimal dec = CS.getTrackMeterByTrackId(B.getPlanProTrack().getIdentitaet().getWert());
                    if(B.getPlanProTrack().getBezeichnung().getBezeichnungStrecke().getWert().equals("2000")) {
                        if(B.getHashcodeOfBaliseDp() == 4731) {
                            isUpwardToEdge = CH.isTrackPosition_2000_4731_Upward;
                        }
                    }

                    if(isUpwardToEdge == null) throw new InvalidParameterException("No Setting for Balise prepared.");
                    if(isUpwardToEdge) {

                        decResult = dec.add(decBalise);

                    } else {
                        decResult = dec.subtract(decBalise);
                    }
                    geoCoordinate = MainGraphicPanel.getGeoCoordinate(TopKante.getIdentitaet().getWert(), !isAMissing, decResult.doubleValue());
                }


            } catch(Exception Ex) {
                Ex.printStackTrace();
                //geoCoordinate = MainGraphicPanel.getGeoCoordinate(TopKante.getIdentitaet().getWert(), true, dA);
            }



            // getGeoCoordinate()


            //B.setX(geoCoordinate.getX());
            //B.setY(geoCoordinate.getY());

            //UtilFunction.calcTargetGeoByStartPoint(B, dA, Geo_A, Geo_B);

            tempBalises.update(B.getHashcodeOfBaliseDp(), B);

            if(B_PRINT_BALISE_LIST)printBaliseInfo(B, DP, TopKante, Geo_A, Geo_B);


            BaliseExtractor.mapBaliseToDataPoint(DP, B);

        }
        if(B_PRINT_BALISE_LIST) System.out.println("----List-End---");
        Balise.baliseByNid_bg = tempBalises;

    }
    private void printBaliseInfo(Balise B, CDatenpunkt DP, CTOPKante topKante, GeometricCoordinate geo_A, GeometricCoordinate geo_B) {
        System.out.println("Nid-Bg: " + B.getHashcodeOfBaliseDp());
        System.out.println("TopKante-ID: " + topKante.getIdentitaet().getWert());
        System.out.println("DP Abstand: " + DP.getPunktObjektTOPKante().get(0).getAbstand().getWert());
        System.out.println("Geo_A_x: " + geo_A.getX() + " Geo_A_y: " + geo_A.getY());
        System.out.println("Geo_B_x: " + geo_B.getX() + " Geo_B_y: " + geo_B.getY());
    }
    private void initFromFile() throws JAXBException {
        PlanProDefinition = getcPlanProSchnittstelle();
        topLines = PlanProDefinition.getLSTZustand().getContainer().getTOPKante();
        handleSignals();
        handleGeoData();

    }

    private void handleSignals() {
        List<CSignal> signalList = PlanProDefinition.getLSTZustand().getContainer().getSignal();
        for(CSignal Signal : PlanProDefinition.getLSTZustand().getContainer().getSignal()) {
            this.signalRepo.update(Signal.getIdentitaet().getWert(), Signal);
        }
    }

    private void handleGeoData() {
        List<CGEOPunkt> geoPoints = PlanProDefinition.getLSTZustand().getContainer().getGEOPunkt();
        geoBundle = new DefaultRepo<>();

        // Punkte enthalten dem payload der Coordinaten,
        // Aber Knoten werden als String-ID benutzt

        for (CGEOPunkt GeoPunkt : geoPoints) {
            if (GeoPunkt.getIDGEOKnoten() == null) continue;
            String sGeoKnotenId = GeoPunkt.getIDGEOKnoten().getWert();

            GeometricCoordinate GeoCoordTms = new GeometricCoordinate();
            CGEOPunktAllg GeoPointData = GeoPunkt.getGEOPunktAllg();
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
        for (CStrecke Track : trackList) {
            this.trackRepo.update(Track.getIdentitaet().getWert(), Track);
        }
        for (CStreckePunkt Info : trackingInfos) {
            String sIdGeoNode = Info.getIDGEOKnoten().getWert();
            if (sIdGeoNode == null) continue;
            GeometricCoordinate GeoCoordTms = PlanData.GeoNodeRepo.getModel(sIdGeoNode);
            if (GeoCoordTms == null) continue;
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
        List[] geoContents = new List[]{geoPoints, geoNodes, geoLines, topLines, topNodes};
        handlePlanProIndexing(aGeoKeys, geoContents, geoBundle);
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



    private void handlePlanProIndexing(Object[] aKeys, List[] aContents, DefaultRepo<Class<?>,DefaultRepo<String, CBasisObjekt>> targetBundle) {
        if(aKeys.length != aContents.length) throw new InvalidParameterException("Given arrays shall have same length");

        else {
            int iSize = aKeys.length;
            for(int i = 0; i < iSize; i++) {
                DefaultRepo<String, CBasisObjekt> defaultRepo = new DefaultRepo<>();
                Object Bundlekey = aKeys[i];
                List basicObjectList = aContents[i];
                for(Object BasicObject : basicObjectList) {
                    String key;
                    CBasisObjekt CBO = (CBasisObjekt) BasicObject;
                    key = CBO.getIdentitaet().getWert();
                    defaultRepo.update(key, CBO);
                }
                targetBundle.update((Class<?>) Bundlekey, defaultRepo);
            }
        }
    }

    private CPlanProSchnittstelle getcPlanProSchnittstelle() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(plan_pro.modell.planpro._1_9_0.ObjectFactory.class);

        //2. Use JAXBContext instance to create the Unmarshaller.
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        //3. Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.
        JAXBElement<CPlanProSchnittstelle> unmarshalledObject =
                (JAXBElement<CPlanProSchnittstelle>)unmarshaller.unmarshal(
                        ClassLoader.getSystemResourceAsStream(
                                TranslationModel.TrackplanEnvironment.CurrentEnvironment.resourceLocation));

        //4. Get the instance of the required JAXB Root Class from the JAXBElement.
        return unmarshalledObject.getValue();

    }

    private boolean checkIfEdgeIsSearchedOne(String sGeoA, String sGeoB, String sCheckA, String sCheckB) {
        return sCheckA.equals(sGeoA) && sCheckB.equals(sGeoB) ||
                sCheckA.equals(sGeoB) && sCheckB.equals(sGeoA);
    }

    private void handleGeoEdges(TopologyGraph.Node StartNode, CGEOKnoten CurrentGeo, CGEOKnoten NextGeoNode) {
        // return value
        ArrayList<CGEOKante> resultEdges = new ArrayList<>();
        // already visitedNodes
        ArrayList<String> visitedGeoNodesIds = new ArrayList<>();
        String sGeoA = CurrentGeo.getIdentitaet().getWert();
        String sGeoB = NextGeoNode.getIdentitaet().getWert();
        CTOPKnoten LastTopNode = null;
        // all connected Edges
        List<CGEOKante> connectedEdges = geoNodeToGeoEdgesRepo.getModel(CurrentGeo.getIdentitaet().getWert());

        // check all nodes from branching point
        String sGeoCurrent;
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




            }
        }

        if(LastTopNode == null) {
            throw new NullPointerException("Last TopNode may not be null");
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

    private void fillGeoEdgeRelateToGeoNodeRepo(DefaultRepo<String, CBasisObjekt> geoPointRepo) {
        for (Object geoObject :  geoBundle.getModel(CGEOKante.class).getAll()) {
            CGEOKante geoEdge = (CGEOKante) geoObject;
            CGEOKnoten geoNodeA = (CGEOKnoten) geoPointRepo.getModel(geoEdge.getIDGEOKnotenA().getWert());
            CGEOKnoten geoNodeB = (CGEOKnoten) geoPointRepo.getModel(geoEdge.getIDGEOKnotenB().getWert());

            relateEdgeToNode(geoEdge, geoNodeA);
            relateEdgeToNode(geoEdge, geoNodeB);

        }
    }


    private static GeometricCoordinate getGeoCoordinate(DefaultRepo<String, CBasisObjekt> nodeRepo, String sNodeA) {
        CTOPKnoten TopNode = (CTOPKnoten) nodeRepo.getModel(sNodeA);
        String sGeoNodeId = TopNode.getIDGEOKnoten().getWert();
        //CGEOKnoten geoPointOfNode = geoPointRepo.getModel(sGeoNodeId);
        return PlanData.GeoNodeRepo.getModel(sGeoNodeId);
    }



}
