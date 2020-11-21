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
 * <p>Java-Klasse f�r CGEO_Kante_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGEO_Kante_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GEO_Form" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGEO_Form" minOccurs="0"/>
 *         &lt;element name="GEO_Laenge" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGEO_Laenge"/>
 *         &lt;element name="GEO_Radius_A" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGEO_Radius_A" minOccurs="0"/>
 *         &lt;element name="GEO_Radius_B" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGEO_Radius_B" minOccurs="0"/>
 *         &lt;element name="GEO_Richtungswinkel" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGEO_Richtungswinkel" minOccurs="0"/>
 *         &lt;element name="Plan_Quelle" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCPlan_Quelle"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGEO_Kante_Allg", propOrder = {
    "geoForm",
    "geoLaenge",
    "geoRadiusA",
    "geoRadiusB",
    "geoRichtungswinkel",
    "planQuelle"
})
public class CGEOKanteAllg {

    @XmlElement(name = "GEO_Form")
    protected TCGEOForm geoForm;
    @XmlElement(name = "GEO_Laenge", required = true)
    protected TCGEOLaenge geoLaenge;
    @XmlElement(name = "GEO_Radius_A")
    protected TCGEORadiusA geoRadiusA;
    @XmlElement(name = "GEO_Radius_B")
    protected TCGEORadiusB geoRadiusB;
    @XmlElement(name = "GEO_Richtungswinkel")
    protected TCGEORichtungswinkel geoRichtungswinkel;
    @XmlElement(name = "Plan_Quelle", required = true)
    protected TCPlanQuelle planQuelle;

    /**
     * Ruft den Wert der geoForm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGEOForm }
     *     
     */
    public TCGEOForm getGEOForm() {
        return geoForm;
    }

    /**
     * Legt den Wert der geoForm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGEOForm }
     *     
     */
    public void setGEOForm(TCGEOForm value) {
        this.geoForm = value;
    }

    /**
     * Ruft den Wert der geoLaenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGEOLaenge }
     *     
     */
    public TCGEOLaenge getGEOLaenge() {
        return geoLaenge;
    }

    /**
     * Legt den Wert der geoLaenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGEOLaenge }
     *     
     */
    public void setGEOLaenge(TCGEOLaenge value) {
        this.geoLaenge = value;
    }

    /**
     * Ruft den Wert der geoRadiusA-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGEORadiusA }
     *     
     */
    public TCGEORadiusA getGEORadiusA() {
        return geoRadiusA;
    }

    /**
     * Legt den Wert der geoRadiusA-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGEORadiusA }
     *     
     */
    public void setGEORadiusA(TCGEORadiusA value) {
        this.geoRadiusA = value;
    }

    /**
     * Ruft den Wert der geoRadiusB-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGEORadiusB }
     *     
     */
    public TCGEORadiusB getGEORadiusB() {
        return geoRadiusB;
    }

    /**
     * Legt den Wert der geoRadiusB-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGEORadiusB }
     *     
     */
    public void setGEORadiusB(TCGEORadiusB value) {
        this.geoRadiusB = value;
    }

    /**
     * Ruft den Wert der geoRichtungswinkel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGEORichtungswinkel }
     *     
     */
    public TCGEORichtungswinkel getGEORichtungswinkel() {
        return geoRichtungswinkel;
    }

    /**
     * Legt den Wert der geoRichtungswinkel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGEORichtungswinkel }
     *     
     */
    public void setGEORichtungswinkel(TCGEORichtungswinkel value) {
        this.geoRichtungswinkel = value;
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
