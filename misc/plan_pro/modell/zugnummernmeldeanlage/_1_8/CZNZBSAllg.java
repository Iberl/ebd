//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zugnummernmeldeanlage._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZN_ZBS_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_ZBS_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IP_Adresse" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCIP_Adresse" minOccurs="0"/>
 *         &lt;element name="ZBS_Schnittstelle" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.8.0}TCZBS_Schnittstelle"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_ZBS_Allg", propOrder = {
    "ipAdresse",
    "zbsSchnittstelle"
})
public class CZNZBSAllg {

    @XmlElement(name = "IP_Adresse")
    protected TCIPAdresse ipAdresse;
    @XmlElement(name = "ZBS_Schnittstelle", required = true)
    protected TCZBSSchnittstelle zbsSchnittstelle;

    /**
     * Ruft den Wert der ipAdresse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIPAdresse }
     *     
     */
    public TCIPAdresse getIPAdresse() {
        return ipAdresse;
    }

    /**
     * Legt den Wert der ipAdresse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIPAdresse }
     *     
     */
    public void setIPAdresse(TCIPAdresse value) {
        this.ipAdresse = value;
    }

    /**
     * Ruft den Wert der zbsSchnittstelle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZBSSchnittstelle }
     *     
     */
    public TCZBSSchnittstelle getZBSSchnittstelle() {
        return zbsSchnittstelle;
    }

    /**
     * Legt den Wert der zbsSchnittstelle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZBSSchnittstelle }
     *     
     */
    public void setZBSSchnittstelle(TCZBSSchnittstelle value) {
        this.zbsSchnittstelle = value;
    }

}
