//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CAEA_GFK_IP_Adressblock complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAEA_GFK_IP_Adressblock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GFK_Kategorie" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCGFK_Kategorie"/>
 *         &lt;element name="IP_Adressblock_Blau_V4" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCIP_Adressblock_Blau_V4"/>
 *         &lt;element name="IP_Adressblock_Blau_V6" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCIP_Adressblock_Blau_V6"/>
 *         &lt;element name="IP_Adressblock_Grau_V4" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCIP_Adressblock_Grau_V4"/>
 *         &lt;element name="IP_Adressblock_Grau_V6" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCIP_Adressblock_Grau_V6"/>
 *         &lt;element name="Regionalbereich" type="{http://www.plan-pro.org/modell/Ansteuerung_Element/1.9.0.2}TCRegionalbereich"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAEA_GFK_IP_Adressblock", propOrder = {
    "gfkKategorie",
    "ipAdressblockBlauV4",
    "ipAdressblockBlauV6",
    "ipAdressblockGrauV4",
    "ipAdressblockGrauV6",
    "regionalbereich"
})
public class CAEAGFKIPAdressblock {

    @XmlElement(name = "GFK_Kategorie", required = true)
    protected TCGFKKategorie gfkKategorie;
    @XmlElement(name = "IP_Adressblock_Blau_V4", required = true)
    protected TCIPAdressblockBlauV4 ipAdressblockBlauV4;
    @XmlElement(name = "IP_Adressblock_Blau_V6", required = true)
    protected TCIPAdressblockBlauV6 ipAdressblockBlauV6;
    @XmlElement(name = "IP_Adressblock_Grau_V4", required = true)
    protected TCIPAdressblockGrauV4 ipAdressblockGrauV4;
    @XmlElement(name = "IP_Adressblock_Grau_V6", required = true)
    protected TCIPAdressblockGrauV6 ipAdressblockGrauV6;
    @XmlElement(name = "Regionalbereich", required = true)
    protected TCRegionalbereich regionalbereich;

    /**
     * Ruft den Wert der gfkKategorie-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGFKKategorie }
     *     
     */
    public TCGFKKategorie getGFKKategorie() {
        return gfkKategorie;
    }

    /**
     * Legt den Wert der gfkKategorie-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGFKKategorie }
     *     
     */
    public void setGFKKategorie(TCGFKKategorie value) {
        this.gfkKategorie = value;
    }

    /**
     * Ruft den Wert der ipAdressblockBlauV4-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIPAdressblockBlauV4 }
     *     
     */
    public TCIPAdressblockBlauV4 getIPAdressblockBlauV4() {
        return ipAdressblockBlauV4;
    }

    /**
     * Legt den Wert der ipAdressblockBlauV4-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIPAdressblockBlauV4 }
     *     
     */
    public void setIPAdressblockBlauV4(TCIPAdressblockBlauV4 value) {
        this.ipAdressblockBlauV4 = value;
    }

    /**
     * Ruft den Wert der ipAdressblockBlauV6-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIPAdressblockBlauV6 }
     *     
     */
    public TCIPAdressblockBlauV6 getIPAdressblockBlauV6() {
        return ipAdressblockBlauV6;
    }

    /**
     * Legt den Wert der ipAdressblockBlauV6-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIPAdressblockBlauV6 }
     *     
     */
    public void setIPAdressblockBlauV6(TCIPAdressblockBlauV6 value) {
        this.ipAdressblockBlauV6 = value;
    }

    /**
     * Ruft den Wert der ipAdressblockGrauV4-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIPAdressblockGrauV4 }
     *     
     */
    public TCIPAdressblockGrauV4 getIPAdressblockGrauV4() {
        return ipAdressblockGrauV4;
    }

    /**
     * Legt den Wert der ipAdressblockGrauV4-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIPAdressblockGrauV4 }
     *     
     */
    public void setIPAdressblockGrauV4(TCIPAdressblockGrauV4 value) {
        this.ipAdressblockGrauV4 = value;
    }

    /**
     * Ruft den Wert der ipAdressblockGrauV6-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIPAdressblockGrauV6 }
     *     
     */
    public TCIPAdressblockGrauV6 getIPAdressblockGrauV6() {
        return ipAdressblockGrauV6;
    }

    /**
     * Legt den Wert der ipAdressblockGrauV6-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIPAdressblockGrauV6 }
     *     
     */
    public void setIPAdressblockGrauV6(TCIPAdressblockGrauV6 value) {
        this.ipAdressblockGrauV6 = value;
    }

    /**
     * Ruft den Wert der regionalbereich-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRegionalbereich }
     *     
     */
    public TCRegionalbereich getRegionalbereich() {
        return regionalbereich;
    }

    /**
     * Legt den Wert der regionalbereich-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRegionalbereich }
     *     
     */
    public void setRegionalbereich(TCRegionalbereich value) {
        this.regionalbereich = value;
    }

}
