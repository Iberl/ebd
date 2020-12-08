//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBgrenze_RBC_Wechsel_BTS_Kette complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBgrenze_RBC_Wechsel_BTS_Kette">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bez_Strecke_BTS_1" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCBez_Strecke_BTS_1"/>
 *         &lt;element name="Bez_Strecke_BTS_2" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCBez_Strecke_BTS_2" minOccurs="0"/>
 *         &lt;element name="Bez_Strecke_BTS_3" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCBez_Strecke_BTS_3" minOccurs="0"/>
 *         &lt;element name="Km_BTS_1" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCKm_BTS_1"/>
 *         &lt;element name="Km_BTS_2" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCKm_BTS_2" minOccurs="0"/>
 *         &lt;element name="Km_BTS_3" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCKm_BTS_3" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBgrenze_RBC_Wechsel_BTS_Kette", propOrder = {
    "bezStreckeBTS1",
    "bezStreckeBTS2",
    "bezStreckeBTS3",
    "kmBTS1",
    "kmBTS2",
    "kmBTS3"
})
public class CBgrenzeRBCWechselBTSKette {

    @XmlElement(name = "Bez_Strecke_BTS_1", required = true)
    protected TCBezStreckeBTS1 bezStreckeBTS1;
    @XmlElement(name = "Bez_Strecke_BTS_2")
    protected TCBezStreckeBTS2 bezStreckeBTS2;
    @XmlElement(name = "Bez_Strecke_BTS_3")
    protected TCBezStreckeBTS3 bezStreckeBTS3;
    @XmlElement(name = "Km_BTS_1", required = true)
    protected TCKmBTS1 kmBTS1;
    @XmlElement(name = "Km_BTS_2")
    protected TCKmBTS2 kmBTS2;
    @XmlElement(name = "Km_BTS_3")
    protected TCKmBTS3 kmBTS3;

    /**
     * Ruft den Wert der bezStreckeBTS1-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezStreckeBTS1 }
     *     
     */
    public TCBezStreckeBTS1 getBezStreckeBTS1() {
        return bezStreckeBTS1;
    }

    /**
     * Legt den Wert der bezStreckeBTS1-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezStreckeBTS1 }
     *     
     */
    public void setBezStreckeBTS1(TCBezStreckeBTS1 value) {
        this.bezStreckeBTS1 = value;
    }

    /**
     * Ruft den Wert der bezStreckeBTS2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezStreckeBTS2 }
     *     
     */
    public TCBezStreckeBTS2 getBezStreckeBTS2() {
        return bezStreckeBTS2;
    }

    /**
     * Legt den Wert der bezStreckeBTS2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezStreckeBTS2 }
     *     
     */
    public void setBezStreckeBTS2(TCBezStreckeBTS2 value) {
        this.bezStreckeBTS2 = value;
    }

    /**
     * Ruft den Wert der bezStreckeBTS3-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBezStreckeBTS3 }
     *     
     */
    public TCBezStreckeBTS3 getBezStreckeBTS3() {
        return bezStreckeBTS3;
    }

    /**
     * Legt den Wert der bezStreckeBTS3-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBezStreckeBTS3 }
     *     
     */
    public void setBezStreckeBTS3(TCBezStreckeBTS3 value) {
        this.bezStreckeBTS3 = value;
    }

    /**
     * Ruft den Wert der kmBTS1-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKmBTS1 }
     *     
     */
    public TCKmBTS1 getKmBTS1() {
        return kmBTS1;
    }

    /**
     * Legt den Wert der kmBTS1-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKmBTS1 }
     *     
     */
    public void setKmBTS1(TCKmBTS1 value) {
        this.kmBTS1 = value;
    }

    /**
     * Ruft den Wert der kmBTS2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKmBTS2 }
     *     
     */
    public TCKmBTS2 getKmBTS2() {
        return kmBTS2;
    }

    /**
     * Legt den Wert der kmBTS2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKmBTS2 }
     *     
     */
    public void setKmBTS2(TCKmBTS2 value) {
        this.kmBTS2 = value;
    }

    /**
     * Ruft den Wert der kmBTS3-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCKmBTS3 }
     *     
     */
    public TCKmBTS3 getKmBTS3() {
        return kmBTS3;
    }

    /**
     * Legt den Wert der kmBTS3-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCKmBTS3 }
     *     
     */
    public void setKmBTS3(TCKmBTS3 value) {
        this.kmBTS3 = value;
    }

}
