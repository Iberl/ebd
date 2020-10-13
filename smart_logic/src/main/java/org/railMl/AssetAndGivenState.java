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
 * Interlocking model often requires a generic track asset to be in a given state. This base class must be extended and contain a reference to a track asset; signal, section, switch, etc. plus the given status of that element. Eg. (switch_18A, left) or (signal S19, proceed).
 * In addition information about the level of state enforcement can be set.
 * 
 * <p>Java-Klasse für AssetAndGivenState complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AssetAndGivenState">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.railml.org/schemas/3.1}EntityIL">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="mustOrShould" type="{https://www.railml.org/schemas/3.1}tMustOrShould" />
 *       &lt;attribute name="proving" type="{https://www.railml.org/schemas/3.1}tProving" />
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
@XmlType(name = "AssetAndGivenState")
@XmlSeeAlso({
    LockAndGivenState.class,
    CrossingAndGivenPosition.class,
    SwitchAndGivenPosition.class,
    SignalAndGivenAspect.class,
    LevelCrossingAndGivenState.class,
    SectionAndGivenVacancy.class,
    DetectorAndGivenState.class,
    DerailerAndGivenPosition.class
})
public abstract class AssetAndGivenState
    extends EntityIL
{

    @XmlAttribute(name = "mustOrShould")
    protected TMustOrShould mustOrShould;
    @XmlAttribute(name = "proving")
    protected TProving proving;
    @XmlAttribute(name = "isNegated")
    protected Boolean isNegated;

    /**
     * Ruft den Wert der mustOrShould-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TMustOrShould }
     *     
     */
    public TMustOrShould getMustOrShould() {
        return mustOrShould;
    }

    /**
     * Legt den Wert der mustOrShould-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TMustOrShould }
     *     
     */
    public void setMustOrShould(TMustOrShould value) {
        this.mustOrShould = value;
    }

    /**
     * Ruft den Wert der proving-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TProving }
     *     
     */
    public TProving getProving() {
        return proving;
    }

    /**
     * Legt den Wert der proving-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TProving }
     *     
     */
    public void setProving(TProving value) {
        this.proving = value;
    }

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
