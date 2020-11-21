//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CSchrankenantrieb_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CSchrankenantrieb_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Abstand_Gehweg_Fahrbahn" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCAbstand_Gehweg_Fahrbahn"/>
 *         &lt;element name="Hersteller" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCHersteller" minOccurs="0"/>
 *         &lt;element name="Schaltgruppe" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCSchaltgruppe" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSchrankenantrieb_Allg", propOrder = {
    "abstandGehwegFahrbahn",
    "hersteller",
    "schaltgruppe"
})
public class CSchrankenantriebAllg {

    @XmlElement(name = "Abstand_Gehweg_Fahrbahn", required = true)
    protected TCAbstandGehwegFahrbahn abstandGehwegFahrbahn;
    @XmlElement(name = "Hersteller")
    protected TCHersteller hersteller;
    @XmlElement(name = "Schaltgruppe")
    protected TCSchaltgruppe schaltgruppe;

    /**
     * Ruft den Wert der abstandGehwegFahrbahn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAbstandGehwegFahrbahn }
     *     
     */
    public TCAbstandGehwegFahrbahn getAbstandGehwegFahrbahn() {
        return abstandGehwegFahrbahn;
    }

    /**
     * Legt den Wert der abstandGehwegFahrbahn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAbstandGehwegFahrbahn }
     *     
     */
    public void setAbstandGehwegFahrbahn(TCAbstandGehwegFahrbahn value) {
        this.abstandGehwegFahrbahn = value;
    }

    /**
     * Ruft den Wert der hersteller-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHersteller }
     *     
     */
    public TCHersteller getHersteller() {
        return hersteller;
    }

    /**
     * Legt den Wert der hersteller-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHersteller }
     *     
     */
    public void setHersteller(TCHersteller value) {
        this.hersteller = value;
    }

    /**
     * Ruft den Wert der schaltgruppe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSchaltgruppe }
     *     
     */
    public TCSchaltgruppe getSchaltgruppe() {
        return schaltgruppe;
    }

    /**
     * Legt den Wert der schaltgruppe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSchaltgruppe }
     *     
     */
    public void setSchaltgruppe(TCSchaltgruppe value) {
        this.schaltgruppe = value;
    }

}
