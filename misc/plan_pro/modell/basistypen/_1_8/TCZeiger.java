//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.basistypen._1_8;

import modell.verweise._1_8.*;

import javax.xml.bind.annotation.*;


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
 *     &lt;extension base="{http://www.plan-pro.org/modell/BasisTypen/1.8.0}CBasisAttribut">
 *       &lt;sequence>
 *         &lt;element name="Wert" type="{http://www.plan-pro.org/modell/BasisTypen/1.8.0}TGUID"/>
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
    TCIDMarkanteStelle.class,
    TCIDUebertragungswegNach.class,
    TCIDFMAKomponente.class,
    TCIDFMAAnlage.class,
    TCIDBUESchnittstelle.class,
    TCIDBlockAnlage.class,
    TCIDAbhaengigesElement.class,
    TCIDFortschaltungStart.class,
    TCIDESTWZentraleinheit.class,
    TCIDMarkanterPunkt.class,
    TCIDFstrDWeg.class,
    TCIDAnforderung.class,
    TCIDGrenzzeichen.class,
    TCIDBUEBedienAnzeigeElement.class,
    TCIDBedienAnzeigeElement.class,
    TCIDZNFortschaltKriterium.class,
    TCIDPZBElementBezugspunkt.class,
    TCIDFstrAneinander.class,
    TCIDGEOArt.class,
    TCIDVerknuepftesElement.class,
    TCIDSchluesselsperre.class,
    TCIDGrenzelement.class,
    TCIDPZBElementZuordnung.class,
    TCIDBlockElement.class,
    TCIDSchlosskombination.class,
    TCIDZLSignalgruppe.class,
    TCIDNB.class,
    TCIDPlanungEinzel.class,
    TCIDSchalter.class,
    TCIDFstrFahrweg.class,
    TCIDBeginnBereich.class,
    TCIDZLDLPFstr.class,
    TCIDTOPKante.class,
    TCIDSchluessel.class,
    TCIDGEOPunkt.class,
    TCIDUebertragungswegVon.class,
    TCIDAnhang.class,
    TCIDBUEAnlage.class,
    TCIDBasisObjekt.class,
    TCIDBedienBezirk.class,
    TCIDUrObjekt.class,
    TCIDZLFstr.class,
    TCIDStrecke.class,
    TCIDBUEEinschaltung.class,
    TCIDSignal.class,
    TCIDWeichenlaufkette.class,
    TCIDBlockStrecke.class,
    TCIDPlanProSchnittstelle.class,
    TCIDElement.class,
    TCIDTOPKnoten.class,
    TCIDOertlichkeitProxy.class,
    TCIDSchaltmittelZuordnung.class,
    TCIDAussenelementansteuerung.class,
    TCIDZugeinwirkung.class,
    TCIDEnergiePrimaer.class,
    TCIDWKrAnlage.class,
    TCIDBahnsteigKante.class,
    TCIDBUEGleisbezogenerGefahrraum.class,
    TCIDPlanungsgrundlage.class,
    TCIDOertlichkeit.class,
    TCIDZNZBS.class,
    TCIDFlaSchutz.class,
    TCIDEinschaltpunkt.class,
    TCIDBUEWSFstrZuordnung.class,
    TCIDStellelement.class,
    TCIDWKrGspElement.class,
    TCIDAnfordererElement.class,
    TCIDGleisAbschnitt.class,
    TCIDZNUnterstation.class,
    TCIDUnterbringung.class,
    TCIDNBElement.class,
    TCIDRegelzeichnung.class,
    TCIDZL.class,
    TCIDGEOKnoten.class,
    TCIDBahnsteigAnlage.class,
    TCIDFstrZugRangier.class,
    TCIDZN.class,
    TCIDZLVBus.class,
    TCIDBedienOberflaeche.class,
    TCIDWKrGspKomponente.class,
    TCIDBedienZentrale.class,
    TCIDStreckePunkt.class,
    TCIDBearbeitungsvermerk.class,
    TCIDZNAnzeigefeld.class,
    TCIDUmfahrpunkt.class,
    TCIDSignalRahmen.class,
    TCIDSignalBefestigung.class,
    TCIDZNAnzeigefeldAnstoss.class,
    TCIDStellwerk.class,
    TCIDGleisBezeichnung.class,
    TCIDFMAElement.class,
    TCIDHandschaltWirkfunktion.class,
    TCIDZiel.class,
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
