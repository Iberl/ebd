//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basistypen._1_9_0;

import plan_pro.modell.verweise._1_9_0.*;

import jakarta.xml.bind.annotation.*;


/**
 * Typklasse, von der alle spezifischen Zeiger im Modell abgeleitet sind. Spezifische Zeiger werden verwendet, um einen Verweis von einem Objekt auf ein anderes Objekt zu modellieren. Dazu wird technisch auf die GUID des Zielobjektes referenziert.
 * 
 * <p>Java-Klasse f�r TCZeiger complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TCZeiger">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}CBasisAttribut">
 *       &lt;sequence>
 *         &lt;element name="Wert" type="{http://www.plan-pro.org/modell/BasisTypen/1.9.0.2}TGUID"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCZeiger", propOrder = {
    "wert"
})
@XmlSeeAlso({
    TCIDSignalSignalbegriff.class,
    TCIDSonderanlage.class,
    TCIDMarkanteStelle.class,
    TCIDLOEinbau.class,
    TCIDUebertragungswegNach.class,
    TCIDBaliseOhneProxy.class,
    TCIDUeberhoehung.class,
    TCIDLEUAnlage.class,
    TCIDFMAKomponente.class,
    TCIDFMAAnlage.class,
    TCIDBUESchnittstelle.class,
    TCIDBlockAnlage.class,
    TCIDFortschaltungStart.class,
    TCIDDatenpunktOhneProxy.class,
    TCIDESTWZentraleinheit.class,
    TCIDMarkanterPunkt.class,
    TCIDFstrDWeg.class,
    TCIDSignalOhneProxy.class,
    TCIDAnforderung.class,
    TCIDWKrAnlageOhneProxy.class,
    TCIDLEUSchaltkastenOhneProxy.class,
    TCIDGrenzzeichen.class,
    TCIDGFRAnlageOhneProxy.class,
    TCIDBUEBedienAnzeigeElement.class,
    TCIDFMAAnlageRangierFrei.class,
    TCIDBedienAnzeigeElement.class,
    TCIDZNFortschaltKriterium.class,
    TCIDQuellelement.class,
    TCIDPZBElementBezugspunkt.class,
    TCIDFstrAneinander.class,
    TCIDGEOArt.class,
    TCIDHoehenpunkt.class,
    TCIDVerknuepftesElement.class,
    TCIDDPBezugspunkt.class,
    TCIDFTFahrwegTeil.class,
    TCIDSchluesselsperre.class,
    TCIDZweitesHaltfallkriterium.class,
    TCIDPZBElementZuordnung.class,
    TCIDBlockElement.class,
    TCIDGEOPunktOhneProxy.class,
    TCIDSchlosskombination.class,
    TCIDZLSignalgruppe.class,
    TCIDNB.class,
    TCIDSignalFank.class,
    TCIDPlanungEinzel.class,
    TCIDSchalter.class,
    TCIDFstrFahrweg.class,
    TCIDElementGrenze.class,
    TCIDTrasseKnoten.class,
    TCIDBedienStandort.class,
    TCIDBeginnBereich.class,
    TCIDZLDLPFstr.class,
    TCIDTOPKante.class,
    TCIDAnhangOhneProxy.class,
    TCIDSchluessel.class,
    TCIDGEOPunkt.class,
    TCIDUebertragungswegVon.class,
    TCIDAnhang.class,
    TCIDUnterbringungTechnik.class,
    TCIDBUEAnlage.class,
    TCIDBasisObjekt.class,
    TCIDBedienBezirk.class,
    TCIDUrObjekt.class,
    TCIDLEUBezugspunkt.class,
    TCIDZLFstr.class,
    TCIDStrecke.class,
    TCIDETCSKnotenOhneProxy.class,
    TCIDFachtelegramm.class,
    TCIDBUEEinschaltung.class,
    TCIDAusgabeFachdatenOhneProxy.class,
    TCIDSignal.class,
    TCIDSignalGleisbezechnung.class,
    TCIDWeichenlaufkette.class,
    TCIDBlockStrecke.class,
    TCIDPlanProSchnittstelle.class,
    TCIDElement.class,
    TCIDTOPKnoten.class,
    TCIDOertlichkeitProxy.class,
    TCIDSchaltmittelZuordnung.class,
    TCIDBUEAnlageOhneProxy.class,
    TCIDAussenelementansteuerung.class,
    TCIDAnschlussElement.class,
    TCIDZugeinwirkung.class,
    TCIDElementUnterbringung.class,
    TCIDEnergiePrimaer.class,
    TCIDWKrAnlage.class,
    TCIDBahnsteigKante.class,
    TCIDBUEGleisbezogenerGefahrraum.class,
    TCIDFTAnschaltbedingung.class,
    TCIDPlanungsgrundlage.class,
    TCIDGeraetProgrammiert.class,
    TCIDPZBElementMitnutzung.class,
    TCIDEnergieEingang.class,
    TCIDOertlichkeit.class,
    TCIDZNZBS.class,
    TCIDETCSKnoten.class,
    TCIDFlaSchutz.class,
    TCIDEinschaltpunkt.class,
    TCIDTechnischerPunkt.class,
    TCIDBUEWSFstrZuordnung.class,
    TCIDBalise.class,
    TCIDStellelement.class,
    TCIDWKrGspElement.class,
    TCIDAnfordererElement.class,
    TCIDGleisAbschnitt.class,
    TCIDZNUnterstation.class,
    TCIDRBC.class,
    TCIDTrasseKante.class,
    TCIDDatenpunkt.class,
    TCIDUnterbringung.class,
    TCIDNBElement.class,
    TCIDFstrAusschlussBesonders.class,
    TCIDRegelzeichnung.class,
    TCIDZL.class,
    TCIDGEOKnoten.class,
    TCIDBahnsteigKanteOhneProxy.class,
    TCIDBahnsteigAnlage.class,
    TCIDFstrZugRangier.class,
    TCIDZN.class,
    TCIDZLVBus.class,
    TCIDBedienOberflaeche.class,
    TCIDWKrGspKomponente.class,
    TCIDBedienZentrale.class,
    TCIDSignalStart.class,
    TCIDStreckePunkt.class,
    TCIDBearbeitungsvermerk.class,
    TCIDZNAnzeigefeld.class,
    TCIDUmfahrpunkt.class,
    TCIDLEUAnlageOhneProxy.class,
    TCIDUnterbringungOhneProxy.class,
    TCIDSignalRahmen.class,
    TCIDSignalBefestigung.class,
    TCIDTOPKanteOhneProxy.class,
    TCIDZNAnzeigefeldAnstoss.class,
    TCIDStellwerk.class,
    TCIDBinaerdateiOhneProxy.class,
    TCIDGleisBezeichnung.class,
    TCIDFMAElement.class,
    TCIDHandschaltWirkfunktion.class,
    TCIDEVModul.class,
    TCIDZiel.class,
    TCIDInformationEingang.class,
    TCIDPZBElement.class,
    TCIDNBZone.class,
    TCIDInformationPrimaer.class,
    TCIDBedienEinrichtungOertlich.class
})
public class TCZeiger
    extends CBasisAttribut
{

    @XmlElement(name = "Wert", required = true, nillable = true)
    protected String wert;

    /**
     * Ruft den Wert der wert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWert() {
        return wert;
    }

    /**
     * Legt den Wert der wert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWert(String value) {
        this.wert = value;
    }

}
