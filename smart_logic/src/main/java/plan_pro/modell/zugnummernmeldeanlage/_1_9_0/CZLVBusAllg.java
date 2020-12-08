//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZLV_Bus_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZLV_Bus_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Unterstation_Max" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCUnterstation_Max"/>
 *         &lt;element name="ZLV_Bus_Nr" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCZLV_Bus_Nr"/>
 *         &lt;element name="ZN_Modem" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCZN_Modem"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZLV_Bus_Allg", propOrder = {
    "unterstationMax",
    "zlvBusNr",
    "znModem"
})
public class CZLVBusAllg {

    @XmlElement(name = "Unterstation_Max", required = true)
    protected TCUnterstationMax unterstationMax;
    @XmlElement(name = "ZLV_Bus_Nr", required = true)
    protected TCZLVBusNr zlvBusNr;
    @XmlElement(name = "ZN_Modem", required = true)
    protected TCZNModem znModem;

    /**
     * Ruft den Wert der unterstationMax-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUnterstationMax }
     *     
     */
    public TCUnterstationMax getUnterstationMax() {
        return unterstationMax;
    }

    /**
     * Legt den Wert der unterstationMax-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUnterstationMax }
     *     
     */
    public void setUnterstationMax(TCUnterstationMax value) {
        this.unterstationMax = value;
    }

    /**
     * Ruft den Wert der zlvBusNr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZLVBusNr }
     *     
     */
    public TCZLVBusNr getZLVBusNr() {
        return zlvBusNr;
    }

    /**
     * Legt den Wert der zlvBusNr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZLVBusNr }
     *     
     */
    public void setZLVBusNr(TCZLVBusNr value) {
        this.zlvBusNr = value;
    }

    /**
     * Ruft den Wert der znModem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZNModem }
     *     
     */
    public TCZNModem getZNModem() {
        return znModem;
    }

    /**
     * Legt den Wert der znModem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZNModem }
     *     
     */
    public void setZNModem(TCZNModem value) {
        this.znModem = value;
    }

}
