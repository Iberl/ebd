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
 * <p>Java-Klasse f�r CFT_GNT_Merkmale complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFT_GNT_Merkmale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Delta_VGES" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDelta_VGES" minOccurs="0"/>
 *         &lt;element name="Delta_VLES" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDelta_VLES" minOccurs="0"/>
 *         &lt;element name="Delta_VZES" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCDelta_VZES" minOccurs="0"/>
 *         &lt;element name="FT_GNT_Punktart" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCFT_GNT_Punktart"/>
 *         &lt;element name="LLA" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCLLA" minOccurs="0"/>
 *         &lt;element name="Neigung" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCNeigung" minOccurs="0"/>
 *         &lt;element name="SBE" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSBE"/>
 *         &lt;element name="STZ" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCSTZ"/>
 *         &lt;element name="VGR" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCVGR" minOccurs="0"/>
 *         &lt;element name="VLA" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCVLA"/>
 *         &lt;element name="VZ" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCVZ"/>
 *         &lt;element name="ZLA" type="{http://www.plan-pro.org/modell/Balisentechnik_ETCS/1.9.0.2}TCZLA" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFT_GNT_Merkmale", propOrder = {
    "deltaVGES",
    "deltaVLES",
    "deltaVZES",
    "ftgntPunktart",
    "lla",
    "neigung",
    "sbe",
    "stz",
    "vgr",
    "vla",
    "vz",
    "zla"
})
public class CFTGNTMerkmale {

    @XmlElement(name = "Delta_VGES")
    protected TCDeltaVGES deltaVGES;
    @XmlElement(name = "Delta_VLES")
    protected TCDeltaVLES deltaVLES;
    @XmlElement(name = "Delta_VZES")
    protected TCDeltaVZES deltaVZES;
    @XmlElement(name = "FT_GNT_Punktart", required = true)
    protected TCFTGNTPunktart ftgntPunktart;
    @XmlElement(name = "LLA")
    protected TCLLA lla;
    @XmlElement(name = "Neigung")
    protected TCNeigung neigung;
    @XmlElement(name = "SBE", required = true)
    protected TCSBE sbe;
    @XmlElement(name = "STZ", required = true)
    protected TCSTZ stz;
    @XmlElement(name = "VGR")
    protected TCVGR vgr;
    @XmlElement(name = "VLA", required = true)
    protected TCVLA vla;
    @XmlElement(name = "VZ", required = true)
    protected TCVZ vz;
    @XmlElement(name = "ZLA")
    protected TCZLA zla;

    /**
     * Ruft den Wert der deltaVGES-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDeltaVGES }
     *     
     */
    public TCDeltaVGES getDeltaVGES() {
        return deltaVGES;
    }

    /**
     * Legt den Wert der deltaVGES-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDeltaVGES }
     *     
     */
    public void setDeltaVGES(TCDeltaVGES value) {
        this.deltaVGES = value;
    }

    /**
     * Ruft den Wert der deltaVLES-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDeltaVLES }
     *     
     */
    public TCDeltaVLES getDeltaVLES() {
        return deltaVLES;
    }

    /**
     * Legt den Wert der deltaVLES-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDeltaVLES }
     *     
     */
    public void setDeltaVLES(TCDeltaVLES value) {
        this.deltaVLES = value;
    }

    /**
     * Ruft den Wert der deltaVZES-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDeltaVZES }
     *     
     */
    public TCDeltaVZES getDeltaVZES() {
        return deltaVZES;
    }

    /**
     * Legt den Wert der deltaVZES-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDeltaVZES }
     *     
     */
    public void setDeltaVZES(TCDeltaVZES value) {
        this.deltaVZES = value;
    }

    /**
     * Ruft den Wert der ftgntPunktart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCFTGNTPunktart }
     *     
     */
    public TCFTGNTPunktart getFTGNTPunktart() {
        return ftgntPunktart;
    }

    /**
     * Legt den Wert der ftgntPunktart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCFTGNTPunktart }
     *     
     */
    public void setFTGNTPunktart(TCFTGNTPunktart value) {
        this.ftgntPunktart = value;
    }

    /**
     * Ruft den Wert der lla-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCLLA }
     *     
     */
    public TCLLA getLLA() {
        return lla;
    }

    /**
     * Legt den Wert der lla-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLLA }
     *     
     */
    public void setLLA(TCLLA value) {
        this.lla = value;
    }

    /**
     * Ruft den Wert der neigung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCNeigung }
     *     
     */
    public TCNeigung getNeigung() {
        return neigung;
    }

    /**
     * Legt den Wert der neigung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCNeigung }
     *     
     */
    public void setNeigung(TCNeigung value) {
        this.neigung = value;
    }

    /**
     * Ruft den Wert der sbe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSBE }
     *     
     */
    public TCSBE getSBE() {
        return sbe;
    }

    /**
     * Legt den Wert der sbe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSBE }
     *     
     */
    public void setSBE(TCSBE value) {
        this.sbe = value;
    }

    /**
     * Ruft den Wert der stz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCSTZ }
     *     
     */
    public TCSTZ getSTZ() {
        return stz;
    }

    /**
     * Legt den Wert der stz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSTZ }
     *     
     */
    public void setSTZ(TCSTZ value) {
        this.stz = value;
    }

    /**
     * Ruft den Wert der vgr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVGR }
     *     
     */
    public TCVGR getVGR() {
        return vgr;
    }

    /**
     * Legt den Wert der vgr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVGR }
     *     
     */
    public void setVGR(TCVGR value) {
        this.vgr = value;
    }

    /**
     * Ruft den Wert der vla-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVLA }
     *     
     */
    public TCVLA getVLA() {
        return vla;
    }

    /**
     * Legt den Wert der vla-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVLA }
     *     
     */
    public void setVLA(TCVLA value) {
        this.vla = value;
    }

    /**
     * Ruft den Wert der vz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCVZ }
     *     
     */
    public TCVZ getVZ() {
        return vz;
    }

    /**
     * Legt den Wert der vz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVZ }
     *     
     */
    public void setVZ(TCVZ value) {
        this.vz = value;
    }

    /**
     * Ruft den Wert der zla-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZLA }
     *     
     */
    public TCZLA getZLA() {
        return zla;
    }

    /**
     * Legt den Wert der zla-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZLA }
     *     
     */
    public void setZLA(TCZLA value) {
        this.zla = value;
    }

}
