//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDZLVBus;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CTelegramm_84_Alle_Fstr complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTelegramm_84_Alle_Fstr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_ZLV_Bus" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZLV_Bus" minOccurs="0"/>
 *         &lt;element name="Telegramm_84_Fuer_Alle_Fstr" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCTelegramm_84_Fuer_Alle_Fstr"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTelegramm_84_Alle_Fstr", propOrder = {
    "idzlvBus",
    "telegramm84FuerAlleFstr"
})
public class CTelegramm84AlleFstr {

    @XmlElement(name = "ID_ZLV_Bus")
    protected TCIDZLVBus idzlvBus;
    @XmlElement(name = "Telegramm_84_Fuer_Alle_Fstr", required = true)
    protected TCTelegramm84FuerAlleFstr telegramm84FuerAlleFstr;

    /**
     * Ruft den Wert der idzlvBus-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCIDZLVBus }
     *     
     */
    public TCIDZLVBus getIDZLVBus() {
        return idzlvBus;
    }

    /**
     * Legt den Wert der idzlvBus-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCIDZLVBus }
     *     
     */
    public void setIDZLVBus(TCIDZLVBus value) {
        this.idzlvBus = value;
    }

    /**
     * Ruft den Wert der telegramm84FuerAlleFstr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelegramm84FuerAlleFstr }
     *     
     */
    public TCTelegramm84FuerAlleFstr getTelegramm84FuerAlleFstr() {
        return telegramm84FuerAlleFstr;
    }

    /**
     * Legt den Wert der telegramm84FuerAlleFstr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelegramm84FuerAlleFstr }
     *     
     */
    public void setTelegramm84FuerAlleFstr(TCTelegramm84FuerAlleFstr value) {
        this.telegramm84FuerAlleFstr = value;
    }

}
