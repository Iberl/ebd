//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r SignalCatenary complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalCatenary">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}SignalX">
 *       &lt;sequence>
 *         &lt;element name="refersToElectrificationSection" type="{https://www.railml.org/schemas/3.1}tElementWithIDref" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{https://www.railml.org/schemas/3.1}tSignalCatenaryType" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignalCatenary", propOrder = {
    "refersToElectrificationSection"
})
public class SignalCatenary
    extends SignalX
{

    protected TElementWithIDref refersToElectrificationSection;
    @XmlAttribute(name = "type")
    protected TSignalCatenaryType type;

    /**
     * Ruft den Wert der refersToElectrificationSection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TElementWithIDref }
     *     
     */
    public TElementWithIDref getRefersToElectrificationSection() {
        return refersToElectrificationSection;
    }

    /**
     * Legt den Wert der refersToElectrificationSection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TElementWithIDref }
     *     
     */
    public void setRefersToElectrificationSection(TElementWithIDref value) {
        this.refersToElectrificationSection = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TSignalCatenaryType }
     *     
     */
    public TSignalCatenaryType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TSignalCatenaryType }
     *     
     */
    public void setType(TSignalCatenaryType value) {
        this.type = value;
    }

}