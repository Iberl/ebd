//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SpeedProfileTrainType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpeedProfileTrainType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="etcsTrainCategoryNumber" type="{https://www.railml.org/schemas/3.1}tEtcsTrainCategoryNumber" />
 *       &lt;attribute name="type" type="{https://www.railml.org/schemas/3.1}tTrainType" />
 *       &lt;attribute name="cantDeficiency" type="{https://www.railml.org/schemas/3.1}tCantDeficiency" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeedProfileTrainType")
public class SpeedProfileTrainType {

    @XmlAttribute(name = "etcsTrainCategoryNumber")
    protected Integer etcsTrainCategoryNumber;
    @XmlAttribute(name = "type")
    protected TTrainType type;
    @XmlAttribute(name = "cantDeficiency")
    protected Integer cantDeficiency;

    /**
     * Ruft den Wert der etcsTrainCategoryNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEtcsTrainCategoryNumber() {
        return etcsTrainCategoryNumber;
    }

    /**
     * Legt den Wert der etcsTrainCategoryNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEtcsTrainCategoryNumber(Integer value) {
        this.etcsTrainCategoryNumber = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TTrainType }
     *     
     */
    public TTrainType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TTrainType }
     *     
     */
    public void setType(TTrainType value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der cantDeficiency-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantDeficiency() {
        return cantDeficiency;
    }

    /**
     * Legt den Wert der cantDeficiency-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantDeficiency(Integer value) {
        this.cantDeficiency = value;
    }

}
