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
 * <p>Java-Klasse f�r CNB_Zone_Reihenfolgezwang complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Zone_Reihenfolgezwang">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NB_Zone_Allg" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCNB_Zone_Allg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB_Zone_Reihenfolgezwang", propOrder = {
    "nbZoneAllg"
})
public class CNBZoneReihenfolgezwang {

    @XmlElement(name = "NB_Zone_Allg")
    protected TCNBZoneAllg nbZoneAllg;

    /**
     * Ruft den Wert der nbZoneAllg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNBZoneAllg }
     *     
     */
    public TCNBZoneAllg getNBZoneAllg() {
        return nbZoneAllg;
    }

    /**
     * Legt den Wert der nbZoneAllg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNBZoneAllg }
     *     
     */
    public void setNBZoneAllg(TCNBZoneAllg value) {
        this.nbZoneAllg = value;
    }

}
