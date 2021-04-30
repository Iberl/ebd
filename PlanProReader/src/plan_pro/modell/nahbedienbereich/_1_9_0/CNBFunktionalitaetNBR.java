//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.nahbedienbereich._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CNB_Funktionalitaet_NB_R complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CNB_Funktionalitaet_NB_R">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AWU" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCAWU"/>
 *         &lt;element name="F_ST_Z" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCF_ST_Z"/>
 *         &lt;element name="FA_FAE" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCFA_FAE"/>
 *         &lt;element name="SBUE" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCSBUE"/>
 *         &lt;element name="SLE_SLS" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCSLE_SLS"/>
 *         &lt;element name="WHU" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCWHU"/>
 *         &lt;element name="WUS" type="{http://www.plan-pro.org/modell/Nahbedienbereich/1.9.0.2}TCWUS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CNB_Funktionalitaet_NB_R", propOrder = {
    "awu",
    "fstz",
    "fafae",
    "sbue",
    "slesls",
    "whu",
    "wus"
})
public class CNBFunktionalitaetNBR {

    @XmlElement(name = "AWU", required = true)
    protected TCAWU awu;
    @XmlElement(name = "F_ST_Z", required = true)
    protected TCFSTZ fstz;
    @XmlElement(name = "FA_FAE", required = true)
    protected TCFAFAE fafae;
    @XmlElement(name = "SBUE", required = true)
    protected TCSBUE sbue;
    @XmlElement(name = "SLE_SLS", required = true)
    protected TCSLESLS slesls;
    @XmlElement(name = "WHU", required = true)
    protected TCWHU whu;
    @XmlElement(name = "WUS", required = true)
    protected TCWUS wus;

    /**
     * Ruft den Wert der awu-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAWU }
     *     
     */
    public TCAWU getAWU() {
        return awu;
    }

    /**
     * Legt den Wert der awu-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAWU }
     *     
     */
    public void setAWU(TCAWU value) {
        this.awu = value;
    }

    /**
     * Ruft den Wert der fstz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFSTZ }
     *     
     */
    public TCFSTZ getFSTZ() {
        return fstz;
    }

    /**
     * Legt den Wert der fstz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFSTZ }
     *     
     */
    public void setFSTZ(TCFSTZ value) {
        this.fstz = value;
    }

    /**
     * Ruft den Wert der fafae-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFAFAE }
     *     
     */
    public TCFAFAE getFAFAE() {
        return fafae;
    }

    /**
     * Legt den Wert der fafae-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFAFAE }
     *     
     */
    public void setFAFAE(TCFAFAE value) {
        this.fafae = value;
    }

    /**
     * Ruft den Wert der sbue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSBUE }
     *     
     */
    public TCSBUE getSBUE() {
        return sbue;
    }

    /**
     * Legt den Wert der sbue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSBUE }
     *     
     */
    public void setSBUE(TCSBUE value) {
        this.sbue = value;
    }

    /**
     * Ruft den Wert der slesls-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSLESLS }
     *     
     */
    public TCSLESLS getSLESLS() {
        return slesls;
    }

    /**
     * Legt den Wert der slesls-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSLESLS }
     *     
     */
    public void setSLESLS(TCSLESLS value) {
        this.slesls = value;
    }

    /**
     * Ruft den Wert der whu-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWHU }
     *     
     */
    public TCWHU getWHU() {
        return whu;
    }

    /**
     * Legt den Wert der whu-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWHU }
     *     
     */
    public void setWHU(TCWHU value) {
        this.whu = value;
    }

    /**
     * Ruft den Wert der wus-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWUS }
     *     
     */
    public TCWUS getWUS() {
        return wus;
    }

    /**
     * Legt den Wert der wus-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWUS }
     *     
     */
    public void setWUS(TCWUS value) {
        this.wus = value;
    }

}
