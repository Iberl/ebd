package de.ibw.tms.plan_pro.adapter;

import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrAnlage;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspElement;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspKomponente;

/**
 * Wrapper for mulitible BranchingObjects of Planpro
 */
public class CrossingSwitch {
    private CWKrAnlage Anlage;
    private CWKrGspElement Element;
    private CWKrGspKomponente Component;

    public CrossingSwitch(CWKrAnlage A, CWKrGspElement E, CWKrGspKomponente C) {
        this.Anlage = A;
        this.Element = E;
        this.Component = C;
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
