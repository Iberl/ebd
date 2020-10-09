//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.weichen_und_gleissperren._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CW_Kr_Gsp_Element_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CW_Kr_Gsp_Element_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Vorzugslage_Automatik" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCVorzugslage_Automatik" minOccurs="0"/>
 *         &lt;element name="W_Kr_Gsp_Stellart" type="{http://www.plan-pro.org/modell/Weichen_und_Gleissperren/1.9.0.2}TCW_Kr_Gsp_Stellart"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CW_Kr_Gsp_Element_Allg", propOrder = {
    "vorzugslageAutomatik",
    "wKrGspStellart"
})
public class CWKrGspElementAllg {

    @XmlElement(name = "Vorzugslage_Automatik")
    protected TCVorzugslageAutomatik vorzugslageAutomatik;
    @XmlElement(name = "W_Kr_Gsp_Stellart", required = true)
    protected TCWKrGspStellart wKrGspStellart;

    /**
     * Ruft den Wert der vorzugslageAutomatik-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVorzugslageAutomatik }
     *     
     */
    public TCVorzugslageAutomatik getVorzugslageAutomatik() {
        return vorzugslageAutomatik;
    }

    /**
     * Legt den Wert der vorzugslageAutomatik-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVorzugslageAutomatik }
     *     
     */
    public void setVorzugslageAutomatik(TCVorzugslageAutomatik value) {
        this.vorzugslageAutomatik = value;
    }

    /**
     * Ruft den Wert der wKrGspStellart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWKrGspStellart }
     *     
     */
    public TCWKrGspStellart getWKrGspStellart() {
        return wKrGspStellart;
    }

    /**
     * Legt den Wert der wKrGspStellart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWKrGspStellart }
     *     
     */
    public void setWKrGspStellart(TCWKrGspStellart value) {
        this.wKrGspStellart = value;
    }

}
