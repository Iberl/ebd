//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import plan_pro.modell.verweise._1_9_0.TCIDZLVBus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CTelegramm_85_Alle_Fstr complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CTelegramm_85_Alle_Fstr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_ZLV_Bus" type="{http://www.plan-pro.org/modell/Verweise/1.9.0.2}TCID_ZLV_Bus" minOccurs="0"/>
 *         &lt;element name="Telegramm_85_Fuer_Alle_Fstr" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCTelegramm_85_Fuer_Alle_Fstr"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTelegramm_85_Alle_Fstr", propOrder = {
    "idzlvBus",
    "telegramm85FuerAlleFstr"
})
public class CTelegramm85AlleFstr {

    @XmlElement(name = "ID_ZLV_Bus")
    protected TCIDZLVBus idzlvBus;
    @XmlElement(name = "Telegramm_85_Fuer_Alle_Fstr", required = true)
    protected TCTelegramm85FuerAlleFstr telegramm85FuerAlleFstr;

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
     * Ruft den Wert der telegramm85FuerAlleFstr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelegramm85FuerAlleFstr }
     *     
     */
    public TCTelegramm85FuerAlleFstr getTelegramm85FuerAlleFstr() {
        return telegramm85FuerAlleFstr;
    }

    /**
     * Legt den Wert der telegramm85FuerAlleFstr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelegramm85FuerAlleFstr }
     *     
     */
    public void setTelegramm85FuerAlleFstr(TCTelegramm85FuerAlleFstr value) {
        this.telegramm85FuerAlleFstr = value;
    }

}
