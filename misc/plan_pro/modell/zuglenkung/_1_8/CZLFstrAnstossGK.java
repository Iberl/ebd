//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zuglenkung._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CZL_Fstr_Anstoss_GK complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CZL_Fstr_Anstoss_GK">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GK" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCGK"/>
 *         &lt;element name="Tv_GK" type="{http://www.plan-pro.org/modell/Zuglenkung/1.8.0}TCTv_GK"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CZL_Fstr_Anstoss_GK", propOrder = {
    "gk",
    "tvGK"
})
public class CZLFstrAnstossGK {

    @XmlElement(name = "GK", required = true)
    protected TCGK gk;
    @XmlElement(name = "Tv_GK", required = true)
    protected TCTvGK tvGK;

    /**
     * Ruft den Wert der gk-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCGK }
     *     
     */
    public TCGK getGK() {
        return gk;
    }

    /**
     * Legt den Wert der gk-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCGK }
     *     
     */
    public void setGK(TCGK value) {
        this.gk = value;
    }

    /**
     * Ruft den Wert der tvGK-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCTvGK }
     *     
     */
    public TCTvGK getTvGK() {
        return tvGK;
    }

    /**
     * Legt den Wert der tvGK-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTvGK }
     *     
     */
    public void setTvGK(TCTvGK value) {
        this.tvGK = value;
    }

}
