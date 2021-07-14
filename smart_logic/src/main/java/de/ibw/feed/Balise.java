package de.ibw.feed;


import de.ibw.tms.ma.occupation.Occupation;
import de.ibw.tms.plan.elements.UiTools;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.DefaultRepo;
import de.ibw.util.ICoord;
import de.ibw.util.ThreadedRepo;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CBalise;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CDatenpunkt;
import plan_pro.modell.basistypen._1_9_0.ENUMAusrichtung;
import plan_pro.modell.basistypen._1_9_0.ENUMWirkrichtung;
import plan_pro.modell.geodaten._1_9_0.CStrecke;
import plan_pro.modell.geodaten._1_9_0.CTOPKante;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse stellt eine Balise mit deren Koordinaten dar.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.12
 * @since 2021-07-09
 */
public class Balise implements ICoord<Double> {
    /**
     * Dieses Repository speichert die erste Baise einer Balisengruppe &uuml;ber einem Hashwert der PlanPro Datei
     */
    public static DefaultRepo<Integer, Balise> baliseByNid_bg = new DefaultRepo<>();
    /**
     * Dieses Repository gibt f&uuml;r eine Balise als Objekt-Schl&uuml;ssel den Hashwert zur&uuml;ck
     */
    public static DefaultRepo<Balise, Integer> hashOfBalise = new DefaultRepo<>();
    /**
     * Dieses Repository speichert f&uuml;r eine Datenpunkt eine Liste von Balisen ab
     */
    public static DefaultRepo<CDatenpunkt, List<Balise>> balisesByBaliseGroup = new DefaultRepo<>();

    /**
     * Definiert alle Balises auf einer Topologieschen Kannte
     */
    public static ThreadedRepo<TopologyGraph.Edge, ArrayList<Balise>> baliseOnEdge = new ThreadedRepo<>();
    /**
     * Balise color auf dem Trackpanel
     */
    public static Color DEFAULTCOLOR = Color.CYAN.darker();

    private CBalise PlanProBalise;
    private CDatenpunkt PlanProDataPoint = null;
    private CTOPKante TopPositionOfDataPoint = null;
    private CStrecke PlanProTrack = null;
    //private CBasisObjekt PlanProBezugspunkt;

    private double x;
    private double y;



    /**
     * Die Darstelung als Bild dieser Balise
     * @return BufferedImage - Ein Bild
     * @throws IOException - Falls die Bilddatei nicht gefunden wurde
     */
    public BufferedImage getImage() throws IOException {
        ClassLoader cl = this.getClass().getClassLoader();
        return UiTools.handleImaging(cl,"images/balise.jpg");
    }

    /**
     * Gibt Laenge der Kante auf die sich der Datenpunkt befindet zurueck.
     * @return Laenge der Kante
     */
    public BigDecimal getLengthOfTopEdge() {
        return this.TopPositionOfDataPoint.getTOPKanteAllg().getTOPLaenge().getWert();
    }

    /**
     * @deprecated
     * unused
     * @return Streckenkilometrierung
     */
    public BigDecimal getMetersOfTrack() {
        try {
            String sKM = PlanProDataPoint.getPunktObjektStrecke().get(0).getStreckeKm().getWert();
            String sMeter = sKM.replace(".", "");
            sMeter = sMeter.replace(",", "");
            return new BigDecimal(sMeter);
        } catch (Exception E) {
            E.printStackTrace();
            return null;
        }
    }

    private boolean isDatapointNominal() {
        return this.PlanProDataPoint.getDatenpunktAllg().getAusrichtung().getWert().equals(ENUMAusrichtung.IN);
    }

    private boolean isTopologicalNominal() {
        return this.PlanProDataPoint.getPunktObjektTOPKante().get(0).getWirkrichtung().getWert().equals(ENUMWirkrichtung.IN);
    }

    /**
     * Gibt an ob die Balise auf Knoten B in nominaler Richtung zeigt
     * Das heisst von Balis 1 zu Balise 2 geht der Weg in richtung Knoten B
     * @return boolean - true, falls der Topologische-Knoten B in Trigger-Richtung ist
     *                   false, wenn der Topologische-Knoten A in Trigger-Richtung ist
     */
    public boolean isNominalTriggeredToNodeB() {
        return this.isDatapointNominal();
    }

    private ENUMAusrichtung getDpAusrichtung(){
        return this.getPlanProDataPoint().getDatenpunktAllg().getAusrichtung().getWert();
    }

    private BigDecimal getDpLength() {
        return this.getPlanProDataPoint().getDatenpunktAllg().getDatenpunktLaenge().getWert();
    }

    /**
     * Distanz von Knoten A
     * @return BigDecimal - distance in Meter
     */
    public BigDecimal getBalisenPositionFromNodeA() {
        BigDecimal dResult = this.PlanProDataPoint.getPunktObjektTOPKante().get(0).getAbstand().getWert();
        //if(isNominalTriggeredToNodeB()) return dResult;
        //else return this.TopPositionOfDataPoint.getTOPKanteAllg().getTOPLaenge().getWert().subtract(dResult);
        return dResult;
    }


    /**
     * Gibt den angefragten Knoten der Balisengruppe wieder. Es wird der Knoten der in angegebener Richtung angefragt
     * wiedergegeben.
     * @param q_dlrbg_IsNominal - true bedeutet es wird der Knoten wiedergegeben, der von von Balise 1 &uuml;ber
     *                               Balise 2 an- oder durchfahren wird.
     *                               - false bedeutet es wird der Knoten wiedergegeben, der von Balise 2 &uumL;ber
     *                               Balise 1 an- oder durchfahren wird.
     * @return Node - der Knoten, der der angegebenen Richtung entspricht.
     */
    public TopologyGraph.Node getNodeInDirectionOfBaliseGroup(boolean q_dlrbg_IsNominal ) {
        String sNodeId = null;
        if(isDatapointNominal() == q_dlrbg_IsNominal) {
            sNodeId = this.TopPositionOfDataPoint.getIDTOPKnotenB().getWert();
        } else {
            sNodeId = this.TopPositionOfDataPoint.getIDTOPKnotenA().getWert();
        }
        return TopologyGraph.NodeRepo.get(sNodeId);
    }



    /**
     * gibt die x-Koordinate dieser Balise wider
     */
    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    /**
     * Gibt die Y-Koordinate dieser Balise zur wider
     */
    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    /**
     * gibt eine definierte Balise, wie sie aus der PlanPro Datei gelesen wird wider
     * @return CBalise
     */
    public CBalise getPlanProBalise() {
        return PlanProBalise;
    }

    public void setPlanProBalise(CBalise planProBalise) {
        PlanProBalise = planProBalise;
    }

    /**
     * gibt den Datenpunkt wie im PlanProFormat wider
     * @return CDatenpunkt
     */
    public CDatenpunkt getPlanProDataPoint() {
        return PlanProDataPoint;
    }

    public void setPlanProDataPoint(CDatenpunkt planProDataPoint) {
        PlanProDataPoint = planProDataPoint;
    }

    /**
     * gibt eine Topologische Kante wider
     * @return CTOPKante
     */
    public CTOPKante getTopPositionOfDataPoint() {
        return TopPositionOfDataPoint;
    }

    public void setTopPositionOfDataPoint(CTOPKante topPositionOfDataPoint) {
        TopPositionOfDataPoint = topPositionOfDataPoint;
    }

    /**
     * gibt die Strecke auf die die Balise liegt wider
     * @return CStrecke
     */
    public CStrecke getPlanProTrack() {
        return PlanProTrack;
    }

    public void setPlanProTrack(CStrecke planProTrack) {
        PlanProTrack = planProTrack;
    }

    /**
     *
     * @param BaliseOfHash
     * @return true if Hash is not accepted (already used)
     * return false if Hash is okay
     */
    private boolean checkifHashOfBaliseIsAlreadyUsed(Balise BaliseOfHash) {
        return !(BaliseOfHash == null || BaliseOfHash == this);
    }

    /**
     * generiert Hashcode der noch nicht vergeben wurde
     * @return int - generierter 14 bit Hashcode
     */
    public int getHashcodeOfBaliseDp() {
        int bitmask = 16383;//14 bit‬;
        Integer currentHash = Balise.hashOfBalise.getModel(this);
        if(currentHash == null) {
            currentHash = calculateNewHash(bitmask);


        }
        return currentHash;

    }

    /**
     * calculates new Hash and Stores into Repositories
     * @param bitmask - bitmask 14 Bit
     * @return hash of 14 bit
     */
    private Integer calculateNewHash(int bitmask) {
        Integer currentHash;
        String sId = this.PlanProDataPoint.getIdentitaet().getWert();
        currentHash = sId.hashCode() & bitmask;

        Balise BaliseOfHash = Balise.baliseByNid_bg.getModel(currentHash);
        // bei eins starten f&uuml;r neuen hash
        // vermeidet &uuml;berlauf der 14 bits
        if(checkifHashOfBaliseIsAlreadyUsed(BaliseOfHash)) {
            currentHash = 1;
            BaliseOfHash = Balise.baliseByNid_bg.getModel(currentHash);

        }
        // von eins aus pr&uuml;fen ob ein hash frei ist
        while (checkifHashOfBaliseIsAlreadyUsed(BaliseOfHash)) {
            currentHash++;
            BaliseOfHash = Balise.baliseByNid_bg.getModel(currentHash);

        }
        Balise.baliseByNid_bg.update(currentHash, this);
        Balise.hashOfBalise.update(this,currentHash);
        return currentHash;
    }

    /**
     * Gibt die Ausdehnung eines Datenpunktes mit Balisen wieder
     * @return BlockedArea - Ausdehnung als Balise - streng genommen keine BlockedArea, aber praktisch,
     *                      bei Vergleich ob sich eine Balise mit anderen Bereichen schneidet.
     */
    public Occupation createAreaFromBalise() {
        return createDummyArea();
    }

    private Occupation createDummyArea() {
        // ausdehnung um den Datenpunkt sicherheitshalber in beiden Richtung
        // Real abhängig vom Datenpunkt
        PlanData.getInstance();
        BigDecimal dDpLength = this.getDpLength();
        BigDecimal dDistanceFromA = this.getBalisenPositionFromNodeA();
        BigDecimal dTrackLength = this.getLengthOfTopEdge();
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(this.TopPositionOfDataPoint.getIdentitaet().getWert());
        
        BigDecimal dStart = dDistanceFromA.subtract(dDpLength);
        BigDecimal dEnd = dDistanceFromA.add(dDpLength);
        if(dStart.compareTo(new BigDecimal(0) ) < 0) dStart = new BigDecimal(0);
        if(dEnd.compareTo(dTrackLength) > 0) dEnd = dTrackLength;
        //return new Occupation(E,scale, dStart.intValue(), scale, dEnd.intValue() );
        return null;
    }
}
