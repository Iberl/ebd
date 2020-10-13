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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The interlocking extensively uses assets with a state for securing routes. The AssetAndState class is a generic tupel of (Asset, State). These tupels can be used by more than one interlocking system and are therefore not a child of the Interlocking class but of the class NetworkAssets. AssetAndState extends BaseObject in order to inherit an identifier. This base class must be extended and contain a reference to a track asset; signal, section, switch, etc. plus the given status of that element. Eg. (id=xy, switch_18A, left) or (id=yz, signal S19, proceed).
 * 
 * <p>Java-Klasse für AssetAndState complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AssetAndState">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="isNegated" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssetAndState")
@XmlSeeAlso({
    LockAndState.class,
    LevelCrossingAndState.class,
    DetectorAndState.class,
    SectionAndVacancy.class,
    DerailerAndPosition.class,
    SwitchAndPosition.class,
    CrossingAndPosition.class,
    SignalAndAspect.class
})
public abstract class AssetAndState
    extends EntityIL
{

    @XmlAttribute(name = "isNegated")
    protected Boolean isNegated;

    /**
     * Ruft den Wert der isNegated-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsNegated() {
        return isNegated;
    }

    /**
     * Legt den Wert der isNegated-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNegated(Boolean value) {
        this.isNegated = value;
    }

}
