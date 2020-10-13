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
 * the tuple of references to the level crossing and its state plus the level of enforcement
 * 
 * <p>Java-Klasse für LevelCrossingAndGivenState complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LevelCrossingAndGivenState">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}AssetAndGivenState">
 *       &lt;sequence>
 *         &lt;element name="relatedLevelCrossingAndState" type="{https://www.railml.org/schemas/3.1}LevelCrossingAndState"/>
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
@XmlType(name = "LevelCrossingAndGivenState", propOrder = {
    "relatedLevelCrossingAndState"
})
public class LevelCrossingAndGivenState
    extends AssetAndGivenState
{

    @XmlElement(required = true)
    protected LevelCrossingAndState relatedLevelCrossingAndState;

    /**
     * Ruft den Wert der relatedLevelCrossingAndState-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LevelCrossingAndState }
     *     
     */
    public LevelCrossingAndState getRelatedLevelCrossingAndState() {
        return relatedLevelCrossingAndState;
    }

    /**
     * Legt den Wert der relatedLevelCrossingAndState-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelCrossingAndState }
     *     
     */
    public void setRelatedLevelCrossingAndState(LevelCrossingAndState value) {
        this.relatedLevelCrossingAndState = value;
    }

}
