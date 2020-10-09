//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.fahrstrasse._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CFstr_DWeg_W_Kr_Allg complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CFstr_DWeg_W_Kr_Allg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Element_Flankenschutz" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCElement_Flankenschutz"/>
 *         &lt;element name="Element_Verschluss" type="{http://www.plan-pro.org/modell/Fahrstrasse/1.8.0}TCElement_Verschluss"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFstr_DWeg_W_Kr_Allg", propOrder = {
    "elementFlankenschutz",
    "elementVerschluss"
})
public class CFstrDWegWKrAllg {

    @XmlElement(name = "Element_Flankenschutz", required = true)
    protected TCElementFlankenschutz elementFlankenschutz;
    @XmlElement(name = "Element_Verschluss", required = true)
    protected TCElementVerschluss elementVerschluss;

    /**
     * Ruft den Wert der elementFlankenschutz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCElementFlankenschutz }
     *     
     */
    public TCElementFlankenschutz getElementFlankenschutz() {
        return elementFlankenschutz;
    }

    /**
     * Legt den Wert der elementFlankenschutz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCElementFlankenschutz }
     *     
     */
    public void setElementFlankenschutz(TCElementFlankenschutz value) {
        this.elementFlankenschutz = value;
    }

    /**
     * Ruft den Wert der elementVerschluss-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCElementVerschluss }
     *     
     */
    public TCElementVerschluss getElementVerschluss() {
        return elementVerschluss;
    }

    /**
     * Legt den Wert der elementVerschluss-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCElementVerschluss }
     *     
     */
    public void setElementVerschluss(TCElementVerschluss value) {
        this.elementVerschluss = value;
    }

}
