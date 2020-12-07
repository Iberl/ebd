//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CHoehenpunkt_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CHoehenpunkt_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GEO_PAD" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGEO_PAD" minOccurs="0"/>
 *         &lt;element name="Hoehenpunkt_Datum" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCHoehenpunkt_Datum" minOccurs="0"/>
 *         &lt;element name="Hoehenpunkt_Hoehe" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCHoehenpunkt_Hoehe"/>
 *         &lt;element name="HSystem" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCHSystem" minOccurs="0"/>
 *         &lt;element name="Neigung" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCNeigung" minOccurs="0"/>
 *         &lt;element name="Plan_Quelle" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCPlan_Quelle" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHoehenpunkt_Allg", propOrder = {
    "geopad",
    "hoehenpunktDatum",
    "hoehenpunktHoehe",
    "hSystem",
    "neigung",
    "planQuelle"
})
public class CHoehenpunktAllg {

    @XmlElement(name = "GEO_PAD")
    protected TCGEOPAD geopad;
    @XmlElement(name = "Hoehenpunkt_Datum")
    protected TCHoehenpunktDatum hoehenpunktDatum;
    @XmlElement(name = "Hoehenpunkt_Hoehe", required = true)
    protected TCHoehenpunktHoehe hoehenpunktHoehe;
    @XmlElement(name = "HSystem")
    protected TCHSystem hSystem;
    @XmlElement(name = "Neigung")
    protected TCNeigung neigung;
    @XmlElement(name = "Plan_Quelle")
    protected TCPlanQuelle planQuelle;

    /**
     * Ruft den Wert der geopad-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGEOPAD }
     *     
     */
    public TCGEOPAD getGEOPAD() {
        return geopad;
    }

    /**
     * Legt den Wert der geopad-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGEOPAD }
     *     
     */
    public void setGEOPAD(TCGEOPAD value) {
        this.geopad = value;
    }

    /**
     * Ruft den Wert der hoehenpunktDatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHoehenpunktDatum }
     *     
     */
    public TCHoehenpunktDatum getHoehenpunktDatum() {
        return hoehenpunktDatum;
    }

    /**
     * Legt den Wert der hoehenpunktDatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHoehenpunktDatum }
     *     
     */
    public void setHoehenpunktDatum(TCHoehenpunktDatum value) {
        this.hoehenpunktDatum = value;
    }

    /**
     * Ruft den Wert der hoehenpunktHoehe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHoehenpunktHoehe }
     *     
     */
    public TCHoehenpunktHoehe getHoehenpunktHoehe() {
        return hoehenpunktHoehe;
    }

    /**
     * Legt den Wert der hoehenpunktHoehe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHoehenpunktHoehe }
     *     
     */
    public void setHoehenpunktHoehe(TCHoehenpunktHoehe value) {
        this.hoehenpunktHoehe = value;
    }

    /**
     * Ruft den Wert der hSystem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCHSystem }
     *     
     */
    public TCHSystem getHSystem() {
        return hSystem;
    }

    /**
     * Legt den Wert der hSystem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCHSystem }
     *     
     */
    public void setHSystem(TCHSystem value) {
        this.hSystem = value;
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
     * Ruft den Wert der planQuelle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCPlanQuelle }
     *     
     */
    public TCPlanQuelle getPlanQuelle() {
        return planQuelle;
    }

    /**
     * Legt den Wert der planQuelle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPlanQuelle }
     *     
     */
    public void setPlanQuelle(TCPlanQuelle value) {
        this.planQuelle = value;
    }

}
