//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.nahbedienbereich._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CNB_Zone_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Zone_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NB_Unterstellungsverhaeltnis" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}TCNB_Unterstellungsverhaeltnis" minOccurs="0"/>
 *         &lt;element name="NB_Zone_Bezeichnung" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.8.0}TCNB_Zone_Bezeichnung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB_Zone_Allg", propOrder = {
    "nbUnterstellungsverhaeltnis",
    "nbZoneBezeichnung"
})
public class CNBZoneAllg {

    @XmlElement(name = "NB_Unterstellungsverhaeltnis")
    protected TCNBUnterstellungsverhaeltnis nbUnterstellungsverhaeltnis;
    @XmlElement(name = "NB_Zone_Bezeichnung", required = true)
    protected TCNBZoneBezeichnung nbZoneBezeichnung;

    /**
     * Ruft den Wert der nbUnterstellungsverhaeltnis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNBUnterstellungsverhaeltnis }
     *     
     */
    public TCNBUnterstellungsverhaeltnis getNBUnterstellungsverhaeltnis() {
        return nbUnterstellungsverhaeltnis;
    }

    /**
     * Legt den Wert der nbUnterstellungsverhaeltnis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNBUnterstellungsverhaeltnis }
     *     
     */
    public void setNBUnterstellungsverhaeltnis(TCNBUnterstellungsverhaeltnis value) {
        this.nbUnterstellungsverhaeltnis = value;
    }

    /**
     * Ruft den Wert der nbZoneBezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNBZoneBezeichnung }
     *     
     */
    public TCNBZoneBezeichnung getNBZoneBezeichnung() {
        return nbZoneBezeichnung;
    }

    /**
     * Legt den Wert der nbZoneBezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNBZoneBezeichnung }
     *     
     */
    public void setNBZoneBezeichnung(TCNBZoneBezeichnung value) {
        this.nbZoneBezeichnung = value;
    }

}
