package de.ibw.tms.trackplan.ui;

import java.util.ArrayList;

public class PlatformEdge extends StopPosition {
    public static class Entrances {
        private String sZugangsArt;
        private boolean isHauptzugang;
        private String sId;

        public String getsId() {
            return sId;
        }

        public void setsId(String sId) {
            this.sId = sId;
        }

        public String getsZugangsArt() {
            return sZugangsArt;
        }

        public void setsZugangsArt(String sZugangsArt) {
            this.sZugangsArt = sZugangsArt;
        }

        public boolean isHauptzugang() {
            return isHauptzugang;
        }

        public void setHauptzugang(boolean hauptzugang) {
            isHauptzugang = hauptzugang;
        }
    }
    private String sIdAnlage;
    private String sAnlagenBezeichnung;
    private String sKantenBezeichnung;
    private LinksRechts positionsLageZumGleis;
    private ArrayList<Entrances> zugangsListe = new ArrayList<>();
    private String sHoehe;

    public String getsIdAnlage() {
        return sIdAnlage;
    }

    public void setsIdAnlage(String sIdAnlage) {
        this.sIdAnlage = sIdAnlage;
    }

    public String getsAnlagenBezeichnung() {
        return sAnlagenBezeichnung;
    }

    public void setsAnlagenBezeichnung(String sAnlagenBezeichnung) {
        this.sAnlagenBezeichnung = sAnlagenBezeichnung;
    }

    public String getsKantenBezeichnung() {
        return sKantenBezeichnung;
    }

    public void setsKantenBezeichnung(String sKantenBezeichnung) {
        this.sKantenBezeichnung = sKantenBezeichnung;
    }

    public LinksRechts getPositionsLageZumGleis() {
        return positionsLageZumGleis;
    }

    public void setPositionsLageZumGleis(LinksRechts positionsLageZumGleis) {
        this.positionsLageZumGleis = positionsLageZumGleis;
    }



    public String getsHoehe() {
        return sHoehe;
    }

    public void setsHoehe(String sHoehe) {
        this.sHoehe = sHoehe;
    }

    public ArrayList<Entrances> getZugangsListe() {
        return zugangsListe;
    }
    public void addEntrance(Entrances E) {
        if(!zugangsListe.contains(E)) this.zugangsListe.add(E);
    }

}
