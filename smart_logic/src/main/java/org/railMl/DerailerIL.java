//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The derailer or trap switch is an infrastructure element that either allows or disallows train passage. A derailer typically operates on one rail only; trap switch (points) have similar effect using both rails to literally derail the train for protection purpose. 
 * Derailers that are locally and manually controlled are obviously not within the scope of an interlocking as the dispatcher will typically prevent trains from derailing by blocking signals leading towards such a device
 * 
 * <p>Java-Klasse für DerailerIL complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DerailerIL">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}MovableElement">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="preferredPosition" type="{https://www.railml.org/schemas/3.1}tDerailingPosition" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DerailerIL")
public class DerailerIL
    extends MovableElement
{

    @XmlAttribute(name = "preferredPosition")
    protected TDerailingPosition preferredPosition;

    /**
     * Ruft den Wert der preferredPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TDerailingPosition }
     *     
     */
    public TDerailingPosition getPreferredPosition() {
        return preferredPosition;
    }

    /**
     * Legt den Wert der preferredPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TDerailingPosition }
     *     
     */
    public void setPreferredPosition(TDerailingPosition value) {
        this.preferredPosition = value;
    }

}
