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
 * <p>Java-Klasse f�r CZN_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZN_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Einwahlstelle" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCEinwahlstelle"/>
 *         &lt;element name="Reaktivierungsfunktion" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCReaktivierungsfunktion"/>
 *         &lt;element name="ZN_Anlagentyp" type="{http://www.plan-pro.org/modell/Zugnummernmeldeanlage/1.9.0.2}TCZN_Anlagentyp"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZN_Allg", propOrder = {
    "einwahlstelle",
    "reaktivierungsfunktion",
    "znAnlagentyp"
})
public class CZNAllg {

    @XmlElement(name = "Einwahlstelle", required = true)
    protected TCEinwahlstelle einwahlstelle;
    @XmlElement(name = "Reaktivierungsfunktion", required = true)
    protected TCReaktivierungsfunktion reaktivierungsfunktion;
    @XmlElement(name = "ZN_Anlagentyp", required = true)
    protected TCZNAnlagentyp znAnlagentyp;

    /**
     * Ruft den Wert der einwahlstelle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCEinwahlstelle }
     *     
     */
    public TCEinwahlstelle getEinwahlstelle() {
        return einwahlstelle;
    }

    /**
     * Legt den Wert der einwahlstelle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEinwahlstelle }
     *     
     */
    public void setEinwahlstelle(TCEinwahlstelle value) {
        this.einwahlstelle = value;
    }

    /**
     * Ruft den Wert der reaktivierungsfunktion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCReaktivierungsfunktion }
     *     
     */
    public TCReaktivierungsfunktion getReaktivierungsfunktion() {
        return reaktivierungsfunktion;
    }

    /**
     * Legt den Wert der reaktivierungsfunktion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCReaktivierungsfunktion }
     *     
     */
    public void setReaktivierungsfunktion(TCReaktivierungsfunktion value) {
        this.reaktivierungsfunktion = value;
    }

    /**
     * Ruft den Wert der znAnlagentyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCZNAnlagentyp }
     *     
     */
    public TCZNAnlagentyp getZNAnlagentyp() {
        return znAnlagentyp;
    }

    /**
     * Legt den Wert der znAnlagentyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCZNAnlagentyp }
     *     
     */
    public void setZNAnlagentyp(TCZNAnlagentyp value) {
        this.znAnlagentyp = value;
    }

}
