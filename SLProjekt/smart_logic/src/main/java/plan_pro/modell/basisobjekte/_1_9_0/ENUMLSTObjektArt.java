//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMLST_Objekt_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMLST_Objekt_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Anhang"/>
 *     &lt;enumeration value="Aussenelementansteuerung"/>
 *     &lt;enumeration value="Bahnsteig_Anlage"/>
 *     &lt;enumeration value="Bahnsteig_Dach"/>
 *     &lt;enumeration value="Bahnsteig_Kante"/>
 *     &lt;enumeration value="Bahnsteig_Zugang"/>
 *     &lt;enumeration value="Balise"/>
 *     &lt;enumeration value="Bearbeitungsvermerk"/>
 *     &lt;enumeration value="Bedien_Anrueckabschnitt"/>
 *     &lt;enumeration value="Bedien_Anzeige_Element"/>
 *     &lt;enumeration value="Bedien_Bezirk"/>
 *     &lt;enumeration value="Bedien_Einrichtung_Oertlich"/>
 *     &lt;enumeration value="Bedien_GBT"/>
 *     &lt;enumeration value="Bedien_Oberflaeche"/>
 *     &lt;enumeration value="Bedien_Oberflaeche_Bild"/>
 *     &lt;enumeration value="Bedien_Oertlichkeit"/>
 *     &lt;enumeration value="Bedien_Platz"/>
 *     &lt;enumeration value="Bedien_Standort"/>
 *     &lt;enumeration value="Bedien_Zentrale"/>
 *     &lt;enumeration value="Bereichsgrenze"/>
 *     &lt;enumeration value="Binaerdatei"/>
 *     &lt;enumeration value="Block_Anlage"/>
 *     &lt;enumeration value="Block_Element"/>
 *     &lt;enumeration value="Block_Strecke"/>
 *     &lt;enumeration value="BUE_Anlage"/>
 *     &lt;enumeration value="BUE_Anlage_Strasse"/>
 *     &lt;enumeration value="BUE_Anlage_V"/>
 *     &lt;enumeration value="BUE_Ausschaltung"/>
 *     &lt;enumeration value="BUE_Bedien_Anzeige_Element"/>
 *     &lt;enumeration value="BUE_Deckendes_Signal_Zuordnung"/>
 *     &lt;enumeration value="BUE_Einschaltung"/>
 *     &lt;enumeration value="BUE_Einschaltung_Zuordnung"/>
 *     &lt;enumeration value="BUE_Gefahrraum_Eckpunkt"/>
 *     &lt;enumeration value="BUE_Gleisbezogener_Gefahrraum"/>
 *     &lt;enumeration value="BUE_Kante"/>
 *     &lt;enumeration value="BUE_Kreuzungsplan"/>
 *     &lt;enumeration value="BUE_Schnittstelle"/>
 *     &lt;enumeration value="BUE_Spezifisches_Signal"/>
 *     &lt;enumeration value="BUE_WS_Fstr_Zuordnung"/>
 *     &lt;enumeration value="Datenpunkt"/>
 *     &lt;enumeration value="Datenpunkt_Link"/>
 *     &lt;enumeration value="ESTW_Zentraleinheit"/>
 *     &lt;enumeration value="ETCS_Kante"/>
 *     &lt;enumeration value="ETCS_Knoten"/>
 *     &lt;enumeration value="ETCS_Signal"/>
 *     &lt;enumeration value="ETCS_W_Kr"/>
 *     &lt;enumeration value="EV_Modul"/>
 *     &lt;enumeration value="Fachtelegramm"/>
 *     &lt;enumeration value="Fla_Freimelde_Zuordnung"/>
 *     &lt;enumeration value="Fla_Schutz"/>
 *     &lt;enumeration value="Fla_Zwieschutz"/>
 *     &lt;enumeration value="FMA_Anlage"/>
 *     &lt;enumeration value="FMA_Element"/>
 *     &lt;enumeration value="FMA_Komponente"/>
 *     &lt;enumeration value="Fstr_Abhaengigkeit"/>
 *     &lt;enumeration value="Fstr_Aneinander"/>
 *     &lt;enumeration value="Fstr_Aneinander_Zuordnung"/>
 *     &lt;enumeration value="Fstr_DWeg"/>
 *     &lt;enumeration value="Fstr_DWeg_W_Kr"/>
 *     &lt;enumeration value="Fstr_Fahrweg"/>
 *     &lt;enumeration value="Fstr_Nichthaltfall"/>
 *     &lt;enumeration value="Fstr_Rangier_Fla_Zuordnung"/>
 *     &lt;enumeration value="Fstr_Signalisierung"/>
 *     &lt;enumeration value="Fstr_Umfahrpunkt"/>
 *     &lt;enumeration value="Fstr_Zug_Rangier"/>
 *     &lt;enumeration value="FT_Anschaltbedingung"/>
 *     &lt;enumeration value="FT_Fahrweg_Teil"/>
 *     &lt;enumeration value="GEO_Kante"/>
 *     &lt;enumeration value="GEO_Knoten"/>
 *     &lt;enumeration value="GEO_Punkt"/>
 *     &lt;enumeration value="Geschwindigkeitsprofil"/>
 *     &lt;enumeration value="GFR_Anlage"/>
 *     &lt;enumeration value="GFR_Element"/>
 *     &lt;enumeration value="GFR_Tripelspiegel"/>
 *     &lt;enumeration value="Gleis_Abschluss"/>
 *     &lt;enumeration value="Gleis_Abschnitt"/>
 *     &lt;enumeration value="Gleis_Art"/>
 *     &lt;enumeration value="Gleis_Baubereich"/>
 *     &lt;enumeration value="Gleis_Bezeichnung"/>
 *     &lt;enumeration value="Gleis_Fahrbahn"/>
 *     &lt;enumeration value="Gleis_Lichtraum"/>
 *     &lt;enumeration value="Gleis_Schaltgruppe"/>
 *     &lt;enumeration value="Hoehenpunkt"/>
 *     &lt;enumeration value="Kabel"/>
 *     &lt;enumeration value="Kabel_Verteilpunkt"/>
 *     &lt;enumeration value="LEU_Anlage"/>
 *     &lt;enumeration value="LEU_Modul"/>
 *     &lt;enumeration value="LEU_Schaltkasten"/>
 *     &lt;enumeration value="Luft_Telegramm"/>
 *     &lt;enumeration value="Markanter_Punkt"/>
 *     &lt;enumeration value="NB"/>
 *     &lt;enumeration value="NB_Bedien_Anzeige_Element"/>
 *     &lt;enumeration value="NB_Zone"/>
 *     &lt;enumeration value="NB_Zone_Element"/>
 *     &lt;enumeration value="NB_Zone_Grenze"/>
 *     &lt;enumeration value="Oertlichkeit"/>
 *     &lt;enumeration value="Prog_Datei_Gruppe"/>
 *     &lt;enumeration value="PZB_Element"/>
 *     &lt;enumeration value="PZB_Element_Zuordnung"/>
 *     &lt;enumeration value="PZB_Zuordnung_Signal"/>
 *     &lt;enumeration value="RBC"/>
 *     &lt;enumeration value="Regelzeichnung"/>
 *     &lt;enumeration value="Regelzeichnung_Parameter"/>
 *     &lt;enumeration value="Schaltmittel_Fstr_Zuordnung"/>
 *     &lt;enumeration value="Schaltmittel_Zuordnung"/>
 *     &lt;enumeration value="Schloss"/>
 *     &lt;enumeration value="Schlosskombination"/>
 *     &lt;enumeration value="Schluessel"/>
 *     &lt;enumeration value="Schluesselsperre"/>
 *     &lt;enumeration value="Schrankenantrieb"/>
 *     &lt;enumeration value="Signal"/>
 *     &lt;enumeration value="Signal_Befestigung"/>
 *     &lt;enumeration value="Signal_Rahmen"/>
 *     &lt;enumeration value="Signal_Signalbegriff"/>
 *     &lt;enumeration value="Sonstiger_Punkt"/>
 *     &lt;enumeration value="Stell_Bereich"/>
 *     &lt;enumeration value="Stellelement"/>
 *     &lt;enumeration value="Strecke"/>
 *     &lt;enumeration value="Strecke_Punkt"/>
 *     &lt;enumeration value="Technik_Standort"/>
 *     &lt;enumeration value="Technischer_Bereich"/>
 *     &lt;enumeration value="Technischer_Punkt"/>
 *     &lt;enumeration value="TOP_Kante"/>
 *     &lt;enumeration value="TOP_Knoten"/>
 *     &lt;enumeration value="Ueberhoehung"/>
 *     &lt;enumeration value="Uebertragungsweg"/>
 *     &lt;enumeration value="Unterbringung"/>
 *     &lt;enumeration value="Verkehrszeichen"/>
 *     &lt;enumeration value="W_Kr_Anlage"/>
 *     &lt;enumeration value="W_Kr_Gsp_Element"/>
 *     &lt;enumeration value="W_Kr_Gsp_Komponente"/>
 *     &lt;enumeration value="Weichenlaufkette"/>
 *     &lt;enumeration value="Weichenlaufkette_Zuordnung"/>
 *     &lt;enumeration value="ZL"/>
 *     &lt;enumeration value="ZL_DLP_Abschnitt"/>
 *     &lt;enumeration value="ZL_DLP_Fstr"/>
 *     &lt;enumeration value="ZL_Fstr"/>
 *     &lt;enumeration value="ZL_Fstr_Anstoss"/>
 *     &lt;enumeration value="ZL_Signalgruppe"/>
 *     &lt;enumeration value="ZL_Signalgruppe_Zuordnung"/>
 *     &lt;enumeration value="ZLV_Bus"/>
 *     &lt;enumeration value="ZLV_Bus_US_Zuordnung"/>
 *     &lt;enumeration value="ZN"/>
 *     &lt;enumeration value="ZN_Akustik"/>
 *     &lt;enumeration value="ZN_Anzeigefeld"/>
 *     &lt;enumeration value="ZN_Fortschalt_Kriterium"/>
 *     &lt;enumeration value="ZN_Telegramm_84_Zuordnung"/>
 *     &lt;enumeration value="ZN_Telegramm_85_Zuordnung"/>
 *     &lt;enumeration value="ZN_Unterstation"/>
 *     &lt;enumeration value="ZN_ZBS"/>
 *     &lt;enumeration value="ZUB_Bereichsgrenze"/>
 *     &lt;enumeration value="ZUB_Streckeneigenschaft"/>
 *     &lt;enumeration value="Zugeinwirkung"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMLST_Objekt_Art")
@XmlEnum
public enum ENUMLSTObjektArt {

    @XmlEnumValue("Anhang")
    ANHANG("Anhang"),
    @XmlEnumValue("Aussenelementansteuerung")
    AUSSENELEMENTANSTEUERUNG("Aussenelementansteuerung"),
    @XmlEnumValue("Bahnsteig_Anlage")
    BAHNSTEIG_ANLAGE("Bahnsteig_Anlage"),
    @XmlEnumValue("Bahnsteig_Dach")
    BAHNSTEIG_DACH("Bahnsteig_Dach"),
    @XmlEnumValue("Bahnsteig_Kante")
    BAHNSTEIG_KANTE("Bahnsteig_Kante"),
    @XmlEnumValue("Bahnsteig_Zugang")
    BAHNSTEIG_ZUGANG("Bahnsteig_Zugang"),
    @XmlEnumValue("Balise")
    BALISE("Balise"),
    @XmlEnumValue("Bearbeitungsvermerk")
    BEARBEITUNGSVERMERK("Bearbeitungsvermerk"),
    @XmlEnumValue("Bedien_Anrueckabschnitt")
    BEDIEN_ANRUECKABSCHNITT("Bedien_Anrueckabschnitt"),
    @XmlEnumValue("Bedien_Anzeige_Element")
    BEDIEN_ANZEIGE_ELEMENT("Bedien_Anzeige_Element"),
    @XmlEnumValue("Bedien_Bezirk")
    BEDIEN_BEZIRK("Bedien_Bezirk"),
    @XmlEnumValue("Bedien_Einrichtung_Oertlich")
    BEDIEN_EINRICHTUNG_OERTLICH("Bedien_Einrichtung_Oertlich"),
    @XmlEnumValue("Bedien_GBT")
    BEDIEN_GBT("Bedien_GBT"),
    @XmlEnumValue("Bedien_Oberflaeche")
    BEDIEN_OBERFLAECHE("Bedien_Oberflaeche"),
    @XmlEnumValue("Bedien_Oberflaeche_Bild")
    BEDIEN_OBERFLAECHE_BILD("Bedien_Oberflaeche_Bild"),
    @XmlEnumValue("Bedien_Oertlichkeit")
    BEDIEN_OERTLICHKEIT("Bedien_Oertlichkeit"),
    @XmlEnumValue("Bedien_Platz")
    BEDIEN_PLATZ("Bedien_Platz"),
    @XmlEnumValue("Bedien_Standort")
    BEDIEN_STANDORT("Bedien_Standort"),
    @XmlEnumValue("Bedien_Zentrale")
    BEDIEN_ZENTRALE("Bedien_Zentrale"),
    @XmlEnumValue("Bereichsgrenze")
    BEREICHSGRENZE("Bereichsgrenze"),
    @XmlEnumValue("Binaerdatei")
    BINAERDATEI("Binaerdatei"),
    @XmlEnumValue("Block_Anlage")
    BLOCK_ANLAGE("Block_Anlage"),
    @XmlEnumValue("Block_Element")
    BLOCK_ELEMENT("Block_Element"),
    @XmlEnumValue("Block_Strecke")
    BLOCK_STRECKE("Block_Strecke"),
    @XmlEnumValue("BUE_Anlage")
    BUE_ANLAGE("BUE_Anlage"),
    @XmlEnumValue("BUE_Anlage_Strasse")
    BUE_ANLAGE_STRASSE("BUE_Anlage_Strasse"),
    @XmlEnumValue("BUE_Anlage_V")
    BUE_ANLAGE_V("BUE_Anlage_V"),
    @XmlEnumValue("BUE_Ausschaltung")
    BUE_AUSSCHALTUNG("BUE_Ausschaltung"),
    @XmlEnumValue("BUE_Bedien_Anzeige_Element")
    BUE_BEDIEN_ANZEIGE_ELEMENT("BUE_Bedien_Anzeige_Element"),
    @XmlEnumValue("BUE_Deckendes_Signal_Zuordnung")
    BUE_DECKENDES_SIGNAL_ZUORDNUNG("BUE_Deckendes_Signal_Zuordnung"),
    @XmlEnumValue("BUE_Einschaltung")
    BUE_EINSCHALTUNG("BUE_Einschaltung"),
    @XmlEnumValue("BUE_Einschaltung_Zuordnung")
    BUE_EINSCHALTUNG_ZUORDNUNG("BUE_Einschaltung_Zuordnung"),
    @XmlEnumValue("BUE_Gefahrraum_Eckpunkt")
    BUE_GEFAHRRAUM_ECKPUNKT("BUE_Gefahrraum_Eckpunkt"),
    @XmlEnumValue("BUE_Gleisbezogener_Gefahrraum")
    BUE_GLEISBEZOGENER_GEFAHRRAUM("BUE_Gleisbezogener_Gefahrraum"),
    @XmlEnumValue("BUE_Kante")
    BUE_KANTE("BUE_Kante"),
    @XmlEnumValue("BUE_Kreuzungsplan")
    BUE_KREUZUNGSPLAN("BUE_Kreuzungsplan"),
    @XmlEnumValue("BUE_Schnittstelle")
    BUE_SCHNITTSTELLE("BUE_Schnittstelle"),
    @XmlEnumValue("BUE_Spezifisches_Signal")
    BUE_SPEZIFISCHES_SIGNAL("BUE_Spezifisches_Signal"),
    @XmlEnumValue("BUE_WS_Fstr_Zuordnung")
    BUE_WS_FSTR_ZUORDNUNG("BUE_WS_Fstr_Zuordnung"),
    @XmlEnumValue("Datenpunkt")
    DATENPUNKT("Datenpunkt"),
    @XmlEnumValue("Datenpunkt_Link")
    DATENPUNKT_LINK("Datenpunkt_Link"),
    @XmlEnumValue("ESTW_Zentraleinheit")
    ESTW_ZENTRALEINHEIT("ESTW_Zentraleinheit"),
    @XmlEnumValue("ETCS_Kante")
    ETCS_KANTE("ETCS_Kante"),
    @XmlEnumValue("ETCS_Knoten")
    ETCS_KNOTEN("ETCS_Knoten"),
    @XmlEnumValue("ETCS_Signal")
    ETCS_SIGNAL("ETCS_Signal"),
    @XmlEnumValue("ETCS_W_Kr")
    ETCS_W_KR("ETCS_W_Kr"),
    @XmlEnumValue("EV_Modul")
    EV_MODUL("EV_Modul"),
    @XmlEnumValue("Fachtelegramm")
    FACHTELEGRAMM("Fachtelegramm"),
    @XmlEnumValue("Fla_Freimelde_Zuordnung")
    FLA_FREIMELDE_ZUORDNUNG("Fla_Freimelde_Zuordnung"),
    @XmlEnumValue("Fla_Schutz")
    FLA_SCHUTZ("Fla_Schutz"),
    @XmlEnumValue("Fla_Zwieschutz")
    FLA_ZWIESCHUTZ("Fla_Zwieschutz"),
    @XmlEnumValue("FMA_Anlage")
    FMA_ANLAGE("FMA_Anlage"),
    @XmlEnumValue("FMA_Element")
    FMA_ELEMENT("FMA_Element"),
    @XmlEnumValue("FMA_Komponente")
    FMA_KOMPONENTE("FMA_Komponente"),
    @XmlEnumValue("Fstr_Abhaengigkeit")
    FSTR_ABHAENGIGKEIT("Fstr_Abhaengigkeit"),
    @XmlEnumValue("Fstr_Aneinander")
    FSTR_ANEINANDER("Fstr_Aneinander"),
    @XmlEnumValue("Fstr_Aneinander_Zuordnung")
    FSTR_ANEINANDER_ZUORDNUNG("Fstr_Aneinander_Zuordnung"),
    @XmlEnumValue("Fstr_DWeg")
    FSTR_D_WEG("Fstr_DWeg"),
    @XmlEnumValue("Fstr_DWeg_W_Kr")
    FSTR_D_WEG_W_KR("Fstr_DWeg_W_Kr"),
    @XmlEnumValue("Fstr_Fahrweg")
    FSTR_FAHRWEG("Fstr_Fahrweg"),
    @XmlEnumValue("Fstr_Nichthaltfall")
    FSTR_NICHTHALTFALL("Fstr_Nichthaltfall"),
    @XmlEnumValue("Fstr_Rangier_Fla_Zuordnung")
    FSTR_RANGIER_FLA_ZUORDNUNG("Fstr_Rangier_Fla_Zuordnung"),
    @XmlEnumValue("Fstr_Signalisierung")
    FSTR_SIGNALISIERUNG("Fstr_Signalisierung"),
    @XmlEnumValue("Fstr_Umfahrpunkt")
    FSTR_UMFAHRPUNKT("Fstr_Umfahrpunkt"),
    @XmlEnumValue("Fstr_Zug_Rangier")
    FSTR_ZUG_RANGIER("Fstr_Zug_Rangier"),
    @XmlEnumValue("FT_Anschaltbedingung")
    FT_ANSCHALTBEDINGUNG("FT_Anschaltbedingung"),
    @XmlEnumValue("FT_Fahrweg_Teil")
    FT_FAHRWEG_TEIL("FT_Fahrweg_Teil"),
    @XmlEnumValue("GEO_Kante")
    GEO_KANTE("GEO_Kante"),
    @XmlEnumValue("GEO_Knoten")
    GEO_KNOTEN("GEO_Knoten"),
    @XmlEnumValue("GEO_Punkt")
    GEO_PUNKT("GEO_Punkt"),
    @XmlEnumValue("Geschwindigkeitsprofil")
    GESCHWINDIGKEITSPROFIL("Geschwindigkeitsprofil"),
    @XmlEnumValue("GFR_Anlage")
    GFR_ANLAGE("GFR_Anlage"),
    @XmlEnumValue("GFR_Element")
    GFR_ELEMENT("GFR_Element"),
    @XmlEnumValue("GFR_Tripelspiegel")
    GFR_TRIPELSPIEGEL("GFR_Tripelspiegel"),
    @XmlEnumValue("Gleis_Abschluss")
    GLEIS_ABSCHLUSS("Gleis_Abschluss"),
    @XmlEnumValue("Gleis_Abschnitt")
    GLEIS_ABSCHNITT("Gleis_Abschnitt"),
    @XmlEnumValue("Gleis_Art")
    GLEIS_ART("Gleis_Art"),
    @XmlEnumValue("Gleis_Baubereich")
    GLEIS_BAUBEREICH("Gleis_Baubereich"),
    @XmlEnumValue("Gleis_Bezeichnung")
    GLEIS_BEZEICHNUNG("Gleis_Bezeichnung"),
    @XmlEnumValue("Gleis_Fahrbahn")
    GLEIS_FAHRBAHN("Gleis_Fahrbahn"),
    @XmlEnumValue("Gleis_Lichtraum")
    GLEIS_LICHTRAUM("Gleis_Lichtraum"),
    @XmlEnumValue("Gleis_Schaltgruppe")
    GLEIS_SCHALTGRUPPE("Gleis_Schaltgruppe"),
    @XmlEnumValue("Hoehenpunkt")
    HOEHENPUNKT("Hoehenpunkt"),
    @XmlEnumValue("Kabel")
    KABEL("Kabel"),
    @XmlEnumValue("Kabel_Verteilpunkt")
    KABEL_VERTEILPUNKT("Kabel_Verteilpunkt"),
    @XmlEnumValue("LEU_Anlage")
    LEU_ANLAGE("LEU_Anlage"),
    @XmlEnumValue("LEU_Modul")
    LEU_MODUL("LEU_Modul"),
    @XmlEnumValue("LEU_Schaltkasten")
    LEU_SCHALTKASTEN("LEU_Schaltkasten"),
    @XmlEnumValue("Luft_Telegramm")
    LUFT_TELEGRAMM("Luft_Telegramm"),
    @XmlEnumValue("Markanter_Punkt")
    MARKANTER_PUNKT("Markanter_Punkt"),
    NB("NB"),
    @XmlEnumValue("NB_Bedien_Anzeige_Element")
    NB_BEDIEN_ANZEIGE_ELEMENT("NB_Bedien_Anzeige_Element"),
    @XmlEnumValue("NB_Zone")
    NB_ZONE("NB_Zone"),
    @XmlEnumValue("NB_Zone_Element")
    NB_ZONE_ELEMENT("NB_Zone_Element"),
    @XmlEnumValue("NB_Zone_Grenze")
    NB_ZONE_GRENZE("NB_Zone_Grenze"),
    @XmlEnumValue("Oertlichkeit")
    OERTLICHKEIT("Oertlichkeit"),
    @XmlEnumValue("Prog_Datei_Gruppe")
    PROG_DATEI_GRUPPE("Prog_Datei_Gruppe"),
    @XmlEnumValue("PZB_Element")
    PZB_ELEMENT("PZB_Element"),
    @XmlEnumValue("PZB_Element_Zuordnung")
    PZB_ELEMENT_ZUORDNUNG("PZB_Element_Zuordnung"),
    @XmlEnumValue("PZB_Zuordnung_Signal")
    PZB_ZUORDNUNG_SIGNAL("PZB_Zuordnung_Signal"),
    RBC("RBC"),
    @XmlEnumValue("Regelzeichnung")
    REGELZEICHNUNG("Regelzeichnung"),
    @XmlEnumValue("Regelzeichnung_Parameter")
    REGELZEICHNUNG_PARAMETER("Regelzeichnung_Parameter"),
    @XmlEnumValue("Schaltmittel_Fstr_Zuordnung")
    SCHALTMITTEL_FSTR_ZUORDNUNG("Schaltmittel_Fstr_Zuordnung"),
    @XmlEnumValue("Schaltmittel_Zuordnung")
    SCHALTMITTEL_ZUORDNUNG("Schaltmittel_Zuordnung"),
    @XmlEnumValue("Schloss")
    SCHLOSS("Schloss"),
    @XmlEnumValue("Schlosskombination")
    SCHLOSSKOMBINATION("Schlosskombination"),
    @XmlEnumValue("Schluessel")
    SCHLUESSEL("Schluessel"),
    @XmlEnumValue("Schluesselsperre")
    SCHLUESSELSPERRE("Schluesselsperre"),
    @XmlEnumValue("Schrankenantrieb")
    SCHRANKENANTRIEB("Schrankenantrieb"),
    @XmlEnumValue("Signal")
    SIGNAL("Signal"),
    @XmlEnumValue("Signal_Befestigung")
    SIGNAL_BEFESTIGUNG("Signal_Befestigung"),
    @XmlEnumValue("Signal_Rahmen")
    SIGNAL_RAHMEN("Signal_Rahmen"),
    @XmlEnumValue("Signal_Signalbegriff")
    SIGNAL_SIGNALBEGRIFF("Signal_Signalbegriff"),
    @XmlEnumValue("Sonstiger_Punkt")
    SONSTIGER_PUNKT("Sonstiger_Punkt"),
    @XmlEnumValue("Stell_Bereich")
    STELL_BEREICH("Stell_Bereich"),
    @XmlEnumValue("Stellelement")
    STELLELEMENT("Stellelement"),
    @XmlEnumValue("Strecke")
    STRECKE("Strecke"),
    @XmlEnumValue("Strecke_Punkt")
    STRECKE_PUNKT("Strecke_Punkt"),
    @XmlEnumValue("Technik_Standort")
    TECHNIK_STANDORT("Technik_Standort"),
    @XmlEnumValue("Technischer_Bereich")
    TECHNISCHER_BEREICH("Technischer_Bereich"),
    @XmlEnumValue("Technischer_Punkt")
    TECHNISCHER_PUNKT("Technischer_Punkt"),
    @XmlEnumValue("TOP_Kante")
    TOP_KANTE("TOP_Kante"),
    @XmlEnumValue("TOP_Knoten")
    TOP_KNOTEN("TOP_Knoten"),
    @XmlEnumValue("Ueberhoehung")
    UEBERHOEHUNG("Ueberhoehung"),
    @XmlEnumValue("Uebertragungsweg")
    UEBERTRAGUNGSWEG("Uebertragungsweg"),
    @XmlEnumValue("Unterbringung")
    UNTERBRINGUNG("Unterbringung"),
    @XmlEnumValue("Verkehrszeichen")
    VERKEHRSZEICHEN("Verkehrszeichen"),
    @XmlEnumValue("W_Kr_Anlage")
    W_KR_ANLAGE("W_Kr_Anlage"),
    @XmlEnumValue("W_Kr_Gsp_Element")
    W_KR_GSP_ELEMENT("W_Kr_Gsp_Element"),
    @XmlEnumValue("W_Kr_Gsp_Komponente")
    W_KR_GSP_KOMPONENTE("W_Kr_Gsp_Komponente"),
    @XmlEnumValue("Weichenlaufkette")
    WEICHENLAUFKETTE("Weichenlaufkette"),
    @XmlEnumValue("Weichenlaufkette_Zuordnung")
    WEICHENLAUFKETTE_ZUORDNUNG("Weichenlaufkette_Zuordnung"),
    ZL("ZL"),
    @XmlEnumValue("ZL_DLP_Abschnitt")
    ZL_DLP_ABSCHNITT("ZL_DLP_Abschnitt"),
    @XmlEnumValue("ZL_DLP_Fstr")
    ZL_DLP_FSTR("ZL_DLP_Fstr"),
    @XmlEnumValue("ZL_Fstr")
    ZL_FSTR("ZL_Fstr"),
    @XmlEnumValue("ZL_Fstr_Anstoss")
    ZL_FSTR_ANSTOSS("ZL_Fstr_Anstoss"),
    @XmlEnumValue("ZL_Signalgruppe")
    ZL_SIGNALGRUPPE("ZL_Signalgruppe"),
    @XmlEnumValue("ZL_Signalgruppe_Zuordnung")
    ZL_SIGNALGRUPPE_ZUORDNUNG("ZL_Signalgruppe_Zuordnung"),
    @XmlEnumValue("ZLV_Bus")
    ZLV_BUS("ZLV_Bus"),
    @XmlEnumValue("ZLV_Bus_US_Zuordnung")
    ZLV_BUS_US_ZUORDNUNG("ZLV_Bus_US_Zuordnung"),
    ZN("ZN"),
    @XmlEnumValue("ZN_Akustik")
    ZN_AKUSTIK("ZN_Akustik"),
    @XmlEnumValue("ZN_Anzeigefeld")
    ZN_ANZEIGEFELD("ZN_Anzeigefeld"),
    @XmlEnumValue("ZN_Fortschalt_Kriterium")
    ZN_FORTSCHALT_KRITERIUM("ZN_Fortschalt_Kriterium"),
    @XmlEnumValue("ZN_Telegramm_84_Zuordnung")
    ZN_TELEGRAMM_84_ZUORDNUNG("ZN_Telegramm_84_Zuordnung"),
    @XmlEnumValue("ZN_Telegramm_85_Zuordnung")
    ZN_TELEGRAMM_85_ZUORDNUNG("ZN_Telegramm_85_Zuordnung"),
    @XmlEnumValue("ZN_Unterstation")
    ZN_UNTERSTATION("ZN_Unterstation"),
    ZN_ZBS("ZN_ZBS"),
    @XmlEnumValue("ZUB_Bereichsgrenze")
    ZUB_BEREICHSGRENZE("ZUB_Bereichsgrenze"),
    @XmlEnumValue("ZUB_Streckeneigenschaft")
    ZUB_STRECKENEIGENSCHAFT("ZUB_Streckeneigenschaft"),
    @XmlEnumValue("Zugeinwirkung")
    ZUGEINWIRKUNG("Zugeinwirkung");
    private final String value;

    ENUMLSTObjektArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMLSTObjektArt fromValue(String v) {
        for (ENUMLSTObjektArt c: ENUMLSTObjektArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
