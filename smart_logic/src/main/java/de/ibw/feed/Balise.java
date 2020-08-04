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

public class Balise implements ICoord<Double> {
    /**
     * This repository stores first Balise of Balisegroup(PlanProDataPoint) by its nid_bg
     * The nid_bg is the hash of the String ID from Plan Pro of PlanProDataPoint
     */
    public static DefaultRepo<Integer, Balise> baliseByNid_bg = new DefaultRepo<>();
    public static DefaultRepo<Balise, Integer> hashOfBalise = new DefaultRepo<>();
    /**
     * This repository stores all Balises for this Datapoint
     */
    public static DefaultRepo<CDatenpunkt, List<Balise>> balisesByBaliseGroup = new DefaultRepo<>();

    private CBalise PlanProBalise;
    private CDatenpunkt PlanProDataPoint = null;
    private CTOPKante TopPositionOfDataPoint = null;
    private CStrecke PlanProTrack = null;
    //private CBasisObjekt PlanProBezugspunkt;

    private double x;
    private double y;


    public BufferedImage getImage() throws IOException {
        ClassLoader cl = this.getClass().getClassLoader();
        return UiTools.handleImaging(cl,"images/balise.jpg");
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public CBalise getPlanProBalise() {
        return PlanProBalise;
    }

    public void setPlanProBalise(CBalise planProBalise) {
        PlanProBalise = planProBalise;
    }

    public CDatenpunkt getPlanProDataPoint() {
        return PlanProDataPoint;
    }

    public void setPlanProDataPoint(CDatenpunkt planProDataPoint) {
        PlanProDataPoint = planProDataPoint;
    }

    public CTOPKante getTopPositionOfDataPoint() {
        return TopPositionOfDataPoint;
    }

    public void setTopPositionOfDataPoint(CTOPKante topPositionOfDataPoint) {
        TopPositionOfDataPoint = topPositionOfDataPoint;
    }

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
    public Integer calculateNewHash(int bitmask) {
        Integer currentHash;
        String sId = this.PlanProDataPoint.getIdentitaet().getWert();
        currentHash = sId.hashCode() & bitmask;

        Balise BaliseOfHash = Balise.baliseByNid_bg.getModel(currentHash);
        // bei eins starten für neuen hash
        // vermeidet überlauf der 14 bits
        if(checkifHashOfBaliseIsAlreadyUsed(BaliseOfHash)) {
            currentHash = 1;
            BaliseOfHash = Balise.baliseByNid_bg.getModel(currentHash);

        }
        // von eins aus prüfen ob ein hash frei ist
        while (checkifHashOfBaliseIsAlreadyUsed(BaliseOfHash)) {
            currentHash++;
            BaliseOfHash = Balise.baliseByNid_bg.getModel(currentHash);

        }
        Balise.baliseByNid_bg.update(currentHash, this);
        Balise.hashOfBalise.update(this,currentHash);
        return currentHash;
    }

}
