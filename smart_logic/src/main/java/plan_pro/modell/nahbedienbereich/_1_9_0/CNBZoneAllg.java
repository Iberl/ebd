//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.nahbedienbereich._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


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
 *         &lt;element name="NB_Verhaeltnis_Besonders" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCNB_Verhaeltnis_Besonders" minOccurs="0"/>
 *         &lt;element name="NB_Zone_Bezeichnung" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCNB_Zone_Bezeichnung"/>
 *         &lt;element name="Rang" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCRang" minOccurs="0"/>
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
    "nbVerhaeltnisBesonders",
    "nbZoneBezeichnung",
    "rang"
})
public class CNBZoneAllg {

    @XmlElement(name = "NB_Verhaeltnis_Besonders")
    protected TCNBVerhaeltnisBesonders nbVerhaeltnisBesonders;
    @XmlElement(name = "NB_Zone_Bezeichnung", required = true)
    protected TCNBZoneBezeichnung nbZoneBezeichnung;
    @XmlElement(name = "Rang")
    protected TCRang rang;

    /**
     * Ruft den Wert der nbVerhaeltnisBesonders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNBVerhaeltnisBesonders }
     *     
     */
    public TCNBVerhaeltnisBesonders getNBVerhaeltnisBesonders() {
        return nbVerhaeltnisBesonders;
    }

    /**
     * Legt den Wert der nbVerhaeltnisBesonders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNBVerhaeltnisBesonders }
     *     
     */
    public void setNBVerhaeltnisBesonders(TCNBVerhaeltnisBesonders value) {
        this.nbVerhaeltnisBesonders = value;
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

    /**
     * Ruft den Wert der rang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCRang }
     *     
     */
    public TCRang getRang() {
        return rang;
    }

    /**
     * Legt den Wert der rang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRang }
     *     
     */
    public void setRang(TCRang value) {
        this.rang = value;
    }

}
