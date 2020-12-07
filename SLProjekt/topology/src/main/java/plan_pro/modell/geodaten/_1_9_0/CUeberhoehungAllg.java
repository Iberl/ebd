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
 * <p>Java-Klasse f�r CUeberhoehung_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CUeberhoehung_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GEO_PAD" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGEO_PAD" minOccurs="0"/>
 *         &lt;element name="Plan_Quelle" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCPlan_Quelle" minOccurs="0"/>
 *         &lt;element name="Ueberhoehung_Datum" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCUeberhoehung_Datum" minOccurs="0"/>
 *         &lt;element name="Ueberhoehung_Hoehe" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCUeberhoehung_Hoehe"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUeberhoehung_Allg", propOrder = {
    "geopad",
    "planQuelle",
    "ueberhoehungDatum",
    "ueberhoehungHoehe"
})
public class CUeberhoehungAllg {

    @XmlElement(name = "GEO_PAD")
    protected TCGEOPAD geopad;
    @XmlElement(name = "Plan_Quelle")
    protected TCPlanQuelle planQuelle;
    @XmlElement(name = "Ueberhoehung_Datum")
    protected TCUeberhoehungDatum ueberhoehungDatum;
    @XmlElement(name = "Ueberhoehung_Hoehe", required = true)
    protected TCUeberhoehungHoehe ueberhoehungHoehe;

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

    /**
     * Ruft den Wert der ueberhoehungDatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUeberhoehungDatum }
     *     
     */
    public TCUeberhoehungDatum getUeberhoehungDatum() {
        return ueberhoehungDatum;
    }

    /**
     * Legt den Wert der ueberhoehungDatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUeberhoehungDatum }
     *     
     */
    public void setUeberhoehungDatum(TCUeberhoehungDatum value) {
        this.ueberhoehungDatum = value;
    }

    /**
     * Ruft den Wert der ueberhoehungHoehe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCUeberhoehungHoehe }
     *     
     */
    public TCUeberhoehungHoehe getUeberhoehungHoehe() {
        return ueberhoehungHoehe;
    }

    /**
     * Legt den Wert der ueberhoehungHoehe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCUeberhoehungHoehe }
     *     
     */
    public void setUeberhoehungHoehe(TCUeberhoehungHoehe value) {
        this.ueberhoehungHoehe = value;
    }

}
