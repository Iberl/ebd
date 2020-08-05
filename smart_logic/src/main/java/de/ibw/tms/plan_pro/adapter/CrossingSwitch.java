package de.ibw.tms.plan_pro.adapter;

import de.ibw.util.DefaultRepo;
import org.greenrobot.eventbus.Logger;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektStrecke;
import plan_pro.modell.geodaten._1_9_0.CStrecke;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrAnlage;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspElement;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspKomponente;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Wrapper for mulitible BranchingObjects of Planpro
 */
public class CrossingSwitch {
    private CWKrAnlage Anlage;
    private CWKrGspElement Element;
    private CWKrGspKomponente Component;

    private DefaultRepo<String, Double> TrackMeterByTrackId = new DefaultRepo<>();

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
                    d
                );
        }
    }

    public CWKrAnlage getAnlage() {
        return Anlage;
    }

    public CWKrGspElement getElement() {
        return Element;
    }

    public CWKrGspKomponente getComponent() {
        return Component;
    }
}
