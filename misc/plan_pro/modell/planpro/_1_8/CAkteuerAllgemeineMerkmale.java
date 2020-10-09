//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.planpro._1_8;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r CAkteuer_Allgemeine_Merkmale complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CAkteuer_Allgemeine_Merkmale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCName"/>
 *         &lt;element name="Name_10" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCName_10"/>
 *         &lt;element name="Name_5" type="{http://www.plan-pro.org/modell/PlanPro/1.8.0}TCName_5"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAkteuer_Allgemeine_Merkmale", propOrder = {
    "name",
    "name10",
    "name5"
})
public class CAkteuerAllgemeineMerkmale {

    @XmlElement(name = "Name", required = true)
    protected TCName name;
    @XmlElement(name = "Name_10", required = true)
    protected TCName10 name10;
    @XmlElement(name = "Name_5", required = true)
    protected TCName5 name5;

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCName }
     *     
     */
    public TCName getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCName }
     *     
     */
    public void setName(TCName value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der name10-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCName10 }
     *     
     */
    public TCName10 getName10() {
        return name10;
    }

    /**
     * Legt den Wert der name10-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCName10 }
     *     
     */
    public void setName10(TCName10 value) {
        this.name10 = value;
    }

    /**
     * Ruft den Wert der name5-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TCName5 }
     *     
     */
    public TCName5 getName5() {
        return name5;
    }

    /**
     * Legt den Wert der name5-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCName5 }
     *     
     */
    public void setName5(TCName5 value) {
        this.name5 = value;
    }

}
