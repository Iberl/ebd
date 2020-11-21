//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basistypen._1_9_0;

import plan_pro.modell.ansteuerung_element._1_9_0.*;
import plan_pro.modell.bahnsteig._1_9_0.*;
import plan_pro.modell.bahnuebergang._1_9_0.*;
import plan_pro.modell.balisentechnik_etcs._1_9_0.*;
import plan_pro.modell.basisobjekte._1_9_0.*;
import plan_pro.modell.bedienung._1_9_0.*;
import plan_pro.modell.block._1_9_0.*;
import plan_pro.modell.fahrstrasse._1_9_0.*;
import plan_pro.modell.flankenschutz._1_9_0.*;
import plan_pro.modell.geodaten._1_9_0.*;
import plan_pro.modell.gleis._1_9_0.*;
import plan_pro.modell.medien_und_trassen._1_9_0.*;
import plan_pro.modell.nahbedienbereich._1_9_0.*;
import plan_pro.modell.ortung._1_9_0.*;
import plan_pro.modell.planpro._1_9_0.*;
import plan_pro.modell.pzb._1_9_0.*;
import plan_pro.modell.regelzeichnung._1_9_0.*;
import plan_pro.modell.schluesselabhaengigkeiten._1_9_0.*;
import plan_pro.modell.signale._1_9_0.*;
import plan_pro.modell.verweise._1_9_0.TCIDBearbeitungsvermerk;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.*;
import plan_pro.modell.zuglenkung._1_9_0.*;
import plan_pro.modell.zugnummernmeldeanlage._1_9_0.*;

import jakarta.xml.bind.annotation.*;
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
 *         &lt;element name="ID_Bearbeitungsvermerk" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bearbeitungsvermerk" maxOccurs="unbounded" minOccurs="0"/>
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
    TCStandortBeschreibung.class,
    plan_pro.modell.ansteuerung_element._1_9_0.TCIPAdressblockGrauV6 .class,
    TCBauart.class,
    plan_pro.modell.ansteuerung_element._1_9_0.TCIPAdressblockGrauV4 .class,
    TCTechnikBeschreibung.class,
    TCAussenelementansteuerungArt.class,
    TCBezeichnungESTWZE.class,
    TCEnergieversorgungArtErsatz.class,
    TCMediumArt.class,
    TCUnterbringungBefestigung.class,
    TCBezeichnungAEA.class,
    plan_pro.modell.ansteuerung_element._1_9_0.TCIPAdressblockBlauV4 .class,
    TCBandbreite.class,
    plan_pro.modell.ansteuerung_element._1_9_0.TCIPAdressblockGrau.class,
    TCTechnikArt.class,
    plan_pro.modell.ansteuerung_element._1_9_0.TCIPAdressblockBlauV6 .class,
    TCEnergieversorgungArt.class,
    TCNetzArt.class,
    plan_pro.modell.ansteuerung_element._1_9_0.TCHersteller.class,
    TCBezeichnungTSO.class,
    plan_pro.modell.ansteuerung_element._1_9_0.TCRegionalbereich.class,
    TCUnterbringungArt.class,
    plan_pro.modell.ansteuerung_element._1_9_0.TCIPAdressblockBlau.class,
    TCGFKKategorie.class,
    TCTSOTeilsystemArt.class,
    TCUebertragungswegArt.class,
    TCBezeichnungLageplanKurz.class,
    TCBezeichnungTabelle.class,
    TCPruefsumme.class,
    TCZeiger.class,
    TCBezeichnungLageplanLang.class,
    TCBezeichnungAussenanlage.class,
    TCOertlicherElementname.class,
    TCDatumAuslieferung.class,
    plan_pro.modell.basistypen._1_9_0.TCKennzahl.class,
    TCPruefsummeArt.class,
    TCVersionAuslieferung.class,
    TCBeschreibung.class,
    TCLSTObjektArt.class,
    TCAnhangArt.class,
    TCBearbeitungsvermerkRolle.class,
    TCRichtungsbezug.class,
    TCKommentar.class,
    TCDBGDIReferenz.class,
    TCLOAusgabestand.class,
    plan_pro.modell.basisobjekte._1_9_0.TCDaten.class,
    TCIdentitaet.class,
    TCBearbeitungsvermerkKennung.class,
    TCDatumRegelwerk.class,
    plan_pro.modell.basisobjekte._1_9_0.TCStreckeKm.class,
    TCSeitlicheLage.class,
    TCZeitBearbeitungsvermerk.class,
    TCSeitlicherAbstand.class,
    TCLODBFreigabe.class,
    plan_pro.modell.basisobjekte._1_9_0.TCDateiname.class,
    TCBestandsrelevanz.class,
    TCBestandsschutz.class,
    TCKurztext.class,
    TCLOSeriennummer.class,
    TCLODatumHerstellung.class,
    plan_pro.modell.basisobjekte._1_9_0.TCWirkrichtung.class,
    TCObjektzustandBesonders.class,
    TCLOFirmensachnummer.class,
    TCBegrenzungB.class,
    TCBegrenzungA.class,
    TCLOEMANr.class,
    TCTechnischerPlatz.class,
    TCLOErsatz.class,
    TCAbstand.class,
    TCDateityp.class,
    TCHauptzugang.class,
    TCLageZumGleis.class,
    TCBahnsteigZugangArt.class,
    TCBezeichnungBahnsteigKante.class,
    TCBezeichnungBahnsteigAnlage.class,
    TCSystemhoehe.class,
    TCErsatzsteckerGleisbezogen.class,
    TCPixelKoordinateY.class,
    TCPixelKoordinateX.class,
    TCSperrstrecke.class,
    TCVMinSchiene.class,
    TCLieferlaenge.class,
    TCFussRadwegSeite.class,
    TCGFRNeigung.class,
    TCTeilsperrstrecke.class,
    TCAkustikFussgaenger.class,
    TCBezeichnungVerkehrszeichen.class,
    TCGFRTyp.class,
    TCSperrlaenge.class,
    TCAutoHet.class,
    plan_pro.modell.bahnuebergang._1_9_0.TCHersteller.class,
    TCGFRArt.class,
    TCSchaltgruppe.class,
    TCRaeumstreckeDSKStrich.class,
    TCPegel.class,
    TCStoerhaltMerkhinweis.class,
    TCBUETechnik.class,
    TCOptikSymbolmaske.class,
    TCSperrstreckeFussgaenger.class,
    TCBUESicherungszeit.class,
    TCRichtungspfeil.class,
    TCSicherheitsabstand.class,
    TCMontageAusgleichsgewichte.class,
    TCFahrbahnBefestigungGleis.class,
    TCBezeichnungBUEGFREckpunkt.class,
    TCAusrichtungWinkel.class,
    TCBUEFunktionsueberwachung.class,
    TCOptikDurchmesser.class,
    TCFueSchaltfall.class,
    TCRaeumstreckeDCK.class,
    plan_pro.modell.bahnuebergang._1_9_0.TCAusrichtung.class,
    TCSchutzbuegel.class,
    TCRaeumstrecke.class,
    TCVorgeschaltet.class,
    TCTeilvorgabezeit.class,
    TCZeitueberschreitungsmeldung.class,
    TCLagerungArt.class,
    TCRaeumstreckeDBK.class,
    TCZusatzschild.class,
    TCHpErsatzstecker.class,
    TCLFUEImpuls.class,
    TCGleisAmBue.class,
    TCRaeumstreckeDAB.class,
    TCEinschaltverzErrechnet.class,
    TCMontageBesonders.class,
    TCBUEStrasse.class,
    TCEinschaltverzGewaehlt.class,
    TCKurzzugschaltung.class,
    TCTragkopfVerstellbar.class,
    TCStoerhaltHaltfall.class,
    TCFussRadwegArt.class,
    TCSignalverzErrechnet.class,
    TCBezSchrankenantrieb.class,
    TCFahrbahnBreite.class,
    TCFahrbahnBefestigung.class,
    TCBUEVorlaufzeit.class,
    TCMontagehoehe.class,
    TCVMaxStrasse.class,
    TCBaumprofil.class,
    TCBlitzpfeil.class,
    TCBezeichnungGFRElement.class,
    TCBUEBuestra.class,
    TCBUEHandschalteinrichtung.class,
    TCKontrastblende.class,
    TCWinkelAlpha.class,
    TCBUESicherungsart.class,
    TCKreuzungswinkel.class,
    TCBUENeigung.class,
    TCKlassifizierung.class,
    TCAbstandGehwegFahrbahn.class,
    TCBUEMitGFR.class,
    TCBezeichnungGFRTripelspiegel.class,
    TCSignalverzGewaehlt.class,
    TCGitterbehang.class,
    TCBaulast.class,
    TCVMinFussweg.class,
    TCVMaxSchiene.class,
    TCBeeinflussungStrassenverkehr.class,
    TCBUEBauart.class,
    TCBUENachlaufzeit.class,
    TCVMinStrasse.class,
    TCTBVTunnelsignal.class,
    TCLinkDistanz.class,
    TCETCSKennung.class,
    TCDateitypBinaerdatei.class,
    TCDatenpunktLaenge.class,
    TCNIDC.class,
    TCFTZBSTyp.class,
    TCPositionSonstige.class,
    TCMetallteil.class,
    TCWirksam.class,
    plan_pro.modell.balisentechnik_etcs._1_9_0.TCPrioritaet.class,
    TCNIDSTM.class,
    TCSRSVersion.class,
    TCZBSLaBereichLaenge.class,
    TCVerbotWBArt.class,
    TCDPTypGNT.class,
    TCDeltaVZES.class,
    TCEinstiegErlaubt.class,
    plan_pro.modell.balisentechnik_etcs._1_9_0.TCNeigung.class,
    TCTextBedingung.class,
    TCVGR2 .class,
    TCVGR1 .class,
    TCOberstrombegrenzungGueterzug.class,
    plan_pro.modell.balisentechnik_etcs._1_9_0.TCDaten.class,
    TCAnzahlVollLEUKalkuliert.class,
    TCETCSAdresseKennung.class,
    TCETCSParErlaeuterung.class,
    TCESGIndErlaeuterung.class,
    TCSonstigeStandortangabe.class,
    plan_pro.modell.balisentechnik_etcs._1_9_0.TCWLage.class,
    TCKmBTS3 .class,
    TCKmBTS2 .class,
    TCKmBTS1 .class,
    TCSystemVorGrenze.class,
    TCLaenge1 .class,
    TCLMG.class,
    TCZBSLaBereichGeschwindigkeit.class,
    plan_pro.modell.balisentechnik_etcs._1_9_0.TCAusrichtung.class,
    TCDWegIntervall50 .class,
    TCRBCSRSVersion.class,
    TCMaxLeistung.class,
    TCBedingungWeichenlage.class,
    TCWAnschluss.class,
    TCLfdNrInTelegrSpec.class,
    TCEinzeldateiArt.class,
    TCMastschild.class,
    TCUeberbrueckungEVUnterbrechung.class,
    TCUntergruppenID.class,
    TCEVModulArt.class,
    TCEinstiegOhneRueckwSig.class,
    TCDPTypTrans.class,
    TCDPTypVLa.class,
    TCArtBedingung.class,
    TCBezZUBBereichsgrenze.class,
    TCLLA.class,
    TCVZ.class,
    TCZBSLaBereichDistanz.class,
    TCRekursion2Nr.class,
    TCTBVMeldepunkt.class,
    TCFTGNTPunktart.class,
    TCETCSPaketnummer.class,
    TCDWegIntervall50200 .class,
    TCLEUModulTyp.class,
    TCETCSAdresseNIDBG.class,
    TCLEUModulArt.class,
    TCVerwendung.class,
    TCEnergieEingangArt.class,
    TCSchutzstreckeErforderlich.class,
    TCOberstrombegrenzungReisezug.class,
    TCESGIndParameter.class,
    plan_pro.modell.balisentechnik_etcs._1_9_0.TCBremsweg.class,
    TCAnwendungSonst.class,
    TCDLEVELTR.class,
    TCFTETCSL2Typ.class,
    TCAusstiegETCSSperre.class,
    TCTBVTunnelbereichLaenge.class,
    TCBezeichnungLEUAnlage.class,
    TCHinweisBalisenbefestigung.class,
    TCBezeichnungZUBSE.class,
    TCLaengeAusfuehrungsbereich.class,
    TCDPTypETCS.class,
    TCRBCSRSUnterversion.class,
    TCDeltaVGES.class,
    TCSTZ.class,
    TCVerwendungAlsRueckfall.class,
    TCDPTypSonst.class,
    TCSchutzstreckeVorhanden.class,
    TCMassgebendeNeig1 .class,
    TCETCSWOrtsgestellt.class,
    TCVerbotAnhalten.class,
    TCDunkelschaltanstoss.class,
    TCETCSParametername.class,
    TCESGIndParameterwert.class,
    TCIstBefahren.class,
    TCSRSUnterversion.class,
    TCKonfigurationskennung.class,
    TCZLA.class,
    TCVFrei.class,
    TCNennleistung.class,
    TCVGR.class,
    TCIndividuell.class,
    TCVBefehlR.class,
    plan_pro.modell.balisentechnik_etcs._1_9_0.TCHersteller.class,
    TCVBefehlZ.class,
    TCNIDRBC.class,
    TCStandortangabeBalisenschild.class,
    TCEingangGepuffert.class,
    TCAnwendungssystem.class,
    TCBaselineSRS.class,
    TCWirkrichtungInDatenpunkt.class,
    TCGruppenID.class,
    TCMassgebendeNeigSchutzstrecke.class,
    TCSystemVorGrenzeBesonders.class,
    TCDPTypArt.class,
    TCLEUAusgangNr.class,
    TCDPTypZBS.class,
    TCBezeichnungETCSKante.class,
    plan_pro.modell.balisentechnik_etcs._1_9_0.TCDateiname.class,
    TCFTESGTyp.class,
    TCPosition.class,
    TCLfdNrAmBezugspunkt.class,
    TCSpannungArt.class,
    TCSpannungToleranzObere.class,
    TCHarterAusstiegAusL2 .class,
    TCEVModulTyp.class,
    TCAnordnungImDP.class,
    TCRufnummer.class,
    TCVerbotRegenerativeBremse.class,
    TCBezeichnungZUB.class,
    TCETCSParameterwert.class,
    TCTelegrammnummer.class,
    TCNummerSchaltkasten.class,
    TCAnzeigetext.class,
    TCFTESGSubtyp.class,
    TCFTHinweisFunktion.class,
    TCDeltaVLES.class,
    TCLACKLEVELTR.class,
    TCMLEVELTR.class,
    TCUmfahrstrasse.class,
    TCDatenpunktBeschreibung.class,
    TCPrimaerquelle.class,
    TCAusgangNr.class,
    TCSpannungToleranzUntere.class,
    TCZielDPAusrichtung.class,
    TCAbstandGrenzeBereichC.class,
    TCPortNrAusgPhysisch.class,
    TCDPTypESG.class,
    TCDWegIntervall200 .class,
    TCDPLinkArt.class,
    TCLEUSchaltkastenTyp.class,
    TCZBSReaktion.class,
    TCETCSAdresseNIDC.class,
    TCZBSLaBereichNeigung.class,
    TCMaxUnterbrechungszeit.class,
    TCFabrikat.class,
    TCVZulStrecke.class,
    TCRekursionNr.class,
    TCSBE.class,
    TCZielIstFahrwegende.class,
    TCBezStreckeBTS2 .class,
    TCBezStreckeBTS1 .class,
    TCModulnummer.class,
    TCVLA.class,
    TCBezStreckeBTS3 .class,
    TCDPBezugBetrieblichArt.class,
    TCETCSKnotenArtSonstige.class,
    TCAnlagenteilSonstige.class,
    plan_pro.modell.bedienung._1_9_0.TCIPAdressblockGrauV6 .class,
    plan_pro.modell.bedienung._1_9_0.TCIPAdressblockGrauV4 .class,
    TCSteuerbezirksnummer.class,
    TCVorschauzeit.class,
    TCBezBedAnzeigeElement.class,
    TCBezBedZentrale.class,
    TCDDWert.class,
    TCBedienEinrichtOertlBez.class,
    TCMelder.class,
    plan_pro.modell.bedienung._1_9_0.TCIPAdressblockGrau.class,
    TCBedienplatznummer.class,
    plan_pro.modell.bedienung._1_9_0.TCHersteller.class,
    plan_pro.modell.bedienung._1_9_0.TCKennzahl.class,
    TCBSOTeilsystemArt.class,
    TCYWert.class,
    TCAnbindungIB3 .class,
    TCSteuerbezirksname.class,
    TCAWert.class,
    plan_pro.modell.bedienung._1_9_0.TCRegionalbereich.class,
    TCHupeAnschaltzeit.class,
    TCBedienplatzbezeichnung.class,
    TCAnbindungIB2 .class,
    TCBedienraumnummer.class,
    TCBedienPlatzArt.class,
    TCBetriebsstellenbezeichner.class,
    TCSchalter.class,
    TCCWert.class,
    TCYYWert.class,
    TCBWert.class,
    TCTaste.class,
    TCOberflaecheBildart.class,
    plan_pro.modell.bedienung._1_9_0.TCIPAdressblockBlauV4 .class,
    TCXWert.class,
    TCOberflaecheZustaendigkeit.class,
    plan_pro.modell.bedienung._1_9_0.TCIPAdressblockBlauV6 .class,
    TCBezeichnungBSO.class,
    TCBedienEinrichtBauart.class,
    TCSchrankreihe.class,
    TCBezBedAnrueckabschnitt.class,
    plan_pro.modell.bedienung._1_9_0.TCIPAdressblockBlau.class,
    TCRueckschauzeit.class,
    TCRueckblockwecker.class,
    TCVorblockwecker.class,
    TCSchutzuebertrager.class,
    TCErlaubnisabgabespeicherung.class,
    TCBlockBauform.class,
    TCErlaubnisStaendigVorhanden.class,
    TCBetriebsfuehrung.class,
    plan_pro.modell.block._1_9_0.TCBremsweg.class,
    TCZugbeeinflussungArt.class,
    TCStreckeArt.class,
    TCAutoErlaubnisholen.class,
    TCSchaltung.class,
    TCTraktionArt.class,
    TCErlaubnisholen.class,
    TCEntwurfsgeschwindigkeit.class,
    TCAutoErlaubnisruecklauf.class,
    TCZusatzinformation.class,
    TCFstrDWegWKr.class,
    TCRangierGegenfahrtausschluss.class,
    TCDWegV.class,
    TCAutomatischeEinstellung.class,
    TCDWegVorzug.class,
    TCFstrBildezeit.class,
    TCFstrMittelVAufwertung.class,
    TCAufloesungSspZielgeis.class,
    TCFstrVsigabstandVerkuerzt.class,
    TCDWegVAufwertungVerzicht.class,
    TCMassgebendeNeigung.class,
    TCFstrV.class,
    TCFBedienung.class,
    TCAufloesungVerzoegerung.class,
    TCElementVerschluss.class,
    TCBezeichnungFstrDWeg.class,
    TCDWegReihenfolge.class,
    TCLaengeSoll.class,
    TCBezeichnungMarkanterPunkt.class,
    TCFstrBedienstring.class,
    TCFstrReihenfolge.class,
    TCFstrVHg.class,
    TCFstrAneinanderBedienstring.class,
    TCFstrArt.class,
    TCFlaWLage.class,
    TCFlaRaumFreimeldung.class,
    TCZwieschutzArt.class,
    TCFlaVerzicht.class,
    TCNachlaufverhinderung.class,
    TCFahrtUeber.class,
    TCMassnahme.class,
    TCFlaSignalZielsperrung.class,
    TCUeberhoehungHoehe.class,
    TCGEOForm.class,
    TCUeberhoehungDatum.class,
    TCOertlichkeitKurzname.class,
    TCTOPAnschlussA.class,
    plan_pro.modell.geodaten._1_9_0.TCGeschwindigkeit.class,
    TCTOPAnschlussB.class,
    TCTPArt.class,
    TCHoehenpunktHoehe.class,
    TCHoehenpunktDatum.class,
    TCTOPLaenge.class,
    TCGEORadiusA.class,
    TCGEORadiusB.class,
    plan_pro.modell.geodaten._1_9_0.TCWirkrichtung.class,
    TCOertlichkeitGueltigAb.class,
    TCPlanQuelle.class,
    TCTBArt.class,
    TCHoehenlinieLaenge.class,
    TCGEOKoordinatenSystemSonstige.class,
    TCStreckeMeter.class,
    TCOertlichkeitArt.class,
    TCGKX.class,
    TCGKY.class,
    TCUeberhoehungslinieForm.class,
    TCGKZ.class,
    plan_pro.modell.geodaten._1_9_0.TCNeigung.class,
    TCGEOPAD.class,
    TCTPBeschreibung.class,
    TCKnotenname.class,
    TCBezeichnungStrecke.class,
    TCGEOLaenge.class,
    TCTBBeschreibung.class,
    TCOertlichkeitAbkuerzung.class,
    TCOertlichkeitLangname.class,
    TCHoehenlinieForm.class,
    TCOertlichkeitGueltigBis.class,
    TCVProfilArt.class,
    TCGEOKoordinatenSystemLSys.class,
    TCHSystem.class,
    TCUeberhoehungslinieLaenge.class,
    TCGEORichtungswinkel.class,
    TCKonstruktion.class,
    TCGleisart.class,
    TCLichtraumprofil.class,
    plan_pro.modell.gleis._1_9_0.TCGeschwindigkeit.class,
    TCNutzungReisezug.class,
    TCFahrstrom.class,
    TCBezGleisBezeichnung.class,
    TCBaubereichArt.class,
    TCNutzungSBahn.class,
    TCNutzungGueterzug.class,
    TCNutzungRangier.class,
    TCTrasseNutzer.class,
    TCAderDurchmesser.class,
    TCKabelTyp.class,
    TCVerseilart.class,
    TCTrasseKnotenArt.class,
    TCAderReserve.class,
    TCBezeichnungKabelVerteilpunkt.class,
    TCKabelLaenge.class,
    TCTrasseKanteArt.class,
    TCKabelArt.class,
    TCAnzahlVerseilelemente.class,
    TCAderQuerschnitt.class,
    TCKabelVerteilpunktArt.class,
    TCBezeichnungKabel.class,
    TCTasteANF.class,
    TCFAFAE.class,
    TCNBZoneAllg.class,
    TCTasteWGT.class,
    TCNBGrenzeArt.class,
    TCNBVerhaeltnisBesonders.class,
    TCWUS.class,
    TCRang.class,
    TCNBBezeichnung.class,
    TCNBRueckgabevoraussetzung.class,
    TCSBUE.class,
    TCSLESLS.class,
    TCWHU.class,
    TCNBArt.class,
    TCAWU.class,
    TCFreieStellbarkeit.class,
    TCNBZoneBezeichnung.class,
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
    TCFMAIsolierung.class,
    TCFMAKomponenteStromversorgung.class,
    TCFMATyp.class,
    TCFMAHilffreimeldung.class,
    TCFMAKomponenteTyp.class,
    TCUebertragungFMinfoTyp.class,
    TCFMALaengeBeeinflusst.class,
    TCFMAArt.class,
    TCFMAElementSeilanzahl.class,
    TCAdresseStrasseNr.class,
    TCDatumUebernahme.class,
    TCPlanungPhase.class,
    TCIdentRolle.class,
    TCBezeichnungPlanungGruppe.class,
    TCPolygonzugBetrachtungsbereich.class,
    TCNameAkteur.class,
    TCNameAkteur10 .class,
    plan_pro.modell.planpro._1_9_0.TCStreckeKm.class,
    TCStreckeNummer.class,
    TCBezeichnungAnlage.class,
    TCKoordinatensystemPB.class,
    TCAdressePLZOrt.class,
    TCLaufendeNummerAusgabe.class,
    TCStreckeAbschnitt.class,
    TCVerantwortlicheStelleDB.class,
    TCBezeichnungUnteranlage.class,
    TCBezeichnungPlanungProjekt.class,
    TCPlanungEArt.class,
    TCIndexAusgabe.class,
    TCFuehrendeOertlichkeit.class,
    TCPolygonzugPlanungsbereich.class,
    TCPlanungGArtBesonders.class,
    TCProjektNummer.class,
    TCBauabschnitt.class,
    TCDatum.class,
    TCReferenzVergleichBesonders.class,
    TCBemerkung.class,
    TCWerkzeugVersion.class,
    TCErzeugungZeitstempel.class,
    TCNameOrganisation.class,
    TCKoordinatensystemBB.class,
    TCTelefonnummer.class,
    TCBauzustandKurzbezeichnung.class,
    TCVergleichstypBesonders.class,
    TCWerkzeugName.class,
    TCBauzustandLangbezeichnung.class,
    TCDatumAbschlussGruppe.class,
    TCUntergewerkArt.class,
    TCInformativ.class,
    TCDatumRegelwerksstand.class,
    TCDatumAbschlussProjekt.class,
    TCPlanProXSDVersion.class,
    TCReferenzPlanungBasis.class,
    TCEMailAdresse.class,
    TCVergleichAusgabestandBasis.class,
    TCNameAkteur5 .class,
    TCOrganisationseinheit.class,
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
    plan_pro.modell.zugnummernmeldeanlage._1_9_0.TCPrioritaet.class,
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
    TCSignalsichtMindest.class,
    TCZs2Ueberwacht.class,
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
    TCBesetzteAusfahrt.class,
    TCSonstigeZulaessigeAnordnung.class,
    TCRichtpunkt.class,
    TCSignalArt.class,
    TCPZBSchutzstreckeSoll.class,
    TCBefestigungArt.class,
    TCGeltungsbereich.class,
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
    TCGspLage.class,
    TCBezeichnungSchloss.class,
    TCSchluesselGruppe.class,
    TCTechnischBerechtigter.class,
    TCBezeichnungSchluessel.class,
    TCBedienungArt.class,
    TCWAnbaulage.class,
    TCBezeichnungSk.class,
    TCSchluesselInGrdstEingeschl.class,
    TCHauptschloss.class,
    TCBeschreibungSonderanlage.class,
    TCBUELage.class,
    plan_pro.modell.schluesselabhaengigkeiten._1_9_0.TCWLage.class,
    TCSchlossArt.class,
    TCSchluesselBartform.class,
    TCVerschlussHerzstueck.class,
    TCUntertitel.class,
    TCTitel.class,
    TCBild.class,
    TCRZParameterWert.class,
    TCRZNummer.class,
    TCRZParameterName.class,
    TCGUEAbstandAbweichend.class,
    TCGUEAnordnung.class,
    TCGUEBauart.class,
    TCGUEEnergieversorgung.class,
    TCPZBArt.class,
    TCWirksamkeit.class,
    TCPZBINA.class,
    TCMessfehler.class,
    TCPruefzeit.class,
    TCPZBAbstandGM.class,
    TCGUEMessstrecke.class,
    TCPruefgeschwindigkeit.class,
    TCWeicheVorzugslage.class,
    TCWKrArt.class,
    TCVorzugslageAutomatik.class,
    TCAuffahrortung.class,
    TCElektrischerAntriebLage.class,
    TCKreuzungsgleis.class,
    TCElementLage.class,
    TCBesonderesFahrwegelement.class,
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
    TCWKrGrundform.class,
    TCElektrischerAntriebAnzahl.class,
    TCSchutzschiene.class,
    TCGleisAbschlussArt.class
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
