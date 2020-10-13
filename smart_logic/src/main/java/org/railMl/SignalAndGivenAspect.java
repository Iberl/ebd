//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * the tuple of references to the signal and its aspect plus the level of enforcement
 * 
 * <p>Java-Klasse für SignalAndGivenAspect complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SignalAndGivenAspect">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}AssetAndGivenState">
 *       &lt;sequence>
 *         &lt;element name="relatedSignalAndAspect" type="{https://www.railml.org/schemas/3.1}SignalAndAspect"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignalAndGivenAspect", propOrder = {
    "relatedSignalAndAspect"
})
public class SignalAndGivenAspect
    extends AssetAndGivenState
{

    @XmlElement(required = true)
    protected SignalAndAspect relatedSignalAndAspect;

    /**
     * Ruft den Wert der relatedSignalAndAspect-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SignalAndAspect }
     *     
     */
    public SignalAndAspect getRelatedSignalAndAspect() {
        return relatedSignalAndAspect;
    }

    /**
     * Legt den Wert der relatedSignalAndAspect-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalAndAspect }
     *     
     */
    public void setRelatedSignalAndAspect(SignalAndAspect value) {
        this.relatedSignalAndAspect = value;
    }

}
