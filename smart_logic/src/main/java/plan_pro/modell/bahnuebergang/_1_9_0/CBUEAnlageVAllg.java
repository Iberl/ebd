//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBUE_Anlage_V_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBUE_Anlage_V_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="V_Max_Schiene" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCV_Max_Schiene"/>
 *         &lt;element name="V_Max_Strasse" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCV_Max_Strasse" minOccurs="0"/>
 *         &lt;element name="V_Min_Fussweg" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCV_Min_Fussweg" minOccurs="0"/>
 *         &lt;element name="V_Min_Schiene" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCV_Min_Schiene"/>
 *         &lt;element name="V_Min_Strasse" type="{http://www.plan-pro.org/modell/Bahnuebergang/1.9.0.2}TCV_Min_Strasse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBUE_Anlage_V_Allg", propOrder = {
    "vMaxSchiene",
    "vMaxStrasse",
    "vMinFussweg",
    "vMinSchiene",
    "vMinStrasse"
})
public class CBUEAnlageVAllg {

    @XmlElement(name = "V_Max_Schiene", required = true)
    protected TCVMaxSchiene vMaxSchiene;
    @XmlElement(name = "V_Max_Strasse")
    protected TCVMaxStrasse vMaxStrasse;
    @XmlElement(name = "V_Min_Fussweg")
    protected TCVMinFussweg vMinFussweg;
    @XmlElement(name = "V_Min_Schiene", required = true)
    protected TCVMinSchiene vMinSchiene;
    @XmlElement(name = "V_Min_Strasse")
    protected TCVMinStrasse vMinStrasse;

    /**
     * Ruft den Wert der vMaxSchiene-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVMaxSchiene }
     *     
     */
    public TCVMaxSchiene getVMaxSchiene() {
        return vMaxSchiene;
    }

    /**
     * Legt den Wert der vMaxSchiene-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVMaxSchiene }
     *     
     */
    public void setVMaxSchiene(TCVMaxSchiene value) {
        this.vMaxSchiene = value;
    }

    /**
     * Ruft den Wert der vMaxStrasse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVMaxStrasse }
     *     
     */
    public TCVMaxStrasse getVMaxStrasse() {
        return vMaxStrasse;
    }

    /**
     * Legt den Wert der vMaxStrasse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVMaxStrasse }
     *     
     */
    public void setVMaxStrasse(TCVMaxStrasse value) {
        this.vMaxStrasse = value;
    }

    /**
     * Ruft den Wert der vMinFussweg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVMinFussweg }
     *     
     */
    public TCVMinFussweg getVMinFussweg() {
        return vMinFussweg;
    }

    /**
     * Legt den Wert der vMinFussweg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVMinFussweg }
     *     
     */
    public void setVMinFussweg(TCVMinFussweg value) {
        this.vMinFussweg = value;
    }

    /**
     * Ruft den Wert der vMinSchiene-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVMinSchiene }
     *     
     */
    public TCVMinSchiene getVMinSchiene() {
        return vMinSchiene;
    }

    /**
     * Legt den Wert der vMinSchiene-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVMinSchiene }
     *     
     */
    public void setVMinSchiene(TCVMinSchiene value) {
        this.vMinSchiene = value;
    }

    /**
     * Ruft den Wert der vMinStrasse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVMinStrasse }
     *     
     */
    public TCVMinStrasse getVMinStrasse() {
        return vMinStrasse;
    }

    /**
     * Legt den Wert der vMinStrasse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVMinStrasse }
     *     
     */
    public void setVMinStrasse(TCVMinStrasse value) {
        this.vMinStrasse = value;
    }

}
