package de.ibw.feed;

import de.ibw.tms.plan.elements.UiTools;
import de.ibw.util.DefaultRepo;
import de.ibw.util.ICoord;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CBalise;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CDatenpunkt;
import plan_pro.modell.geodaten._1_9_0.CStrecke;
import plan_pro.modell.geodaten._1_9_0.CTOPKante;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Diese Klasse stellt eine Balise mit deren Koordinaten dar.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
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

}
