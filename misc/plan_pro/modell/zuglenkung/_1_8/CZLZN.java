//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zuglenkung._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZL_ZN complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_ZN">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Lenkziffernstellen" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCLenkziffernstellen" minOccurs="0"/>
 *         &lt;element name="ZN_Stellen" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCZN_Stellen" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_ZN", propOrder = {
    "lenkziffernstellen",
    "znStellen"
})
public class CZLZN {

    @XmlElement(name = "Lenkziffernstellen")
    protected TCLenkziffernstellen lenkziffernstellen;
    @XmlElement(name = "ZN_Stellen")
    protected TCZNStellen znStellen;

    /**
     * Ruft den Wert der lenkziffernstellen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLenkziffernstellen }
     *     
     */
    public TCLenkziffernstellen getLenkziffernstellen() {
        return lenkziffernstellen;
    }

    /**
     * Legt den Wert der lenkziffernstellen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLenkziffernstellen }
     *     
     */
    public void setLenkziffernstellen(TCLenkziffernstellen value) {
        this.lenkziffernstellen = value;
    }

    /**
     * Ruft den Wert der znStellen-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZNStellen }
     *     
     */
    public TCZNStellen getZNStellen() {
        return znStellen;
    }

    /**
     * Legt den Wert der znStellen-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZNStellen }
     *     
     */
    public void setZNStellen(TCZNStellen value) {
        this.znStellen = value;
    }

}
