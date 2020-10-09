//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.planpro._1_8;

import modell.ansteuerung_element._1_8.*;
import modell.bahnsteig._1_8.CBahnsteigAnlage;
import modell.bahnsteig._1_8.CBahnsteigKante;
import modell.bahnsteig._1_8.CBahnsteigZugang;
import modell.bahnuebergang._1_8.*;
import modell.basisobjekte._1_8.CAnhang;
import modell.basisobjekte._1_8.CBearbeitungsvermerk;
import modell.basisobjekte._1_8.CProxyObjekt;
import modell.bedienung._1_8.*;
import modell.block._1_8.CBlockAnlage;
import modell.block._1_8.CBlockElement;
import modell.block._1_8.CBlockStrecke;
import modell.fahrstrasse._1_8.*;
import modell.flankenschutz._1_8.CFlaFreimeldeZuordnung;
import modell.flankenschutz._1_8.CFlaSchutz;
import modell.flankenschutz._1_8.CFlaZwieschutz;
import modell.geodaten._1_8.*;
import modell.gleis._1_8.*;
import modell.nahbedienbereich._1_8.*;
import modell.ortung._1_8.*;
import modell.pzb._1_8.CPZBElement;
import modell.pzb._1_8.CPZBElementZuordnung;
import modell.pzb._1_8.CPZBZuordnungSignal;
import modell.regelzeichnung._1_8.CRegelzeichnung;
import modell.regelzeichnung._1_8.CRegelzeichnungParameter;
import modell.schluesselabhaengigkeiten._1_8.CSchloss;
import modell.schluesselabhaengigkeiten._1_8.CSchlosskombination;
import modell.schluesselabhaengigkeiten._1_8.CSchluessel;
import modell.schluesselabhaengigkeiten._1_8.CSchluesselsperre;
import modell.signale._1_8.CSignal;
import modell.signale._1_8.CSignalBefestigung;
import modell.signale._1_8.CSignalRahmen;
import modell.signale._1_8.CSignalSignalbegriff;
import modell.weichen_und_gleissperren._1_8.*;
import modell.zuglenkung._1_8.*;
import modell.zugnummernmeldeanlage._1_8.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r CContainer complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CContainer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Anhang" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CAnhang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Aussenelementansteuerung" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}CAussenelementansteuerung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bahnsteig_Anlage" type="{http://www.plan-pro.org/modell/Bahnsteig/1.8.0}CBahnsteig_Anlage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bahnsteig_Kante" type="{http://www.plan-pro.org/modell/Bahnsteig/1.8.0}CBahnsteig_Kante" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bahnsteig_Zugang" type="{http://www.plan-pro.org/modell/Bahnsteig/1.8.0}CBahnsteig_Zugang" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bearbeitungsvermerk" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBearbeitungsvermerk" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bedien_Anrueckabschnitt" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Anrueckabschnitt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bedien_Anzeige_Element" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Anzeige_Element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bedien_Bezirk" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Bezirk" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bedien_Einrichtung_Oertlich" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Einrichtung_Oertlich" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bedien_GBT" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_GBT" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bedien_Oberflaeche" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Oberflaeche" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bedien_Oberflaeche_Bild" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Oberflaeche_Bild" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bedien_Oertlichkeit" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Oertlichkeit" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bedien_Platz" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Platz" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bedien_Zentrale" type="{http://www.plan-pro.org/modell/Bedienung/1.8.0}CBedien_Zentrale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Block_Anlage" type="{http://www.plan-pro.org/modell/Block/1.8.0}CBlock_Anlage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Block_Element" type="{http://www.plan-pro.org/modell/Block/1.8.0}CBlock_Element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Block_Strecke" type="{http://www.plan-pro.org/modell/Block/1.8.0}CBlock_Strecke" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BUE_Anlage" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Anlage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BUE_Ausschaltung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Ausschaltung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BUE_Bedien_Anzeige_Element" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Bedien_Anzeige_Element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BUE_Deckendes_Signal_Zuordnung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Deckendes_Signal_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BUE_Einschaltung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Einschaltung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BUE_Einschaltung_Zuordnung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Einschaltung_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BUE_Gleisbezogener_Gefahrraum" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Gleisbezogener_Gefahrraum" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BUE_Schnittstelle" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Schnittstelle" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BUE_Spezifisches_Signal" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_Spezifisches_Signal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BUE_WS_Fstr_Zuordnung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CBUE_WS_Fstr_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ESTW_Zentraleinheit" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}CESTW_Zentraleinheit" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fla_Freimelde_Zuordnung" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}CFla_Freimelde_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fla_Schutz" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}CFla_Schutz" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fla_Zwieschutz" type="{http://www.plan-pro.org/modell/Flankenschutz/1.8.0}CFla_Zwieschutz" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FMA_Anlage" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CFMA_Anlage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FMA_Element" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CFMA_Element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FMA_Komponente" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CFMA_Komponente" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fstr_Abhaengigkeit" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_Abhaengigkeit" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fstr_Aneinander" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_Aneinander" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fstr_Aneinander_Zuordnung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_Aneinander_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fstr_DWeg" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_DWeg" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fstr_DWeg_W_Kr" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_DWeg_W_Kr" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fstr_Fahrweg" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_Fahrweg" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fstr_Nichthaltfall" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_Nichthaltfall" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fstr_Rangier_Fla_Zuordnung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_Rangier_Fla_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fstr_Signalisierung" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_Signalisierung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fstr_Umfahrpunkt" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_Umfahrpunkt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fstr_Zug_Rangier" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CFstr_Zug_Rangier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GEO_Kante" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CGEO_Kante" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GEO_Knoten" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CGEO_Knoten" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GEO_Punkt" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CGEO_Punkt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Geschwindigkeitsprofil" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CGeschwindigkeitsprofil" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Gleis_Abschluss" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}CGleis_Abschluss" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Gleis_Abschnitt" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}CGleis_Abschnitt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Gleis_Art" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}CGleis_Art" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Gleis_Baubereich" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}CGleis_Baubereich" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Gleis_Bezeichnung" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}CGleis_Bezeichnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Gleis_Fahrbahn" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}CGleis_Fahrbahn" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Gleis_Lichtraum" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}CGleis_Lichtraum" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Gleis_Schaltgruppe" type="{http://www.plan-pro.org/modell/Gleis/1.8.0}CGleis_Schaltgruppe" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Hoehenpunkt" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CHoehenpunkt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Markanter_Punkt" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CMarkanter_Punkt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NB" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}CNB" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NB_Bedien_Anzeige_Element" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}CNB_Bedien_Anzeige_Element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NB_Zone" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}CNB_Zone" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NB_Zone_Element" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}CNB_Zone_Element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NB_Zone_Grenze" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}CNB_Zone_Grenze" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Oertlichkeit" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}COertlichkeit" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Proxy_Objekt" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CProxy_Objekt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PZB_Element" type="{http://www.plan-pro.org/modell/PZB/1.8.0}CPZB_Element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PZB_Element_Zuordnung" type="{http://www.plan-pro.org/modell/PZB/1.8.0}CPZB_Element_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PZB_Zuordnung_Signal" type="{http://www.plan-pro.org/modell/PZB/1.8.0}CPZB_Zuordnung_Signal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Regelzeichnung" type="{http://www.plan-pro.org/modell/Regelzeichnung/1.8.0}CRegelzeichnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Regelzeichnung_Parameter" type="{http://www.plan-pro.org/modell/Regelzeichnung/1.8.0}CRegelzeichnung_Parameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Schaltmittel_Fstr_Zuordnung" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.8.0}CSchaltmittel_Fstr_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Schaltmittel_Zuordnung" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CSchaltmittel_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Schloss" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.8.0}CSchloss" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Schlosskombination" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.8.0}CSchlosskombination" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Schluessel" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.8.0}CSchluessel" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Schluesselsperre" type="{http://www.plan-pro.org/modell/Schluesselabhaengigkeiten/1.8.0}CSchluesselsperre" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Signal" type="{http://www.plan-pro.org/modell/Signale/1.8.0}CSignal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Signal_Befestigung" type="{http://www.plan-pro.org/modell/Signale/1.8.0}CSignal_Befestigung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Signal_Rahmen" type="{http://www.plan-pro.org/modell/Signale/1.8.0}CSignal_Rahmen" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Signal_Signalbegriff" type="{http://www.plan-pro.org/modell/Signale/1.8.0}CSignal_Signalbegriff" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Sonstiger_Punkt" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}CSonstiger_Punkt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Stell_Bereich" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}CStell_Bereich" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Stellelement" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}CStellelement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Strecke" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CStrecke" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Strecke_Punkt" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CStrecke_Punkt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Technischer_Bereich" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CTechnischer_Bereich" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Technischer_Punkt" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CTechnischer_Punkt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TOP_Kante" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CTOP_Kante" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TOP_Knoten" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CTOP_Knoten" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Ueberhoehung" type="{http://www.plan-pro.org/modell/Geodaten/1.8.0}CUeberhoehung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Uebertragungsweg" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}CUebertragungsweg" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Unterbringung" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.8.0}CUnterbringung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="W_Kr_Anlage" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CW_Kr_Anlage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="W_Kr_Gsp_Element" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CW_Kr_Gsp_Element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="W_Kr_Gsp_Komponente" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CW_Kr_Gsp_Komponente" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Weichenlaufkette" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CWeichenlaufkette" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Weichenlaufkette_Zuordnung" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.8.0}CWeichenlaufkette_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZL" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}CZL" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZL_DLP_Abschnitt" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}CZL_DLP_Abschnitt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZL_DLP_Fstr" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}CZL_DLP_Fstr" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZL_Fstr" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}CZL_Fstr" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZL_Fstr_Anstoss" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}CZL_Fstr_Anstoss" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZL_Signalgruppe" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}CZL_Signalgruppe" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZL_Signalgruppe_Zuordnung" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}CZL_Signalgruppe_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZLV_Bus" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZLV_Bus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZLV_Bus_US_Zuordnung" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZLV_Bus_US_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZN" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZN_Akustik" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_Akustik" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZN_Anzeigefeld" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_Anzeigefeld" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZN_Fortschalt_Kriterium" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_Fortschalt_Kriterium" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZN_Telegramm_84_Zuordnung" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_Telegramm_84_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZN_Telegramm_85_Zuordnung" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_Telegramm_85_Zuordnung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZN_Unterstation" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_Unterstation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ZN_ZBS" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}CZN_ZBS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Zugeinwirkung" type="{http://www.plan-pro.org/modell/Ortung/1.8.0}CZugeinwirkung" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CContainer", propOrder = {
    "anhang",
    "aussenelementansteuerung",
    "bahnsteigAnlage",
    "bahnsteigKante",
    "bahnsteigZugang",
    "bearbeitungsvermerk",
    "bedienAnrueckabschnitt",
    "bedienAnzeigeElement",
    "bedienBezirk",
    "bedienEinrichtungOertlich",
    "bedienGBT",
    "bedienOberflaeche",
    "bedienOberflaecheBild",
    "bedienOertlichkeit",
    "bedienPlatz",
    "bedienZentrale",
    "blockAnlage",
    "blockElement",
    "blockStrecke",
    "bueAnlage",
    "bueAusschaltung",
    "bueBedienAnzeigeElement",
    "bueDeckendesSignalZuordnung",
    "bueEinschaltung",
    "bueEinschaltungZuordnung",
    "bueGleisbezogenerGefahrraum",
    "bueSchnittstelle",
    "bueSpezifischesSignal",
    "buewsFstrZuordnung",
    "estwZentraleinheit",
    "flaFreimeldeZuordnung",
    "flaSchutz",
    "flaZwieschutz",
    "fmaAnlage",
    "fmaElement",
    "fmaKomponente",
    "fstrAbhaengigkeit",
    "fstrAneinander",
    "fstrAneinanderZuordnung",
    "fstrDWeg",
    "fstrDWegWKr",
    "fstrFahrweg",
    "fstrNichthaltfall",
    "fstrRangierFlaZuordnung",
    "fstrSignalisierung",
    "fstrUmfahrpunkt",
    "fstrZugRangier",
    "geoKante",
    "geoKnoten",
    "geoPunkt",
    "geschwindigkeitsprofil",
    "gleisAbschluss",
    "gleisAbschnitt",
    "gleisArt",
    "gleisBaubereich",
    "gleisBezeichnung",
    "gleisFahrbahn",
    "gleisLichtraum",
    "gleisSchaltgruppe",
    "hoehenpunkt",
    "markanterPunkt",
    "nb",
    "nbBedienAnzeigeElement",
    "nbZone",
    "nbZoneElement",
    "nbZoneGrenze",
    "oertlichkeit",
    "proxyObjekt",
    "pzbElement",
    "pzbElementZuordnung",
    "pzbZuordnungSignal",
    "regelzeichnung",
    "regelzeichnungParameter",
    "schaltmittelFstrZuordnung",
    "schaltmittelZuordnung",
    "schloss",
    "schlosskombination",
    "schluessel",
    "schluesselsperre",
    "signal",
    "signalBefestigung",
    "signalRahmen",
    "signalSignalbegriff",
    "sonstigerPunkt",
    "stellBereich",
    "stellelement",
    "strecke",
    "streckePunkt",
    "technischerBereich",
    "technischerPunkt",
    "topKante",
    "topKnoten",
    "ueberhoehung",
    "uebertragungsweg",
    "unterbringung",
    "wKrAnlage",
    "wKrGspElement",
    "wKrGspKomponente",
    "weichenlaufkette",
    "weichenlaufketteZuordnung",
    "zl",
    "zldlpAbschnitt",
    "zldlpFstr",
    "zlFstr",
    "zlFstrAnstoss",
    "zlSignalgruppe",
    "zlSignalgruppeZuordnung",
    "zlvBus",
    "zlvBusUSZuordnung",
    "zn",
    "znAkustik",
    "znAnzeigefeld",
    "znFortschaltKriterium",
    "znTelegramm84Zuordnung",
    "znTelegramm85Zuordnung",
    "znUnterstation",
    "znzbs",
    "zugeinwirkung"
})
public class CContainer {

    @XmlElement(name = "Anhang")
    protected List<CAnhang> anhang;
    @XmlElement(name = "Aussenelementansteuerung")
    protected List<CAussenelementansteuerung> aussenelementansteuerung;
    @XmlElement(name = "Bahnsteig_Anlage")
    protected List<CBahnsteigAnlage> bahnsteigAnlage;
    @XmlElement(name = "Bahnsteig_Kante")
    protected List<CBahnsteigKante> bahnsteigKante;
    @XmlElement(name = "Bahnsteig_Zugang")
    protected List<CBahnsteigZugang> bahnsteigZugang;
    @XmlElement(name = "Bearbeitungsvermerk")
    protected List<CBearbeitungsvermerk> bearbeitungsvermerk;
    @XmlElement(name = "Bedien_Anrueckabschnitt")
    protected List<CBedienAnrueckabschnitt> bedienAnrueckabschnitt;
    @XmlElement(name = "Bedien_Anzeige_Element")
    protected List<CBedienAnzeigeElement> bedienAnzeigeElement;
    @XmlElement(name = "Bedien_Bezirk")
    protected List<CBedienBezirk> bedienBezirk;
    @XmlElement(name = "Bedien_Einrichtung_Oertlich")
    protected List<CBedienEinrichtungOertlich> bedienEinrichtungOertlich;
    @XmlElement(name = "Bedien_GBT")
    protected List<CBedienGBT> bedienGBT;
    @XmlElement(name = "Bedien_Oberflaeche")
    protected List<CBedienOberflaeche> bedienOberflaeche;
    @XmlElement(name = "Bedien_Oberflaeche_Bild")
    protected List<CBedienOberflaecheBild> bedienOberflaecheBild;
    @XmlElement(name = "Bedien_Oertlichkeit")
    protected List<CBedienOertlichkeit> bedienOertlichkeit;
    @XmlElement(name = "Bedien_Platz")
    protected List<CBedienPlatz> bedienPlatz;
    @XmlElement(name = "Bedien_Zentrale")
    protected List<CBedienZentrale> bedienZentrale;
    @XmlElement(name = "Block_Anlage")
    protected List<CBlockAnlage> blockAnlage;
    @XmlElement(name = "Block_Element")
    protected List<CBlockElement> blockElement;
    @XmlElement(name = "Block_Strecke")
    protected List<CBlockStrecke> blockStrecke;
    @XmlElement(name = "BUE_Anlage")
    protected List<CBUEAnlage> bueAnlage;
    @XmlElement(name = "BUE_Ausschaltung")
    protected List<CBUEAusschaltung> bueAusschaltung;
    @XmlElement(name = "BUE_Bedien_Anzeige_Element")
    protected List<CBUEBedienAnzeigeElement> bueBedienAnzeigeElement;
    @XmlElement(name = "BUE_Deckendes_Signal_Zuordnung")
    protected List<CBUEDeckendesSignalZuordnung> bueDeckendesSignalZuordnung;
    @XmlElement(name = "BUE_Einschaltung")
    protected List<CBUEEinschaltung> bueEinschaltung;
    @XmlElement(name = "BUE_Einschaltung_Zuordnung")
    protected List<CBUEEinschaltungZuordnung> bueEinschaltungZuordnung;
    @XmlElement(name = "BUE_Gleisbezogener_Gefahrraum")
    protected List<CBUEGleisbezogenerGefahrraum> bueGleisbezogenerGefahrraum;
    @XmlElement(name = "BUE_Schnittstelle")
    protected List<CBUESchnittstelle> bueSchnittstelle;
    @XmlElement(name = "BUE_Spezifisches_Signal")
    protected List<CBUESpezifischesSignal> bueSpezifischesSignal;
    @XmlElement(name = "BUE_WS_Fstr_Zuordnung")
    protected List<CBUEWSFstrZuordnung> buewsFstrZuordnung;
    @XmlElement(name = "ESTW_Zentraleinheit")
    protected List<CESTWZentraleinheit> estwZentraleinheit;
    @XmlElement(name = "Fla_Freimelde_Zuordnung")
    protected List<CFlaFreimeldeZuordnung> flaFreimeldeZuordnung;
    @XmlElement(name = "Fla_Schutz")
    protected List<CFlaSchutz> flaSchutz;
    @XmlElement(name = "Fla_Zwieschutz")
    protected List<CFlaZwieschutz> flaZwieschutz;
    @XmlElement(name = "FMA_Anlage")
    protected List<CFMAAnlage> fmaAnlage;
    @XmlElement(name = "FMA_Element")
    protected List<CFMAElement> fmaElement;
    @XmlElement(name = "FMA_Komponente")
    protected List<CFMAKomponente> fmaKomponente;
    @XmlElement(name = "Fstr_Abhaengigkeit")
    protected List<CFstrAbhaengigkeit> fstrAbhaengigkeit;
    @XmlElement(name = "Fstr_Aneinander")
    protected List<CFstrAneinander> fstrAneinander;
    @XmlElement(name = "Fstr_Aneinander_Zuordnung")
    protected List<CFstrAneinanderZuordnung> fstrAneinanderZuordnung;
    @XmlElement(name = "Fstr_DWeg")
    protected List<CFstrDWeg> fstrDWeg;
    @XmlElement(name = "Fstr_DWeg_W_Kr")
    protected List<CFstrDWegWKr> fstrDWegWKr;
    @XmlElement(name = "Fstr_Fahrweg")
    protected List<CFstrFahrweg> fstrFahrweg;
    @XmlElement(name = "Fstr_Nichthaltfall")
    protected List<CFstrNichthaltfall> fstrNichthaltfall;
    @XmlElement(name = "Fstr_Rangier_Fla_Zuordnung")
    protected List<CFstrRangierFlaZuordnung> fstrRangierFlaZuordnung;
    @XmlElement(name = "Fstr_Signalisierung")
    protected List<CFstrSignalisierung> fstrSignalisierung;
    @XmlElement(name = "Fstr_Umfahrpunkt")
    protected List<CFstrUmfahrpunkt> fstrUmfahrpunkt;
    @XmlElement(name = "Fstr_Zug_Rangier")
    protected List<CFstrZugRangier> fstrZugRangier;
    @XmlElement(name = "GEO_Kante")
    protected List<CGEOKante> geoKante;
    @XmlElement(name = "GEO_Knoten")
    protected List<CGEOKnoten> geoKnoten;
    @XmlElement(name = "GEO_Punkt")
    protected List<CGEOPunkt> geoPunkt;
    @XmlElement(name = "Geschwindigkeitsprofil")
    protected List<CGeschwindigkeitsprofil> geschwindigkeitsprofil;
    @XmlElement(name = "Gleis_Abschluss")
    protected List<CGleisAbschluss> gleisAbschluss;
    @XmlElement(name = "Gleis_Abschnitt")
    protected List<CGleisAbschnitt> gleisAbschnitt;
    @XmlElement(name = "Gleis_Art")
    protected List<CGleisArt> gleisArt;
    @XmlElement(name = "Gleis_Baubereich")
    protected List<CGleisBaubereich> gleisBaubereich;
    @XmlElement(name = "Gleis_Bezeichnung")
    protected List<CGleisBezeichnung> gleisBezeichnung;
    @XmlElement(name = "Gleis_Fahrbahn")
    protected List<CGleisFahrbahn> gleisFahrbahn;
    @XmlElement(name = "Gleis_Lichtraum")
    protected List<CGleisLichtraum> gleisLichtraum;
    @XmlElement(name = "Gleis_Schaltgruppe")
    protected List<CGleisSchaltgruppe> gleisSchaltgruppe;
    @XmlElement(name = "Hoehenpunkt")
    protected List<CHoehenpunkt> hoehenpunkt;
    @XmlElement(name = "Markanter_Punkt")
    protected List<CMarkanterPunkt> markanterPunkt;
    @XmlElement(name = "NB")
    protected List<CNB> nb;
    @XmlElement(name = "NB_Bedien_Anzeige_Element")
    protected List<CNBBedienAnzeigeElement> nbBedienAnzeigeElement;
    @XmlElement(name = "NB_Zone")
    protected List<CNBZone> nbZone;
    @XmlElement(name = "NB_Zone_Element")
    protected List<CNBZoneElement> nbZoneElement;
    @XmlElement(name = "NB_Zone_Grenze")
    protected List<CNBZoneGrenze> nbZoneGrenze;
    @XmlElement(name = "Oertlichkeit")
    protected List<COertlichkeit> oertlichkeit;
    @XmlElement(name = "Proxy_Objekt")
    protected List<CProxyObjekt> proxyObjekt;
    @XmlElement(name = "PZB_Element")
    protected List<CPZBElement> pzbElement;
    @XmlElement(name = "PZB_Element_Zuordnung")
    protected List<CPZBElementZuordnung> pzbElementZuordnung;
    @XmlElement(name = "PZB_Zuordnung_Signal")
    protected List<CPZBZuordnungSignal> pzbZuordnungSignal;
    @XmlElement(name = "Regelzeichnung")
    protected List<CRegelzeichnung> regelzeichnung;
    @XmlElement(name = "Regelzeichnung_Parameter")
    protected List<CRegelzeichnungParameter> regelzeichnungParameter;
    @XmlElement(name = "Schaltmittel_Fstr_Zuordnung")
    protected List<CSchaltmittelFstrZuordnung> schaltmittelFstrZuordnung;
    @XmlElement(name = "Schaltmittel_Zuordnung")
    protected List<CSchaltmittelZuordnung> schaltmittelZuordnung;
    @XmlElement(name = "Schloss")
    protected List<CSchloss> schloss;
    @XmlElement(name = "Schlosskombination")
    protected List<CSchlosskombination> schlosskombination;
    @XmlElement(name = "Schluessel")
    protected List<CSchluessel> schluessel;
    @XmlElement(name = "Schluesselsperre")
    protected List<CSchluesselsperre> schluesselsperre;
    @XmlElement(name = "Signal")
    protected List<CSignal> signal;
    @XmlElement(name = "Signal_Befestigung")
    protected List<CSignalBefestigung> signalBefestigung;
    @XmlElement(name = "Signal_Rahmen")
    protected List<CSignalRahmen> signalRahmen;
    @XmlElement(name = "Signal_Signalbegriff")
    protected List<CSignalSignalbegriff> signalSignalbegriff;
    @XmlElement(name = "Sonstiger_Punkt")
    protected List<CSonstigerPunkt> sonstigerPunkt;
    @XmlElement(name = "Stell_Bereich")
    protected List<CStellBereich> stellBereich;
    @XmlElement(name = "Stellelement")
    protected List<CStellelement> stellelement;
    @XmlElement(name = "Strecke")
    protected List<CStrecke> strecke;
    @XmlElement(name = "Strecke_Punkt")
    protected List<CStreckePunkt> streckePunkt;
    @XmlElement(name = "Technischer_Bereich")
    protected List<CTechnischerBereich> technischerBereich;
    @XmlElement(name = "Technischer_Punkt")
    protected List<CTechnischerPunkt> technischerPunkt;
    @XmlElement(name = "TOP_Kante")
    protected List<CTOPKante> topKante;
    @XmlElement(name = "TOP_Knoten")
    protected List<CTOPKnoten> topKnoten;
    @XmlElement(name = "Ueberhoehung")
    protected List<CUeberhoehung> ueberhoehung;
    @XmlElement(name = "Uebertragungsweg")
    protected List<CUebertragungsweg> uebertragungsweg;
    @XmlElement(name = "Unterbringung")
    protected List<CUnterbringung> unterbringung;
    @XmlElement(name = "W_Kr_Anlage")
    protected List<CWKrAnlage> wKrAnlage;
    @XmlElement(name = "W_Kr_Gsp_Element")
    protected List<CWKrGspElement> wKrGspElement;
    @XmlElement(name = "W_Kr_Gsp_Komponente")
    protected List<CWKrGspKomponente> wKrGspKomponente;
    @XmlElement(name = "Weichenlaufkette")
    protected List<CWeichenlaufkette> weichenlaufkette;
    @XmlElement(name = "Weichenlaufkette_Zuordnung")
    protected List<CWeichenlaufketteZuordnung> weichenlaufketteZuordnung;
    @XmlElement(name = "ZL")
    protected List<CZL> zl;
    @XmlElement(name = "ZL_DLP_Abschnitt")
    protected List<CZLDLPAbschnitt> zldlpAbschnitt;
    @XmlElement(name = "ZL_DLP_Fstr")
    protected List<CZLDLPFstr> zldlpFstr;
    @XmlElement(name = "ZL_Fstr")
    protected List<CZLFstr> zlFstr;
    @XmlElement(name = "ZL_Fstr_Anstoss")
    protected List<CZLFstrAnstoss> zlFstrAnstoss;
    @XmlElement(name = "ZL_Signalgruppe")
    protected List<CZLSignalgruppe> zlSignalgruppe;
    @XmlElement(name = "ZL_Signalgruppe_Zuordnung")
    protected List<CZLSignalgruppeZuordnung> zlSignalgruppeZuordnung;
    @XmlElement(name = "ZLV_Bus")
    protected List<CZLVBus> zlvBus;
    @XmlElement(name = "ZLV_Bus_US_Zuordnung")
    protected List<CZLVBusUSZuordnung> zlvBusUSZuordnung;
    @XmlElement(name = "ZN")
    protected List<CZN> zn;
    @XmlElement(name = "ZN_Akustik")
    protected List<CZNAkustik> znAkustik;
    @XmlElement(name = "ZN_Anzeigefeld")
    protected List<CZNAnzeigefeld> znAnzeigefeld;
    @XmlElement(name = "ZN_Fortschalt_Kriterium")
    protected List<CZNFortschaltKriterium> znFortschaltKriterium;
    @XmlElement(name = "ZN_Telegramm_84_Zuordnung")
    protected List<CZNTelegramm84Zuordnung> znTelegramm84Zuordnung;
    @XmlElement(name = "ZN_Telegramm_85_Zuordnung")
    protected List<CZNTelegramm85Zuordnung> znTelegramm85Zuordnung;
    @XmlElement(name = "ZN_Unterstation")
    protected List<CZNUnterstation> znUnterstation;
    @XmlElement(name = "ZN_ZBS")
    protected List<CZNZBS> znzbs;
    @XmlElement(name = "Zugeinwirkung")
    protected List<CZugeinwirkung> zugeinwirkung;

    /**
     * Gets the value of the anhang property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anhang property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnhang().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAnhang }
     * 
     * 
     */
    public List<CAnhang> getAnhang() {
        if (anhang == null) {
            anhang = new ArrayList<CAnhang>();
        }
        return this.anhang;
    }

    /**
     * Gets the value of the aussenelementansteuerung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aussenelementansteuerung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAussenelementansteuerung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CAussenelementansteuerung }
     * 
     * 
     */
    public List<CAussenelementansteuerung> getAussenelementansteuerung() {
        if (aussenelementansteuerung == null) {
            aussenelementansteuerung = new ArrayList<CAussenelementansteuerung>();
        }
        return this.aussenelementansteuerung;
    }

    /**
     * Gets the value of the bahnsteigAnlage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bahnsteigAnlage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBahnsteigAnlage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBahnsteigAnlage }
     * 
     * 
     */
    public List<CBahnsteigAnlage> getBahnsteigAnlage() {
        if (bahnsteigAnlage == null) {
            bahnsteigAnlage = new ArrayList<CBahnsteigAnlage>();
        }
        return this.bahnsteigAnlage;
    }

    /**
     * Gets the value of the bahnsteigKante property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bahnsteigKante property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBahnsteigKante().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBahnsteigKante }
     * 
     * 
     */
    public List<CBahnsteigKante> getBahnsteigKante() {
        if (bahnsteigKante == null) {
            bahnsteigKante = new ArrayList<CBahnsteigKante>();
        }
        return this.bahnsteigKante;
    }

    /**
     * Gets the value of the bahnsteigZugang property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bahnsteigZugang property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBahnsteigZugang().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBahnsteigZugang }
     * 
     * 
     */
    public List<CBahnsteigZugang> getBahnsteigZugang() {
        if (bahnsteigZugang == null) {
            bahnsteigZugang = new ArrayList<CBahnsteigZugang>();
        }
        return this.bahnsteigZugang;
    }

    /**
     * Gets the value of the bearbeitungsvermerk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bearbeitungsvermerk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBearbeitungsvermerk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBearbeitungsvermerk }
     * 
     * 
     */
    public List<CBearbeitungsvermerk> getBearbeitungsvermerk() {
        if (bearbeitungsvermerk == null) {
            bearbeitungsvermerk = new ArrayList<CBearbeitungsvermerk>();
        }
        return this.bearbeitungsvermerk;
    }

    /**
     * Gets the value of the bedienAnrueckabschnitt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedienAnrueckabschnitt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedienAnrueckabschnitt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBedienAnrueckabschnitt }
     * 
     * 
     */
    public List<CBedienAnrueckabschnitt> getBedienAnrueckabschnitt() {
        if (bedienAnrueckabschnitt == null) {
            bedienAnrueckabschnitt = new ArrayList<CBedienAnrueckabschnitt>();
        }
        return this.bedienAnrueckabschnitt;
    }

    /**
     * Gets the value of the bedienAnzeigeElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedienAnzeigeElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedienAnzeigeElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBedienAnzeigeElement }
     * 
     * 
     */
    public List<CBedienAnzeigeElement> getBedienAnzeigeElement() {
        if (bedienAnzeigeElement == null) {
            bedienAnzeigeElement = new ArrayList<CBedienAnzeigeElement>();
        }
        return this.bedienAnzeigeElement;
    }

    /**
     * Gets the value of the bedienBezirk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedienBezirk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedienBezirk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBedienBezirk }
     * 
     * 
     */
    public List<CBedienBezirk> getBedienBezirk() {
        if (bedienBezirk == null) {
            bedienBezirk = new ArrayList<CBedienBezirk>();
        }
        return this.bedienBezirk;
    }

    /**
     * Gets the value of the bedienEinrichtungOertlich property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedienEinrichtungOertlich property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedienEinrichtungOertlich().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBedienEinrichtungOertlich }
     * 
     * 
     */
    public List<CBedienEinrichtungOertlich> getBedienEinrichtungOertlich() {
        if (bedienEinrichtungOertlich == null) {
            bedienEinrichtungOertlich = new ArrayList<CBedienEinrichtungOertlich>();
        }
        return this.bedienEinrichtungOertlich;
    }

    /**
     * Gets the value of the bedienGBT property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedienGBT property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedienGBT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBedienGBT }
     * 
     * 
     */
    public List<CBedienGBT> getBedienGBT() {
        if (bedienGBT == null) {
            bedienGBT = new ArrayList<CBedienGBT>();
        }
        return this.bedienGBT;
    }

    /**
     * Gets the value of the bedienOberflaeche property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedienOberflaeche property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedienOberflaeche().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBedienOberflaeche }
     * 
     * 
     */
    public List<CBedienOberflaeche> getBedienOberflaeche() {
        if (bedienOberflaeche == null) {
            bedienOberflaeche = new ArrayList<CBedienOberflaeche>();
        }
        return this.bedienOberflaeche;
    }

    /**
     * Gets the value of the bedienOberflaecheBild property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedienOberflaecheBild property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedienOberflaecheBild().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBedienOberflaecheBild }
     * 
     * 
     */
    public List<CBedienOberflaecheBild> getBedienOberflaecheBild() {
        if (bedienOberflaecheBild == null) {
            bedienOberflaecheBild = new ArrayList<CBedienOberflaecheBild>();
        }
        return this.bedienOberflaecheBild;
    }

    /**
     * Gets the value of the bedienOertlichkeit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedienOertlichkeit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedienOertlichkeit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBedienOertlichkeit }
     * 
     * 
     */
    public List<CBedienOertlichkeit> getBedienOertlichkeit() {
        if (bedienOertlichkeit == null) {
            bedienOertlichkeit = new ArrayList<CBedienOertlichkeit>();
        }
        return this.bedienOertlichkeit;
    }

    /**
     * Gets the value of the bedienPlatz property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedienPlatz property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedienPlatz().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBedienPlatz }
     * 
     * 
     */
    public List<CBedienPlatz> getBedienPlatz() {
        if (bedienPlatz == null) {
            bedienPlatz = new ArrayList<CBedienPlatz>();
        }
        return this.bedienPlatz;
    }

    /**
     * Gets the value of the bedienZentrale property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bedienZentrale property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBedienZentrale().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBedienZentrale }
     * 
     * 
     */
    public List<CBedienZentrale> getBedienZentrale() {
        if (bedienZentrale == null) {
            bedienZentrale = new ArrayList<CBedienZentrale>();
        }
        return this.bedienZentrale;
    }

    /**
     * Gets the value of the blockAnlage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the blockAnlage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlockAnlage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBlockAnlage }
     * 
     * 
     */
    public List<CBlockAnlage> getBlockAnlage() {
        if (blockAnlage == null) {
            blockAnlage = new ArrayList<CBlockAnlage>();
        }
        return this.blockAnlage;
    }

    /**
     * Gets the value of the blockElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the blockElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlockElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBlockElement }
     * 
     * 
     */
    public List<CBlockElement> getBlockElement() {
        if (blockElement == null) {
            blockElement = new ArrayList<CBlockElement>();
        }
        return this.blockElement;
    }

    /**
     * Gets the value of the blockStrecke property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the blockStrecke property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlockStrecke().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBlockStrecke }
     * 
     * 
     */
    public List<CBlockStrecke> getBlockStrecke() {
        if (blockStrecke == null) {
            blockStrecke = new ArrayList<CBlockStrecke>();
        }
        return this.blockStrecke;
    }

    /**
     * Gets the value of the bueAnlage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bueAnlage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUEAnlage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUEAnlage }
     * 
     * 
     */
    public List<CBUEAnlage> getBUEAnlage() {
        if (bueAnlage == null) {
            bueAnlage = new ArrayList<CBUEAnlage>();
        }
        return this.bueAnlage;
    }

    /**
     * Gets the value of the bueAusschaltung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bueAusschaltung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUEAusschaltung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUEAusschaltung }
     * 
     * 
     */
    public List<CBUEAusschaltung> getBUEAusschaltung() {
        if (bueAusschaltung == null) {
            bueAusschaltung = new ArrayList<CBUEAusschaltung>();
        }
        return this.bueAusschaltung;
    }

    /**
     * Gets the value of the bueBedienAnzeigeElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bueBedienAnzeigeElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUEBedienAnzeigeElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUEBedienAnzeigeElement }
     * 
     * 
     */
    public List<CBUEBedienAnzeigeElement> getBUEBedienAnzeigeElement() {
        if (bueBedienAnzeigeElement == null) {
            bueBedienAnzeigeElement = new ArrayList<CBUEBedienAnzeigeElement>();
        }
        return this.bueBedienAnzeigeElement;
    }

    /**
     * Gets the value of the bueDeckendesSignalZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bueDeckendesSignalZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUEDeckendesSignalZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUEDeckendesSignalZuordnung }
     * 
     * 
     */
    public List<CBUEDeckendesSignalZuordnung> getBUEDeckendesSignalZuordnung() {
        if (bueDeckendesSignalZuordnung == null) {
            bueDeckendesSignalZuordnung = new ArrayList<CBUEDeckendesSignalZuordnung>();
        }
        return this.bueDeckendesSignalZuordnung;
    }

    /**
     * Gets the value of the bueEinschaltung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bueEinschaltung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUEEinschaltung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUEEinschaltung }
     * 
     * 
     */
    public List<CBUEEinschaltung> getBUEEinschaltung() {
        if (bueEinschaltung == null) {
            bueEinschaltung = new ArrayList<CBUEEinschaltung>();
        }
        return this.bueEinschaltung;
    }

    /**
     * Gets the value of the bueEinschaltungZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bueEinschaltungZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUEEinschaltungZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUEEinschaltungZuordnung }
     * 
     * 
     */
    public List<CBUEEinschaltungZuordnung> getBUEEinschaltungZuordnung() {
        if (bueEinschaltungZuordnung == null) {
            bueEinschaltungZuordnung = new ArrayList<CBUEEinschaltungZuordnung>();
        }
        return this.bueEinschaltungZuordnung;
    }

    /**
     * Gets the value of the bueGleisbezogenerGefahrraum property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bueGleisbezogenerGefahrraum property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUEGleisbezogenerGefahrraum().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUEGleisbezogenerGefahrraum }
     * 
     * 
     */
    public List<CBUEGleisbezogenerGefahrraum> getBUEGleisbezogenerGefahrraum() {
        if (bueGleisbezogenerGefahrraum == null) {
            bueGleisbezogenerGefahrraum = new ArrayList<CBUEGleisbezogenerGefahrraum>();
        }
        return this.bueGleisbezogenerGefahrraum;
    }

    /**
     * Gets the value of the bueSchnittstelle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bueSchnittstelle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUESchnittstelle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUESchnittstelle }
     * 
     * 
     */
    public List<CBUESchnittstelle> getBUESchnittstelle() {
        if (bueSchnittstelle == null) {
            bueSchnittstelle = new ArrayList<CBUESchnittstelle>();
        }
        return this.bueSchnittstelle;
    }

    /**
     * Gets the value of the bueSpezifischesSignal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bueSpezifischesSignal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUESpezifischesSignal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUESpezifischesSignal }
     * 
     * 
     */
    public List<CBUESpezifischesSignal> getBUESpezifischesSignal() {
        if (bueSpezifischesSignal == null) {
            bueSpezifischesSignal = new ArrayList<CBUESpezifischesSignal>();
        }
        return this.bueSpezifischesSignal;
    }

    /**
     * Gets the value of the buewsFstrZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the buewsFstrZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUEWSFstrZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBUEWSFstrZuordnung }
     * 
     * 
     */
    public List<CBUEWSFstrZuordnung> getBUEWSFstrZuordnung() {
        if (buewsFstrZuordnung == null) {
            buewsFstrZuordnung = new ArrayList<CBUEWSFstrZuordnung>();
        }
        return this.buewsFstrZuordnung;
    }

    /**
     * Gets the value of the estwZentraleinheit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the estwZentraleinheit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getESTWZentraleinheit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CESTWZentraleinheit }
     * 
     * 
     */
    public List<CESTWZentraleinheit> getESTWZentraleinheit() {
        if (estwZentraleinheit == null) {
            estwZentraleinheit = new ArrayList<CESTWZentraleinheit>();
        }
        return this.estwZentraleinheit;
    }

    /**
     * Gets the value of the flaFreimeldeZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flaFreimeldeZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlaFreimeldeZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFlaFreimeldeZuordnung }
     * 
     * 
     */
    public List<CFlaFreimeldeZuordnung> getFlaFreimeldeZuordnung() {
        if (flaFreimeldeZuordnung == null) {
            flaFreimeldeZuordnung = new ArrayList<CFlaFreimeldeZuordnung>();
        }
        return this.flaFreimeldeZuordnung;
    }

    /**
     * Gets the value of the flaSchutz property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flaSchutz property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlaSchutz().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFlaSchutz }
     * 
     * 
     */
    public List<CFlaSchutz> getFlaSchutz() {
        if (flaSchutz == null) {
            flaSchutz = new ArrayList<CFlaSchutz>();
        }
        return this.flaSchutz;
    }

    /**
     * Gets the value of the flaZwieschutz property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flaZwieschutz property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlaZwieschutz().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFlaZwieschutz }
     * 
     * 
     */
    public List<CFlaZwieschutz> getFlaZwieschutz() {
        if (flaZwieschutz == null) {
            flaZwieschutz = new ArrayList<CFlaZwieschutz>();
        }
        return this.flaZwieschutz;
    }

    /**
     * Gets the value of the fmaAnlage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fmaAnlage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFMAAnlage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFMAAnlage }
     * 
     * 
     */
    public List<CFMAAnlage> getFMAAnlage() {
        if (fmaAnlage == null) {
            fmaAnlage = new ArrayList<CFMAAnlage>();
        }
        return this.fmaAnlage;
    }

    /**
     * Gets the value of the fmaElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fmaElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFMAElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFMAElement }
     * 
     * 
     */
    public List<CFMAElement> getFMAElement() {
        if (fmaElement == null) {
            fmaElement = new ArrayList<CFMAElement>();
        }
        return this.fmaElement;
    }

    /**
     * Gets the value of the fmaKomponente property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fmaKomponente property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFMAKomponente().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFMAKomponente }
     * 
     * 
     */
    public List<CFMAKomponente> getFMAKomponente() {
        if (fmaKomponente == null) {
            fmaKomponente = new ArrayList<CFMAKomponente>();
        }
        return this.fmaKomponente;
    }

    /**
     * Gets the value of the fstrAbhaengigkeit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fstrAbhaengigkeit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFstrAbhaengigkeit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFstrAbhaengigkeit }
     * 
     * 
     */
    public List<CFstrAbhaengigkeit> getFstrAbhaengigkeit() {
        if (fstrAbhaengigkeit == null) {
            fstrAbhaengigkeit = new ArrayList<CFstrAbhaengigkeit>();
        }
        return this.fstrAbhaengigkeit;
    }

    /**
     * Gets the value of the fstrAneinander property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fstrAneinander property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFstrAneinander().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFstrAneinander }
     * 
     * 
     */
    public List<CFstrAneinander> getFstrAneinander() {
        if (fstrAneinander == null) {
            fstrAneinander = new ArrayList<CFstrAneinander>();
        }
        return this.fstrAneinander;
    }

    /**
     * Gets the value of the fstrAneinanderZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fstrAneinanderZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFstrAneinanderZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFstrAneinanderZuordnung }
     * 
     * 
     */
    public List<CFstrAneinanderZuordnung> getFstrAneinanderZuordnung() {
        if (fstrAneinanderZuordnung == null) {
            fstrAneinanderZuordnung = new ArrayList<CFstrAneinanderZuordnung>();
        }
        return this.fstrAneinanderZuordnung;
    }

    /**
     * Gets the value of the fstrDWeg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fstrDWeg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFstrDWeg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFstrDWeg }
     * 
     * 
     */
    public List<CFstrDWeg> getFstrDWeg() {
        if (fstrDWeg == null) {
            fstrDWeg = new ArrayList<CFstrDWeg>();
        }
        return this.fstrDWeg;
    }

    /**
     * Gets the value of the fstrDWegWKr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fstrDWegWKr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFstrDWegWKr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFstrDWegWKr }
     * 
     * 
     */
    public List<CFstrDWegWKr> getFstrDWegWKr() {
        if (fstrDWegWKr == null) {
            fstrDWegWKr = new ArrayList<CFstrDWegWKr>();
        }
        return this.fstrDWegWKr;
    }

    /**
     * Gets the value of the fstrFahrweg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fstrFahrweg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFstrFahrweg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFstrFahrweg }
     * 
     * 
     */
    public List<CFstrFahrweg> getFstrFahrweg() {
        if (fstrFahrweg == null) {
            fstrFahrweg = new ArrayList<CFstrFahrweg>();
        }
        return this.fstrFahrweg;
    }

    /**
     * Gets the value of the fstrNichthaltfall property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fstrNichthaltfall property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFstrNichthaltfall().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFstrNichthaltfall }
     * 
     * 
     */
    public List<CFstrNichthaltfall> getFstrNichthaltfall() {
        if (fstrNichthaltfall == null) {
            fstrNichthaltfall = new ArrayList<CFstrNichthaltfall>();
        }
        return this.fstrNichthaltfall;
    }

    /**
     * Gets the value of the fstrRangierFlaZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fstrRangierFlaZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFstrRangierFlaZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFstrRangierFlaZuordnung }
     * 
     * 
     */
    public List<CFstrRangierFlaZuordnung> getFstrRangierFlaZuordnung() {
        if (fstrRangierFlaZuordnung == null) {
            fstrRangierFlaZuordnung = new ArrayList<CFstrRangierFlaZuordnung>();
        }
        return this.fstrRangierFlaZuordnung;
    }

    /**
     * Gets the value of the fstrSignalisierung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fstrSignalisierung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFstrSignalisierung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFstrSignalisierung }
     * 
     * 
     */
    public List<CFstrSignalisierung> getFstrSignalisierung() {
        if (fstrSignalisierung == null) {
            fstrSignalisierung = new ArrayList<CFstrSignalisierung>();
        }
        return this.fstrSignalisierung;
    }

    /**
     * Gets the value of the fstrUmfahrpunkt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fstrUmfahrpunkt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFstrUmfahrpunkt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFstrUmfahrpunkt }
     * 
     * 
     */
    public List<CFstrUmfahrpunkt> getFstrUmfahrpunkt() {
        if (fstrUmfahrpunkt == null) {
            fstrUmfahrpunkt = new ArrayList<CFstrUmfahrpunkt>();
        }
        return this.fstrUmfahrpunkt;
    }

    /**
     * Gets the value of the fstrZugRangier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fstrZugRangier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFstrZugRangier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFstrZugRangier }
     * 
     * 
     */
    public List<CFstrZugRangier> getFstrZugRangier() {
        if (fstrZugRangier == null) {
            fstrZugRangier = new ArrayList<CFstrZugRangier>();
        }
        return this.fstrZugRangier;
    }

    /**
     * Gets the value of the geoKante property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geoKante property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGEOKante().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGEOKante }
     * 
     * 
     */
    public List<CGEOKante> getGEOKante() {
        if (geoKante == null) {
            geoKante = new ArrayList<CGEOKante>();
        }
        return this.geoKante;
    }

    /**
     * Gets the value of the geoKnoten property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geoKnoten property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGEOKnoten().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGEOKnoten }
     * 
     * 
     */
    public List<CGEOKnoten> getGEOKnoten() {
        if (geoKnoten == null) {
            geoKnoten = new ArrayList<CGEOKnoten>();
        }
        return this.geoKnoten;
    }

    /**
     * Gets the value of the geoPunkt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geoPunkt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGEOPunkt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGEOPunkt }
     * 
     * 
     */
    public List<CGEOPunkt> getGEOPunkt() {
        if (geoPunkt == null) {
            geoPunkt = new ArrayList<CGEOPunkt>();
        }
        return this.geoPunkt;
    }

    /**
     * Gets the value of the geschwindigkeitsprofil property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geschwindigkeitsprofil property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeschwindigkeitsprofil().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGeschwindigkeitsprofil }
     * 
     * 
     */
    public List<CGeschwindigkeitsprofil> getGeschwindigkeitsprofil() {
        if (geschwindigkeitsprofil == null) {
            geschwindigkeitsprofil = new ArrayList<CGeschwindigkeitsprofil>();
        }
        return this.geschwindigkeitsprofil;
    }

    /**
     * Gets the value of the gleisAbschluss property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gleisAbschluss property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGleisAbschluss().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGleisAbschluss }
     * 
     * 
     */
    public List<CGleisAbschluss> getGleisAbschluss() {
        if (gleisAbschluss == null) {
            gleisAbschluss = new ArrayList<CGleisAbschluss>();
        }
        return this.gleisAbschluss;
    }

    /**
     * Gets the value of the gleisAbschnitt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gleisAbschnitt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGleisAbschnitt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGleisAbschnitt }
     * 
     * 
     */
    public List<CGleisAbschnitt> getGleisAbschnitt() {
        if (gleisAbschnitt == null) {
            gleisAbschnitt = new ArrayList<CGleisAbschnitt>();
        }
        return this.gleisAbschnitt;
    }

    /**
     * Gets the value of the gleisArt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gleisArt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGleisArt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGleisArt }
     * 
     * 
     */
    public List<CGleisArt> getGleisArt() {
        if (gleisArt == null) {
            gleisArt = new ArrayList<CGleisArt>();
        }
        return this.gleisArt;
    }

    /**
     * Gets the value of the gleisBaubereich property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gleisBaubereich property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGleisBaubereich().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGleisBaubereich }
     * 
     * 
     */
    public List<CGleisBaubereich> getGleisBaubereich() {
        if (gleisBaubereich == null) {
            gleisBaubereich = new ArrayList<CGleisBaubereich>();
        }
        return this.gleisBaubereich;
    }

    /**
     * Gets the value of the gleisBezeichnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gleisBezeichnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGleisBezeichnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGleisBezeichnung }
     * 
     * 
     */
    public List<CGleisBezeichnung> getGleisBezeichnung() {
        if (gleisBezeichnung == null) {
            gleisBezeichnung = new ArrayList<CGleisBezeichnung>();
        }
        return this.gleisBezeichnung;
    }

    /**
     * Gets the value of the gleisFahrbahn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gleisFahrbahn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGleisFahrbahn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGleisFahrbahn }
     * 
     * 
     */
    public List<CGleisFahrbahn> getGleisFahrbahn() {
        if (gleisFahrbahn == null) {
            gleisFahrbahn = new ArrayList<CGleisFahrbahn>();
        }
        return this.gleisFahrbahn;
    }

    /**
     * Gets the value of the gleisLichtraum property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gleisLichtraum property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGleisLichtraum().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGleisLichtraum }
     * 
     * 
     */
    public List<CGleisLichtraum> getGleisLichtraum() {
        if (gleisLichtraum == null) {
            gleisLichtraum = new ArrayList<CGleisLichtraum>();
        }
        return this.gleisLichtraum;
    }

    /**
     * Gets the value of the gleisSchaltgruppe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gleisSchaltgruppe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGleisSchaltgruppe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CGleisSchaltgruppe }
     * 
     * 
     */
    public List<CGleisSchaltgruppe> getGleisSchaltgruppe() {
        if (gleisSchaltgruppe == null) {
            gleisSchaltgruppe = new ArrayList<CGleisSchaltgruppe>();
        }
        return this.gleisSchaltgruppe;
    }

    /**
     * Gets the value of the hoehenpunkt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hoehenpunkt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHoehenpunkt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CHoehenpunkt }
     * 
     * 
     */
    public List<CHoehenpunkt> getHoehenpunkt() {
        if (hoehenpunkt == null) {
            hoehenpunkt = new ArrayList<CHoehenpunkt>();
        }
        return this.hoehenpunkt;
    }

    /**
     * Gets the value of the markanterPunkt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the markanterPunkt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarkanterPunkt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CMarkanterPunkt }
     * 
     * 
     */
    public List<CMarkanterPunkt> getMarkanterPunkt() {
        if (markanterPunkt == null) {
            markanterPunkt = new ArrayList<CMarkanterPunkt>();
        }
        return this.markanterPunkt;
    }

    /**
     * Gets the value of the nb property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nb property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNB().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CNB }
     * 
     * 
     */
    public List<CNB> getNB() {
        if (nb == null) {
            nb = new ArrayList<CNB>();
        }
        return this.nb;
    }

    /**
     * Gets the value of the nbBedienAnzeigeElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nbBedienAnzeigeElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNBBedienAnzeigeElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CNBBedienAnzeigeElement }
     * 
     * 
     */
    public List<CNBBedienAnzeigeElement> getNBBedienAnzeigeElement() {
        if (nbBedienAnzeigeElement == null) {
            nbBedienAnzeigeElement = new ArrayList<CNBBedienAnzeigeElement>();
        }
        return this.nbBedienAnzeigeElement;
    }

    /**
     * Gets the value of the nbZone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nbZone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNBZone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CNBZone }
     * 
     * 
     */
    public List<CNBZone> getNBZone() {
        if (nbZone == null) {
            nbZone = new ArrayList<CNBZone>();
        }
        return this.nbZone;
    }

    /**
     * Gets the value of the nbZoneElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nbZoneElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNBZoneElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CNBZoneElement }
     * 
     * 
     */
    public List<CNBZoneElement> getNBZoneElement() {
        if (nbZoneElement == null) {
            nbZoneElement = new ArrayList<CNBZoneElement>();
        }
        return this.nbZoneElement;
    }

    /**
     * Gets the value of the nbZoneGrenze property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nbZoneGrenze property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNBZoneGrenze().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CNBZoneGrenze }
     * 
     * 
     */
    public List<CNBZoneGrenze> getNBZoneGrenze() {
        if (nbZoneGrenze == null) {
            nbZoneGrenze = new ArrayList<CNBZoneGrenze>();
        }
        return this.nbZoneGrenze;
    }

    /**
     * Gets the value of the oertlichkeit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oertlichkeit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOertlichkeit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COertlichkeit }
     * 
     * 
     */
    public List<COertlichkeit> getOertlichkeit() {
        if (oertlichkeit == null) {
            oertlichkeit = new ArrayList<COertlichkeit>();
        }
        return this.oertlichkeit;
    }

    /**
     * Gets the value of the proxyObjekt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proxyObjekt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProxyObjekt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CProxyObjekt }
     * 
     * 
     */
    public List<CProxyObjekt> getProxyObjekt() {
        if (proxyObjekt == null) {
            proxyObjekt = new ArrayList<CProxyObjekt>();
        }
        return this.proxyObjekt;
    }

    /**
     * Gets the value of the pzbElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pzbElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPZBElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CPZBElement }
     * 
     * 
     */
    public List<CPZBElement> getPZBElement() {
        if (pzbElement == null) {
            pzbElement = new ArrayList<CPZBElement>();
        }
        return this.pzbElement;
    }

    /**
     * Gets the value of the pzbElementZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pzbElementZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPZBElementZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CPZBElementZuordnung }
     * 
     * 
     */
    public List<CPZBElementZuordnung> getPZBElementZuordnung() {
        if (pzbElementZuordnung == null) {
            pzbElementZuordnung = new ArrayList<CPZBElementZuordnung>();
        }
        return this.pzbElementZuordnung;
    }

    /**
     * Gets the value of the pzbZuordnungSignal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pzbZuordnungSignal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPZBZuordnungSignal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CPZBZuordnungSignal }
     * 
     * 
     */
    public List<CPZBZuordnungSignal> getPZBZuordnungSignal() {
        if (pzbZuordnungSignal == null) {
            pzbZuordnungSignal = new ArrayList<CPZBZuordnungSignal>();
        }
        return this.pzbZuordnungSignal;
    }

    /**
     * Gets the value of the regelzeichnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regelzeichnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegelzeichnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CRegelzeichnung }
     * 
     * 
     */
    public List<CRegelzeichnung> getRegelzeichnung() {
        if (regelzeichnung == null) {
            regelzeichnung = new ArrayList<CRegelzeichnung>();
        }
        return this.regelzeichnung;
    }

    /**
     * Gets the value of the regelzeichnungParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regelzeichnungParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegelzeichnungParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CRegelzeichnungParameter }
     * 
     * 
     */
    public List<CRegelzeichnungParameter> getRegelzeichnungParameter() {
        if (regelzeichnungParameter == null) {
            regelzeichnungParameter = new ArrayList<CRegelzeichnungParameter>();
        }
        return this.regelzeichnungParameter;
    }

    /**
     * Gets the value of the schaltmittelFstrZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schaltmittelFstrZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchaltmittelFstrZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CSchaltmittelFstrZuordnung }
     * 
     * 
     */
    public List<CSchaltmittelFstrZuordnung> getSchaltmittelFstrZuordnung() {
        if (schaltmittelFstrZuordnung == null) {
            schaltmittelFstrZuordnung = new ArrayList<CSchaltmittelFstrZuordnung>();
        }
        return this.schaltmittelFstrZuordnung;
    }

    /**
     * Gets the value of the schaltmittelZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schaltmittelZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchaltmittelZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CSchaltmittelZuordnung }
     * 
     * 
     */
    public List<CSchaltmittelZuordnung> getSchaltmittelZuordnung() {
        if (schaltmittelZuordnung == null) {
            schaltmittelZuordnung = new ArrayList<CSchaltmittelZuordnung>();
        }
        return this.schaltmittelZuordnung;
    }

    /**
     * Gets the value of the schloss property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schloss property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchloss().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CSchloss }
     * 
     * 
     */
    public List<CSchloss> getSchloss() {
        if (schloss == null) {
            schloss = new ArrayList<CSchloss>();
        }
        return this.schloss;
    }

    /**
     * Gets the value of the schlosskombination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schlosskombination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchlosskombination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CSchlosskombination }
     * 
     * 
     */
    public List<CSchlosskombination> getSchlosskombination() {
        if (schlosskombination == null) {
            schlosskombination = new ArrayList<CSchlosskombination>();
        }
        return this.schlosskombination;
    }

    /**
     * Gets the value of the schluessel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schluessel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchluessel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CSchluessel }
     * 
     * 
     */
    public List<CSchluessel> getSchluessel() {
        if (schluessel == null) {
            schluessel = new ArrayList<CSchluessel>();
        }
        return this.schluessel;
    }

    /**
     * Gets the value of the schluesselsperre property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schluesselsperre property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchluesselsperre().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CSchluesselsperre }
     * 
     * 
     */
    public List<CSchluesselsperre> getSchluesselsperre() {
        if (schluesselsperre == null) {
            schluesselsperre = new ArrayList<CSchluesselsperre>();
        }
        return this.schluesselsperre;
    }

    /**
     * Gets the value of the signal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CSignal }
     * 
     * 
     */
    public List<CSignal> getSignal() {
        if (signal == null) {
            signal = new ArrayList<CSignal>();
        }
        return this.signal;
    }

    /**
     * Gets the value of the signalBefestigung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signalBefestigung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignalBefestigung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CSignalBefestigung }
     * 
     * 
     */
    public List<CSignalBefestigung> getSignalBefestigung() {
        if (signalBefestigung == null) {
            signalBefestigung = new ArrayList<CSignalBefestigung>();
        }
        return this.signalBefestigung;
    }

    /**
     * Gets the value of the signalRahmen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signalRahmen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignalRahmen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CSignalRahmen }
     * 
     * 
     */
    public List<CSignalRahmen> getSignalRahmen() {
        if (signalRahmen == null) {
            signalRahmen = new ArrayList<CSignalRahmen>();
        }
        return this.signalRahmen;
    }

    /**
     * Gets the value of the signalSignalbegriff property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signalSignalbegriff property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignalSignalbegriff().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CSignalSignalbegriff }
     * 
     * 
     */
    public List<CSignalSignalbegriff> getSignalSignalbegriff() {
        if (signalSignalbegriff == null) {
            signalSignalbegriff = new ArrayList<CSignalSignalbegriff>();
        }
        return this.signalSignalbegriff;
    }

    /**
     * Gets the value of the sonstigerPunkt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sonstigerPunkt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSonstigerPunkt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CSonstigerPunkt }
     * 
     * 
     */
    public List<CSonstigerPunkt> getSonstigerPunkt() {
        if (sonstigerPunkt == null) {
            sonstigerPunkt = new ArrayList<CSonstigerPunkt>();
        }
        return this.sonstigerPunkt;
    }

    /**
     * Gets the value of the stellBereich property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stellBereich property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStellBereich().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CStellBereich }
     * 
     * 
     */
    public List<CStellBereich> getStellBereich() {
        if (stellBereich == null) {
            stellBereich = new ArrayList<CStellBereich>();
        }
        return this.stellBereich;
    }

    /**
     * Gets the value of the stellelement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stellelement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStellelement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CStellelement }
     * 
     * 
     */
    public List<CStellelement> getStellelement() {
        if (stellelement == null) {
            stellelement = new ArrayList<CStellelement>();
        }
        return this.stellelement;
    }

    /**
     * Gets the value of the strecke property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the strecke property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStrecke().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CStrecke }
     * 
     * 
     */
    public List<CStrecke> getStrecke() {
        if (strecke == null) {
            strecke = new ArrayList<CStrecke>();
        }
        return this.strecke;
    }

    /**
     * Gets the value of the streckePunkt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the streckePunkt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStreckePunkt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CStreckePunkt }
     * 
     * 
     */
    public List<CStreckePunkt> getStreckePunkt() {
        if (streckePunkt == null) {
            streckePunkt = new ArrayList<CStreckePunkt>();
        }
        return this.streckePunkt;
    }

    /**
     * Gets the value of the technischerBereich property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the technischerBereich property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTechnischerBereich().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CTechnischerBereich }
     * 
     * 
     */
    public List<CTechnischerBereich> getTechnischerBereich() {
        if (technischerBereich == null) {
            technischerBereich = new ArrayList<CTechnischerBereich>();
        }
        return this.technischerBereich;
    }

    /**
     * Gets the value of the technischerPunkt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the technischerPunkt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTechnischerPunkt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CTechnischerPunkt }
     * 
     * 
     */
    public List<CTechnischerPunkt> getTechnischerPunkt() {
        if (technischerPunkt == null) {
            technischerPunkt = new ArrayList<CTechnischerPunkt>();
        }
        return this.technischerPunkt;
    }

    /**
     * Gets the value of the topKante property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topKante property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTOPKante().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CTOPKante }
     * 
     * 
     */
    public List<CTOPKante> getTOPKante() {
        if (topKante == null) {
            topKante = new ArrayList<CTOPKante>();
        }
        return this.topKante;
    }

    /**
     * Gets the value of the topKnoten property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topKnoten property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTOPKnoten().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CTOPKnoten }
     * 
     * 
     */
    public List<CTOPKnoten> getTOPKnoten() {
        if (topKnoten == null) {
            topKnoten = new ArrayList<CTOPKnoten>();
        }
        return this.topKnoten;
    }

    /**
     * Gets the value of the ueberhoehung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ueberhoehung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUeberhoehung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CUeberhoehung }
     * 
     * 
     */
    public List<CUeberhoehung> getUeberhoehung() {
        if (ueberhoehung == null) {
            ueberhoehung = new ArrayList<CUeberhoehung>();
        }
        return this.ueberhoehung;
    }

    /**
     * Gets the value of the uebertragungsweg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uebertragungsweg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUebertragungsweg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CUebertragungsweg }
     * 
     * 
     */
    public List<CUebertragungsweg> getUebertragungsweg() {
        if (uebertragungsweg == null) {
            uebertragungsweg = new ArrayList<CUebertragungsweg>();
        }
        return this.uebertragungsweg;
    }

    /**
     * Gets the value of the unterbringung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unterbringung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnterbringung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CUnterbringung }
     * 
     * 
     */
    public List<CUnterbringung> getUnterbringung() {
        if (unterbringung == null) {
            unterbringung = new ArrayList<CUnterbringung>();
        }
        return this.unterbringung;
    }

    /**
     * Gets the value of the wKrAnlage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wKrAnlage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWKrAnlage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CWKrAnlage }
     * 
     * 
     */
    public List<CWKrAnlage> getWKrAnlage() {
        if (wKrAnlage == null) {
            wKrAnlage = new ArrayList<CWKrAnlage>();
        }
        return this.wKrAnlage;
    }

    /**
     * Gets the value of the wKrGspElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wKrGspElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWKrGspElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CWKrGspElement }
     * 
     * 
     */
    public List<CWKrGspElement> getWKrGspElement() {
        if (wKrGspElement == null) {
            wKrGspElement = new ArrayList<CWKrGspElement>();
        }
        return this.wKrGspElement;
    }

    /**
     * Gets the value of the wKrGspKomponente property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wKrGspKomponente property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWKrGspKomponente().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CWKrGspKomponente }
     * 
     * 
     */
    public List<CWKrGspKomponente> getWKrGspKomponente() {
        if (wKrGspKomponente == null) {
            wKrGspKomponente = new ArrayList<CWKrGspKomponente>();
        }
        return this.wKrGspKomponente;
    }

    /**
     * Gets the value of the weichenlaufkette property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the weichenlaufkette property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWeichenlaufkette().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CWeichenlaufkette }
     * 
     * 
     */
    public List<CWeichenlaufkette> getWeichenlaufkette() {
        if (weichenlaufkette == null) {
            weichenlaufkette = new ArrayList<CWeichenlaufkette>();
        }
        return this.weichenlaufkette;
    }

    /**
     * Gets the value of the weichenlaufketteZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the weichenlaufketteZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWeichenlaufketteZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CWeichenlaufketteZuordnung }
     * 
     * 
     */
    public List<CWeichenlaufketteZuordnung> getWeichenlaufketteZuordnung() {
        if (weichenlaufketteZuordnung == null) {
            weichenlaufketteZuordnung = new ArrayList<CWeichenlaufketteZuordnung>();
        }
        return this.weichenlaufketteZuordnung;
    }

    /**
     * Gets the value of the zl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZL }
     * 
     * 
     */
    public List<CZL> getZL() {
        if (zl == null) {
            zl = new ArrayList<CZL>();
        }
        return this.zl;
    }

    /**
     * Gets the value of the zldlpAbschnitt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zldlpAbschnitt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZLDLPAbschnitt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZLDLPAbschnitt }
     * 
     * 
     */
    public List<CZLDLPAbschnitt> getZLDLPAbschnitt() {
        if (zldlpAbschnitt == null) {
            zldlpAbschnitt = new ArrayList<CZLDLPAbschnitt>();
        }
        return this.zldlpAbschnitt;
    }

    /**
     * Gets the value of the zldlpFstr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zldlpFstr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZLDLPFstr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZLDLPFstr }
     * 
     * 
     */
    public List<CZLDLPFstr> getZLDLPFstr() {
        if (zldlpFstr == null) {
            zldlpFstr = new ArrayList<CZLDLPFstr>();
        }
        return this.zldlpFstr;
    }

    /**
     * Gets the value of the zlFstr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zlFstr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZLFstr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZLFstr }
     * 
     * 
     */
    public List<CZLFstr> getZLFstr() {
        if (zlFstr == null) {
            zlFstr = new ArrayList<CZLFstr>();
        }
        return this.zlFstr;
    }

    /**
     * Gets the value of the zlFstrAnstoss property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zlFstrAnstoss property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZLFstrAnstoss().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZLFstrAnstoss }
     * 
     * 
     */
    public List<CZLFstrAnstoss> getZLFstrAnstoss() {
        if (zlFstrAnstoss == null) {
            zlFstrAnstoss = new ArrayList<CZLFstrAnstoss>();
        }
        return this.zlFstrAnstoss;
    }

    /**
     * Gets the value of the zlSignalgruppe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zlSignalgruppe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZLSignalgruppe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZLSignalgruppe }
     * 
     * 
     */
    public List<CZLSignalgruppe> getZLSignalgruppe() {
        if (zlSignalgruppe == null) {
            zlSignalgruppe = new ArrayList<CZLSignalgruppe>();
        }
        return this.zlSignalgruppe;
    }

    /**
     * Gets the value of the zlSignalgruppeZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zlSignalgruppeZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZLSignalgruppeZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZLSignalgruppeZuordnung }
     * 
     * 
     */
    public List<CZLSignalgruppeZuordnung> getZLSignalgruppeZuordnung() {
        if (zlSignalgruppeZuordnung == null) {
            zlSignalgruppeZuordnung = new ArrayList<CZLSignalgruppeZuordnung>();
        }
        return this.zlSignalgruppeZuordnung;
    }

    /**
     * Gets the value of the zlvBus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zlvBus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZLVBus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZLVBus }
     * 
     * 
     */
    public List<CZLVBus> getZLVBus() {
        if (zlvBus == null) {
            zlvBus = new ArrayList<CZLVBus>();
        }
        return this.zlvBus;
    }

    /**
     * Gets the value of the zlvBusUSZuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zlvBusUSZuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZLVBusUSZuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZLVBusUSZuordnung }
     * 
     * 
     */
    public List<CZLVBusUSZuordnung> getZLVBusUSZuordnung() {
        if (zlvBusUSZuordnung == null) {
            zlvBusUSZuordnung = new ArrayList<CZLVBusUSZuordnung>();
        }
        return this.zlvBusUSZuordnung;
    }

    /**
     * Gets the value of the zn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZN }
     * 
     * 
     */
    public List<CZN> getZN() {
        if (zn == null) {
            zn = new ArrayList<CZN>();
        }
        return this.zn;
    }

    /**
     * Gets the value of the znAkustik property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the znAkustik property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZNAkustik().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZNAkustik }
     * 
     * 
     */
    public List<CZNAkustik> getZNAkustik() {
        if (znAkustik == null) {
            znAkustik = new ArrayList<CZNAkustik>();
        }
        return this.znAkustik;
    }

    /**
     * Gets the value of the znAnzeigefeld property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the znAnzeigefeld property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZNAnzeigefeld().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZNAnzeigefeld }
     * 
     * 
     */
    public List<CZNAnzeigefeld> getZNAnzeigefeld() {
        if (znAnzeigefeld == null) {
            znAnzeigefeld = new ArrayList<CZNAnzeigefeld>();
        }
        return this.znAnzeigefeld;
    }

    /**
     * Gets the value of the znFortschaltKriterium property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the znFortschaltKriterium property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZNFortschaltKriterium().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZNFortschaltKriterium }
     * 
     * 
     */
    public List<CZNFortschaltKriterium> getZNFortschaltKriterium() {
        if (znFortschaltKriterium == null) {
            znFortschaltKriterium = new ArrayList<CZNFortschaltKriterium>();
        }
        return this.znFortschaltKriterium;
    }

    /**
     * Gets the value of the znTelegramm84Zuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the znTelegramm84Zuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZNTelegramm84Zuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZNTelegramm84Zuordnung }
     * 
     * 
     */
    public List<CZNTelegramm84Zuordnung> getZNTelegramm84Zuordnung() {
        if (znTelegramm84Zuordnung == null) {
            znTelegramm84Zuordnung = new ArrayList<CZNTelegramm84Zuordnung>();
        }
        return this.znTelegramm84Zuordnung;
    }

    /**
     * Gets the value of the znTelegramm85Zuordnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the znTelegramm85Zuordnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZNTelegramm85Zuordnung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZNTelegramm85Zuordnung }
     * 
     * 
     */
    public List<CZNTelegramm85Zuordnung> getZNTelegramm85Zuordnung() {
        if (znTelegramm85Zuordnung == null) {
            znTelegramm85Zuordnung = new ArrayList<CZNTelegramm85Zuordnung>();
        }
        return this.znTelegramm85Zuordnung;
    }

    /**
     * Gets the value of the znUnterstation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the znUnterstation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZNUnterstation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZNUnterstation }
     * 
     * 
     */
    public List<CZNUnterstation> getZNUnterstation() {
        if (znUnterstation == null) {
            znUnterstation = new ArrayList<CZNUnterstation>();
        }
        return this.znUnterstation;
    }

    /**
     * Gets the value of the znzbs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the znzbs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZNZBS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZNZBS }
     * 
     * 
     */
    public List<CZNZBS> getZNZBS() {
        if (znzbs == null) {
            znzbs = new ArrayList<CZNZBS>();
        }
        return this.znzbs;
    }

    /**
     * Gets the value of the zugeinwirkung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zugeinwirkung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZugeinwirkung().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CZugeinwirkung }
     * 
     * 
     */
    public List<CZugeinwirkung> getZugeinwirkung() {
        if (zugeinwirkung == null) {
            zugeinwirkung = new ArrayList<CZugeinwirkung>();
        }
        return this.zugeinwirkung;
    }

}
