//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZLV_Bus_US_Zuordnung_Telegramm complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZLV_Bus_US_Zuordnung_Telegramm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Telegramm_02" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCTelegramm_02" minOccurs="0"/>
 *         &lt;element name="Telegramm_03" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCTelegramm_03" minOccurs="0"/>
 *         &lt;element name="Telegramm_04" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCTelegramm_04" minOccurs="0"/>
 *         &lt;element name="Telegramm_10" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCTelegramm_10" minOccurs="0"/>
 *         &lt;element name="Telegramm_21" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCTelegramm_21" minOccurs="0"/>
 *         &lt;element name="Telegramm_30" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCTelegramm_30" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZLV_Bus_US_Zuordnung_Telegramm", propOrder = {
    "telegramm02",
    "telegramm03",
    "telegramm04",
    "telegramm10",
    "telegramm21",
    "telegramm30"
})
public class CZLVBusUSZuordnungTelegramm {

    @XmlElement(name = "Telegramm_02")
    protected TCTelegramm02 telegramm02;
    @XmlElement(name = "Telegramm_03")
    protected TCTelegramm03 telegramm03;
    @XmlElement(name = "Telegramm_04")
    protected TCTelegramm04 telegramm04;
    @XmlElement(name = "Telegramm_10")
    protected TCTelegramm10 telegramm10;
    @XmlElement(name = "Telegramm_21")
    protected TCTelegramm21 telegramm21;
    @XmlElement(name = "Telegramm_30")
    protected TCTelegramm30 telegramm30;

    /**
     * Ruft den Wert der telegramm02-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelegramm02 }
     *     
     */
    public TCTelegramm02 getTelegramm02() {
        return telegramm02;
    }

    /**
     * Legt den Wert der telegramm02-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelegramm02 }
     *     
     */
    public void setTelegramm02(TCTelegramm02 value) {
        this.telegramm02 = value;
    }

    /**
     * Ruft den Wert der telegramm03-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelegramm03 }
     *     
     */
    public TCTelegramm03 getTelegramm03() {
        return telegramm03;
    }

    /**
     * Legt den Wert der telegramm03-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelegramm03 }
     *     
     */
    public void setTelegramm03(TCTelegramm03 value) {
        this.telegramm03 = value;
    }

    /**
     * Ruft den Wert der telegramm04-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelegramm04 }
     *     
     */
    public TCTelegramm04 getTelegramm04() {
        return telegramm04;
    }

    /**
     * Legt den Wert der telegramm04-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelegramm04 }
     *     
     */
    public void setTelegramm04(TCTelegramm04 value) {
        this.telegramm04 = value;
    }

    /**
     * Ruft den Wert der telegramm10-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelegramm10 }
     *     
     */
    public TCTelegramm10 getTelegramm10() {
        return telegramm10;
    }

    /**
     * Legt den Wert der telegramm10-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelegramm10 }
     *     
     */
    public void setTelegramm10(TCTelegramm10 value) {
        this.telegramm10 = value;
    }

    /**
     * Ruft den Wert der telegramm21-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelegramm21 }
     *     
     */
    public TCTelegramm21 getTelegramm21() {
        return telegramm21;
    }

    /**
     * Legt den Wert der telegramm21-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelegramm21 }
     *     
     */
    public void setTelegramm21(TCTelegramm21 value) {
        this.telegramm21 = value;
    }

    /**
     * Ruft den Wert der telegramm30-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTelegramm30 }
     *     
     */
    public TCTelegramm30 getTelegramm30() {
        return telegramm30;
    }

    /**
     * Legt den Wert der telegramm30-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTelegramm30 }
     *     
     */
    public void setTelegramm30(TCTelegramm30 value) {
        this.telegramm30 = value;
    }

}
