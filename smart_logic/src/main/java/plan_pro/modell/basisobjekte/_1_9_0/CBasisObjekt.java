//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import plan_pro.modell.ansteuerung_element._1_9_0.*;
import plan_pro.modell.bahnsteig._1_9_0.CBahnsteigAnlage;
import plan_pro.modell.bahnuebergang._1_9_0.*;
import plan_pro.modell.balisentechnik_etcs._1_9_0.*;
import plan_pro.modell.bedienung._1_9_0.*;
import plan_pro.modell.block._1_9_0.CBlockAnlage;
import plan_pro.modell.block._1_9_0.CBlockElement;
import plan_pro.modell.block._1_9_0.CBlockStrecke;
import plan_pro.modell.fahrstrasse._1_9_0.*;
import plan_pro.modell.flankenschutz._1_9_0.CFlaFreimeldeZuordnung;
import plan_pro.modell.flankenschutz._1_9_0.CFlaSchutz;
import plan_pro.modell.flankenschutz._1_9_0.CFlaZwieschutz;
import plan_pro.modell.geodaten._1_9_0.*;
import plan_pro.modell.medien_und_trassen._1_9_0.CKabel;
import plan_pro.modell.medien_und_trassen._1_9_0.CKabelVerteilpunkt;
import plan_pro.modell.medien_und_trassen._1_9_0.CTrasseKante;
import plan_pro.modell.medien_und_trassen._1_9_0.CTrasseKnoten;
import plan_pro.modell.nahbedienbereich._1_9_0.*;
import plan_pro.modell.ortung._1_9_0.CFMAAnlage;
import plan_pro.modell.ortung._1_9_0.CSchaltmittelZuordnung;
import plan_pro.modell.pzb._1_9_0.CPZBElementZuordnung;
import plan_pro.modell.pzb._1_9_0.CPZBZuordnungSignal;
import plan_pro.modell.regelzeichnung._1_9_0.CRegelzeichnung;
import plan_pro.modell.regelzeichnung._1_9_0.CRegelzeichnungParameter;
import plan_pro.modell.schluesselabhaengigkeiten._1_9_0.CSchloss;
import plan_pro.modell.schluesselabhaengigkeiten._1_9_0.CSchlosskombination;
import plan_pro.modell.schluesselabhaengigkeiten._1_9_0.CSchluessel;
import plan_pro.modell.schluesselabhaengigkeiten._1_9_0.CSchluesselsperre;
import plan_pro.modell.signale._1_9_0.CSignalFankZuordnung;
import plan_pro.modell.signale._1_9_0.CSignalRahmen;
import plan_pro.modell.signale._1_9_0.CSignalSignalbegriff;
import plan_pro.modell.verweise._1_9_0.TCIDBearbeitungsvermerk;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrAnlage;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspElement;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWeichenlaufkette;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWeichenlaufketteZuordnung;
import plan_pro.modell.zuglenkung._1_9_0.*;
import plan_pro.modell.zugnummernmeldeanlage._1_9_0.*;

import jakarta.xml.bind.annotation.*;
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
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CUr_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Basis_Objekt_Allg" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt_Allg"/>
 *         &lt;element name="ID_Bearbeitungsvermerk" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Bearbeitungsvermerk" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Objektreferenzen" type="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CObjektreferenzen" minOccurs="0"/>
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
    CTechnikStandort.class,
    CLieferobjekt.class,
    CBahnsteigAnlage.class,
    CBUEBedienAnzeigeElement.class,
    CGFRElement.class,
    CGFRAnlage.class,
    CVerkehrszeichen.class,
    CSchaltmittelFstrZuordnung.class,
    CBUESpezifischesSignal.class,
    CBUESchnittstelle.class,
    CBUEAusschaltung.class,
    CBUEKreuzungsplan.class,
    CBUEEinschaltungZuordnung.class,
    CBUEEinschaltung.class,
    CBUEDeckendesSignalZuordnung.class,
    CBUEWSFstrZuordnung.class,
    CBUEAnlageV.class,
    CBUEAnlageStrasse.class,
    CEVModul.class,
    CETCSKante.class,
    CETCSKnoten.class,
    CFTAnschaltbedingung.class,
    CRBC.class,
    CLuftTelegramm.class,
    CBalise.class,
    CDatenpunktLink.class,
    CBinaerdatei.class,
    CLEUSchaltkasten.class,
    CFachtelegramm.class,
    CLEUModul.class,
    CFTFahrwegTeil.class,
    CETCSWKr.class,
    CProgDateiGruppe.class,
    CLEUAnlage.class,
    CETCSSignal.class,
    CBedienZentrale.class,
    CBedienStandort.class,
    CBedienAnzeigeElement.class,
    CBedienGBT.class,
    CBedienEinrichtungOertlich.class,
    CBedienOberflaeche.class,
    CBedienAnrueckabschnitt.class,
    CBedienOertlichkeit.class,
    CBedienPlatz.class,
    CBedienBezirk.class,
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
    CHoehenlinie.class,
    CUeberhoehungslinie.class,
    CTOPKante.class,
    COertlichkeit.class,
    CGEOKnoten.class,
    CGEOKante.class,
    CBereichObjekt.class,
    CKabel.class,
    CTrasseKnoten.class,
    CTrasseKante.class,
    CKabelVerteilpunkt.class,
    CNBBedienAnzeigeElement.class,
    CNBZone.class,
    CNBZoneGrenze.class,
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
    CSignalSignalbegriff.class,
    CSignalFankZuordnung.class,
    CSignalRahmen.class,
    CSchloss.class,
    CSchluessel.class,
    CSchlosskombination.class,
    CSchluesselsperre.class,
    CRegelzeichnungParameter.class,
    CRegelzeichnung.class,
    CPZBZuordnungSignal.class,
    CPZBElementZuordnung.class,
    CWeichenlaufkette.class,
    CWKrGspElement.class,
    CWKrAnlage.class,
    CWeichenlaufketteZuordnung.class,
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
