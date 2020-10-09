//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.medien_und_trassen._1_9_0;

import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.verweise._1_9_0.TCIDUnterbringung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Punktf�rmige Installation zur Aufteilung bzw. Verschaltung von Kabeln (ohne Intelligenz).
 * 
 * <p>Java-Klasse f�r CKabel_Verteilpunkt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CKabel_Verteilpunkt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plan-pro.org/modell/Basisobjekte/1.9.0.2}CBasis_Objekt">
 *       &lt;sequence>
 *         &lt;element name="Bezeichnung" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}CKabel_Verteilpunkt_Bezeichnung"/>
 *         &lt;element name="ID_Unterbringung" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_Unterbringung"/>
 *         &lt;element name="Kabel_Verteilpunkt_Art" type="{http://www.plan-pro.org/modell/Medien_und_Trassen/1.9.0.2}TCKabel_Verteilpunkt_Art"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CKabel_Verteilpunkt", propOrder = {
    "bezeichnung",
    "idUnterbringung",
    "kabelVerteilpunktArt"
})
public class CKabelVerteilpunkt
    extends CBasisObjekt
{

    @XmlElement(name = "Bezeichnung", required = true)
    protected CKabelVerteilpunktBezeichnung bezeichnung;
    @XmlElement(name = "ID_Unterbringung", required = true)
    protected TCIDUnterbringung idUnterbringung;
    @XmlElement(name = "Kabel_Verteilpunkt_Art", required = true)
    protected TCKabelVerteilpunktArt kabelVerteilpunktArt;

    /**
     * Ruft den Wert der bezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CKabelVerteilpunktBezeichnung }
     *     
     */
    public CKabelVerteilpunktBezeichnung getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Legt den Wert der bezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CKabelVerteilpunktBezeichnung }
     *     
     */
    public void setBezeichnung(CKabelVerteilpunktBezeichnung value) {
        this.bezeichnung = value;
    }

    /**
     * Ruft den Wert der idUnterbringung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public TCIDUnterbringung getIDUnterbringung() {
        return idUnterbringung;
    }

    /**
     * Legt den Wert der idUnterbringung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDUnterbringung }
     *     
     */
    public void setIDUnterbringung(TCIDUnterbringung value) {
        this.idUnterbringung = value;
    }

    /**
     * Ruft den Wert der kabelVerteilpunktArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKabelVerteilpunktArt }
     *     
     */
    public TCKabelVerteilpunktArt getKabelVerteilpunktArt() {
        return kabelVerteilpunktArt;
    }

    /**
     * Legt den Wert der kabelVerteilpunktArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKabelVerteilpunktArt }
     *     
     */
    public void setKabelVerteilpunktArt(TCKabelVerteilpunktArt value) {
        this.kabelVerteilpunktArt = value;
    }

}
