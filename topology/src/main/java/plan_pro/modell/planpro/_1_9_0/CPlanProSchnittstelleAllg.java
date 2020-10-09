//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.planpro._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CPlanPro_Schnittstelle_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CPlanPro_Schnittstelle_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bemerkung" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCBemerkung" minOccurs="0"/>
 *         &lt;element name="Erzeugung_Zeitstempel" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCErzeugung_Zeitstempel"/>
 *         &lt;element name="Werkzeug_Name" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCWerkzeug_Name"/>
 *         &lt;element name="Werkzeug_Version" type="{http://www.plan-pro.org/modell/PlanPro/1.9.0.2}TCWerkzeug_Version"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPlanPro_Schnittstelle_Allg", propOrder = {
    "bemerkung",
    "erzeugungZeitstempel",
    "werkzeugName",
    "werkzeugVersion"
})
public class CPlanProSchnittstelleAllg {

    @XmlElement(name = "Bemerkung")
    protected TCBemerkung bemerkung;
    @XmlElement(name = "Erzeugung_Zeitstempel", required = true)
    protected TCErzeugungZeitstempel erzeugungZeitstempel;
    @XmlElement(name = "Werkzeug_Name", required = true)
    protected TCWerkzeugName werkzeugName;
    @XmlElement(name = "Werkzeug_Version", required = true)
    protected TCWerkzeugVersion werkzeugVersion;

    /**
     * Ruft den Wert der bemerkung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBemerkung }
     *     
     */
    public TCBemerkung getBemerkung() {
        return bemerkung;
    }

    /**
     * Legt den Wert der bemerkung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBemerkung }
     *     
     */
    public void setBemerkung(TCBemerkung value) {
        this.bemerkung = value;
    }

    /**
     * Ruft den Wert der erzeugungZeitstempel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCErzeugungZeitstempel }
     *     
     */
    public TCErzeugungZeitstempel getErzeugungZeitstempel() {
        return erzeugungZeitstempel;
    }

    /**
     * Legt den Wert der erzeugungZeitstempel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCErzeugungZeitstempel }
     *     
     */
    public void setErzeugungZeitstempel(TCErzeugungZeitstempel value) {
        this.erzeugungZeitstempel = value;
    }

    /**
     * Ruft den Wert der werkzeugName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWerkzeugName }
     *     
     */
    public TCWerkzeugName getWerkzeugName() {
        return werkzeugName;
    }

    /**
     * Legt den Wert der werkzeugName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWerkzeugName }
     *     
     */
    public void setWerkzeugName(TCWerkzeugName value) {
        this.werkzeugName = value;
    }

    /**
     * Ruft den Wert der werkzeugVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCWerkzeugVersion }
     *     
     */
    public TCWerkzeugVersion getWerkzeugVersion() {
        return werkzeugVersion;
    }

    /**
     * Legt den Wert der werkzeugVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCWerkzeugVersion }
     *     
     */
    public void setWerkzeugVersion(TCWerkzeugVersion value) {
        this.werkzeugVersion = value;
    }

}
