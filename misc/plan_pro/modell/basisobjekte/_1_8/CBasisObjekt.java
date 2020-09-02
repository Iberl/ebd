//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.basisobjekte._1_8;

import modell.ansteuerung_element._1_8.*;
import modell.bahnsteig._1_8.CBahnsteigAnlage;
import modell.bahnuebergang._1_8.*;
import modell.bedienung._1_8.*;
import modell.block._1_8.CBlockAnlage;
import modell.block._1_8.CBlockElement;
import modell.block._1_8.CBlockStrecke;
import modell.fahrstrasse._1_8.*;
import modell.flankenschutz._1_8.CFlaFreimeldeZuordnung;
import modell.flankenschutz._1_8.CFlaSchutz;
import modell.flankenschutz._1_8.CFlaZwieschutz;
import modell.geodaten._1_8.*;
import modell.nahbedienbereich._1_8.CNB;
import modell.nahbedienbereich._1_8.CNBBedienAnzeigeElement;
import modell.nahbedienbereich._1_8.CNBZone;
import modell.nahbedienbereich._1_8.CNBZoneElement;
import modell.ortung._1_8.CFMAAnlage;
import modell.ortung._1_8.CSchaltmittelZuordnung;
import modell.pzb._1_8.CPZBElementZuordnung;
import modell.pzb._1_8.CPZBZuordnungSignal;
import modell.regelzeichnung._1_8.CRegelzeichnung;
import modell.regelzeichnung._1_8.CRegelzeichnungParameter;
import modell.schluesselabhaengigkeiten._1_8.CSchloss;
import modell.schluesselabhaengigkeiten._1_8.CSchlosskombination;
import modell.schluesselabhaengigkeiten._1_8.CSchluessel;
import modell.schluesselabhaengigkeiten._1_8.CSchluesselsperre;
import modell.signale._1_8.CSignalRahmen;
import modell.signale._1_8.CSignalSignalbegriff;
import modell.verweise._1_8.TCIDBearbeitungsvermerk;
import modell.weichen_und_gleissperren._1_8.CWKrAnlage;
import modell.weichen_und_gleissperren._1_8.CWKrGspElement;
import modell.weichen_und_gleissperren._1_8.CWeichenlaufkette;
import modell.weichen_und_gleissperren._1_8.CWeichenlaufketteZuordnung;
import modell.zuglenkung._1_8.*;
import modell.zugnummernmeldeanlage._1_8.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Allen Modell-Objekten zugrundeliegendes Objekt, welches gemeinsame Eigenschaften definiert. In den Basisobjekten werden grunds�tzliche Eigenschaften definiert, die allen Objekten gemein sind. Alle im Datenmodell definierten LST-Objekte erben diese Eigenschaften unmittelbar, wie z.B. die Regelzeichnung, oder mittelbar, z.B. �ber das Punkt Objekt.
 * 
 * <p>Java-Klasse f�r CBasis_Objekt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBasis_Objekt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Basis_Objekt_Allg" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CBasis_Objekt_Allg"/>
 *         &lt;element name="ID_Bearbeitungsvermerk" type="{http://www.plan-pro.org/modell/Verweise/1.8.0}TCID_Bearbeitungsvermerk" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Objektreferenzen" type="{http://www.plan-pro.org/modell/Basisobjekte/1.8.0}CObjektreferenzen" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBasis_Objekt", propOrder = {
    "basisObjektAllg",
    "idBearbeitungsvermerk",
    "objektreferenzen"
})
@XmlSeeAlso({
    CAussenelementansteuerung.class,
    CUebertragungsweg.class,
    CStellelement.class,
    CUnterbringung.class,
    CESTWZentraleinheit.class,
    CBahnsteigAnlage.class,
    CBUEDeckendesSignalZuordnung.class,
    CSchaltmittelFstrZuordnung.class,
    CBUEEinschaltungZuordnung.class,
    CBUEBedienAnzeigeElement.class,
    CBUEWSFstrZuordnung.class,
    CBUESpezifischesSignal.class,
    CBUESchnittstelle.class,
    CBUEEinschaltung.class,
    CBUEAusschaltung.class,
    CBedienZentrale.class,
    CBedienAnzeigeElement.class,
    CBedienBezirk.class,
    CBedienGBT.class,
    CBedienEinrichtungOertlich.class,
    CBedienOberflaeche.class,
    CBedienAnrueckabschnitt.class,
    CBedienOertlichkeit.class,
    CBedienPlatz.class,
    CBedienOberflaecheBild.class,
    CBlockStrecke.class,
    CBlockAnlage.class,
    CBlockElement.class,
    CFstrRangierFlaZuordnung.class,
    CFstrNichthaltfall.class,
    CFstrSignalisierung.class,
    CMarkanterPunkt.class,
    CFstrZugRangier.class,
    CFstrUmfahrpunkt.class,
    CFstrAneinander.class,
    CFstrAneinanderZuordnung.class,
    CFstrDWegWKr.class,
    CFstrAbhaengigkeit.class,
    CFstrDWeg.class,
    CFlaFreimeldeZuordnung.class,
    CFlaZwieschutz.class,
    CFlaSchutz.class,
    CStreckePunkt.class,
    CTOPKnoten.class,
    CGEOPunkt.class,
    CTOPKante.class,
    CGEOKante.class,
    COertlichkeit.class,
    CGEOKnoten.class,
    CBereichObjekt.class,
    CNBBedienAnzeigeElement.class,
    CNBZone.class,
    CNBZoneElement.class,
    CNB.class,
    CFMAAnlage.class,
    CSchaltmittelZuordnung.class,
    CZNTelegramm85Zuordnung.class,
    CZLVBus.class,
    CZNFortschaltKriterium.class,
    CZNAkustik.class,
    CZNTelegramm84Zuordnung.class,
    CZNAnzeigefeld.class,
    CZN.class,
    CZNUnterstation.class,
    CZLVBusUSZuordnung.class,
    CZNZBS.class,
    CZLFstrAnstoss.class,
    CZLSignalgruppe.class,
    CZLFstr.class,
    CZLSignalgruppeZuordnung.class,
    CZLDLPFstr.class,
    CZL.class,
    CZLDLPAbschnitt.class,
    CWeichenlaufkette.class,
    CWKrGspElement.class,
    CWKrAnlage.class,
    CWeichenlaufketteZuordnung.class,
    CSignalSignalbegriff.class,
    CSignalRahmen.class,
    CSchloss.class,
    CSchluessel.class,
    CSchlosskombination.class,
    CSchluesselsperre.class,
    CRegelzeichnungParameter.class,
    CRegelzeichnung.class,
    CPZBZuordnungSignal.class,
    CPZBElementZuordnung.class,
    CPunktObjekt.class
})
public abstract class CBasisObjekt
    extends CUrObjekt
{

    @XmlElement(name = "Basis_Objekt_Allg", required = true)
    protected CBasisObjektAllg basisObjektAllg;
    @XmlElement(name = "ID_Bearbeitungsvermerk")
    protected List<TCIDBearbeitungsvermerk> idBearbeitungsvermerk;
    @XmlElement(name = "Objektreferenzen")
    protected CObjektreferenzen objektreferenzen;

    /**
     * Ruft den Wert der basisObjektAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CBasisObjektAllg }
     *     
     */
    public CBasisObjektAllg getBasisObjektAllg() {
        return basisObjektAllg;
    }

    /**
     * Legt den Wert der basisObjektAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CBasisObjektAllg }
     *     
     */
    public void setBasisObjektAllg(CBasisObjektAllg value) {
        this.basisObjektAllg = value;
    }

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

    /**
     * Ruft den Wert der objektreferenzen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CObjektreferenzen }
     *     
     */
    public CObjektreferenzen getObjektreferenzen() {
        return objektreferenzen;
    }

    /**
     * Legt den Wert der objektreferenzen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CObjektreferenzen }
     *     
     */
    public void setObjektreferenzen(CObjektreferenzen value) {
        this.objektreferenzen = value;
    }

}
