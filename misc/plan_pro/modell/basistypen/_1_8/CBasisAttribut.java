//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.basistypen._1_8;

import modell.ansteuerung_element._1_8.*;
import modell.bahnsteig._1_8.*;
import modell.bahnuebergang._1_8.*;
import modell.basisobjekte._1_8.*;
import modell.bedienung._1_8.*;
import modell.block._1_8.*;
import modell.fahrstrasse._1_8.*;
import modell.flankenschutz._1_8.*;
import modell.geodaten._1_8.*;
import modell.gleis._1_8.*;
import modell.nahbedienbereich._1_8.*;
import modell.ortung._1_8.*;
import modell.planpro._1_8.*;
import modell.pzb._1_8.*;
import modell.regelzeichnung._1_8.*;
import modell.schluesselabhaengigkeiten._1_8.*;
import modell.signale._1_8.*;
import modell.verweise._1_8.TCIDBearbeitungsvermerk;
import modell.weichen_und_gleissperren._1_8.*;
import modell.zuglenkung._1_8.*;
import modell.zugnummernmeldeanlage._1_8.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Das BasisAttribut stellt die Schablone f�r alle Attribute aller Objekte dar. 
 * 
 * Die Attributeigenschaften des BasisAttributs sind in 2 Gruppen unterteilbar. Zum einen die vom Modell gef�llten Attribute, die als eine xs:appinfo umgesetzt sind:
 * � Beispielbefuellung, 
 * � Patternbeschreibung, 
 * � Planungsphase. 
 * 
 * In ihnen werden Informationen zum Attribut fest gespeichert. Sie sind f�r alle Programme, die das Schema auslesen, verf�gbar und werden zur Durchf�hrung von Pr�fungen verwendet oder um dem jeweiligen Bearbeitungsprogramm zus�tzliche Informationen �ber das Attribut zur Verf�gung zu stellen.
 * 
 * Die zweite Gruppe der Attributeigenschaften sind als XSDElement modellierten Informationen, die von den Nutzern der Schnittstelle erstellt werden. Es handelt sich neben dem eigentlichen Wert, welcher verpflichtend zu f�llen ist, um einen oder mehrere optionale Verweise auf Bearbeitungsvermerke. In diesen k�nnen weitere Informationen zu der speziellen Auspr�gung des Attributs hinterlegt werden.
 * � ID_Bearbeitungsvermerk, 
 * � Wert.
 * 
 * <p>Java-Klasse f�r CBasisAttribut complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBasisAttribut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Bearbeitungsvermerk" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Bearbeitungsvermerk" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBasisAttribut", propOrder = {
    "idBearbeitungsvermerk"
})
@XmlSeeAlso({
    TCBezeichnungAEA.class,
    TCStandortBeschreibung.class,
    TCBandbreite.class,
    TCBauart.class,
    TCTechnikBeschreibung.class,
    TCAussenelementansteuerungArt.class,
    TCTechnikArt.class,
    TCEnergieversorgungArt.class,
    modell.ansteuerung_element._1_8.TCHersteller.class,
    TCPhysik.class,
    TCNetz.class,
    TCBezeichnungESTWZE.class,
    TCEnergieversorgungArtErsatz.class,
    TCUnterbringungArt.class,
    TCUnterbringungBefestigung.class,
    TCUebertragungswegArt.class,
    TCBezeichnungLageplanLang.class,
    TCBezeichnungLageplanKurz.class,
    TCBezeichnungAussenanlage.class,
    TCKennzahl.class,
    TCBezeichnungTabelle.class,
    TCOertlicherElementbezeichner.class,
    TCZeiger.class,
    TCAnhangArt.class,
    TCBearbeitungsvermerkRolle.class,
    TCRichtungsbezug.class,
    TCKommentar.class,
    TCDBGDIReferenz.class,
    TCDaten.class,
    TCIdentitaet.class,
    TCBearbeitungsvermerkKennung.class,
    TCNameLSTObjekt.class,
    TCDatumRegelwerk.class,
    modell.basisobjekte._1_8.TCStreckeKm.class,
    TCSeitlicheLage.class,
    TCZeitBearbeitungsvermerk.class,
    TCSeitlicherAbstand.class,
    TCDateiname.class,
    TCKurztext.class,
    modell.basisobjekte._1_8.TCWirkrichtung.class,
    TCObjektzustandBesonders.class,
    TCBegrenzungB.class,
    TCBegrenzungA.class,
    TCTechnischerPlatz.class,
    TCAbstand.class,
    TCDateityp.class,
    TCBahnsteigZugangPrioritaet.class,
    TCLageZumGleis.class,
    TCBahnsteigZugangArt.class,
    TCBezeichnungBahnsteigKante.class,
    TCBezeichnungBahnsteigAnlage.class,
    TCSystemhoehe.class,
    TCLFUEImpuls.class,
    TCBUETechnik.class,
    TCGleisAmBue.class,
    TCBUESicherungsart.class,
    TCEinschaltverzErrechnet.class,
    TCBUEFunktionsueberwachung.class,
    TCBUEStrasse.class,
    TCEinschaltverzGewaehlt.class,
    TCKurzzugschaltung.class,
    TCBUEMitGFR.class,
    TCStoerhaltHaltfall.class,
    TCSignalverzErrechnet.class,
    TCSignalverzGewaehlt.class,
    TCAutoHet.class,
    TCBUEVorlaufzeit.class,
    TCTeilvorgabezeit.class,
    TCZeitueberschreitungsmeldung.class,
    TCBUEBauart.class,
    TCBUEBetriebsartenstecker.class,
    TCBUENachlaufzeit.class,
    TCBUEBuestra.class,
    TCBUEHandschalteinrichtung.class,
    TCStoerhaltMerkhinweis.class,
    TCBetriebsstellenbezeichner.class,
    TCSchalter.class,
    TCCWert.class,
    TCYYWert.class,
    TCSteuerbezirksnummer.class,
    TCBWert.class,
    TCVorschauzeit.class,
    TCBezBedAnzeigeElement.class,
    TCBezBedZentrale.class,
    TCDDWert.class,
    TCBedienEinrichtOertlBez.class,
    TCTaste.class,
    TCOberflaecheBildart.class,
    TCMelder.class,
    TCBedienplatznummer.class,
    TCXWert.class,
    TCOberflaecheZustaendigkeit.class,
    modell.bedienung._1_8.TCHersteller.class,
    TCBedienEinrichtBauart.class,
    modell.bedienung._1_8.TCKennzahl.class,
    TCYWert.class,
    TCAnbindungIB3 .class,
    TCSteuerbezirksname.class,
    TCSchrankreihe.class,
    TCAWert.class,
    TCHupeAnschaltzeit.class,
    TCBezBedAnrueckabschnitt.class,
    TCBedienplatzbezeichnung.class,
    TCAnbindungIB2 .class,
    TCBedienraumnummer.class,
    TCRueckschauzeit.class,
    TCBedienPlatzArt.class,
    TCRueckblockwecker.class,
    TCVorblockwecker.class,
    TCSchutzuebertrager.class,
    TCErlaubnisabgabespeicherung.class,
    TCBlockBauform.class,
    TCErlaubnisStaendigVorhanden.class,
    TCBetriebsfuehrung.class,
    TCBremsweg.class,
    TCAutoErlaubnisholen.class,
    TCSchaltung.class,
    TCErlaubnisholen.class,
    TCEntwurfsgeschwindigkeit.class,
    TCAutoErlaubnisruecklauf.class,
    TCRangierGegenfahrtausschluss.class,
    TCDWegV.class,
    TCRangierGleisfreimeldung.class,
    TCAutomatischeEinstellung.class,
    TCDWegVorzug.class,
    TCFstrBildezeit.class,
    TCFstrMittelVAufwertung.class,
    TCFstrVsigabstandVerkuerzt.class,
    TCDWegVAufwertungVerzicht.class,
    TCBezeichnungFstrAneinander.class,
    TCMassgebendeNeigung.class,
    TCFstrV.class,
    TCFBedienung.class,
    TCElementFlankenschutz.class,
    TCAufloesungVerzoegerung.class,
    TCElementVerschluss.class,
    TCBezeichnungFstrDWeg.class,
    TCDWegReihenfolge.class,
    TCLaengeSoll.class,
    TCBezeichnungMarkanterPunkt.class,
    TCFstrBedienstring.class,
    TCFstrReihenfolge.class,
    TCFstrVHg.class,
    TCFstrArt.class,
    TCFlaWLage.class,
    TCFlaRaumFreimeldung.class,
    TCZwieschutzArt.class,
    TCFlaVerzicht.class,
    TCNachlaufverhinderung.class,
    TCFahrtUeber.class,
    TCMassnahme.class,
    TCFlaSignalZielsperrung.class,
    TCGKX.class,
    TCUeberhoehungHoehe.class,
    TCGKY.class,
    TCGKZ.class,
    TCGEOForm.class,
    TCUeberhoehungDatum.class,
    TCGEOPAD.class,
    TCOertlichkeitKurzname.class,
    TCTOPAnschlussA.class,
    modell.geodaten._1_8.TCGeschwindigkeit.class,
    TCTOPAnschlussB.class,
    TCArtBesonders.class,
    TCTPArt.class,
    TCTPBeschreibung.class,
    TCHoehenpunktHoehe.class,
    TCKnotenname.class,
    TCHoehenpunktDatum.class,
    TCBezeichnungStrecke.class,
    TCTOPLaenge.class,
    TCGEORadiusA.class,
    TCGEORadiusB.class,
    TCGEOLaenge.class,
    TCTBBeschreibung.class,
    modell.geodaten._1_8.TCWirkrichtung.class,
    TCOertlichkeitGueltigAb.class,
    TCOertlichkeitAbkuerzung.class,
    TCOertlichkeitLangname.class,
    TCPlanQuelle.class,
    TCOertlichkeitGueltigBis.class,
    TCTBArt.class,
    TCVProfilArt.class,
    TCGEOKoordinatenSystemSonstige.class,
    TCGEOKoordinatenSystemLSys.class,
    TCHSystem.class,
    TCStreckeMeter.class,
    TCGEORichtungswinkel.class,
    TCOertlichkeitArt.class,
    TCGleisart.class,
    TCLichtraumprofil.class,
    modell.gleis._1_8.TCGeschwindigkeit.class,
    TCNutzungReisezug.class,
    TCFesteFahrbahn.class,
    TCFahrstrom.class,
    TCBaubereichArt.class,
    TCNutzungSBahn.class,
    TCNutzungGueterzug.class,
    TCNutzungRangier.class,
    TCGleisAbschlussArt.class,
    TCTasteANF.class,
    TCFAFAE.class,
    TCTasteWGT.class,
    TCNBGrenzeArt.class,
    TCWUS.class,
    TCRang.class,
    TCNBBezeichnung.class,
    TCNBRueckgabevoraussetzung.class,
    TCSBUE.class,
    TCSLESLS.class,
    TCWHU.class,
    TCNBArt.class,
    TCReihenfolgezwangZuAbschalt.class,
    TCAWU.class,
    TCFreieStellbarkeit.class,
    TCNBZoneBezeichnung.class,
    TCNBUnterstellungsverhaeltnis.class,
    TCFSTZ.class,
    TCTasteFGT.class,
    TCFMAAnschlussBezeichnung.class,
    TCBettungswiderstand.class,
    TCFMAKomponenteArt.class,
    TCFMAElementSeiltyp.class,
    TCFMAKaskadeBezeichnung.class,
    TCZugeinwirkungTyp.class,
    TCFMAKaskadeEinzelauswertung.class,
    TCUebertragungFMinfoRichtung.class,
    TCBezeichnungKennbuchstabe.class,
    TCFMAAnschlussSpeiserichtung.class,
    TCSchaltmittelFunktion.class,
    TCFMALaenge.class,
    TCFMAKomponenteSchienenprofil.class,
    TCFMALaengeE3 .class,
    TCFMALaengeE2 .class,
    TCFMALaengeE1 .class,
    TCFMALaengeS.class,
    TCFMAElementArt.class,
    TCZugeinwirkungArt.class,
    TCFMAKomponenteStromversorgung.class,
    TCFMATyp.class,
    TCFMAHilffreimeldung.class,
    TCFMAKomponenteTyp.class,
    TCUebertragungFMinfoTyp.class,
    TCFMALaengeBeeinflusst.class,
    TCFMAArt.class,
    TCFMAElementSeilanzahl.class,
    TCProjektNummer.class,
    TCDatumUebernahme.class,
    TCBauabschnitt.class,
    TCDatum.class,
    TCPlanungPhase.class,
    TCName5 .class,
    TCIdentRolle.class,
    TCBezeichnungPlanungGruppe.class,
    TCPolygonzugBetrachtungsbereich.class,
    TCReferenzVergleichBesonders.class,
    modell.planpro._1_8.TCStreckeKm.class,
    TCWerkzeugVersion.class,
    TCStreckeNummer.class,
    TCName.class,
    TCErzeugungZeitstempel.class,
    TCKoordinatensystemBB.class,
    TCBauzustandKurzbezeichnung.class,
    TCVergleichstypBesonders.class,
    TCBezeichnungAnlage.class,
    TCKoordinatensystemPB.class,
    TCLaufendeNummerAusgabe.class,
    TCWerkzeugName.class,
    TCStreckeAbschnitt.class,
    TCVerantwortlicheStelleDB.class,
    TCName10 .class,
    TCBezeichnungUnteranlage.class,
    TCDatumAbschlussGruppe.class,
    TCBezeichnungPlanungProjekt.class,
    TCPlanungEArt.class,
    TCInformativ.class,
    TCDatumRegelwerksstand.class,
    TCDatumAbschlussProjekt.class,
    TCIndexAusgabe.class,
    TCFuehrendeOertlichkeit.class,
    TCPlanProXSDVersion.class,
    TCReferenzPlanungBasis.class,
    TCPolygonzugPlanungsbereich.class,
    TCVergleichAusgabestandBasis.class,
    TCPlanungGArtBesonders.class,
    TCBauphase.class,
    TCDatumAbschlussEinzel.class,
    TCAkustikdauerAnbAnn.class,
    TCUnterstationMax.class,
    TCBedienbarkeitAnzeigefeld.class,
    TCSichtbarkeitAnzeigefeld.class,
    TCBfNrANB.class,
    TCBfNr.class,
    TCZNABezeichner.class,
    TCUnterstationNr.class,
    TCKoppelunterstation.class,
    TCBfKennung.class,
    TCZugvorbereitungsmeldung.class,
    TCVerzoegerungManuellLoeschung.class,
    TCPrioritaet.class,
    TCAkustikdauerVoranz.class,
    TCEinwahlstelle.class,
    TCFunktionalitaetAnzeigefeld.class,
    TCAusfahrdruckGegengleis.class,
    TCTelegrammwiederholung.class,
    TCTelegramm84Verzicht.class,
    TCZNSchaltkriterium.class,
    TCZBSSchnittstelle.class,
    TCZNModem.class,
    TCReaktivierungsfunktion.class,
    TCZBSAnbindung.class,
    TCTelegramm85FuerAlleFstr.class,
    TCDurchfahrdruck.class,
    TCTelegramm21 .class,
    TCAnschlussnummer.class,
    TCZBSAdresse.class,
    TCBesonderesSchaltkriterium.class,
    TCVormeldestart.class,
    TCZNABedienbezeichnerFrei.class,
    TCEinfahrdruckGegengleis.class,
    TCTelegramm30 .class,
    TCAusfahrdruck.class,
    TCTelegramm10 .class,
    TCZLVBusNr.class,
    TCBfNrZNA.class,
    TCIPAdresse.class,
    TCAkustikdauerSonst.class,
    TCEinfahrdruck.class,
    TCTelegramm03 .class,
    TCTelegramm02 .class,
    TCTelegramm04 .class,
    TCMeldedruck.class,
    TCTelegramm84FuerAlleFstr.class,
    TCZNFeldOhneAnzeige.class,
    TCZNAnzeigefeldLoeschkriterium.class,
    TCZNAnlagentyp.class,
    TCHOA.class,
    TCFUEMAuswertung.class,
    TCAnnaeherungsgeschwindigkeit.class,
    TCLenkabbruchzeit.class,
    TCVmaxAnnaeherung.class,
    TCEinstellkontrollzeit.class,
    TCPersonalReaktionszeit.class,
    TCLenkziffernstellen.class,
    TCAnzahlWiederholZLAnstoesse.class,
    TCSichtzeitVorsignal.class,
    TCDeadlockpruefung.class,
    TCSignalgruppeBezeichner.class,
    TCTvGK.class,
    TCZLFstrZuschlag.class,
    TCZNStellen.class,
    TCGKZSS.class,
    TCDWegPrio.class,
    TCGK.class,
    TCWeicheVorzugslage.class,
    TCWKrArt.class,
    TCVorzugslageAutomatik.class,
    TCAuffahrortung.class,
    TCKreuzungsgleis.class,
    TCElementLage.class,
    TCHerzstueckAntriebe.class,
    TCWeichensignal.class,
    TCWeicheBetriebsart.class,
    TCZungenpruefkontaktAnzahl.class,
    TCGeschwindigkeitR.class,
    TCAuswurfrichtung.class,
    TCGleissperrensignal.class,
    TCGeschwindigkeitL.class,
    TCIsolierfall.class,
    TCGleissperreBetriebsart.class,
    TCGleissperreVorzugslage.class,
    TCWKrGspStellart.class,
    TCRadiusL.class,
    TCWKrGrundform.class,
    TCElektrischerAntriebAnzahl.class,
    TCSchutzschiene.class,
    TCRadiusR.class,
    TCSignalsichtMindest.class,
    TCDurchfahrt.class,
    TCStreuscheibeArt.class,
    TCSignalsichtErreichbar.class,
    TCDAManuell.class,
    TCGeschaltet.class,
    TCRichtpunktentfernung.class,
    TCTunnelsignal.class,
    TCSignalsystem.class,
    TCSignalBefestigungsart.class,
    TCGegengleis.class,
    TCBeleuchtet.class,
    TCStreuscheibeBetriebsstellung.class,
    TCSonstigeZulaessigeAnordnung.class,
    TCRichtpunkt.class,
    TCSignalArt.class,
    TCPZBSchutzstreckeSoll.class,
    TCBefestigungArt.class,
    TCRahmenArt.class,
    TCDunkelschaltung.class,
    TCObereLichtpunkthoehe.class,
    TCSignalsichtSoll.class,
    TCHoeheFundamentoberkante.class,
    TCRangierstrasseRestaufloesung.class,
    TCAnschaltdauer.class,
    TCAutoEinstellung.class,
    TCFiktivesSignalFunktion.class,
    TCSignalFunktion.class,
    TCBedienart.class,
    TCGspLage.class,
    TCSchluesselGruppe.class,
    TCBezeichnungSchluessel.class,
    TCBedienungArt.class,
    TCWAnbaulage.class,
    TCBezeichnungSk.class,
    TCSchluesselInGrdstEingeschl.class,
    TCHauptschloss.class,
    TCBUELage.class,
    TCWLage.class,
    TCSchlossArt.class,
    TCSchluesselBartform.class,
    TCUntertitel.class,
    TCTitel.class,
    TCBild.class,
    TCRZParameterWert.class,
    TCRZNummer.class,
    TCRZParameterName.class,
    TCGUEAbstandAbweichend.class,
    TCGUEWirkmagnetAmSignal.class,
    TCGUEAnordnung.class,
    TCGUEEnergieversorgung.class,
    TCPZBArt.class,
    TCWirksamkeit.class,
    TCPZBINA.class,
    TCPZBAbstandGM.class,
    TCGUEMessstrecke.class,
    TCPruefgeschwindigkeit.class
})
public abstract class CBasisAttribut {

    @XmlElement(name = "ID_Bearbeitungsvermerk")
    protected List<TCIDBearbeitungsvermerk> idBearbeitungsvermerk;

    /**
     * Gets the value of the idBearbeitungsvermerk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idBearbeitungsvermerk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDBearbeitungsvermerk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCIDBearbeitungsvermerk }
     * 
     * 
     */
    public List<TCIDBearbeitungsvermerk> getIDBearbeitungsvermerk() {
        if (idBearbeitungsvermerk == null) {
            idBearbeitungsvermerk = new ArrayList<TCIDBearbeitungsvermerk>();
        }
        return this.idBearbeitungsvermerk;
    }

}