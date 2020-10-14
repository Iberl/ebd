//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.geodaten._1_9_0;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CGEO_Punkt_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CGEO_Punkt_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GK_X" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGK_X"/>
 *         &lt;element name="GK_Y" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGK_Y"/>
 *         &lt;element name="GK_Z" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGK_Z" minOccurs="0"/>
 *         &lt;element name="Plan_Quelle" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCPlan_Quelle"/>
 *         &lt;choice>
 *           &lt;element name="GEO_KoordinatenSystem_LSys" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGEO_KoordinatenSystem_LSys"/>
 *           &lt;element name="GEO_KoordinatenSystem_Sonstige" type="{http://www.plan-pro.org/modell/Geodaten/1.9.0.2}TCGEO_KoordinatenSystem_Sonstige"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CGEO_Punkt_Allg", propOrder = {
    "gkx",
    "gky",
    "gkz",
    "planQuelle",
    "geoKoordinatenSystemLSys",
    "geoKoordinatenSystemSonstige"
})
public class CGEOPunktAllg {

    @XmlElement(name = "GK_X", required = true)
    protected TCGKX gkx;
    @XmlElement(name = "GK_Y", required = true)
    protected TCGKY gky;
    @XmlElement(name = "GK_Z")
    protected TCGKZ gkz;
    @XmlElement(name = "Plan_Quelle", required = true)
    protected TCPlanQuelle planQuelle;
    @XmlElement(name = "GEO_KoordinatenSystem_LSys")
    protected TCGEOKoordinatenSystemLSys geoKoordinatenSystemLSys;
    @XmlElement(name = "GEO_KoordinatenSystem_Sonstige")
    protected TCGEOKoordinatenSystemSonstige geoKoordinatenSystemSonstige;

    /**
     * Ruft den Wert der gkx-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGKX }
     *     
     */
    public TCGKX getGKX() {
        return gkx;
    }

    /**
     * Legt den Wert der gkx-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGKX }
     *     
     */
    public void setGKX(TCGKX value) {
        this.gkx = value;
    }

    /**
     * Ruft den Wert der gky-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGKY }
     *     
     */
    public TCGKY getGKY() {
        return gky;
    }

    /**
     * Legt den Wert der gky-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGKY }
     *     
     */
    public void setGKY(TCGKY value) {
        this.gky = value;
    }

    /**
     * Ruft den Wert der gkz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGKZ }
     *     
     */
    public TCGKZ getGKZ() {
        return gkz;
    }

    /**
     * Legt den Wert der gkz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGKZ }
     *     
     */
    public void setGKZ(TCGKZ value) {
        this.gkz = value;
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
     * Ruft den Wert der geoKoordinatenSystemLSys-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGEOKoordinatenSystemLSys }
     *     
     */
    public TCGEOKoordinatenSystemLSys getGEOKoordinatenSystemLSys() {
        return geoKoordinatenSystemLSys;
    }

    /**
     * Legt den Wert der geoKoordinatenSystemLSys-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGEOKoordinatenSystemLSys }
     *     
     */
    public void setGEOKoordinatenSystemLSys(TCGEOKoordinatenSystemLSys value) {
        this.geoKoordinatenSystemLSys = value;
    }

    /**
     * Ruft den Wert der geoKoordinatenSystemSonstige-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGEOKoordinatenSystemSonstige }
     *     
     */
    public TCGEOKoordinatenSystemSonstige getGEOKoordinatenSystemSonstige() {
        return geoKoordinatenSystemSonstige;
    }

    /**
     * Legt den Wert der geoKoordinatenSystemSonstige-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGEOKoordinatenSystemSonstige }
     *     
     */
    public void setGEOKoordinatenSystemSonstige(TCGEOKoordinatenSystemSonstige value) {
        this.geoKoordinatenSystemSonstige = value;
    }

}
