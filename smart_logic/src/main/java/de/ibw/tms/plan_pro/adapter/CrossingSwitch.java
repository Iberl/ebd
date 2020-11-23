package de.ibw.tms.plan_pro.adapter;

import de.ibw.tms.ma.occupation.Occupation;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.trackbased.ICompareTrackMeter;
import de.ibw.util.DefaultRepo;
import org.apache.commons.lang3.NotImplementedException;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektStrecke;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektTOPKante;
import plan_pro.modell.basistypen._1_9_0.CBezeichnungElement;
import plan_pro.modell.signale._1_9_0.CSignal;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrAnlage;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspElement;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspKomponente;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.ENUMWKrArt;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Ein Wrapper f&uuml;r Weichen aus PlanPro
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-09-29
 */
public class
CrossingSwitch implements ICompareTrackMeter {



    private CWKrAnlage Anlage;
    private CWKrGspElement Element;
    private CWKrGspKomponente Component;
    private CSignal Signal;
    private ArrayList<String> supportedTracks = new ArrayList<>();
    private DefaultRepo<String, BigDecimal> TrackMeterByTrackId = new DefaultRepo<>();

    /**
     * Instanziiert eine Weichenwrappter
     * @param A {@link CWKrAnlage} - Weicheanlagedaten
     * @param E {@link CWKrGspElement} - Weichenelement
     * @param C {@link CWKrGspKomponente} - Weichenkomponente
     * @param signal {@link CSignal} - Signal
     * @throws ParseException - Falls die Streckenkilometrierung sich nicht in double konvertieren l&auml;&szlig;t
     */
    public CrossingSwitch(CWKrAnlage A, CWKrGspElement E, CWKrGspKomponente C, CSignal signal) throws ParseException {
        this.Anlage = A;
        this.Element = E;
        this.Component = C;
        this.Signal = signal;
        for(CPunktObjektStrecke TrackRelevantObj : C.getPunktObjektStrecke()) {
            NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
            Number number = format.parse(TrackRelevantObj.getStreckeKm().getWert());
            double d = number.doubleValue() * 1000;

            TrackMeterByTrackId.update(
                    TrackRelevantObj.getIDStrecke().getWert(),
                    BigDecimal.valueOf(d)
                );
            supportedTracks.add(TrackRelevantObj.getIDStrecke().getWert());
        }
        ISwitchHandler.registerCrossingSwitch(A, this);
    }

    /**
     * Gibt Weichenanlagendaten wider
     * @return CWKrAnlage - Weichenanlage
     */
    public CWKrAnlage getAnlage() {
        return Anlage;
    }

    /**
     * Gibt Weichenelement wider
     * @return CWKrGspElement - Weichen Element
     */
    public CWKrGspElement getElement() {
        return Element;
    }

    /**
     * Gibt Weichenkomponente wider
     * @return CWKrGspKomponente - Weichenkomponente
     */
    public CWKrGspKomponente getComponent() {
        return Component;
    }


    /**
     * Signal als Grenzzeichen
     * @return CSignal - Grenzzeichen
     */
    public CSignal getSignal() {
        return Signal;
    }

    /**
     * Gibt den Grenzbereich auf der angegebenen Kante zu dieser Crossing-Switch wider
     * @param E - {@link TopologyGraph.Edge} Die Kante zu der der Grenzbereich festgestellt werden soll
     * @return BigDecimal - Abstand von dieser Crossing-Switch der den Grenzbereich darstellt.
     */
    public BigDecimal getInsecureRangeRelative(TopologyGraph.Edge E) {
        CSignal Sig = this.getSignal();

        for(CPunktObjektTOPKante CTopKante : Sig.getPunktObjektTOPKante()) {
            if (CTopKante.getIDTOPKante().getWert().equals(E.sId)) {
                return CTopKante.getAbstand().getWert();
            }
        }
        throw new InvalidParameterException("Edge has for this Switch no insecure Area");
    }

    /**
     * @deprecated
     * Gibt den Grenzbereich dieser Weiche wider.
     * @param E - Grenzbereich wird zu Topologischen Kante E widergegeben
     * @return BlockedArea - Grenzbereich als Blockierter Abschnitt
     */
    public Occupation getInsecureAreAtGivenEdge(TopologyGraph.Edge E) {
        throw new NotImplementedException("deprecated");
    }

    private boolean checkIfConnectedByA(TopologyGraph.Edge Edge) {
        if(Edge.A.NodeImpl != null) {

            if(this.equals(Edge.A.NodeImpl)) return true;
        }
        if(Edge.B.NodeImpl != null) {
            if(this.equals(Edge.B.NodeImpl)) return false;
        }
        throw new InvalidParameterException("Edge is not connected to this Switch");

    }

    /**
     * Gibt den Titel einer Weiche im EBD wider. Zum Beispiel "12W14"
     * @return String - der Titel
     */
    public String getEbdTitle(int sidDKWshortage, boolean isFull, boolean withoutAddOn) {
        boolean isDKW = isDKW();

        CWKrGspElement Element = getElement();
        if(Element == null) return null;
        CBezeichnungElement B = Element.getBezeichnung();
        if(B == null) return null;
        try {
            String sAddOn = "";
            if(isDKW) {
                String sID = this.getComponent().getIdentitaet().getWert();
                if(isFull) {
                    sAddOn = "UID" + sID;
                } else {
                    sAddOn = "UID" + sID.substring(sID.length() - sidDKWshortage);
                }
            }
            if(withoutAddOn) return B.getBezeichnungTabelle().getWert();
            return B.getBezeichnungTabelle().getWert() + sAddOn;
        } catch(Exception E) {
            return null;
        }
    }

    public Integer getLocalElementId() {
        CWKrGspElement Element = getElement();
        CBezeichnungElement B = Element.getBezeichnung();
        if (B == null) return null;
        System.out.println(Element.getIdentitaet().getWert());
        try {
            return Integer.parseInt(B.getBezeichnungLageplanKurz().getWert());
        } catch (NullPointerException NPE) {
            return null;
        }
    }


    public boolean isDKW() {
        boolean isDKW = false;
        try {
            if (Anlage.getWKrAnlageAllg().getWKrArt().getWert().equals(ENUMWKrArt.DKW)) {
                isDKW = true;
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return isDKW;
    }

    /**
     * Checks if corssover belonging to same Anlage
     * like Two Kompontents of DKW belonging to same Anlage
     * @return boolean - true for beeing same else false
     */
    public boolean isSameAnlage(CrossingSwitch CS) {
        return (this.Anlage.getIdentitaet().getWert().equals(CS.Anlage.getIdentitaet().getWert()));
    }

    /**
     * Gibt die Streckenkilometrierung einer Strecke wider.
     * @param trackId {@link String} - StreckenId aus PLanPro, die zur Kilometrierung verwendet wird
     * @return BigDecimal - Streckekilometrierung in Meter
     */

    @Override
    public BigDecimal getTrackMeterByTrackId(String trackId) {
        return this.TrackMeterByTrackId.getModel(trackId);
    }


    /**
     * Gibt eine Liste von Strecken-Ids von Strecken, die eine Kilometrierung auf dieser Weiche haben.
     * Es kann vorkommen, dass an einem Knoten eine Strecke aufh&ouml;rt und eine neue beginnt.
     * @return ArrayList - Liste von Strecken-Ids
     */
    @Override
    public ArrayList<String> getSupportedTracks() {
        return this.supportedTracks;
    }




}
