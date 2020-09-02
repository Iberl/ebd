package de.ibw.tms.plan_pro.adapter;

import de.ibw.tms.plan_pro.adapter.topology.trackbased.ICompareTrackMeter;
import de.ibw.util.DefaultRepo;
import org.greenrobot.eventbus.Logger;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektStrecke;
import plan_pro.modell.basistypen._1_9_0.CBezeichnungElement;
import plan_pro.modell.geodaten._1_9_0.CStrecke;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrAnlage;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspElement;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspKomponente;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.ENUMWKrArt;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Ein Wrapper f&uuml;r Weichen aus PlanPro
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class CrossingSwitch implements ICompareTrackMeter {



    private CWKrAnlage Anlage;
    private CWKrGspElement Element;
    private CWKrGspKomponente Component;
    private ArrayList<String> supportedTracks = new ArrayList<>();
    private DefaultRepo<String, BigDecimal> TrackMeterByTrackId = new DefaultRepo<>();

    /**
     * Instanziiert eine Weichenwrappter
     * @param A {@link CWKrAnlage} - Weicheanlagedaten
     * @param E {@link CWKrGspElement} - Weichenelement
     * @param C {@link CWKrGspKomponente} - Weichenkomponente
     * @throws ParseException - Falls die Streckenkilometrierung sich nicht in double konvertieren l&auml;&szlig;t
     */
    public CrossingSwitch(CWKrAnlage A, CWKrGspElement E, CWKrGspKomponente C) throws ParseException {
        this.Anlage = A;
        this.Element = E;
        this.Component = C;
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
     * Gibt den Titel einer Weiche im EBD wider. Zum Beispiel "12W14"
     * @return String - der Titel
     */
    public String getEbdTitle() {
        boolean isDKW = isDKW();

        CWKrGspElement Element = getElement();
        if(Element == null) return null;
        CBezeichnungElement B = Element.getBezeichnung();
        if(B == null) return null;
        try {
            String sAddOn = "";
            if(isDKW) {
                String sID = this.getComponent().getIdentitaet().getWert();
                sAddOn = "UID" + sID.substring(sID.length() - 3);
            }

            return B.getBezeichnungTabelle().getWert() + sAddOn;
        } catch(Exception E) {
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
