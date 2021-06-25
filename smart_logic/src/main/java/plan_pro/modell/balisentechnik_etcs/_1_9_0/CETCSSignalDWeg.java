//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CETCS_Signal_DWeg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CETCS_Signal_DWeg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DWeg_Intervall_200" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDWeg_Intervall_200" minOccurs="0"/>
 *         &lt;element name="DWeg_Intervall_50" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDWeg_Intervall_50" minOccurs="0"/>
 *         &lt;element name="DWeg_Intervall_50_200" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDWeg_Intervall_50_200" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CETCS_Signal_DWeg", propOrder = {
    "dWegIntervall200",
    "dWegIntervall50",
    "dWegIntervall50200"
})
public class CETCSSignalDWeg {

    @XmlElement(name = "DWeg_Intervall_200")
    protected TCDWegIntervall200 dWegIntervall200;
    @XmlElement(name = "DWeg_Intervall_50")
    protected TCDWegIntervall50 dWegIntervall50;
    @XmlElement(name = "DWeg_Intervall_50_200")
    protected TCDWegIntervall50200 dWegIntervall50200;

    /**
     * Ruft den Wert der dWegIntervall200-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDWegIntervall200 }
     *     
     */
    public TCDWegIntervall200 getDWegIntervall200() {
        return dWegIntervall200;
    }

    /**
     * Legt den Wert der dWegIntervall200-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDWegIntervall200 }
     *     
     */
    public void setDWegIntervall200(TCDWegIntervall200 value) {
        this.dWegIntervall200 = value;
    }

    /**
     * Ruft den Wert der dWegIntervall50-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDWegIntervall50 }
     *     
     */
    public TCDWegIntervall50 getDWegIntervall50() {
        return dWegIntervall50;
    }

    /**
     * Legt den Wert der dWegIntervall50-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDWegIntervall50 }
     *     
     */
    public void setDWegIntervall50(TCDWegIntervall50 value) {
        this.dWegIntervall50 = value;
    }

    /**
     * Ruft den Wert der dWegIntervall50200-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDWegIntervall50200 }
     *     
     */
    public TCDWegIntervall50200 getDWegIntervall50200() {
        return dWegIntervall50200;
    }

    /**
     * Legt den Wert der dWegIntervall50200-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDWegIntervall50200 }
     *     
     */
    public void setDWegIntervall50200(TCDWegIntervall50200 value) {
        this.dWegIntervall50200 = value;
    }

}
