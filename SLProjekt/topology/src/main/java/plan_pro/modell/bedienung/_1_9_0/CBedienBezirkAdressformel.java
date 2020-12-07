//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CBedien_Bezirk_Adressformel complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CBedien_Bezirk_Adressformel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="A_Wert" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCA_Wert"/>
 *         &lt;element name="B_Wert" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCB_Wert"/>
 *         &lt;element name="C_Wert" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCC_Wert"/>
 *         &lt;element name="DD_Wert" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCDD_Wert"/>
 *         &lt;element name="X_Wert" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCX_Wert"/>
 *         &lt;element name="Y_Wert" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCY_Wert"/>
 *         &lt;element name="YY_Wert" type="{http://www.plan-pro.org/modell/Bedienung/1.9.0.2}TCYY_Wert"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CBedien_Bezirk_Adressformel", propOrder = {
    "aWert",
    "bWert",
    "cWert",
    "ddWert",
    "xWert",
    "yWert",
    "yyWert"
})
public class CBedienBezirkAdressformel {

    @XmlElement(name = "A_Wert", required = true)
    protected TCAWert aWert;
    @XmlElement(name = "B_Wert", required = true)
    protected TCBWert bWert;
    @XmlElement(name = "C_Wert", required = true)
    protected TCCWert cWert;
    @XmlElement(name = "DD_Wert", required = true)
    protected TCDDWert ddWert;
    @XmlElement(name = "X_Wert", required = true)
    protected TCXWert xWert;
    @XmlElement(name = "Y_Wert", required = true)
    protected TCYWert yWert;
    @XmlElement(name = "YY_Wert", required = true)
    protected TCYYWert yyWert;

    /**
     * Ruft den Wert der aWert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCAWert }
     *     
     */
    public TCAWert getAWert() {
        return aWert;
    }

    /**
     * Legt den Wert der aWert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAWert }
     *     
     */
    public void setAWert(TCAWert value) {
        this.aWert = value;
    }

    /**
     * Ruft den Wert der bWert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCBWert }
     *     
     */
    public TCBWert getBWert() {
        return bWert;
    }

    /**
     * Legt den Wert der bWert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBWert }
     *     
     */
    public void setBWert(TCBWert value) {
        this.bWert = value;
    }

    /**
     * Ruft den Wert der cWert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCCWert }
     *     
     */
    public TCCWert getCWert() {
        return cWert;
    }

    /**
     * Legt den Wert der cWert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCCWert }
     *     
     */
    public void setCWert(TCCWert value) {
        this.cWert = value;
    }

    /**
     * Ruft den Wert der ddWert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCDDWert }
     *     
     */
    public TCDDWert getDDWert() {
        return ddWert;
    }

    /**
     * Legt den Wert der ddWert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDDWert }
     *     
     */
    public void setDDWert(TCDDWert value) {
        this.ddWert = value;
    }

    /**
     * Ruft den Wert der xWert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCXWert }
     *     
     */
    public TCXWert getXWert() {
        return xWert;
    }

    /**
     * Legt den Wert der xWert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCXWert }
     *     
     */
    public void setXWert(TCXWert value) {
        this.xWert = value;
    }

    /**
     * Ruft den Wert der yWert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCYWert }
     *     
     */
    public TCYWert getYWert() {
        return yWert;
    }

    /**
     * Legt den Wert der yWert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCYWert }
     *     
     */
    public void setYWert(TCYWert value) {
        this.yWert = value;
    }

    /**
     * Ruft den Wert der yyWert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCYYWert }
     *     
     */
    public TCYYWert getYYWert() {
        return yyWert;
    }

    /**
     * Legt den Wert der yyWert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCYYWert }
     *     
     */
    public void setYYWert(TCYYWert value) {
        this.yyWert = value;
    }

}
