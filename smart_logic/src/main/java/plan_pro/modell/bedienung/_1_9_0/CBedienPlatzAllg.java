//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedien_Platz_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Platz_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bedien_Platz_Art" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCBedien_Platz_Art"/>
 *         &lt;element name="Bedienplatzbezeichnung" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCBedienplatzbezeichnung" minOccurs="0"/>
 *         &lt;element name="Bedienplatznummer" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCBedienplatznummer" minOccurs="0"/>
 *         &lt;element name="Bedienraumnummer" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCBedienraumnummer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Platz_Allg", propOrder = {
    "bedienPlatzArt",
    "bedienplatzbezeichnung",
    "bedienplatznummer",
    "bedienraumnummer"
})
public class CBedienPlatzAllg {

    @XmlElement(name = "Bedien_Platz_Art", required = true)
    protected TCBedienPlatzArt bedienPlatzArt;
    @XmlElement(name = "Bedienplatzbezeichnung")
    protected TCBedienplatzbezeichnung bedienplatzbezeichnung;
    @XmlElement(name = "Bedienplatznummer")
    protected TCBedienplatznummer bedienplatznummer;
    @XmlElement(name = "Bedienraumnummer")
    protected TCBedienraumnummer bedienraumnummer;

    /**
     * Ruft den Wert der bedienPlatzArt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBedienPlatzArt }
     *     
     */
    public TCBedienPlatzArt getBedienPlatzArt() {
        return bedienPlatzArt;
    }

    /**
     * Legt den Wert der bedienPlatzArt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBedienPlatzArt }
     *     
     */
    public void setBedienPlatzArt(TCBedienPlatzArt value) {
        this.bedienPlatzArt = value;
    }

    /**
     * Ruft den Wert der bedienplatzbezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBedienplatzbezeichnung }
     *     
     */
    public TCBedienplatzbezeichnung getBedienplatzbezeichnung() {
        return bedienplatzbezeichnung;
    }

    /**
     * Legt den Wert der bedienplatzbezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBedienplatzbezeichnung }
     *     
     */
    public void setBedienplatzbezeichnung(TCBedienplatzbezeichnung value) {
        this.bedienplatzbezeichnung = value;
    }

    /**
     * Ruft den Wert der bedienplatznummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBedienplatznummer }
     *     
     */
    public TCBedienplatznummer getBedienplatznummer() {
        return bedienplatznummer;
    }

    /**
     * Legt den Wert der bedienplatznummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBedienplatznummer }
     *     
     */
    public void setBedienplatznummer(TCBedienplatznummer value) {
        this.bedienplatznummer = value;
    }

    /**
     * Ruft den Wert der bedienraumnummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBedienraumnummer }
     *     
     */
    public TCBedienraumnummer getBedienraumnummer() {
        return bedienraumnummer;
    }

    /**
     * Legt den Wert der bedienraumnummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBedienraumnummer }
     *     
     */
    public void setBedienraumnummer(TCBedienraumnummer value) {
        this.bedienraumnummer = value;
    }

}
