//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * the tuple of references to the derailer and its position plus the level of enforcement
 * 
 * <p>Java-Klasse f�r DerailerAndGivenPosition complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DerailerAndGivenPosition">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}AssetAndGivenState">
 *       &lt;sequence>
 *         &lt;element name="relatedDerailerAndPosition" type="{https://www.railml.org/schemas/3.1}DerailerAndPosition"/>
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
@XmlType(name = "DerailerAndGivenPosition", propOrder = {
    "relatedDerailerAndPosition"
})
public class DerailerAndGivenPosition
    extends AssetAndGivenState
{

    @XmlElement(required = true)
    protected DerailerAndPosition relatedDerailerAndPosition;

    /**
     * Ruft den Wert der relatedDerailerAndPosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DerailerAndPosition }
     *     
     */
    public DerailerAndPosition getRelatedDerailerAndPosition() {
        return relatedDerailerAndPosition;
    }

    /**
     * Legt den Wert der relatedDerailerAndPosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DerailerAndPosition }
     *     
     */
    public void setRelatedDerailerAndPosition(DerailerAndPosition value) {
        this.relatedDerailerAndPosition = value;
    }

}
